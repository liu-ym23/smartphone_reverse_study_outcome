package com.larksuite.component.card.action;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponseInner;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardActionManager {
    public static final Lazy<UniversalCardActionManager> b = null;
    public final com.larksuite.component.card.action.a a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ f c;

        public b(String r1, Context r2, f r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            String r1 = this.a;
            Context r2 = this.b;
            f r0 = this.c;
            dz7.b r3 = r0.a;
            com.larksuite.component.card.plugin.a.b(r1, r2, r3.a, r3.g, r0.e, r0.b.a, r3.k);
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
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Context d;

        public c(int r1, String r2, int r3, Context r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a;
            if (r0 != PutUniversalCardActionResponseInner.Toast.Type.success.getValue()) goto L6;
            String r1 = this.b;
            int r2 = 2131256306;
        L24:
            if (TextUtils.isEmpty(r1) == true) goto L32;
            Context r3 = this.d;
            if (r3 == null) goto L33;
            UDToast.a r4 = UDToast.build(r3);
            r4.g(r1);
            if (r2 == 0) goto L30;
            r4.d(r2);
        L30:
            r4.b.d = -2;
            r4.h();
            return;
        L33:
            return;
        L32:
            return;
        L6:
            if (r0 != PutUniversalCardActionResponseInner.Toast.Type.error.getValue()) goto L9;
            r1 = this.b;
        L20:
            r2 = 2131255144;
            goto L24
        L9:
            if (r0 != PutUniversalCardActionResponseInner.Toast.Type.info.getValue()) goto L12;
            r1 = this.b;
        L22:
            r2 = 0;
            goto L24
        L12:
            if (r0 != PutUniversalCardActionResponseInner.Toast.Type.warning.getValue()) goto L15;
            r1 = this.b;
            r2 = 2131256189;
            goto L24
        L15:
            if (r0 == 1000) goto L17;
            r1 = "";
            goto L22
        L17:
            if (idb.f.a().isEnable("universal_card.action_error_code_tip.enable") == false) goto L19;
            r1 = this.b + " code: " + this.c;
            goto L20
        L19:
            r1 = this.b;
            goto L20
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
        b = LazyKt.lazy(UniversalCardActionManager$Companion$INSTANCE$2.INSTANCE);
    }

    public UniversalCardActionManager() {
        this.a = new com.larksuite.component.card.action.a();
    }

    public static void b(Context r8, f r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "requestEntity");
        Intrinsics.checkNotNullParameter(r10, "platformUrl");
        if (idb.f.a().isEnable("universalcard.open_url.thread.fix.disable") == true) goto L5;
        mz7.b.a(new b(r10, r8, r9));
        return;
    L5:
        dz7.b r0 = r9.a;
        com.larksuite.component.card.plugin.a.b(r10, r8, r0.a, r0.g, r9.e, r9.b.a, r0.k);
    }

    public static void c(Context r1, int r2, String r3, int r4) {
        if (r3 == null) goto L4;
        mz7.b.a(new c(r2, r3, r4, r1));
        return;
    L4:
        Log.i("LynxCardActionManager", "show toast content is null");
    }

    public static final void a(final UniversalCardActionManager r17, Context r19, dz7.c.b r110, dz7.c r20, final f r21) {
        r17.getClass();
        if (idb.f.a().isEnable("universalcard.card.modifyerrormsg") == true) goto L5;
        Log.i("LynxCardActionManager", "showJumpDialogIfNeed skipped: fg disabled");
        c(r19, r110.a, r110.c, 99999999);
        return;
    L5:
        com.larksuite.component.card.action.a r4 = r17.a;
        final Function2<Activity, String, Unit> r6 = new UniversalCardActionManager$onToast$toastIntercepted$1(r17, r21);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r110, "toast");
        Intrinsics.checkNotNullParameter(r20, "response");
        Intrinsics.checkNotNullParameter(r6, "onConfirmJump");
        String r0 = r110.c;
        boolean r7 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        final Activity r9 = null;
        if (r1 == false) goto L15;
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped: toast content is null or empty");
    L39:
        final String r11 = null;
    L40:
        String r2 = r110.c;
        if (r11 != null) goto L43;
    L46:
        boolean r3 = true;
    L47:
        if (r3 == true) goto L84;
        if (r2 != null) goto L50;
    L53:
        boolean r5 = true;
    L54:
        if (r5 == true) goto L84;
        if (r11 != null) goto L90;
    L64:
        String r8 = null;
    L65:
        if (r8 != null) goto L67;
    L70:
        boolean r10 = true;
    L71:
        if (r10 == false) goto L73;
        Log.i("CardToastInterceptor", "showJumpDialogIfNeed skipped: jumpDialogUrl is blank or empty after sanitized, raw jumpDialogUrl=" + r11);
    L85:
        r7 = false;
    L86:
        if (r7 == true) goto L93;
        c(r19, r110.a, r110.c, 99999999);
        return;
    L93:
        return;
    L73:
        if (r19 == null) goto L75;
        r9 = UIUtils.getActivityFromContext(r19);
    L75:
        if (r9 != null) goto L78;
        Log.i("CardToastInterceptor", "showJumpDialogIfNeed skipped: activity is null");
        goto L85
    L78:
        if (r9.isFinishing() == false) goto L80;
    L83:
        Log.i("CardToastInterceptor", "showJumpDialogIfNeed skipped: activity is invalid, finishing=" + r9.isFinishing() + ", destroyed=" + r9.isDestroyed());
        goto L85
    L80:
        if (r9.isDestroyed() == true) goto L83;
        mz7.b.a(new com.larksuite.component.card.action.b(r9, r2, r4, new CardToastInterceptor$showJumpDialogIfNeed$1(r6, r9, r11)));
        goto L86
    L67:
        if (r8.length() == 0) goto L70;
        r10 = false;
        goto L71
    L90:
        URL r12 = new URL(r11);     // Catch: MalformedURLException -> L63
        StringBuffer r13 = new StringBuffer();
        r13.append(r12.getProtocol());
        r13.append("://");
        r13.append(r12.getHost());
        if (r12.getPort() == (-1)) goto L62;
        r13.append(":");
        r13.append(r12.getPort());
    L62:
        r13.append(r12.getPath());
        r8 = r13.toString();
        goto L65
    L50:
        if (r2.length() == 0) goto L53;
        r5 = false;
    L84:
        Log.i("CardToastInterceptor", "showJumpDialogIfNeed skipped: jumpDialogUrl is blank or toastContent is empty, jumpDialogUrl=" + r11 + " ; toastContent=" + r2);
        goto L85
    L43:
        if (StringsKt.isBlank(r11) == true) goto L46;
        r3 = false;
        goto L47
    L15:
        Integer r14 = r110.b;
        if (r14 != null) goto L18;
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped: errorCode is null");
        goto L39
    L18:
        LynxCardCommonConfig r15 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);
        if (r15 != null) goto L21;
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped: cardCommonConfig is null");
        goto L39
    L21:
        Map<String, String> r16 = r15.toastJumpUrlMap;
        if (r16 == null) goto L38;
        r11 = r16.get(r14.toString());
        if (r11 != null) goto L26;
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped: toastJumpUrlMap has no matched url for errorCode=" + r14);
        goto L38
    L26:
        if (StringsKt.contains$default(r11, "{{client_id}}", false, 2, null) == false) goto L40;
        String r111 = r20.b;
        if (r111 != null) goto L30;
    L33:
        boolean r22 = true;
    L34:
        if (r22 == false) goto L36;
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped:url requires placeholder but clientId is null or empty");
        goto L39
    L36:
        r11 = StringsKt.replace$default(r11, "{{client_id}}", r111, false, 4, null);
        goto L40
    L30:
        if (r111.length() == 0) goto L33;
        r22 = false;
    L38:
        Log.i("CardToastInterceptor", "tryParseJumpDialogUrl skipped: cardCommonConfig did not parse toastJumpUrlMap");
        goto L39
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }
}
