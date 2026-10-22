package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ue1;
import com.bytedance.android.livesdk.message.model.jb;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleStarActivityGradeMedal;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/FansRankListAnimationWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansRankListAnimationWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int o = 0;
    public HSImageView a;
    public HSImageView b;
    public RelativeLayout c;
    public TextView d;
    public LottieAnimationView e;
    public View f;
    public HSImageView g;
    public HSImageView h;
    public boolean i;
    public boolean j;
    public ArrayList<Animator> k;
    public String l;
    public AnimatedDrawable2 m;
    public AnimatedDrawable2 n;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566976;
    }

    public final String getSpm() {
        return "a100.a100.a156";
    }

    public final void onUnload() {
        ArrayList<Animator> r0 = this.k;
        if (r0 == null) goto L9;
        Iterator<Animator> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Animator r2 = r1.next();
        r2.cancel();
        r2.removeAllListeners();
        goto L6
    L8:
        r0.clear();
    L9:
        wq();
        LottieAnimationView r3 = this.e;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L12:
        r3.cancelAnimation();
        LottieAnimationView r4 = this.e;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L15:
        UIUtils.setViewVisibility(r4, 8);
    }

    public final void wq() {
        AnimatedDrawable2 r0 = this.m;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        AnimatedDrawable2 r1 = this.n;
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        this.m = null;
        this.n = null;
        this.l = "";
        TextView r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L11:
        r2.setText(this.l);
        RelativeLayout r3 = this.c;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L14:
        UIUtils.setViewVisibility(r3, 8);
    }

    public FansRankListAnimationWidget() {
        this.j = true;
        this.l = "";
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (this.i == true) goto L21;
        HSImageView r0 = this.g;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L7:
        r0.setController(null);
        View r1 = this.f;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L10:
        UIUtils.setViewVisibility(r1, 4);
        HSImageView r2 = this.g;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L13:
        if (r2 == null) goto L15;
        r2.clearAnimation();
    L15:
        HSImageView r3 = this.h;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L18:
        if (r3 == null) goto L22;
        r3.clearAnimation();
        return;
    L22:
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (((Widget) this).context != null) goto L6;
        return;
    L6:
        if (((Widget) this).isViewValid == true) goto L9;
        return;
    L9:
        if (r10 == null) goto L11;
        String r1 = r10.getKey();
    L12:
        boolean r3 = false;
        if (Intrinsics.areEqual(r1, "fans_rank_list_award_anim") == false) goto L33;
        jb r11 = (jb) ((Widget) this).dataCenter.get("fans_rank_list_award_anim", vh7.f.c(jb.class));
        if (this.j == false) goto L98;
        int r12 = r11.getRank();
        if (r12 != 1) goto L19;
        this.l = com.bytedance.android.live.core.utils.s1.B(2131919084);
    L20:
        RelativeLayout r13 = this.c;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L23:
        UIUtils.setViewVisibility(r13, 0);
        TextView r14 = this.d;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L26:
        UIUtils.setViewVisibility(r14, 4);
        RelativeLayout r15 = this.c;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L29:
        r15.setAlpha(1.0f);
        AbstractDraweeController r16 = Fresco.newDraweeControllerBuilder().setControllerListener(new x(this)).setUri(UriProtector.parse(ue1.a.getValue())).setAutoPlayAnimations(false).build();
        HSImageView r0 = this.a;
        if (r0 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationDi");
    L32:
        r0.setController(r16);
        return;
    L19:
        this.l = com.bytedance.android.live.core.utils.s1.C(2131919083, new Object[]{Integer.valueOf(r12)});
        goto L20
    L98:
        return;
    L33:
        if (r10 == null) goto L35;
        String r2 = r10.getKey();
    L37:
        if (Intrinsics.areEqual(r2, "fans_rank_list_lottie") == true) goto L39;
        if (r10 == null) goto L53;
        String r17 = r10.getKey();
    L55:
        if (Intrinsics.areEqual(r17, "pk_activity_award_anim") == false) goto L102;
        jb r18 = (jb) ((Widget) this).dataCenter.get("pk_activity_award_anim", vh7.f.c(jb.class));
        if (this.j == false) goto L103;
        Intrinsics.checkNotNullParameter(r18, "message");
        View r4 = this.f;
        if (r4 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L61:
        r4.setOnClickListener(new a0(this, r18));
        RelativeLayout r5 = this.c;
        if (r5 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L64:
        UIUtils.setViewVisibility(r5, 4);
        View r6 = this.f;
        if (r6 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L67:
        UIUtils.setViewVisibility(r6, 4);
        if (com.bytedance.android.livesdk.chatroom.utils.a1.j(r18.getAssetImage()) == false) goto L76;
        HSImageView r7 = this.h;
        if (r7 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L72:
        UIUtils.setViewVisibility(r7, 4);
        AbstractDraweeController r19 = Fresco.newDraweeControllerBuilder().setControllerListener(new b0(this)).setFirstAvailableImageRequests(ImageLoader.createImageRequests(r18.getAssetImage(), null, null)).setAutoPlayAnimations(true).build();
        HSImageView r8 = this.g;
        if (r8 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L75:
        r8.setController(r19);
        return;
    L76:
        HSImageView r20 = this.h;
        if (r20 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L79:
        UIUtils.setViewVisibility(r20, 0);
        BattleStarActivityGradeMedal r21 = r18.getGradeMedal();
        if (r21 == null) goto L82;
        py.k r22 = r21.gradeMedal;
    L83:
        ImageRequest[] r23 = ImageLoader.createImageRequests(r22, null, null);
        if (r23 != null) goto L86;
    L90:
        r3 = true;
    L91:
        if (r3 == true) goto L107;
        AbstractDraweeController r24 = Fresco.newDraweeControllerBuilder().setControllerListener(new c0(this, r18)).setFirstAvailableImageRequests(r23).setAutoPlayAnimations(true).build();
        HSImageView r25 = this.g;
        if (r25 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L96:
        r25.setController(r24);
        return;
    L107:
        return;
    L86:
        if (r23.length != 0) goto L88;
        boolean r26 = true;
    L89:
        if (r26 == false) goto L91;
    L88:
        r26 = false;
        goto L89
    L82:
        r22 = null;
        goto L83
    L103:
        return;
    L102:
        return;
    L53:
        r17 = null;
        goto L55
    L39:
        if (((Boolean) ((Widget) this).dataCenter.get("fans_rank_list_lottie", Boolean.FALSE)).booleanValue() == false) goto L44;
        LottieAnimationView r27 = this.e;
        if (r27 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L43:
        r27.setVisibility(0);
        r27.setRepeatCount(-1);
        com.bytedance.android.livesdk.chatroom.utils.i2.g(r27, "/revenue/entrance/ttlive_fans_rank_tip_lottie.zip");
        return;
    L44:
        LottieAnimationView r28 = this.e;
        if (r28 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L47:
        r28.cancelAnimation();
        LottieAnimationView r29 = this.e;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L50:
        UIUtils.setViewVisibility(r29, 8);
        return;
    L35:
        r2 = null;
        goto L37
    L11:
        r1 = null;
        goto L12
    }

    public final void onInit(Object[] r7) {
        this.c = (RelativeLayout) ((Widget) this).contentView.findViewById(2131383670);
        this.a = ((Widget) this).contentView.findViewById(2131383671);
        this.b = ((Widget) this).contentView.findViewById(2131383672);
        this.d = (TextView) ((Widget) this).contentView.findViewById(2131383673);
        this.e = ((Widget) this).contentView.findViewById(2131372120);
        this.f = ((Widget) this).contentView.findViewById(2131382343);
        this.g = ((Widget) this).containerView.findViewById(2131376468);
        this.h = ((Widget) this).contentView.findViewById(2131376355);
        ViewGroup.LayoutParams r3 = null;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L28;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L29;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L30;
        User r11 = r10.getOwner();
        if (r11 == null) goto L31;
        com.bytedance.android.live.base.model.user.g0 r12 = r11.getSubscribe();
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.getOpen() != 1) goto L33;
        LottieAnimationView r13 = this.e;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L17:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof RelativeLayout.LayoutParams) == false) goto L21;
        r3 = r14;
    L21:
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r3;
        if (r4 == null) goto L34;
        r4.leftMargin = com.bytedance.android.live.core.utils.s1.f(-20.0f);
        LottieAnimationView r15 = this.e;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L26:
        r15.setLayoutParams(r4);
        return;
    L34:
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void onLoad(Object[] r2) {
        this.i = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).c;
        this.j = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).b;
        ((Widget) this).dataCenter.observe("fans_rank_list_award_anim", this).observe("fans_rank_list_lottie", this).observe("pk_activity_award_anim", this);
    }
}
