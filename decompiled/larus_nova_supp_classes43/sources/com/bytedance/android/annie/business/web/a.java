package com.bytedance.android.annie.business.web;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import b36.m;
import com.bytedance.ies.bullet.secure.WebViewPermissionKeva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnnieXLiveWebChromeClient a;
    public final /* synthetic */ AppCompatActivity b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ List<String> d;
    public final /* synthetic */ b36.b e;
    public final /* synthetic */ List<String> f;

    /* JADX INFO: renamed from: com.bytedance.android.annie.business.web.a$a, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC0066a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ List<String> b;
        public final /* synthetic */ b36.b c;
        public final /* synthetic */ AnnieXLiveWebChromeClient d;
        public final /* synthetic */ AppCompatActivity e;
        public final /* synthetic */ List<String> f;

        public DialogInterfaceOnClickListenerC0066a(Uri r1, List<String> r10, b36.b r11, AnnieXLiveWebChromeClient r12, AppCompatActivity r13, List<String> r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            if (r11 != (-3)) goto L5;
            Lazy r12 = WebViewPermissionKeva.a;
            WebViewPermissionKeva.d(this.a, this.b, true, true);
            AnnieXLiveWebChromeClient r13 = this.d;
            AppCompatActivity r0 = this.e;
            List<String> r1 = this.f;
            b36.b r14 = this.c;
            int r15 = AnnieXLiveWebChromeClient.h;
            r13.getClass();
            AnnieXLiveWebChromeClient.g(r0, r1, r14);
        L12:
            r10.dismiss();
            return;
        L5:
            if (r11 != (-2)) goto L7;
            Lazy r16 = WebViewPermissionKeva.a;
            WebViewPermissionKeva.d(this.a, this.b, false, false);
            this.c.a();
            goto L12
        L7:
            if (r11 != (-1)) goto L12;
            Lazy r17 = WebViewPermissionKeva.a;
            WebViewPermissionKeva.d(this.a, this.b, true, false);
            AnnieXLiveWebChromeClient r18 = this.d;
            AppCompatActivity r19 = this.e;
            List<String> r20 = this.f;
            b36.b r21 = this.c;
            int r22 = AnnieXLiveWebChromeClient.h;
            r18.getClass();
            AnnieXLiveWebChromeClient.g(r19, r20, r21);
            goto L12
        }
    }

    public a(AnnieXLiveWebChromeClient r1, AppCompatActivity r10, Uri r11, List r12, m r13, List r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final void a() {
        WeakReference<AlertDialog> r0 = this.a.f;
        if (r0 == null) goto L28;
        AlertDialog r1 = r0.get();
        if (r1 == null) goto L28;
        if (r1.isShowing() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L28;
        Handler r10 = DialogLancet.resolveDialogHandler(r1);
        if (r10 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r1);
        goto L28
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r11 == null) goto L25;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L14:
        if (Looper.myLooper() == r10.getLooper()) goto L16;
        r10.post(DialogLancet.createDismissRunnable(r1));
    L28:
        AlertDialog.Builder r12 = new AlertDialog.Builder(this.b);
        AnnieXLiveWebChromeClient r13 = this.a;
        Uri r14 = this.c;
        List<String> r15 = this.d;
        r13.getClass();
        String r16 = r14.toString();
        if (r15.size() != 1) goto L34;
        if (r15.contains("android.webkit.resource.AUDIO_CAPTURE") == false) goto L34;
        Pair r17 = new Pair("麦克风授权", "是否允许 " + r16 + " 访问你当前设备的麦克风?");
    L39:
        String r18 = (String) r17.component1();
        String r19 = (String) r17.component2();
        r12.setTitle(r18);
        r12.setMessage(r19);
        DialogInterfaceOnClickListenerC0066a r20 = new DialogInterfaceOnClickListenerC0066a(this.c, this.d, this.e, this.a, this.b, this.f);
        r12.setNegativeButton(2131912928, r20);
        r12.setPositiveButton(2131912927, r20);
        r12.setNeutralButton(2131912929, r20);
        r12.setCancelable(false);
        this.a.f = new WeakReference(r12.show());
        return;
    L34:
        if (r15.size() == 1) goto L36;
    L38:
        r17 = new Pair("麦克风和摄像头授权", "是否允许 " + r16 + " 访问你当前设备的摄像头和麦克风?");
        goto L39
    L36:
        if (r15.contains("android.webkit.resource.VIDEO_CAPTURE") == false) goto L38;
        r17 = new Pair("摄像头授权", "是否允许 " + r16 + " 访问你当前设备的摄像头?");
        goto L39
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
