package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.g6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public HSImageView A;
    public TextView B;
    public LinearLayout C;
    public HSImageView D;
    public TextView E;
    public LottieAnimationView F;
    public TextView G;
    public AnimatorSet H;
    public LinearLayout z;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131566584;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        gh0.b.a("audio_layer_update", "MultiLinkAudioFirstUserMicSeatBasicLayer#onCreate", false);
        this.F = q().findViewById(2131374103);
        this.G = (TextView) q().findViewById(2131374093);
        this.z = (LinearLayout) q().findViewById(2131374095);
        this.A = q().findViewById(2131374094);
        this.B = (TextView) q().findViewById(2131374096);
        this.C = (LinearLayout) q().findViewById(2131374098);
        this.D = q().findViewById(2131374097);
        this.E = (TextView) q().findViewById(2131374099);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        super.A(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public h(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r18, int r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "itemData");
        Intrinsics.checkNotNullParameter(r20, "payload");
        super.B(r18, r19, r20);
        Iterator<String> r1 = r20.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L103;
        String r2 = r1.next();
        if (r2 == null) goto L4;
        if (r2.hashCode() != 281544963) goto L4;
        if (r2.equals("payload_key_audio_anchor_guest_info_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r3 = this.e;
        if ((r3 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L16;
        r3 = null;
    L16:
        MultiLinkAudioFirstUserViewBinder.a r4 = (MultiLinkAudioFirstUserViewBinder.a) r3;
        if (r4 == null) goto L4;
        ch0.l r5 = r4.s;
        if (r5 == null) goto L4;
        f6 r6 = r5.b;
        if (r6 == null) goto L71;
        List r7 = r6.getInfoItems();
        if (r7 == null) goto L71;
        if (r7.size() < 3) goto L71;
        String r9 = "right = " + ((g6) ListProtector.get(r7, 0)).getContent() + ", left = " + ((g6) ListProtector.get(r7, 1)).getContent() + ", description = " + ((g6) ListProtector.get(r7, 2)).getContent();
        boolean r10 = gh0.b.a;
        gh0.b.a("AudioAnchorGuide", "bindAnchorGuideInfo, content = " + r9, false);
        int r11 = 0;
    L29:
        if (r11 > 2) goto L71;
        g6 r12 = (g6) ListProtector.get(r7, r11);
        if (r11 == 0) goto L33;
        if (r11 != 1) goto L62;
        if (TextUtils.isEmpty(r12.getContent()) == false) goto L52;
        LinearLayout r13 = this.z;
        if (r13 == null) goto L69;
        r13.setVisibility(4);
    L69:
        r11 = r11 + 1;
        goto L29
    L52:
        TextView r14 = this.B;
        if (r14 == null) goto L56;
        r14.setText(r12.getContent());
    L56:
        if (r12.getIconModel() != null) goto L60;
        HSImageView r15 = this.A;
        if (r15 == null) goto L69;
        r15.setVisibility(8);
        goto L69
    L60:
        int r16 = s1.f(14.0f);
        ImageUtil.loadImage(this.A, r12.getIconModel(), r16, r16, null);
        goto L69
    L62:
        if (TextUtils.isEmpty(r12.getContent()) == false) goto L66;
        TextView r17 = this.G;
        if (r17 == null) goto L69;
        r17.setVisibility(8);
        goto L69
    L66:
        TextView r110 = this.G;
        if (r110 == null) goto L69;
        r110.setText(r12.getContent());
        goto L69
    L33:
        if (TextUtils.isEmpty(r12.getContent()) == false) goto L37;
        LinearLayout r111 = this.C;
        if (r111 == null) goto L69;
        r111.setVisibility(4);
        goto L69
    L37:
        TextView r112 = this.E;
        if (r112 == null) goto L41;
        r112.setText(r12.getContent());
    L41:
        if (r12.getIconModel() != null) goto L45;
        HSImageView r113 = this.D;
        if (r113 == null) goto L69;
        r113.setVisibility(8);
        goto L69
    L45:
        int r114 = s1.f(14.0f);
        ImageUtil.loadImage(this.D, r12.getIconModel(), r114, r114, null);
    L71:
        if (GuestBattleContext.Companion.e() == true) goto L4;
        if (ThemedCompetitionContext.Companion.g() == true) goto L4;
        int r8 = s1.f(30.0f);
        MultiLinkMicSeatGiftIconElement r21 = this.m;
        if (r21 == null) goto L78;
        LinkMicQuickInteractView r22 = r21.c;
    L79:
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r22, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.G, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet r116 = new AnimatorSet();
        r116.setDuration(240);
        r116.playTogether(new Animator[]{r23, r115});
        r116.addListener(new b(this));
        float r24 = r8;
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.C, View.TRANSLATION_Y, new float[]{r24, 0.0f});
        r25.setDuration(800);
        r25.setInterpolator(PathInterpolatorCompat.create(0.03f, 0.2f, 0.16f, 0.99f));
        ObjectAnimator r26 = ObjectAnimator.ofFloat(this.C, View.ALPHA, new float[]{0.0f, 1.0f});
        r26.setDuration(400);
        AnimatorSet r117 = new AnimatorSet();
        r117.setStartDelay(240);
        r117.playTogether(new Animator[]{r26, r25});
        r117.addListener(new c(this));
        ObjectAnimator r27 = ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Y, new float[]{r24, 0.0f});
        r27.setInterpolator(PathInterpolatorCompat.create(0.14f, 1.0f, 0.34f, 1.0f));
        r27.setDuration(800);
        ObjectAnimator r28 = ObjectAnimator.ofFloat(this.z, View.ALPHA, new float[]{0.0f, 1.0f});
        r28.setDuration(400);
        AnimatorSet r29 = new AnimatorSet();
        r29.setStartDelay(640);
        r29.playTogether(new Animator[]{r28, r27});
        r29.addListener(new d(this));
        ObjectAnimator r30 = ObjectAnimator.ofFloat(this.G, View.ALPHA, new float[]{1.0f, 0.0f});
        r30.setDuration(240);
        r30.setStartDelay(5480);
        r30.addListener(new e(this));
        float r31 = -r24;
        ObjectAnimator r32 = ObjectAnimator.ofFloat(this.C, View.TRANSLATION_Y, new float[]{0.0f, r31});
        r32.setDuration(800);
        r32.setInterpolator(PathInterpolatorCompat.create(0.84f, 0.02f, 0.75f, 0.99f));
        ObjectAnimator r33 = ObjectAnimator.ofFloat(this.C, View.ALPHA, new float[]{1.0f, 0.0f});
        r33.setDuration(320);
        AnimatorSet r118 = new AnimatorSet();
        r118.setStartDelay(5000);
        r118.playTogether(new Animator[]{r32, r33});
        r118.addListener(new f(this));
        ObjectAnimator r34 = ObjectAnimator.ofFloat(this.z, View.TRANSLATION_Y, new float[]{0.0f, r31});
        r34.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.68f, 0.06f));
        r34.setDuration(760);
        ObjectAnimator r35 = ObjectAnimator.ofFloat(this.z, View.ALPHA, new float[]{1.0f, 0.0f});
        r35.setDuration(320);
        AnimatorSet r36 = new AnimatorSet();
        r36.setStartDelay(5040);
        r36.playTogether(new Animator[]{r34, r35});
        r36.addListener(new g(this));
        this.H = new AnimatorSet();
        TextView r37 = this.G;
        if (r37 == null) goto L82;
        CharSequence r38 = r37.getText();
    L84:
        if (TextUtils.isEmpty(r38) == false) goto L88;
        AnimatorSet r39 = this.H;
        if (r39 == null) goto L91;
        r39.playTogether(new Animator[]{r117, r29, r36, r118, r30});
    L91:
        AnimatorSet r40 = this.H;
        if (r40 == null) goto L94;
        r40.start();
    L94:
        LottieAnimationView r41 = this.F;
        if (r41 == null) goto L97;
        r41.setVisibility(0);
    L97:
        LottieAnimationView r42 = this.F;
        if (r42 == null) goto L100;
        r42.setAnimation("radio_guide_oval.json");
    L100:
        LottieAnimationView r43 = this.F;
        if (r43 == null) goto L4;
        r43.playAnimation();
        goto L4
    L88:
        AnimatorSet r44 = this.H;
        if (r44 == null) goto L91;
        r44.playTogether(new Animator[]{r116, r117, r29, r36, r118, r30});
        goto L91
    L82:
        r38 = null;
        goto L84
    L78:
        r22 = null;
        goto L79
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
