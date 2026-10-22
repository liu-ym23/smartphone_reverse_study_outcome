package com.bytedance.android.ec.core.arch.event;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final <I extends d, S extends com.bytedance.android.ec.core.arch.state.b> void d(QStateViewModel<S> r1, I r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$sendEvent");
        Intrinsics.checkNotNullParameter(r10, "event");
        int r0 = b.a;
        b.b(r1, r10, false);
    }

    public static final void e(LivePromotionListViewModel r1, com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$sendEventSticky");
        Intrinsics.checkNotNullParameter(r10, "event");
        int r0 = b.a;
        b.b(r1, r10, true);
    }

    public static /* synthetic */ void b(QStateViewModel r1, KClass r10, Function1 r11) {
        a(r1, r10, Dispatchers.getIO(), r11);
    }

    public static final <I extends d, S extends com.bytedance.android.ec.core.arch.state.b> void a(QStateViewModel<S> r10, KClass<I> r11, CoroutineDispatcher r12, Function1<? super I, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$observeEvent");
        Intrinsics.checkNotNullParameter(r11, "eventKClass");
        Intrinsics.checkNotNullParameter(r12, "dispatcher");
        Intrinsics.checkNotNullParameter(r13, "block");
        b.a(r10, false, null, r12, r11, r13, 4);
    }

    public static final <I extends d, S extends com.bytedance.android.ec.core.arch.state.b> void c(QStateViewModel<S> r10, LifecycleOwner r11, KClass<I> r12, Function1<? super I, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$observeEventLifecycleSafety");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "eventKClass");
        Intrinsics.checkNotNullParameter(r13, "block");
        b.a(r10, true, r11, null, r12, r13, 8);
    }
}
