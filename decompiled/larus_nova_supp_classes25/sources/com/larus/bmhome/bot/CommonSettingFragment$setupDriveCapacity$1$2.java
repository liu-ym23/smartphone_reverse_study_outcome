package com.larus.bmhome.bot;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.platform.service.FlowDriveSdkService;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupDriveCapacity$1$2", f = "CommonSettingFragment.kt", i = {}, l = {2698}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$setupDriveCapacity$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemTextArrow $this_apply;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.CommonSettingFragment$setupDriveCapacity$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupDriveCapacity$1$2$1", f = "CommonSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $subText;
        final /* synthetic */ ItemTextArrow $this_apply;
        int label;

        public AnonymousClass1(ItemTextArrow r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$this_apply = r1;
            this.$subText = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$this_apply, this.$subText, r4);
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
            this.$this_apply.getSubTextView().setText(this.$subText);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CommonSettingFragment$setupDriveCapacity$1$2(CommonSettingFragment r1, ItemTextArrow r2, Continuation<? super CommonSettingFragment$setupDriveCapacity$1$2> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$setupDriveCapacity$1$2(this.this$0, this.$this_apply, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        com.larus.platform.api.p r9 = (com.larus.platform.api.p) r8;
        if (r9 == null) goto L14;
        CommonSettingFragment r2 = this.this$0;
        BigDecimal r3 = CommonSettingFragment.k1;
        r2.getClass();
        String r4 = CommonSettingFragment.Ha0(r9.c);
        if (r9.a == false) goto L18;
        r4 = r4 + " / " + CommonSettingFragment.Ha0(r9.b);
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain(), null, new AnonymousClass1(this.$this_apply, r4, null), 2, null);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FlowDriveSdkService r10 = FlowDriveSdkService.a;
        this.label = 1;
        r8 = r10.d(this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
