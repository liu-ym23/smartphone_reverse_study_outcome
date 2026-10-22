package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotObserveWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotObserveWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int o = 0;
    public final String a;
    public View b;
    public HSImageView c;
    public View d;
    public VideoViewParams e;
    public Room f;
    public Rect g;
    public bs1.b h;
    public GestureDetector i;
    public final ValueAnimator j;
    public final ValueAnimator k;
    public final ValueAnimator l;
    public final Lazy m;
    public final b n;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ LandscapeQuickShotObserveWidget a;

        public b(LandscapeQuickShotObserveWidget r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "e2");
            if (Math.abs(r7) <= Math.abs(r8)) goto L8;
            if (r7 >= 0) goto L8;
            int r1 = x8.a.a;
            x8.a.d(this.a.a, "scroll & dismiss ____ distanceX = " + r7 + "   +   distanceY = " + r8 + ' ', false);
            LandscapeQuickShotObserveWidget.wq(this.a);
        L8:
            return super.onScroll(r5, r6, r7, r8);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LandscapeQuickShotObserveWidget a;

        public c(LandscapeQuickShotObserveWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapeQuickShotObserveWidget r0 = this.a;     // Catch: Throwable -> L9
            DataCenter r1 = ((Widget) r0).dataCenter;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            VideoViewParams r2 = (VideoViewParams) r1.get("live_render_view_params");     // Catch: Throwable -> L9
            if (r2 == null) goto L6;
        L7:
            r0.e = r2;     // Catch: Throwable -> L9
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

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ LandscapeQuickShotObserveWidget a;

        public d(LandscapeQuickShotObserveWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            GestureDetector r3 = this.a.i;
            if (r3 == null) goto L7;
            Intrinsics.checkNotNull(r2);
            r3.onTouchEvent(r2);
            return false;
        L7:
            return false;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565712;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        List r0 = CollectionsKt.mutableListOf(new String[]{"data_live_quickshot_auto_observe"});
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

    public final void xq() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getRoomUISizeGetter();
        if (r1 == null) goto L9;
        m0 r2 = (m0) r1.getValue();
        if (r2 == null) goto L9;
        this.g = r2.a();
    L9:
        ValueAnimator r3 = this.j;
        if (r3 == null) goto L12;
        r3.cancel();
    L12:
        ValueAnimator r4 = this.k;
        if (r4 == null) goto L15;
        r4.cancel();
    L15:
        ValueAnimator r5 = this.l;
        if (r5 == null) goto L18;
        r5.cancel();
    L18:
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L21;
        r6.setAlpha(1.0f);
    L21:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r7);
    L24:
        View r8 = this.b;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L27:
        if (r8 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r8);
    L29:
        HSImageView r9 = this.c;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L32:
        if (r9 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r9);
    L34:
        View r10 = this.d;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L37:
        if (r10 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r10);
    L39:
        View r11 = ((Widget) this).contentView;
        if (r11 == null) goto L43;
        r11.setOnClickListener(null);
        return;
    }

    public LandscapeQuickShotObserveWidget() {
        this.a = "LandscapeQuickShotObserveWidget";
        this.j = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.k = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.l = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
        this.m = LazyKt.lazy(LandscapeQuickShotObserveWidget$imgFinalWidth$2.INSTANCE);
        this.n = new b(this);
    }

    public static final void wq(LandscapeQuickShotObserveWidget r3) {
        ((Widget) r3).dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r0 = new int[2];
        View r1 = ((Widget) r3).contentView;
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r0);
    L5:
        r3.l.addUpdateListener(new m(r3));
        r3.l.start();
    }

    public final void onChanged(Object r18) {
        KVData r0 = (KVData) r18;
        if (r0 == null) goto L59;
        String r1 = r0.getKey();
        if (r1.hashCode() != (-391345406)) goto L59;
        if (r1.equals("data_live_quickshot_auto_observe") == false) goto L59;
        bs1.b r2 = (bs1.b) r0.getData();
        this.h = r2;
        if (r2 == null) goto L12;
        String r3 = r2.c;
    L14:
        if (TextUtils.isEmpty(r3) == true) goto L59;
        xq();
        bs1.b r4 = this.h;
        if (r4 == null) goto L59;
        String r5 = r4.c;
        if (r5 == null) goto L59;
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        View r6 = this.b;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L22:
        UtilityKotlinExtentionsKt.w(r6);
        HSImageView r7 = this.c;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        UtilityKotlinExtentionsKt.w(r7);
        PolarisFileWrapper r8 = new PolarisFileWrapper(r5);
        HSImageView r9 = this.c;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L28:
        r9.setImageURI(Uri.fromFile(r8).toString());
        float r10 = s1.e(112.0f);
        Rect r11 = this.g;
        if (r11 == null) goto L31;
        int r12 = r11.height();
    L32:
        float r13 = r12;
        float r14 = 2;
        float r15 = (s1.e(96.0f) + r13) / r14;
        VideoViewParams r16 = this.e;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L35:
        int r17 = (int) (r15 - (((r10 / r16.a) * r13) / r14));
        Ref.FloatRef r19 = new Ref.FloatRef();
        Rect r20 = this.g;
        if (r20 == null) goto L38;
        int r21 = r20.width();
    L39:
        r19.element = (r21 - s1.f(14.0f)) - r10;
        Ref.IntRef r22 = new Ref.IntRef();
        VideoViewParams r23 = this.e;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L42:
        r22.element = r23.a;
        Ref.IntRef r24 = new Ref.IntRef();
        VideoViewParams r25 = this.e;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L45:
        r24.element = r25.b;
        Ref.FloatRef r110 = new Ref.FloatRef();
        r110.element = 0.0f;
        Ref.IntRef r111 = new Ref.IntRef();
        VideoViewParams r26 = this.e;
        if (r26 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L48:
        r111.element = r26.c + s1.r();
        if (r22.element > 0) goto L51;
    L52:
        r22.element = s1.t();
        r24.element = s1.r();
        r110.element = 0.0f;
        r111.element = s1.r();
    L53:
        int r27 = r22.element;
        int r28 = r24.element;
        if (r27 >= r28) goto L57;
        r27 = r28;
    L57:
        float r29 = ((Number) this.m.getValue()).floatValue() / r27;
        Ref.FloatRef r30 = new Ref.FloatRef();
        r30.element = 0.0f;
        Ref.IntRef r31 = new Ref.IntRef();
        r31.element = 0;
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 0;
        Ref.FloatRef r32 = new Ref.FloatRef();
        r32.element = 0.0f;
        Ref.IntRef r33 = new Ref.IntRef();
        r33.element = 0;
        Ref.IntRef r34 = new Ref.IntRef();
        r34.element = 0;
        r19.element = ((s1.t() - UtilityKotlinExtentionsKt.i(112)) - UtilityKotlinExtentionsKt.i(168)) - UtilityKotlinExtentionsKt.i(12);
        this.j.addUpdateListener(new o(this, r30, r32, r29, r33, r22, r34, r24, r31, r110, r19, r112, r111, r17));
        this.j.start();
        ((Widget) this).contentView.post(new n(this));
        return;
    L51:
        if (r24.element > 0) goto L53;
    L38:
        r21 = 0;
        goto L39
    L31:
        r12 = 0;
        goto L32
    L12:
        r3 = null;
    }

    public final void onLoad(Object[] r4) {
        this.b = findViewById(2131389907);
        this.c = findViewById(2131389922);
        this.d = findViewById(2131364832);
        this.e = (VideoViewParams) ((Widget) this).dataCenter.get("live_render_view_params", new VideoViewParams(0, 0, 0, 0.0f));
        ((Widget) this).contentView.post(new c(this));
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L10;
        List r0 = CollectionsKt.mutableListOf(new String[]{"data_live_quickshot_auto_observe"});
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r5.observe((String) r1.next(), this);
    L10:
        com.bytedance.android.livesdk.f.d().a.observe(this, new AnonymousClass3(this));
        this.f = (Room) ((Widget) this).dataCenter.get("data_room");
        xq();
        this.i = new GestureDetector(((Widget) this).context, this.n);
        View r6 = this.b;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L13:
        if (r6 == null) goto L17;
        r6.setOnTouchListener(new d(this));
        return;
    }
}
