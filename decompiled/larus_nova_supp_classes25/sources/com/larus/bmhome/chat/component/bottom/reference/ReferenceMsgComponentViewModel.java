package com.larus.bmhome.chat.component.bottom.reference;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.manager.l0;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TaskCardBlock;
import com.larus.platform.model.HoverActionConfig;
import com.larus.platform.service.m3;
import com.larus.platform.service.p1;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004Jø\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162¬\u0001\b\u0002\u0010\u0017\u001a¥\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\u0010!J\u0086\u0001\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00062d\b\u0002\u0010#\u001a^\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0$J\u0084\u0001\u0010%\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020\u00062j\b\u0002\u0010\u0017\u001ad\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0$J)\u0010'\u001a\u00020\f2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\f0)R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponentViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponentViewState;", "<init>", "()V", "enableCreateMarkdownOnMain", "", "getEnableCreateMarkdownOnMain", "()Z", "enableCreateMarkdownOnMain$delegate", "Lkotlin/Lazy;", "setReferenceMessageAndShowIme", "", "message", "Lcom/larus/im/bean/message/Message;", "botType", "", "referenceAction", "", "showIme", "refScene", "refEntrance", "Lcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;", "onUpdateRefMsg", "Lkotlin/Function7;", "Lkotlin/ParameterName;", "name", "action", "Lcom/larus/bmhome/utils/ReferenceMessage;", "refMsg", "", "suggestList", "hideSuggestActionBar", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;Lkotlin/jvm/functions/Function7;)V", "setReferenceMessageWithoutReply", "updateRefMsgWithoutReply", "Lkotlin/Function4;", "clearReferenceMessage", "forceClear", "observerImmerseModeChanged", "onStatusChanged", "Lkotlin/Function1;", "Lcom/larus/platform/model/bot/BotBgImageChangeData;", "changeData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ReferenceMsgComponentViewModel extends ComponentViewModel<ReferenceMsgComponentViewState> {
    private final Lazy enableCreateMarkdownOnMain$delegate;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$clearReferenceMessage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$clearReferenceMessage$2", f = "ReferenceMsgComponentViewModel.kt", i = {0, 0}, l = {120, 122}, m = "invokeSuspend", n = {"action", "refMsg"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceClear;
        final /* synthetic */ Message $message;
        final /* synthetic */ Function4<String, ReferenceMessage, List<String>, String, Unit> $onUpdateRefMsg;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$clearReferenceMessage$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$clearReferenceMessage$2$1", f = "ReferenceMsgComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $action;
            final /* synthetic */ Function4<String, ReferenceMessage, List<String>, String, Unit> $onUpdateRefMsg;
            final /* synthetic */ Ref.ObjectRef<ReferenceMessage> $refMsg;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function4<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, Unit> r1, Ref.ObjectRef<String> r2, Ref.ObjectRef<ReferenceMessage> r3, Continuation<? super AnonymousClass1> r4) {
                this.$onUpdateRefMsg = r1;
                this.$action = r2;
                this.$refMsg = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass1(this.$onUpdateRefMsg, this.$action, this.$refMsg, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                this.$onUpdateRefMsg.invoke(this.$action.element, this.$refMsg.element, CollectionsKt.emptyList(), null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(boolean r1, Message r2, Function4<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, Unit> r3, Continuation<? super AnonymousClass2> r4) {
            this.$forceClear = r1;
            this.$message = r2;
            this.$onUpdateRefMsg = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$forceClear, this.$message, this.$onUpdateRefMsg, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$2;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r9);
        L21:
            r2.element = r9;
            r2 = r4;
        L22:
            MainCoroutineDispatcher r10 = Dispatchers.getMain();
            AnonymousClass1 r6 = new AnonymousClass1(this.$onUpdateRefMsg, r5, r2, null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (BuildersKt.withContext(r10, r6, this) != r0) goto L26;
            return r0;
        L10:
            ResultKt.throwOnFailure(r9);
            r5 = new Ref.ObjectRef();
            r5.element = "action_delete";
            if (this.$forceClear == false) goto L13;
            r5.element = "action_force_delete";
        L13:
            r2 = new Ref.ObjectRef();
            ReferenceMessage.Companion r11 = ReferenceMessage.Companion;
            r11.getClass();
            r2.element = ReferenceMessage.access$getEMPTY_REFERENCE_MESSAGE$cp();
            Message r7 = this.$message;
            if (r7 == null) goto L22;
            if (this.$forceClear == true) goto L22;
            this.L$0 = r5;
            this.L$1 = r2;
            this.L$2 = r2;
            this.label = 1;
            r9 = r11.b(r7, null, this);
            if (r9 != r0) goto L20;
            return r0;
        L20:
            r4 = r2;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$observerImmerseModeChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$observerImmerseModeChanged$1", f = "ReferenceMsgComponentViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_VUI_ERROR}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<nq9.b, Unit> $onStatusChanged;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$observerImmerseModeChanged$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ Function1<nq9.b, Unit> a;

            public a(Function1<? super nq9.b, Unit> r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                Function1<nq9.b, Unit> r3 = this.a;
                r3.invoke((nq9.b) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Function1<? super nq9.b, Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$onStatusChanged = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$onStatusChanged, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L14:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            d1 r6 = m3.a.c();
            if (r6 == null) goto L16;
            a r2 = new a(this.$onStatusChanged);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageAndShowIme$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageAndShowIme$2", f = "ReferenceMsgComponentViewModel.kt", i = {0}, l = {69, 88}, m = "invokeSuspend", n = {"suggestList"}, s = {"L$0"})
    public static final class C01512 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $botType;
        final /* synthetic */ Message $message;
        final /* synthetic */ Function7<String, ReferenceMessage, List<String>, String, Boolean, String, Boolean, Unit> $onUpdateRefMsg;
        final /* synthetic */ RefEntranceType $refEntrance;
        final /* synthetic */ String $refScene;
        final /* synthetic */ String $referenceAction;
        final /* synthetic */ boolean $showIme;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageAndShowIme$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageAndShowIme$2$1", f = "ReferenceMsgComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function7<String, ReferenceMessage, List<String>, String, Boolean, String, Boolean, Unit> $onUpdateRefMsg;
            final /* synthetic */ RefEntranceType $refEntrance;
            final /* synthetic */ ReferenceMessage $refMsg;
            final /* synthetic */ String $refScene;
            final /* synthetic */ String $referenceAction;
            final /* synthetic */ boolean $showIme;
            final /* synthetic */ List<String> $suggestList;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function7<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, ? super Boolean, ? super String, ? super Boolean, Unit> r1, ReferenceMessage r2, List<String> r3, String r4, boolean r5, String r6, RefEntranceType r7, Continuation<? super AnonymousClass1> r8) {
                this.$onUpdateRefMsg = r1;
                this.$refMsg = r2;
                this.$suggestList = r3;
                this.$referenceAction = r4;
                this.$showIme = r5;
                this.$refScene = r6;
                this.$refEntrance = r7;
                super(2, r8);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass1(this.$onUpdateRefMsg, this.$refMsg, this.$suggestList, this.$referenceAction, this.$showIme, this.$refScene, this.$refEntrance, r11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r10);
                Function7<String, ReferenceMessage, List<String>, String, Boolean, String, Boolean, Unit> r1 = this.$onUpdateRefMsg;
                ReferenceMessage r3 = this.$refMsg;
                List<String> r4 = this.$suggestList;
                String r5 = this.$referenceAction;
                Boolean r6 = Boxing.boxBoolean(this.$showIme);
                String r7 = this.$refScene;
                if (this.$refEntrance != RefEntranceType.TaskCardQuestion) goto L7;
                boolean r11 = true;
            L8:
                r1.invoke("action_update", r3, r4, r5, r6, r7, Boxing.boxBoolean(r11));
                return Unit.INSTANCE;
            L7:
                r11 = false;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01512(Integer r1, Message r2, String r3, Function7<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, ? super Boolean, ? super String, ? super Boolean, Unit> r4, String r5, boolean r6, RefEntranceType r7, Continuation<? super C01512> r8) {
            this.$botType = r1;
            this.$message = r2;
            this.$refScene = r3;
            this.$onUpdateRefMsg = r4;
            this.$referenceAction = r5;
            this.$showIme = r6;
            this.$refEntrance = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C01512(this.$botType, this.$message, this.$refScene, this.$onUpdateRefMsg, this.$referenceAction, this.$showIme, this.$refEntrance, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r14v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v4 */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L73:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r14);
            ?? r7 = r2;
        L69:
            ReferenceMessage r6 = (ReferenceMessage) r14;
            MainCoroutineDispatcher r15 = Dispatchers.getMain();
            AnonymousClass1 r3 = new AnonymousClass1(this.$onUpdateRefMsg, r6, r7, this.$referenceAction, this.$showIme, this.$refScene, this.$refEntrance, null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(r15, r3, this) != r0) goto L73;
            return r0;
        L10:
            ResultKt.throwOnFailure(r14);
            int r16 = l0.a;
            Integer r17 = this.$botType;
            if (r17 == null) goto L24;
            r17.intValue();
            HoverActionConfig r5 = z2.a.r();
            int r18 = r17.intValue();
            if (r18 == 0) goto L19;
            if (r18 == 1) goto L18;
            if (r18 == 2) goto L17;
            boolean r19 = false;
        L20:
            if (r19 == false) goto L24;
            if (r5.getShowSuggestOnInput() == false) goto L24;
            boolean r110 = true;
        L25:
            if (r110 == false) goto L42;
            List r111 = this.$message.getSuggestQuestions();
            if (r111 == null) goto L41;
            ArrayList r8 = new ArrayList();
            Iterator r112 = r111.iterator();
        L30:
            if (r112.hasNext() == false) goto L34;
            Object r9 = r112.next();
            if (o0.d(((SuggestQuestion) r9).content) == false) goto L30;
            r8.add(r9);
            goto L30
        L34:
            ?? r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r10 = r8.iterator();
        L36:
            if (r10.hasNext() == false) goto L43;
            String r11 = ((SuggestQuestion) r10.next()).content;
            if (r11 != null) goto L40;
            r11 = "";
        L40:
            r113.add(r11);
        L43:
            ReferenceMessage.Companion r12 = ReferenceMessage.Companion;
            Message r13 = this.$message;
            if (Intrinsics.areEqual(this.$refScene, "task_card_ref") == false) goto L64;
            LinkedHashMap r20 = new LinkedHashMap();
            r20.put("ref_icon_key", "task");
            Iterator r21 = com.larus.im.bean.message.a.d(this.$message).iterator();
        L47:
            if (r21.hasNext() == false) goto L54;
            Object r22 = r21.next();
            if (((Block) r22).getBlockType() != BlockType.BLOCK_TYPE_TASK_CARD.getValue()) goto L51;
            boolean r114 = true;
        L52:
            if (r114 == false) goto L47;
        L55:
            Block r23 = (Block) r22;
            if (r23 == null) goto L65;
            JSONObject r4 = new JSONObject();
            r4.put("action", 1);
            BlockContent r24 = r23.getContent();
            if (r24 == null) goto L62;
            TaskCardBlock r25 = r24.getTaskCardBlock();
            if (r25 == null) goto L62;
            String r26 = r25.threadId;
        L63:
            r4.put("thread_id", r26);
            r4.put("source_type", 1);
            Unit r27 = Unit.INSTANCE;
            r20.put("general_task_param", r4.toString());
        L62:
            r26 = null;
        L65:
            this.L$0 = r113;
            this.label = 1;
            Object r28 = r12.b(r13, r20, this);
            if (r28 != r0) goto L68;
            return r0;
        L68:
            r7 = r113;
            r14 = r28;
            goto L69
        L51:
            r114 = false;
            goto L52
        L54:
            r22 = null;
            goto L55
        L64:
            r20 = null;
            goto L65
        L41:
            r113 = CollectionsKt.emptyList();
            goto L43
        L42:
            r113 = CollectionsKt.emptyList();
            goto L43
        L17:
            r19 = r5.getSupportOfficialBot();
            goto L20
        L18:
            r19 = r5.getSupportMainBot();
            goto L20
        L19:
            r19 = r5.getSupportUserBot();
        L24:
            r110 = false;
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageWithoutReply$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageWithoutReply$2", f = "ReferenceMsgComponentViewModel.kt", i = {}, l = {101, 102}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $message;
        final /* synthetic */ String $referenceAction;
        final /* synthetic */ boolean $showIme;
        final /* synthetic */ Function4<String, ReferenceMessage, String, Boolean, Unit> $updateRefMsgWithoutReply;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageWithoutReply$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponentViewModel$setReferenceMessageWithoutReply$2$1", f = "ReferenceMsgComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ReferenceMessage $refMsg;
            final /* synthetic */ String $referenceAction;
            final /* synthetic */ boolean $showIme;
            final /* synthetic */ Function4<String, ReferenceMessage, String, Boolean, Unit> $updateRefMsgWithoutReply;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function4<? super String, ? super ReferenceMessage, ? super String, ? super Boolean, Unit> r1, ReferenceMessage r2, String r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
                this.$updateRefMsgWithoutReply = r1;
                this.$refMsg = r2;
                this.$referenceAction = r3;
                this.$showIme = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass1(this.$updateRefMsgWithoutReply, this.$refMsg, this.$referenceAction, this.$showIme, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                this.$updateRefMsgWithoutReply.invoke("action_update", this.$refMsg, this.$referenceAction, Boxing.boxBoolean(this.$showIme));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01522(Message r1, Function4<? super String, ? super ReferenceMessage, ? super String, ? super Boolean, Unit> r2, String r3, boolean r4, Continuation<? super C01522> r5) {
            this.$message = r1;
            this.$updateRefMsgWithoutReply = r2;
            this.$referenceAction = r3;
            this.$showIme = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01522(this.$message, this.$updateRefMsgWithoutReply, this.$referenceAction, this.$showIme, r8);
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
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L13:
            ReferenceMessage r5 = (ReferenceMessage) r10;
            MainCoroutineDispatcher r11 = Dispatchers.getMain();
            AnonymousClass1 r2 = new AnonymousClass1(this.$updateRefMsgWithoutReply, r5, this.$referenceAction, this.$showIme, null);
            this.label = 2;
            if (BuildersKt.withContext(r11, r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            ReferenceMessage.Companion r12 = ReferenceMessage.Companion;
            Message r3 = this.$message;
            this.label = 1;
            r10 = r12.b(r3, null, this);
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    public static /* synthetic */ Unit No(String r0, ReferenceMessage r1, List r2, String r3, boolean r4, String r5, boolean r6) {
        return setReferenceMessageAndShowIme$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit Oo(String r0, ReferenceMessage r1, List r2, String r3) {
        return clearReferenceMessage$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit Po(String r0, ReferenceMessage r1, String r2, boolean r3) {
        return setReferenceMessageWithoutReply$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean Qo() {
        return enableCreateMarkdownOnMain_delegate$lambda$0();
    }

    private static final boolean enableCreateMarkdownOnMain_delegate$lambda$0() {
        return p1.a.enableCreateMarkdownOnMain();
    }

    private final boolean getEnableCreateMarkdownOnMain() {
        return ((Boolean) this.enableCreateMarkdownOnMain$delegate.getValue()).booleanValue();
    }

    public ReferenceMsgComponentViewModel() {
        this.enableCreateMarkdownOnMain$delegate = LazyKt.lazy(new j0());
    }

    public final void observerImmerseModeChanged(Function1<? super nq9.b, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onStatusChanged");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(r8, null), 3, null);
    }

    public final void clearReferenceMessage(Message r8, boolean r9, Function4<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onUpdateRefMsg");
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new AnonymousClass2(r9, r8, r10, null), 2, null);
    }

    private static final Unit clearReferenceMessage$lambda$3(String r0, ReferenceMessage r1, List r2, String r3) {
        Intrinsics.checkNotNullParameter(r0, "<unused var>");
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final Unit setReferenceMessageWithoutReply$lambda$2(String r0, ReferenceMessage r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "<unused var>");
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    public final void setReferenceMessageWithoutReply(Message r11, String r12, boolean r13, Function4<? super String, ? super ReferenceMessage, ? super String, ? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r14, "updateRefMsgWithoutReply");
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01522(r11, r14, r12, r13, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clearReferenceMessage$default(ReferenceMsgComponentViewModel r0, Message r1, boolean r2, Function4 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new k0();
    L5:
        r0.clearReferenceMessage(r1, r2, r3);
    }

    private static final Unit setReferenceMessageAndShowIme$lambda$1(String r0, ReferenceMessage r1, List r2, String r3, boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r0, "<unused var>");
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setReferenceMessageWithoutReply$default(ReferenceMsgComponentViewModel r0, Message r1, String r2, boolean r3, Function4 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new i0();
    L5:
        r0.setReferenceMessageWithoutReply(r1, r2, r3, r4);
    }

    public final void setReferenceMessageAndShowIme(Message r14, Integer r15, String r16, boolean r17, String r18, RefEntranceType r19, Function7<? super String, ? super ReferenceMessage, ? super List<String>, ? super String, ? super Boolean, ? super String, ? super Boolean, Unit> r20) {
        Intrinsics.checkNotNullParameter(r14, "message");
        Intrinsics.checkNotNullParameter(r20, "onUpdateRefMsg");
        if (getEnableCreateMarkdownOnMain() == false) goto L5;
        MainCoroutineDispatcher r0 = Dispatchers.getMain();
    L6:
        CoroutineScope r10 = getViewModelScope();
        C01512 r12 = new C01512(r15, r14, r18, r20, r16, r17, r19, null);
        BuildersKt.launch$default(r10, r0, null, r12, 2, null);
        return;
    L5:
        r0 = Dispatchers.getIO();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setReferenceMessageAndShowIme$default(ReferenceMsgComponentViewModel r9, Message r10, Integer r11, String r12, boolean r13, String r14, RefEntranceType r15, Function7 r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r17 & 16) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        RefEntranceType r7 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        Function7 r8 = new h0();
    L18:
        r9.setReferenceMessageAndShowIme(r10, r11, r12, r5, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
