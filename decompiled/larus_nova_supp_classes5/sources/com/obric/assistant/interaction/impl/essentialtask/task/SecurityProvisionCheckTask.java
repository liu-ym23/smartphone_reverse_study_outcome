package com.obric.assistant.interaction.impl.essentialtask.task;

import android.content.Context;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.common.AndroidLogcat;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.obric.assistant.product.api.IObricProduct;
import com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker;
import com.obric.assistant.security.provision.check.bean.CheckState;
import com.obric.assistant.security.provision.check.bean.ProvisionResult;
import com.obric.assistant.t1;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\fH\u0094@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\rJ\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/SecurityProvisionCheckTask;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", DBDefinition.RETRY_COUNT, "", "internalNeedExecute", "", "isNeedDownload", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCheckAndProvision", "canRetry", "getMaxRetryCount", "getRetryDisplayText", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityProvisionCheckTask extends EssentialTask {
    public static final Companion Companion = null;
    public static final int MAX_RETRY_COUNT = 10;
    private static final long[] SILENT_RETRY_BACKOFF_MS = null;
    public static final String TAG = "SecurityProvisionCheckerImpl";
    private volatile int retryCount;

    public int getMaxRetryCount() {
        return 10;
    }

    static {
        Companion = new Companion(null);
        SILENT_RETRY_BACKOFF_MS = new long[]{2000, 4000, 8000};
    }

    private final boolean isNeedDownload() {
        IObricProduct.a.getClass();
        IObricProduct r0 = IObricProduct.a.a();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        boolean r1 = b.a().c("obric_feature_download_certificate");
        FLogger.a.i(TAG, "isNeedDownload() isEnable:" + r1);
        int r2 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "isNeedDownload() isEnable:" + r1);
        return r1;
    }

    public boolean canRetry() {
        if (this.retryCount >= 10) goto L5;
        return true;
    L5:
        return false;
    }

    public String getRetryDisplayText() {
        return AppHost.a.getApplication().getString(2131912401);
    }

    public boolean internalNeedExecute() {
        boolean r0 = t1.a.T();
        FLogger r1 = FLogger.a;
        r1.d(TAG, "internalNeedExecute() isReady:" + r0);
        if (r0 == false) goto L6;
        r1.d(TAG, "process: " + q0.b(getContext()) + " internalNeedExecute() 读取Keva缓存，证书ready，不需要再次执行");
        return false;
    L6:
        boolean r2 = isNeedDownload();
        r1.d(TAG, "internalNeedExecute() needDownload:" + r2);
        int r3 = AndroidLogcat.a;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        AndroidLogcat.c(AndroidLogcat.Level.D, TAG, "internalNeedExecute() needDownload:" + r2);
        if (r2 == true) goto L9;
        return false;
    L9:
        if (b.a().e() == true) goto L13;
        return true;
    L13:
        return false;
    }

    public SecurityProvisionCheckTask(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, "security_provision_check");
    }

    private final Object runCheckAndProvision(Continuation<? super ExecuteResult> r9) {
        if ((r9 instanceof runCheckAndProvision.1) == false) goto L7;
        runCheckAndProvision.1 r0 = (runCheckAndProvision.1) r9;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L34:
        ProvisionResult r11 = (ProvisionResult) r10;
        if (r11.getCode() != 0) goto L38;
        FLogger.a.d(TAG, "证书下载成功，返回success");
        t1.a.x(true);
        return new ExecuteResult.Succeed();
    L38:
        FLogger.a.d(TAG, "证书下载失败，provisionResult=" + r11);
        int r4 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "证书下载失败，provisionResult=" + r11);
        return new ExecuteResult.Failed("code=" + r11.getCode() + ", clientCode=" + r11.getClientCode() + ", msg=" + r11.getMsg());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ISecurityProvisionChecker r5 = (ISecurityProvisionChecker) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        CheckState r12 = (CheckState) r10;
        if (r12.getCode() != 0) goto L28;
        FLogger.a.d(TAG, "process: " + q0.b(getContext()) + " securityProvisionChecker.checkState() 证书ready，直接返回成功");
        t1.a.x(true);
        return new ExecuteResult.Succeed();
    L28:
        if (r12.getCode() != 1) goto L31;
        FLogger.a.d(TAG, "证书检测失败，返回失败，message:" + r12.getMessage());
        int r6 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "证书检测失败，返回失败，message:" + r12.getMessage());
        return new ExecuteResult.Failed(r12.getMessage());
    L31:
        Context r13 = getContext();
        Bundle r7 = new Bundle();
        r0.L$0 = null;
        r0.label = 2;
        r10 = r5.b(r13, r7, r0);
        if (r10 != r2) goto L34;
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        r5 = (ISecurityProvisionChecker) ServiceManager.get().getService(ISecurityProvisionChecker.class);
        if (r5 == null) goto L19;
        Context r14 = getContext();
        r0.L$0 = r5;
        r0.label = 1;
        r10 = r5.a(r14);
        if (r10 != r2) goto L23;
        return r2;
    L19:
        return new ExecuteResult.Failed("ISecurityProvisionChecker is null");
    L7:
        r0 = new runCheckAndProvision.1(this, r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f2 -> B:34:0x00f4). Please report as a decompilation issue!!! */
    public Object internalExecute(Continuation<? super ExecuteResult> r18) {
        if ((r18 instanceof internalExecute.1) == false) goto L7;
        internalExecute.1 r2 = (internalExecute.1) r18;
        int r3 = r2.label;
        if ((r3 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        int r6 = r2.I$1;
        int r8 = r2.I$0;
        long[] r9 = (long[]) r2.L$0;
        ResultKt.throwOnFailure(r1);
        SecurityProvisionCheckTask r10 = this;
        int r7 = r6;
        long[] r11 = r9;
    L34:
        ExecuteResult r12 = (ExecuteResult) r1;
        if (r12.isSuccess() == false) goto L37;
        return r12;
    L37:
        int r13 = r8 + 1;
        int r14 = r7;
    L25:
        if (r13 >= r14) goto L38;
        long r15 = r11[r13];
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("silent retry #");
        int r19 = r13 + 1;
        r17.append(r19);
        r17.append(" after ");
        r17.append(r15);
        r17.append("ms, lastError=");
        r17.append(r12.getErrorInfo());
        r16.i(TAG, r17.toString());
        int r0 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "silent retry #" + r19 + " after " + r15 + "ms, lastError=" + r12.getErrorInfo());
        r2.L$0 = r11;
        r2.I$0 = r13;
        r2.I$1 = r14;
        r2.label = 2;
        if (DelayKt.delay(r15, r2) != r4) goto L29;
        return r4;
    L29:
        int r110 = r13;
        long[] r20 = r11;
        int r21 = r14;
        r8 = r110;
    L30:
        r2.L$0 = r20;
        r2.I$0 = r8;
        r2.I$1 = r21;
        r2.label = 3;
        r1 = r10.runCheckAndProvision(r2);
        if (r1 != r4) goto L33;
        return r4;
    L33:
        r7 = r21;
        r11 = r20;
        goto L34
    L38:
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r21 = r2.I$1;
        r8 = r2.I$0;
        r20 = (long[]) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r10 = this;
        goto L30
    L17:
        ResultKt.throwOnFailure(r1);
    L21:
        r12 = (ExecuteResult) r1;
        this.retryCount++;
        if (r12.isSuccess() == false) goto L24;
        return r12;
    L24:
        r11 = SILENT_RETRY_BACKOFF_MS;
        r14 = r11.length;
        r13 = 0;
        r10 = this;
        goto L25
    L18:
        ResultKt.throwOnFailure(r1);
        r2.label = 1;
        r1 = runCheckAndProvision(r2);
        if (r1 != r4) goto L21;
        return r4;
    L7:
        r2 = new internalExecute.1(this, r18);
        goto L8
    }

    public static final /* synthetic */ Object access$runCheckAndProvision(SecurityProvisionCheckTask r0, Continuation r1) {
        return r0.runCheckAndProvision(r1);
    }
}
