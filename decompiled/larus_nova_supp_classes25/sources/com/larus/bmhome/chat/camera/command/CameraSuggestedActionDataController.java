package com.larus.bmhome.chat.camera.command;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CameraSuggestedActionDataController implements p {
    public static final /* synthetic */ int h = 0;
    public final l a;
    public final o b;
    public final CompletableDeferred<SuggestedActionData> c;
    public final Map<String, iq9.e> d;
    public Function1<? super List<SuggestedAction>, ? extends List<SuggestedAction>> e;
    public BotModel f;
    public boolean g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.camera.command.CameraSuggestedActionDataController$preload$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.camera.command.CameraSuggestedActionDataController$preload$1", f = "CameraSuggestedActionDataController.kt", i = {1}, l = {MessageCellStateTransformerType.EDU_CONTINUE_SHOT, MessageCellStateTransformerType.CROWD_TEST_TAB}, m = "invokeSuspend", n = {"botId"}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $source;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CameraSuggestedActionDataController this$0;

        public AnonymousClass1(CameraSuggestedActionDataController r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$source, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            boolean r7 = true;
            if (r4 == 0) goto L14;
            if (r4 == 1) goto L11;
            if (r4 != 2) goto L10;
            String r5 = (String) this.L$1;
            CameraSuggestedActionDataController r6 = (CameraSuggestedActionDataController) this.L$0;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L51
            Object r8 = r17;
        L40:
            com.larus.network.http.f r9 = (com.larus.network.http.a) r8;     // Catch: Throwable -> L51
            if ((r9 instanceof com.larus.network.http.f) == false) goto L43;
            FLogger.a.e("CameraSuggestedActionDataController", "request suggested action failed, botId=" + r5 + ", error=" + r9.d);     // Catch: Throwable -> L51
        L43:
            SuggestedActionData r2 = (SuggestedActionData) ((com.larus.network.http.a) r9).b;     // Catch: Throwable -> L51
            if (r6.a.c1() == false) goto L46;
        L48:
            r6.d(r2);     // Catch: Throwable -> L51
            FLogger.a.i("CameraSuggestedActionDataController", "request suggested action done, botId=" + r5 + ", resp=" + r9);     // Catch: Throwable -> L51
            Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
        L53:
            CameraSuggestedActionDataController r10 = this.this$0;
            Throwable r1 = Result.exceptionOrNull-impl(r0);
            if (r1 == null) goto L57;
            FLogger.a.e("CameraSuggestedActionDataController", "request suggested action error", r1);
            r10.d(null);
        L57:
            return Unit.INSTANCE;
        L46:
            if (o0.d(r5) == false) goto L48;
            Lazy r11 = v.a;     // Catch: Throwable -> L51
            Intrinsics.checkNotNullParameter(r5, "botId");     // Catch: Throwable -> L51
            v.b.put(r5, r2);     // Catch: Throwable -> L51
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuggestedActionCache$put$1(r2, r5, null), 3, null);     // Catch: Throwable -> L51
            goto L48
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            String r12 = (String) this.L$1;
            CameraSuggestedActionDataController r13 = (CameraSuggestedActionDataController) this.L$0;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L51
            Object r14 = r17;
            String r15 = r12;
            r6 = r13;
        L18:
            BotModel r16 = (BotModel) r14;     // Catch: Throwable -> L51
            r6.f = r16;     // Catch: Throwable -> L51
            if (r16 == null) goto L21;
            String r18 = r16.getBotId();     // Catch: Throwable -> L51
        L22:
            if (r18 != null) goto L24;
        L27:
            if (r7 == false) goto L29;
        L49:
            r6.d(null);     // Catch: Throwable -> L51
            return Unit.INSTANCE;
        L29:
            if (q.a(r16) == false) goto L49;
            if (r16 == null) goto L33;
            String r19 = r16.getBotId();     // Catch: Throwable -> L51
        L34:
            if (r19 != null) goto L36;
            r19 = "";
        L36:
            Lazy<ChatApi> r110 = ChatApi.a;     // Catch: Throwable -> L51
            ChatApi r111 = ChatApi.a.a();     // Catch: Throwable -> L51
            this.L$0 = r6;     // Catch: Throwable -> L51
            this.L$1 = r19;     // Catch: Throwable -> L51
            this.label = 2;     // Catch: Throwable -> L51
            r111.getClass();     // Catch: Throwable -> L51
            r8 = ChatApi.c(r19, r15, this);     // Catch: Throwable -> L51
            if (r8 != r3) goto L39;
            return r3;
        L39:
            r5 = r19;
            goto L40
        L33:
            r19 = null;
            goto L34
        L24:
            if (r18.length() == 0) goto L27;
            r7 = false;
            goto L27
        L21:
            r18 = null;
            goto L22
        L14:
            ResultKt.throwOnFailure(r17);
            CoroutineScope r20 = (CoroutineScope) this.L$0;
            r6 = this.this$0;
            r15 = this.$source;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L51
            l r113 = r6.a;     // Catch: Throwable -> L51
            this.L$0 = r6;     // Catch: Throwable -> L51
            this.L$1 = r15;     // Catch: Throwable -> L51
            this.label = 1;     // Catch: Throwable -> L51
            r14 = r113.b(this);     // Catch: Throwable -> L51
            if (r14 != r3) goto L18;
            return r3;
        L51:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r0 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L53
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        BotModel r0 = this.a.a();
        if (r0 != null) goto L6;
        r0 = this.f;
    L6:
        return q.b(r0);
    }

    public final String f() {
        BotModel r0 = this.a.a();
        if (r0 != null) goto L5;
        r0 = this.f;
    L5:
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.getBotId();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r1) {
        this.e = r1;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r2) {
        this.c.complete(r2);
    }

    public final SuggestedActionData e(SuggestedActionScene r7) {
        Lazy r0 = v.a;
        SuggestedActionData r1 = v.a(f());
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("getSuggestedAction from cache, ");
        ArrayList r4 = null;
        if (r1 == null) goto L15;
        List r8 = r1.get(r7);
        if (r8 == null) goto L15;
        List r9 = r8;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        SuggestedAction r6 = (SuggestedAction) r10.next();
        if (r6 == null) goto L12;
        String r11 = r6.getDisplayName();
    L13:
        r5.add(r11);
        goto L8
    L12:
        r11 = null;
        goto L13
    L14:
        r4 = r5;
    L15:
        r3.append(r4);
        r2.i("CameraSuggestedActionDataController", r3.toString());
        return r1;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        BuildersKt.launch$default(this.a.getScope(), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public CameraSuggestedActionDataController(l r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "options");
        this.a = r2;
        this.b = r3;
        this.c = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.d = new LinkedHashMap();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r2, iq9.e r3) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        if (r3 != null) goto L5;
        this.d.remove(r2);
        return;
    L5:
        this.d.put(r2, r3);
    }

    public final iq9.e g(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        iq9.e r4 = (iq9.e) ((LinkedHashMap) this.d).get(r2);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (iq9.e) this.b.b.invoke(Boolean.valueOf(r3));
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "bizScene");
        if (r11 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Object r3 = null;
        if (r2 == true) goto L11;
        return null;
    L11:
        if (this.c.isCompleted() == false) goto L33;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L22
        SuggestedActionData r5 = (SuggestedActionData) this.c.getCompleted();     // Catch: Throwable -> L22
        if (r5 != null) goto L16;
        r5 = e(r11);     // Catch: Throwable -> L22
    L16:
        SuggestedActionData r6 = r5;
        int r7 = m.a;     // Catch: Throwable -> L22
        List r14 = m.a(r6, r11, g(r12, r13), ((Boolean) this.b.a.invoke()).booleanValue(), this.e, null);     // Catch: Throwable -> L22
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L22
        StringBuilder r9 = new StringBuilder("getSuggestedActionSync[");     // Catch: Throwable -> L22
        r9.append(r11);     // Catch: Throwable -> L22
        r9.append("], bizScene=");     // Catch: Throwable -> L22
        r9.append(r12);     // Catch: Throwable -> L22
        r9.append(", bot=");     // Catch: Throwable -> L22
        r9.append(f());     // Catch: Throwable -> L22
        r9.append(", resultSize=");     // Catch: Throwable -> L22
        if (r14 == null) goto L19;
        Integer r15 = Integer.valueOf(r14.size());     // Catch: Throwable -> L22
    L20:
        r9.append(r15);     // Catch: Throwable -> L22
        r8.i("CameraSuggestedActionDataController", r9.toString());     // Catch: Throwable -> L22
        Object r16 = Result.constructor-impl(r14);     // Catch: Throwable -> L22
    L24:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L27;
        r3 = r16;
    L29:
        return (List) r3;
    L27:
        FLogger.a.e("CameraSuggestedActionDataController", "getSuggestedActionSync error", r17);
        goto L29
    L19:
        r15 = null;
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L33:
        return null;
    L5:
        if (r11 == SuggestedActionScene.Unknown) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r8, String r9, boolean r10, Function1<? super List<SuggestedAction>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "bizScene");
        Intrinsics.checkNotNullParameter(r11, "callback");
        a(r8, r9, r10, null, r11);
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r14, String r15, boolean r16, String r17, Function1<? super List<SuggestedAction>, Unit> r18) {
        Intrinsics.checkNotNullParameter(r15, "bizScene");
        Intrinsics.checkNotNullParameter(r18, "callback");
        if (r14 != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L11;
        r18.invoke(null);
        return;
    L11:
        BuildersKt.launch$default(this.a.getScope(), null, null, new CameraSuggestedActionDataController$getSuggestedAction$1(this, r14, r15, r16, r17, r18, null), 3, null);
        return;
    L5:
        if (r14 == SuggestedActionScene.Unknown) goto L7;
        r0 = true;
        goto L8
    }
}
