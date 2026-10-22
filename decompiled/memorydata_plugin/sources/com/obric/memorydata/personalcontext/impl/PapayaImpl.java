package com.obric.memorydata.personalcontext.impl;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aee.b;
import com.obric.memorydata.middleware.api.aikernel.IPapayaAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/PapayaImpl;", "Lcom/obric/memorydata/middleware/api/aikernel/IPapayaAPI;", "<init>", "()V", "initSuccess", "", "getInst", "setInitState", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "isInit", "getPythonThreadTrace", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PapayaImpl implements IPapayaAPI {
    public static final PapayaImpl INSTANCE = null;
    private static boolean initSuccess;

    static {
        INSTANCE = new PapayaImpl();
    }

    private PapayaImpl() {
    }

    @JvmStatic
    public static final PapayaImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public String getPythonThreadTrace() {
        Object r2 = null;
        if (isInit() == true) goto L18;
        return null;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        PapayaImpl r12 = (PapayaImpl) ZeusTransformUtils.preCheckCast(this, PapayaImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r13 = Result.m1421constructorimpl(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(b.f5869a.a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);
        if (r3 == null) goto L13;
        RunLog.INSTANCE.error("PapayaImpl", "getPythonThreadTrace error", r3);
    L13:
        if (Result.m1427isFailureimpl(r13) == true) goto L17;
        r2 = r13;
    L17:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public boolean isInit() {
        return initSuccess;
    }

    @Override // com.obric.memorydata.middleware.api.aikernel.IPapayaAPI
    public void setInitState(boolean r1) {
        initSuccess = r1;
    }
}
