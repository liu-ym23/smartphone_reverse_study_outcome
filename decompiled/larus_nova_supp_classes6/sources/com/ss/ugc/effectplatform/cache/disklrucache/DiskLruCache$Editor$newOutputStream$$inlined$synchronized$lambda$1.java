package com.ss.ugc.effectplatform.cache.disklrucache;

import a0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/ss/ugc/effectplatform/cache/disklrucache/DiskLruCache$Editor$newOutputStream$2$1"}, k = 3, mv = {1, 1, 16})
final class DiskLruCache$Editor$newOutputStream$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ a.b this$0;

    public DiskLruCache$Editor$newOutputStream$$inlined$synchronized$lambda$1(a.b r1, int r2) {
        this.this$0 = r1;
        this.$index$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m21invoke() {
        b r0 = this.this$0.b;
        r0.a = Boolean.TRUE;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m21invoke();
        return Unit.INSTANCE;
    }
}
