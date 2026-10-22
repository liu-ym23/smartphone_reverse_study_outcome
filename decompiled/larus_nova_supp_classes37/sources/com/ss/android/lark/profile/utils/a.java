package com.ss.android.lark.profile.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final Context r9, final String r10, final Serializable r11) {
        final Fragment r5 = null;
        final String r3 = null;
        final String r4 = null;
        final boolean r7 = false;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "contactSource");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isMempopeApp() == false) goto L6;
        Log.i("ProfileJumpUtilsExport", "profile is disabled in mempope");
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L8;
    L10:
        Log.i("ProfileJumpUtilsExport", "open profile by router");
        UICallbackExecutor.execute(new ProfileJumpUtilsExport$openUserProfile$1(r10, r11, r3, r4, r5, r9, r7));
        return;
    L8:
        if (TextUtils.isEmpty(null) == false) goto L10;
        Log.e("ProfileJumpUtilsExport", "userId and Token are null");
    }
}
