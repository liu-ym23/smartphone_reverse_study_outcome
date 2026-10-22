package com.obric.memorydata.recommend.settings;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class HeaderViewHolder$special$$inlined$viewModels$default$3 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Function0 $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    public HeaderViewHolder$special$$inlined$viewModels$default$3(Function0 r3, ComponentActivity r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.memorydata.plugin");
        this.$extrasProducer = r5;
        this.$this_viewModels = r6;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreationExtras invoke() {
        Function0 r0 = this.$extrasProducer;
        if (r0 == null) goto L6;
        CreationExtras r1 = (CreationExtras) ZeusTransformUtils.preCheckCast(r0.invoke(), CreationExtras.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        CreationExtras r2 = this.$this_viewModels.getDefaultViewModelCreationExtras();
        Intrinsics.checkNotNullExpressionValue(r2, "this.defaultViewModelCreationExtras");
        return r2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CreationExtras invoke() {
        return invoke();
    }
}
