package p99;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.model.NotificationType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hq9.n3;
import hq9.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q99.i;
import q99.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class c implements e {
    public final n99.a a;

    public static final class a {
    }

    public static final class b implements q3 {
        public boolean a;
        public final /* synthetic */ o99.a b;
        public final /* synthetic */ q99.e c;
        public final /* synthetic */ c d;
        public final /* synthetic */ i e;

        public final void c() {
        }

        public final void a() {
            FLogger.a.i("BaseFeedbackManager", "[showPopup.onDialogCloseByUserMoveUp]:");
            o99.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.i();
            return;
        }

        public final void b(boolean r4) {
            FLogger.a.i("BaseFeedbackManager", "[showPopup.onFeedbackClick]: isLike = " + r4 + ", feedbackClicked = " + this.a);
            if (this.a == false) goto L5;
            return;
        L5:
            this.a = true;
            o99.a r0 = this.b;
            if (r0 == null) goto L8;
            r0.j(this.c, r4);
        L8:
            if (r4 == false) goto L10;
            this.d.c(this.c, this.e);
            return;
        L10:
            this.d.b(this.c, this.e);
        }

        public b(o99.a r1, q99.e r2, c r3, i r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    static {
    }

    public void d(q99.e r2, i r3, q99.a r4) {
        Intrinsics.checkNotNullParameter(r2, "delivery");
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "result");
    }

    public c(n99.a r2) {
        Intrinsics.checkNotNullParameter(r2, "gateway");
        this.a = r2;
    }

    public void b(final q99.e r27, final i r28) {
        Intrinsics.checkNotNullParameter(r27, "delivery");
        Intrinsics.checkNotNullParameter(r28, "host");
        Intrinsics.checkNotNullParameter(r27, "delivery");
        Intrinsics.checkNotNullParameter(r28, "host");
        Function0<LifecycleOwner> r1 = r28.h;
        if (r1 == null) goto L5;
        LifecycleOwner r11 = (LifecycleOwner) r1.invoke();
    L6:
        if (r11 == null) goto L73;
        Function0<FragmentManager> r2 = r28.i;
        if (r2 == null) goto L11;
        FragmentManager r12 = (FragmentManager) r2.invoke();
    L12:
        if (r12 == null) goto L74;
        final q99.d r13 = r27.f;
        if (r13 == null) goto L75;
        final o99.a r14 = r28.q;
        List<q99.b> r3 = r13.a();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = ((ArrayList) r3).iterator();
    L19:
        if (r4.hasNext() == false) goto L22;
        q99.b r5 = (q99.b) r4.next();
        r15.add(new FeedbackMeta(MsgFeedbackType.MsgFeedbackTypeDislike.value, r5.a, r5.b));
        goto L19
    L22:
        if (r15.isEmpty() == true) goto L76;
        String r6 = r13.b();
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        final String r8 = "flow_feedback_dislike_panel_".concat(r6);
        DialogFragment r7 = r12.findFragmentByTag(r8);
        if ((r7 instanceof DialogFragment) == false) goto L30;
        DialogFragment r9 = r7;
    L31:
        if (r9 != null) goto L67;
        final FragmentManager r10 = r12;
        r12.setFragmentResultListener(r8, r11, new p99.b(r13, r14, r27, r10, r8, this, r28));
        FlowFeedbackServiceDelegate r16 = FlowFeedbackServiceDelegate.a;
        ArrayList r17 = new ArrayList(r15);
        String r18 = r13.g();
        if (r18 != null) goto L41;
        String r20 = "";
    L42:
        Bundle r21 = new Bundle();
        String r22 = r27.b;
        if (r22 != null) goto L45;
        r22 = r13.e();
    L45:
        r21.putString("message_id", r22);
        r21.putString("message_log_id", r27.e);
        r21.putBoolean("disable_copy_button", r28.m);
        r21.putBoolean("is_multiple_selection", true);
        if (r14 == null) goto L51;
        Bundle r23 = r14.b(r21);
        if (r23 == null) goto L51;
        Bundle r24 = r23;
    L52:
        Fragment r25 = r16.d(new FlowDislikePanelConfig(r8, r17, r20, r24, null, false, false));
        if ((r25 instanceof Fragment) == false) goto L55;
        Fragment r110 = r25;
    L56:
        LandscapeRestrictionOperation r26 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r110, r8, r26);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r110, r26) == false) goto L65;
    L61:
        if (r14 == null) goto L72;
        r14.d();
        return;
    L72:
        return;
    L65:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L60:
        r25.show(r12, r8);
        goto L61
    L55:
        r110 = null;
    L51:
        r24 = r21;
        goto L52
    L41:
        r20 = r18;
        goto L42
    L67:
        r9.dismissAllowingStateLoss();     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L70;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L70:
        return;
    L30:
        r9 = null;
        goto L31
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L11:
        r12 = null;
        goto L12
    L73:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void c(q99.e r10, i r11) {
        Intrinsics.checkNotNullParameter(r10, "delivery");
        Intrinsics.checkNotNullParameter(r11, "host");
        q99.d r0 = r10.f;
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        String r5 = "";
    L10:
        q99.d r3 = r10.f;
        if (r3 == null) goto L13;
        Integer r4 = r3.c();
    L14:
        int r6 = MsgFeedbackType.MsgFeedbackTypeLike.value;
        Map r7 = MapsKt.createMapBuilder();
        String r12 = r10.b;
        if (r12 == null) goto L18;
        r7.put("message_id", r12);
    L18:
        if (r11.a() == null) goto L24;
        String r13 = r11.a();
        if (r13 == null) goto L23;
        r2 = r13;
    L23:
        r7.put("section_id", r2);
    L24:
        String r14 = r11.d;
        if (r14 == null) goto L27;
        r7.put("call_id", r14);
    L27:
        r7.put("click_from", "banner_action");
        k r15 = new k(r4, r5, r6, MapsKt.build(r7), 24);
        Intrinsics.checkNotNullParameter(r15, "request");
        this.a.b(r15, null);
        return;
    L13:
        r4 = null;
        goto L14
    L9:
        r5 = r1;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [p99.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p99.e
    public void query(q99.c r3, final o99.c r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.a.a(r3, new p99.a(r4));
    }

    public final n3 a(q99.d r26, String r27, q99.e r28, i r210, String r30, List<String> r31, o99.a r32) {
        Intrinsics.checkNotNullParameter(r26, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r27, "avatarUrl");
        Intrinsics.checkNotNullParameter(r28, "delivery");
        Intrinsics.checkNotNullParameter(r210, "host");
        Intrinsics.checkNotNullParameter(r30, "notificationBusiness");
        String r5 = r26.e();
        String r4 = r26.i();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        n3 r3 = new n3(r5, r27, r4, null, NotificationType.FEEDBACK, 0, r30, r31, new b(r32, r28, this, r210), null, null, null, null, null, false, null, false, null, 1047636);
        if (r32 == null) goto L12;
        n3 r0 = r32.f(r3);
        if (r0 != null) goto L11;
        return r3;
    L11:
        return r0;
    L12:
        return r3;
    }
}
