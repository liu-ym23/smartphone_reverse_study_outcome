package com.larus.uaigc.spring.component;

import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.service.z2;
import com.larus.uaigc.lynx.Scatter;
import com.larus.uaigc.lynx.Segment;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\fH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u001e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001eJ\u001e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014J2\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/uaigc/spring/component/SpringMainVenueShuffleTimesComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "<init>", "()V", "horseShuffleTimesResult", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/larus/uaigc/spring/ability/ShuffleItem;", "beginShuffleTimesResult", "notLotteryShuffleTimesResult", "getHorseShuffleTimesDict", "", "getBeginShuffleTimesDict", "getNotLotteryShuffleTimesDict", "onAttach", "", "handleNonLotteryShuffle", "handleBeginShuffle", "roundNum", "", "handleHorseShuffle", "onCreate", "triggerMainEnterHandleShuffle", "triggerSendMessageHandleShuffle", "triggerNonLotteryHandleShuffle", "segmentId", "triggerBeginHandleShuffle", "triggerHorseHandleShuffle", "hashToUnit", "", "key", "lerp", "min", "max", "t", "clamp", "value", "shuffleTimes", "uniqueId", "salt", "segments", "", "Lcom/larus/uaigc/lynx/Segment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMainVenueShuffleTimesComponent extends BaseContentWidget implements zz9.e {
    public static final /* synthetic */ int p = 0;
    public final ConcurrentHashMap<String, zz9.c> m;
    public final ConcurrentHashMap<String, zz9.c> n;
    public final ConcurrentHashMap<String, zz9.c> o;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((Segment) r2).getPriority(), ((Segment) r1).getPriority());
        }
    }

    static {
    }

    @Override // zz9.e
    public final void BD() {
        B3("delay_request_interval_ms");
        z3("delay_request_interval_ms");
        if (z2.a.enableNonLotteryShuffle() == false) goto L6;
        C3("delay_request_interval_ms");
        return;
    }

    public final void m3() {
        String r0 = com.larus.platform.service.o.a.getDeviceId();
        com.larus.uaigc.lynx.j.a.getClass();
        Scatter r1 = com.larus.uaigc.lynx.j.e();
        if (r1 == null) goto L6;
        List<Segment> r2 = r1.getNonLotterySegments();
        if (r2 == null) goto L6;
    L7:
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Segment r5 = (Segment) r4.next();
        if (r5 == null) goto L9;
        r3.add(r5);
        goto L9
    L13:
        FLogger r6 = FLogger.a;
        r6.i("SpringMainVenueShuffleTimesComponent", "[handleNonLotteryShuffle] deviceId: " + r0 + ", segments.size: " + r2.size() + ", filerSegments.size = " + r3.size());
        StringBuilder r7 = new StringBuilder("[handleNonLotteryShuffle] deviceId: ");
        r7.append(r0);
        r7.append(", filerSegments: ");
        r7.append(r3);
        r6.i("SpringMainVenueShuffleTimesComponent", r7.toString());
        if ((!r3.isEmpty()) == false) goto L53;
        Map<String, Integer> r8 = p3(r0.concat("_non_shuffle"), "9999", r3);
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = ((LinkedHashMap) r8).entrySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L40;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        int r13 = ((Number) r11.getValue()).intValue();
        Iterator r14 = r3.iterator();
    L19:
        String r15 = null;
        if (r14.hasNext() == false) goto L24;
        Object r16 = r14.next();
        if (Intrinsics.areEqual(((Segment) r16).getId(), r12) == false) goto L19;
    L25:
        Segment r17 = (Segment) r16;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("[handleNonLotteryShuffle] key = ");
        r19.append(r12);
        r19.append(", value = ");
        r19.append(r13);
        r19.append(", id = ");
        if (r17 == null) goto L28;
        r15 = r17.getId();
    L28:
        r19.append(r15);
        r18.i("SpringMainVenueShuffleTimesComponent", r19.toString());
        if (r17 == null) goto L33;
        Integer r20 = r17.getValidDuration();
        if (r20 == null) goto L33;
        int r21 = r20.intValue();
    L34:
        if (r17 == null) goto L38;
        Integer r22 = r17.getTimes();
        if (r22 == null) goto L38;
        int r23 = r22.intValue();
    L39:
        r9.put(r12, new zz9.c(r13, r21, r23));
    L38:
        r23 = 1;
    L33:
        r21 = 0;
        goto L34
    L24:
        r16 = null;
        goto L25
    L40:
        this.o.putAll(r9);
        return;
    L53:
        return;
    L6:
        r2 = CollectionsKt.emptyList();
        goto L7
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zz9.e.class);
    }

    public SpringMainVenueShuffleTimesComponent() {
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        B3("z_main_enter");
        z3("z_main_enter");
        if (z2.a.enableNonLotteryShuffle() == false) goto L6;
        C3("z_main_enter");
        return;
    }

    @Override // zz9.e
    public final Map<String, zz9.c> Ex() {
        return this.m;
    }

    @Override // zz9.e
    public final Map<String, zz9.c> SH() {
        return this.o;
    }

    @Override // zz9.e
    public final Map<String, zz9.c> T20() {
        return this.n;
    }

    public final void B3(String r10) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L29
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L29
        this.m.clear();     // Catch: Throwable -> L29
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L29
        r5.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] segmentId = ".concat(r10));     // Catch: Throwable -> L29
        IZLotteryService.Companion r0 = IZLotteryService.a;     // Catch: Throwable -> L29
        hy9.g r6 = r0.n();     // Catch: Throwable -> L29
        r5.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] curRound = " + r6);     // Catch: Throwable -> L29
        if (r6 == null) goto L27;
        Integer r2 = r6.d();     // Catch: Throwable -> L29
        if (r2 == null) goto L27;
        int r7 = r2.intValue();     // Catch: Throwable -> L29
        int r1 = r0.u(r7, r10);     // Catch: Throwable -> L29
        com.larus.uaigc.lynx.j.a.getClass();     // Catch: Throwable -> L29
        Iterator r8 = com.larus.uaigc.lynx.j.d().iterator();     // Catch: Throwable -> L29
    L8:
        Object r9 = null;
        if (r8.hasNext() == false) goto L16;
        Object r11 = r8.next();     // Catch: Throwable -> L29
        Segment r12 = (Segment) r11;     // Catch: Throwable -> L29
        if (r12 == null) goto L14;
        r9 = r12.getId();     // Catch: Throwable -> L29
    L14:
        if (Intrinsics.areEqual(r9, r10) == false) goto L8;
        r9 = r11;
    L16:
        Segment r13 = (Segment) r9;     // Catch: Throwable -> L29
        if (r13 == null) goto L26;
        Integer r14 = r13.getTimes();     // Catch: Throwable -> L29
        if (r14 == null) goto L21;
        int r15 = r14.intValue();     // Catch: Throwable -> L29
    L22:
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L29
        r16.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] localHorseShuffleTimes = " + r1 + ", pollingHorseShuffleTimes = " + r15 + ", roundNum = " + r7);     // Catch: Throwable -> L29
        if (r15 <= r1) goto L25;
        r16.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] already not happen shuffle in current round, handle shuffle");     // Catch: Throwable -> L29
        h3(r7);     // Catch: Throwable -> L29
        goto L27
    L25:
        r16.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] already happen shuffle in current round, not to handle shuffle");     // Catch: Throwable -> L29
        goto L27
    L21:
        r15 = 1;
        goto L22
    L26:
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] not find segment of id is " + r10);     // Catch: Throwable -> L29
    L27:
        long r17 = System.currentTimeMillis() - r4;     // Catch: Throwable -> L29
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] total cost = " + r17);     // Catch: Throwable -> L29
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L40;
        FLogger.a.e("SpringMainVenueShuffleTimesComponent", "[triggerHorseHandleShuffle] error msg: " + r19.getMessage());
        return;
    L40:
        return;
    L29:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }

    public final void C3(String r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L31
        this.o.clear();     // Catch: Throwable -> L31
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] segmentId = ".concat(r8));     // Catch: Throwable -> L31
        com.larus.uaigc.lynx.j.a.getClass();     // Catch: Throwable -> L31
        Scatter r0 = com.larus.uaigc.lynx.j.e();     // Catch: Throwable -> L31
        if (r0 == null) goto L7;
        List<Segment> r1 = r0.getNonLotterySegments();     // Catch: Throwable -> L31
        if (r1 == null) goto L7;
    L8:
        Iterator<T> r4 = r1.iterator();     // Catch: Throwable -> L31
    L9:
        Object r5 = null;
        if (r4.hasNext() == false) goto L17;
        Object r6 = r4.next();     // Catch: Throwable -> L31
        Segment r7 = (Segment) r6;     // Catch: Throwable -> L31
        if (r7 == null) goto L15;
        r5 = r7.getId();     // Catch: Throwable -> L31
    L15:
        if (Intrinsics.areEqual(r5, r8) == false) goto L9;
        r5 = r6;
    L17:
        Segment r9 = (Segment) r5;     // Catch: Throwable -> L31
        if (r9 == null) goto L28;
        int r10 = IZLotteryService.a.x(r8);     // Catch: Throwable -> L31
        Integer r11 = r9.getTimes();     // Catch: Throwable -> L31
        if (r11 == null) goto L22;
        int r12 = r11.intValue();     // Catch: Throwable -> L31
    L23:
        FLogger r13 = FLogger.a;     // Catch: Throwable -> L31
        r13.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] localLotteryShuffle = " + r10 + ", pollingLotteryTimes = " + r12);     // Catch: Throwable -> L31
        if (r12 <= r10) goto L26;
        r13.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] already not happen shuffle in current round, handle shuffle");     // Catch: Throwable -> L31
        m3();     // Catch: Throwable -> L31
    L27:
        r13.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] total cost = " + (System.currentTimeMillis() - r3));     // Catch: Throwable -> L31
    L29:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
        return;
    L26:
        r13.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] already happen shuffle in current round, not to handle shuffle");     // Catch: Throwable -> L31
        goto L27
    L22:
        r12 = 1;
        goto L23
    L28:
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerNotLotteryHandleShuffle] not find segment of id is " + r8);     // Catch: Throwable -> L31
    L7:
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void Y2(int r12) {
        String r0 = com.larus.platform.service.o.a.getDeviceId();
        com.larus.uaigc.lynx.j.a.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        s09.a r3 = PollingConfigService.a.d();     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        Map r4 = r3.a;     // Catch: Throwable -> L16
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("t_scatter");     // Catch: Throwable -> L16
    L10:
        if (o0.d(r5) == false) goto L14;
        List<Segment> r6 = ((Scatter) com.larus.uaigc.lynx.j.b.fromJson(r5, Scatter.class)).getBeginSegment();     // Catch: Throwable -> L16
        if (r6 != null) goto L21;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
    L21:
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        Segment r9 = (Segment) r8.next();
        if (r9 == null) goto L23;
        r7.add(r9);
        goto L23
    L27:
        FLogger r10 = FLogger.a;
        r10.i("SpringMainVenueShuffleTimesComponent", "[handleBeginShuffle] deviceId: " + r0 + ", roundNum: " + r12 + ", segments.size: " + r6.size() + ", filerSegments.size = " + r7.size());
        StringBuilder r11 = new StringBuilder("[handleBeginShuffle] deviceId: ");
        r11.append(r0);
        r11.append(", roundNum: ");
        r11.append(r12);
        r11.append(", filerSegments: ");
        r11.append(r7);
        r10.i("SpringMainVenueShuffleTimesComponent", r11.toString());
        if ((!r7.isEmpty()) == false) goto L73;
        Map<String, Integer> r13 = p3(r0.concat("_begin"), String.valueOf(r12), r7);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r14 = ((LinkedHashMap) r13).entrySet().iterator();
    L31:
        if (r14.hasNext() == false) goto L59;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        int r17 = ((Number) r15.getValue()).intValue();
        Iterator r18 = r7.iterator();
    L34:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((Segment) r19).getId(), r16) == false) goto L34;
    L39:
        Segment r20 = (Segment) r19;
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("[handleBeginShuffle] key = ");
        r22.append(r16);
        r22.append(", value = ");
        r22.append(r17);
        r22.append(", id = ");
        if (r20 == null) goto L42;
        String r110 = r20.getId();
    L43:
        r22.append(r110);
        r22.append(", validDuration = ");
        if (r20 == null) goto L46;
        Integer r111 = r20.getValidDuration();
    L47:
        r22.append(r111);
        r21.i("SpringMainVenueShuffleTimesComponent", r22.toString());
        if (r20 == null) goto L52;
        Integer r23 = r20.getValidDuration();
        if (r23 == null) goto L52;
        int r24 = r23.intValue();
    L53:
        if (r20 == null) goto L57;
        Integer r25 = r20.getTimes();
        if (r25 == null) goto L57;
        int r26 = r25.intValue();
    L58:
        r1.put(r16, new zz9.c(r17, r24, r26));
    L57:
        r26 = 1;
    L52:
        r24 = 0;
        goto L53
    L46:
        r111 = null;
        goto L47
    L42:
        r110 = null;
        goto L43
    L38:
        r19 = null;
        goto L39
    L59:
        this.n.putAll(r1);
        return;
    L73:
        return;
    L14:
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
    L8:
        r5 = null;
    L16:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Throwable r28 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r28 == null) goto L20;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainTimeScatterSegments] failed, error = " + r28);
    L20:
        r6 = CollectionsKt.emptyList();
        goto L21
    }

    @Override // zz9.e
    public final double bB(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        byte[] r9 = MessageDigest.getInstance("SHA-256").digest(r8.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r9);
        Iterator r10 = ArraysKt.take(r9, 8).iterator();
        long r1 = 0;
    L4:
        if (r10.hasNext() == false) goto L7;
        byte r3 = ((Number) r10.next()).byteValue();
        r1 = ULong.constructor-impl(ULong.constructor-impl(r1 << 8) | ULong.constructor-impl(((long) UByte.constructor-impl(r3)) & 255));
        goto L4
    L7:
        return UnsignedKt.ulongToDouble(r1) / UnsignedKt.ulongToDouble(-1);
    }

    public final void h3(int r12) {
        String r0 = com.larus.platform.service.o.a.getDeviceId();
        com.larus.uaigc.lynx.j.a.getClass();
        List r1 = com.larus.uaigc.lynx.j.d();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Segment r4 = (Segment) r3.next();
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        FLogger r5 = FLogger.a;
        r5.i("SpringMainVenueShuffleTimesComponent", "[handleHorseShuffle] deviceId: " + r0 + ", roundNum: " + r12 + ", segments.size: " + r1.size() + ", filerSegments.size = " + r2.size());
        StringBuilder r6 = new StringBuilder("[handleHorseShuffle] deviceId: ");
        r6.append(r0);
        r6.append(", roundNum: ");
        r6.append(r12);
        r6.append(", filerSegments: ");
        r6.append(r2);
        r5.i("SpringMainVenueShuffleTimesComponent", r6.toString());
        if ((!r2.isEmpty()) == false) goto L52;
        Map<String, Integer> r13 = p3(r0.concat("_horse"), String.valueOf(r12), r2);
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r14 = ((LinkedHashMap) r13).entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L39;
        Map.Entry r8 = (Map.Entry) r14.next();
        String r9 = (String) r8.getKey();
        int r10 = ((Number) r8.getValue()).intValue();
        Iterator r11 = r2.iterator();
    L14:
        Integer r15 = null;
        if (r11.hasNext() == false) goto L19;
        Object r16 = r11.next();
        if (Intrinsics.areEqual(((Segment) r16).getId(), r9) == false) goto L14;
    L20:
        Segment r17 = (Segment) r16;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("[handleHorseShuffle] key = ");
        r19.append(r9);
        r19.append(", value = ");
        r19.append(r10);
        r19.append(", id = ");
        if (r17 == null) goto L23;
        String r110 = r17.getId();
    L24:
        r19.append(r110);
        r19.append(", validDuration = ");
        if (r17 == null) goto L27;
        r15 = r17.getValidDuration();
    L27:
        r19.append(r15);
        r18.i("SpringMainVenueShuffleTimesComponent", r19.toString());
        if (r17 == null) goto L32;
        Integer r20 = r17.getValidDuration();
        if (r20 == null) goto L32;
        int r21 = r20.intValue();
    L33:
        if (r17 == null) goto L37;
        Integer r22 = r17.getTimes();
        if (r22 == null) goto L37;
        int r23 = r22.intValue();
    L38:
        r7.put(r9, new zz9.c(r10, r21, r23));
    L37:
        r23 = 1;
    L32:
        r21 = 0;
        goto L33
    L23:
        r110 = null;
        goto L24
    L19:
        r16 = null;
        goto L20
    L39:
        this.m.putAll(r7);
        return;
    }

    public final void z3(String r10) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L40
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L40
        this.n.clear();     // Catch: Throwable -> L40
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L40
        r5.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] segmentId = ".concat(r10));     // Catch: Throwable -> L40
        com.larus.uaigc.lynx.j.a.getClass();     // Catch: Throwable -> L40
        Scatter r0 = com.larus.uaigc.lynx.j.e();     // Catch: Throwable -> L40
        if (r0 == null) goto L8;
        Integer r6 = r0.getLotteryFront();     // Catch: Throwable -> L40
        if (r6 == null) goto L8;
        int r7 = r6.intValue();     // Catch: Throwable -> L40
    L9:
        IZLotteryService.Companion r8 = IZLotteryService.a;     // Catch: Throwable -> L40
        hy9.g r9 = r8.c(r7);     // Catch: Throwable -> L40
        r5.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] curRound = " + r9);     // Catch: Throwable -> L40
        if (r9 == null) goto L38;
        Integer r2 = r9.d();     // Catch: Throwable -> L40
        if (r2 == null) goto L38;
        int r11 = r2.intValue();     // Catch: Throwable -> L40
        int r12 = r8.m(r11, r10);     // Catch: Throwable -> L40
        if (r0 == null) goto L17;
        List<Segment> r1 = r0.getBeginSegment();     // Catch: Throwable -> L40
        if (r1 == null) goto L17;
    L18:
        Iterator<T> r13 = r1.iterator();     // Catch: Throwable -> L40
    L19:
        Object r14 = null;
        if (r13.hasNext() == false) goto L27;
        Object r15 = r13.next();     // Catch: Throwable -> L40
        Segment r16 = (Segment) r15;     // Catch: Throwable -> L40
        if (r16 == null) goto L25;
        r14 = r16.getId();     // Catch: Throwable -> L40
    L25:
        if (Intrinsics.areEqual(r14, r10) == false) goto L19;
        r14 = r15;
    L27:
        Segment r17 = (Segment) r14;     // Catch: Throwable -> L40
        if (r17 == null) goto L37;
        Integer r18 = r17.getTimes();     // Catch: Throwable -> L40
        if (r18 == null) goto L32;
        int r19 = r18.intValue();     // Catch: Throwable -> L40
    L33:
        FLogger r20 = FLogger.a;     // Catch: Throwable -> L40
        r20.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] localLotteryShuffle = " + r12 + ", pollingLotteryTimes = " + r19 + ", roundNum = " + r11);     // Catch: Throwable -> L40
        if (r19 <= r12) goto L36;
        r20.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] already not happen shuffle in current round, handle shuffle");     // Catch: Throwable -> L40
        Y2(r11);     // Catch: Throwable -> L40
        goto L38
    L36:
        r20.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] already happen shuffle in current round, not to handle shuffle");     // Catch: Throwable -> L40
        goto L38
    L32:
        r19 = 1;
        goto L33
    L37:
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] not find segment of id is " + r10);     // Catch: Throwable -> L40
    L17:
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L40
    L38:
        long r21 = System.currentTimeMillis() - r4;     // Catch: Throwable -> L40
        FLogger.a.i("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] total cost = " + r21);     // Catch: Throwable -> L40
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L51;
        FLogger.a.e("SpringMainVenueShuffleTimesComponent", "[triggerBeginHandleShuffle] error msg: " + r111.getMessage());
        return;
    L51:
        return;
    L8:
        r7 = -1;
    L40:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    }

    public final Map<String, Integer> p3(String r22, String r23, List<Segment> r24) {
        Iterator r4 = ((ArrayList) r24).iterator();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r4.hasNext() == false) goto L16;
        Segment r8 = (Segment) r4.next();
        Integer r9 = r8.getMaxMs();
        if (r9 == null) goto L8;
        int r10 = r9.intValue();
    L9:
        r7 = r7 + r10;
        if (Intrinsics.areEqual(r8.getPresenceRate(), 1.0d) == false) goto L4;
        Integer r11 = r8.getMinMs();
        if (r11 == null) goto L14;
        int r12 = r11.intValue();
    L15:
        r6 = r6 + r12;
        goto L4
    L14:
        r12 = 0;
        goto L15
    L8:
        r10 = 0;
        goto L9
    L16:
        int r13 = ((int) (((double) (r7 - r6)) * bB(r22 + "#total#" + r23))) + r6;
        List r3 = CollectionsKt.sortedWith(r24, new b());
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r3.iterator();
    L17:
        char r16 = '#';
        boolean r17 = true;
        if (r15.hasNext() == false) goto L28;
        Segment r18 = (Segment) r15.next();
        double r19 = bB(r22 + '#' + r18.getId() + "#presence#" + r23);
        String r110 = r18.getId();
        if (r110 == null) goto L17;
        Double r20 = r18.getPresenceRate();
        if (r20 == null) goto L17;
        if (r19 < r20.doubleValue()) goto L27;
        r17 = false;
    L27:
        r14.put(r110, Boolean.valueOf(r17));
        goto L17
    L28:
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator r25 = r3.iterator();
        int r111 = 0;
    L30:
        if (r25.hasNext() == false) goto L51;
        Segment r112 = (Segment) r25.next();
        Boolean r113 = (Boolean) r14.get(r112.getId());
        if (r113 == null) goto L34;
        boolean r114 = r113.booleanValue();
    L35:
        if (r114 == false) goto L36;
        double r115 = bB(r22 + r16 + r112.getId() + "#time#" + r23);
        Integer r116 = r112.getMinMs();
        if (r116 == null) goto L42;
        int r117 = r116.intValue();
    L43:
        Integer r118 = r112.getMaxMs();
        if (r118 == null) goto L46;
        int r119 = r118.intValue();
    L47:
        int r120 = r6;
        int r121 = r117 + ((int) (((double) (r119 - r117)) * r115));
        String r26 = r112.getId();
        if (r26 == null) goto L50;
        r21.put(r26, Integer.valueOf(r121));
    L50:
        r111 = r111 + r121;
        r6 = r120;
        r5 = 0;
        r16 = '#';
        goto L30
    L46:
        r119 = 0;
        goto L47
    L42:
        r117 = 0;
        goto L43
    L36:
        String r122 = r112.getId();
        if (r122 == null) goto L30;
        r21.put(r122, Integer.valueOf(r5));
        goto L30
    L34:
        r114 = false;
        goto L35
    L51:
        int r123 = r6;
        int r1 = r13 - r111;
        if (r1 >= 0) goto L86;
        int r2 = -r1;
        ArrayList r27 = new ArrayList();
        Iterator r28 = r3.iterator();
    L55:
        if (r28.hasNext() == false) goto L59;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(r14.get(((Segment) r29).getId()), Boolean.TRUE) == false) goto L55;
        r27.add(r29);
        goto L55
    L59:
        Iterator r30 = CollectionsKt.sortedWith(r27, ComparisonsKt.compareBy(new Function1[]{new b0(), new c0()})).iterator();
    L61:
        if (r30.hasNext() == false) goto L78;
        Segment r31 = (Segment) r30.next();
        if (r2 <= 0) goto L78;
        Integer r32 = (Integer) r21.get(r31.getId());
        if (r32 == null) goto L67;
        int r33 = r32.intValue();
    L68:
        Integer r124 = r31.getMinMs();
        if (r124 == null) goto L71;
        int r125 = r124.intValue();
    L72:
        int r126 = r33 - r125;
        if (r126 <= 0) goto L61;
        int r127 = Math.min(r126, r2);
        String r34 = r31.getId();
        if (r34 == null) goto L77;
        r21.put(r34, Integer.valueOf(r33 - r127));
    L77:
        r2 = r2 - r127;
        goto L61
    L71:
        r125 = 0;
        goto L72
    L67:
        r33 = 0;
    L78:
        if (r2 != 0) goto L80;
        boolean r35 = true;
    L81:
        if (r35 == true) goto L86;
        throw new IllegalStateException("Configuration invalid: totalMin > totalTime".toString());
    L80:
        r35 = false;
    L86:
        if (r1 <= 0) goto L141;
        ArrayList r36 = new ArrayList();
        Iterator r37 = r3.iterator();
    L88:
        double r128 = 0.0d;
        if (r37.hasNext() == false) goto L102;
        Object r38 = r37.next();
        Segment r39 = (Segment) r38;
        Double r40 = r39.getWeight();
        if (r40 == null) goto L93;
        double r129 = r40.doubleValue();
    L95:
        if (Intrinsics.areEqual(r14.get(r39.getId()), Boolean.TRUE) == true) goto L97;
    L99:
        boolean r41 = false;
    L100:
        if (r41 == false) goto L88;
        r36.add(r38);
        goto L88
    L97:
        if (r129 <= 0.0d) goto L99;
        r41 = true;
        goto L100
    L93:
        r129 = 0.0d;
        goto L95
    L102:
        Iterator r42 = r36.iterator();
        double r43 = 0.0d;
    L104:
        if (r42.hasNext() == false) goto L110;
        Double r44 = ((Segment) r42.next()).getWeight();
        if (r44 == null) goto L108;
        double r130 = r44.doubleValue();
    L109:
        r43 = r43 + r130;
        goto L104
    L108:
        r130 = 0.0d;
        goto L109
    L110:
        Iterator r45 = r36.iterator();
        int r46 = 0;
    L112:
        if (r45.hasNext() == false) goto L141;
        int r47 = r46 + 1;
        Segment r131 = (Segment) r45.next();
        Integer r132 = (Integer) r21.get(r131.getId());
        if (r132 == null) goto L116;
        int r133 = r132.intValue();
    L118:
        if (r46 != CollectionsKt.getLastIndex(r36)) goto L120;
        int r48 = r1;
    L125:
        int r49 = r48 + r133;
        Integer r134 = r131.getMinMs();
        if (r134 == null) goto L128;
        int r135 = r134.intValue();
    L129:
        Integer r136 = r131.getMaxMs();
        if (r136 == null) goto L132;
        int r137 = r136.intValue();
    L133:
        if (r49 >= r135) goto L135;
        r49 = r135;
    L137:
        int r138 = r49 - r133;
        String r139 = r131.getId();
        if (r139 == null) goto L140;
        r21.put(r139, Integer.valueOf(r49));
    L140:
        r1 = r1 - r138;
        r46 = r47;
        r128 = 0.0d;
        goto L112
    L135:
        if (r49 <= r137) goto L137;
        r49 = r137;
        goto L137
    L132:
        r137 = 0;
        goto L133
    L128:
        r135 = 0;
        goto L129
    L120:
        Double r50 = r131.getWeight();
        if (r50 == null) goto L123;
        double r140 = r50.doubleValue();
    L124:
        r48 = (int) (((double) r1) * (r140 / r43));
        goto L125
    L123:
        r140 = r128;
        goto L124
    L116:
        r133 = 0;
    L141:
        int r51 = CollectionsKt.sumOfInt(r21.values());
        if (r51 > (r13 + 1)) goto L145;
        if (r51 < r123) goto L145;
        boolean r52 = true;
    L146:
        if (r52 == false) goto L149;
        return r21;
    L149:
        throw new IllegalStateException(("Time allocation failed: finalSum=" + r51 + ", totalTime=" + r13 + ", totalMin=" + r123).toString());
    L145:
        r52 = false;
        goto L146
    }
}
