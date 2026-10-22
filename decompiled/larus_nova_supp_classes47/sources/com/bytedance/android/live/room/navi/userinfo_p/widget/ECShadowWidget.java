package com.bytedance.android.live.room.navi.userinfo_p.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/widget/ECShadowWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShadowWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {
    public View a;
    public Animator b;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            View r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setAlpha(((Float) r3).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ ECShadowWidget b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.b = null;
            this.a.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.b = null;
            this.a.setAlpha(1.0f);
        }

        public c(View r1, ECShadowWidget r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565832;
    }

    public final void onUnload() {
        f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        Animator r1 = this.b;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.b = null;
    }

    public ECShadowWidget() {
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1765201437)) goto L12;
        return;
    L12:
        if (r0.equals("data_ec_room_user_info_background") == false) goto L17;
        Integer r6 = (Integer) r5.getData();
        if (r6 == null) goto L18;
        wq(r6.intValue());
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onInit(Object[] r1) {
        this.a = ((Widget) this).contentView;
    }

    public final void onLoad(Object[] r4) {
        f.c(this);
        DataCenter r5 = ((Widget) this).dataCenter;
        int r1 = 2131106784;
        if (r5 == null) goto L7;
        Integer r6 = (Integer) r5.get("data_ec_room_user_info_background", 2131106784);
        if (r6 == null) goto L7;
        r1 = r6.intValue();
    L7:
        wq(r1);
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L11;
        r7.observe("data_ec_room_user_info_background", this);
        return;
    }

    public final void wq(int r5) {
        View r1 = this.a;     // Catch: Exception -> L10
        if (r1 == null) goto L15;
        r1.setAlpha(0.0f);     // Catch: Exception -> L10
        r1.setBackgroundResource(r5);     // Catch: Exception -> L10
        Animator r6 = this.b;     // Catch: Exception -> L10
        if (r6 == null) goto L8;
        r6.cancel();     // Catch: Exception -> L10
        this.b = null;     // Catch: Exception -> L10
    L8:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);     // Catch: Exception -> L10
        r7.addUpdateListener(new b(r1));     // Catch: Exception -> L10
        r7.addListener(new c(r1, this));     // Catch: Exception -> L10
        r7.start();     // Catch: Exception -> L10
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L10
        this.b = r7;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        SafetyGuard.a(null, e, "ECShadowWidget changeBackground error");
    }
}
