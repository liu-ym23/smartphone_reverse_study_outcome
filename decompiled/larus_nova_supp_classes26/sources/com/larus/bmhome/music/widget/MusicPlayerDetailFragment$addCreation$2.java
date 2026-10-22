package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$addCreation$2", f = "MusicPlayerDetailFragment.kt", i = {1}, l = {297, 312, 326}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class MusicPlayerDetailFragment$addCreation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    final /* synthetic */ Context $fragmentContext;
    final /* synthetic */ int $privateStatus;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.MusicPlayerDetailFragment$addCreation$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$addCreation$2$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MusicPlayerDetailFragment this$0;

        public AnonymousClass1(MusicPlayerDetailFragment r1, Continuation<? super AnonymousClass1> r2) {
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
            MusicPlayerDetailFragment r3 = this.this$0;
            int r0 = MusicPlayerDetailFragment.O;
            r3.fa0(1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicPlayerDetailFragment$addCreation$2(MusicPlayerDetailFragment r1, int r2, Context r3, int r4, Continuation<? super MusicPlayerDetailFragment$addCreation$2> r5) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$fragmentContext = r3;
        this.$buttonStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MusicPlayerDetailFragment$addCreation$2(this.this$0, this.$privateStatus, this.$fragmentContext, this.$buttonStatus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean, int] */
    public final Object invokeSuspend(Object r39) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r11 = false;
        JSONObject r12 = null;
        kr8.o r13 = null;
        String r14 = TriggerSendLoading.NO_LOADING;
        String r15 = "";
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        String r1 = (String) this.L$2;
        String r2 = (String) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r39);
        String r7 = r1;
        boolean r16 = true;
        Object r4 = r39;
    L101:
        Message r5 = (Message) r4;
        boolean r17 = r16;
        if (r5 == null) goto L109;
        List<AICreationTaskDurationInfo> r6 = ap8.a.a(r5);
        r17 = r16;
        if (r6 == null) goto L109;
        AICreationTaskDurationInfo r8 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r6);
        r17 = r16;
        if (r8 == null) goto L109;
        String r22 = r8.taskId;
        String r20 = r2;
        String r19 = r3;
        String r21 = r7;
        ?? r18 = r16;
    L110:
        MusicPlayerDetailFragment r10 = this.this$0;
        String r23 = r10.I;
        if (this.$privateStatus == 2) goto L114;
        r14 = "1";
    L114:
        String r26 = r14;
        Message r24 = r10.d;
        if (r24 == null) goto L119;
        Map r25 = r24.getExt();
        if (r25 == null) goto L119;
        String r31 = (String) r25.get("gen_music_create_way");
    L120:
        tx9.o0 r27 = new tx9.o0(r19, r20, r21, r22, r23, "music", "-1", r26, null, null, null, null, r31, null, null, null, null, null, 515585);
        MusicPlayerDetailFragment r28 = this.this$0;
        if (r28.k == false) goto L126;
        kr8.n r29 = kr8.n.a;
        com.larus.bmhome.music.player.j r30 = r28.q;
        if (r30 == null) goto L125;
        r13 = r30.d;
    L125:
        r12 = kr8.n.c(r13, "music_detail", r18);
    L126:
        tx9.e2.a.b(r27, r12, r18);
        return Unit.INSTANCE;
    L119:
        r31 = null;
    L109:
        r20 = r2;
        r19 = r3;
        r21 = r7;
        r22 = null;
        r18 = r17;
        goto L110
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        zp9.a r32 = (zp9.a) this.L$0;
        ResultKt.throwOnFailure(r39);
        r15 = r15;
        boolean r110 = true;
    L81:
        if (r32 != null) goto L83;
    L85:
        if (r11 == false) goto L91;
        if (r32 == null) goto L90;
        UserCreation r33 = r32.b;
        if (r33 == null) goto L90;
        r7 = r33.a;
    L92:
        IChatRepoService r34 = RepoDispatcherDelegate.b.e();
        r2 = "chat";
        if (r34 == null) goto L108;
        String r35 = this.this$0.I;
        if (r35 != null) goto L97;
        r35 = TriggerSendLoading.NO_LOADING;
    L97:
        this.L$0 = "music_detail";
        this.L$1 = "chat";
        this.L$2 = r7;
        this.label = 3;
        r4 = r34.E1(r35, this);
        if (r4 != r9) goto L100;
        return r9;
    L100:
        r3 = "music_detail";
        r16 = r110;
        goto L101
    L108:
        r3 = "music_detail";
        r17 = r110;
    L90:
        r7 = null;
        goto L92
    L91:
        r7 = r15;
        goto L92
    L83:
        if (r32.a != r110) goto L85;
        r11 = true;
        goto L85
    L11:
        ResultKt.throwOnFailure(r39);
        Object r36 = r39;
        r110 = true;
    L15:
        r32 = (zp9.a) r36;
        if (r32 != null) goto L18;
    L20:
        boolean r37 = false;
    L21:
        if (r37 == true) goto L46;
        if (r32 == null) goto L24;
        String r38 = r32.c;
    L26:
        if (Intrinsics.areEqual(r38, "710053005") == false) goto L35;
        t19.s r40 = t19.s.a;
        Context r41 = this.$fragmentContext;
        if (r41 == null) goto L33;
        Resources r42 = r41.getResources();
        if (r42 == null) goto L33;
        String r43 = r42.getString(2131907956);
        if (r43 == null) goto L33;
    L34:
        r40.getClass();
        t19.s.c(r41, r43);
    L43:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicPlayerDetailFragment$reportMusicAddCreation$1(this.this$0.I, false, r15, null), 3, null);
        MainCoroutineDispatcher r44 = Dispatchers.getMain();
        AnonymousClass1 r45 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r32;
        this.label = 2;
        if (BuildersKt.withContext(r44, r45, this) != r9) goto L81;
        return r9;
    L33:
        r43 = r15;
        goto L34
    L35:
        t19.s r46 = t19.s.a;
        Context r47 = this.$fragmentContext;
        if (r47 == null) goto L41;
        Resources r48 = r47.getResources();
        if (r48 == null) goto L41;
        String r49 = r48.getString(2131899191);
        if (r49 == null) goto L41;
    L42:
        r46.getClass();
        t19.s.c(r47, r49);
    L41:
        r49 = r15;
        goto L42
    L24:
        r38 = null;
        goto L26
    L46:
        String r50 = this.this$0.I;
        if (r32 == null) goto L51;
        UserCreation r51 = r32.b;
        if (r51 == null) goto L51;
        String r52 = r51.a;
    L52:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicPlayerDetailFragment$reportMusicAddCreation$1(r50, r110, r52, null), 3, null);
        t19.s r53 = t19.s.a;
        Context r54 = this.$fragmentContext;
        if (r54 == null) goto L58;
        Resources r55 = r54.getResources();
        if (r55 == null) goto L58;
        String r56 = r55.getString(2131900634);
        if (r56 == null) goto L58;
    L59:
        r53.getClass();
        t19.s.p(r54, r56);
        MusicPlayerDetailFragment r57 = this.this$0;
        r57.J = this.$buttonStatus;
        if (r32 == null) goto L65;
        UserCreation r58 = r32.b;
        if (r58 == null) goto L65;
        String r59 = r58.a;
        if (r59 == null) goto L65;
    L66:
        Intrinsics.checkNotNullParameter(r59, "<set-?>");
        r57.E = r59;
        MusicDetailPagerFragment r60 = this.this$0.getParentFragment();
        if ((r60 instanceof MusicDetailPagerFragment) == false) goto L69;
        MusicDetailPagerFragment r61 = r60;
    L70:
        if (r61 == null) goto L81;
        String r62 = this.this$0.aa0();
        if (r32 == null) goto L77;
        UserCreation r63 = r32.b;
        if (r63 == null) goto L77;
        String r64 = r63.a;
        if (r64 == null) goto L77;
    L78:
        int r65 = this.$privateStatus;
        Intrinsics.checkNotNullParameter(r62, "taskId");
        Intrinsics.checkNotNullParameter(r64, "creationId");
        Map<String, Pair<String, Integer>> r66 = r61.l;
        if (r66 == null) goto L81;
        r66.put(r62, TuplesKt.to(r64, Integer.valueOf(r65)));
    L77:
        r64 = r15;
        goto L78
    L69:
        r61 = null;
    L65:
        r59 = r15;
    L58:
        r56 = r15;
    L51:
        r52 = null;
        goto L52
    L18:
        if (r32.a != r110) goto L20;
        r37 = true;
        goto L21
    L12:
        ResultKt.throwOnFailure(r39);
        com.larus.platform.service.e0 r67 = com.larus.platform.service.e0.a;
        MusicPlayerDetailFragment r68 = this.this$0;
        String r69 = r68.I;
        String r70 = r68.aa0();
        int r71 = this.$privateStatus;
        String r72 = this.this$0.aa0();
        this.label = 1;
        r110 = true;
        r36 = com.larus.platform.api.g2.a.a(r69, 1, r70, r71, r72, 4, this, 64);
        if (r36 != r9) goto L15;
        return r9;
    }
}
