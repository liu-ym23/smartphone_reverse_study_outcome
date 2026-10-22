package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastAlertModal")
public final class gb extends com.bytedance.ies.web.jsbridge2.f<b, c> {
    public com.bytedance.android.livesdk.chatroom.ui.c9 a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/gb$b;", "", "", "base64Img", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setBase64Img", "(Ljava/lang/String;)V", "title", "e", "setTitle", "message", "d", "setMessage", "confirmText", "c", "setConfirmText", "cancelText", "b", "setCancelText", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("img")
        private String base64Img;

        @SerializedName("cancelText")
        private String cancelText;

        @SerializedName("confirmText")
        private String confirmText;

        @SerializedName("message")
        private String message;

        @SerializedName("title")
        private String title;

        public b() {
        }

        public final String a() {
            return this.base64Img;
        }

        public final String b() {
            return this.cancelText;
        }

        public final String c() {
            return this.confirmText;
        }

        public final String d() {
            return this.message;
        }

        public final String e() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/gb$c;", "", "", "click", "Ljava/lang/String;", "getClick", "()Ljava/lang/String;", "setClick", "(Ljava/lang/String;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("clicked")
        private String click;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.click = r2;
        }
    }

    static {
    }

    public final void onTerminate() {
        com.bytedance.android.livesdk.chatroom.ui.c9 r0 = this.a;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.a = null;
    }

    public gb() {
    }

    public final void invoke(Object r7, CallContext r8) {
        b r9 = (b) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (TextUtils.isEmpty(r9.c()) == false) goto L5;
        int r0 = 1;
    L6:
        Context r2 = r8.getContext();
        com.bytedance.android.livesdk.chatroom.ui.c9.b r3 = new com.bytedance.android.livesdk.chatroom.ui.c9.b();
        r3.a = r2;
        r3.b = r0;
        r3.c = 2131565735;
        r3.p = false;
        if (TextUtils.isEmpty(r9.a()) == false) goto L43;
        r3.d = com.bytedance.android.live.core.utils.s1.m(2131251277);
    L13:
        if (TextUtils.isEmpty(r9.e()) == true) goto L16;
        r3.e = r9.e();
    L16:
        if (TextUtils.isEmpty(r9.d()) == true) goto L19;
        r3.f = r9.d();
    L19:
        if (r0 != 1) goto L26;
        if (TextUtils.isEmpty(r9.b()) == false) goto L23;
        String r11 = com.bytedance.android.live.core.utils.s1.B(2131915442);
    L24:
        hb r12 = new hb(this);
        r3.h = r11;
        r3.i = r12;
    L34:
        com.bytedance.android.livesdk.chatroom.ui.c9 r13 = new com.bytedance.android.livesdk.chatroom.ui.c9(r3.a, r3);
        this.a = r13;
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L38:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    L23:
        r11 = r9.b();
        goto L24
    L26:
        if (TextUtils.isEmpty(r9.b()) == false) goto L28;
        String r14 = com.bytedance.android.live.core.utils.s1.B(2131915442);
    L29:
        ib r1 = new ib(this);
        r3.j = r14;
        r3.k = r1;
        if (TextUtils.isEmpty(r9.c()) == false) goto L32;
        String r15 = com.bytedance.android.live.core.utils.s1.B(2131920806);
    L33:
        jb r16 = new jb(this);
        r3.l = r15;
        r3.m = r16;
        r3.s = 2131954724;
        goto L34
    L32:
        r15 = r9.c();
        goto L33
    L28:
        r14 = r9.b();
        goto L29
    L43:
        byte[] r4 = Base64.decode(r9.a(), 0);     // Catch: Exception -> L10
        Bitmap r5 = BitmapFactory.decodeByteArray(r4, 0, r4.length);     // Catch: Exception -> L10
        r3.d = new BitmapDrawable(r8.getContext().getResources(), r5);     // Catch: Exception -> L10
    L10:
        r3.d = null;
        goto L13
    L5:
        r0 = 2;
        goto L6
    }
}
