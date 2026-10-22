package com.larus.bmhome.music.player;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.StreamingMusicPlayer$startUpdateProgress$1", f = "StreamingMusicPlayerBuilder.kt", i = {0, 1, 1}, l = {758, 770}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u243", "$this$invokeSuspend_u24lambda_u243", "count"}, s = {"L$1", "L$1", "L$2"})
public final class StreamingMusicPlayer$startUpdateProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StreamingMusicPlayer this$0;

    public StreamingMusicPlayer$startUpdateProgress$1(StreamingMusicPlayer r1, Continuation<? super StreamingMusicPlayer$startUpdateProgress$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        StreamingMusicPlayer$startUpdateProgress$1 r0 = new StreamingMusicPlayer$startUpdateProgress$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00b0 -> B:9:0x0025). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r29) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r9 = "StreamingMusicPlayer";
        if (r2 == 0) goto L15;
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L11;
        Ref.IntRef r3 = (Ref.IntRef) this.L$2;
        CoroutineScope r11 = (CoroutineScope) this.L$1;
        StreamingMusicPlayer r12 = (StreamingMusicPlayer) this.L$0;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L137
        StreamingMusicPlayer$startUpdateProgress$1 r14 = this;
    L9:
        StreamingMusicPlayer r13 = r12;
        CoroutineScope r15 = r11;
        String r16 = r9;
        Ref.IntRef r10 = r3;
        Object r4 = r0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L75
        MediaPlayer r5 = StreamingMusicPlayer.q;     // Catch: Throwable -> L75
        if (r5 == null) goto L52;
        int r6 = r5.getCurrentPosition();     // Catch: Throwable -> L75
    L53:
        float r17 = r13.e.c;     // Catch: Throwable -> L75
        if (r17 <= 0.0f) goto L56;
        float r7 = r17;
    L58:
        if (r17 != 60000.0f) goto L60;
        boolean r8 = true;
    L61:
        if (r8 == false) goto L77;
        j r18 = r13.c;     // Catch: Throwable -> L75
        if (r18 == null) goto L65;
        String r19 = r18.p();     // Catch: Throwable -> L75
    L67:
        if (TextUtils.isEmpty(r19) == true) goto L77;
        Lazy r20 = q3.a;     // Catch: Throwable -> L75
        z3 r21 = q3.a();     // Catch: Throwable -> L75
        if (r21 == null) goto L77;
        j r110 = r13.c;     // Catch: Throwable -> L75
        if (r110 == null) goto L73;
        String r111 = r110.p();     // Catch: Throwable -> L75
    L74:
        r21.f(r111, new b0(r13));     // Catch: Throwable -> L75
        goto L77
    L73:
        r111 = null;
        goto L74
    L65:
        r19 = null;
    L77:
        FLogger.a.i(r16, "[startUpdateProgress] currentPosition: " + r6 + ", displayPlayTime: " + r7);     // Catch: Throwable -> L75
        float r22 = (((float) r6) * 100.0f) / r7;     // Catch: Throwable -> L75
        String r23 = r13.e.b;     // Catch: Throwable -> L75
        k r24 = StreamingMusicPlayer.p;     // Catch: Throwable -> L75
        if (r24 == null) goto L80;
        String r25 = r24.b;     // Catch: Throwable -> L75
    L81:
        j r112 = r13.c;     // Catch: Throwable -> L75
        if (r112 == null) goto L86;
        Message r113 = r112.j;     // Catch: Throwable -> L75
        if (r113 == null) goto L86;
        Boolean r114 = Boxing.boxBoolean(r113.isNewBlockType());     // Catch: Throwable -> L75
    L88:
        if (c0.a(r23, r25, r114) == false) goto L117;
        k r26 = StreamingMusicPlayer.p;     // Catch: Throwable -> L75
        if (r26 != null) goto L92;
    L94:
        boolean r27 = false;
    L95:
        if (r27 == false) goto L117;
        if (r13.e.e == false) goto L117;
        if (r6 <= 0) goto L109;
        b.a r28 = b.a;     // Catch: Throwable -> L75
        String r30 = r13.o();     // Catch: Throwable -> L75
        if (r30 != null) goto L102;
        r30 = "";
    L102:
        j r115 = r13.c;     // Catch: Throwable -> L75
        if (r115 == null) goto L107;
        ad9.b r116 = r115.g;     // Catch: Throwable -> L75
        if (r116 == null) goto L107;
        String r117 = r116.getItemId();     // Catch: Throwable -> L75
    L108:
        r28.getClass();     // Catch: Throwable -> L75
        b.a.d(r30, r117, r6);     // Catch: Throwable -> L75
    L107:
        r117 = null;
    L109:
        k r118 = StreamingMusicPlayer.p;     // Catch: Throwable -> L75
        if (r118 == null) goto L112;
        k r31 = k.a(r118, null, null, 0.0f, r22, false, false, 0, 247);     // Catch: Throwable -> L75
    L113:
        StreamingMusicPlayer.p = r31;     // Catch: Throwable -> L75
        if (r31 == null) goto L116;
        r13.e = r31;     // Catch: Throwable -> L75
    L116:
        BuildersKt.launch$default(r13.getScope(), Dispatchers.getMain(), null, new StreamingMusicPlayer$startUpdateProgress$1$1$1$2(r13, r22, null), 2, null);     // Catch: Throwable -> L75
        goto L117
    L112:
        r31 = null;
        goto L113
    L92:
        if (r26.e != true) goto L94;
        r27 = true;
    L117:
        r10.element = 10;     // Catch: Throwable -> L75
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L148:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L124
        if (r33 == null) goto L123;
        FLogger.a.e(r16, "updating media player playing e ", r33);     // Catch: Throwable -> L124
        r10.element--;     // Catch: Throwable -> L124
    L123:
        r0 = r4;
        r3 = r10;
        r9 = r16;
        r11 = r15;
        r12 = r13;
        StreamingMusicPlayer$startUpdateProgress$1 r119 = r14;
    L25:
        if (r3.element <= 0) goto L135;
        MediaPlayer r120 = StreamingMusicPlayer.q;     // Catch: Throwable -> L137
        if (r120 != null) goto L29;
    L31:
        boolean r121 = false;
    L32:
        if (r121 == false) goto L126;
        k r122 = StreamingMusicPlayer.p;     // Catch: Throwable -> L137
        if (r122 != null) goto L36;
    L38:
        boolean r123 = false;
    L39:
        if (r123 == false) goto L126;
        j r124 = r12.c;     // Catch: Throwable -> L137
        if (r124 == null) goto L44;
        long r125 = r124.b;     // Catch: Throwable -> L137
    L45:
        r119.L$0 = r12;     // Catch: Throwable -> L137
        r119.L$1 = r11;     // Catch: Throwable -> L137
        r119.L$2 = r3;     // Catch: Throwable -> L137
        r119.label = 2;     // Catch: Throwable -> L137
        if (DelayKt.delay(r125, r119) != r0) goto L48;
        return r0;
    L48:
        r14 = r119;
        goto L9
    L44:
        r125 = 30;
        goto L45
    L36:
        if (r122.e != true) goto L38;
        r123 = true;
    L126:
        r3.element--;     // Catch: Throwable -> L137
        FLogger r34 = FLogger.a;     // Catch: Throwable -> L137
        StringBuilder r35 = new StringBuilder();     // Catch: Throwable -> L137
        r35.append("[startUpdateProgress] retry mediaPlayer?.isPlaying: ");     // Catch: Throwable -> L137
        MediaPlayer r36 = StreamingMusicPlayer.q;     // Catch: Throwable -> L137
        if (r36 == null) goto L129;
        Boolean r37 = Boxing.boxBoolean(r36.isPlaying());     // Catch: Throwable -> L137
    L130:
        r35.append(r37);     // Catch: Throwable -> L137
        r35.append(", playingStateCache?.playingChunk: ");     // Catch: Throwable -> L137
        k r38 = StreamingMusicPlayer.p;     // Catch: Throwable -> L137
        if (r38 == null) goto L133;
        Boolean r39 = Boxing.boxBoolean(r38.e);     // Catch: Throwable -> L137
    L134:
        r35.append(r39);     // Catch: Throwable -> L137
        r34.i(r9, r35.toString());     // Catch: Throwable -> L137
        goto L25
    L133:
        r39 = null;
        goto L134
    L129:
        r37 = null;
        goto L130
    L29:
        if (r120.isPlaying() != true) goto L31;
        r121 = true;
        goto L32
    L135:
        Object r40 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L137
    L139:
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L143;
        FLogger.a.e(r9, "illegal is playing check media player", r41);
    L143:
        return Unit.INSTANCE;
    L86:
        r114 = null;
        goto L88
    L80:
        r25 = null;
        goto L81
    L60:
        r8 = false;
        goto L61
    L56:
        r7 = 60000.0f;
        goto L58
    L52:
        r6 = 0;
        goto L53
    L75:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
    L124:
        th = th;
        r9 = r16;
    L138:
        Result.Companion r43 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L139
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r44 = (CoroutineScope) this.L$1;
        StreamingMusicPlayer r126 = (StreamingMusicPlayer) this.L$0;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L137
    L23:
        Ref.IntRef r127 = new Ref.IntRef();     // Catch: Throwable -> L137
        r127.element = 10;     // Catch: Throwable -> L137
        r119 = this;
        StreamingMusicPlayer r210 = r126;
        r11 = r44;
        r3 = r127;
        r12 = r210;
        goto L25
    L15:
        ResultKt.throwOnFailure(r29);
        r44 = (CoroutineScope) this.L$0;
        r126 = this.this$0;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L137
        FLogger.a.i("StreamingMusicPlayer", "[startUpdateProgress] updating media player playing");     // Catch: Throwable -> L137
        j r129 = r126.c;     // Catch: Throwable -> L137
        if (r129 == null) goto L19;
        long r130 = r129.b;     // Catch: Throwable -> L137
    L20:
        this.L$0 = r126;     // Catch: Throwable -> L137
        this.L$1 = r44;     // Catch: Throwable -> L137
        this.label = 1;     // Catch: Throwable -> L137
        if (DelayKt.delay(r130, this) != r0) goto L23;
        return r0;
    L19:
        r130 = 30;
    L137:
        th = th;
        goto L138
    }
}
