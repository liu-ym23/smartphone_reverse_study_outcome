package com.obric.aivoice.core.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aivoice/core/data/IdlErrors;", NameKeys.UnloadStrategy_No_Strategy, "()V", "E_BinderNotReady", NameKeys.UnloadStrategy_No_Strategy, "E_DownloadFailed", "E_InvalidArgument", "E_InvalidMethod", "E_InvalidModelType", "E_InvalidResult", "E_ModelRunFailed", "E_PackResNotReady", "E_TimeOut", "S_NOT_FINISH", "S_OK", "defaultErrInfo", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "getDefaultErrInfo", "()Ljava/util/Map;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdlErrors {
    public static final int E_BinderNotReady = 102;
    public static final int E_DownloadFailed = 104;
    public static final int E_InvalidArgument = 101;
    public static final int E_InvalidMethod = 106;
    public static final int E_InvalidModelType = 103;
    public static final int E_InvalidResult = 108;
    public static final int E_ModelRunFailed = 105;
    public static final int E_PackResNotReady = 109;
    public static final int E_TimeOut = 107;
    public static final IdlErrors INSTANCE = null;
    public static final int S_NOT_FINISH = 1;
    public static final int S_OK = 0;
    private static final Map<Integer, String> defaultErrInfo = null;

    private IdlErrors() {
    }

    static {
        INSTANCE = new IdlErrors();
        defaultErrInfo = MapsKt.mapOf(new Pair[]{TuplesKt.to(106, "invalid method name"), TuplesKt.to(101, "invalid argument"), TuplesKt.to(102, "binder is not ready, or disconnected.")});
    }

    public final Map<Integer, String> getDefaultErrInfo() {
        return defaultErrInfo;
    }
}
