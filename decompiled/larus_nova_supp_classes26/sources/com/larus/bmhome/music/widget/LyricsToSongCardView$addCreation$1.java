package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.api.creation.UserCreation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$addCreation$1", f = "LyricsToSongCardView.kt", i = {1}, l = {464, 479}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class LyricsToSongCardView$addCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    final /* synthetic */ Context $fragmentContext;
    final /* synthetic */ int $privateStatus;
    Object L$0;
    int label;
    final /* synthetic */ LyricsToSongCardView this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.LyricsToSongCardView$addCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$addCreation$1$1", f = "LyricsToSongCardView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LyricsToSongCardView this$0;

        public AnonymousClass1(LyricsToSongCardView r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            LyricsToSongCardView r3 = this.this$0;
            int r0 = LyricsToSongCardView.U;
            r3.p(1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LyricsToSongCardView$addCreation$1(LyricsToSongCardView r1, int r2, Context r3, int r4, Continuation<? super LyricsToSongCardView$addCreation$1> r5) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$fragmentContext = r3;
        this.$buttonStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LyricsToSongCardView$addCreation$1(this.this$0, this.$privateStatus, this.$fragmentContext, this.$buttonStatus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r11 = TriggerSendLoading.NO_LOADING;
        boolean r12 = false;
        String r13 = "";
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        zp9.a r1 = (zp9.a) this.L$0;
        ResultKt.throwOnFailure(r37);
    L107:
        if (r1 != null) goto L109;
    L111:
        if (r12 == false) goto L117;
        if (r1 == null) goto L116;
        UserCreation r2 = r1.b;
        if (r2 == null) goto L116;
        r13 = r2.a;
    L116:
        String r19 = null;
    L118:
        Message r3 = this.this$0.i;
        if (r3 == null) goto L125;
        List<AICreationTaskDurationInfo> r4 = ap8.a.a(r3);
        if (r4 == null) goto L125;
        AICreationTaskDurationInfo r5 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L125;
        String r20 = r5.taskId;
    L126:
        Message r6 = this.this$0.i;
        if (r6 == null) goto L129;
        String r7 = r6.getMessageId();
    L131:
        if (com.larus.utils.o0.d(r7) == false) goto L136;
        Message r8 = this.this$0.i;
        if (r8 == null) goto L135;
        String r21 = r8.getMessageId();
    L138:
        if (this.$privateStatus == 2) goto L141;
        r11 = "1";
    L141:
        String r24 = r11;
        Message r10 = this.this$0.i;
        if (r10 == null) goto L146;
        Map r14 = r10.getExt();
        if (r14 == null) goto L146;
        String r29 = (String) r14.get("gen_music_create_way");
    L147:
        tx9.e2.a.b(new tx9.o0("chat", "chat_list", r19, r20, r21, "music", "-1", r24, null, null, null, null, r29, null, null, null, null, null, 515585), null, 3);
        return Unit.INSTANCE;
    L146:
        r29 = null;
        goto L147
    L135:
        r21 = null;
        goto L138
    L136:
        r21 = TriggerSendLoading.NO_LOADING;
        goto L138
    L129:
        r7 = null;
    L125:
        r20 = null;
    L117:
        r19 = r13;
        goto L118
    L109:
        if (r1.a != true) goto L111;
        r12 = true;
        goto L111
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r37);
        Object r15 = r37;
    L31:
        r1 = (zp9.a) r15;
        if (r1 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 == true) goto L73;
        if (r1 == null) goto L40;
        String r17 = r1.c;
    L42:
        if (Intrinsics.areEqual(r17, "710053005") == false) goto L51;
        t19.s r18 = t19.s.a;
        Context r22 = this.$fragmentContext;
        if (r22 == null) goto L49;
        Resources r23 = r22.getResources();
        if (r23 == null) goto L49;
        String r25 = r23.getString(2131907956);
        if (r25 == null) goto L49;
    L50:
        r18.getClass();
        t19.s.c(r22, r25);
    L59:
        Message r26 = this.this$0.i;
        if (r26 == null) goto L62;
        String r27 = r26.getMessageId();
    L64:
        if (com.larus.utils.o0.d(r27) == false) goto L69;
        Message r28 = this.this$0.i;
        if (r28 == null) goto L68;
        String r30 = r28.getMessageId();
    L70:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new LyricsToSongCardView$reportMusicAddCreation$1(r30, false, "", null), 3, null);
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        AnonymousClass1 r32 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r1;
        this.label = 2;
        if (BuildersKt.withContext(r31, r32, this) != r9) goto L107;
        return r9;
    L68:
        r30 = null;
        goto L70
    L69:
        r30 = TriggerSendLoading.NO_LOADING;
        goto L70
    L62:
        r27 = null;
    L49:
        r25 = "";
        goto L50
    L51:
        t19.s r33 = t19.s.a;
        Context r34 = this.$fragmentContext;
        if (r34 == null) goto L57;
        Resources r35 = r34.getResources();
        if (r35 == null) goto L57;
        String r36 = r35.getString(2131899191);
        if (r36 == null) goto L57;
    L58:
        r33.getClass();
        t19.s.c(r34, r36);
    L57:
        r36 = "";
        goto L58
    L40:
        r17 = null;
        goto L42
    L73:
        Message r38 = this.this$0.i;
        if (r38 == null) goto L76;
        String r39 = r38.getMessageId();
    L78:
        if (com.larus.utils.o0.d(r39) == false) goto L83;
        Message r40 = this.this$0.i;
        if (r40 == null) goto L82;
        String r41 = r40.getMessageId();
    L84:
        if (r1 == null) goto L88;
        UserCreation r42 = r1.b;
        if (r42 == null) goto L88;
        String r43 = r42.a;
    L89:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new LyricsToSongCardView$reportMusicAddCreation$1(r41, true, r43, null), 3, null);
        t19.s r44 = t19.s.a;
        Context r45 = this.$fragmentContext;
        if (r45 == null) goto L95;
        Resources r46 = r45.getResources();
        if (r46 == null) goto L95;
        String r47 = r46.getString(2131900634);
        if (r47 == null) goto L95;
    L96:
        r44.getClass();
        t19.s.p(r45, r47);
        LyricsToSongCardView r48 = this.this$0;
        r48.J = this.$buttonStatus;
        Map<String, Pair<String, Integer>> r49 = r48.E;
        if (r49 == null) goto L107;
        String r50 = LyricsToSongCardView.n(r48.j);
        if (r1 == null) goto L104;
        UserCreation r51 = r1.b;
        if (r51 == null) goto L104;
        String r52 = r51.a;
        if (r52 == null) goto L104;
    L105:
        r49.put(r50, TuplesKt.to(r52, Boxing.boxInt(this.$privateStatus)));
    L104:
        r52 = "";
    L95:
        r47 = "";
    L88:
        r43 = null;
        goto L89
    L82:
        r41 = null;
        goto L84
    L83:
        r41 = TriggerSendLoading.NO_LOADING;
        goto L84
    L76:
        r39 = null;
        goto L78
    L34:
        if (r1.a != true) goto L36;
        r16 = true;
        goto L37
    L10:
        ResultKt.throwOnFailure(r37);
        com.larus.platform.service.e0 r53 = com.larus.platform.service.e0.a;
        Message r54 = this.this$0.i;
        if (r54 == null) goto L14;
        String r55 = r54.getMessageId();
        if (r55 == null) goto L14;
    L15:
        String r56 = LyricsToSongCardView.n(this.this$0.j);
        MusicCreationContent r57 = this.this$0.j;
        if (r57 != null) goto L18;
    L20:
        boolean r58 = false;
    L21:
        if (r58 == false) goto L23;
        int r59 = 4;
    L24:
        MusicCreationContent r60 = this.this$0.j;
        if (r60 == null) goto L27;
        String r61 = zc9.i0.a(r60);
    L28:
        int r62 = this.$privateStatus;
        this.label = 1;
        r15 = com.larus.platform.api.g2.a.a(r55, 1, r56, r62, r61, r59, this, 64);
        if (r15 != r9) goto L31;
        return r9;
    L27:
        r61 = null;
        goto L28
    L23:
        r59 = 1;
        goto L24
    L18:
        if (r57.isBlock() != true) goto L20;
        r58 = true;
    L14:
        r55 = "";
        goto L15
    }
}
