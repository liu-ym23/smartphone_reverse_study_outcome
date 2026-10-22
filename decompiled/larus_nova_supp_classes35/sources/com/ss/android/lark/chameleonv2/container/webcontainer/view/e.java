package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.WebMediaPermissionResources;
import com.ss.android.lark.officewebview.quality.safe.permission.PermissionHostFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends WebChromeClient {
    public final ChameleonWebView a;
    public PermissionRequest b;
    public UDDialog c;
    public final Map<String, Set<String>> d;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ List<String> b;

        public b(e r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            e r11 = this.a;
            List<String> r12 = this.b;
            PermissionRequest r0 = r11.b;
            if (r0 == null) goto L33;
            List<String> r1 = r12;
            List<String> r2 = WebMediaPermissionResources.androidPermissions(r1);
            ArrayList r3 = new ArrayList();
            Iterator<T> r4 = r2.iterator();
        L6:
            boolean r5 = false;
            if (r4.hasNext() == false) goto L14;
            Object r6 = r4.next();
            Context r7 = r11.a.getContext();
            if (ContextCompat.checkSelfPermission(r7, (String) r6) != 0) goto L11;
            r5 = true;
        L11:
            if (r5 == true) goto L6;
            r3.add(r6);
            goto L6
        L14:
            if (r3.isEmpty() == false) goto L16;
            r11.b = null;
            r11.g(r0, r1);
            e.e(r0, r12);
            return;
        L16:
            PermissionHostFragment r13 = r11.f();
            if (r13 != null) goto L24;
            com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "deny permission because activity is not available");
            r11.a();
            return;
        L24:
            r13.requestPermissions((String[]) r3.toArray(new String[0]), new f(r11));     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_PermissionClient", "request Android permission failed", th);
            r11.a();
            return;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ PermissionRequest a;
        public final /* synthetic */ e b;

        public c(PermissionRequest r1, e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_PermissionClient", "user deny WebView permission origin=" + this.a.getOrigin());
            this.b.a();
        }
    }

    static {
    }

    public final void a() {
        PermissionRequest r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.b = null;
        b(r0);     // Catch: IllegalStateException -> L8
        return;
    L8:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "WebView permission request is no longer valid: " + e.getMessage());
    }

    public final void d() {
        UDDialog r0 = this.c;
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
        this.c = null;
    }

    public final PermissionHostFragment f() {
        Fragment r0 = this.a.getFragment();
        if (r0 == null) goto L6;
        int r1 = PermissionHostFragment.f;
        PermissionHostFragment r2 = PermissionHostFragment.U90(r0.getChildFragmentManager());
        if (r2 == null) goto L6;
        return r2;
    L6:
        Fragment r3 = this.a.getFragment();
        if (r3 == null) goto L11;
        FragmentActivity r4 = r3.getActivity();
        if (r4 == null) goto L11;
    L13:
        if ((r4 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r5 = r4;
    L16:
        if (r5 == null) goto L19;
        int r6 = PermissionHostFragment.f;
        return PermissionHostFragment.U90(r5.getSupportFragmentManager());
    L19:
        return null;
    L15:
        r5 = null;
    L11:
        r4 = swb.h.a(this.a.getContext());
        goto L13
    }

    public e(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
        this.d = new LinkedHashMap();
    }

    public static void b(PermissionRequest r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102606);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102606, "android/webkit/PermissionRequest", "deny", r18, r10, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.deny();
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r18) {
        Intrinsics.checkNotNullParameter(r18, "request");
        List<String> r2 = WebMediaPermissionResources.grantableWebResources(r18.getResources());
        if (r2.isEmpty() == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "deny unsupported WebView permission request");
        b(r18);
        return;
    L6:
        d();
        a();
        Uri r3 = r18.getOrigin();
        if (r3 == null) goto L9;
        String r4 = r3.getHost();
    L10:
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        String r7 = r4;
        List<String> r5 = r2;
        List<String> r6 = WebMediaPermissionResources.androidPermissions(r5);
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L13:
        boolean r10 = false;
        if (r9.hasNext() == false) goto L20;
        Object r11 = r9.next();
        if (ContextCompat.checkSelfPermission(this.a.getContext(), (String) r11) != 0) goto L18;
        r10 = true;
    L18:
        if (r10 == true) goto L13;
        r8.add(r11);
        goto L13
    L20:
        Set r12 = (Set) ((LinkedHashMap) this.d).get(r7);
        if (r8.isEmpty() == false) goto L27;
        if (r12 == null) goto L27;
        if (r12.containsAll(r5) == false) goto L27;
        e(r18, r2);
        return;
    L27:
        Fragment r13 = this.a.getFragment();
        if (r13 == null) goto L32;
        FragmentActivity r14 = r13.getActivity();
        if (r14 == null) goto L32;
    L33:
        if (r14 != null) goto L35;
    L57:
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "deny permission because activity is not available");
        b(r18);
        return;
    L35:
        if (r14.isFinishing() == true) goto L57;
        if ((!r8.isEmpty()) == true) goto L40;
    L43:
        this.b = r18;
        UDDialogBuilder r15 = new UDDialogBuilder(r14).cancelOnTouchOutside(false);
        boolean r16 = r5.contains(WebMediaPermissionResources.VIDEO_CAPTURE);
        boolean r17 = r5.contains(WebMediaPermissionResources.AUDIO_CAPTURE);
        if (r16 == false) goto L47;
        if (r17 == false) goto L47;
        int r19 = 2131892971;
    L50:
        UDDialog r1 = r15.title(StringsKt.replace$default(StringsKt.replace$default(this.a.getContext().getString(2131892968), "{{page_url}}", r7, false, 4, null), "{{device}}", this.a.getContext().getString(r19), false, 4, null)).addActionButton(2131391777, 2131892065, new b(this, r2)).addActionButton(2131391778, 2131892064, new c(r18, this)).build();
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L60;
        DialogLancet.handleBlockedDialogShow(r1);
    L55:
        this.c = r1;
        return;
    L60:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L54:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    L47:
        if (r16 == false) goto L49;
        r19 = 2131892969;
        goto L50
    L49:
        r19 = 2131892970;
        goto L50
    L40:
        if (f() != null) goto L43;
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "deny permission because permissionProxy is not available");
        b(r18);
        return;
    L32:
        r14 = swb.h.a(this.a.getContext());
        goto L33
    L9:
        r4 = null;
        goto L10
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if (this.b != r2) goto L6;
        d();
        this.b = null;
        return;
    }

    public static void c(PermissionRequest r18, String[] r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102605);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102605, "android/webkit/PermissionRequest", "grant", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.grant(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void e(PermissionRequest r4, List r5) {
        c(r4, (String[]) r5.toArray(new String[0]));     // Catch: IllegalStateException -> L5
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_PermissionClient", "grant WebView permission=" + r5 + " origin=" + r4.getOrigin());     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_PermissionClient", "WebView permission request is no longer valid: " + e.getMessage());
    }

    public final void g(PermissionRequest r3, Collection<String> r4) {
        Uri r5 = r3.getOrigin();
        if (r5 == null) goto L12;
        String r6 = r5.getHost();
        if (r6 == null) goto L13;
        LinkedHashMap r0 = (LinkedHashMap) this.d;
        Object r1 = r0.get(r6);
        if (r1 != null) goto L10;
        r1 = new LinkedHashSet();
        r0.put(r6, r1);
    L10:
        ((Set) r1).addAll(r4);
        return;
    L13:
        return;
    }
}
