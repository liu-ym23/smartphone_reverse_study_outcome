package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.q2;
import com.bytedance.android.livesdk.gift.model.r3;
import com.bytedance.android.livesdk.gift.model.s3;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.message.model.zb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.bdlocation.BuildConfig;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class VideoGiftView extends FrameLayout {
    public static final /* synthetic */ int v = 0;
    public FrameLayout a;
    public View b;
    public GiftSwitchImageView c;
    public NewGiftSwitchImageView d;
    public boolean e;
    public zb.a f;
    public String g;
    public com.bytedance.android.livesdk.gift.platform.business.effect.player.f h;
    public final Map<String, Object> i;
    public Runnable j;
    public Disposable k;
    public boolean l;
    public EffectMessage m;
    public long n;
    public i o;
    public dq2.d p;
    public boolean q;
    public final List<Long> r;
    public long s;
    public int t;
    public int u;

    public final void e() {
        if (this.f != null) goto L5;
        return;
    L5:
        this.b.setVisibility(0);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 0.0f}).setDuration(this.f.getStart());
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f}).setDuration(500);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 1.0f}).setDuration(this.f.getDuration() - 500);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f}).setDuration(500);
        AnimatorSet r5 = new AnimatorSet();
        r5.playSequentially(new Animator[]{r0, r3, r7, r4});
        r5.start();
    }

    public int getDuration() {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r0 = this.h;
        if (r0 == null) goto L8;
        ILiveGiftPlayController r1 = r0.f;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getDuration();
    L8:
        return 0;
    }

    public String getPlayerType() {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r0 = this.h;
        if (r0 == null) goto L8;
        ILiveGiftPlayController r1 = r0.f;
        if (r1 != null) goto L7;
        return CardLockInfo.sUNKNOWN;
    L7:
        return r1.getPlayerType();
    L8:
        return CardLockInfo.sUNKNOWN;
    }

    private int getResourceLayout() {
        if (PadConfigUtils.c() == false) goto L5;
        return 2131567920;
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L11;
        return 2131567919;
    L11:
        return 2131567920;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.j;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r1 = this.h;
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    public FrameLayout getVideoContainer() {
        return this.a;
    }

    public VideoGiftView(Context r3) {
        super(r3);
        this.i = new HashMap();
        this.q = false;
        this.r = new ArrayList();
        this.t = 0;
        this.u = 0;
        b(r3);
    }

    public static void c(EffectMessage r6) {
        HashMap r0 = new HashMap();
        i02.g r1 = m02.f.b(r6.d);
        if (r1 != null) goto L5;
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L10;
        if (r1.portrait == null) goto L19;
        r0.put("origin_resolution_ratio", r1.portrait.videoWidth + "*" + r1.portrait.videoHeight);
    L19:
        r0.put("gift_id", r6.l + BuildConfig.FLAVOR);
        com.bytedance.android.livesdk.gift.platform.core.utils.h.d0("livesdk_gift_resolution_change", r0);
        return;
    L10:
        if (r1.landscape == null) goto L15;
        if (e5.n() == false) goto L15;
        r0.put("origin_resolution_ratio", r1.landscape.videoWidth + "*" + r1.landscape.videoHeight);
    L15:
        if (r1.portrait == null) goto L19;
        if (e5.n() == true) goto L19;
        r0.put("origin_resolution_ratio", r1.portrait.videoWidth + "*" + r1.portrait.videoHeight);
        goto L19
    }

    private void setTextEffect(zb r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.e == false) goto L7;
        zb.a r3 = r2.getPortraitDetail();
    L8:
        this.f = r3;
        return;
    L7:
        r3 = r2.getLandscapeDetail();
        goto L8
    }

    public final void a(EffectMessage r4) {
        Map<String, Object> r0 = this.i;
        HashMap r1 = (HashMap) r0;
        r1.put("effect_id", Long.valueOf(r4.b));
        Map<String, Object> r2 = this.i;
        HashMap r3 = (HashMap) r2;
        r3.put("gift_id", Long.valueOf(r4.l));
        Map<String, Object> r5 = this.i;
        HashMap r6 = (HashMap) r5;
        r6.put("msg_id", Long.valueOf(r4.a));
        Map<String, Object> r7 = this.i;
        IBaseUser r8 = r4.i;
        if (r8 == null) goto L5;
        String r9 = String.valueOf(r8.getIdString());
    L6:
        ((HashMap) r7).put("from_user_id", r9);
        Map<String, Object> r10 = this.i;
        HashMap r11 = (HashMap) r10;
        r11.put("log_id", r4.n);
        jy0.b.d("ttlive_gift", this.i.toString());
        return;
    L5:
        r9 = BuildConfig.FLAVOR;
        goto L6
    }

    public final void b(Context r3) {
        getResources().getDimension(2131169222);
        getResources().getDimension(2131169221);
        LayoutInflater.from(r3).inflate(getResourceLayout(), this, true);
        this.a = (FrameLayout) findViewById(2131392404);
        this.b = findViewById(2131388426);
        ImageView r4 = (ImageView) findViewById(2131388427);
        TextView r5 = (TextView) findViewById(2131388428);
        this.c = (GiftSwitchImageView) findViewById(2131387878);
        this.d = (NewGiftSwitchImageView) findViewById(2131387884);
        ((HashMap) this.i).put("desc", "播放大礼物动画");
        List r6 = (List) com.bytedance.android.livesdk.gift.platform.business.b.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[0]);
        if (r6 == null) goto L6;
        ((ArrayList) this.r).addAll(r6);
        return;
    }

    public final void d(boolean r3) {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r0 = this.h;
        if (r0 == null) goto L10;
        ILiveGiftPlayController r1 = r0.f;
        if (r1 == null) goto L11;
        if (r3 == false) goto L8;
        r1.attachAlphaView(r0.b);
        return;
    L8:
        r1.detachAlphaView(r0.b);
        return;
    L11:
        return;
    }

    public void setPortrait(boolean r1) {
        this.e = r1;
    }

    public VideoGiftView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.i = new HashMap();
        this.q = false;
        this.r = new ArrayList();
        this.t = 0;
        this.u = 0;
        b(r2);
    }

    public final boolean f(EffectMessage r3, BaseVideoGiftWidget.c r4) {
        if (this.h == null) goto L6;
        this.j = r4;
        this.g = r3.d;
        setTextEffect(r3.k);
        a(r3);
        setVisibility(0);
        e();
        postDelayed(r4, 1500);
        return true;
    L6:
        return false;
    }

    public final boolean g(final EffectMessage r20, final SuperResolutionModel r21) {
        EffectMessage r5 = r20;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d;
        r0.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r1 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r1.c.d(Long.valueOf(r5.a), "startVideoGift");
        if (this.h == null) goto L54;
        this.m = r5;
        this.n = r5.l;
        this.s = r5.b;
        setTextEffect(r5.k);
        this.g = r5.d;
        a(r20);
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.playcontroller_receive, r5.a, r5.l, r5.b);
        final ArrayList r15 = new ArrayList();
        IBaseUser r2 = r5.h;
        if (r2 == null) goto L7;
        r2.getIdString();
    L7:
        com.bytedance.android.livesdk.gift.model.a r3 = r5.q;
        if (r3 == null) goto L15;
        s3 r4 = r3.d;
        if (r4 == null) goto L15;
        jy0.b.d("GiftEnterQueue", "delegate to enter queue");
        com.bytedance.android.live.revenue.core.b r6 = com.bytedance.android.live.revenue.core.util.j.C0.a();
        if (r6 == null) goto L14;
        com.bytedance.android.live.revenue.core.util.e.b(r6, com.bytedance.android.livesdk.revenue.service.interactivity.a.class).U4(r4.a, r4.b, r4.c, r4.d, r4.e, this.o, r4.f);
    L14:
        return true;
    L15:
        if (r3 != null) goto L18;
    L25:
        boolean r7 = true;
    L27:
        if (r7 == false) goto L35;
        r0.getClass();
        r1.c.g(Long.valueOf(r5.a), "start mGiftPlayerLifecycleController.start " + r5.d, new j());
        if (r21 == null) goto L34;
        if (r21.getOpenSR() == false) goto L34;
        c(r20);
    L34:
        return this.h.b(r5.d, r5.a, r5.l, r5.b, r15, r21, r5.y, r20);
    L35:
        Iterator<r3> r8 = r5.q.b.iterator();
    L37:
        if (r8.hasNext() == false) goto L45;
        r3 r9 = r8.next();
        MaskSrc r10 = new MaskSrc();
        r10.a = r9.a;
        r10.b = 0;
        r10.c = r9.b;
        Long r11 = r9.c;
        if (r11 == null) goto L41;
        r10.e = s1.f(r11.intValue());
    L41:
        String r13 = r9.d;
        if (r13 == null) goto L44;
        r10.d = r13;
    L44:
        r15.add(r10);
        goto L37
    L45:
        Iterator<q2> r14 = r5.q.a.iterator();
    L47:
        if (r14.hasNext() == false) goto L49;
        final q2 r16 = r14.next();
        a1.k(r16.b).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r15, r16, r20, r21), new f(this, r20, r16, r15, r21));
        r5 = r5;
        goto L47
    L49:
        EffectMessage r17 = r5;
        t3 r18 = r17.q.c;
        if (r18 == null) goto L53;
        Bitmap[] r19 = new Bitmap[1];
        com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class).a4(r18.a, RevRenderConfig.SyncDecodeContext, new m(this, s1.f(r18.b), s1.f(r18.c), r19));
        Bitmap r23 = r19[0];
        MaskSrc r24 = new MaskSrc();
        r24.a = "{default_image}";
        r24.b = 1;
        r24.g = r23;
        r15.add(r24);
        return this.h.b(r17.d, r17.a, r17.l, r17.b, r15, r21, r17.y, r20);
    L53:
        return true;
    L18:
        if (r3.a.isEmpty() == true) goto L20;
    L26:
        r7 = false;
        goto L27
    L20:
        if (r5.q.b.isEmpty() == false) goto L26;
        com.bytedance.android.livesdk.gift.model.a r25 = r5.q;
        if (r25.c != null) goto L26;
        if (r25.d != null) goto L26;
    L54:
        r0.getClass();
        r1.c.a(Long.valueOf(r5.a), "startVideoGift-mGiftPlayerLifecycleController" + this.h + " msg:" + r5, new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.OBJECT_NULL, "mGiftPlayerLifecycleController or msg null"));
        return false;
    }

    public VideoGiftView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.i = new HashMap();
        this.q = false;
        this.r = new ArrayList();
        this.t = 0;
        this.u = 0;
        b(r1);
    }
}
