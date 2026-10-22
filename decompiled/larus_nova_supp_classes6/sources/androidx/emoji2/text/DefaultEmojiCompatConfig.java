package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigFactory {
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if (Build.VERSION.SDK_INT < 28) goto L7;
            return new DefaultEmojiCompatConfigHelper_API28();
        L7:
            return new DefaultEmojiCompatConfigHelper_API19();
        }

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper r1) {
            if (r1 != null) goto L6;
            r1 = getHelperForApi();
        L6:
            this.mHelper = r1;
        }

        private List<List<byte[]>> convertToByteArray(Signature[] r5) {
            ArrayList r0 = new ArrayList();
            int r1 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.add(r5[r2].toByteArray());
            r2 = r2 + 1;
            goto L3
        L6:
            return Collections.singletonList(r0);
        }

        private boolean hasFlagSystem(ProviderInfo r2) {
            if (r2 == null) goto L8;
            ApplicationInfo r3 = r2.applicationInfo;
            if (r3 == null) goto L8;
            if ((r3.flags & 1) != 1) goto L8;
            return true;
        L8:
            return false;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager r4) {
            Iterator<ResolveInfo> r5 = this.mHelper.queryIntentContentProviders(r4, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            ResolveInfo r0 = r5.next();
            ProviderInfo r1 = this.mHelper.getProviderInfo(r0);
            if (hasFlagSystem(r1) == false) goto L4;
            return r1;
        L8:
            return null;
        }

        public EmojiCompat.Config create(Context r2) {
            return configOrNull(r2, queryForDefaultFontRequest(r2));
        }

        public FontRequest queryForDefaultFontRequest(Context r3) {
            PackageManager r4 = r3.getPackageManager();
            Preconditions.checkNotNull(r4, "Package manager required to locate emoji font provider");
            ProviderInfo r0 = queryDefaultInstalledContentProvider(r4);
            if (r0 != null) goto L8;
            return null;
        L8:
            return generateFontRequestFrom(r0, r4);
        L7:
            return null;
        }

        private EmojiCompat.Config configOrNull(Context r2, FontRequest r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            return new FontRequestEmojiCompatConfig(r2, r3);
        }

        private FontRequest generateFontRequestFrom(ProviderInfo r4, PackageManager r5) throws PackageManager.NameNotFoundException {
            String r0 = r4.authority;
            String r6 = r4.packageName;
            return new FontRequest(r0, r6, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r5, r6)));
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
        }

        public ProviderInfo getProviderInfo(ResolveInfo r2) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] getSigningSignatures(PackageManager r2, String r3) throws PackageManager.NameNotFoundException {
            return r2.getPackageInfo(r3, 64).signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager r1, Intent r2, int r3) {
            return Collections.emptyList();
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig create(Context r2) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(r2);
    }
}
