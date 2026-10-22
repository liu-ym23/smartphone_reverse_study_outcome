package com.bytedance.android.live.profit.livepet.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.livepet.container.k;
import com.bytedance.android.live.profit.livepet.container.n;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class DebugModeKt$enableLivePetDebugView$7 extends Lambda implements Function0<Disposable> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ViewGroup $petContainer;
    final /* synthetic */ ru0.a $petRoomScope;

    public DebugModeKt$enableLivePetDebugView$7(ru0.a r1, Context r2, ViewGroup r3) {
        this.$petRoomScope = r1;
        this.$context = r2;
        this.$petContainer = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m181invoke() {
        return invoke();
    }

    public final Disposable invoke() {
        ru0.a r0 = this.$petRoomScope;
        m r1 = m.e;
        if (r0 == null) goto L11;
        Object r2 = r1.d(r0, com.bytedance.android.live.profit.livepet.container.e.class);
        if (r2 == null) goto L9;
        com.bytedance.android.live.profit.livepet.container.e r3 = (com.bytedance.android.live.profit.livepet.container.e) ((o) r2);
        n r4 = r3.c;
        k r5 = r3.d;
        final View r6 = new View(this.$context);
        r6.setBackgroundColor(ColorProtector.parseColor("#33FF0000"));
        this.$petContainer.addView(r6);
        r6.setLayoutParams(a1.c(r6.getLayoutParams(), null, null, Integer.valueOf(r5.getLeft()), Integer.valueOf(r5.getTop()), Integer.valueOf(r4.a - r5.getRight()), Integer.valueOf(r4.b - r5.getBottom()), 67));
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{1.0f, 0.0f});
        r7.setDuration(1000);
        r7.setRepeatMode(2);
        r7.setRepeatCount(-1);
        DebugModeKt$enableLivePetDebugView$7$1$1 r8 = DebugModeKt$enableLivePetDebugView$7$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "$this$doOnStart");
        Intrinsics.checkNotNullParameter(r8, "callback");
        r7.addListener(new com.bytedance.android.live.revenue.common.d(r8));
        com.bytedance.android.live.revenue.common.e.b(r7, new DebugModeKt$enableLivePetDebugView$7$$special$$inlined$run$lambda$1(this, r6));
        r7.start();
        return RxUtilKt.a(r7, false);
    L9:
        throw new IllegalStateException(("Service " + Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.livepet.container.e.class) + " does not exist").toString());
    L11:
        throw new IllegalArgumentException("Scope is null".toString());
    }
}
