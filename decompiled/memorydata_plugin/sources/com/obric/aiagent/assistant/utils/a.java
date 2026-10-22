package com.obric.aiagent.assistant.utils;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusHelper;", "", "<init>", "()V", "kAssistantPkg", "", "getObricAppStatus", "Lcom/obric/aiagent/assistant/utils/ObricAppStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObricAppStatusSync", "getObricAppStatusFull", "Lcom/obric/aiagent/assistant/utils/ObricAppStatusFull;", "onlySysStatus", "", "getDefaultAssistantState", "Lcom/obric/aiagent/assistant/utils/DefaultAssistantStatus;", "getAppEnableState", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "getAppPrivacyApprovalState", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "getAppLoginState", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5901a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0227a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5902a = null;

        static {
            int[] r0 = new int[PrivacyApprovalStatus.values().length];
            r0[PrivacyApprovalStatus.NotApproved.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PrivacyApprovalStatus.CannotObtain.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PrivacyApprovalStatus.Timeout.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PrivacyApprovalStatus.Approved.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f5902a = r0;
        }
    }

    static {
        f5901a = new a();
    }

    private a() {
    }

    public final DefaultAssistantStatus a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        String r3 = b.f5903a.b(r1);
        if (r3 != null) goto L11;
        return DefaultAssistantStatus.Unknown;
    L11:
        if (Intrinsics.areEqual(r3, "com.larus.nova") == false) goto L15;
        return DefaultAssistantStatus.IsDefaultAssistant;
    L15:
        return DefaultAssistantStatus.NotDefaultAssistant;
    L5:
        return DefaultAssistantStatus.Unknown;
    }

    public final Object a(Context r6, Continuation<? super ObricAppStatus> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ObricAppStatusHelper$getObricAppStatus$1.class) == false) goto L7;
        ObricAppStatusHelper$getObricAppStatus$1 r0 = (ObricAppStatusHelper$getObricAppStatus$1) ZeusTransformUtils.preCheckCast(r9, ObricAppStatusHelper$getObricAppStatus$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (Context) ZeusTransformUtils.preCheckCast(r0.L$0, Context.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L29:
        int r11 = C0227a.f5902a[((PrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(r5, PrivacyApprovalStatus.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r11 == 1) goto L52;
        if (r11 == 2) goto L50;
        if (r11 == 3) goto L50;
        if (r11 != 4) goto L48;
        if (b.f5903a.a(r8) == true) goto L42;
        return ObricAppStatus.UserNoLogin;
    L42:
        if (Intrinsics.areEqual(b.f5903a.b(r8), "com.larus.nova") == true) goto L46;
        return ObricAppStatus.NotRoleAssistant;
    L46:
        return ObricAppStatus.Success;
    L48:
        throw new NoWhenBranchMatchedException();
    L50:
        return ObricAppStatus.PrivacyNotObtainError;
    L52:
        return ObricAppStatus.PrivacyNotApprovalError;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (r8 == null) goto L17;
        AppEnableStatus r12 = b.f5903a.a(r8, "com.larus.nova");
        if (r12 != AppEnableStatus.NoInstalled) goto L23;
        return ObricAppStatus.NoInstalledError;
    L23:
        if (r12 == AppEnableStatus.AppDisabled) goto L25;
        b r13 = b.f5903a;
        r0.L$0 = r8;
        r0.label = 1;
        r5 = r13.a(r8, r0);
        if (r5 != r10) goto L29;
        return r10;
    L25:
        return ObricAppStatus.AppDisabledError;
    L17:
        return ObricAppStatus.Unknown;
    L7:
        r0 = new ObricAppStatusHelper$getObricAppStatus$1(this, r9);
        goto L8
    }
}
