package com.larus.e_commerce.impl.settings;

import android.view.View;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.view.item.ItemTextToggle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.impl.settings.OrderMessageNotifySettingsProviderImpl$getNotifySettingItems$1$1$1$1", f = "OrderMessageNotifySettingsProviderImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class OrderMessageNotifySettingsProviderImpl$getNotifySettingItems$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isToggleChecked;
    final /* synthetic */ View $itemView;
    final /* synthetic */ ISettingRepoService $repo;
    int label;

    public OrderMessageNotifySettingsProviderImpl$getNotifySettingItems$1$1$1$1(ISettingRepoService r1, boolean r2, View r3, Continuation<? super OrderMessageNotifySettingsProviderImpl$getNotifySettingItems$1$1$1$1> r4) {
        this.$repo = r1;
        this.$isToggleChecked = r2;
        this.$itemView = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OrderMessageNotifySettingsProviderImpl$getNotifySettingItems$1$1$1$1(this.$repo, this.$isToggleChecked, this.$itemView, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == true) goto L20;
        ItemTextToggle r5 = this.$itemView;
        if ((r5 instanceof ItemTextToggle) == false) goto L16;
        ItemTextToggle r6 = r5;
    L17:
        if (r6 == null) goto L20;
        ISettingRepoService r2 = this.$repo;
        r6.setRestoring(true);
        r6.getToggleView().setChecked(r2.G0());
        s.a.g(r6.getContext(), 2131908080, false);
        goto L20
    L16:
        r6 = null;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ISettingRepoService r7 = this.$repo;
        boolean r3 = this.$isToggleChecked;
        this.label = 1;
        r4 = r7.J0(r3, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
