package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$updateInputEntrances$1", f = "CoreInputAbility.kt", i = {0}, l = {433, 450}, m = "invokeSuspend", n = {"enabled"}, s = {"L$0"})
public final class CoreInputAbility$updateInputEntrances$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ EditPos $editPos;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CoreInputAbility<T> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$updateInputEntrances$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$updateInputEntrances$1$1", f = "CoreInputAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $enabled;
        final /* synthetic */ boolean $showTopRight;
        int label;
        final /* synthetic */ CoreInputAbility<T> this$0;

        public AnonymousClass1(Ref.BooleanRef r1, boolean r2, CoreInputAbility<T> r3, Continuation<? super AnonymousClass1> r4) {
            this.$enabled = r1;
            this.$showTopRight = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$enabled, this.$showTopRight, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r6v14, types: [com.larus.bmhome.chat.component.bottom.core.x, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L34;
            ResultKt.throwOnFailure(r6);
            if (this.$enabled.element == true) goto L7;
        L9:
            boolean r7 = false;
        L10:
            CoreInputAbility<T> r2 = this.this$0;
            r2.R = Boxing.boxBoolean(r7);
            final CoreInputAbility<T> r3 = this.this$0;
            if (r7 == true) goto L13;
        L15:
            boolean r8 = false;
        L16:
            BotModel r4 = r3.q();
            if (r4 == null) goto L20;
            final String r5 = r4.getBotId();
            if (r5 == null) goto L20;
        L21:
            r3.R0(r8);
            if (r8 == false) goto L32;
            if (CoreInputViewModel.getActionShownByConf$default(r3.F(), false, 1, null) != 4) goto L32;
            if (r3.F().isPageVisible() == false) goto L32;
            Set r9 = com.larus.bmhome.utils.a0.a;
            ?? r10 = new x(r3, r5);
            Intrinsics.checkNotNullParameter("onRealtimeEntranceShow", "id");
            Intrinsics.checkNotNullParameter(r10, "task");
            Set r0 = com.larus.bmhome.utils.a0.a;
            if (r0.contains("onRealtimeEntranceShow") == true) goto L32;
            r0.add("onRealtimeEntranceShow");
            r10.invoke();
        L32:
            return Unit.INSTANCE;
        L20:
            r5 = "";
            goto L21
        L13:
            if (r3.Q == true) goto L15;
            r8 = true;
            goto L16
        L7:
            if (this.$showTopRight == true) goto L9;
            r7 = true;
            goto L10
        L34:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CoreInputAbility$updateInputEntrances$1(EditPos r1, CoreInputAbility<T> r2, BotModel r3, Continuation<? super CoreInputAbility$updateInputEntrances$1> r4) {
        this.$editPos = r1;
        this.this$0 = r2;
        this.$botModel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoreInputAbility$updateInputEntrances$1(this.$editPos, this.this$0, this.$botModel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$1;
        Ref.BooleanRef r4 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r10);
    L14:
        r2.element = ((Boolean) r10).booleanValue();
        boolean r11 = !this.this$0.O;
        FLogger r3 = FLogger.a;
        StringBuilder r5 = new StringBuilder("viewmodel ");
        r5.append(this.this$0.F());
        r5.append(", [updateInputEntrances] bot name: ");
        BotModel r6 = this.this$0.F().getBotModel();
        if (r6 == null) goto L17;
        String r7 = r6.getName();
    L18:
        r5.append(r7);
        r5.append(", isVisible ");
        if (r4.element == false) goto L22;
        if (r11 == true) goto L22;
        boolean r8 = true;
    L23:
        r5.append(r8);
        r5.append(", enabled ");
        r5.append(r4.element);
        r5.append(", botmodel ");
        BotModel r9 = this.$botModel;
        if (r9 == null) goto L26;
        Map r12 = r9.getExtra();
    L27:
        r5.append(r12);
        r3.i("CoreInputAbility", r5.toString());
        this.this$0.Q = VoiceCallServiceDelegate.a.q("voice_call", "input_bar", true);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r14 = new AnonymousClass1(r4, r11, this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(r13, r14, this) != r0) goto L31;
        return r0;
    L26:
        r12 = null;
    L22:
        r8 = false;
        goto L23
    L17:
        r7 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r10);
        r2 = new Ref.BooleanRef();
        ILegacyChatUiServiceDelegate r15 = ILegacyChatUiServiceDelegate.b;
        EditPos r16 = this.$editPos;
        BotModel r17 = this.this$0.q();
        String r18 = this.this$0.v();
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 1;
        r10 = r15.v8(r16, r17, r18, this);
        if (r10 != r0) goto L13;
        return r0;
    L13:
        r4 = r2;
        goto L14
    }
}
