package com.obric.aiagent.product.platform.impl.app;

import android.app.IObricAutoVirtualDisplayRecordSetListener;
import android.app.ObricActivityManager;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/ObricAutoVirtualDisplayRecordSetOfficialApi;", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetCalls;", "<init>", "()V", "retainedListener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "retainedAdapter", "Landroid/app/IObricAutoVirtualDisplayRecordSetListener;", "begin", NameKeys.UnloadStrategy_No_Strategy, "displayId", NameKeys.UnloadStrategy_No_Strategy, "userId", "listener", "add", NameKeys.UnloadStrategy_No_Strategy, "sessionId", "packageNames", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "(J[Ljava/lang/String;)Z", "end", NameKeys.UnloadStrategy_No_Strategy, "getOrCreateAdapter", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoVirtualDisplayRecordSetOfficialApi {
    public static final ObricAutoVirtualDisplayRecordSetOfficialApi INSTANCE = null;
    private static volatile IObricAutoVirtualDisplayRecordSetListener retainedAdapter;
    private static volatile e retainedListener;

    static {
        INSTANCE = new ObricAutoVirtualDisplayRecordSetOfficialApi();
    }

    private ObricAutoVirtualDisplayRecordSetOfficialApi() {
    }

    private final IObricAutoVirtualDisplayRecordSetListener getOrCreateAdapter(final e r2) {
        monitor-enter(this);
        IObricAutoVirtualDisplayRecordSetListener r0 = retainedAdapter;     // Catch: Throwable -> L9
        if (r0 != null) goto L7;
        IObricAutoVirtualDisplayRecordSetListener r1 = new ObricAutoVirtualDisplayRecordSetOfficialApi$getOrCreateAdapter$1$2(r2);     // Catch: Throwable -> L9
        retainedAdapter = r1;     // Catch: Throwable -> L9
        r0 = r1;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public void end(long r1) {
        ObricActivityManager.endAutoVirtualDisplayRecordSet(r1);
    }

    public boolean add(long r2, String[] r4) {
        Intrinsics.checkNotNullParameter(r4, "packageNames");
        return ObricActivityManager.addAutoVirtualDisplayRecordPackages(r2, r4);
    }

    public long begin(int r2, int r3, e r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return ObricActivityManager.beginAutoVirtualDisplayRecordSet(r2, r3, getOrCreateAdapter(r4));
    }
}
