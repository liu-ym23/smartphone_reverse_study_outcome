package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardPhotoModule {
    public static final Lazy a = null;

    public interface a {
        int getFileUploadAuthorizatedDenyCode();

        int getFileUploadAuthorizatedDenyCodeByFilePolicy();

        int getUnifiedStorageLimitErrorCode();

        boolean isHitStorageQuotaLimit(int r1);

        void onAuthorizatedDeny(Context r1, String r2);

        boolean showQuotaLimitDialog(Activity r1, int r2);

        void showUnifiedStorageLimitCTADialog(Activity r1);
    }

    static {
        a = LazyKt.lazy(KeyboardPhotoModule$dependency$2.INSTANCE);
    }

    public static final a a() {
        return (a) a.getValue();
    }
}
