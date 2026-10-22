package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import am2.x;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qu0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomTitle;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/LiveTitleDetailWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/a$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTitleDetailWidget extends LiveWidget implements com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b, Observer<KVData> {
    public final GestureDetectorCompat a;
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public ParentTouchScrollView e;
    public TextView f;
    public TextView g;
    public View h;
    public View i;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            Function0<Unit> r3 = this.a;
            if (r3 == null) goto L7;
            r3.invoke();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            Function0<Unit> r5 = this.a;
            if (r5 == null) goto L7;
            r5.invoke();
            return true;
        L7:
            return true;
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ LiveTitleDetailWidget a;

        public b(LiveTitleDetailWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            if (r3 != null) goto L4;
        L6:
            this.a.a.onTouchEvent(r3);
            return true;
        L4:
            if (r3.getAction() != 0) goto L6;
            xs2.b.a().post(new d0());
            goto L6
        }
    }

    public final int getLayoutId() {
        return 2131566854;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final void C4() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final boolean isShowing() {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public LiveTitleDetailWidget() {
        this.a = new GestureDetectorCompat(((Widget) this).context, new a(LiveTitleDetailWidget$gesture$1.INSTANCE));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r0 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        Intrinsics.checkNotNullParameter(this, "view");
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a = this;
        int r1 = 8;
        ((Widget) this).contentView.setVisibility(8);
        ((Widget) this).contentView.setOnTouchListener(new b(this));
        this.b = (ViewGroup) ((Widget) this).contentView.findViewById(2131392032);
        this.c = (ViewGroup) ((Widget) this).contentView.findViewById(2131388843);
        this.d = (ViewGroup) ((Widget) this).contentView.findViewById(2131392040);
        ParentTouchScrollView r2 = ((Widget) this).contentView.findViewById(2131392951);
        this.e = r2;
        if (r2 == null) goto L5;
        r2.setTopFading(0.5f);
    L5:
        this.h = ((Widget) this).contentView.findViewById(2131378645);
        this.f = (TextView) ((Widget) this).contentView.findViewById(2131392953);
        this.g = (TextView) ((Widget) this).contentView.findViewById(2131392952);
        this.i = ((Widget) this).contentView.findViewById(2131392941);
        RelativeLayout r3 = (RelativeLayout) ((Widget) this).contentView.findViewById(2131392950);
        String r4 = null;
        Room r5 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r5 == null) goto L12;
        RoomPlatformComponentsData r6 = r5.roomPlatformComponentsData;
        if (r6 == null) goto L12;
        RoomTitle r7 = r6.getRoomTitle();
        if (r7 == null) goto L12;
        String r8 = r7.getTitle();
    L14:
        if (TextUtils.isEmpty(r8) == false) goto L23;
        TextView r9 = this.f;
        if (r9 == null) goto L33;
        if (r5 == null) goto L21;
        User r11 = r5.getOwner();
        if (r11 == null) goto L21;
        String r12 = r11.getNickName();
    L22:
        r9.setText(r12);
    L21:
        r12 = null;
    L33:
        if (r5 == null) goto L41;
        RoomPlatformComponentsData r13 = r5.roomPlatformComponentsData;
        if (r13 == null) goto L41;
        RoomTitle r14 = r13.getRoomTitle();
        if (r14 == null) goto L41;
        String r15 = r14.getIntroduction();
        if (r15 == null) goto L41;
        r4 = StringsKt.replace$default(r15, "\n", "\n\n", false, 4, null);
    L41:
        TextView r16 = this.g;
        if (r16 == null) goto L44;
        r16.setText(r4);
    L44:
        TextView r17 = this.g;
        if (r17 == null) goto L47;
        r17.post(new c(this));
    L47:
        View r18 = this.i;
        if (r18 == null) goto L56;
        RoomContext r19 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r19 != null) goto L52;
    L54:
        r18.setVisibility(r1);
        goto L56
    L52:
        if (r19.isVSFirstShow() != true) goto L54;
        r1 = 0;
    L56:
        if (PadConfigUtils.c() == false) goto L61;
        RoomContext r21 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r21 == null) goto L61;
        ((ObservableSubscribeProxy) r21.getPadOrientation().a().as(AutoDispose.bind(this))).subscribe(new e(this));
    L61:
        if (((Boolean) qu0.a.getValue()).booleanValue() == false) goto L69;
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L65;
        r22.observe("data_room_title", this);
    L65:
        DataCenter r23 = ((Widget) this).dataCenter;
        if (r23 == null) goto L70;
        r23.observe("data_room_short_title", this);
        return;
    L70:
        return;
    L69:
        return;
    L23:
        TextView r24 = this.f;
        if (r24 == null) goto L33;
        if (r5 == null) goto L31;
        RoomPlatformComponentsData r25 = r5.roomPlatformComponentsData;
        if (r25 == null) goto L31;
        RoomTitle r26 = r25.getRoomTitle();
        if (r26 == null) goto L31;
        String r27 = r26.getTitle();
    L32:
        r24.setText(r27);
    L31:
        r27 = null;
    L12:
        r8 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r0 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b.clear();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.e = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.g = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.i = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.j = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.k = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.m = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.n = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.o = null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final void y2() {
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L5;
        ((Widget) this).contentView.setPadding(0, x1.k(), 0, 0);
    L5:
        ((Widget) this).contentView.setVisibility(0);
        ParentTouchScrollView r0 = this.e;
        if (r0 == null) goto L8;
        r0.scrollTo(0, 0);
    L8:
        u.l().d("livesdk_live_intro_title_click", new Object[]{Room.class, x.class});
        u.l().d("livesdk_live_intro_panel_show", new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup B2() {
        return this.d;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup J4() {
        return this.c;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup r3() {
        return this.b;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L31;
        String r0 = r5.getKey();
        if (r0.hashCode() == 956730793) goto L11;
        return;
    L11:
        if (r0.equals("data_room_title") == false) goto L26;
        Object r6 = r5.getData();
        if ((r6 instanceof String) == true) goto L15;
        r6 = null;
    L15:
        String r7 = (String) r6;
        if (r7 != null) goto L18;
        return;
    L18:
        if ((!Intrinsics.areEqual(r7, "")) == true) goto L20;
        return;
    L20:
        if (((Boolean) qu0.a.getValue()).booleanValue() == false) goto L29;
        TextView r1 = this.f;
        if (r1 == null) goto L30;
        r1.setText(r7);
        return;
    L30:
        return;
    L29:
        return;
    L26:
        return;
    }
}
