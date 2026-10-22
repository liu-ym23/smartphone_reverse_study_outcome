package com.larus.bmhome.chat.component.bottom.bottommenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$updateBottomMenu$1", f = "BottomMenuComponent.kt", i = {}, l = {1281, 1298}, m = "invokeSuspend", n = {}, s = {})
final class BottomMenuComponent$updateBottomMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditPos $editPos;
    int label;
    final /* synthetic */ BottomMenuComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$updateBottomMenu$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$updateBottomMenu$1$1", f = "BottomMenuComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;
        final /* synthetic */ BottomMenuComponent this$0;

        public AnonymousClass1(boolean r1, BottomMenuComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$enabled = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$enabled, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r4);
            FLogger.a.i("MultimodalInputWrapper", "updateActionEntranceRealtimeCallVisibility: enabled=" + this.$enabled + ", downgrade=" + this.this$0.G + ", visible=" + this.this$0.e4());
            this.this$0.c4();
            BottomMenuComponent r5 = this.this$0;
            r5.D = true;
            if (r5.E == false) goto L11;
            r5.E = false;
            ICoreInputAbility r6 = r5.Q3();
            if (r6 == null) goto L11;
            r6.C1(true, false, "");
        L11:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BottomMenuComponent$updateBottomMenu$1(BottomMenuComponent r1, EditPos r2, Continuation<? super BottomMenuComponent$updateBottomMenu$1> r3) {
        this.this$0 = r1;
        this.$editPos = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BottomMenuComponent$updateBottomMenu$1(this.this$0, this.$editPos, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L19:
        boolean r9 = ((Boolean) r8).booleanValue();
    L20:
        BottomMenuComponent r2 = this.this$0;
        r2.H = Boxing.boxBoolean(r9);
        BottomMenuComponent r3 = this.this$0;
        if (r3.V3() == false) goto L23;
        boolean r4 = false;
    L24:
        r3.G = r4;
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(r9, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L28;
        return r0;
    L23:
        r4 = VoiceCallServiceDelegate.a.q("voice_call", "plus_panel", true);
        goto L24
    L10:
        ResultKt.throwOnFailure(r8);
        BottomMenuComponent r10 = this.this$0;
        int r7 = BottomMenuComponent.x1;
        if (r10.V3() == false) goto L13;
        r9 = z2.a.g();
        goto L20
    L13:
        VoiceCallServiceDelegate r11 = VoiceCallServiceDelegate.a;
        EditPos r12 = this.$editPos;
        BotModel r13 = this.this$0.z3();
        String r14 = this.this$0.H3();
        if (r14 != null) goto L16;
        r14 = "";
    L16:
        this.label = 1;
        r8 = r11.f(r12, r13, r14, this);
        if (r8 != r0) goto L19;
        return r0;
    }
}
