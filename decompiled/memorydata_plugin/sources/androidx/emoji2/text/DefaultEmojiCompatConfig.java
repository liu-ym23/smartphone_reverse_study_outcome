package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigFactory {
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper r1) {
            if (r1 != null) goto L6;
            r1 = getHelperForApi();
        L6:
            this.mHelper = r1;
        }

        private EmojiCompat.Config configOrNull(Context r2, FontRequest r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L7;
            return null;
        L7:
            return new FontRequestEmojiCompatConfig(r1, r3);
        }

        private List<List<byte[]>> convertToByteArray(Signature[] r4) {
            ArrayList r3 = new ArrayList();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            r3.add(r4[r1].toByteArray());
            r1 = r1 + 1;
            goto L3
        L6:
            return Collections.singletonList(r3);
        }

        private FontRequest generateFontRequestFrom(ProviderInfo r3, PackageManager r4) {
            String r0 = r3.authority;
            String r5 = r3.packageName;
            return new FontRequest(r0, r5, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r4, r5)));
        }

        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if (Build.VERSION.SDK_INT < 28) goto L7;
            return new DefaultEmojiCompatConfigHelper_API28();
        L7:
            if (Build.VERSION.SDK_INT < 19) goto L11;
            return new DefaultEmojiCompatConfigHelper_API19();
        L11:
            return new DefaultEmojiCompatConfigHelper();
        }

        private boolean hasFlagSystem(ProviderInfo r2) {
            if (r2 != null) goto L5;
        L9:
            return false;
        L5:
            if (r2.applicationInfo == null) goto L9;
            if ((r2.applicationInfo.flags & 1) != 1) goto L9;
            return true;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager r4) {
            Iterator<ResolveInfo> r5 = this.mHelper.queryIntentContentProviders(r4, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            ResolveInfo r0 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r5.next(), ResolveInfo.class, "com.obric.memorydata.plugin");
            ProviderInfo r1 = this.mHelper.getProviderInfo(r0);
            if (hasFlagSystem(r1) == false) goto L4;
            return r1;
        L8:
            return null;
        }

        public EmojiCompat.Config create(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            return configOrNull(r4, queryForDefaultFontRequest(r4));
        }

        FontRequest queryForDefaultFontRequest(Context r3) {
            PackageManager r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getPackageManager();
            Preconditions.checkNotNull(r4, "Package manager required to locate emoji font provider");
            ProviderInfo r0 = queryDefaultInstalledContentProvider(r4);
            if (r0 != null) goto L10;
            return null;
        L10:
            return generateFontRequestFrom(r0, r4);
        L7:
            e = move-exception;
            Log.wtf(TAG, e);
            return null;
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
        }

        public ProviderInfo getProviderInfo(ResolveInfo r1) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] getSigningSignatures(PackageManager r1, String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager r1, Intent r2, int r3) {
            return Collections.emptyList();
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper_API19() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public ProviderInfo getProviderInfo(ResolveInfo r1) {
            return r1.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public List<ResolveInfo> queryIntentContentProviders(PackageManager r1, Intent r2, int r3) {
            return r1.queryIntentContentProviders(r2, r3);
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public Signature[] getSigningSignatures(PackageManager r1, String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig create(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return (FontRequestEmojiCompatConfig) ZeusTransformUtils.preCheckCast(new DefaultEmojiCompatConfigFactory(null).create(r4), FontRequestEmojiCompatConfig.class, "com.obric.memorydata.plugin");
    }
}
