package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PortraitQuickShotLayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitQuickShotLayerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int j = 0;
    public View a;
    public ImageView b;
    public View c;
    public VideoViewParams d;
    public Bitmap e;
    public IRoom f;
    public final ValueAnimator g;
    public final ValueAnimator h;
    public final ValueAnimator i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PortraitQuickShotLayerWidget a;

        public b(PortraitQuickShotLayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PortraitQuickShotLayerWidget r0 = this.a;     // Catch: Throwable -> L9
            DataCenter r1 = ((Widget) r0).dataCenter;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            VideoViewParams r2 = (VideoViewParams) r1.get("live_render_view_params");     // Catch: Throwable -> L9
            if (r2 == null) goto L6;
        L7:
            r0.d = r2;     // Catch: Throwable -> L9
            return;
        L6:
            r2 = new VideoViewParams(0, 0, 0, 0.0f);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final int getLayoutId() {
        int r0 = bs1.a.a;
        return 2131567963;
    }

    public final void onUnload() {
        List r0 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        ((Widget) this).dataCenter.removeObserver(r2, this);
        goto L6
    L10:
        return;
    }

    public final void yq() {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.h;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.i;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L14;
        r3.setAlpha(1.0f);
    L14:
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r4);
    L17:
        View r5 = this.a;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L20:
        if (r5 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r5);
    L22:
        ImageView r6 = this.b;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        if (r6 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r6);
    L27:
        View r7 = this.c;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L30:
        if (r7 == null) goto L32;
        UtilityKotlinExtentionsKt.t(r7);
    L32:
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L36;
        r8.setOnClickListener(null);
        return;
    }

    public PortraitQuickShotLayerWidget() {
        this.g = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.h = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.i = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
    }

    public static View wq(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void onChanged(Object r24) {
        KVData r0 = (KVData) r24;
        if (r0 == null) goto L119;
        String r1 = r0.getKey();
        switch(r1.hashCode()) {
            case -1956533084: goto L116;
            case -1210674534: goto L97;
            case -904942447: goto L94;
            case 84498020: goto L8;
            default: goto L132;
        };
    L132:
        return;
    L8:
        if (r1.equals("data_live_quick_shot_bitmap") == false) goto L120;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L13;
        VideoViewParams r3 = (VideoViewParams) r2.get("live_render_view_params");
        if (r3 == null) goto L13;
    L14:
        this.d = r3;
        ((Widget) this).dataCenter.put("data_live_quick_shot_layer_show", Boolean.TRUE);
        bs1.b r4 = (bs1.b) r0.getData();
        if (r4 == null) goto L17;
        Bitmap r5 = r4.b;
    L18:
        if (r5 == null) goto L121;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotShareDialogShow(r4.d);
        yq();
        Bitmap r6 = r4.b;
        this.e = r6;
        if (r6 == null) goto L122;
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        View r7 = this.a;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L24:
        UtilityKotlinExtentionsKt.w(r7);
        ImageView r8 = this.b;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L27:
        UtilityKotlinExtentionsKt.w(r8);
        ImageView r9 = this.b;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L30:
        RoundedBitmapDrawable r10 = new RoundedBitmapDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r6);
        int r11 = bs1.a.a;
        float r12 = UtilityKotlinExtentionsKt.h(6);
        r10.setRadii(new float[]{r12, r12, r12, r12, r12, r12, r12, r12});
        Unit r13 = Unit.INSTANCE;
        r9.setImageDrawable(r10);
        Ref.IntRef r14 = new Ref.IntRef();
        VideoViewParams r15 = this.d;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L33:
        r14.element = r15.a;
        Ref.IntRef r16 = new Ref.IntRef();
        VideoViewParams r17 = this.d;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L36:
        r16.element = r17.b;
        Ref.IntRef r18 = new Ref.IntRef();
        vr1.u r19 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r19 == null) goto L43;
        com.bytedance.live.datacontext.n<Rect> r20 = r19.d();
        if (r20 == null) goto L43;
        Rect r21 = (Rect) r20.getValue();
        if (r21 == null) goto L43;
        int r22 = r21.left;
    L44:
        r18.element = r22;
        Ref.IntRef r23 = new Ref.IntRef();
        vr1.u r110 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r110 == null) goto L51;
        com.bytedance.live.datacontext.n<Rect> r111 = r110.d();
        if (r111 == null) goto L51;
        Rect r25 = (Rect) r111.getValue();
        if (r25 == null) goto L51;
        int r26 = r25.top;
    L52:
        r23.element = r26;
        if (r14.element > 0) goto L55;
    L56:
        r14.element = com.bytedance.android.live.core.utils.s1.t();
        r16.element = com.bytedance.android.live.core.utils.s1.r();
        r18.element = 0;
        r23.element = 0;
    L57:
        int r27 = r14.element;
        int r112 = r16.element;
        if (r27 < r112) goto L60;
        int r28 = r27;
    L61:
        if (r27 < r112) goto L63;
        int r29 = 100;
    L64:
        float r30 = UtilityKotlinExtentionsKt.h(r29);
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        float r114 = r30 / r28;
        float r31 = 12;
        float r32 = UtilityKotlinExtentionsKt.h(r31);
        int r115 = ((Widget) this).containerView.getBottom() - ((int) ((r16.element * r114) + UtilityKotlinExtentionsKt.h(60)));
        float r116 = r32 - r18.element;
        int r117 = r115 - r23.element;
        Ref.IntRef r118 = new Ref.IntRef();
        r118.element = 0;
        Ref.IntRef r33 = new Ref.IntRef();
        r33.element = 0;
        Ref.FloatRef r34 = new Ref.FloatRef();
        r34.element = 0.0f;
        Ref.IntRef r35 = new Ref.IntRef();
        r35.element = 0;
        Ref.IntRef r36 = new Ref.IntRef();
        r36.element = 0;
        float r119 = r115;
        float r37 = (r14.element * r114) + UtilityKotlinExtentionsKt.h(r31);
        float r38 = (r16.element * r114) + UtilityKotlinExtentionsKt.h(44);
        Context r39 = ((Widget) this).context;
        if ((r39 instanceof Activity) == true) goto L67;
    L88:
        float r210 = r116;
    L89:
        Bitmap r40 = null;
    L90:
        if (r40 == null) goto L92;
        View r41 = ((Widget) this).contentView;
        RoundedBitmapDrawable r42 = new RoundedBitmapDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r40);
        r42.setBorder(ColorProtector.parseColor("#1AFFFFFF"), 1.0f);
        float r43 = UtilityKotlinExtentionsKt.h(r31);
        r42.setRadii(new float[]{r43, r43, r43, r43, r43, r43, r43, r43});
        r41.setBackground(r42);
    L92:
        r113.addUpdateListener(new c2(this, r34, r114, r35, r14, r36, r16, r118, r18, r210, r33, r23, r117));
        r113.setInterpolator(new AccelerateDecelerateInterpolator());
        r113.start();
        return;
    L67:
        if (r39 == null) goto L87;
        if (((Activity) r39).getWindow() == null) goto L88;
        Context r44 = ((Widget) this).context;
        if (r44 == null) goto L85;
        if (wq(((Activity) r44).getWindow()) == null) goto L88;
        r210 = r116;
        float r120 = 0;
        if (r37 <= r120) goto L89;
        if (r38 <= r120) goto L89;
        Bitmap r45 = Bitmap.createBitmap((int) r37, (int) r38, Bitmap.Config.ARGB_8888);
        Canvas r46 = new Canvas(r45);
        r46.translate(-r32, (-r119) - StatusBarUtil.getStatusBarHeight(((Widget) this).context));
        Context r47 = ((Widget) this).context;
        if (r47 == null) goto L83;
        wq(((Activity) r47).getWindow()).draw(r46);
        r40 = Bitmap.createBitmap(r45.getWidth(), r45.getHeight(), Bitmap.Config.ARGB_8888);
        com.bytedance.android.livesdk.utils.e0.a(r45, r40, 150);
        r45.recycle();
        goto L90
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L63:
        r29 = 178;
        goto L64
    L60:
        r28 = r112;
        goto L61
    L55:
        if (r16.element > 0) goto L57;
    L51:
        r26 = 0;
    L43:
        r22 = 0;
        goto L44
    L122:
        return;
    L121:
        return;
    L17:
        r5 = null;
    L13:
        r3 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L14
    L120:
        return;
    L94:
        if (r1.equals("data_live_quick_record_finish") == false) goto L124;
        yq();
        return;
    L124:
        return;
    L97:
        if (r1.equals("data_live_quick_shot_path") == false) goto L126;
        bs1.b r48 = (bs1.b) r0.getData();
        if (r48 == null) goto L127;
        String r49 = r48.c;
        if (r49 == null) goto L128;
        Bitmap r50 = r48.b;
        IRoom r51 = this.f;
        if (r51 == null) goto L110;
        IRoomAuthStatus r52 = r51.getRoomAuthStatus();
        if (r52 == null) goto L110;
        if (r52.enableVerticalScreenShare() != true) goto L110;
        ((Widget) this).contentView.post(new b2(this, r50, r49));
        return;
    L110:
        if (r50 == null) goto L114;
        View r53 = ((Widget) this).contentView;
        if (r53 == null) goto L114;
        r53.setOnClickListener(new y1(r50, this));
    L114:
        Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new z1(this, r50), a2.a);
        return;
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L116:
        if (r1.equals("data_live_quick_record_start") == false) goto L131;
        yq();
        return;
    L131:
        return;
    }

    public final void onLoad(Object[] r5) {
        this.a = findViewById(2131389907);
        this.b = (ImageView) findViewById(2131389922);
        this.c = findViewById(2131364832);
        ((Widget) this).contentView.post(new b(this));
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L10;
        List r0 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r6.observe((String) r1.next(), this);
    L10:
        com.bytedance.android.livesdk.f.d().a.observe(this, new AnonymousClass3(this));
        this.f = (IRoom) ((Widget) this).dataCenter.get("data_room");
        yq();
    }

    public static final void xq(PortraitQuickShotLayerWidget r3, Bitmap r4) {
        ((Widget) r3).dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r0 = new int[2];
        View r1 = ((Widget) r3).contentView;
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r0);
    L5:
        r3.i.addUpdateListener(new x1(r3, r4));
        r3.i.start();
    }
}
