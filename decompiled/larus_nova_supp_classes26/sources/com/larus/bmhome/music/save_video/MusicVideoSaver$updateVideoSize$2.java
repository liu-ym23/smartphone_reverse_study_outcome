package com.larus.bmhome.music.save_video;

import android.media.MediaCodecList;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver$updateVideoSize$2", f = "MusicVideoSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MusicVideoSaver$updateVideoSize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q $config;
    int label;

    public MusicVideoSaver$updateVideoSize$2(q r1, Continuation<? super MusicVideoSaver$updateVideoSize$2> r2) {
        this.$config = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicVideoSaver$updateVideoSize$2(this.$config, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r6);
        a.C0027a r7 = a.i;
        q r0 = this.$config;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "muxerConfig");
        MediaCodecList r8 = new MediaCodecList(0);
        if (r8.findEncoderForFormat(a.C0027a.b(r0)) != null) goto L18;
        List r1 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(1080, 1920), TuplesKt.to(720, 1280), TuplesKt.to(360, 640), TuplesKt.to(240, 320)});
        if (z2.a.enableMusicVideoSizeDowngradeFix() == false) goto L14;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        Pair r3 = (Pair) r2.next();
        Pair r4 = a.C0027a.a(r8, ((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue(), r0);
        r0.b = ((Number) r4.getFirst()).intValue();
        r0.c = ((Number) r4.getSecond()).intValue();
        if (r8.findEncoderForFormat(a.C0027a.b(r0)) == null) goto L10;
    L14:
        Iterator r5 = r1.iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        Pair r9 = (Pair) r5.next();
        Pair r10 = a.C0027a.a(r8, ((Number) r9.getFirst()).intValue(), ((Number) r9.getSecond()).intValue(), r0);
        r0.b = ((Number) r10.getFirst()).intValue();
        r0.c = ((Number) r10.getSecond()).intValue();
        Unit r11 = Unit.INSTANCE;
        r8.findEncoderForFormat(a.C0027a.b(r0));
    L18:
        MusicVideoSaver r12 = MusicVideoSaver.a;
        MusicVideoSaver.h = r0.b;
        MusicVideoSaver.i = r0.c;
        FLogger.a.i("save_music_video", "updateVideoSize, videoWidth:" + r0.b + ", videoHeight:" + r0.c);
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
