package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultEmojiCompatConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigFactory {

        @NonNull
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";

        @NonNull
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";

        @NonNull
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper r5) {
            if (r5 != null) goto L6;
            r5 = getHelperForApi();
        L6:
            this.mHelper = r5;
        }

        @Nullable
        private EmojiCompat.Config configOrNull(@NonNull Context r5, @Nullable FontRequest r10) {
            if (r10 != null) goto L6;
            return null;
        L6:
            return new FontRequestEmojiCompatConfig(r5, r10);
        }

        @NonNull
        private List<List<byte[]>> convertToByteArray(@NonNull Signature[] r5) {
            ArrayList r10 = new ArrayList();
            int r11 = r5.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L6;
            r10.add(r5[r12].toByteArray());
            r12 = r12 + 1;
            goto L3
        L6:
            return Collections.singletonList(r10);
        }

        @NonNull
        private FontRequest generateFontRequestFrom(@NonNull ProviderInfo r5, @NonNull PackageManager r10) throws PackageManager.NameNotFoundException {
            String r11 = r5.authority;
            String r12 = r5.packageName;
            return new FontRequest(r11, r12, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r10, r12)));
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            return new DefaultEmojiCompatConfigHelper_API28();
        }

        private boolean hasFlagSystem(@Nullable ProviderInfo r5) {
            if (r5 == null) goto L8;
            ApplicationInfo r10 = r5.applicationInfo;
            if (r10 == null) goto L8;
            if ((r10.flags & 1) != 1) goto L8;
            return true;
        L8:
            return false;
        }

        @Nullable
        private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager r5) {
            Iterator<ResolveInfo> r10 = this.mHelper.queryIntentContentProviders(r5, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            ResolveInfo r11 = r10.next();
            ProviderInfo r12 = this.mHelper.getProviderInfo(r11);
            if (hasFlagSystem(r12) == false) goto L4;
            return r12;
        L8:
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config create(@NonNull Context r5) {
            return configOrNull(r5, queryForDefaultFontRequest(r5));
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @VisibleForTesting
        public FontRequest queryForDefaultFontRequest(@NonNull Context r5) {
            PackageManager r10 = r5.getPackageManager();
            Preconditions.checkNotNull(r10, "Package manager required to locate emoji font provider");
            ProviderInfo r11 = queryDefaultInstalledContentProvider(r10);
            if (r11 != null) goto L10;
            return null;
        L10:
            return generateFontRequestFrom(r11, r10);
        L7:
            e = move-exception;
            Log.wtf(TAG, e);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
        }

        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r5) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r5, @NonNull String r10) throws PackageManager.NameNotFoundException {
            return r5.getPackageInfo(r10, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r5, @NonNull Intent r10, int r11) {
            return Collections.emptyList();
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper_API19() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r5) {
            return r5.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r5, @NonNull Intent r10, int r11) {
            return r5.queryIntentContentProviders(r10, r11);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r5, @NonNull String r10) throws PackageManager.NameNotFoundException {
            return r5.getPackageInfo(r10, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context r5) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(r5);
    }
}
