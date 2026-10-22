package com.larus.bot.impl.feature.botmaker;

import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.message.Message;
import com.larus.network.http.y;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.botmaker.BotMakerModel$generateImageUrl$job$1", f = "BotMakerModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
final class BotMakerModel$generateImageUrl$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IChatRepoService $chatRepo;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $msgId;
    final /* synthetic */ long $msgServerIndex;
    final /* synthetic */ BotMakerDataModel $newContent;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.botmaker.BotMakerModel$generateImageUrl$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.botmaker.BotMakerModel$generateImageUrl$job$1$1", f = "BotMakerModel.kt", i = {}, l = {144, 153, 170, 186}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IChatRepoService $chatRepo;
        final /* synthetic */ String $cvsId;
        final /* synthetic */ String $msgId;
        final /* synthetic */ long $msgServerIndex;
        final /* synthetic */ BotMakerDataModel $newContent;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass1(IChatRepoService r1, String r2, long r3, BotMakerDataModel r5, String r6, Continuation<? super AnonymousClass1> r7) {
            this.$chatRepo = r1;
            this.$cvsId = r2;
            this.$msgServerIndex = r3;
            this.$newContent = r5;
            this.$msgId = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$chatRepo, this.$cvsId, this.$msgServerIndex, this.$newContent, this.$msgId, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r4 = "";
            String r10 = "placeholder";
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 != 4) goto L10;
            ResultKt.throwOnFailure(r19);
            Object r3 = r19;
        L139:
            if ((((com.larus.network.http.a) r3) instanceof com.larus.network.http.f) == false) goto L145;
            FLogger.a.e("BotMakerViewModel", "updateMessage fail!!!");
        L145:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            IChatRepoService r5 = (IChatRepoService) this.L$2;
            String r6 = (String) this.L$1;
            BotMakerDataModel r7 = (BotMakerDataModel) this.L$0;
            ResultKt.throwOnFailure(r19);
            IChatRepoService r13 = r5;
            Object r8 = r19;
        L96:
            y r9 = (com.larus.network.http.a) r8;
            if ((r9 instanceof y) == false) goto L115;
            y r11 = r9;
            BotAvatarIconData r12 = (BotAvatarIconData) ((com.larus.network.http.a) r11).b;
            if (r12 == null) goto L102;
            String r14 = r12.getIconUrl();
            if (r14 == null) goto L102;
        L103:
            BotAvatarIconData r15 = (BotAvatarIconData) ((com.larus.network.http.a) r11).b;
            if (r15 == null) goto L109;
            String r16 = r15.getIconUri();
            if (r16 == null) goto L109;
            r10 = r16;
        L109:
            if (r7 == null) goto L111;
            r7.setIcon_url(r14);
        L111:
            if (r7 == null) goto L113;
            r7.setIcon_uri(r10);
        L113:
            k.h.put(r6, r14);
            k.i.put(r6, r10);
        L120:
            if (r7 == null) goto L145;
            String r17 = k.b.toJson(r7);     // Catch: Exception -> L123
            Intrinsics.checkNotNull(r17);     // Catch: Exception -> L123
        L125:
            if (r17.length() <= 0) goto L127;
            boolean r18 = true;
        L128:
            if (r18 == false) goto L145;
            String r20 = k.b.toJson(r7);     // Catch: Exception -> L131
            Intrinsics.checkNotNull(r20);     // Catch: Exception -> L131
        L132:
            r13.J1(r6, r20, null);
            String r21 = k.b.toJson(r7);     // Catch: Exception -> L146
            Intrinsics.checkNotNull(r21);     // Catch: Exception -> L146
            r4 = r21;
        L135:
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 4;
            r3 = r13.A1(r6, r4, this);
            if (r3 != r1) goto L139;
            return r1;
        L131:
            r20 = "";
            goto L132
        L127:
            r18 = false;
        L123:
            r17 = "";
        L102:
            r14 = "placeholder";
            goto L103
        L115:
            if ((r9 instanceof com.larus.network.http.f) == false) goto L120;
            if (r7 == null) goto L118;
            r7.setIcon_url("placeholder");
        L118:
            if (r7 == null) goto L120;
            r7.setIcon_uri("placeholder");
            goto L120
        L12:
            IChatRepoService r22 = (IChatRepoService) this.L$2;
            r6 = (String) this.L$1;
            r7 = (BotMakerDataModel) this.L$0;
            ResultKt.throwOnFailure(r19);
            r13 = r22;
            Object r23 = r19;
        L60:
            y r24 = (com.larus.network.http.a) r23;
            if ((r24 instanceof y) == false) goto L87;
            y r25 = r24;
            wu8.d r26 = (wu8.d) ((com.larus.network.http.a) r25).b;
            if (r26 == null) goto L65;
            BotAvatarIconData r27 = r26.a;
        L66:
            if (r27 == null) goto L69;
            String r28 = r27.getIconUrl();
            if (r28 == null) goto L69;
        L70:
            if (r27 == null) goto L75;
            String r29 = r27.getIconUri();
            if (r29 == null) goto L75;
            r10 = r29;
        L75:
            if (r7 == null) goto L77;
            r7.setIcon_url(r28);
        L77:
            if (r7 == null) goto L79;
            r7.setIcon_uri(r10);
        L79:
            k.h.put(r6, r28);
            k.i.put(r6, r10);
            wu8.d r30 = (wu8.d) ((com.larus.network.http.a) r25).b;
            if (r30 == null) goto L82;
            BgImage r31 = r30.b;
        L83:
            if (r7 == null) goto L85;
            r7.setBgImage(r31);
        L85:
            k.j.put(r6, r31);
            goto L120
        L82:
            r31 = null;
        L69:
            r28 = "placeholder";
            goto L70
        L65:
            r27 = null;
            goto L66
        L87:
            if ((r24 instanceof com.larus.network.http.f) == false) goto L120;
            if (r7 == null) goto L90;
            r7.setIcon_url("placeholder");
        L90:
            if (r7 == null) goto L120;
            r7.setIcon_uri("placeholder");
            goto L120
        L13:
            ResultKt.throwOnFailure(r19);
            Object r32 = r19;
        L17:
            Message r33 = (Message) r32;
            if (r33 == null) goto L145;
            BotMakerDataModel r110 = this.$newContent;
            String r111 = this.$msgId;
            r13 = this.$chatRepo;
            k r112 = k.a;
            BotMakerDataModel r113 = k.d(r33.getContent());
            if (r113 == null) goto L22;
            String r114 = r113.getIcon_url();
        L23:
            if (r114 != null) goto L25;
        L28:
            boolean r115 = true;
        L29:
            if (r115 == false) goto L141;
            BotLanguage r34 = k.e();
            if (r34 == null) goto L34;
            String r35 = r34.c();
            if (r35 == null) goto L34;
        L35:
            if (r113 == null) goto L40;
            String r116 = r113.getNick_name();
            if (r116 == null) goto L40;
            String r36 = r116;
        L41:
            if (r113 == null) goto L44;
            String r117 = r113.getRole();
            if (r117 == null) goto L44;
        L46:
            if (z2.a.chatImmerseEnable() == false) goto L92;
            LaunchInfo r118 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
            if (r118 == null) goto L54;
            BgImageConfig r119 = r118.h();
            if (r119 == null) goto L54;
            BgImageAbParam r120 = r119.a();
            if (r120 == null) goto L54;
            boolean r37 = Intrinsics.areEqual(Boxing.boxBoolean(true), r120.b());
        L55:
            if (r37 == false) goto L92;
            this.L$0 = r110;
            this.L$1 = r111;
            this.L$2 = r13;
            this.label = 2;
            r23 = k.a(r112, r36, r117, this);
            if (r23 != r1) goto L59;
            return r1;
        L59:
            r7 = r110;
            r6 = r111;
        L54:
            r37 = false;
        L92:
            this.L$0 = r110;
            this.L$1 = r111;
            this.L$2 = r13;
            this.label = 3;
            UgcBotRepo r38 = k.c;
            UgcBotRepo.c r39 = new UgcBotRepo.c(r36, r35, r117);
            r38.getClass();
            r8 = UgcBotRepo.j(r39, this);
            if (r8 != r1) goto L95;
            return r1;
        L95:
            r7 = r110;
            r6 = r111;
        L44:
            r117 = "";
        L40:
            r36 = "";
        L34:
            r35 = "";
            goto L35
        L141:
            String r40 = r33.getContent();
            if (r40 == null) goto L145;
            r13.J1(r111, r40, null);
            goto L145
        L25:
            if (r114.length() == 0) goto L28;
            r115 = false;
            goto L29
        L22:
            r114 = null;
            goto L23
        L14:
            ResultKt.throwOnFailure(r19);
            IChatRepoService r41 = this.$chatRepo;
            String r121 = this.$cvsId;
            long r122 = this.$msgServerIndex;
            this.label = 1;
            r32 = r41.v1(r121, r122, this);
            if (r32 != r1) goto L17;
            return r1;
        }
    }

    public BotMakerModel$generateImageUrl$job$1(IChatRepoService r1, String r2, long r3, BotMakerDataModel r5, String r6, Continuation<? super BotMakerModel$generateImageUrl$job$1> r7) {
        this.$chatRepo = r1;
        this.$cvsId = r2;
        this.$msgServerIndex = r3;
        this.$newContent = r5;
        this.$msgId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new BotMakerModel$generateImageUrl$job$1(this.$chatRepo, this.$cvsId, this.$msgServerIndex, this.$newContent, this.$msgId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$chatRepo, this.$cvsId, this.$msgServerIndex, this.$newContent, this.$msgId, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L12;
        return r0;
    }
}
