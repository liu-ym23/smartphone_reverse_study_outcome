package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0 {
    public static boolean a;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.n0$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0114a implements DialogInterface.OnClickListener {
            public static final DialogInterfaceOnClickListenerC0114a a = null;

            static {
                a = new DialogInterfaceOnClickListenerC0114a();
            }

            public DialogInterfaceOnClickListenerC0114a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public a(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(this.a);     // Catch: Throwable -> L4
            r0.h(this.b);     // Catch: Throwable -> L4
            r0.a(2131391777, 2131890915, DialogInterfaceOnClickListenerC0114a.a);     // Catch: Throwable -> L4
            r0.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "errorResult");
        Log.i("MessageUtils", "handleMessageDecryptFailedIfNeed, errorCode: " + r2.getErrorCode());
        Context r0 = ImSdk.a.getContext();
        switch(r2.getErrorCode()) {
            case 311100: goto L6;
            case 311101: goto L4;
            case 311102: goto L6;
            case 311103: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        String r3 = r2.getDisplayMsg();
        if (TextUtils.isEmpty(r3) == false) goto L9;
        r3 = UIUtils.getString(r0, 2131890916);
    L9:
        UICallbackExecutor.execute(new a(r0, r3));
        return true;
    }
}
