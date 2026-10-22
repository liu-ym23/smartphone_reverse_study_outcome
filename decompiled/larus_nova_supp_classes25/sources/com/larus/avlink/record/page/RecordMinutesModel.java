package com.larus.avlink.record.page;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.minutes.api.IMinutesService;
import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordMinutesModel {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public final Integer c;
    public List<i0> d;
    public volatile Map<String, com.larus.dora.api.offline.record.e> e;
    public final ConcurrentHashMap<String, String> f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MinutesOfflineRecordingDeviceType.values().length];
            r0[MinutesOfflineRecordingDeviceType.GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MinutesOfflineRecordingDeviceType.EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            Long r7 = ((i0) r6).g;
            long r0 = Long.MIN_VALUE;
            if (r7 == null) goto L5;
            long r2 = r7.longValue();
        L6:
            Long r8 = Long.valueOf(r2);
            Long r9 = ((i0) r5).g;
            if (r9 == null) goto L10;
            r0 = r9.longValue();
        L10:
            return ComparisonsKt.compareValues(r8, Long.valueOf(r0));
        L5:
            r2 = Long.MIN_VALUE;
            goto L6
        }
    }

    static {
    }

    public RecordMinutesModel() {
        this.a = LazyKt.lazy(new j0());
        this.b = LazyKt.lazy(new k0());
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L12;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L12;
        Integer r2 = Integer.valueOf(r1.y());
        if (r2.intValue() < 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L13:
        this.c = r2;
        this.d = CollectionsKt.emptyList();
        this.e = MapsKt.emptyMap();
        this.f = new ConcurrentHashMap();
        return;
    L9:
        r3 = false;
    L12:
        r2 = null;
        goto L13
    }

    public final i0 g() {
        long r0 = System.currentTimeMillis();
        return new i0("offline_recording_placeholder", j(null, Long.valueOf(r0)), TagType.OFFLINE_RECORDING, k(Long.valueOf(r0)), Long.valueOf(r0), null, null, null, 928);
    }

    public static String k(Long r8) {
        if (r8 == null) goto L14;
        long r0 = r8.longValue();
        Calendar r9 = com.larus.avlink.record.util.r.a;
        long r2 = System.currentTimeMillis();
        Calendar r10 = com.larus.avlink.record.util.r.a;
        r10.setTimeInMillis(r2);
        Calendar r4 = com.larus.avlink.record.util.r.b;
        r4.setTimeInMillis(r0);
        if (com.larus.avlink.record.util.r.a() == false) goto L6;
        String r11 = AppHost.a.getApplication().getString(2131905623) + ' ' + com.larus.avlink.record.util.r.c.format(Long.valueOf(r0));
    L13:
        if (r11 == null) goto L14;
        return r11;
    L6:
        r10.add(5, -1);
        if (com.larus.avlink.record.util.r.a() == false) goto L9;
        r11 = AppHost.a.getApplication().getString(2131907425) + ' ' + com.larus.avlink.record.util.r.c.format(Long.valueOf(r0));
        goto L13
    L9:
        r10.setTimeInMillis(r2);
        if (r10.get(1) != r4.get(1)) goto L12;
        r11 = com.larus.avlink.record.util.r.d.format(Long.valueOf(r0));
        goto L13
    L12:
        r11 = com.larus.avlink.record.util.r.e.format(Long.valueOf(r0));
    L14:
        return "";
    }

    public final i0 f(String r14) {
        Intrinsics.checkNotNullParameter(r14, "recordingId");
        long r0 = System.currentTimeMillis();
        return new i0(r14, j(null, Long.valueOf(r0)), TagType.RECORDING, k(Long.valueOf(r0)), Long.valueOf(r0), null, null, null, 928);
    }

    public static final Object c(RecordMinutesModel r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof RecordMinutesModel$fetchDoraSdkOfflineRecordings$1) == false) goto L7;
        RecordMinutesModel$fetchDoraSdkOfflineRecordings$1 r0 = (RecordMinutesModel$fetchDoraSdkOfflineRecordings$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L23
    L21:
        Object r11 = Result.constructor-impl((List) r10);     // Catch: Throwable -> L23
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 == null) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "fetch synced list failed: " + r4.getMessage());
    L28:
        List r5 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r11) == false) goto L31;
        r11 = r5;
    L31:
        List r12 = (List) r11;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch synced list, count=" + r12.size());
        LinkedHashMap r6 = new LinkedHashMap(r12.size());
        ArrayList r7 = new ArrayList(r12.size());
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L41;
        com.larus.dora.api.offline.record.e r14 = (com.larus.dora.api.offline.record.e) r13.next();
        if (r14.o.length() != 0) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == true) goto L39;
        String r16 = "external_opus_glasses_" + r14.o.hashCode();
        r6.put(r16, r14);
        r7.add(r8.n(r14, r16));
        goto L33
    L39:
        com.larus.avlink.n1.d("RecordMinutesModel", "skip synced recording with empty path, vuiId=" + r14.a);
        goto L33
    L37:
        r15 = false;
        goto L38
    L41:
        r8.e = r6;
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
        IDoraOfflineRecordSyncService r17 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r17 != null) goto L18;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch synced list skipped, dora record sync service is null");
        r8.e = MapsKt.emptyMap();
        return CollectionsKt.emptyList();
    L18:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L23
        r0.label = 1;     // Catch: Throwable -> L23
        r10 = r17.c(r0);     // Catch: Throwable -> L23
        if (r10 != r2) goto L21;
        return r2;
    L23:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new RecordMinutesModel$fetchDoraSdkOfflineRecordings$1(r8, r9);
        goto L8
    }

    public static final Object d(RecordMinutesModel r13, Continuation r14) {
        r13.getClass();
        if ((r14 instanceof RecordMinutesModel$fetchOfflineRecordings$1) == false) goto L7;
        RecordMinutesModel$fetchOfflineRecordings$1 r0 = (RecordMinutesModel$fetchOfflineRecordings$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L23
    L21:
        Object r16 = Result.constructor-impl((List) r15);     // Catch: Throwable -> L23
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r16);
        if (r4 == null) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "fetch offline list failed: " + r4.getMessage());
    L28:
        List r5 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r16) == false) goto L31;
        r16 = r5;
    L31:
        List r17 = (List) r16;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r17.iterator();
    L33:
        if (r7.hasNext() == false) goto L37;
        Object r8 = r7.next();
        if (((yk9.d) r8).c == true) goto L33;
        r6.add(r8);
        goto L33
    L37:
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch offline list, offlineList count: " + r17.size() + ", filter count: " + r6.size());
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r9 = r6.iterator();
    L39:
        if (r9.hasNext() == false) goto L46;
        yk9.d r10 = (yk9.d) r9.next();
        String r11 = r10.a;
        String r12 = r13.i(r10.e, Long.valueOf(r10.b));
        if (r10.c == false) goto L43;
        TagType r19 = TagType.RECORDING;
    L44:
        r18.add(new i0(r11, r12, r19, k(Long.valueOf(r10.b)), Long.valueOf(r10.b), r10.d, r10.e, null, 544));
        goto L39
    L43:
        r19 = TagType.OFFLINE;
        goto L44
    L46:
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        IMinutesService r110 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r110 != null) goto L18;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch offline list skipped, minutes service is null");
        return CollectionsKt.emptyList();
    L18:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L23
        r0.label = 1;     // Catch: Throwable -> L23
        r15 = r110.x0(r0);     // Catch: Throwable -> L23
        if (r15 != r2) goto L21;
        return r2;
    L23:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new RecordMinutesModel$fetchOfflineRecordings$1(r13, r14);
        goto L8
    }

    public static final void e(RecordMinutesModel r4, String r5) {
        List<i0> r0 = r4.d;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((i0) r3).a, r5) == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4.d = r1;
    }

    public final String h(int r5, Long r6) {
        if (r6 == null) goto L5;
        long r1 = r6.longValue();
    L6:
        Date r0 = new Date(r1);
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        int r8 = com.larus.utils.j0.a;
        return String.format(com.larus.utils.j0.d(r5), Arrays.copyOf(new Object[]{((SimpleDateFormat) this.a.getValue()).format(r0), ((SimpleDateFormat) this.b.getValue()).format(r0)}, 2));
    L5:
        r1 = System.currentTimeMillis();
        goto L6
    }

    public final String i(MinutesOfflineRecordingDeviceType r2, Long r3) {
        if (r2 != null) goto L4;
        int r4 = -1;
    L6:
        if (r4 != 1) goto L8;
        int r5 = 2131902003;
    L13:
        return h(r5, r3);
    L8:
        if (r4 != 2) goto L14;
        r5 = 2131902000;
        goto L13
    L14:
        return j(null, r3);
    L4:
        r4 = b.a[r2.ordinal()];
        goto L6
    }

    public final String j(String r3, Long r4) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L38;
        Integer r5 = this.c;
        if (r5 != null) goto L13;
    L14:
        if (r5 != null) goto L17;
    L19:
        if (r5 != null) goto L22;
    L24:
        if (r5 != null) goto L27;
    L29:
        if (r5 != null) goto L32;
    L34:
        int r6 = 2131902000;
    L37:
        return h(r6, r4);
    L32:
        if (r5.intValue() != 1048578) goto L34;
        r6 = 2131902002;
        goto L37
    L27:
        if (r5.intValue() != 50) goto L29;
        r6 = 2131902001;
        goto L37
    L22:
        if (r5.intValue() != 81) goto L24;
        r6 = 2131901999;
        goto L37
    L17:
        if (r5.intValue() != 17) goto L19;
    L35:
        r6 = 2131902003;
        goto L37
    L13:
        if (r5.intValue() == 16) goto L35;
    L38:
        return r3;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final Object m(String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof RecordMinutesModel$notifyDoraCleanupSyncedRecording$1) == false) goto L7;
        RecordMinutesModel$notifyDoraCleanupSyncedRecording$1 r0 = (RecordMinutesModel$notifyDoraCleanupSyncedRecording$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        String r12 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L36:
        Object r13 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r11).booleanValue()));     // Catch: Throwable -> L14
    L43:
        if (Result.isSuccess-impl(r13) == false) goto L45;
        com.larus.avlink.n1.d("RecordMinutesModel", "dora cleanup after upload success, vuiId=" + r12 + ", result=" + ((Boolean) r13).booleanValue());
    L45:
        Throwable r5 = Result.exceptionOrNull-impl(r13);
        if (r5 == null) goto L48;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup after upload failed, vuiId=" + r12 + ": " + r5.getMessage());
    L48:
        Boolean r6 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r13) == false) goto L52;
        r13 = r6;
    L52:
        if (((Boolean) r13).booleanValue() == true) goto L55;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup incomplete, keep current item, vuiId=" + r12);
        return Boxing.boxBoolean(false);
    L55:
        this.f.remove(r4, r12);
        monitor-enter(this);
        this.e = MapsKt.minus(this.e, r4);     // Catch: Throwable -> L61
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(this);
        return Boxing.boxBoolean(true);
    L61:
        th = move-exception;
        throw th;
    L14:
        Throwable th = th;
        String r7 = r4;
        String r8 = r12;
        r9 = r7;
    L41:
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        String r16 = r8;
        r4 = r9;
        r12 = r16;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        String r17 = this.f.get(r9);
        if (r17 != null) goto L21;
    L24:
        boolean r18 = true;
    L25:
        if (r18 == false) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup skipped, pending vuiId not found, id=" + r9);
        return Boxing.boxBoolean(false);
    L28:
        IDoraOfflineRecordSyncService r19 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r19 != null) goto L68;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup skipped, sync service is null, vuiId=" + r17);
        return Boxing.boxBoolean(false);
    L68:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L39
        r0.L$0 = r9;     // Catch: Throwable -> L39
        r0.L$1 = r17;     // Catch: Throwable -> L39
        r0.label = 1;     // Catch: Throwable -> L39
        Object r21 = r19.b(r17, r0);     // Catch: Throwable -> L39
        if (r21 != r2) goto L35;
        return r2;
    L35:
        r4 = r9;
        r12 = r17;
        r11 = r21;
    L39:
        th = move-exception;
        r8 = r17;
        th = th;
        goto L41
    L21:
        if (StringsKt.isBlank(r17) == true) goto L24;
        r18 = false;
    L7:
        r0 = new RecordMinutesModel$notifyDoraCleanupSyncedRecording$1(this, r10);
        goto L8
    }

    public final i0 n(com.larus.dora.api.offline.record.e r12, String r13) {
        MinutesOfflineRecordingDeviceType r7 = MinutesOfflineRecordingDeviceType.GLASSES;
        return new i0(r13, i(r7, Long.valueOf(r12.d)), TagType.OFFLINE, k(Long.valueOf(r12.d)), Long.valueOf(r12.d), null, r7, null, 672);
    }

    public static final Object a(RecordMinutesModel r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof RecordMinutesModel$deleteExternalOpusRecording$1) == false) goto L7;
        RecordMinutesModel$deleteExternalOpusRecording$1 r0 = (RecordMinutesModel$deleteExternalOpusRecording$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        String r11 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
        String r12 = r11;
        r8 = r4;
        Object r5 = r10;
    L36:
        Object r6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r5).booleanValue()));     // Catch: Throwable -> L38
    L41:
        if (Result.isSuccess-impl(r6) == false) goto L43;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete external opus done, vuiId=" + r12 + ", result=" + ((Boolean) r6).booleanValue());
    L43:
        Throwable r13 = Result.exceptionOrNull-impl(r6);
        if (r13 == null) goto L46;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus failed, vuiId=" + r12 + ": " + r13.getMessage());
    L46:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r6) == false) goto L49;
        r6 = r14;
    L49:
        boolean r15 = ((Boolean) r6).booleanValue();
        if (r15 == false) goto L60;
        r7.f.remove(r8);
        monitor-enter(r7);
        r7.e = MapsKt.minus(r7.e, r8);     // Catch: Throwable -> L56
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r7);
    L56:
        th = move-exception;
        throw th;
    L60:
        return Boxing.boxBoolean(r15);
    L38:
        Throwable th = th;
    L39:
        Result.Companion r17 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        r12 = r11;
        r8 = r4;
        th = th;
        goto L39
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        com.larus.dora.api.offline.record.e r18 = r7.e.get(r8);
        if (r18 == null) goto L21;
        r12 = r18.a;
    L22:
        if (r12 != null) goto L24;
    L27:
        boolean r19 = true;
    L28:
        if (r19 == false) goto L30;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus skipped, vuiId not found, id=" + r8);
        return Boxing.boxBoolean(false);
    L30:
        IDoraOfflineRecordSyncService r20 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r20 != null) goto L63;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus skipped, sync service is null, vuiId=" + r12);
        return Boxing.boxBoolean(false);
    L63:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L38
        r0.L$0 = r8;     // Catch: Throwable -> L38
        r0.L$1 = r12;     // Catch: Throwable -> L38
        r0.label = 1;     // Catch: Throwable -> L38
        r5 = r20.b(r12, r0);     // Catch: Throwable -> L38
        if (r5 != r2) goto L36;
        return r2;
    L24:
        if (StringsKt.isBlank(r12) == true) goto L27;
        r19 = false;
        goto L28
    L21:
        r12 = null;
    L7:
        r0 = new RecordMinutesModel$deleteExternalOpusRecording$1(r7, r9);
        goto L8
    }

    public static List l(List r4, List r5, List r6) {
        ArrayList r1 = new ArrayList();
        Iterator r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r2 = ((i0) r0.next()).a;
        if (r2 == null) goto L4;
        r1.add(r2);
        goto L4
    L8:
        HashSet r3 = CollectionsKt.toHashSet(r1);
        List r7 = r4;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r5.iterator();
    L10:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        String r11 = ((i0) r10).a;
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L10;
        r8.add(r10);
        goto L10
    L14:
        if (r3.contains(r11) == false) goto L17;
        r12 = false;
        goto L18
    L21:
        return CollectionsKt.sortedWith(CollectionsKt.plus(CollectionsKt.plus(r7, r8), r6), new c());
    }

    public static final com.larus.avlink.record.page.a b(RecordMinutesModel r3, List r4, List r5, String r6) {
        List<i0> r7 = r3.d;
        if (r7.isEmpty() == true) goto L5;
    L9:
        List r8 = l(r7, r4, r5);
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch failed, fallback to cache, cacheCount=" + r7.size() + ", offlineCount=" + r4.size() + ", syncedCount=" + r5.size() + ", mergedCount=" + r8.size());
        return new com.larus.avlink.record.page.a.b(r8);
    L5:
        if (r4.isEmpty() == false) goto L9;
        if (r5.isEmpty() == false) goto L9;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch failed, cache/offline/synced list all empty, show error page");
        return new com.larus.avlink.record.page.a.C0022a(r6);
    }
}
