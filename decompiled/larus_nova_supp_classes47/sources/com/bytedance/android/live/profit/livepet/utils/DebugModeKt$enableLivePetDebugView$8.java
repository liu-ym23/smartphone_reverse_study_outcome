package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profit.livepet.container.n;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class DebugModeKt$enableLivePetDebugView$8 extends Lambda implements Function0<Disposable> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ViewGroup $petContainer;
    final /* synthetic */ ru0.a $petRoomScope;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            ToastUtil.b("Start displaying link region", 0);
        }
    }

    public static final class b implements Action {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void run() {
            ToastUtil.b("Stop displaying link region", 0);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ DebugModeKt$enableLivePetDebugView$8 a;
        public final /* synthetic */ n b;

        public c(DebugModeKt$enableLivePetDebugView$8 r1, n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r14) {
            Map r15 = (Map) r14;
            Intrinsics.checkNotNullParameter(r15, "regionMap");
            final AnimatorSet r0 = new AnimatorSet();
            com.bytedance.android.live.revenue.common.e.a(r0, new DebugModeKt$enableLivePetDebugView$8$3$animatorSet$1$1(r0));
            Collection r16 = r15.values();
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r17 = r16.iterator();
        L4:
            if (r17.hasNext() == false) goto L6;
            com.bytedance.android.live.profit.livepet.container.a r2 = (com.bytedance.android.live.profit.livepet.container.a) r17.next();
            View r3 = new View(this.a.$context);
            r3.setBackgroundColor(ColorProtector.parseColor("#990000FF"));
            r3.setAlpha(0.0f);
            this.a.$petContainer.addView(r3);
            r3.setLayoutParams(a1.c(r3.getLayoutParams(), null, null, Integer.valueOf(r2.getLeft()), Integer.valueOf(r2.getTop()), Integer.valueOf(this.b.a - r2.getRight()), Integer.valueOf(this.b.b - r2.getBottom()), 67));
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{0.0f, 1.0f, 0.0f});
            r4.setDuration(1000);
            r4.addListener(new com.bytedance.android.live.profit.livepet.utils.b(r3, this));
            r1.add(r4);
            goto L4
        L6:
            r0.playSequentially(r1);
            return Observable.never().doOnSubscribe(new com.bytedance.android.live.profit.livepet.utils.c(r0)).doOnDispose(new d(r0));
        }
    }

    public DebugModeKt$enableLivePetDebugView$8(ru0.a r1, Context r2, ViewGroup r3) {
        this.$petRoomScope = r1;
        this.$context = r2;
        this.$petContainer = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m182invoke() {
        return invoke();
    }

    public final Disposable invoke() {
        ru0.a r0 = this.$petRoomScope;
        m r1 = m.e;
        if (r0 == null) goto L11;
        Object r2 = r1.d(r0, com.bytedance.android.live.profit.livepet.container.e.class);
        if (r2 == null) goto L9;
        n r3 = ((com.bytedance.android.live.profit.livepet.container.e) ((o) r2)).c;
        Intrinsics.checkNotNullParameter(r3, "parent");
        return Observable.defer(new com.bytedance.android.live.profit.livepet.container.b(r3)).doOnSubscribe(a.a).doOnDispose(b.a).switchMap(new c(this, r3)).subscribe();
    L9:
        throw new IllegalStateException(("Service " + Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.livepet.container.e.class) + " does not exist").toString());
    L11:
        throw new IllegalArgumentException("Scope is null".toString());
    }
}
