package com.larus.dora.impl.ota;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ota.DoraOTAReporter;
import com.larus.dora.impl.device.ota.EventTypeOTAErrorCode;
import com.larus.dora.impl.device.ota.EventTypeOTAStatus;
import com.larus.dora.impl.device.ota.l0;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.ota.tracker.DoraOTAPreCheckReason;
import com.larus.dora.impl.ota.utils.KeyLogUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import g49.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTATask$download$3", f = "DoraOTATask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOTATask$download$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicBoolean $completed;
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $finish;
    final /* synthetic */ boolean $onlyWifi;
    final /* synthetic */ e49.a $responseWrapper;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraOTATask this$0;

    public static final class a implements IDownloadListener {
        public final /* synthetic */ DoraOTATask a;
        public final /* synthetic */ e49.a b;
        public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> c;
        public final /* synthetic */ AtomicBoolean d;
        public final /* synthetic */ OTAUpdatePackage e;
        public final /* synthetic */ boolean f;

        public final void onCanceled(DownloadInfo r6) {
            d.e("DoraOTATask0711", "download: onCanceled " + r6);
            Job r7 = this.a.o;
            Function0 r0 = null;
            if (r7 == null) goto L5;
            Job.DefaultImpls.cancel$default(r7, null, 1, null);
        L5:
            this.a.r(this.b, "download canceled", com.larus.dora.impl.ota.a.c.a, 1012);
            Object r8 = this.c.element;
            if (r8 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L9:
            r0.invoke();
            return;
        L8:
            r0 = (Function0) r8;
            goto L9
        }

        public final void onFirstStart(DownloadInfo r3) {
            d.d("DoraOTATask0711", "download: onFirstStart " + r3);
        }

        public final void onFirstSuccess(DownloadInfo r3) {
            d.d("DoraOTATask0711", "download: onFirstSuccess " + r3);
        }

        public final void onPause(DownloadInfo r7) {
            d.d("DoraOTATask0711", "download: onPause " + r7);
            DoraOTATask r8 = this.a;
            Object r0 = r8.p;
            AtomicBoolean r1 = this.d;
            Ref.ObjectRef<Function0<Unit>> r2 = this.c;
            monitor-enter(r0);
            boolean r4 = false;
            Function0 r5 = null;
            if (r1.get() == true) goto L18;
            Function0<Unit> r3 = r8.q;     // Catch: Throwable -> L34
            Object r6 = r2.element;     // Catch: Throwable -> L34
            if (r6 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L34
            Function0<Unit> r9 = null;
        L10:
            if (r3 != r9) goto L18;
            if (r8.r == true) goto L15;
            boolean r10 = true;
        L16:
            r8.r = false;     // Catch: Throwable -> L34
            r4 = r10;
            goto L18
        L15:
            r10 = false;
            goto L16
        L9:
            r9 = (Function0) r6;     // Catch: Throwable -> L34
        L18:
            monitor-exit(r0);
            if (r4 == false) goto L28;
            Job r11 = this.a.o;
            if (r11 == null) goto L23;
            Job.DefaultImpls.cancel$default(r11, null, 1, null);
        L23:
            DoraOTATask r12 = this.a;
            e49.a r13 = this.b;
            if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L26;
            c r14 = com.larus.dora.impl.ota.a.c.a;
        L27:
            r12.r(r13, "download canceled", r14, 1012);
            goto L28
        L26:
            r14 = com.larus.dora.impl.ota.a.b.a;
        L28:
            Object r15 = this.c.element;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L32:
            r5.invoke();
            return;
        L31:
            r5 = (Function0) r15;
        L34:
            th = move-exception;
            throw th;
        }

        public final void onPrepare(DownloadInfo r3) {
            d.d("DoraOTATask0711", "download: onPrepare " + r3);
        }

        public final void onProgress(DownloadInfo r4) {
            StringBuilder r0 = new StringBuilder("download: onProgress ");
            if (r4 == null) goto L5;
            Integer r1 = Integer.valueOf(r4.getDownloadProcess());
        L6:
            r0.append(r1);
            r0.append(", ");
            r0.append(r4);
            d.d("DoraOTATask0711", r0.toString());
            if (r4 != null) goto L9;
            return;
        L9:
            DoraOTATask r2 = this.a;
            d49.a.k r3 = new d49.a.k(this.b, r4.getDownloadProcess());
            int r5 = DoraOTATask.z;
            r2.t(r3);
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void onStart(DownloadInfo r3) {
            d.d("DoraOTATask0711", "download: onStart " + r3);
        }

        public final void onSuccessed(DownloadInfo r9) {
            int r0 = KeyLogUtils.a;
            KeyLogUtils.LogType r1 = KeyLogUtils.LogType.KEY;
            KeyLogUtils.DataLink r2 = KeyLogUtils.DataLink.OTA;
            KeyLogUtils.DataFlowDirection r3 = KeyLogUtils.DataFlowDirection.INTERNAL;
            KeyLogUtils.a r5 = new KeyLogUtils.a();
            r5.a("id", String.valueOf(this.e.getId()));
            KeyLogUtils.a(r1, r2, r3, "ota_download_end", r5, "-");
            Function0 r4 = null;
            if (r9 != null) goto L10;
            Object r10 = this.c.element;
            if (r10 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L8:
            r4.invoke();
            return;
        L7:
            r4 = (Function0) r10;
            goto L8
        L10:
            DoraOTATask r11 = this.a;
            d49.a.j r6 = new d49.a.j(this.b);
            int r7 = DoraOTATask.z;
            r11.t(r6);
            int r12 = j69.a.a;
            String r13 = this.e.getUrl();
            if (r13 != null) goto L13;
            r13 = "";
        L13:
            Intrinsics.checkNotNullParameter(r13, "downloadUrl");
            j69.a.b("ota_update_download", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("package_host", j69.a.a(r13)), TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_download")))}));
            DoraOTAReporter.a.f.d = EventTypeOTAStatus.DOWNLOAD_COMPLETED.getCode();
            DoraOTAReporter.d();
            Object r14 = this.c.element;
            if (r14 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L17:
            r4.invoke();
            return;
        L16:
            r4 = (Function0) r14;
            goto L17
        }

        /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.dora.impl.ota.n] */
        public final void onFailed(DownloadInfo r7, BaseException r8) {
            d.c("DoraOTATask0711", "download: onFailed " + r7 + ' ' + r8, r8);
            Function0 r2 = null;
            if (r7 != null) goto L10;
            Object r9 = this.c.element;
            if (r9 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L8:
            r2.invoke();
            return;
        L7:
            r2 = (Function0) r9;
            goto L8
        L10:
            Job r10 = this.a.o;
            if (r10 == null) goto L13;
            Job.DefaultImpls.cancel$default(r10, null, 1, null);
        L13:
            if (r8 == null) goto L15;
            final int r11 = r8.getErrorCode();
        L16:
            d.b("DoraOTATask0711", "download: onFailed failCode=" + r11 + ", onlyWifi=" + this.f);
            if (this.f == true) goto L19;
        L28:
            DoraOTATask r12 = this.a;
            e49.a r1 = this.b;
            int r3 = j69.a.a;
            String r4 = "download_package_failure_" + r11;
            if (r11 != 1013) goto L31;
            c r5 = new com.larus.dora.impl.ota.a.d(this.b);
        L32:
            r12.r(r1, r4, r5, Integer.valueOf(r11));
            Object r13 = this.c.element;
            if (r13 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L36:
            r2.invoke();
            return;
        L35:
            r2 = (Function0) r13;
            goto L36
        L31:
            r5 = com.larus.dora.impl.ota.a.c.a;
            goto L32
        L19:
            if (r11 != 1049) goto L21;
        L22:
            final DoraOTATask r14 = this.a;
            Lazy r6 = com.larus.dora.impl.ota.network.b.a;
            final e49.a r15 = this.b;
            r14.o = com.larus.dora.impl.ota.network.b.a(new n(r14, r15, r11));
            Object r16 = this.c.element;
            if (r16 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("finish");
        L26:
            r2.invoke();
            return;
        L25:
            r2 = (Function0) r16;
            goto L26
        L21:
            if (r11 != 1055) goto L28;
        L15:
            r11 = 1000;
            goto L16
        }

        public final void onRetry(DownloadInfo r3, BaseException r4) {
            d.c("DoraOTATask0711", "download: onRetry " + r3 + ' ' + r4, r4);
        }

        @Deprecated(message = "")
        public final void onRetryDelay(DownloadInfo r3, BaseException r4) {
            d.c("DoraOTATask0711", "download: onRetryDelay " + r3 + ' ' + r4, r4);
        }

        public a(DoraOTATask r1, e49.a r2, Ref.ObjectRef<Function0<Unit>> r3, AtomicBoolean r4, OTAUpdatePackage r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public DoraOTATask$download$3(AtomicBoolean r1, e49.a r2, DoraOTATask r3, boolean r4, Ref.ObjectRef<Function0<Unit>> r5, Continuation<? super DoraOTATask$download$3> r6) {
        this.$completed = r1;
        this.$responseWrapper = r2;
        this.this$0 = r3;
        this.$onlyWifi = r4;
        this.$finish = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DoraOTATask$download$3 r7 = new DoraOTATask$download$3(this.$completed, this.$responseWrapper, this.this$0, this.$onlyWifi, this.$finish, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L105;
        ResultKt.throwOnFailure(r20);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        if (this.$completed.get() == true) goto L7;
        OTAUpdatePackage r9 = e49.b.a(this.$responseWrapper);
        Function0 r10 = null;
        if (r9 != null) goto L16;
        Object r1 = this.$finish.element;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("finish");
    L14:
        r10.invoke();
        return Unit.INSTANCE;
    L13:
        r10 = (Function0) r1;
        goto L14
    L16:
        int r2 = k69.b.a;
        String r3 = this.this$0.d.a;
        Integer r4 = r9.getSize();
        if (r4 == null) goto L19;
        long r5 = r4.intValue();
    L20:
        Intrinsics.checkNotNullParameter(r3, "path");
        long r6 = DownloadUtils.getAvailableSpaceBytes(r3);     // Catch: Throwable -> L23
    L25:
        long r7 = r5 + j0.G2_OTA_SPACE_CHECK_BYTES;
        if (r6 <= r7) goto L28;
        boolean r8 = true;
    L29:
        d.d("DoraOTATask0711", "download: isPhoneSpaceEnough=" + r8);
        if (r8 == true) goto L52;
        DoraOTATask r11 = this.this$0;
        Object r12 = r11.p;
        AtomicBoolean r13 = this.$completed;
        Ref.ObjectRef<Function0<Unit>> r14 = this.$finish;
        e49.a r15 = this.$responseWrapper;
        monitor-enter(r12);
    L49:
        th = move-exception;
        throw th;
    L34:
        if (r13.get() == true) goto L46;
        Function0<Unit> r16 = r11.q;     // Catch: Throwable -> L49
        Object r17 = r14.element;     // Catch: Throwable -> L49
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L49
        Function0<Unit> r18 = null;
    L39:
        if (r16 != r18) goto L46;
        int r21 = j69.a.a;     // Catch: Throwable -> L49
        com.larus.dora.impl.ota.a.f r22 = com.larus.dora.impl.ota.a.f.a;     // Catch: Throwable -> L49
        j69.a.h(DoraOTAPreCheckReason.NOT_ENOUGH_SPACE_ON_PHONE);     // Catch: Throwable -> L49
        l0 r23 = DoraOTAReporter.a.f;     // Catch: Throwable -> L49
        r23.d = EventTypeOTAStatus.FAIL.getCode();     // Catch: Throwable -> L49
        r23.a = EventTypeOTAErrorCode.STORAGE_FULL.getCode();     // Catch: Throwable -> L49
        DoraOTAReporter.d();     // Catch: Throwable -> L49
        r11.r(r15, DoraOTAPreCheckReason.NOT_ENOUGH_SPACE_ON_PHONE, r22, null);     // Catch: Throwable -> L49
        Object r24 = r14.element;     // Catch: Throwable -> L49
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L49
    L45:
        r10.invoke();     // Catch: Throwable -> L49
        goto L46
    L44:
        r10 = (Function0) r24;     // Catch: Throwable -> L49
        goto L45
    L38:
        r18 = (Function0) r17;     // Catch: Throwable -> L49
    L46:
        monitor-exit(r12);
        return Unit.INSTANCE;
    L52:
        DownloadTask r25 = Downloader.with(AppHost.a.getApplication()).url(r9.getUrl()).backUpUrls(r9.getBakUrls()).name(r9.getName()).savePath(this.this$0.d.a).onlyWifi(this.$onlyWifi).md5(r9.getMd5()).retryCount(3).backUpUrlRetryCount(3).force(false).mainThreadListener(new a(this.this$0, this.$responseWrapper, this.$finish, this.$completed, r9, this.$onlyWifi));
        DoraOTATask r26 = this.this$0;     // Catch: Throwable -> L81
        Object r27 = r26.p;     // Catch: Throwable -> L81
        AtomicBoolean r28 = this.$completed;     // Catch: Throwable -> L81
        Ref.ObjectRef<Function0<Unit>> r30 = this.$finish;     // Catch: Throwable -> L81
        e49.a r31 = this.$responseWrapper;     // Catch: Throwable -> L81
        monitor-enter(r27);     // Catch: Throwable -> L81
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L56:
        if (r28.get() == true) goto L76;
        Function0<Unit> r32 = r26.q;     // Catch: Throwable -> L74
        Object r33 = r30.element;     // Catch: Throwable -> L74
        if (r33 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L74
        Function0<Unit> r34 = null;
    L61:
        if (r32 != r34) goto L76;
        int r35 = KeyLogUtils.a;     // Catch: Throwable -> L74
        KeyLogUtils.LogType r36 = KeyLogUtils.LogType.KEY;     // Catch: Throwable -> L74
        KeyLogUtils.DataLink r37 = KeyLogUtils.DataLink.OTA;     // Catch: Throwable -> L74
        KeyLogUtils.DataFlowDirection r110 = KeyLogUtils.DataFlowDirection.INTERNAL;     // Catch: Throwable -> L74
        KeyLogUtils.a r111 = new KeyLogUtils.a();     // Catch: Throwable -> L74
        Intrinsics.checkNotNullParameter("is_pass", "key");     // Catch: Throwable -> L74
        r111.a.put("is_pass", true);     // Catch: JSONException -> L66 Throwable -> L74
    L68:
        KeyLogUtils.a(r36, r37, r110, "ota_download_precheck", r111, "-");     // Catch: Throwable -> L74
        r26.t(new d49.a.f(r31));     // Catch: Throwable -> L74
        int r38 = j69.a.a;     // Catch: Throwable -> L74
        j69.a.b("ota_update_pre_check", MapsKt.emptyMap());     // Catch: Throwable -> L74
        String r40 = r9.getUrl();     // Catch: Throwable -> L74
        if (r40 != null) goto L71;
        r40 = "";
    L71:
        j69.a.f(r40);     // Catch: Throwable -> L74
        KeyLogUtils.a r41 = new KeyLogUtils.a();     // Catch: Throwable -> L74
        r41.a("id", String.valueOf(r9.getId()));     // Catch: Throwable -> L74
        KeyLogUtils.a(r36, r37, r110, "ota_download_start", r41, "-");     // Catch: Throwable -> L74
        int r42 = r25.download();     // Catch: Throwable -> L74
        if (r28.get() == true) goto L76;
        r26.n = Boxing.boxInt(r42);     // Catch: Throwable -> L74
        goto L76
    L66:
        e = move-exception;
        KeyLogUtils.a.b("is_pass", e);     // Catch: Throwable -> L74
        goto L68
    L60:
        r34 = (Function0) r33;     // Catch: Throwable -> L74
    L76:
        Unit r43 = Unit.INSTANCE;     // Catch: Throwable -> L74
        monitor-exit(r27);     // Catch: Throwable -> L81
    L100:
        return Unit.INSTANCE;
    L81:
        th = move-exception;
        DoraOTATask r44 = this.this$0;
        Object r45 = r44.p;
        AtomicBoolean r46 = this.$completed;
        Ref.ObjectRef<Function0<Unit>> r47 = this.$finish;
        e49.a r48 = this.$responseWrapper;
        monitor-enter(r45);
    L101:
        th = move-exception;
        throw th;
    L85:
        if (r46.get() == true) goto L97;
        Function0<Unit> r50 = r44.q;     // Catch: Throwable -> L101
        Object r51 = r47.element;     // Catch: Throwable -> L101
        if (r51 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L101
        Function0<Unit> r52 = null;
    L90:
        if (r50 != r52) goto L97;
        d.c("DoraOTATask0711", "download: start failed", th);     // Catch: Throwable -> L101
        r44.r(r48, "download start failed", com.larus.dora.impl.ota.a.c.a, Boxing.boxInt(1000));     // Catch: Throwable -> L101
        Object r53 = r47.element;     // Catch: Throwable -> L101
        if (r53 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L101
    L96:
        r10.invoke();     // Catch: Throwable -> L101
        goto L97
    L95:
        r10 = (Function0) r53;     // Catch: Throwable -> L101
        goto L96
    L89:
        r52 = (Function0) r51;     // Catch: Throwable -> L101
    L97:
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L101
        goto L100
    L28:
        d.e("DoraOTAUtils", "isPhoneSpaceEnough: space not enough, need " + r7 + ", available " + r6);
        r8 = false;
    L23:
        th = move-exception;
        d.c("DoraOTAUtils", "isPhoneSpaceEnough: getAvailableSpaceBytes ERROR", th);
        r6 = j0.G2_OTA_RECOVERY_BLOCK_FOREVER;
        goto L25
    L19:
        r5 = 0;
        goto L20
    L7:
        return Unit.INSTANCE;
    L105:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
