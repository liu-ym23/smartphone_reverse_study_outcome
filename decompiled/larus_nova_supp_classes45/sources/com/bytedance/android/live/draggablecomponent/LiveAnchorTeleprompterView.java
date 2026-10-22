package com.bytedance.android.live.draggablecomponent;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveAnchorTeleprompterView extends FrameLayout implements c61.f {
    public c61.h a;
    public final LiveAnchorTeleprompterView b;
    public final ViewGroup c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final NestedScrollView f;
    public Disposable g;
    public final Lazy h;
    public final HSImageView i;
    public final HSImageView j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveAnchorTeleprompterView a;

        public a(LiveAnchorTeleprompterView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveAnchorTeleprompterView.c(this.a, true);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveAnchorTeleprompterView a;

        public b(LiveAnchorTeleprompterView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveAnchorTeleprompterView.c(this.a, false);
        }
    }

    public static final class c {
    }

    static {
    }

    private final LiveAnchorTeleprompterVm getTeleprompterVm() {
        return (LiveAnchorTeleprompterVm) this.h.getValue();
    }

    public final void b() {
    }

    public long getIdentity() {
        return 0;
    }

    public final void onDestroy() {
        Disposable r0 = this.g;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public c61.h getDraggableConfig() {
        return this.a;
    }

    public View getMView() {
        return this.b;
    }

    public LiveAnchorTeleprompterView(final Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        super(r15);
        Spannable r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        boolean r2 = false;
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.i r3 = r1.isAnchor();
        if (r3 == null) goto L9;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L9;
        boolean r4 = true;
    L11:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r15, true, r4) == false) goto L13;
        int r6 = s1.w() - UtilityKotlinExtentionsKt.i(52);
        int r7 = UtilityKotlinExtentionsKt.i(128);
    L14:
        this.a = new c61.h(5, r6 - r7, 46);
        this.b = this;
        this.h = LazyKt.lazy(LiveAnchorTeleprompterView$teleprompterVm$2.INSTANCE);
        View r0 = LayoutInflater.from(r15).inflate(2131566849, this);
        if ((r0 instanceof ViewGroup) == true) goto L17;
        r0 = null;
    L17:
        ViewGroup r8 = (ViewGroup) r0;
        this.c = r8;
        TextView r9 = (TextView) findViewById(2131378214);
        TextView r11 = (TextView) findViewById(2131378217);
        ConstraintLayout r12 = findViewById(2131378212);
        this.d = r12;
        ConstraintLayout r13 = findViewById(2131378221);
        this.e = r13;
        ImageView r14 = (ImageView) findViewById(2131378215);
        ImageView r16 = (ImageView) findViewById(2131378216);
        this.f = findViewById(2131378211);
        TextView r17 = (TextView) findViewById(2131378210);
        this.i = (HSImageView) findViewById(2131378213);
        this.j = (HSImageView) findViewById(2131378222);
        if (r13 == null) goto L20;
        ViewGroup.LayoutParams r18 = r13.getLayoutParams();
    L22:
        if ((r18 instanceof ConstraintLayout.LayoutParams) == true) goto L24;
        r18 = null;
    L24:
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        int r110 = s1.y();
        if (r19 == null) goto L27;
        ((ViewGroup.MarginLayoutParams) r19).width = (r110 - ((ViewGroup.MarginLayoutParams) r19).leftMargin) - ((ViewGroup.MarginLayoutParams) r19).rightMargin;
    L27:
        if (r13 == null) goto L29;
        r13.setLayoutParams(r19);
    L29:
        LiveAnchorTeleprompterVm r111 = getTeleprompterVm();
        if (r111 == null) goto L39;
        m<Boolean> r112 = r111.getFoldState();
        if (r112 == null) goto L39;
        if (((Boolean) r112.getValue()).booleanValue() != true) goto L39;
        if (r13 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r13);
    L37:
        if (r12 == null) goto L43;
        UtilityKotlinExtentionsKt.w(r12);
    L43:
        LiveAnchorTeleprompterVm r21 = getTeleprompterVm();
        if (r21 == null) goto L49;
        m<Boolean> r22 = r21.getFoldState();
        if (r22 == null) goto L49;
        if (((Boolean) r22.getValue()).booleanValue() != true) goto L49;
    L50:
        d(r2);
        if (r14 == null) goto L53;
        r14.setOnClickListener(new a(this));
    L53:
        if (r16 == null) goto L55;
        r16.setOnClickListener(new b(this));
    L55:
        if (r8 == null) goto L57;
        r8.setOnLongClickListener(new AnonymousClass4(this, r15));
    L57:
        if (r11 == null) goto L65;
        LiveAnchorTeleprompterVm r113 = getTeleprompterVm();
        if (r113 == null) goto L63;
        n<Spannable> r114 = r113.getTitle();
        if (r114 == null) goto L63;
        Spannable r115 = (Spannable) r114.getValue();
    L64:
        r11.setText(r115);
    L63:
        r115 = null;
    L65:
        if (r9 == null) goto L73;
        LiveAnchorTeleprompterVm r116 = getTeleprompterVm();
        if (r116 == null) goto L71;
        n<Spannable> r117 = r116.getFoldTitle();
        if (r117 == null) goto L71;
        Spannable r118 = (Spannable) r117.getValue();
    L72:
        r9.setText(r118);
    L71:
        r118 = null;
    L73:
        if (r17 == null) goto L80;
        LiveAnchorTeleprompterVm r119 = getTeleprompterVm();
        if (r119 == null) goto L79;
        n<Spannable> r120 = r119.getContent();
        if (r120 == null) goto L79;
        r5 = (Spannable) r120.getValue();
    L79:
        r17.setText(r5);
    L80:
        LiveAnchorTeleprompterVm r121 = getTeleprompterVm();
        if (r121 == null) goto L87;
        n<InfoBoxBackGround> r122 = r121.getBackground();
        if (r122 == null) goto L87;
        InfoBoxBackGround r123 = (InfoBoxBackGround) r122.getValue();
        if (r123 == null) goto L87;
        e(r123);
    L87:
        if (r11 == null) goto L95;
        LiveAnchorTeleprompterVm r124 = getTeleprompterVm();
        if (r124 == null) goto L95;
        n<Spannable> r125 = r124.getTitle();
        if (r125 == null) goto L95;
        Observable r126 = r125.a();
        if (r126 == null) goto L95;
        r126.subscribe(new g(r11));
    L95:
        if (r9 == null) goto L103;
        LiveAnchorTeleprompterVm r127 = getTeleprompterVm();
        if (r127 == null) goto L103;
        n<Spannable> r128 = r127.getFoldTitle();
        if (r128 == null) goto L103;
        Observable r129 = r128.a();
        if (r129 == null) goto L103;
        r129.subscribe(new h(r9));
    L103:
        if (r17 == null) goto L111;
        LiveAnchorTeleprompterVm r130 = getTeleprompterVm();
        if (r130 == null) goto L111;
        n<Spannable> r131 = r130.getContent();
        if (r131 == null) goto L111;
        Observable r132 = r131.a();
        if (r132 == null) goto L111;
        r132.subscribe(new i(r17));
    L111:
        LiveAnchorTeleprompterVm r133 = getTeleprompterVm();
        if (r133 == null) goto L119;
        n<InfoBoxBackGround> r134 = r133.getBackground();
        if (r134 == null) goto L120;
        Observable r135 = r134.a();
        if (r135 == null) goto L121;
        r135.subscribe(new j(this));
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L49:
        r2 = true;
    L39:
        if (r12 == null) goto L41;
        UtilityKotlinExtentionsKt.t(r12);
    L41:
        if (r13 == null) goto L43;
        UtilityKotlinExtentionsKt.w(r13);
        goto L43
    L20:
        r18 = null;
        goto L22
    L13:
        r6 = (s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(52);
        r7 = UtilityKotlinExtentionsKt.i(128);
    L9:
        r4 = false;
        goto L11
    }

    public static void d(boolean r3) {
        DraggableWindowContext.Companion.getClass();
        c61.g r0 = DraggableWindowContext.b.a();
        if (r0 == null) goto L12;
        c61.e r1 = r0.monitor();
        if (r1 == null) goto L13;
        c61.b r2 = new c61.b("livesdk_telepromoter_components_show");
        if (r3 == false) goto L9;
        String r4 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L10:
        r2.b("status", r4);
        Unit r5 = Unit.INSTANCE;
        r1.a(r2.a());
        return;
    L9:
        r4 = "0";
        goto L10
    L13:
        return;
    }

    public final void e(InfoBoxBackGround r6) {
        if (r6 == null) goto L16;
        String r0 = r6.backgroundColor;
        if (r0 == null) goto L16;
        if ((!TextUtils.isEmpty(r0)) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L16;
        ConstraintLayout r1 = this.d;
        if (r1 == null) goto L13;
        r1.setBackgroundColor(ColorProtector.parseColor(r0));
    L13:
        ConstraintLayout r2 = this.e;
        if (r2 == null) goto L16;
        r2.setBackgroundColor(ColorProtector.parseColor(r0));
    L16:
        if (r6 == null) goto L25;
        Long r3 = r6.backgroundAlpha;
        if (r3 == null) goto L25;
        long r4 = r3.longValue();
        ConstraintLayout r5 = this.d;
        if (r5 == null) goto L22;
        r5.setAlpha(r4 / 100.0f);
    L22:
        ConstraintLayout r7 = this.e;
        if (r7 == null) goto L25;
        r7.setAlpha(r4 / 100.0f);
    L25:
        if (r6 == null) goto L30;
        ImageModel r8 = r6.backgroundImage;
        if (r8 == null) goto L31;
        ImageLoader.bindImage(this.i, r8);
        ImageLoader.bindImage(this.j, r8);
        return;
    L31:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    public void setDraggableConfig(c61.h r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public static final void a(LiveAnchorTeleprompterView r5, String r6) {
        r5.getClass();
        DraggableWindowContext.Companion.getClass();
        c61.g r0 = DraggableWindowContext.b.a();
        if (r0 == null) goto L21;
        c61.e r1 = r0.monitor();
        if (r1 == null) goto L22;
        c61.b r2 = new c61.b("livesdk_draggable_close_dialog_click");
        Object r3 = r5.getTag();
        String r4 = null;
        if ((r3 instanceof c61.c) == true) goto L9;
        r3 = null;
    L9:
        c61.c r7 = (c61.c) r3;
        if (r7 == null) goto L12;
        Long r8 = r7.getType();
    L13:
        r2.b("type", r8);
        Object r9 = r5.getTag();
        if ((r9 instanceof c61.c) == true) goto L16;
        r9 = null;
    L16:
        c61.c r11 = (c61.c) r9;
        if (r11 == null) goto L19;
        r4 = r11.b;
    L19:
        r2.b("scene", r4);
        r2.b("button_type", r6);
        Unit r12 = Unit.INSTANCE;
        r1.a(r2.a());
        return;
    L12:
        r8 = null;
        goto L13
    L22:
        return;
    }

    public static final void c(LiveAnchorTeleprompterView r4, boolean r5) {
        if (r5 == false) goto L14;
        LiveAnchorTeleprompterVm r0 = r4.getTeleprompterVm();
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.getFoldState();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.FALSE);
    L8:
        ConstraintLayout r2 = r4.d;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r2);
    L11:
        ConstraintLayout r3 = r4.e;
        if (r3 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r3);
    L25:
        r4.getClass();
        d(r5);
        DraggableWindowContext.Companion.getClass();
        c61.g r6 = DraggableWindowContext.b.a();
        if (r6 == null) goto L44;
        c61.e r7 = r6.monitor();
        if (r7 == null) goto L45;
        c61.b r8 = new c61.b("livesdk_draggable_component_click");
        Object r9 = r4.getTag();
        String r11 = null;
        if ((r9 instanceof c61.c) == true) goto L32;
        r9 = null;
    L32:
        c61.c r12 = (c61.c) r9;
        if (r12 == null) goto L35;
        Long r13 = r12.getType();
    L36:
        r8.b("type", r13);
        Object r14 = r4.getTag();
        if ((r14 instanceof c61.c) == true) goto L39;
        r14 = null;
    L39:
        c61.c r15 = (c61.c) r14;
        if (r15 == null) goto L42;
        r11 = r15.b;
    L42:
        r8.b("scene", r11);
        Unit r16 = Unit.INSTANCE;
        r7.a(r8.a());
        return;
    L35:
        r13 = null;
        goto L36
    L45:
        return;
    L44:
        return;
    L14:
        LiveAnchorTeleprompterVm r17 = r4.getTeleprompterVm();
        if (r17 == null) goto L19;
        m<Boolean> r18 = r17.getFoldState();
        if (r18 == null) goto L19;
        r18.setValue(Boolean.TRUE);
    L19:
        ConstraintLayout r19 = r4.e;
        if (r19 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r19);
    L22:
        ConstraintLayout r21 = r4.d;
        if (r21 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r21);
        goto L25
    }
}
