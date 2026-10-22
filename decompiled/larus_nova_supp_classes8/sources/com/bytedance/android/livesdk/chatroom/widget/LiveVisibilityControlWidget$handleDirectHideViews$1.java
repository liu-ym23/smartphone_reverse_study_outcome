package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", "item", "", "invoke", "(Lcom/bytedance/android/live/room/api/visibilitycontrol/d;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget$handleDirectHideViews$1 extends Lambda implements Function1<com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ LiveVisibilityControlWidget this$0;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d a;

        public a(com.bytedance.android.live.room.api.visibilitycontrol.d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            UtilityKotlinExtentionsKt.w(this.a.h);
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d a;

        public b(com.bytedance.android.live.room.api.visibilitycontrol.d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            UtilityKotlinExtentionsKt.u(this.a.h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            UtilityKotlinExtentionsKt.w(this.a.h);
        }
    }

    public LiveVisibilityControlWidget$handleDirectHideViews$1(LiveVisibilityControlWidget r1, boolean r2, long r3) {
        this.this$0 = r1;
        this.$entiretyVisible = r2;
        this.$duration = r3;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(com.bytedance.android.live.room.api.visibilitycontrol.d r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (r7.n == true) goto L5;
        boolean r0 = this.$entiretyVisible;
    L9:
        int r1 = !r0;
        Integer r2 = (Integer) r7.e.getValue();
        if (r2 != null) goto L13;
    L15:
        r7.e.postValue(Integer.valueOf(r1));
        if (this.$duration <= 0) goto L22;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(this.$duration);
        if (r0 == 0) goto L20;
        r3.addListener(new a(r7));
    L21:
        ((ArrayList) this.this$0.v).add(r3);
        return;
    L20:
        r3.addListener(new b(r7));
        goto L21
    L22:
        UtilityKotlinExtentionsKt.A(r7.h, r0);
        return;
    L13:
        if (r2.intValue() != r1) goto L15;
        return;
    L5:
        if (this.$entiretyVisible == true) goto L7;
        r0 = 1;
        goto L9
    L7:
        r0 = 0;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.room.api.visibilitycontrol.d) r1);
        return Unit.INSTANCE;
    }
}
