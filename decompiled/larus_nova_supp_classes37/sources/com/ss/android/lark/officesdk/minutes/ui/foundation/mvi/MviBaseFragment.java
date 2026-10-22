package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u0006*\u001a\b\u0003\u0010\u0007*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\b2\u00020\tB\u0007¢\u0006\u0004\b\n\u0010\u000bJK\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0004\u0010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u00132\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0004¢\u0006\u0002\u0010\u0018Jk\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00192\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u00132(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001bH\u0004¢\u0006\u0002\u0010\u001cJ\u008b\u0001\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u0019\"\u0004\b\u0006\u0010\u001d2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001d0\u00132.\u0010\u0014\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001fH\u0004¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00102\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0004¢\u0006\u0002\u0010\"R\u0012\u0010\f\u001a\u00028\u0003X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "S", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMState;", "E", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMEvent;", "UE", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/UIEvent;", "VM", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/IViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseFragment;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/IViewModel;", "subscribeState", "", "A", "prop1", "Lkotlin/reflect/KProperty1;", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function2;)V", "B", "prop2", "Lkotlin/Function3;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function3;)V", "C", "prop3", "Lkotlin/Function4;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function4;)V", "subscribeVMEvent", "(Lkotlin/jvm/functions/Function2;)V", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MviBaseFragment<S extends l, E extends k, UE extends j, VM extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a<S, E, UE>> extends MmBaseFragment {
    public abstract VM Z90();

    public MviBaseFragment() {
    }

    public final void aa0(PropertyReference1Impl r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "action");
        Z90().selectSubscribe(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), r3, r4);
    }

    public final void ba0(PropertyReference1Impl r3, PropertyReference1Impl r4, Function3 r5) {
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "action");
        ((MmSummaryFragment) this).ha0().selectSubscribe(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), r3, r4, r5);
    }
}
