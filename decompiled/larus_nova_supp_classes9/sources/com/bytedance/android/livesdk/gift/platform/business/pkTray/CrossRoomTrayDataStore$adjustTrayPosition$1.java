package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.anya.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/anya/n;", "Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/CrossRoomTrayDataStore;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/anya/n;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CrossRoomTrayDataStore$adjustTrayPosition$1 extends Lambda implements Function1<com.bytedance.android.anya.n<CrossRoomTrayDataStore>, Unit> {
    final /* synthetic */ boolean $guestLink;
    final /* synthetic */ CrossRoomTrayDataStore this$0;

    public CrossRoomTrayDataStore$adjustTrayPosition$1(CrossRoomTrayDataStore r1, boolean r2) {
        this.this$0 = r1;
        this.$guestLink = r2;
        super(1);
    }

    public final void invoke(com.bytedance.android.anya.n<CrossRoomTrayDataStore> r6) {
        Intrinsics.checkNotNullParameter(r6, "$receiver");
        String r0 = (String) CollectionsKt.firstOrNull(((LinkedHashMap) this.this$0.g).keySet());
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.$guestLink == false) goto L8;
        t<CrossRoomTrayDataStore, Map<String, Integer>> r1 = this.this$0.q();
        Map r2 = MapsKt.toMutableMap((Map) r6.b(this.this$0.q()));
        int r3 = CrossRoomTrayDataStore.k(this.this$0);
        this.this$0.getClass();
        r2.put(r0, Integer.valueOf(r3 - (s1.y() / 4)));
        Unit r4 = Unit.INSTANCE;
        r6.a(r1, r2);
        return;
    L8:
        t<CrossRoomTrayDataStore, Map<String, Integer>> r5 = this.this$0.q();
        Map r7 = MapsKt.toMutableMap((Map) r6.b(this.this$0.q()));
        r7.put(r0, Integer.valueOf(CrossRoomTrayDataStore.k(this.this$0)));
        Unit r8 = Unit.INSTANCE;
        r6.a(r5, r7);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.anya.n) r1);
        return Unit.INSTANCE;
    }
}
