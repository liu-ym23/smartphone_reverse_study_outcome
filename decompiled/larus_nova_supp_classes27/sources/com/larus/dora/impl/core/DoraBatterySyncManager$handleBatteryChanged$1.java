package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.battery.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBatterySyncManager$handleBatteryChanged$1", f = "DoraBatterySyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraBatterySyncManager$handleBatteryChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $battery;
    final /* synthetic */ DoraDevice $currentDevice;
    final /* synthetic */ boolean $forceUpload;
    int label;

    public DoraBatterySyncManager$handleBatteryChanged$1(DoraDevice r1, int[] r2, boolean r3, Continuation<? super DoraBatterySyncManager$handleBatteryChanged$1> r4) {
        this.$currentDevice = r1;
        this.$battery = r2;
        this.$forceUpload = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraBatterySyncManager$handleBatteryChanged$1(this.$currentDevice, this.$battery, this.$forceUpload, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L95;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r1 = i.a;
        DoraDevice r2 = this.$currentDevice;
        int[] r3 = this.$battery;
        if (r3 != null) goto L7;
        r3 = r2.battery;
    L7:
        int r4 = -1;
        boolean r5 = false;
        if (r3 != null) goto L10;
        int[] r7 = null;
    L18:
        if (r7 != null) goto L21;
        Map r6 = MapsKt.emptyMap();
    L76:
        CoroutineScope r8 = i.a;
        DoraDevice r9 = this.$currentDevice;
        boolean r10 = this.$forceUpload;
        if (r6.isEmpty() == false) goto L79;
        i.c = null;
        g49.d.d("DoraBatterySyncManager", "handleBatteryChanged: no valid battery value, skip upload");
    L93:
        return Unit.INSTANCE;
    L79:
        int r11 = r6.hashCode();
        if (r10 == true) goto L87;
        Integer r12 = i.c;
        if (r12 == null) goto L87;
        if (r12.intValue() != r11) goto L87;
        g49.d.d("DoraBatterySyncManager", "handleBatteryChanged: battery not changed, skip upload");
    L87:
        Set r13 = r6.entrySet();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L89:
        if (r15.hasNext() == false) goto L91;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.add(TuplesKt.to(r16.getKey(), r16.getValue()));
        goto L89
    L91:
        BuildersKt.launch$default(i.a, null, null, new DoraBatterySyncManager$syncBatteryInfo$1(r9, r14, r11, r10, "handleBatteryChanged", null), 3, null);
        goto L93
    L21:
        if (o59.a.q(r2) == false) goto L41;
        int[] r17 = o59.a.b(r2);
        int[] r18 = new int[3];
        Lazy r111 = k.a;
        String r112 = r2.sn;
        String r113 = "";
        if (r112 != null) goto L25;
        r112 = "";
    L25:
        r18[0] = k.d(r112, r7, r17, "DoraBatterySyncManager");
        String r20 = r2.sn;
        if (r20 == null) goto L29;
        r113 = r20;
    L29:
        r18[1] = k.f(r113, r7, r17, "DoraBatterySyncManager");
        Integer r21 = ArraysKt.getOrNull(r7, 2);
        if (r21 == null) goto L32;
        int r22 = r21.intValue();
    L33:
        if (r22 < 0) goto L36;
        if (r22 >= 101) goto L36;
        boolean r23 = true;
    L37:
        if (r23 == false) goto L40;
        r4 = k.b(r22);
    L40:
        r18[2] = r4;
        r7 = r18;
    L36:
        r23 = false;
        goto L37
    L32:
        r22 = -1;
    L41:
        r6 = new LinkedHashMap();
        Integer r24 = ArraysKt.getOrNull(r7, 0);
        if (r24 == null) goto L53;
        int r25 = r24.intValue();
        if (1 > r25) goto L47;
        if (r25 >= 101) goto L47;
        boolean r26 = true;
    L48:
        if (r26 == true) goto L51;
        r24 = null;
    L51:
        if (r24 == null) goto L53;
        r6.put("left_battery", String.valueOf(r24.intValue()));
    L47:
        r26 = false;
    L53:
        Integer r27 = ArraysKt.getOrNull(r7, 1);
        if (r27 == null) goto L65;
        int r28 = r27.intValue();
        if (1 > r28) goto L59;
        if (r28 >= 101) goto L59;
        boolean r30 = true;
    L60:
        if (r30 == true) goto L63;
        r27 = null;
    L63:
        if (r27 == null) goto L65;
        r6.put("right_battery", String.valueOf(r27.intValue()));
    L59:
        r30 = false;
    L65:
        Integer r31 = ArraysKt.getOrNull(r7, 2);
        if (r31 == null) goto L76;
        int r32 = r31.intValue();
        if (1 > r32) goto L71;
        if (r32 >= 101) goto L71;
        r5 = true;
    L71:
        if (r5 == true) goto L74;
        r31 = null;
    L74:
        if (r31 == null) goto L76;
        r6.put("case_battery", String.valueOf(r31.intValue()));
        goto L76
    L10:
        r7 = new int[3];
        int r33 = 0;
    L11:
        if (r33 >= 3) goto L18;
        Integer r34 = ArraysKt.getOrNull(r3, r33);
        if (r34 == null) goto L15;
        int r35 = r34.intValue();
    L16:
        r7[r33] = r35;
        r33 = r33 + 1;
        goto L11
    L15:
        r35 = -1;
        goto L16
    L95:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
