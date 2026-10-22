package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotLayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotLayerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public View a;
    public ImageView b;
    public View c;
    public VideoViewParams d;
    public Bitmap e;
    public IRoom f;
    public Rect g;
    public long h;
    public final ValueAnimator i;
    public final ValueAnimator j;
    public final ValueAnimator k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LandscapeQuickShotLayerWidget a;

        public b(LandscapeQuickShotLayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapeQuickShotLayerWidget r0 = this.a;     // Catch: Throwable -> L9
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

    public final void xq() {
        vr1.u r1 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.j<m0> r2 = r1.N();
        if (r2 == null) goto L9;
        m0 r3 = (m0) r2.getValue();
        if (r3 == null) goto L9;
        this.g = r3.a();
    L9:
        ValueAnimator r4 = this.i;
        if (r4 == null) goto L12;
        r4.cancel();
    L12:
        ValueAnimator r5 = this.j;
        if (r5 == null) goto L15;
        r5.cancel();
    L15:
        ValueAnimator r6 = this.k;
        if (r6 == null) goto L18;
        r6.cancel();
    L18:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L21;
        r7.setAlpha(1.0f);
    L21:
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r8);
    L24:
        View r9 = this.a;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L27:
        if (r9 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r9);
    L29:
        ImageView r10 = this.b;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L32:
        if (r10 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r10);
    L34:
        View r11 = this.c;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L37:
        if (r11 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r11);
    L39:
        View r12 = ((Widget) this).contentView;
        if (r12 == null) goto L43;
        r12.setOnClickListener(null);
        return;
    }

    public final int getLayoutId() {
        int r0 = bs1.a.a;
        return 2131567961;
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

    public LandscapeQuickShotLayerWidget() {
        this.i = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.j = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.k = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        this.l = LazyKt.lazy(LandscapeQuickShotLayerWidget$imgFinalWidth$2.INSTANCE);
    }

    public final void onChanged(Object r21) {
        KVData r0 = (KVData) r21;
        if (r0 == null) goto L84;
        String r1 = r0.getKey();
        switch(r1.hashCode()) {
            case -1956533084: goto L81;
            case -1210674534: goto L59;
            case -904942447: goto L56;
            case 84498020: goto L8;
            default: goto L102;
        };
    L8:
        if (r1.equals("data_live_quick_shot_bitmap") == false) goto L99;
        ((Widget) this).dataCenter.put("data_live_quick_shot_layer_show", Boolean.TRUE);
        bs1.b r2 = (bs1.b) r0.getData();
        if (r2 == null) goto L12;
        Bitmap r3 = r2.b;
    L13:
        if (r3 == null) goto L100;
        if (r2.a == null) goto L101;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotShareDialogShow(r2.d);
        xq();
        this.e = r2.b;
        this.h = r2.d;
        View r4 = r2.a;
        Intrinsics.checkNotNull(r4);
        Bitmap r5 = r2.b;
        Intrinsics.checkNotNull(r5);
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        View r6 = this.a;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L19:
        UtilityKotlinExtentionsKt.w(r6);
        ImageView r7 = this.b;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L22:
        UtilityKotlinExtentionsKt.w(r7);
        ImageView r8 = this.b;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        r8.setImageBitmap(r5);
        float r9 = s1.e(112.0f);
        r4.getLocationInWindow(new int[2]);
        Rect r10 = this.g;
        if (r10 == null) goto L28;
        int r11 = r10.height();
    L29:
        float r12 = r11;
        float r13 = 2;
        float r14 = (s1.e(96.0f) + r12) / r13;
        VideoViewParams r15 = this.d;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L32:
        int r16 = (int) (r14 - (((r9 / r15.a) * r12) / r13));
        Rect r17 = this.g;
        if (r17 == null) goto L35;
        int r18 = r17.width();
    L36:
        float r19 = ((r18 - r4.getWidth()) - s1.f(14.0f)) - r9;
        Ref.IntRef r20 = new Ref.IntRef();
        VideoViewParams r22 = this.d;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L39:
        r20.element = r22.a;
        Ref.IntRef r23 = new Ref.IntRef();
        VideoViewParams r24 = this.d;
        if (r24 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L42:
        r23.element = r24.b;
        Ref.FloatRef r110 = new Ref.FloatRef();
        r110.element = 0.0f;
        Ref.IntRef r111 = new Ref.IntRef();
        VideoViewParams r25 = this.d;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L45:
        r111.element = r25.c + s1.r();
        if (r20.element > 0) goto L48;
    L49:
        r20.element = s1.t();
        r23.element = s1.r();
        r110.element = 0.0f;
        r111.element = s1.r();
    L50:
        int r26 = r20.element;
        int r27 = r23.element;
        if (r26 >= r27) goto L54;
        r26 = r27;
    L54:
        float r28 = ((Number) this.l.getValue()).floatValue() / r26;
        Ref.FloatRef r29 = new Ref.FloatRef();
        r29.element = 0.0f;
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 0;
        Ref.IntRef r30 = new Ref.IntRef();
        r30.element = 0;
        Ref.FloatRef r31 = new Ref.FloatRef();
        r31.element = 0.0f;
        Ref.IntRef r32 = new Ref.IntRef();
        r32.element = 0;
        Ref.IntRef r33 = new Ref.IntRef();
        r33.element = 0;
        this.i.addUpdateListener(new j(this, r5, r29, r31, r28, r32, r20, r33, r23, r112, r110, r19, r30, r111, r16));
        this.i.start();
        int r34 = bs1.a.a;
        return;
    L48:
        if (r23.element > 0) goto L50;
    L35:
        r18 = 0;
        goto L36
    L28:
        r11 = 0;
        goto L29
    L101:
        return;
    L100:
        return;
    L12:
        r3 = null;
        goto L13
    L99:
        return;
    L56:
        if (r1.equals("data_live_quick_record_finish") == false) goto L90;
        xq();
        return;
    L90:
        return;
    L59:
        if (r1.equals("data_live_quick_shot_path") == false) goto L92;
        bs1.b r35 = (bs1.b) r0.getData();
        long r36 = this.h;
        if (r35 == null) goto L63;
        long r37 = r35.d;
    L64:
        int r38 = (r36 > r37 ? 1 : (r36 == r37 ? 0 : -1));
        int r39 = bs1.a.a;
        if (r35 == null) goto L93;
        String r40 = r35.c;
        if (r40 == null) goto L94;
        Bitmap r41 = r35.b;
        IRoom r42 = this.f;
        if (r42 == null) goto L76;
        IRoomAuthStatus r43 = r42.getRoomAuthStatus();
        if (r43 == null) goto L76;
        if (r43.enableLandscapeScreenShare() != true) goto L76;
        ((Widget) this).contentView.post(new i(this, r41, r40));
        return;
    L76:
        View r44 = ((Widget) this).contentView;
        if (r44 == null) goto L79;
        r44.setOnClickListener(new f(this, r41));
    L79:
        Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r41), h.a);
        return;
    L94:
        return;
    L93:
        return;
    L63:
        r37 = 0;
        goto L64
    L92:
        return;
    L81:
        if (r1.equals("data_live_quick_record_start") == false) goto L97;
        xq();
        return;
    L97:
        return;
    L102:
        return;
    }

    public final void onLoad(Object[] r5) {
        this.a = findViewById(2131389907);
        this.b = (ImageView) findViewById(2131389922);
        this.c = findViewById(2131364832);
        this.d = (VideoViewParams) ((Widget) this).dataCenter.get("live_render_view_params", new VideoViewParams(0, 0, 0, 0.0f));
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
        xq();
    }

    public static final void wq(LandscapeQuickShotLayerWidget r3, Bitmap r4) {
        ((Widget) r3).dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r0 = new int[2];
        View r1 = ((Widget) r3).contentView;
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r0);
    L5:
        r3.k.addUpdateListener(new e(r3, r4));
        r3.k.start();
    }
}
