package com.bytedance.android.livesdk.drawer.drawerlynx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.business.container.AnnieXLiveCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.webview.fragment.m;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.log.a0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.recommend.IRecommendController;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveDrawerLynxCard extends FrameLayout implements m {
    public static final /* synthetic */ int n = 0;
    public final Lazy a;
    public final Lazy b;
    public ViewPager c;
    public AndroidScrollView d;
    public final a e;
    public final long f;
    public boolean g;
    public boolean h;
    public Room i;
    public boolean j;
    public final String k;
    public final Bundle l;
    public boolean m;

    public static final class a implements ILiveDrawerLayoutInterceptor {
        public float a;
        public final /* synthetic */ LiveDrawerLynxCard b;

        public a(LiveDrawerLynxCard r1) {
            this.b = r1;
        }

        public final boolean onInterceptTouchEvent(MotionEvent r7) {
            if (r7 != null) goto L64;
            return false;
        L64:
            float r2 = r7.getRawX();     // Catch: IllegalArgumentException -> L61
            float r3 = r7.getRawY();     // Catch: IllegalArgumentException -> L61
            int r8 = r7.getAction();     // Catch: IllegalArgumentException -> L61
            if (r8 != 0) goto L9;
            this.a = r2;     // Catch: IllegalArgumentException -> L61
            HybridCard r9 = LiveDrawerLynxCard.a(this.b);     // Catch: IllegalArgumentException -> L61
            AndroidScrollView r4 = null;
            if (r9 == null) goto L34;
            View r10 = r9.getHybridView();     // Catch: IllegalArgumentException -> L61
        L36:
            if ((r10 instanceof LynxView) == true) goto L38;
            r10 = null;
        L38:
            LynxView r11 = (LynxView) r10;     // Catch: IllegalArgumentException -> L61
            if (r11 == null) goto L63;
            LiveDrawerLynxCard r5 = this.b;     // Catch: IllegalArgumentException -> L61
            if (r5.c != null) goto L53;
            View r6 = r11.findViewByIdSelector("viewpager");     // Catch: IllegalArgumentException -> L61
            if ((r6 instanceof LinearLayout) == true) goto L45;
            r6 = null;
        L45:
            LinearLayout r12 = (LinearLayout) r6;     // Catch: IllegalArgumentException -> L61
            if (r12 == null) goto L48;
            View r0 = r12.getChildAt(0);     // Catch: IllegalArgumentException -> L61
        L50:
            if ((r0 instanceof ViewPager) == true) goto L52;
            r0 = null;
        L52:
            r5.c = (ViewPager) r0;     // Catch: IllegalArgumentException -> L61
            goto L53
        L48:
            r0 = null;
        L53:
            LiveDrawerLynxCard r1 = this.b;     // Catch: IllegalArgumentException -> L61
            if (r1.d != null) goto L63;
            AndroidScrollView r13 = r11.findViewByIdSelector("history-content");     // Catch: IllegalArgumentException -> L61
            if ((r13 instanceof AndroidScrollView) == false) goto L59;
            r4 = r13;
        L59:
            r1.d = r4;     // Catch: IllegalArgumentException -> L61
        L63:
            return true;
        L34:
            r10 = null;
            goto L36
        L9:
            if (r8 != 2) goto L63;
            int r14 = (int) r2;     // Catch: IllegalArgumentException -> L61
            int r15 = (int) r3;     // Catch: IllegalArgumentException -> L61
            if (a(this.b, r14, r15) == true) goto L15;
            return false;
        L15:
            if (r2 >= this.a) goto L17;
            return true;
        L17:
            ViewPager r16 = this.b.c;     // Catch: IllegalArgumentException -> L61
            if (r16 != null) goto L20;
        L24:
            ViewPager r17 = this.b.c;     // Catch: IllegalArgumentException -> L61
            if (r17 == null) goto L63;
            if (r17.getCurrentItem() != 0) goto L63;
            if (a(this.b.c, r14, r15) == false) goto L63;
            return false;
        L20:
            if (r16.getCurrentItem() != 0) goto L24;
            if (a(this.b.d, r14, r15) == false) goto L24;
            return true;
        L61:
            e = move-exception;
            e.printStackTrace();
            goto L63
        }

        public final boolean a(View r6, int r7, int r8) {
            if (r6 != null) goto L5;
            return false;
        L5:
            int[] r1 = new int[2];
            r6.getLocationOnScreen(r1);
            int r2 = r1[0];
            int r3 = r1[1];
            int r4 = r6.getMeasuredWidth() + r2;
            int r9 = r6.getMeasuredHeight() + r3;
            if (r3 > r8) goto L16;
            if (r9 < r8) goto L13;
            if (r7 < r2) goto L14;
            if (r7 > r4) goto L15;
            return true;
        L15:
            return false;
        L14:
            return false;
        L13:
            return false;
        L16:
            return false;
        }
    }

    private final HybridCard getMHybridCard() {
        return (HybridCard) this.b.getValue();
    }

    private final Uri getUri() {
        return (Uri) this.a.getValue();
    }

    public final void g() {
        setVisibility(0);
        HybridCard r0 = getMHybridCard();
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    private final e getIContext() {
        ILiveService r1 = TTLiveService.getLiveService();
        String r2 = null;
        if (r1 == null) goto L5;
        ILiveOntologyInfoManager r3 = r1.getLiveOntologyRecord();
    L6:
        IHostService r4 = TTLiveSDK.hostService();
        if (r4 == null) goto L11;
        IHostContext r5 = r4.appContext();
        if (r5 == null) goto L11;
        LocationResult r6 = r5.getNearByLocation();
    L13:
        if (r3 == null) goto L16;
        String r7 = r3.getEnterFromMerge();
        if (r7 == null) goto L16;
    L17:
        if (r3 == null) goto L20;
        String r8 = r3.getEnterFromMerge();
        if (r8 == null) goto L20;
    L22:
        if (r3 == null) goto L25;
        String r9 = r3.getEnterMethod();
        if (r9 == null) goto L25;
    L26:
        if (r3 == null) goto L29;
        String r10 = r3.getEnterMethod();
        if (r10 == null) goto L29;
    L30:
        if (r3 == null) goto L32;
        boolean r11 = r3.isFromMatchRoom();
    L33:
        Room r12 = this.i;
        if (r12 == null) goto L37;
        String r13 = r12.getIdStr();
        if (r13 == null) goto L37;
    L38:
        boolean r14 = this.j;
        IRecommendController r15 = k.f(IRecommendController.class);
        if (r15 != null) goto L41;
    L43:
        boolean r16 = false;
    L44:
        boolean r17 = PadConfigUtils.c();
        boolean r18 = e5.n();
        c0 r19 = c0.b();
        Room r20 = this.i;
        r19.getClass();
        boolean r110 = c0.e(r20);
        if (r6 == null) goto L50;
        String r21 = r6.cityCode;
        if (r21 == null) goto L50;
        String r111 = r21;
    L51:
        if (r6 == null) goto L54;
        String r22 = r6.city;
        if (r22 == null) goto L54;
    L55:
        IHostService r23 = TTLiveSDK.hostService();
        if (r23 == null) goto L63;
        IHostContext r24 = r23.appContext();
        if (r24 == null) goto L63;
        String r25 = r24.getNearbyCityCode();
        if (r25 == null) goto L63;
        String r112 = r25;
    L64:
        String r113 = a0.a();
        String r26 = com.bytedance.android.livesdk.log.c0.a();
        Room r27 = this.i;
        if (r27 == null) goto L67;
        VerticalTypeInfo r28 = r27.mVerticalTypeInfo;
    L68:
        RoomContext r29 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r29 == null) goto L71;
        boolean r210 = r29.isVSSpecialDrawer();
    L72:
        Bundle r30 = this.l;
        if (r30 == null) goto L75;
        Integer r211 = Integer.valueOf(r30.getInt("insert_room_reason"));
    L76:
        Bundle r31 = this.l;
        if (r31 == null) goto L79;
        Long r32 = Long.valueOf(r31.getLong("default_tab_type"));
    L80:
        Bundle r33 = this.l;
        if (r33 == null) goto L84;
        r2 = r33.getString("cover_content_category");
    L84:
        return new e(r7, r8, r9, r10, r11, r13, r14, r16, r17, r18, r110, r111, r22, r112, r113, r26, r28, r210, r211, r32, r2, this.m, this.f);
    L79:
        r32 = null;
        goto L80
    L75:
        r211 = null;
        goto L76
    L71:
        r210 = false;
        goto L72
    L67:
        r28 = null;
    L63:
        r112 = "";
    L54:
        r22 = "";
    L50:
        r111 = "";
        goto L51
    L41:
        if (r15.getNeedPersonalRecommend() == false) goto L43;
        r16 = true;
    L37:
        r13 = "";
        goto L38
    L32:
        r11 = false;
    L29:
        r10 = "drawer_cover";
    L25:
        r9 = "drawer_cover";
    L20:
        r8 = "drawer_null";
    L16:
        r7 = "drawer_null";
    L11:
        r6 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void e() {
        setVisibility(8);
        HybridCard r0 = getMHybridCard();
        if (r0 == null) goto L6;
        r0.hide();
    L6:
        if (this.g == true) goto L8;
        return;
    L8:
        if (this.h == true) goto L12;
        d(false);
        return;
    }

    private final com.bytedance.android.livesdk.drawer.drawerlynx.a getPayLoad() {
        JsonElement r0 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), this.i);
        List r2 = null;
        if ((r0 instanceof JsonObject) == true) goto L5;
        r0 = null;
    L5:
        JsonObject r1 = (JsonObject) r0;
        if (r1 == null) goto L13;
        IHostBusiness r3 = k.f(IHostBusiness.class);
        if (r3 == null) goto L11;
        String r4 = r3.getDesktopParams();
        if (r4 == null) goto L11;
    L12:
        r1.addProperty("launch_method", r4);
        Unit r5 = Unit.INSTANCE;
    L14:
        e r6 = getIContext();
        IHostFeed r7 = k.f(IHostFeed.class);
        if (r7 == null) goto L18;
        r2 = r7.getNewDrawerTabList();
    L18:
        return new com.bytedance.android.livesdk.drawer.drawerlynx.a(r1, r6, r2, 8);
    L11:
        r4 = "others";
        goto L12
    L13:
        r1 = null;
        goto L14
    }

    public final void f() {
        HybridCard r0 = getMHybridCard();
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final Bundle getArguments() {
        return this.l;
    }

    public final Room getRoom() {
        return this.i;
    }

    public final boolean getShouldShowFollow() {
        return this.j;
    }

    public final String getSourceBtmToken() {
        return this.k;
    }

    public static final /* synthetic */ HybridCard a(LiveDrawerLynxCard r0) {
        return r0.getMHybridCard();
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.drawer.drawerlynx.a b(LiveDrawerLynxCard r0) {
        return r0.getPayLoad();
    }

    public static final /* synthetic */ Uri c(LiveDrawerLynxCard r0) {
        return r0.getUri();
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L4;
        xs2.b.a().post(new h1(47));
        return;
    L4:
        xs2.b.a().post(new h1(48));
    }

    public final void setInterceptor(IDrawerFeedAction r2) {
        Intrinsics.checkNotNullParameter(r2, "drawerFeedAction");
        r2.setInterceptor(this.e);
    }

    public final void setRoom(Room r1) {
        this.i = r1;
    }

    public final void setShouldShowFollow(boolean r1) {
        this.j = r1;
    }

    public final void setSmartClientPreload(boolean r1) {
        this.m = r1;
    }

    public final void h(Room r4, boolean r5) {
        this.i = r4;
        this.j = r5;
        HybridCard r6 = getMHybridCard();
        if (r6 == null) goto L12;
        LinkedHashMap r7 = new LinkedHashMap();
        JsonElement r0 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), getPayLoad());
        GsonMap r2 = null;
        if ((r0 instanceof JsonObject) == true) goto L7;
        r0 = null;
    L7:
        JsonObject r1 = (JsonObject) r0;
        if (r1 == null) goto L10;
        r2 = UtilsKt.i(r1);
    L10:
        r7.put("container_payload", r2);
        Unit r3 = Unit.INSTANCE;
        r6.updateData(r7);
        return;
    }

    public final void setMuteStatus(boolean r1, boolean r2) {
        this.g = r1;
        this.h = r1;
        d(r1);
    }

    public LiveDrawerLynxCard(Context r2, Room r3, boolean r4, String r5, Bundle r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "sourceBtmToken");
        super(r2);
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.a = LazyKt.lazy(new LiveDrawerLynxCard$uri$2(this));
        this.b = LazyKt.lazy(new LiveDrawerLynxCard$mHybridCard$2(this, r2));
        this.e = new a(this);
        this.f = System.currentTimeMillis();
        HybridCard r8 = getMHybridCard();
        if (r8 == null) goto L5;
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L5:
        HybridCard r9 = getMHybridCard();
        if (r9 == null) goto L8;
        addView(r9, 0);
    L8:
        HybridCard r10 = getMHybridCard();
        if ((r10 instanceof AnnieXLiveCard) == true) goto L11;
        r10 = null;
    L11:
        AnnieXLiveCard r11 = (AnnieXLiveCard) r10;
        if (r11 == null) goto L15;
        Intrinsics.checkNotNullParameter(m.class, "clazz");
        r11.p.registerWeakHolder(m.class, this);
    L15:
        if (this.m == false) goto L18;
        e();
        this.f = 0;
        return;
    }
}
