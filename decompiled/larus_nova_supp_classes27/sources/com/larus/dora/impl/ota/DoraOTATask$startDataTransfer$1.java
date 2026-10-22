package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.connector.g;
import com.larus.dora.impl.ota.g.u;
import com.larus.dora.impl.ota.utils.KeyLogUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import g49.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTATask$startDataTransfer$1", f = "DoraOTATask.kt", i = {0, 1, 2}, l = {788, 790, 820}, m = "invokeSuspend", n = {"packageInfo", "packageInfo", "packageInfo"}, s = {"L$0", "L$0", "L$0"})
final class DoraOTATask$startDataTransfer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ String $linkOwner;
    final /* synthetic */ Function0<Unit> $onTransferCommitted;
    final /* synthetic */ e49.a $responseWrapper;
    Object L$0;
    int label;
    final /* synthetic */ DoraOTATask this$0;

    public static final class a implements com.larus.dora.impl.ota.connector.h {
        public final /* synthetic */ DoraOTATask a;
        public final /* synthetic */ long b;
        public final /* synthetic */ e49.a c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ String e;

        @Override // com.larus.dora.impl.ota.connector.h
        public final void onSuccess(long r14) {
            DoraOTATask r0 = this.a;
            Object r1 = r0.v;
            long r2 = this.b;
            e49.a r4 = this.c;
            Function0<Unit> r5 = this.d;
            String r6 = this.e;
            monitor-enter(r1);
            Long r7 = r0.x;     // Catch: Throwable -> L28
            if (r7 != null) goto L9;
        L10:
            monitor-exit(r1);
            return;
        L9:
            if (r7.longValue() != r2) goto L10;
            r0.u = r0.f.a();     // Catch: Throwable -> L28
            int r3 = KeyLogUtils.a;     // Catch: Throwable -> L28
            KeyLogUtils.LogType r8 = KeyLogUtils.LogType.KEY;     // Catch: Throwable -> L28
            KeyLogUtils.DataLink r9 = KeyLogUtils.DataLink.OTA;     // Catch: Throwable -> L28
            KeyLogUtils.DataFlowDirection r10 = KeyLogUtils.DataFlowDirection.INTERNAL;     // Catch: Throwable -> L28
            KeyLogUtils.a r11 = new KeyLogUtils.a();     // Catch: Throwable -> L28
            z39.a r12 = r4.a;     // Catch: Throwable -> L28
            String r13 = null;
            if (r12 == null) goto L15;
            String r15 = r12.d();     // Catch: Throwable -> L28
        L16:
            r11.a("trace", r15);     // Catch: Throwable -> L28
            z39.a r16 = r4.a;     // Catch: Throwable -> L28
            if (r16 == null) goto L19;
            r13 = r16.c();     // Catch: Throwable -> L28
        L19:
            r11.a("task_id", r13);     // Catch: Throwable -> L28
            KeyLogUtils.a(r8, r9, r10, "ota_upload_end", r11, "-");     // Catch: Throwable -> L28
            if (r5 == null) goto L23;
            r5.invoke();     // Catch: Throwable -> L28
        L23:
            if (DoraOTATask.l(r0) == false) goto L25;
            r0.t(new d49.a.g(r4, r14));     // Catch: Throwable -> L28
        L25:
            int r17 = j69.a.a;     // Catch: Throwable -> L28
            j69.a.b("ota_update_upload", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_upload")))}));     // Catch: Throwable -> L28
            r0.m(r6);     // Catch: Throwable -> L28
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L28
            monitor-exit(r1);
            return;
        L15:
            r15 = null;
        L28:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.dora.impl.ota.connector.h
        public final void b(long r10, int r12) {
            DoraOTATask r1 = this.a;
            Object r2 = r1.v;
            long r3 = this.b;
            e49.a r5 = this.c;
            monitor-enter(r2);
            Long r6 = r1.x;     // Catch: Throwable -> L19
            if (r6 != null) goto L9;
        L10:
            monitor-exit(r2);
            return;
        L9:
            if (r6.longValue() != r3) goto L10;
            if (DoraOTATask.l(r1) == true) goto L16;
            monitor-exit(r2);
            return;
        L16:
            d.d("DoraOTATask0711", "dataTransfer: onProgress progress=" + r12);     // Catch: Throwable -> L19
            r1.t(new d49.a.h(r5, r10, r12));     // Catch: Throwable -> L19
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
            monitor-exit(r2);
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.dora.impl.ota.connector.h
        public final void a(long r12, int r14, String r15) {
            DoraOTATask r13 = this.a;
            Object r0 = r13.v;
            long r1 = this.b;
            String r3 = this.e;
            e49.a r4 = this.c;
            monitor-enter(r0);
            Long r5 = r13.x;     // Catch: Throwable -> L20
            if (r5 != null) goto L9;
        L10:
            monitor-exit(r0);
            return;
        L9:
            if (r5.longValue() != r1) goto L10;
            if (DoraOTATask.l(r13) == true) goto L17;
            r13.m(r3);     // Catch: Throwable -> L20
            monitor-exit(r0);
            return;
        L17:
            r13.u = r13.f.a();     // Catch: Throwable -> L20
            int r2 = KeyLogUtils.a;     // Catch: Throwable -> L20
            KeyLogUtils.a(KeyLogUtils.LogType.ERROR, KeyLogUtils.DataLink.OTA, KeyLogUtils.DataFlowDirection.INTERNAL, "ota_upload_end", null, "failCode=" + r14 + ", failMessage=" + r15);     // Catch: Throwable -> L20
            int r16 = j69.a.a;     // Catch: Throwable -> L20
            StringBuilder r17 = new StringBuilder("upload_package_failure_");     // Catch: Throwable -> L20
            r17.append(r14);     // Catch: Throwable -> L20
            String r18 = r17.toString();     // Catch: Throwable -> L20
            j69.a.d(r18);     // Catch: Throwable -> L20
            r13.s(r4, r18, com.larus.dora.impl.ota.a.C0090a.a);     // Catch: Throwable -> L20
            r13.m(r3);     // Catch: Throwable -> L20
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r0);
            return;
        L20:
            th = move-exception;
            throw th;
        }

        public a(DoraOTATask r1, long r2, e49.a r4, Function0<Unit> r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public DoraOTATask$startDataTransfer$1(e49.a r1, DoraOTATask r2, long r3, String r5, Function0<Unit> r6, Continuation<? super DoraOTATask$startDataTransfer$1> r7) {
        this.$responseWrapper = r1;
        this.this$0 = r2;
        this.$generation = r3;
        this.$linkOwner = r5;
        this.$onTransferCommitted = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DoraOTATask$startDataTransfer$1(this.$responseWrapper, this.this$0, this.$generation, this.$linkOwner, this.$onTransferCommitted, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = this.label;
        if (r7 == 0) goto L12;
        if (r7 == 1) goto L11;
        if (r7 == 2) goto L10;
        if (r7 != 3) goto L9;
        OTAUpdatePackage r3 = (OTAUpdatePackage) this.L$0;
        ResultKt.throwOnFailure(r24);
        OTAUpdatePackage r8 = r3;
        Object r4 = r24;
    L74:
        c r5 = (c) r4;
        DoraOTATask r14 = this.this$0;
        Object r9 = r14.v;
        long r10 = this.$generation;
        String r11 = this.$linkOwner;
        Function0<Unit> r15 = this.$onTransferCommitted;
        e49.a r13 = this.$responseWrapper;
        monitor-enter(r9);
        Long r12 = r14.x;     // Catch: Throwable -> L137
        if (r12 != null) goto L80;
    L81:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L137
        monitor-exit(r9);
        return r0;
    L80:
        if (r12.longValue() != r10) goto L81;
        if (DoraOTATask.l(r14) == true) goto L89;
        r14.m(r11);     // Catch: Throwable -> L137
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L137
        monitor-exit(r9);
        return r1;
    L89:
        d.d("DoraOTATask0711", "startDataTransfer: check=" + r5.a());     // Catch: Throwable -> L137
        if ((r5 instanceof u.e) == false) goto L119;
        d.d("DoraOTATask0711", "startDataTransfer: skip upload because peripheral already prepared, status=" + ((u.e) r5).a);     // Catch: Throwable -> L137
        r14.t = true;     // Catch: Throwable -> L137
        r14.u = 0;     // Catch: Throwable -> L137
        int r2 = j69.a.a;     // Catch: Throwable -> L137
        j69.a.b("ota_update_check", MapsKt.mapOf(TuplesKt.to("step", "end")));     // Catch: Throwable -> L137
        if (r15 == null) goto L95;
        r15.invoke();     // Catch: Throwable -> L137
    L95:
        if (DoraOTATask.l(r14) == false) goto L97;
        r14.t(new d49.a.g(r13, -1));     // Catch: Throwable -> L137
    L97:
        int r16 = KeyLogUtils.a;     // Catch: Throwable -> L137
        KeyLogUtils.LogType r17 = KeyLogUtils.LogType.KEY;     // Catch: Throwable -> L137
        KeyLogUtils.DataLink r18 = KeyLogUtils.DataLink.OTA;     // Catch: Throwable -> L137
        KeyLogUtils.DataFlowDirection r110 = KeyLogUtils.DataFlowDirection.INTERNAL;     // Catch: Throwable -> L137
        KeyLogUtils.a r20 = new KeyLogUtils.a();     // Catch: Throwable -> L137
        z39.a r21 = r13.a;     // Catch: Throwable -> L137
        if (r21 == null) goto L100;
        String r22 = r21.d();     // Catch: Throwable -> L137
    L101:
        r20.a("trace", r22);     // Catch: Throwable -> L137
        z39.a r23 = r13.a;     // Catch: Throwable -> L137
        if (r23 == null) goto L104;
        String r25 = r23.c();     // Catch: Throwable -> L137
    L105:
        r20.a("task_id", r25);     // Catch: Throwable -> L137
        Intrinsics.checkNotNullParameter("skip_upload", "key");     // Catch: Throwable -> L137
        r20.a.put("skip_upload", true);     // Catch: JSONException -> L108 Throwable -> L137
    L110:
        int r26 = ((u.e) r5).a;     // Catch: Throwable -> L137
        Intrinsics.checkNotNullParameter("prepare_status", "key");     // Catch: Throwable -> L137
        r20.a.put("prepare_status", r26);     // Catch: JSONException -> L113 Throwable -> L137
    L115:
        KeyLogUtils.a(r17, r18, r110, "ota_upload_end", r20, "-");     // Catch: Throwable -> L137
        r14.m(r11);     // Catch: Throwable -> L137
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L137
        monitor-exit(r9);
        return r27;
    L113:
        e = move-exception;
        KeyLogUtils.a.b("prepare_status", e);     // Catch: Throwable -> L137
        goto L115
    L108:
        e = move-exception;
        KeyLogUtils.a.b("skip_upload", e);     // Catch: Throwable -> L137
        goto L110
    L104:
        r25 = null;
        goto L105
    L100:
        r22 = null;
        goto L101
    L119:
        if (Intrinsics.areEqual(r5, c.a.a) == false) goto L121;
        int r28 = j69.a.a;     // Catch: Throwable -> L137
        j69.a.b("ota_update_check", MapsKt.mapOf(TuplesKt.to("step", "end")));     // Catch: Throwable -> L137
        j69.b.b("ota_update_upload");     // Catch: Throwable -> L137
        j69.a.b("ota_update_upload", MapsKt.mapOf(TuplesKt.to("step", "start")));     // Catch: Throwable -> L137
        d.d("DoraOTATask0711", "startDataTransfer: ready to start data transfer");     // Catch: Throwable -> L137
        g r30 = r14.f;     // Catch: Throwable -> L137
        String r31 = r14.d.a;     // Catch: Throwable -> L137
        String r32 = r8.getName();     // Catch: Throwable -> L137
        if (r32 != null) goto L133;
        r32 = "";
    L133:
        r30.d(r31, r32, new a(r14, r10, r13, r15, r11));     // Catch: Throwable -> L137
        monitor-exit(r9);
        return Unit.INSTANCE;
    L121:
        if ((r5 instanceof u.a) == false) goto L123;
        u.a r33 = (u.a) r5;     // Catch: Throwable -> L137
    L124:
        if (r33 == null) goto L126;
        int r111 = r33.a;     // Catch: Throwable -> L137
    L127:
        d.d("DoraOTATask0711", "startDataTransfer: report check failed, reason=" + r5.a() + ", retryCount=" + r111);     // Catch: Throwable -> L137
        int r34 = j69.a.a;     // Catch: Throwable -> L137
        j69.a.c(r5.a(), r111);     // Catch: Throwable -> L137
        r14.s(r13, r5.a(), r5);     // Catch: Throwable -> L137
        r14.m(r11);     // Catch: Throwable -> L137
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L137
        monitor-exit(r9);
        return r35;
    L126:
        r111 = 0;
        goto L127
    L123:
        r33 = null;
    L137:
        th = move-exception;
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        OTAUpdatePackage r36 = (OTAUpdatePackage) this.L$0;
        ResultKt.throwOnFailure(r24);
        r8 = r36;
        Object r37 = r24;
    L42:
        c r38 = (c) r37;
    L44:
        if (DoraOTATask.k(this.this$0, this.$generation) == true) goto L48;
        DoraOTATask.i(this.this$0, this.$linkOwner);
        return Unit.INSTANCE;
    L48:
        if (Intrinsics.areEqual(r38, c.a.a) == true) goto L71;
        DoraOTATask r40 = this.this$0;
        Object r41 = r40.v;
        long r42 = this.$generation;
        String r43 = this.$linkOwner;
        e49.a r44 = this.$responseWrapper;
        monitor-enter(r41);
        Long r45 = r40.x;     // Catch: Throwable -> L68
        if (r45 != null) goto L55;
    L56:
        Unit r46 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(r41);
        return r46;
    L55:
        if (r45.longValue() != r42) goto L56;
        if (DoraOTATask.l(r40) == true) goto L64;
        r40.m(r43);     // Catch: Throwable -> L68
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(r41);
        return r47;
    L64:
        d.d("DoraOTATask0711", "startDataTransfer: prepareConnector=" + r38.a());     // Catch: Throwable -> L68
        int r48 = j69.a.a;     // Catch: Throwable -> L68
        j69.a.c(r38.a(), 0);     // Catch: Throwable -> L68
        r40.s(r44, r38.a(), r38);     // Catch: Throwable -> L68
        r40.m(r43);     // Catch: Throwable -> L68
        monitor-exit(r41);
        return Unit.INSTANCE;
    L68:
        th = move-exception;
        throw th;
    L71:
        i69.a r50 = this.this$0.e;
        e49.a r51 = this.$responseWrapper;
        this.L$0 = r8;
        this.label = 3;
        r4 = r50.a(r51, this);
        if (r4 != r6) goto L74;
        return r6;
    L11:
        OTAUpdatePackage r52 = (OTAUpdatePackage) this.L$0;
        ResultKt.throwOnFailure(r24);
        r8 = r52;
        Object r53 = r24;
    L38:
        r38 = (c) r53;
        goto L44
    L12:
        ResultKt.throwOnFailure(r24);
        r8 = e49.b.a(this.$responseWrapper);
        String r112 = this.this$0.d.a;
        if (r8 == null) goto L15;
        String r113 = r8.getName();
    L16:
        if (r113 != null) goto L18;
        r113 = "";
    L18:
        if (r8 == null) goto L20;
        String r114 = r8.getMd5();
    L21:
        if (r114 != null) goto L23;
        r114 = "";
    L23:
        boolean r115 = DownloadUtils.isFileDownloaded(r112, r113, r114, false);
        if (DoraOTATask.k(this.this$0, this.$generation) == false) goto L26;
        d.d("DoraOTATask0711", "startDataTransfer: isFileDownloaded=" + r115);
        if (r8 == null) goto L140;
        if (r115 == false) goto L140;
        String r54 = this.$linkOwner;
        if (r54 == null) goto L39;
        DoraOTAWifiConnector r55 = this.this$0.f;
        if ((r55 instanceof DoraOTAWifiConnector) == false) goto L39;
        this.L$0 = r8;
        this.label = 1;
        int r116 = DoraOTAWifiConnector.i;
        r53 = r55.h(r54, null, this);
        if (r53 != r6) goto L38;
        return r6;
    L39:
        g r56 = this.this$0.f;
        this.L$0 = r8;
        this.label = 2;
        r37 = r56.b(this);
        if (r37 != r6) goto L42;
        return r6;
    L140:
        DoraOTATask r57 = this.this$0;
        Object r58 = r57.v;
        long r60 = this.$generation;
        e49.a r61 = this.$responseWrapper;
        monitor-enter(r58);
        Long r62 = r57.x;     // Catch: Throwable -> L163
        if (r62 != null) goto L146;
    L147:
        Unit r63 = Unit.INSTANCE;     // Catch: Throwable -> L163
        monitor-exit(r58);
        return r63;
    L146:
        if (r62.longValue() != r60) goto L147;
        if (DoraOTATask.l(r57) == true) goto L155;
        Unit r64 = Unit.INSTANCE;     // Catch: Throwable -> L163
        monitor-exit(r58);
        return r64;
    L155:
        d.b("DoraOTATask0711", "startDataTransfer: ota file not exist, isDebug=" + r57.s);     // Catch: Throwable -> L163
        int r65 = j69.a.a;     // Catch: Throwable -> L163
        j69.a.c("ota_file_not_exist", 0);     // Catch: Throwable -> L163
        r57.s(r61, "ota_file_not_exist", null);     // Catch: Throwable -> L163
        if (r57.s == true) goto L160;
        DoraDevice r66 = kj4.a.g().c();     // Catch: Throwable -> L163
        if (r66 == null) goto L160;
        r57.c(r66, DoraOTACheckFrom.FILE_NOT_EXIST, false);     // Catch: Throwable -> L163
    L160:
        monitor-exit(r58);
        return Unit.INSTANCE;
    L163:
        th = move-exception;
        throw th;
    L26:
        return Unit.INSTANCE;
    L20:
        r114 = null;
        goto L21
    L15:
        r113 = null;
        goto L16
    }
}
