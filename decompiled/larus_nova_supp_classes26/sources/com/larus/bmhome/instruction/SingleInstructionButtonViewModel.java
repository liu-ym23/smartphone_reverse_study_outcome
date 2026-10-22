package com.larus.bmhome.instruction;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.platform.service.o2;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/instruction/SingleInstructionButtonViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/instruction/ComponentSingleInstructionState;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "updateConversationId", "", "botId", "", "conversationId", "currentCacheLoad", "", "Ljava/lang/Integer;", "getLefBottomCacheByConversation", "updateLefBottomCacheByConversation", "value", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleInstructionButtonViewModel extends ComponentViewModel<ComponentSingleInstructionState> {
    public static final String BOTTOM_CACHE_KEY = "bottom_cache_key";
    public static final a Companion = null;
    private Integer currentCacheLoad;
    private final Keva keva;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.SingleInstructionButtonViewModel$updateConversationId$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.instruction.SingleInstructionButtonViewModel$updateConversationId$1", f = "SingleInstructionButtonViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ SingleInstructionButtonViewModel this$0;

        public AnonymousClass1(SingleInstructionButtonViewModel r1, String r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$botId = r2;
            this.$conversationId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$botId, this.$conversationId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            if (TextUtils.equals(((ComponentSingleInstructionState) this.this$0.getState()).getBotId(), this.$botId) == false) goto L8;
            SingleInstructionButtonViewModel.access$setState(this.this$0, new g2());
            return Unit.INSTANCE;
        L8:
            SingleInstructionButtonViewModel r5 = this.this$0;
            final String r0 = this.$botId;
            SingleInstructionButtonViewModel.access$setState(r5, new h2(r0));
            BotRepo r6 = z1.a;
            final String r7 = this.$botId;
            String r1 = this.$conversationId;
            final SingleInstructionButtonViewModel r2 = this.this$0;
            z1.a(r7, r1, new i2(r2, r7));
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public SingleInstructionButtonViewModel() {
        this.keva = Keva.getRepo(o2.a.e(), 0);
    }

    public final int getLefBottomCacheByConversation(String r5) {
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        if (this.currentCacheLoad != null) goto L5;
        this.currentCacheLoad = Integer.valueOf(this.keva.getInt(BOTTOM_CACHE_KEY + r5, 0));
    L5:
        Integer r6 = this.currentCacheLoad;
        if (r6 != null) goto L8;
        return 0;
    L8:
        return r6.intValue();
    }

    public static final /* synthetic */ void access$setState(SingleInstructionButtonViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public final void updateConversationId(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }

    public final void updateLefBottomCacheByConversation(String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        if (Intrinsics.areEqual(this.currentCacheLoad, r5) == false) goto L5;
        return;
    L5:
        Keva r0 = this.keva;
        String r6 = BOTTOM_CACHE_KEY + r4;
        if (r5 == null) goto L8;
        int r7 = r5.intValue();
    L9:
        r0.storeInt(r6, r7);
        return;
    L8:
        r7 = 0;
        goto L9
    }
}
