package com.bytedance.android.annie.business.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import b36.m;
import b36.n;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent;
import com.bytedance.android.annie.card.web.e;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.bullet.secure.WebViewPermissionKeva;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveWebChromeClient extends c26.c {
    public static final /* synthetic */ int h = 0;
    public final Context b;
    public final m16.b c;
    public final CopyOnWriteArrayList<e> d;
    public final Lazy e;
    public WeakReference<AlertDialog> f;
    public WeakReference<AlertDialog> g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AnnieXLiveWebChromeClient a;

        public b(AnnieXLiveWebChromeClient r1) {
            this.a = r1;
        }

        public final void a() {
            WeakReference<AlertDialog> r0 = this.a.g;
            if (r0 == null) goto L28;
            AlertDialog r1 = r0.get();
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.isShowing() == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L33;
            Handler r10 = DialogLancet.resolveDialogHandler(r1);
            if (r10 != null) goto L14;
        L16:
            DialogLancet.beforeDialogDismiss(r1);
            r1.dismiss();     // Catch: Throwable -> L19 Exception -> L21
        L25:
            DialogLancet.afterDialogDismiss(r1);
            return;
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
            return;
        L33:
            return;
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

    public static final class c implements Runnable {
        public final /* synthetic */ AnnieXLiveWebChromeClient a;
        public final /* synthetic */ AppCompatActivity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GeolocationPermissions.Callback d;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ GeolocationPermissions.Callback b;
            public final /* synthetic */ AnnieXLiveWebChromeClient c;
            public final /* synthetic */ AppCompatActivity d;

            public a(String r1, GeolocationPermissions.Callback r10, AnnieXLiveWebChromeClient r11, AppCompatActivity r12) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
                this.d = r12;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r10, int r11) {
                if (r11 != (-3)) goto L5;
                Lazy r12 = WebViewPermissionKeva.a;
                WebViewPermissionKeva.c(this.a, com.bytedance.android.ec.core.event.a.KEY_LOCATION, true, true);
                AnnieXLiveWebChromeClient r13 = this.c;
                AppCompatActivity r0 = this.d;
                GeolocationPermissions.Callback r1 = this.b;
                String r14 = this.a;
                int r15 = AnnieXLiveWebChromeClient.h;
                r13.getClass();
                AnnieXLiveWebChromeClient.h(r0, r1, r14, false);
            L12:
                r10.dismiss();
                return;
            L5:
                if (r11 != (-2)) goto L7;
                Lazy r16 = WebViewPermissionKeva.a;
                WebViewPermissionKeva.c(this.a, com.bytedance.android.ec.core.event.a.KEY_LOCATION, false, false);
                this.b.invoke(this.a, false, true);
                goto L12
            L7:
                if (r11 != (-1)) goto L12;
                Lazy r17 = WebViewPermissionKeva.a;
                WebViewPermissionKeva.c(this.a, com.bytedance.android.ec.core.event.a.KEY_LOCATION, true, false);
                AnnieXLiveWebChromeClient r18 = this.c;
                AppCompatActivity r19 = this.d;
                GeolocationPermissions.Callback r20 = this.b;
                String r21 = this.a;
                int r22 = AnnieXLiveWebChromeClient.h;
                r18.getClass();
                AnnieXLiveWebChromeClient.h(r19, r20, r21, true);
                goto L12
            }
        }

        public c(AnnieXLiveWebChromeClient r1, AppCompatActivity r10, String r11, GeolocationPermissions.Callback r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void a() {
            WeakReference<AlertDialog> r0 = this.a.g;
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
            r12.setTitle(2131897290);
            r12.setMessage(this.b.getString(2131897289, new Object[]{this.c}));
            a r13 = new a(this.c, this.d, this.a, this.b);
            r12.setNegativeButton(2131912928, r13);
            r12.setPositiveButton(2131912927, r13);
            r12.setNeutralButton(2131912929, r13);
            r12.setCancelable(false);
            this.a.g = new WeakReference(r12.show());
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

    public static final class d implements Runnable {
        public final /* synthetic */ AnnieXLiveWebChromeClient a;

        public d(AnnieXLiveWebChromeClient r1) {
            this.a = r1;
        }

        public final void a() {
            WeakReference<AlertDialog> r0 = this.a.f;
            if (r0 == null) goto L28;
            AlertDialog r1 = r0.get();
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.isShowing() == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L33;
            Handler r10 = DialogLancet.resolveDialogHandler(r1);
            if (r10 != null) goto L14;
        L16:
            DialogLancet.beforeDialogDismiss(r1);
            r1.dismiss();     // Catch: Throwable -> L19 Exception -> L21
        L25:
            DialogLancet.afterDialogDismiss(r1);
            return;
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
            return;
        L33:
            return;
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

    static {
    }

    public final void onGeolocationPermissionsHidePrompt() {
        Object r0 = this.c.c(Context.class);
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = (AppCompatActivity) r0;
    L6:
        if (r1 == null) goto L8;
        r1.runOnUiThread(new b(this));
    L8:
        super/*b36.j*/.onGeolocationPermissionsHidePrompt();
        throw null;
    L5:
        r1 = null;
        goto L6
    }

    public final Bitmap getDefaultVideoPoster() {
        super/*b36.j*/.getDefaultVideoPoster();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onHideCustomView() {
        super/*android.webkit.WebChromeClient*/.onHideCustomView();
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).r();
        goto L4
    }

    public final void a(m r11) {
        if (r11 == null) goto L45;
        Uri r10 = r11.getOrigin();
        if (r10 != null) goto L8;
        r11.a();
        return;
    L8:
        ArrayList r12 = new ArrayList();
        String[] r1 = r11.getResources();
        int r13 = r1.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L18;
        String r15 = r1[r14];
        if (Intrinsics.areEqual(r15, "android.webkit.resource.AUDIO_CAPTURE") == false) goto L14;
        r12.add(r15);
    L16:
        r14 = r14 + 1;
        goto L9
    L14:
        if (Intrinsics.areEqual(r15, "android.webkit.resource.VIDEO_CAPTURE") == false) goto L16;
        r12.add(r15);
        goto L16
    L18:
        if (r12.isEmpty() == false) goto L21;
        r11.a();
        return;
    L21:
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        Iterator r19 = r12.iterator();
    L23:
        if (r19.hasNext() == false) goto L32;
        String r20 = (String) r19.next();
        Lazy r21 = WebViewPermissionKeva.a;
        Intrinsics.checkNotNullParameter(r10, "origin");
        Intrinsics.checkNotNullParameter(r20, "resource");
        WebViewPermissionKeva.a r22 = WebViewPermissionKeva.b(r10.toString(), r20);
        if (r22 == null) goto L26;
        if (r22.a == true) goto L29;
        r18.add(r20);
        goto L23
    L29:
        r17.add(r20);
        goto L23
    L26:
        r16.add(r20);
        goto L23
    L32:
        if ((!r18.isEmpty()) == false) goto L35;
        r11.a();
        return;
    L35:
        Object r23 = this.c.c(Context.class);
        if ((r23 instanceof AppCompatActivity) == false) goto L38;
        Activity r24 = (AppCompatActivity) r23;
    L39:
        if (r24 == null) goto L45;
        if (r17.size() != r12.size()) goto L44;
        g(r24, r12, r11);
        return;
    L44:
        r24.runOnUiThread(new com.bytedance.android.annie.business.web.a(this, r24, r10, r16, r11, r12));
        goto L45
    L38:
        r24 = null;
    L45:
        super/*b36.j*/.a(r11);
        throw null;
    }

    public final void c(final ValueCallback<Uri> r10) {
        Intrinsics.checkNotNullParameter(r10, "uploadMsg");
        FixedUploadFileFragment r0 = (FixedUploadFileFragment) this.e.getValue();
        if (r0 == null) goto L6;
        Function1<Uri[], Unit> r1 = new AnnieXLiveWebChromeClient$openFileChooser$1(r10);
        int r11 = FixedUploadFileFragment.i;
        r0.U90(r1, null, false, false);
        return;
    }

    public final void f(b36.e r1) {
        ((c26.c) this).a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPermissionRequestCanceled(PermissionRequest r10) {
        Object r0 = this.c.c(Context.class);
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = (AppCompatActivity) r0;
    L6:
        if (r1 == null) goto L8;
        r1.runOnUiThread(new d(this));
    L8:
        super/*android.webkit.WebChromeClient*/.onPermissionRequestCanceled(r10);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public AnnieXLiveWebChromeClient(Context r10, m16.b r11) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        Intrinsics.checkNotNullParameter(r11, "providerFactory");
        this.b = r10;
        this.c = r11;
        Object r12 = r11.c(IHybridComponent.class);
        if ((r12 instanceof AnnieXLiveHybridComponent) == false) goto L5;
        AnnieXLiveHybridComponent r13 = (AnnieXLiveHybridComponent) r12;
    L6:
        if (r13 == null) goto L9;
        CopyOnWriteArrayList<e> r14 = r13.p;
        if (r14 == null) goto L9;
    L10:
        this.d = r14;
        this.e = LazyKt.lazy(new AnnieXLiveWebChromeClient$lazyUploadFileFragment$2(this));
        return;
    L9:
        r14 = new CopyOnWriteArrayList();
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public final void d(final ValueCallback<Uri> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uploadMsg");
        Intrinsics.checkNotNullParameter(r11, "acceptType");
        FixedUploadFileFragment r12 = (FixedUploadFileFragment) this.e.getValue();
        if (r12 == null) goto L6;
        Function1<Uri[], Unit> r0 = new AnnieXLiveWebChromeClient$openFileChooser$2(r10);
        int r13 = FixedUploadFileFragment.i;
        r12.U90(r0, null, false, false);
        return;
    }

    public final void onGeolocationPermissionsShowPrompt(String r23, GeolocationPermissions.Callback r24) {
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r23, r24};
        f06.b r15 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(100003);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r10 = r1;
        int r13 = r10.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L15;
        f06.a r16 = r10[r14];
        int r19 = r14;
        int r20 = r13;
        f06.a[] r21 = r10;
        f06.d r17 = r16.preInvoke(100003, "com/bytedance/android/annie/business/web/AnnieXLiveWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r12, "void", r15);     // Catch: Exception -> L42
        if (r17.a == true) goto L12;
        r11.add(r16);     // Catch: Exception -> L42
        goto L14
    L12:
        AppCompatActivity r18 = null;
    L17:
        if (r17.a == false) goto L19;
        return;
    L19:
        if (r23 != null) goto L21;
    L24:
        boolean r22 = true;
    L25:
        if (r22 == true) goto L48;
        if (r24 == null) goto L51;
        Object r25 = this.c.c(Context.class);
        if ((r25 instanceof AppCompatActivity) == false) goto L31;
        AppCompatActivity r26 = (AppCompatActivity) r25;
    L32:
        if (r26 == null) goto L49;
        WebViewPermissionKeva.a r27 = WebViewPermissionKeva.b(r23, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        if (r27 != null) goto L37;
        r26.runOnUiThread(new c(this, r26, r23, r24));
        return;
    L37:
        if (r27.a != true) goto L40;
        h(r26, r24, r23, r27.b);
        return;
    L40:
        r24.invoke(r23, false, true);
        return;
    L49:
        return;
    L31:
        r26 = r18;
        goto L32
    L51:
        return;
    L48:
        return;
    L21:
        if (r23.length() == 0) goto L24;
        r22 = false;
    L14:
        r14 = r19 + 1;
        r13 = r20;
        r10 = r21;
        goto L8
    L15:
        r18 = null;
        r17 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProgressChanged(WebView r10, int r11) {
        super/*android.webkit.WebChromeClient*/.onProgressChanged(r10, r11);
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).t(r10, r11);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onReceivedTitle(WebView r10, String r11) {
        super/*android.webkit.WebChromeClient*/.onReceivedTitle(r10, r11);
        Iterator<T> r12 = this.d.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((e) r12.next()).x(r11);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onShowCustomView(View r10, WebChromeClient.CustomViewCallback r11) {
        super/*android.webkit.WebChromeClient*/.onShowCustomView(r10, r11);
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).z(r10, r11);
        goto L4
    }

    public static void g(AppCompatActivity r10, List r11, b36.b r12) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r11.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        String r13 = (String) r1.next();
        if (Intrinsics.areEqual(r13, "android.webkit.resource.AUDIO_CAPTURE") == true) goto L7;
        if (Intrinsics.areEqual(r13, "android.webkit.resource.VIDEO_CAPTURE") == false) goto L4;
        r0.add("android.permission.CAMERA");
        goto L4
    L7:
        r0.add("android.permission.RECORD_AUDIO");
        goto L4
    L11:
        boolean r14 = true;
        if (r0.isEmpty() == true) goto L23;
        Iterator r15 = r0.iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        if (ContextCompat.checkSelfPermission(r10, (String) r15.next()) != 0) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == true) goto L16;
        r14 = false;
        goto L23
    L20:
        r16 = false;
    L23:
        if (r14 == false) goto L30;
        Object[] r17 = r11.toArray(new String[0]);
        if (r17 == null) goto L29;
        r12.b((String[]) r17);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L30:
        XBaseRuntime.a.getClass();
        r12.a();
    }

    public final boolean b(WebView r10, final ValueCallback r11, n r12) {
        if (r12 == null) goto L8;
        FixedUploadFileFragment r13 = (FixedUploadFileFragment) this.e.getValue();
        if (r13 == null) goto L9;
        r13.U90(new AnnieXLiveWebChromeClient$onShowFileChooser$1$1(r11), r12.d(), r12.c(), r12.e());
        return true;
    L9:
        return true;
    L8:
        return true;
    }

    public final void e(final ValueCallback<Uri> r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "uploadMsg");
        Intrinsics.checkNotNullParameter(r11, "acceptType");
        Intrinsics.checkNotNullParameter(r12, "capture");
        FixedUploadFileFragment r13 = (FixedUploadFileFragment) this.e.getValue();
        if (r13 == null) goto L6;
        Function1<Uri[], Unit> r14 = new AnnieXLiveWebChromeClient$openFileChooser$3(r10);
        int r15 = FixedUploadFileFragment.i;
        r13.U90(r14, null, true, false);
        return;
    }

    public static void h(AppCompatActivity r10, GeolocationPermissions.Callback r11, String r12, boolean r13) {
        List r0 = CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        if (ContextCompat.checkSelfPermission(r10, (String) r1.next()) != 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L9;
        boolean r15 = false;
    L17:
        if (r15 == false) goto L20;
        r11.invoke(r12, true, r13);
        return;
    L20:
        XBaseRuntime.a.getClass();
        r11.invoke(r12, false, false);
        return;
    L13:
        r14 = false;
    L16:
        r15 = true;
        goto L17
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }
}
