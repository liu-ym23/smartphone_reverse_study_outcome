package com.bytedance.android.livesdk.chatroom.vs_impl.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessScreenBarConfigure;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fq1.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_impl/widget/BusinessScreenBarWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BusinessScreenBarWidget extends LiveRecyclableWidget {
    public HSImageView a;
    public FrameLayout b;
    public TextView c;
    public ViewGroup d;
    public LinkedList<BusinessConfigure> e;
    public boolean f;
    public CompositeDisposable g;
    public ObjectAnimator h;
    public ObjectAnimator i;
    public Disposable j;
    public BusinessConfigure k;
    public String l;
    public final a m;
    public boolean n;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BusinessScreenBarWidget a;

        public a(BusinessScreenBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.yq();
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ BusinessScreenBarWidget a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b(BusinessScreenBarWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.Aq(1.0f, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.f = true;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ BusinessScreenBarWidget a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public c(BusinessScreenBarWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.Aq(0.0f, 8);
            BusinessScreenBarWidget r4 = this.a;
            r4.f = false;
            HSImageView r5 = r4.a;
            if (r5 == null) goto L5;
            r5.setBackground(null);
        L5:
            this.a.yq();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.f = true;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BusinessScreenBarWidget a;

        public d(BusinessScreenBarWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.zq();     // Catch: Throwable -> L10
            this.a.yq();     // Catch: Throwable -> L10
            u r0 = r.u(((Widget) this.a).dataCenter, null, 2);     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            m<MutableLiveData<Boolean>> r1 = r0.B1();     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            MutableLiveData r2 = (MutableLiveData) r1.getValue();     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            r2.observeForever(this.a.m);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BusinessScreenBarWidget a;

        public e(BusinessScreenBarWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            BusinessScreenBarWidget r6 = this.a;
            r6.getClass();
            IVSPlayerService r0 = (IVSPlayerService) k.f(IVSPlayerService.class);
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r0.provideVSPlayerViewControlService(((Widget) r6).dataCenter);
        L6:
            boolean r3 = false;
            if (r2 != null) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == false) goto L18;
            IVSPlayerService r7 = (IVSPlayerService) k.f(IVSPlayerService.class);
            if (r7 == null) goto L16;
            r1 = r7.provideVSPlayerViewControlService(((Widget) r6).dataCenter);
        L16:
            if (r1 == null) goto L26;
            r1.provideContext().getPlayerViewVisible().setValue(Boolean.FALSE);
            return;
        L26:
            return;
        L18:
            String r8 = r6.l;
            if (r8 != null) goto L21;
            return;
        L21:
            if (r8.length() <= 0) goto L23;
            r3 = true;
        L23:
            if (r3 != true) goto L29;
            fq1.d.a().handleSchema(((Widget) r6).context, UriProtector.parse(r6.l).toString());
            int r9 = sr1.a.a;
            sr1.a.c("activity_ad_click", "video_bottom", r6.k, null);
            return;
        L29:
            return;
        L9:
            if (((Boolean) r2.provideContext().getPlayerViewVisible().getValue()).booleanValue() == false) goto L11;
            r4 = true;
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class f extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ BusinessConfigure a;
        public final /* synthetic */ BusinessScreenBarWidget b;

        public f(BusinessConfigure r1, BusinessScreenBarWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r3, Throwable r4) {
            this.b.Aq(0.0f, 8);
            this.b.yq();
            StringBuilder r5 = new StringBuilder("load dynamic screen bar ");
            BusinessResourceConfigure r0 = this.a.resourceConfig;
            String r1 = null;
            if (r0 == null) goto L7;
            BusinessScreenBarConfigure r2 = r0.screenBarConfigure;
            if (r2 == null) goto L7;
            py.k r6 = r2.getImage();
        L8:
            r5.append(r6);
            r5.append(" fail, reason ");
            if (r4 == null) goto L11;
            r1 = r4.getMessage();
        L11:
            r5.append(r1);
            ALogger.e("BusinessConfigure", r5.toString());
            return;
        L7:
            r6 = null;
            goto L8
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
            r3 = null;
        L5:
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            if (r5 == null) goto L9;
            r5.setAnimationListener(new com.bytedance.android.livesdk.chatroom.vs_impl.widget.a(this));
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BusinessConfigure a;
        public final /* synthetic */ BusinessScreenBarWidget b;

        public g(BusinessConfigure r1, BusinessScreenBarWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            HSImageView r0 = this.b.a;
            if (r0 == null) goto L5;
            r0.setBackground(new BitmapDrawable(r5));
        L5:
            this.b.Aq(0.0f, 0);
            BusinessScreenBarWidget.xq(this.b, false);
            ObjectAnimator r6 = this.b.i;
            if (r6 == null) goto L8;
            r6.cancel();
        L8:
            ObjectAnimator r7 = this.b.h;
            if (r7 == null) goto L11;
            r7.start();
        L11:
            int r8 = sr1.a.a;
            py.k r2 = null;
            sr1.a.c("activity_ad_show", "video_bottom", this.a, null);
            BusinessScreenBarWidget.wq(this.b, Integer.valueOf(this.a.displaySecond));
            StringBuilder r9 = new StringBuilder("load screen bar picture ");
            BusinessResourceConfigure r1 = this.a.resourceConfig;
            if (r1 == null) goto L16;
            BusinessScreenBarConfigure r3 = r1.screenBarConfigure;
            if (r3 == null) goto L16;
            r2 = r3.getImage();
        L16:
            r9.append(r2);
            r9.append(" success");
            ALogger.i("BusinessConfigure", r9.toString());
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ BusinessConfigure a;
        public final /* synthetic */ BusinessScreenBarWidget b;

        public h(BusinessConfigure r1, BusinessScreenBarWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            this.b.Aq(0.0f, 8);
            this.b.yq();
            StringBuilder r0 = new StringBuilder("load screen bar picture ");
            BusinessResourceConfigure r1 = this.a.resourceConfig;
            String r2 = null;
            if (r1 == null) goto L7;
            BusinessScreenBarConfigure r3 = r1.screenBarConfigure;
            if (r3 == null) goto L7;
            py.k r6 = r3.getImage();
        L8:
            r0.append(r6);
            r0.append(" fail, reason ");
            if (r5 == null) goto L11;
            r2 = r5.getMessage();
        L11:
            r0.append(r2);
            ALogger.e("BusinessConfigure", r0.toString());
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public final int getLayoutId() {
        return 2131565283;
    }

    public final void onUnload() {
        u r0 = r.u(((Widget) this).dataCenter, null, 2);
        if (r0 == null) goto L9;
        m<MutableLiveData<Boolean>> r1 = r0.B1();
        if (r1 == null) goto L9;
        MutableLiveData r2 = (MutableLiveData) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeObserver(this.m);
    L9:
        this.e = null;
        HSImageView r3 = this.a;
        if (r3 == null) goto L12;
        r3.setController(null);
    L12:
        HSImageView r4 = this.a;
        if (r4 == null) goto L15;
        r4.setBackground(null);
    L15:
        Aq(0.0f, 8);
        this.g.dispose();
    }

    public final void yq() {
        if (this.e != null) goto L13;
        u r0 = r.u(((Widget) this).dataCenter, null, 2);
        if (r0 == null) goto L11;
        j<cq1.a> r1 = r0.f0();
        if (r1 == null) goto L11;
        cq1.a r2 = (cq1.a) r1.getValue();
        if (r2 == null) goto L11;
        LinkedList<BusinessConfigure> r3 = r2.c;
    L12:
        this.e = r3;
    L11:
        r3 = null;
    L13:
        LinkedList<BusinessConfigure> r4 = this.e;
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.isEmpty() == false) goto L18;
        return;
    L18:
        if (this.f == true) goto L131;
        LinkedList<BusinessConfigure> r5 = this.e;
        if (r5 == null) goto L123;
        BusinessConfigure r6 = r5.pollFirst();
        if (r6 == null) goto L124;
        BusinessResourceConfigure r7 = r6.resourceConfig;
        if (r7 == null) goto L119;
        BusinessScreenBarConfigure r8 = r7.screenBarConfigure;
        if (r8 == null) goto L119;
        py.k r9 = r8.getImage();
        if (r9 == null) goto L119;
        List r10 = r9.getUrls();
        if (r10 == null) goto L119;
        if (r10.isEmpty() == true) goto L119;
        if (sr1.a.d(r6) == true) goto L119;
        if (sr1.a.a(t.a().getCurrentUserId(), r6) == false) goto L119;
        BusinessResourceConfigure r11 = r6.resourceConfig;
        if (r11 == null) goto L44;
        BusinessScreenBarConfigure r12 = r11.screenBarConfigure;
        if (r12 == null) goto L44;
        String r13 = r12.getSchema();
    L45:
        this.l = r13;
        HSImageView r14 = this.a;
        if (r14 == null) goto L48;
        r14.setController(null);
    L48:
        HSImageView r15 = this.a;
        if (r15 == null) goto L51;
        r15.setBackground(null);
    L51:
        Disposable r16 = this.j;
        if (r16 == null) goto L54;
        r16.dispose();
    L54:
        this.j = null;
        FrameLayout r17 = this.b;
        if (r17 == null) goto L57;
        r17.setVisibility(8);
    L57:
        ViewGroup r18 = this.d;
        if (r18 == null) goto L60;
        r18.setVisibility(8);
    L60:
        BusinessResourceConfigure r19 = r6.resourceConfig;
        if (r19 == null) goto L65;
        BusinessScreenBarConfigure r20 = r19.screenBarConfigure;
        if (r20 == null) goto L65;
        String r21 = r20.getJumpPrompt();
    L66:
        Handler r22 = UtilityKotlinExtentionsKt.a;
        if (r21 != null) goto L69;
    L71:
        boolean r23 = false;
    L72:
        if (r23 == false) goto L97;
        BusinessResourceConfigure r24 = r6.resourceConfig;
        if (r24 == null) goto L78;
        BusinessScreenBarConfigure r25 = r24.screenBarConfigure;
        if (r25 == null) goto L78;
        String r26 = r25.getSchema();
    L79:
        if (r26 != null) goto L81;
    L83:
        boolean r27 = false;
    L84:
        if (r27 == false) goto L97;
        TextView r28 = this.c;
        if (r28 == null) goto L94;
        BusinessResourceConfigure r29 = r6.resourceConfig;
        if (r29 == null) goto L92;
        BusinessScreenBarConfigure r30 = r29.screenBarConfigure;
        if (r30 == null) goto L92;
        String r31 = r30.getJumpPrompt();
    L93:
        r28.setText(r31);
    L92:
        r31 = null;
    L94:
        ViewGroup r32 = this.d;
        if (r32 == null) goto L97;
        r32.setVisibility(0);
        goto L97
    L81:
        if (r26.length() <= 0) goto L83;
        r27 = true;
    L78:
        r26 = null;
    L97:
        BusinessResourceConfigure r33 = r6.resourceConfig;
        if (r33 == null) goto L112;
        BusinessScreenBarConfigure r34 = r33.screenBarConfigure;
        if (r34 == null) goto L112;
        if (r34.getBarType() != 2) goto L112;
        this.k = r6;
        Aq(1.0f, 0);
        HSImageView r35 = this.a;
        if (r35 == null) goto L125;
        PipelineDraweeControllerBuilder r36 = Fresco.newDraweeControllerBuilder();
        BusinessResourceConfigure r37 = r6.resourceConfig;
        if (r37 == null) goto L110;
        BusinessScreenBarConfigure r38 = r37.screenBarConfigure;
        if (r38 == null) goto L110;
        py.k r39 = r38.getImage();
    L111:
        r35.setController(r36.setFirstAvailableImageRequests(ImageLoader.createImageRequests(r39, null, null)).setAutoPlayAnimations(true).setControllerListener(new f(r6, this)).build());
        return;
    L110:
        r39 = null;
        goto L111
    L125:
        return;
    L112:
        BusinessResourceConfigure r40 = r6.resourceConfig;
        if (r40 == null) goto L127;
        BusinessScreenBarConfigure r41 = r40.screenBarConfigure;
        if (r41 == null) goto L128;
        py.k r42 = r41.getImage();
        if (r42 == null) goto L129;
        RxUtilKt.c(a1.k(r42).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r6, this), new h(r6, this)), this.g);
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L69:
        if (r21.length() <= 0) goto L71;
        r23 = true;
    L65:
        r21 = null;
    L44:
        r13 = null;
    L119:
        yq();
        return;
    L124:
        return;
    L123:
        return;
    }

    public BusinessScreenBarWidget() {
        this.g = new CompositeDisposable();
        this.l = "";
        this.m = new a(this);
    }

    public final void zq() {
        this.n = PadConfigUtils.c();
        boolean r0 = e5.n();
        Boolean r2 = null;
        if (this.n == false) goto L8;
        if (r0 == false) goto L6;
        int r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.t.e();
    L7:
        Integer r3 = Integer.valueOf(r1);
    L12:
        if (r3 == null) goto L23;
        int r4 = r3.intValue();
        HSImageView r5 = this.a;
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L23;
        r6.width = r4;
        r6.height = (int) (r4 * 0.16f);
        StringBuilder r7 = new StringBuilder("initScreenBarSize, screen orientation ");
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L20;
        r2 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r8, true));
    L20:
        r7.append(r2);
        r7.append("screen bar width ");
        r7.append(r6.width);
        r7.append(", height ");
        r7.append(r6.height);
        ALogger.i("BusinessConfigure", r7.toString());
        HSImageView r9 = this.a;
        if (r9 == null) goto L23;
        r9.setLayoutParams(r6);
    L23:
        boolean r10 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.c("screenBar", ((Widget) this).containerView, false, true, true, 4);
        return;
    L6:
        r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.t.f();
        goto L7
    L8:
        ViewGroup r11 = ((Widget) this).containerView;
        if (r11 == null) goto L11;
        r3 = Integer.valueOf(r11.getWidth());
        goto L12
    L11:
        r3 = null;
        goto L12
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        ALogger.i("BusinessConfigure", String.valueOf(this.n));
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        if (this.f == false) goto L5;
        Aq(0.0f, 8);
    L5:
        zq();
    }

    public final void onInit(Object[] r6) {
        ObjectAnimator r7 = ObjectAnimator.ofFloat(((Widget) this).contentView, "alpha", new float[]{0.0f, 1.0f});
        r7.setDuration(300);
        r7.addListener(new b(this));
        Unit r1 = Unit.INSTANCE;
        this.h = r7;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(((Widget) this).contentView, "alpha", new float[]{1.0f, 0.0f});
        r8.setDuration(300);
        r8.addListener(new c(this));
        this.i = r8;
        ViewGroup r9 = ((Widget) this).containerView;
        ViewGroup r0 = null;
        if (r9 == null) goto L5;
        HSImageView r10 = (HSImageView) r9.findViewById(2131364967);
    L6:
        this.a = r10;
        ViewGroup r11 = ((Widget) this).containerView;
        if (r11 == null) goto L9;
        FrameLayout r12 = (FrameLayout) r11.findViewById(2131385184);
    L10:
        this.b = r12;
        ViewGroup r13 = ((Widget) this).containerView;
        if (r13 == null) goto L13;
        TextView r14 = (TextView) r13.findViewById(2131390252);
    L14:
        this.c = r14;
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L17;
        r0 = (ViewGroup) r15.findViewById(2131385183);
    L17:
        this.d = r0;
        return;
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public final void onLoad(Object[] r2) {
        this.g = new CompositeDisposable();
        Aq(0.0f, 8);
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L5;
        r3.post(new d(this));
    L5:
        HSImageView r4 = this.a;
        if (r4 == null) goto L9;
        r4.setOnClickListener(new e(this));
        return;
    }

    public static final void wq(BusinessScreenBarWidget r2, Integer r3) {
        if (r3 == null) goto L6;
        r2.getClass();
        if (r3.intValue() <= 0) goto L6;
        RxUtilKt.c(Observable.timer(r3.intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new tr1.a(r2)), r2.g);
        return;
    L6:
        ObjectAnimator r4 = r2.h;
        if (r4 == null) goto L9;
        r4.cancel();
    L9:
        ObjectAnimator r5 = r2.i;
        if (r5 == null) goto L14;
        r5.start();
        return;
    }

    public static final void xq(BusinessScreenBarWidget r2, boolean r3) {
        Disposable r0 = r2.j;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        if (r3 == false) goto L7;
        r2.j = Observable.timer(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new tr1.b(r2));
        return;
    L7:
        FrameLayout r4 = r2.b;
        if (r4 == null) goto L12;
        r4.setVisibility(0);
        return;
    }

    public final void Aq(float r2, int r3) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L5;
        r0.setVisibility(r3);
    L5:
        HSImageView r1 = this.a;
        if (r1 == null) goto L8;
        r1.setVisibility(r3);
    L8:
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L11;
        r4.setAlpha(r2);
    L11:
        if (r3 != 0) goto L13;
        boolean r5 = true;
    L14:
        this.f = r5;
        return;
    L13:
        r5 = false;
        goto L14
    }
}
