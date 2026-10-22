package com.larus.bootprotector.mock;

import com.larus.bootprotector.IBootProtectorBizCallback;
import com.larus.bootprotector.entity.LastException;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/bootprotector/mock/BootProtectorDefaultBizCallback;", "Lcom/larus/bootprotector/IBootProtectorBizCallback;", "<init>", "()V", "getBizTag", "", "getObservedCrashPortrait", "", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "onAppCrash", "", "currentCrashCount", "", "matchedPortrait", "exception", "Lcom/larus/bootprotector/entity/LastException;", "onAppRestartAfterCrash", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorDefaultBizCallback implements IBootProtectorBizCallback {

    public static final class a {
    }

    static {
    }

    public BootProtectorDefaultBizCallback() {
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final int d() {
        return 1;
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final String getBizTag() {
        return "default";
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final List<CrashPortrait> b() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void a(LastException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void e(LastException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void c(int r3, CrashPortrait r4, LastException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        nu8.a.e("BootProtectorDefaultCB", "onAppRestartAfterCrash! \ncurrentCrashCount = " + r3 + ", \nmatchedPortrait = " + r4 + ", \nlastException = " + r5);
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void f(int r3, CrashPortrait r4, LastException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        nu8.a.e("BootProtectorDefaultCB", "onAppCrash! \ncurrentCrashCount = " + r3 + ", \nmatchedPortrait = " + r4 + ", \nlastException = " + r5);
    }
}
