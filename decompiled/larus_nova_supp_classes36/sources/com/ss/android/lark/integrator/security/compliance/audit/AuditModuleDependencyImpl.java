package com.ss.android.lark.integrator.security.compliance.audit;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IAuditModuleDependency.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u000201H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00106\u001a\u000201H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(¨\u00069"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/audit/AuditModuleDependencyImpl;", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency;", "<init>", "()V", "accountChangeListenersMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$OnAccountChangedListener;", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/OnUserSwitchListener;", "securityComplianceInternalApi", "Lcom/ss/android/lark/security/compliance/api/subapi/ISecurityComplianceInternalApi;", "kotlin.jvm.PlatformType", "userListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "getUserListApi", "()Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "registerAccountChangedListener", "", "listener", "unRegisterAccountChangedListener", "getDeviceId", "callback", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$IGetDeviceIdCallback;", "getSecurityComplianceDependency", "Lcom/ss/android/lark/auditsdk/ISecurityComplianceDependency;", "getQuotaLimitDependency", "Lcom/ss/android/lark/auditsdk/IQuotaLimitDependency;", "domain", "", "getDomain", "()Ljava/lang/String;", "userAgent", "getUserAgent", "tenantId", "getTenantId", "userId", "getUserId", "session", "getSession", "isLogin", "", "()Z", "isDoubaoEnterpriseUser", "getChatTypeByChatId", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$ChatType;", "chatId", "getMessageSenderInfo", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$MessageSenderInfo;", "messageId", "getUnifiedStorageLimitErrorCode", "", "showUnifiedStorageLimitCTADialog", "activity", "Landroid/app/Activity;", "showQuotaLimitDialog", "errorCode", "isHitStorageQuotaLimit", "Companion", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AuditModuleDependencyImpl implements IAuditModuleDependency {
    public static final a Companion = null;
    public static final String TAG = "OfficeSdkAuditModuleDependencyImpl";
    private final ConcurrentHashMap<IAuditModuleDependency.c, qzb.a> accountChangeListenersMap;
    private final p4c.d securityComplianceInternalApi;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Chat.Type.values().length];
            r0[Chat.Type.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Chat.Type.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Chat.Type.TOPIC_GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Chat.Type.THREAD_DETAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements owa.b {
        public c() {
        }

        public final void a(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
            Log.w(AuditModuleDependencyImpl.TAG, "showExceedTenantQuota skipped in OfficeSDK");
        }

        public final void b(FragmentActivity r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
            Log.w(AuditModuleDependencyImpl.TAG, "showExceedUserOrDepartQuota skipped in OfficeSDK, isDepartment=" + r3);
        }
    }

    public static final class d implements owa.c {
        public final /* synthetic */ AuditModuleDependencyImpl a;

        public final KVRepo b() {
            return AuditModuleDependencyImpl.access$getSecurityComplianceInternalApi$p(this.a).getScsUserKVRepo(false);
        }

        public final List<Integer> getLscSettingAuditValue() {
            return AuditModuleDependencyImpl.access$getSecurityComplianceInternalApi$p(this.a).getLscSettingAuditValue();
        }

        public d(AuditModuleDependencyImpl r1) {
            this.a = r1;
        }

        public final void a(PolicyModel r2) {
            Intrinsics.checkNotNullParameter(r2, "policyModel");
            ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).a(r2);
        }

        public final boolean d(PolicyModel r2) {
            Intrinsics.checkNotNullParameter(r2, "policyModel");
            return ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).d(r2);
        }

        public final ValidateResult e(PolicyModel r2, AuthEntity r3, ValidateConfig r4) {
            Intrinsics.checkNotNullParameter(r2, "policyModel");
            return ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).b(r2, r3, r4);
        }

        public final void c(Map r7, Map r8, Map r9, int r10) {
            Intrinsics.checkNotNullParameter("scs_security_audit", "serviceName");
            AuditModuleDependencyImpl.access$getSecurityComplianceInternalApi$p(this.a).monitorEventV2("scs_security_audit", r7, r8, r9, r10);
        }

        public final void f(PolicyModel[] r3, AuthEntity r4, ValidateConfig r5, m r6) {
            Intrinsics.checkNotNullParameter(r3, "policyModels");
            Intrinsics.checkNotNullParameter(r6, "callback");
            ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).f((PolicyModel[]) Arrays.copyOf(r3, r3.length), r4, r5, r6);
        }

        public final void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r2, "serviceName");
            AuditModuleDependencyImpl.access$getSecurityComplianceInternalApi$p(this.a).monitorEvent(r2, r3, r4, r5);
        }
    }

    public static final class e implements qzb.a {
        public e() {
        }
    }

    static {
        Companion = new a();
    }

    public int getUnifiedStorageLimitErrorCode() {
        return 5612;
    }

    private final yzb.b getUserListApi() {
        return (yzb.b) LarkContext.spiByDwarf(yzb.b.class);
    }

    public owa.b getQuotaLimitDependency() {
        return new c();
    }

    public owa.c getSecurityComplianceDependency() {
        return new d(this);
    }

    public boolean isDoubaoEnterpriseUser() {
        com.ss.android.lark.integrator.security.compliance.c.a.getClass();
        return com.ss.android.lark.integrator.security.compliance.c.a();
    }

    public AuditModuleDependencyImpl() {
        this.accountChangeListenersMap = new ConcurrentHashMap();
        this.securityComplianceInternalApi = (p4c.d) ApiUtils.getApi(p4c.d.class);
    }

    public String getDomain() {
        return jcb.b.c().a("suite_main_domain");
    }

    public String getSession() {
        User r0 = getUserListApi().getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.getSession();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getTenantId() {
        User r0 = getUserListApi().getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.getTenantId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getUserAgent() {
        Application r0 = LarkContext.getApplication();
        yob.e.a().getClass();
        int r1 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        return xoc.a.a(r0);
    }

    public String getUserId() {
        return getUserListApi().d();
    }

    public boolean isLogin() {
        return getUserListApi().isLogin();
    }

    public static final /* synthetic */ p4c.d access$getSecurityComplianceInternalApi$p(AuditModuleDependencyImpl r0) {
        return r0.securityComplianceInternalApi;
    }

    public IAuditModuleDependency.ChatType getChatTypeByChatId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Chat r3 = ((IIMApi) ApiUtils.getApi(IIMApi.class)).getChatById(r2);
        if (r3 == null) goto L21;
        Chat.Type r4 = r3.getType();
        if (r4 != null) goto L8;
        int r5 = -1;
    L10:
        if (r5 == 1) goto L20;
        if (r5 == 2) goto L23;
        if (r5 == 3) goto L23;
        if (r5 == 4) goto L23;
        return IAuditModuleDependency.ChatType.UNKNOWN;
    L23:
        return IAuditModuleDependency.ChatType.GROUP;
    L20:
        return IAuditModuleDependency.ChatType.P2P;
    L8:
        r5 = b.a[r4.ordinal()];
        goto L10
    L21:
        return IAuditModuleDependency.ChatType.UNKNOWN;
    }

    public void getDeviceId(final IAuditModuleDependency.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        r4.onSuccess(r2);
        return;
    L20:
        ((epb.a) ApiUtils.getApi(epb.a.class)).getDeviceId(LarkContext.getApplication(), new AnonymousClass1(r4));
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public IAuditModuleDependency.b getMessageSenderInfo(String r6) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        int r1 = com.ss.android.lark.integrator.security.compliance.audit.a.a;
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Message r7 = ImSdkService.f().ta(CollectionsKt.listOf(r6)).get(r6);
        boolean r0 = false;
        Long r2 = null;
        if (r7 == null) goto L29;
        String r3 = r7.getFromId();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L29;
        String r5 = r7.getFromChatterTenantId();
        if (r5 != null) goto L16;
    L17:
        r0 = true;
    L18:
        if (r0 == true) goto L23;
        Long r8 = StringsKt.toLongOrNull(r7.getFromId());
        String r9 = r7.getFromChatterTenantId();
        if (r9 == null) goto L34;
        r2 = StringsKt.toLongOrNull(r9);
    L34:
        return new IAuditModuleDependency.b(r8, r2);
    L23:
        Chatter r10 = ImSdkService.d().ue(r7.getFromId());
        Long r11 = StringsKt.toLongOrNull(r7.getFromId());
        if (r10 == null) goto L35;
        String r12 = r10.getTenantId();
        if (r12 == null) goto L35;
        r2 = StringsKt.toLongOrNull(r12);
    L35:
        return new IAuditModuleDependency.b(r11, r2);
    L16:
        if (r5.length() != 0) goto L18;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
    L29:
        StringBuilder r13 = new StringBuilder("getMessageSenderInfo fromId=null, message=null:");
        if (r7 != null) goto L32;
        r0 = true;
    L32:
        r13.append(r0);
        Log.w("MessageSenderInfoProvider", r13.toString());
        return null;
    }

    public boolean isHitStorageQuotaLimit(int r4) {
        int r0 = qwa.a.a;
        switch(r4) {
            case 5617: goto L5;
            case 5618: goto L5;
            case 5619: goto L5;
            default: goto L4;
        };
    L4:
        boolean r1 = false;
    L6:
        Log.i("StorageQuotaLimitUtils", "current error code: " + r4 + ", isHitStorageQuotaLimit: " + r1);
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public void registerAccountChangedListener(IAuditModuleDependency.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e r0 = new e();
        this.accountChangeListenersMap.put(r3, r0);
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerUserSwitchListener(r0);
    }

    public void showUnifiedStorageLimitCTADialog(Activity r2) {
        int r0 = qwa.c.a;
        UICallbackExecutor.execute(new qwa.b(r2));
    }

    public void unRegisterAccountChangedListener(IAuditModuleDependency.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        qzb.a r3 = this.accountChangeListenersMap.remove(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).unregisterUserSwitchListener(r3);
    }

    public boolean showQuotaLimitDialog(Activity r4, int r5) {
        int r0 = qwa.a.a;
        if (r4 != null) goto L6;
        Log.e("StorageQuotaLimitUtils", "top activity is null, returns show quota limit dialog.");
        return false;
    L6:
        if (r4.isFinishing() == false) goto L8;
    L26:
        Log.e("StorageQuotaLimitUtils", "activity is finishing or is destroyed, returns show quota limit dialog.");
        return false;
    L8:
        if (r4.isDestroyed() == true) goto L26;
        if ((r4 instanceof LifecycleOwner) == true) goto L14;
        Log.e("StorageQuotaLimitUtils", "activity is is not LifecycleOwner, returns show quota limit dialog.");
        return false;
    L14:
        if ((r4 instanceof FragmentActivity) == false) goto L16;
        FragmentActivity r6 = (FragmentActivity) r4;
    L17:
        if (r6 != null) goto L20;
        Log.e("StorageQuotaLimitUtils", "fragmentActivity is null, returns show quota limit dialog.");
        return false;
    L20:
        switch(r5) {
            case 5617: goto L24;
            case 5618: goto L23;
            case 5619: goto L22;
            default: goto L21;
        };
    L21:
        Log.i("StorageQuotaLimitUtils", "current error code: " + r5 + " is not storage quota limit error code.");
        return false;
    L22:
        owa.a.d().getQuotaLimitDependency().a(r6);
    L25:
        return true;
    L23:
        owa.a.d().getQuotaLimitDependency().b(r6, true);
        goto L25
    L24:
        owa.a.d().getQuotaLimitDependency().b(r6, false);
        goto L25
    L16:
        r6 = null;
        goto L17
    }
}
