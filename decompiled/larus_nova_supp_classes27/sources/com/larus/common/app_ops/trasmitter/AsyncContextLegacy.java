package com.larus.common.app_ops.trasmitter;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/common/app_ops/trasmitter/AsyncContextLegacy;", "Lcom/larus/common/app_ops/trasmitter/AsyncContext;", "<init>", "()V", "map", "", "", "", "preContext", "getPreContext", "()Lcom/larus/common/app_ops/trasmitter/AsyncContextLegacy;", "setPreContext", "(Lcom/larus/common/app_ops/trasmitter/AsyncContextLegacy;)V", "otherThreadPreContext", "getOtherThreadPreContext", "setOtherThreadPreContext", "findPreContext", "addData", "", "key", "value", "remove", "getData", "copy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsyncContextLegacy extends AsyncContext {
    private Map<String, Object> map;
    private volatile AsyncContextLegacy otherThreadPreContext;
    private volatile AsyncContextLegacy preContext;

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public AsyncContextLegacy copy() {
        AsyncContextLegacy r0 = new AsyncContextLegacy();
        Map<String, Object> r1 = this.map;
        if (r1 == null) goto L5;
        Map<String, Object> r2 = MapsKt.toMutableMap(r1);
    L6:
        r0.map = r2;
        r0.preContext = this.preContext;
        r0.otherThreadPreContext = this.otherThreadPreContext;
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public AsyncContext findPreContext() {
        AsyncContextLegacy r0 = this.otherThreadPreContext;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.preContext;
    }

    public AsyncContextLegacy() {
    }

    public final AsyncContextLegacy getOtherThreadPreContext() {
        return this.otherThreadPreContext;
    }

    public final AsyncContextLegacy getPreContext() {
        return this.preContext;
    }

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public /* bridge */ /* synthetic */ AsyncContext copy() {
        return copy();
    }

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public Object getData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, Object> r0 = this.map;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public void remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, Object> r0 = this.map;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    public final void setOtherThreadPreContext(AsyncContextLegacy r1) {
        this.otherThreadPreContext = r1;
    }

    public final void setPreContext(AsyncContextLegacy r1) {
        this.preContext = r1;
    }

    @Override // com.larus.common.app_ops.trasmitter.AsyncContext
    public void addData(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Map<String, Object> r0 = this.map;
        if (r0 != null) goto L5;
        this.map = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r3, r4)});
        return;
    L5:
        if (r0 == null) goto L9;
        r0.put(r3, r4);
        return;
    }
}
