package com.bytedance.android.anya;

import com.byted.cast.sink.api.IAPI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "STORE", "Lcom/bytedance/android/anya/BaseMVIDataStore;", "invoke", "com/bytedance/android/anya/BaseMVIDataStore$mutateInternal$1$1"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BaseMVIDataStore$mutateInternal$$inlined$withLock$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $action$inlined;
    final /* synthetic */ com.bytedance.android.anya.internal.f $mutator$inlined;
    final /* synthetic */ com.bytedance.android.anya.internal.l $this_mutateInternal$inlined;
    final /* synthetic */ BaseMVIDataStore this$0;

    public BaseMVIDataStore$mutateInternal$$inlined$withLock$lambda$1(BaseMVIDataStore r1, com.bytedance.android.anya.internal.l r10, Function1 r11, com.bytedance.android.anya.internal.f r12) {
        this.this$0 = r1;
        this.$this_mutateInternal$inlined = r10;
        this.$action$inlined = r11;
        this.$mutator$inlined = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m440invoke() {
        com.bytedance.android.anya.internal.f r0 = this.$mutator$inlined;
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r1 = r0.a;
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r11 = ((LinkedHashMap) r1).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        Object r13 = r12.getKey();
        com.bytedance.android.anya.internal.n r14 = (com.bytedance.android.anya.internal.n) r12.getKey();
        r10.put(r13, new j(r12.getValue(), r14.a(), true));
        goto L4
    L6:
        Iterator<T> r15 = this.this$0.b.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        ((Function2) r15.next()).invoke(r10, this.$this_mutateInternal$inlined.a);
        goto L8
    L10:
        ((LinkedHashMap) r0.a).clear();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m440invoke();
        return Unit.INSTANCE;
    }
}
