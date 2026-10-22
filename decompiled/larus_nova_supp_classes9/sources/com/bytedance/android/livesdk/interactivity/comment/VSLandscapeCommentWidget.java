package com.bytedance.android.livesdk.interactivity.comment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.view.CommentWidgetAnimator;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeDanmakuSend, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/VSLandscapeCommentWidget;", "Lcom/bytedance/android/livesdk/interactivity/comment/CommentWidget;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLandscapeCommentWidget extends CommentWidget {
    public static final /* synthetic */ int v2 = 0;
    public Disposable h2;
    public boolean p2;

    public static final class a {
    }

    public static final class b extends CommentWidgetAnimator {
        public final /* synthetic */ VSLandscapeCommentWidget m;

        @Override // com.bytedance.android.livesdk.interactivity.comment.view.CommentWidgetAnimator
        public final void b(boolean r6) {
            com.bytedance.android.livesdk.log.j0 r0 = com.bytedance.android.livesdk.log.j0.l();
            Pair[] r1 = new Pair[3];
            r1[0] = TuplesKt.to("room_orientation", "1");
            if (r6 == false) goto L5;
            String r7 = "close";
        L6:
            r1[1] = TuplesKt.to("mute_barrage_type", r7);
            r1[2] = TuplesKt.to("request_page", "bottom");
            Map r8 = MapsKt.mapOf(r1);
            am2.x r3 = new am2.x();
            r3.a = "live";
            r3.e = "click";
            r3.b = "live_detail";
            r0.sendLog("livesdk_landscape_mute_gift_barrage_click", r8, new Object[]{IRoom.class, r3});
            return;
        L5:
            r7 = "open";
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.view.CommentWidgetAnimator
        public final void c(boolean r5, boolean r6) {
            super.c(r5, r6);
            if (r5 == true) goto L15;
            final VSLandscapeCommentWidget r7 = this.m;
            if (r7.p2 == true) goto L19;
            IRoomContextService r8 = jc1.k.f(IRoomContextService.class);
            if (r8 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.o r9 = IRoomContextService.a.a(r8, ((Widget) r7).dataCenter, 0, 2);
            if (r9 == null) goto L17;
            com.bytedance.live.datacontext.j r10 = r9.a2();
            if (r10 == null) goto L18;
            r10.c(new VSLandscapeCommentWidget$logSettingIconShow$1(r7));
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L19:
            return;
        }

        public b(VSLandscapeCommentWidget r8, View r9, View r10, View r11, LottieAnimationView r13, int r14) {
            this.m = r8;
            super(r9, r10, r11, r13, r14, false);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCommentWidget a;

        public c(VSLandscapeCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.kr();
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ VSLandscapeCommentWidget a;
        public final /* synthetic */ ConstraintLayout.LayoutParams b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            IMiddlewareRoomService r0 = jc1.k.f(IMiddlewareRoomService.class);
            if (r0 == null) goto L74;
            Class r1 = r0.getToolbarWidgetClass();
            if (r1 == null) goto L78;
            VSLandscapeCommentWidget r2 = this.a;
            int r3 = VSLandscapeCommentWidget.v2;
            WidgetInfo r4 = r2.getWidgetInfo(r1);
            if (r4 == null) goto L75;
            Rect r5 = r4.getGlobalVisibleRect();
            if (r5 == null) goto L79;
            Rect r6 = new Rect();
            View r7 = ((Widget) this.a).contentView;
            if (r7 == null) goto L15;
            r7.getGlobalVisibleRect(r6);
        L15:
            int r8 = r6.right;
            pm1.h r9 = pm1.h.d;
            nm1.p r10 = (nm1.p) r9.c(nm1.p.class);
            if (r10 == null) goto L33;
            boolean r11 = true;
            if (r10.a(((Widget) this.a).dataCenter) != true) goto L33;
            VSLandscapeCommentWidget r13 = this.a;
            r13.getClass();
            IVSPlayerService r14 = jc1.k.f(IVSPlayerService.class);
            if (r14 == null) goto L30;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r15 = r14.provideVSPlayerViewControlService(((Widget) r13).dataCenter);
            if (r15 == null) goto L30;
            VSPlayerViewControlContext r16 = r15.provideContext();
            if (r16 == null) goto L30;
            com.bytedance.live.datacontext.m r17 = r16.getPlayerViewIsInZoom();
            if (r17 == null) goto L30;
            if (((Boolean) r17.getValue()).booleanValue() != true) goto L30;
            boolean r18 = true;
        L31:
            if (r18 == false) goto L33;
        L34:
            if (r11 == false) goto L58;
            VSLandscapeCommentWidget r19 = this.a;
            nm1.p r20 = (nm1.p) r9.c(nm1.p.class);
            if (r20 == null) goto L38;
            Class r21 = r20.d();
        L39:
            WidgetInfo r23 = r19.getWidgetInfo(r21);
            if (r23 == null) goto L44;
            Rect r24 = r23.getGlobalVisibleRect();
            if (r24 == null) goto L44;
            r24.width();
        L44:
            if (r23 == null) goto L48;
            Rect r25 = r23.getGlobalVisibleRect();
            if (r25 == null) goto L48;
            int r26 = r25.right;
        L50:
            if (r26 <= r5.left) goto L54;
            ConstraintLayout.LayoutParams r27 = this.b;
            if (r27 == null) goto L65;
            r27.matchConstraintMaxWidth = 0;
        L65:
            ViewGroup r28 = ((Widget) this.a).containerView;
            if (r28 == null) goto L68;
            r28.setLayoutParams(this.b);
        L68:
            View r29 = ((Widget) this.a).contentView;
            if (r29 == null) goto L76;
            ViewTreeObserver r30 = r29.getViewTreeObserver();
            if (r30 == null) goto L77;
            r30.removeOnGlobalLayoutListener(this);
            return;
        L77:
            return;
        L76:
            return;
        L54:
            ConstraintLayout.LayoutParams r31 = this.b;
            if (r31 == null) goto L65;
            r31.matchConstraintMaxWidth = this.a.Kq();
        L48:
            r26 = 0;
            goto L50
        L38:
            r21 = null;
            goto L39
        L58:
            if (r8 <= r5.left) goto L62;
            ConstraintLayout.LayoutParams r33 = this.b;
            if (r33 == null) goto L65;
            r33.matchConstraintMaxWidth = 0;
            goto L65
        L62:
            ConstraintLayout.LayoutParams r34 = this.b;
            if (r34 == null) goto L65;
            r34.matchConstraintMaxWidth = this.a.Kq();
        L30:
            r18 = false;
        L33:
            r11 = false;
            goto L34
        L79:
            return;
        L75:
            return;
        L78:
            return;
        }

        public d(VSLandscapeCommentWidget r1, ConstraintLayout.LayoutParams r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final int getLayoutId() {
        return 2131567638;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final String getSpm() {
        return "a100.a100.a285";
    }

    public static boolean Fr() {
        com.bytedance.android.livesdk.sharedpref.e<m42.a> r0 = l42.a.w;
        m42.a r1 = (m42.a) r0.getValue();
        if (r1.a == false) goto L5;
        return false;
    L5:
        long r4 = System.currentTimeMillis();
        long r2 = r1.b;
        if (r2 > 0) goto L8;
    L10:
        if (r2 > 0) goto L14;
        m42.a r3 = new m42.a();
        r3.b = r4;
        Unit r5 = Unit.INSTANCE;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        return true;
    L14:
        return true;
    L8:
        if ((r2 + 2592000000L) >= r4) goto L10;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final CommentWidgetAnimator Iq() {
        b r7 = new b(this, this.b, this.d, this.a, this.o, ColorProtector.parseColor("#33FFFFFF"));
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_close.json", "<set-?>");
        r7.f = "vs_danmaku/vs_danmaku_close.json";
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_open.json", "<set-?>");
        r7.g = "vs_danmaku/vs_danmaku_open.json";
        return r7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final int Kq() {
        return UtilityKotlinExtentionsKt.i(250);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final boolean Wq() {
        return !((Boolean) ((Widget) this).dataCenter.get("byte_cast_danmaku_mode", Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void kr() {
        ViewGroup r0 = ((Widget) this).containerView;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        ((Widget) this).contentView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, (ConstraintLayout.LayoutParams) r1));
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final /* bridge */ /* synthetic */ Boolean Cq() {
        return Boolean.valueOf(Fr());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void Sq() {
        super.Sq();
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 != null) goto L5;
    L13:
        View r1 = this.b;
        if (r1 == null) goto L16;
        UIUtils.setLayoutParams(r1, Integer.MIN_VALUE, s1.f(34.0f));
    L16:
        TextView r2 = this.a;
        if (r2 == null) goto L20;
        UIUtils.setLayoutParams(r2, Integer.MIN_VALUE, s1.f(34.0f));
        return;
    L20:
        return;
    L5:
        if (r0.canShowCastDanmakuBtn(((Widget) this).dataCenter) != true) goto L13;
        View r3 = this.d;
        if (r3 == null) goto L13;
        if (((Boolean) ((Widget) this).dataCenter.get("byte_cast_danmaku_mode", Boolean.FALSE)).booleanValue() == false) goto L11;
        int r4 = 8;
    L12:
        r3.setVisibility(r4);
        goto L13
    L11:
        r4 = 0;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onUnload() {
        super.onUnload();
        this.p2 = false;
        Disposable r0 = this.h2;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.h2;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public VSLandscapeCommentWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void Pq(KVData r3) {
        Intrinsics.checkNotNullParameter(r3, "kvData");
        super.Pq(r3);
        View r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) r3.getData(Boolean.FALSE), Boolean.TRUE) == false) goto L7;
        int r4 = 8;
    L8:
        r0.setVisibility(r4);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onInit(Object[] r2) {
        ImageView r0 = (ImageView) findViewById(2131376162);
        this.d = findViewById(2131385977);
        this.e = findViewById(2131384096);
        super.onInit(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void onLoad(Object[] r4) {
        super.onLoad(r4);
        LottieAnimationView r5 = this.o;
        if (r5 == null) goto L5;
        r5.setImageAssetsFolder("vs_danmaku/images_landscape_opt");
    L5:
        View r6 = this.d;
        if (r6 == null) goto L9;
        r6.setOnClickListener(new AnonymousClass1(this));
    L9:
        if (Fr() == false) goto L13;
        RedDotView r7 = this.e;
        if (r7 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r7);
    L16:
        r3.c(this.d, "弹幕设置", true);
        ViewGroup r8 = ((Widget) this).containerView;
        Disposable r0 = null;
        if (r8 == null) goto L19;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L21:
        if ((r9 instanceof ConstraintLayout.LayoutParams) == true) goto L23;
        r9 = null;
    L23:
        ViewGroup.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
        if (r10 == null) goto L26;
        ((ConstraintLayout.LayoutParams) r10).horizontalChainStyle = 2;
        ((ConstraintLayout.LayoutParams) r10).horizontalBias = 0.0f;
        ((ConstraintLayout.LayoutParams) r10).constrainedWidth = true;
        ((ConstraintLayout.LayoutParams) r10).matchConstraintMaxWidth = Kq();
    L26:
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L29;
        r1.setLayoutParams(r10);
    L29:
        IVSPlayerService r11 = jc1.k.f(IVSPlayerService.class);
        if (r11 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = r11.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r13 == null) goto L40;
        VSPlayerViewControlContext r14 = r13.provideContext();
        if (r14 == null) goto L40;
        com.bytedance.live.datacontext.m r15 = r14.getPlayerViewIsInZoom();
        if (r15 == null) goto L40;
        Observable r16 = r15.a();
        if (r16 == null) goto L40;
        r0 = r16.subscribe(new c(this));
    L40:
        this.h2 = r0;
        return;
    L19:
        r9 = null;
        goto L21
    L13:
        RedDotView r17 = this.e;
        if (r17 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r17);
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget
    public final void yr(boolean r3) {
        View r0 = this.b;
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131249086);
    L5:
        View r1 = this.b;
        if (r1 == null) goto L12;
        if (r3 == false) goto L9;
        int r4 = 8;
    L10:
        r1.setVisibility(r4);
        return;
    L9:
        r4 = 0;
        goto L10
    }
}
