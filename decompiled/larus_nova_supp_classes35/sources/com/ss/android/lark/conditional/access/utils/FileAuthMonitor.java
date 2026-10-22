package com.ss.android.lark.conditional.access.utils;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileAuthMonitor {
    public static final UpdateTrigger[] a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$AccessControlScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "OpenBindWebDidPage", "OpenDeviceDeclarePage", "OpenNoPermissionPage", "ModuleInit", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccessControlScene extends Enum<AccessControlScene> {
        public static final AccessControlScene ModuleInit = null;
        public static final AccessControlScene OpenBindWebDidPage = null;
        public static final AccessControlScene OpenDeviceDeclarePage = null;
        public static final AccessControlScene OpenNoPermissionPage = null;
        public static final /* synthetic */ AccessControlScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AccessControlScene> getEntries() {
            return b;
        }

        static {
            AccessControlScene r0 = new AccessControlScene("OpenBindWebDidPage", 0);
            OpenBindWebDidPage = r0;
            AccessControlScene r1 = new AccessControlScene("OpenDeviceDeclarePage", 1);
            OpenDeviceDeclarePage = r1;
            AccessControlScene r3 = new AccessControlScene("OpenNoPermissionPage", 2);
            OpenNoPermissionPage = r3;
            AccessControlScene r5 = new AccessControlScene("ModuleInit", 3);
            ModuleInit = r5;
            AccessControlScene[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static AccessControlScene[] values() {
            return (AccessControlScene[]) a.clone();
        }

        public static AccessControlScene valueOf(String r1) {
            return (AccessControlScene) r27.a.a(AccessControlScene.class, r1);
        }

        public AccessControlScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$CheckType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CacheCheck", "AsyncCheck", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckType extends Enum<CheckType> {
        public static final CheckType AsyncCheck = null;
        public static final CheckType CacheCheck = null;
        public static final /* synthetic */ CheckType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CheckType> getEntries() {
            return b;
        }

        static {
            CheckType r0 = new CheckType("CacheCheck", 0);
            CacheCheck = r0;
            CheckType r1 = new CheckType("AsyncCheck", 1);
            AsyncCheck = r1;
            CheckType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static CheckType[] values() {
            return (CheckType[]) a.clone();
        }

        public static CheckType valueOf(String r1) {
            return (CheckType) r27.a.a(CheckType.class, r1);
        }

        public CheckType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$NoPermissionEvent;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MFA_CHECK_STATUS", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NoPermissionEvent extends Enum<NoPermissionEvent> {
        public static final NoPermissionEvent MFA_CHECK_STATUS = null;
        public static final /* synthetic */ NoPermissionEvent[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<NoPermissionEvent> getEntries() {
            return b;
        }

        static {
            NoPermissionEvent r0 = new NoPermissionEvent();
            MFA_CHECK_STATUS = r0;
            NoPermissionEvent[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public NoPermissionEvent() {
            super("MFA_CHECK_STATUS", 0);
            this.value = "mfa_check_status";
        }

        public static NoPermissionEvent[] values() {
            return (NoPermissionEvent[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static NoPermissionEvent valueOf(String r1) {
            return (NoPermissionEvent) r27.a.a(NoPermissionEvent.class, r1);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$UpdateTrigger;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ColdBoot", "BackToFront", "NetworkChange", "PushNotification", "UIdChange", "NoCacheRetry", "BusinessCheck", "Retry", "DocScene", "DeviceChange", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateTrigger extends Enum<UpdateTrigger> {
        public static final UpdateTrigger BackToFront = null;
        public static final UpdateTrigger BusinessCheck = null;
        public static final UpdateTrigger ColdBoot = null;
        public static final UpdateTrigger DeviceChange = null;
        public static final UpdateTrigger DocScene = null;
        public static final UpdateTrigger NetworkChange = null;
        public static final UpdateTrigger NoCacheRetry = null;
        public static final UpdateTrigger PushNotification = null;
        public static final UpdateTrigger Retry = null;
        public static final UpdateTrigger UIdChange = null;
        public static final /* synthetic */ UpdateTrigger[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UpdateTrigger> getEntries() {
            return b;
        }

        static {
            UpdateTrigger r0 = new UpdateTrigger("ColdBoot", 0);
            ColdBoot = r0;
            UpdateTrigger r1 = new UpdateTrigger("BackToFront", 1);
            BackToFront = r1;
            UpdateTrigger r3 = new UpdateTrigger("NetworkChange", 2);
            NetworkChange = r3;
            UpdateTrigger r5 = new UpdateTrigger("PushNotification", 3);
            PushNotification = r5;
            UpdateTrigger r7 = new UpdateTrigger("UIdChange", 4);
            UIdChange = r7;
            UpdateTrigger r9 = new UpdateTrigger("NoCacheRetry", 5);
            NoCacheRetry = r9;
            UpdateTrigger r11 = new UpdateTrigger("BusinessCheck", 6);
            BusinessCheck = r11;
            UpdateTrigger r13 = new UpdateTrigger("Retry", 7);
            Retry = r13;
            UpdateTrigger r15 = new UpdateTrigger("DocScene", 8);
            DocScene = r15;
            UpdateTrigger r14 = new UpdateTrigger("DeviceChange", 9);
            DeviceChange = r14;
            UpdateTrigger[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static UpdateTrigger[] values() {
            return (UpdateTrigger[]) a.clone();
        }

        public static UpdateTrigger valueOf(String r1) {
            return (UpdateTrigger) r27.a.a(UpdateTrigger.class, r1);
        }

        public UpdateTrigger(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final UpdateTrigger a;
        public final Object b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Object r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "UpdateInfo(trigger=" + this.a + ", info=" + this.b + ')';
        }

        public a(UpdateTrigger r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "trigger");
            this.a = r2;
            this.b = r3;
        }
    }

    public FileAuthMonitor() {
    }

    static {
        a = new UpdateTrigger[]{UpdateTrigger.Retry, UpdateTrigger.BusinessCheck, UpdateTrigger.NoCacheRetry, UpdateTrigger.DocScene};
    }

    public static String a(InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        Object r0 = r3.getInternalParams().get("SDK_MONITOR_TT_LOG_ID");
        if ((r0 instanceof String) == false) goto L5;
        String r1 = (String) r0;
    L6:
        if (r1 != null) goto L15;
        r1 = r3.getTraceId();
        boolean r2 = true;
        if (r3.getSource() == 1) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == true) goto L15;
        return null;
    L10:
        if ((!StringsKt.isBlank(r1)) == false) goto L12;
    L15:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static void b(AccessControlScene r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        String r1 = u4c.a.a;
        u4c.a.a("scs_security_policy_ac_hit_userscope", MapsKt.mapOf(TuplesKt.to("scene", r8.name())), null, null, 0, 28);
    }

    public static void i(String r7) {
        Intrinsics.checkNotNullParameter(r7, "errorInfo");
        String r0 = u4c.a.a;
        u4c.a.a("scs_security_policy_dlp_engine_error", MapsKt.mapOf(TuplesKt.to("errorType", r7)), null, null, 0, 28);
    }

    public static void e(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        String r1 = u4c.a.a;
        u4c.a.a("scs_security_policy_custom_display_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r8)), TuplesKt.to("reason", r9)}), null, null, 0, 28);
    }

    public static /* synthetic */ void h(String r7, long r8) {
        g(r7, 0, r8, null, null, null);
    }

    public static void k(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "pointKey");
        String r1 = u4c.a.a;
        u4c.a.a("scs_security_policy_dynamic_capacity", MapsKt.mapOf(TuplesKt.to("pointKey", r8)), MapsKt.mapOf(TuplesKt.to("current_capacity", Long.valueOf(r9))), null, 0, 24);
    }

    public static void l(String r8, InternalSecurityAction r9) {
        Intrinsics.checkNotNullParameter(r8, "fallbackType");
        String r1 = u4c.a.a;
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("fallbackType", r8);
        if (r9 == null) goto L7;
        DecisionData.Action r10 = r9.getCurrentAction();
        if (r10 == null) goto L7;
        String r11 = r10.toString();
    L8:
        r2[1] = TuplesKt.to("rawAction", r11);
        u4c.a.a("scs_fallback_view", MapsKt.mapOf(r2), null, null, 0, 28);
        return;
    L7:
        r11 = null;
        goto L8
    }

    public static void n(@RegulateDispatcher.ActionFrom String r18, InternalSecurityAction r19) {
        Intrinsics.checkNotNullParameter(r18, "actionSource");
        Intrinsics.checkNotNullParameter(r19, Keys.API_PARAM_KEY_ACTION);
        String r2 = r19.getCurrentAction().getName();
        String r4 = r19.getCurrentAction().getParams().get("style");
        String r5 = a(r19);
        String r6 = r19.getCurrentAction().getParams().get("policyType");
        String r8 = r19.getCurrentAction().getParams().get("containerType");
        m8b.c r10 = com.ss.android.lark.conditional.access.network.model.response.a.b(r19.getCurrentAction());
        boolean r1 = false;
        HashMap r13 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("actionSource", r18), TuplesKt.to("actionName", r2)});
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        r13.put("actionStyle", r4);
    L11:
        if (r5 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        r13.put("logId", r5);
    L19:
        if (r6 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        r13.put("policyType", r6);
    L27:
        if (r8 != null) goto L29;
    L30:
        r1 = true;
    L31:
        if (r1 == true) goto L33;
        r13.put("containerType", r8);
    L33:
        Integer r9 = r10.a;
        if (r9 == null) goto L36;
        r13.put("challengeType", r9);
    L36:
        String r11 = u4c.a.a;
        u4c.a.a("scs_security_policy_handle_action", r13, null, MapsKt.mapOf(TuplesKt.to("actionInfo", r19.toString())), 0, 20);
        return;
    L29:
        if (r8.length() != 0) goto L31;
    L21:
        if (r6.length() == 0) goto L24;
        r7 = false;
        goto L25
    L13:
        if (r5.length() == 0) goto L16;
        r3 = false;
        goto L17
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void s(List r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "factors");
        String r1 = u4c.a.a;
        u4c.a.a("scs_security_policy_factor_query", MapsKt.mapOf(TuplesKt.to("factors", r8)), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r9))), null, 0, 24);
    }

    public static void c(InternalSecurityAction r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "pingSource");
        if (r7 != null) goto L5;
        return;
    L5:
        HashMap r3 = new HashMap();
        if (r9 <= 0) goto L8;
        r3.put("duration", Long.valueOf(r9));
    L8:
        String r10 = a(r7);
        m8b.c r11 = com.ss.android.lark.conditional.access.network.model.response.a.b(r7.getCurrentAction());
        String r0 = u4c.a.a;
        u4c.a.a("scs_access_control", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "ping"), TuplesKt.to(IPortraitService.NAME, r7.getCurrentAction().getName()), TuplesKt.to("policy_type", r7.getCurrentAction().getParams().get("policyType")), TuplesKt.to("challenge_type", r11.a), TuplesKt.to("raw_actions", r7.getRawActions()), TuplesKt.to("ping_source", r8)}), r3, MapsKt.mapOf(TuplesKt.to("log_id", r10)), 0, 16);
    }

    public static void d(InternalSecurityAction r9, String r10, NoPermissionType r11) {
        Intrinsics.checkNotNullParameter(r10, "pageEvent");
        Intrinsics.checkNotNullParameter(r11, "noPermissionType");
        if (r9 != null) goto L5;
        return;
    L5:
        String r0 = a(r9);
        m8b.c r1 = com.ss.android.lark.conditional.access.network.model.response.a.b(r9.getCurrentAction());
        String r2 = u4c.a.a;
        u4c.a.a("scs_access_control", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "access_control_view"), TuplesKt.to("page_event", r10), TuplesKt.to(IPortraitService.NAME, r9.getCurrentAction().getName()), TuplesKt.to("policy_type", r9.getCurrentAction().getParams().get("policyType")), TuplesKt.to("challenge_type", r1.a), TuplesKt.to("raw_actions", r9.getRawActions()), TuplesKt.to("access_control_type", r11.name())}), MapsKt.emptyMap(), MapsKt.mapOf(TuplesKt.to("log_id", r0)), 0, 16);
    }

    public static void j(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "containerType");
        Intrinsics.checkNotNullParameter(r11, "code");
        boolean r3 = false;
        HashMap r5 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("handlerType", "DeviceTokenClaimsChallenge"), TuplesKt.to("containerType", r10), TuplesKt.to(ChameleonOpenTracker.ParamKey.RESULT, "failure"), TuplesKt.to("errorCode", r11)});
        if (r12 != null) goto L5;
    L6:
        r3 = true;
    L7:
        if (r3 == true) goto L9;
        r5.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r12);
    L9:
        u4c.a.a("scs_security_policy_center_action_button", r5, null, null, 0, 28);
        return;
    L5:
        if (r12.length() != 0) goto L7;
        goto L6
    }

    public static void o(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "actionSource");
        Intrinsics.checkNotNullParameter(r11, "actionInfo");
        Intrinsics.checkNotNullParameter(r12, "errorType");
        String r3 = u4c.a.a;
        u4c.a.a("scs_security_policy_handle_action_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("actionSource", r10), TuplesKt.to("errorType", r12)}), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("actionInfo", r11), TuplesKt.to(ChameleonOpenTracker.ParamKey.ERRORMSG, BuildConfig.FLAVOR)}), 0, 20);
    }

    public static void p(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "handlerType");
        Intrinsics.checkNotNullParameter(r10, "containerType");
        String r2 = u4c.a.a;
        u4c.a.a("scs_security_policy_center_action_button", MapsKt.mapOf(new Pair[]{TuplesKt.to("handlerType", r9), TuplesKt.to("containerType", r10), TuplesKt.to("errorInfo", r11)}), null, null, 0, 28);
    }

    public static void f(int r9, long r10, Integer r12, String r13) {
        if (r10 > 0) goto L5;
        return;
    L5:
        HashMap r4 = new HashMap();
        r4.put("event", "rustAsyncGetConfig");
        r4.put("state", Integer.valueOf(r9));
        if (r12 == null) goto L8;
        r4.put("errorCode", r12);
    L8:
        if (r13 == null) goto L10;
        r4.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r13);
    L10:
        String r11 = u4c.a.a;
        u4c.a.a("scs_security_policy_custom_display", r4, MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r10))), null, 0, 24);
    }

    public static void m(PolicyModel r8, com.ss.android.lark.conditional.access.auth.v2.c r9, CheckType r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        Intrinsics.checkNotNullParameter(r9, "filePolicyResult");
        Intrinsics.checkNotNullParameter(r10, "checkType");
        if (r11 >= 0) goto L5;
        return;
    L5:
        String r1 = u4c.a.a;
        u4c.a.a("lark_scs_file_strategy_result", MapsKt.mapOf(new Pair[]{TuplesKt.to(ChameleonOpenTracker.ParamKey.RESULT, r9.h().name()), TuplesKt.to("source", r9.g().name()), TuplesKt.to("operation", r8.getEntity().getEntityOperate()), TuplesKt.to("entityType", r8.getEntity().getEntityType()), TuplesKt.to("entityDomain", r8.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r8.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r8.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(com.ss.android.lark.conditional.access.auth.v2.g.c(r9))), TuplesKt.to("checkType", r10.name())}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r11))), MapsKt.mapOf(TuplesKt.to("info", r8.toString())), 0, 16);
    }

    public static void q(PolicyModel r15, com.ss.android.lark.conditional.access.auth.v2.c r16, CheckType r17, long r18) {
        Intrinsics.checkNotNullParameter(r15, "policyModel");
        Intrinsics.checkNotNullParameter(r16, "filePolicyResult");
        Intrinsics.checkNotNullParameter(r17, "checkType");
        if (r18 >= 0) goto L5;
        return;
    L5:
        String r4 = u4c.a.a;
        u4c.a.a("scs_security_policy_result", MapsKt.mapOf(new Pair[]{TuplesKt.to(ChameleonOpenTracker.ParamKey.RESULT, r16.h().name()), TuplesKt.to("source", r16.g().name()), TuplesKt.to("operation", r15.getEntity().getEntityOperate()), TuplesKt.to("entityType", r15.getEntity().getEntityType()), TuplesKt.to("entityDomain", r15.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r15.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r15.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(com.ss.android.lark.conditional.access.auth.v2.g.c(r16))), TuplesKt.to("checkType", r17.name()), TuplesKt.to("policySetKeys", SequencesKt.joinToString$default(SequencesKt.flatMapIterable(CollectionsKt.asSequence(r16.i()), FileAuthMonitor$reportPolicyResultMergedResult$1.INSTANCE), "|", null, null, 0, null, null, 62, null))}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r18))), MapsKt.mapOf(TuplesKt.to("info", r15.toString())), 0, 16);
    }

    public static void t(PolicyModel r8, ValidateResult r9, CheckType r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        Intrinsics.checkNotNullParameter(r9, "validateResult");
        Intrinsics.checkNotNullParameter(r10, "checkType");
        if (r11 >= 0) goto L5;
        return;
    L5:
        String r1 = u4c.a.a;
        u4c.a.a("scs_security_policy_validate_result", MapsKt.mapOf(new Pair[]{TuplesKt.to(ChameleonOpenTracker.ParamKey.RESULT, r9.getResult().name()), TuplesKt.to("source", r9.getPolicyMethod().name()), TuplesKt.to("operation", r8.getEntity().getEntityOperate()), TuplesKt.to("entityType", r8.getEntity().getEntityType()), TuplesKt.to("entityDomain", r8.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r8.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r8.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(r9.isCredible())), TuplesKt.to("checkType", r10.name())}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r11))), MapsKt.mapOf(TuplesKt.to("info", r8.toString())), 0, 16);
    }

    public static void r(String r11, String r12, UpdateTrigger r13, Set r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "identifier");
        Intrinsics.checkNotNullParameter(r13, "trigger");
        Intrinsics.checkNotNullParameter(r14, "pointKeys");
        Intrinsics.checkNotNullParameter(r15, "notifyType");
        String r4 = u4c.a.a;
        u4c.a.a("scs_security_policy_refresh_center_notify", MapsKt.mapOf(new Pair[]{TuplesKt.to("refreshableScene", r11), TuplesKt.to("identifier", r12), TuplesKt.to("trigger", r13.name()), TuplesKt.to("pointKeys", r14), TuplesKt.to("notifyType", r15)}), null, null, 0, 28);
    }

    public static void g(String r4, int r5, long r6, String r8, Integer r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "path");
        if (r6 > 0) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        r1.put("event", "network");
        r1.put("path", r4);
        r1.put("status", Integer.valueOf(r5));
        if (r8 == null) goto L8;
        r1.put("logId", r8);
    L8:
        if (r9 == null) goto L10;
        r1.put("errorCode", r9);
    L10:
        if (r10 == null) goto L12;
        r1.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r10);
    L12:
        String r7 = u4c.a.a;
        u4c.a.a("scs_security_policy_custom_display", r1, MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r6))), null, 0, 24);
    }
}
