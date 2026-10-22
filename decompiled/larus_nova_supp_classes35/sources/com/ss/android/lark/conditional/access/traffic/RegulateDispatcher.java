package com.ss.android.lark.conditional.access.traffic;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.handler.policy.center.PolicyCenterDisplayIdActionGate;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.subjects.PublishSubject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RegulateDispatcher {
    public static final PublishSubject<InternalSecurityAction> a = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/RegulateDispatcher$ActionFrom;", BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ActionFrom {
    }

    static {
        new String[]{"DLP_CONTENT_DETECTING", "DLP_CONTENT_SENSITIVE"};
        new String[]{"ACCESS_MFA", "BLOCKED_BY_IP_RULE", "BLOCKED_BY_DEVICE_CREDIBILITY", "BLOCKED_BY_DEVICE_OWNERSHIP"};
        a = PublishSubject.create();
    }

    public static void a(InternalSecurityAction r11, @ActionFrom String r12) {
        Intrinsics.checkNotNullParameter(r11, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r12, "comeFrom");
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_RegulateDispatcher", "[start handle action], handleSecurityAction(), [actionSource:" + r12 + "], [rawDecision:" + r11.getRawActions() + ']');
        Lazy r3 = PolicyCenterDisplayIdActionGate.a;
        Intrinsics.checkNotNullParameter(r11, Keys.API_PARAM_KEY_ACTION);
        if (((com.ss.android.lark.conditional.access.traffic.handler.policy.center.a) PolicyCenterDisplayIdActionGate.a.getValue()).C5(r11) == false) goto L5;
        return;
    L5:
        int r4 = g8b.b.a;
        if (g8b.b.a.a().j() == true) goto L58;
        r11.getInternalParams().put("comeFrom", r12);
        if (r11.getCurrentAction().getParams().get("style") != null) goto L48;
        Lazy r5 = ActionDispatcher.a;
        Intrinsics.checkNotNullParameter(r11, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r12, "comeFrom");
        boolean r1 = false;
        Object r6 = null;
        if (w4c.c.a().A() == false) goto L27;
        Iterator<T> r0 = r11.getActions().iterator();
    L14:
        if (r0.hasNext() == false) goto L23;
        Object r7 = r0.next();
        DecisionData.Action r8 = (DecisionData.Action) r7;
        if (Intrinsics.areEqual(r8.getName(), "ACCESS_CONTROL_ACTION_COMMON") == true) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L14;
    L24:
        DecisionData.Action r10 = (DecisionData.Action) r7;
        if (r10 == null) goto L27;
        String r13 = r10.getParams().get("logID");
        int r14 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "tryPickCustomAction, [logId:" + r13 + ']');
        r11.setCurrentAction(r10);
        goto L27
    L18:
        if (ArraysKt.contains(new String[]{"FILE_PROTECT", "POLICY_CENTER", "DEFAULT_PLATFORM_POLICY_SET"}, r8.getParams().get("policyType")) == false) goto L20;
        r9 = true;
        goto L21
    L23:
        r7 = null;
    L27:
        Iterator r15 = ((List) ActionDispatcher.d.getValue()).iterator();
    L29:
        if (r15.hasNext() == false) goto L33;
        Object r16 = r15.next();
        if (((q8b.c) r16).b(r11.getCurrentAction()) == false) goto L29;
        r6 = r16;
    L33:
        q8b.c r17 = (q8b.c) r6;
        if (r17 == null) goto L59;
        int r18 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "pick actionHandler is " + r17.c() + ", [selectedAction:" + r11.getCurrentAction() + ']');
        Lazy r19 = ActionDispatcher.a;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L39;
    L45:
        if (r1 == false) goto L47;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "skip officeSDK access control actionHandler " + r17.c() + ", [selectedAction:" + r11.getCurrentAction() + ']');
        FileAuthMonitor.UpdateTrigger[] r20 = FileAuthMonitor.a;
        FileAuthMonitor.n(r12, r11);
        return;
    L47:
        r17.a(r11);
        FileAuthMonitor.UpdateTrigger[] r21 = FileAuthMonitor.a;
        FileAuthMonitor.n(r12, r11);
        return;
    L39:
        if (((List) ActionDispatcher.a.getValue()).contains(r17) == false) goto L45;
        if (w4c.c.a().v0() == false) goto L44;
        r1 = true;
        goto L45
    L44:
        r1 = !ActionDispatcher.b.contains(r17.getClass());
        goto L45
    L59:
        return;
    L48:
        a.onNext(r11);
        return;
    }
}
