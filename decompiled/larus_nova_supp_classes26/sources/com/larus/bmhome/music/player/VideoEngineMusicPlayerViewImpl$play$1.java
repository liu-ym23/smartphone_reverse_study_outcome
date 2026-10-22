package com.larus.bmhome.music.player;

import android.content.Context;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.platform.api.l4;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl$play$1", f = "VideoEngineMusicPlayerBuilder.kt", i = {0}, l = {447}, m = "invokeSuspend", n = {"realPlay"}, s = {"L$0"})
final class VideoEngineMusicPlayerViewImpl$play$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $byAuto;
    final /* synthetic */ int $toDuration;
    Object L$0;
    int label;
    final /* synthetic */ VideoEngineMusicPlayerViewImpl this$0;

    public static final class a implements l4 {
        public final /* synthetic */ VideoEngineMusicPlayerViewImpl a;
        public final /* synthetic */ int b;

        public a(VideoEngineMusicPlayerViewImpl r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r3, com.larus.video.impl.sdk.a r4) {
            VideoEngineMusicPlayerViewImpl r0 = this.a;
            boolean r1 = VideoEngineMusicPlayerViewImpl.I;
            if (Intrinsics.areEqual(r0.y(), r3) == false) goto L6;
            VideoEngineMusicPlayerViewImpl r5 = this.a;
            r5.g = r4;
            r5.K(this.b, false);
            return;
        }
    }

    public VideoEngineMusicPlayerViewImpl$play$1(VideoEngineMusicPlayerViewImpl r1, int r2, boolean r3, Continuation<? super VideoEngineMusicPlayerViewImpl$play$1> r4) {
        this.this$0 = r1;
        this.$toDuration = r2;
        this.$byAuto = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoEngineMusicPlayerViewImpl$play$1(this.this$0, this.$toDuration, this.$byAuto, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.music.player.z0, java.lang.Object] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Integer r5 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function0 r2 = (Function0) this.L$0;
        ResultKt.throwOnFailure(r11);
        ?? r3 = r2;
    L37:
        com.larus.bmhome.music.repo.a.b r12 = (com.larus.bmhome.music.repo.a.b) r11;
        if (r12 == null) goto L40;
        com.larus.bmhome.music.repo.a.b.C0026b r13 = r12.a();
    L41:
        if (r13 != null) goto L43;
    L45:
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[play] chatMessageId:");
        VideoEngineMusicPlayerViewImpl r7 = this.this$0;
        boolean r8 = VideoEngineMusicPlayerViewImpl.I;
        r6.append(r7.t());
        r6.append(", vid:");
        r6.append(this.this$0.x());
        r6.append(", error");
        r4.d("SimpleMusicPlayerViewImpl", r6.toString());
        this.this$0.H(false);
        t19.s r9 = t19.s.a;
        Context r10 = this.this$0.getViewContext();
        if (r13 != null) goto L48;
    L50:
        this.this$0.G(30037);
        int r14 = 2131906741;
    L51:
        r9.getClass();
        t19.s.b(r10, r14, false);
    L52:
        VideoEngineMusicPlayerViewImpl r15 = this.this$0;
        j r16 = r15.c;
        if (r16 != null) goto L55;
    L57:
        boolean r17 = false;
    L58:
        if (r17 == false) goto L64;
        com.larus.platform.service.o r18 = com.larus.platform.service.o.a;
        Pair[] r19 = new Pair[3];
        r19[0] = TuplesKt.to("bot_id", r15.s());
        r19[1] = TuplesKt.to("song_id", this.this$0.w());
        if (r13 == null) goto L62;
        r5 = r13.a();
    L62:
        r19[2] = TuplesKt.to("risk_result", r5);
        r18.b("music_risk_result", com.larus.utils.f.c(r19));
    L64:
        return Unit.INSTANCE;
    L55:
        if (r16.f != true) goto L57;
        r17 = true;
        goto L58
    L48:
        if (r13.b() == false) goto L50;
        this.this$0.G(30036);
        r14 = 2131908004;
        goto L51
    L43:
        if (r13.c() == false) goto L45;
        r3.invoke();
        goto L52
    L40:
        r13 = null;
        goto L41
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        GlobalAudioObserver r110 = GlobalAudioObserver.a;
        j r20 = this.this$0.c;
        if (r20 == null) goto L11;
        String r21 = r20.j();
    L12:
        r110.e("music", String.valueOf(r21), null);
        this.this$0.k = 0;
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[play] chatMessageId:" + this.this$0.t() + ", vid:" + this.this$0.x() + ", toDuration:" + this.$toDuration + ", byAuto:" + this.$byAuto);
        final VideoEngineMusicPlayerViewImpl r111 = this.this$0;
        final int r22 = this.$toDuration;
        final boolean r23 = this.$byAuto;
        ?? r24 = new z0(r111, r22, r23);
        if (r111.D() == true) goto L65;
        String r112 = this.this$0.w();
        if (r112 != null) goto L17;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == true) goto L65;
        VideoEngineMusicPlayerViewImpl r114 = this.this$0;
        com.larus.bmhome.music.repo.a r25 = r114.j;
        j r115 = r114.c;
        if (r115 == null) goto L26;
        Integer r116 = Integer.valueOf(r115.l());
    L27:
        if (r116 == null) goto L29;
        int r117 = r116.intValue();
    L30:
        String r26 = this.this$0.w();
        if (r26 != null) goto L33;
        r26 = "";
    L33:
        this.L$0 = r24;
        this.label = 1;
        r11 = com.larus.bmhome.music.repo.a.a(r25, r117, r26, this);
        if (r11 != r0) goto L36;
        return r0;
    L36:
        r3 = r24;
        goto L37
    L29:
        r117 = -1;
        goto L30
    L26:
        r116 = null;
        goto L27
    L17:
        if (r112.length() == 0) goto L20;
        r113 = false;
    L65:
        r24.invoke();
        return Unit.INSTANCE;
    L11:
        r21 = null;
        goto L12
    }
}
