package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.conditional.access.nopermission.ui.PopupWindowActivityV2;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Map<String, Integer> a = null;
    public static final Map<String, Integer> b = null;
    public static final Map<String, Integer> c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.nopermission.manager.a$a, reason: collision with other inner class name */
    public static final class RunnableC0156a implements Runnable {
        public final /* synthetic */ UDDialog a;

        public RunnableC0156a(UDDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDDialog r0 = this.a;     // Catch: Throwable -> L10
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r0);     // Catch: Throwable -> L10
        L8:
            ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "showDialogInternal(), dialog.show()");     // Catch: Throwable -> L10
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15 Throwable -> L10
        L7:
            DialogLancet.beforeDialogShow(r0);     // Catch: Throwable -> L10
            r0.show();     // Catch: Throwable -> L10
            DialogLancet.afterDialogShow(r0);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ InternalSecurityAction a;
        public final /* synthetic */ Activity b;

        public b(InternalSecurityAction r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.onPrimaryButtonClick();
            Map<String, Integer> r3 = a.a;
            Activity r4 = this.b;
            Intrinsics.checkNotNull(r1);
            a.a(r4, r1);
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Activity a;

        public c(Activity r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            Map<String, Integer> r0 = a.a;
            Activity r1 = this.a;
            Intrinsics.checkNotNull(r2);
            a.a(r1, r2);
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ InternalSecurityAction a;

        public d(InternalSecurityAction r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            this.a.onDialogDismiss();
        }
    }

    public static final class e<T> implements Predicate {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            InternalSecurityAction r3 = (InternalSecurityAction) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Intrinsics.areEqual("CommonDialog", r3.getCurrentAction().getParams().get("style"));
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r6) {
            InternalSecurityAction r7 = (InternalSecurityAction) r6;
            Map<String, Integer> r0 = a.a;
            Intrinsics.checkNotNull(r7);
            String r1 = r7.getCurrentAction().getParams().get("operation");
            if (r1 != null) goto L5;
            r1 = BuildConfig.FLAVOR;
        L5:
            int r2 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "handleCommonDialogAction(), operation:".concat(r1));
            if (r1.length() != 0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            FileAuthMonitor.UpdateTrigger[] r4 = FileAuthMonitor.a;
            FileAuthMonitor.o("BUSINESS", r7.getCurrentAction().toString(), "requiredFieldNotFound");
        L11:
            Integer r5 = a.a.get(r1);
            if (r5 == null) goto L14;
            int r8 = r5.intValue();
        L15:
            Integer r9 = a.b.get(r1);
            if (r9 == null) goto L18;
            int r10 = r9.intValue();
        L19:
            Integer r11 = a.c.get(r1);
            if (r11 == null) goto L22;
            int r12 = r11.intValue();
        L23:
            DialogInfo r13 = new DialogInfo();
            r13.a = r8;
            r13.b = r10;
            r13.c = r12;
            Object r14 = r7.getInternalParams().get("comeFrom");
            if (r14 != null) goto L26;
            r14 = "SDK_INTERNAL";
        L26:
            String r15 = (String) r14;
            int r16 = g8b.b.a;
            if (g8b.b.a.a().j() == false) goto L29;
            ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "startPopupDialog(), NoPermissionModuleManager.getCurrentUnauthorizedType() != null");
            FileAuthMonitor.UpdateTrigger[] r17 = FileAuthMonitor.a;
            FileAuthMonitor.o(r15, r7.toString(), "inNoAccessStatus");
            return;
        L29:
            WeakReference<Dialog> r18 = SecurityDialogUtil.a;
            Activity r19 = null;
            if (r18 == null) goto L32;
            Dialog r20 = r18.get();
        L33:
            if (r20 == null) goto L39;
            WeakReference<Activity> r21 = SecurityDialogUtil.b;
            if (r21 == null) goto L37;
            r19 = r21.get();
        L37:
            if (r19 == null) goto L39;
            ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "dialog already exist");
            FileAuthMonitor.UpdateTrigger[] r22 = FileAuthMonitor.a;
            FileAuthMonitor.o(r15, r7.toString(), "dialogAlreadyExist");
            return;
        L39:
            ContextWrapper r23 = AppLifecycle.a.a.f();
            if (r23 != null) goto L42;
            r23 = LarkContext.getApplication();
        L42:
            g8b.b.a.a().getDependency().l(r23);
            Intent r24 = new Intent(r23, PopupWindowActivityV2.class);
            r24.putExtra("popup_title", r13.a);
            r24.putExtra("popup_content", r13.b);
            r24.putExtra("popup_primary_button", r13.c);
            r24.putExtra("popup_action", r7);
            if ((r23 instanceof Activity) == true) goto L45;
            r24.addFlags(268435456);
        L45:
            SecurityDialogUtil.c = r7;
            r23.startActivity(r24);
            return;
        L32:
            r20 = null;
            goto L33
        L22:
            r12 = 2131890503;
            goto L23
        L18:
            r10 = 2131892674;
            goto L19
        L14:
            r8 = 2131892673;
            goto L15
        L8:
            r3 = false;
            goto L9
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ Observable<InternalSecurityAction> a;

        public g(Observable<InternalSecurityAction> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            int r0 = ScsLogger.a;
            Intrinsics.checkNotNull(r3);
            ScsLogger.c("SecurityPolicy_CommonDialogActionHandler", ExceptionsKt.stackTraceToString(r3));
            Map<String, Integer> r4 = a.a;
            a.c(this.a);
        }
    }

    public a() {
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("DLP_IM_SAVE", 2131890630), TuplesKt.to("DLP_IM_CHAT_CREATE", 2131890629)});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("DLP_IM_SAVE", 2131890631), TuplesKt.to("DLP_IM_CHAT_CREATE", 2131890627)});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("DLP_IM_SAVE", 2131890626), TuplesKt.to("DLP_IM_CHAT_CREATE", 2131890626)});
    }

    public static void c(Observable r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        r3.filter(e.a).observeOn(AndroidSchedulers.mainThread()).subscribe(f.a, new g(r3));
    }

    public static final void a(Activity r0, DialogInterface r1) {
        r1.dismiss();
        if ((r0 instanceof com.ss.android.lark.conditional.access.nopermission.ui.r) == false) goto L8;
        SecurityDialogUtil.c = null;
        WeakReference<Activity> r2 = SecurityDialogUtil.b;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        r0.finish();
        return;
    L8:
        WeakReference<Dialog> r3 = SecurityDialogUtil.a;
        if (r3 == null) goto L13;
        r3.clear();
        return;
    }

    public static void b(Activity r8, DialogInfo r9, InternalSecurityAction r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "dialogInfo");
        Intrinsics.checkNotNullParameter(r10, Keys.API_PARAM_KEY_ACTION);
        ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "showDialogInternal");
        Object r1 = r10.getInternalParams().get("comeFrom");
        if (r1 != null) goto L5;
        r1 = "SDK_INTERNAL";
    L5:
        String r2 = (String) r1;
        if (r8.isFinishing() == true) goto L41;
        boolean r3 = r8 instanceof com.ss.android.lark.conditional.access.nopermission.ui.r;
        if (r3 == true) goto L43;
        WeakReference<Dialog> r5 = SecurityDialogUtil.a;
        boolean r6 = true;
        if (r5 == null) goto L16;
        Dialog r7 = r5.get();
        if (r7 == null) goto L16;
        if (r7.isShowing() != true) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L43;
        WeakReference<Dialog> r12 = SecurityDialogUtil.a;
        if (r12 == null) goto L27;
        Dialog r13 = r12.get();
        if (r13 == null) goto L27;
        Activity r14 = r13.getOwnerActivity();
        if (r14 == null) goto L27;
        if (r14.isDestroyed() != true) goto L27;
    L28:
        if (r6 == false) goto L41;
    L27:
        r6 = false;
    L16:
        r11 = false;
    L43:
        String r15 = LarkContext.getApplication().getString(r9.a);     // Catch: Exception -> L38
        String r16 = LarkContext.getApplication().getString(r9.b);     // Catch: Exception -> L38
        String r17 = LarkContext.getApplication().getString(r9.c);     // Catch: Exception -> L38
        com.ss.android.lark.conditional.access.nopermission.ui.a0 r0 = new com.ss.android.lark.conditional.access.nopermission.ui.a0(r8);
        if ((r8 instanceof PopupWindowActivityV2) == false) goto L33;
        r0.style(2131953406);
    L33:
        r0.title(r15);
        r0.message(r16);
        r0.messageGravity(8388611);
        r0.addActionButton(2131391777, r17, new b(r10, r8));
        r0.cancelable(false);
        r0.cancelOnTouchOutside(false);
        r0.onCancelListener(new c(r8));
        r0.onDismissListener(new d(r10));
        UDDialog r18 = r0.build();
        if (r3 == true) goto L36;
        WeakReference<Dialog> r19 = SecurityDialogUtil.a;
        SecurityDialogUtil.a = new WeakReference(r18);
    L36:
        ((Handler) SecurityDialogUtil.d.getValue()).post(new RunnableC0156a(r18));
        return;
    L38:
        e = move-exception;
        int r20 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CommonDialogActionHandler", ExceptionsKt.stackTraceToString(e));
        FileAuthMonitor.o(r2, BuildConfig.FLAVOR, "stringResourceError");
        return;
    L41:
        ScsLogger.d("SecurityPolicy_CommonDialogActionHandler", "showDialogInternal() fail, currentActivity.isFinishing:" + r8.isFinishing());
        FileAuthMonitor.o(r2, BuildConfig.FLAVOR, "activityIsFinishing");
    }
}
