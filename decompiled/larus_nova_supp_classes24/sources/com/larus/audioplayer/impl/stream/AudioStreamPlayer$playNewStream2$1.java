package com.larus.audioplayer.impl.stream;

import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IAudioService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$playNewStream2$1", f = "AudioStreamPlayer.kt", i = {0}, l = {645}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
final class AudioStreamPlayer$playNewStream2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $bufferSize;
    final /* synthetic */ Ref.ObjectRef<FileOutputStream> $fileOutputStream;
    final /* synthetic */ String $parsedExportId;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ File $tempFile;
    final /* synthetic */ Ref.LongRef $totalDataSize;
    final /* synthetic */ String $url;
    final /* synthetic */ float $volumeFactor;
    long J$0;
    int label;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.stream.AudioStreamPlayer$playNewStream2$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "id", "", "musicData", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$playNewStream2$1$2", f = "AudioStreamPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<Integer, byte[], Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<FileOutputStream> $fileOutputStream;
        final /* synthetic */ String $parsedExportId;
        final /* synthetic */ File $tempFile;
        final /* synthetic */ Ref.LongRef $totalDataSize;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(String r1, Ref.LongRef r2, Ref.ObjectRef<FileOutputStream> r3, File r4, Continuation<? super AnonymousClass2> r5) {
            this.$parsedExportId = r1;
            this.$totalDataSize = r2;
            this.$fileOutputStream = r3;
            this.$tempFile = r4;
            super(3, r5);
        }

        public final Object invoke(int r7, byte[] r8, Continuation<? super Unit> r9) {
            AnonymousClass2 r10 = new AnonymousClass2(this.$parsedExportId, this.$totalDataSize, this.$fileOutputStream, this.$tempFile, r9);
            r10.L$0 = r8;
            return r10.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke(((Number) r1).intValue(), (byte[]) r2, (Continuation) r3);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r8);
            byte[] r9 = (byte[]) this.L$0;
            IAudioService r0 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
            if (r0 == null) goto L7;
            r0.c0(r9, this.$parsedExportId);
        L7:
            this.$totalDataSize.element += (long) r9.length;
            if (AudioStreamPlayer.s.f() == false) goto L27;
            Ref.ObjectRef<FileOutputStream> r1 = this.$fileOutputStream;
            if (r1.element != null) goto L12;
            r1.element = new PolarisFileOutputStreamWrapper(this.$tempFile);
        L12:
            FileOutputStream r2 = (FileOutputStream) this.$fileOutputStream.element;
            long r3 = SystemClock.elapsedRealtime();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
            if (r2 == null) goto L16;
            r2.write(r9, 0, r9.length);     // Catch: Throwable -> L21
        L16:
            if (r2 == null) goto L18;
            r2.flush();     // Catch: Throwable -> L21
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L21
        L19:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L21
        L23:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L29;
            AudioStreamPlayer r5 = AudioStreamPlayer.a;
            AudioStreamPlayer.C = new Pair(AudioStreamPlayer.j(), Long.valueOf(AudioStreamPlayer.i(AudioStreamPlayer.j())));
            AudioStreamPlayer.e = new Pair(2, "saveStreamToFile error. msg=" + r12);
            AudioStreamPlayer.v(com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR);
            FLogger.a.e("AudioStreamPlayer", "error when save stream data to file. err=" + r12 + " total duration=" + (SystemClock.elapsedRealtime() - r3));
        L29:
            return Unit.INSTANCE;
        L18:
            r10 = null;
        L21:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        L27:
            FLogger.a.e("AudioStreamPlayer", "write data to internal storage!");
            goto L29
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AudioStreamPlayer$playNewStream2$1(String r1, String r2, Ref.LongRef r3, Ref.ObjectRef<FileOutputStream> r4, String r5, Ref.IntRef r6, float r7, File r8, Continuation<? super AudioStreamPlayer$playNewStream2$1> r9) {
        this.$url = r1;
        this.$resourceId = r2;
        this.$totalDataSize = r3;
        this.$fileOutputStream = r4;
        this.$parsedExportId = r5;
        this.$bufferSize = r6;
        this.$volumeFactor = r7;
        this.$tempFile = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AudioStreamPlayer$playNewStream2$1(this.$url, this.$resourceId, this.$totalDataSize, this.$fileOutputStream, this.$parsedExportId, this.$bufferSize, this.$volumeFactor, this.$tempFile, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.audioplayer.impl.stream.q] */
    public final Object invokeSuspend(Object r23) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        long r1 = this.J$0;
        ResultKt.throwOnFailure(r23);
    L16:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("sse chunk request finished totally！total request duration=");
        r3.append(SystemClock.elapsedRealtime() - r1);
        r3.append("ms  totalReadSize=");
        r3.append(this.$totalDataSize.element);
        r3.append(" totalFramesWritten=");
        r3.append(AudioStreamPlayer.o);
        r3.append(" url=");
        Pair<String, String> r4 = AudioStreamPlayer.c;
        if (r4 == null) goto L19;
        String r5 = (String) r4.getFirst();
    L20:
        r3.append(r5);
        r2.i("AudioStreamPlayer", r3.toString());
        FileOutputStream r6 = (FileOutputStream) this.$fileOutputStream.element;
        if (r6 == null) goto L23;
        r6.close();
    L23:
        AudioStreamPlayer.q = false;
        if (AudioStreamPlayer.s.f() == true) goto L27;
        AudioStreamPlayer.p = false;
        r2.i("AudioStreamPlayer", "playNewStream2 exec finished。reset the isQueueChunking");
    L27:
        return Unit.INSTANCE;
    L19:
        r5 = null;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        if (AudioStreamPlayer.s.f() == false) goto L11;
        FLogger.a.i("AudioStreamPlayer", "use the stable internal storage");
    L12:
        AudioStreamPlayer.p = true;
        long r11 = SystemClock.elapsedRealtime();
        AudioStreamPlayer r7 = AudioStreamPlayer.a;
        long r8 = SystemClock.elapsedRealtime();
        String r9 = this.$url;
        final String r10 = this.$resourceId;
        final String r12 = this.$parsedExportId;
        final Ref.IntRef r13 = this.$bufferSize;
        final float r15 = this.$volumeFactor;
        final File r16 = this.$tempFile;
        ?? r17 = new q(r12, r13, r15, r16, r10);
        AnonymousClass2 r19 = new AnonymousClass2(r12, this.$totalDataSize, this.$fileOutputStream, r16, null);
        Function0 r20 = new r();
        this.J$0 = r11;
        this.label = 1;
        if (AudioStreamPlayer.A(r7, r9, r10, r17, r19, r20, 0, 0, r8, false, this, 96) != r14) goto L15;
        return r14;
    L15:
        r1 = r11;
        goto L16
    L11:
        FLogger.a.i("AudioStreamPlayer", "use all internal storage");
        goto L12
    }
}
