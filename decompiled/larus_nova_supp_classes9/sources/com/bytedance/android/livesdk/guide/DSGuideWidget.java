package com.bytedance.android.livesdk.guide;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.t0;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.DSConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/guide/DSGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DSGuideWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public HSImageView a;
    public RoomContext b;
    public boolean c;
    public AnimatorSet d;
    public boolean e;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ DSGuideWidget a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public a(DSGuideWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            View r4 = ((Widget) this.a).contentView;
            if (r4 == null) goto L5;
            r4.setVisibility(8);
        L5:
            RoomContext r5 = this.a.b;
            if (r5 == null) goto L10;
            m r6 = r5.isShowDSGuideAnim();
            if (r6 == null) goto L10;
            r6.setValue(Boolean.FALSE);
        L10:
            DataCenter r7 = ((Widget) this.a).dataCenter;
            if (r7 == null) goto L13;
            r7.put("data_enter_room_guide_anim_finish", Boolean.TRUE);
        L13:
            String r8 = t0.b.format(new Date());
            int r0 = v5.b().getInt(r8, 0);
            v5.a().putInt(r8, r0 + 1).apply();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r6) {
            Intrinsics.checkNotNullParameter(r6, "animation");
            DSGuideWidget r0 = this.a;
            if (r0.c == false) goto L6;
            r6.end();
            return;
        L6:
            r0.getClass();
            HashMap r7 = new HashMap();
            r7.put("channel_type", "room_enter");
            u.l().sendLog("livesdk_consumer_assistant_animation_show", r7, new Object[]{x.class, Room.class});
            View r8 = ((Widget) this.a).contentView;
            if (r8 == null) goto L10;
            r8.setVisibility(0);
            return;
        }
    }

    public final int getLayoutId() {
        return 2131567392;
    }

    public final void onUnload() {
        AnimatorSet r0 = this.d;
        if (r0 == null) goto L5;
        r0.end();
    L5:
        AnimatorSet r1 = this.d;
        if (r1 == null) goto L9;
        r1.removeAllListeners();
        return;
    }

    public DSGuideWidget() {
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Object r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "cmd_end_live") == false) goto L20;
        Object r6 = r5.getData();
        if ((r6 instanceof Boolean) == false) goto L12;
        r0 = r6;
    L12:
        Boolean r2 = (Boolean) r0;
        if (r2 == null) goto L21;
        boolean r7 = r2.booleanValue();
        this.c = r7;
        if (r7 == false) goto L22;
        AnimatorSet r8 = this.d;
        if (r8 == null) goto L23;
        r8.end();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onInit(Object[] r1) {
        this.a = findViewById(2131375148);
    }

    public final void onLoad(Object[] r14) {
        View r15 = ((Widget) this).contentView;
        if (r15 == null) goto L5;
        r15.setVisibility(8);
    L5:
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        this.b = r16;
        if (r16 == null) goto L12;
        m r17 = r16.isShowDSGuideAnim();
        if (r17 == null) goto L12;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L12;
        boolean r19 = r18.booleanValue();
    L13:
        this.e = r19;
        RoomContext r110 = this.b;
        if (r110 == null) goto L18;
        m r111 = r110.getDsGuideUrl();
        if (r111 == null) goto L18;
        String r112 = (String) r111.getValue();
    L19:
        ((Widget) this).dataCenter.observe("cmd_end_live", this);
        this.c = ((Boolean) ((Widget) this).dataCenter.get("cmd_end_live", Boolean.FALSE)).booleanValue();
        if (this.e == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(r112) == false) goto L24;
        return;
    L24:
        if (this.c == true) goto L65;
        FrescoLoader r113 = FrescoLoader.with(getContext()).actualScaleType(ImageView.ScaleType.CENTER_INSIDE).load(r112);
        HSImageView r1 = this.a;
        if (r1 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("animImage");
    L29:
        r113.into(r1);
        float r114 = s1.f(126.0f);
        HSImageView r2 = this.a;
        if (r2 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("animImage");
    L32:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "translationY", new float[]{r114, 0.0f});
        r3.setDuration(600);
        HSImageView r4 = this.a;
        if (r4 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("animImage");
    L35:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{0.0f, 1.0f});
        r5.setDuration(600);
        HSImageView r10 = this.a;
        if (r10 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("animImage");
    L38:
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r10, "translationY", new float[]{0.0f, -r114});
        r115.setDuration(600);
        HSImageView r6 = this.a;
        if (r6 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("animImage");
    L41:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{1.0f, 0.0f});
        r7.setDuration(600);
        AnimatorSet r8 = new AnimatorSet();
        this.d = r8;
        r8.playTogether(new Animator[]{r3, r5});
        AnimatorSet r0 = this.d;
        if (r0 == null) goto L52;
        AnimatorSet.Builder r116 = r0.play(r115);
        if (r116 == null) goto L52;
        AnimatorSet.Builder r117 = r116.with(r7);
        if (r117 == null) goto L52;
        DSConfig r9 = t0.a;
        if (r9 == null) goto L50;
        long r11 = r9.getDuration();
    L51:
        r117.after(r11 + ((long) 600));
        goto L52
    L50:
        r11 = 3000;
    L52:
        AnimatorSet r118 = this.d;
        if (r118 == null) goto L55;
        r118.addListener(new a(this));
    L55:
        AnimatorSet r119 = this.d;
        if (r119 == null) goto L58;
        r119.setStartDelay(300);
    L58:
        AnimatorSet r120 = this.d;
        if (r120 == null) goto L64;
        r120.start();
        return;
    L64:
        return;
    L65:
        return;
    L18:
        r112 = null;
    L12:
        r19 = false;
        goto L13
    }
}
