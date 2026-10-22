package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
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
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper r10) {
            if (r10 != null) goto L6;
            r10 = getHelperForApi();
        L6:
            this.mHelper = r10;
        }

        @Nullable
        private EmojiCompat.Config configOrNull(@NonNull Context r10, @Nullable FontRequest r11) {
            if (r11 != null) goto L6;
            return null;
        L6:
            return new FontRequestEmojiCompatConfig(r10, r11);
        }

        @NonNull
        private List<List<byte[]>> convertToByteArray(@NonNull Signature[] r10) {
            ArrayList r11 = new ArrayList();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.add(r10[r13].toByteArray());
            r13 = r13 + 1;
            goto L3
        L6:
            return Collections.singletonList(r11);
        }

        @NonNull
        private FontRequest generateFontRequestFrom(@NonNull ProviderInfo r10, @NonNull PackageManager r11) {
            String r12 = r10.authority;
            String r13 = r10.packageName;
            return new FontRequest(r12, r13, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r11, r13)));
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 28) goto L7;
            return new DefaultEmojiCompatConfigHelper_API28();
        L7:
            if (r10 < 19) goto L11;
            return new DefaultEmojiCompatConfigHelper_API19();
        L11:
            return new DefaultEmojiCompatConfigHelper();
        }

        private boolean hasFlagSystem(@Nullable ProviderInfo r10) {
            if (r10 == null) goto L9;
            ApplicationInfo r11 = r10.applicationInfo;
            if (r11 == null) goto L9;
            if ((r11.flags & 1) != 1) goto L9;
            return true;
        L9:
            return false;
        }

        @Nullable
        private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager r10) {
            Iterator<ResolveInfo> r11 = this.mHelper.queryIntentContentProviders(r10, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            ResolveInfo r12 = r11.next();
            ProviderInfo r13 = this.mHelper.getProviderInfo(r12);
            if (hasFlagSystem(r13) == false) goto L4;
            return r13;
        L8:
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config create(@NonNull Context r10) {
            return configOrNull(r10, queryForDefaultFontRequest(r10));
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @VisibleForTesting
        FontRequest queryForDefaultFontRequest(@NonNull Context r10) {
            PackageManager r11 = r10.getPackageManager();
            Preconditions.checkNotNull(r11, "Package manager required to locate emoji font provider");
            ProviderInfo r12 = queryDefaultInstalledContentProvider(r11);
            if (r12 != null) goto L10;
            return null;
        L10:
            return generateFontRequestFrom(r12, r11);
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
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r10) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r10, @NonNull String r11) {
            return r10.getPackageInfo(r11, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r10, @NonNull Intent r11, int r12) {
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
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r10) {
            return r10.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r10, @NonNull Intent r11, int r12) {
            return r10.queryIntentContentProviders(r11, r12);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r10, @NonNull String r11) {
            return r10.getPackageInfo(r11, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context r10) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(r10);
    }
}
