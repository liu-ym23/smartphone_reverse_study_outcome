package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.ui.ILiveCardView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/HSLargeLiveCardView;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/widget/FixedRatioRelativeLayout;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView;", "Lmw1/a;", "g", "Lkotlin/Lazy;", "getPreviewView", "()Lmw1/a;", "previewView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class HSLargeLiveCardView extends FixedRatioRelativeLayout implements ILiveCardView {
    public static final /* synthetic */ int m = 0;
    public final String b;
    public int c;
    public int d;
    public Room e;
    public z0 f;
    public final Lazy g;
    public final boolean h;
    public String i;
    public boolean j;
    public long k;
    public HashMap l;

    public static final class a {
    }

    public static final class b extends q0 {
        public final /* synthetic */ HSLargeLiveCardView a;

        public final void f(k r1, Exception r2) {
        }

        public final void g(k r1) {
        }

        public b(HSLargeLiveCardView r1) {
            this.a = r1;
        }

        public final void h(k r2, int r3, int r4) {
            ViewGroup.LayoutParams r5 = this.a.a(2131365210).getLayoutParams();
            r5.width = (int) (r5.height * (r3 / r4));
            this.a.a(2131365210).setLayoutParams(r5);
        }
    }

    public static final class c extends q0 {
        public final /* synthetic */ HSLargeLiveCardView a;

        public final void f(k r1, Exception r2) {
        }

        public final void g(k r1) {
        }

        public c(HSLargeLiveCardView r1) {
            this.a = r1;
        }

        public final void h(k r2, int r3, int r4) {
            ViewGroup.LayoutParams r5 = this.a.a(2131365209).getLayoutParams();
            r5.width = (int) (r5.height * (r3 / r4));
            this.a.a(2131365209).setLayoutParams(r5);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ HSLargeLiveCardView a;

        public d(HSLargeLiveCardView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            HSLargeLiveCardView r8 = this.a;
            int r0 = HSLargeLiveCardView.m;
            r8.getClass();
            Bundle r1 = new Bundle();
            Room r2 = r8.e;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L5:
            r1.putString("log_pb", r2.getLog_pb());
            Room r3 = r8.e;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L8:
            r1.putString("request_id", r3.getRequestId());
            r1.putString("enter_from_merge", r8.i);
            r1.putString("enter_method", "live_window");
            Room r4 = r8.e;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L11:
            r1.putString("anchor_id", r4.getOwnerUserIdString());
            r1.putString("live.intent.extra.EXTRA_LIVE_FEED_URL_NEW", r8.b);
            Context r5 = r8.getContext();
            Room r6 = r8.e;
            if (r6 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L14:
            Bundle r9 = LiveRoomIntentBuilder.buildBundle(r5, r6, "homepage_hot", r1);
            if (r9 != null) goto L17;
            return;
        L17:
            if (TTLiveSDK.hostService() != null) goto L19;
            return;
        L19:
            if (TTLiveSDK.hostService().action() == null) goto L36;
            Room r10 = r8.e;
            if (r10 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L23:
            r9.putAll(ArgumentsBuilder.buildRoomArgs(r10));
            if (r9.get("live.intent.extra.USER_ID") != null) goto L29;
            Room r11 = r8.e;
            if (r11 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L28:
            r9.putString("live.intent.extra.USER_ID", r11.getOwnerUserIdString());
        L29:
            int r12 = kw1.c.a;
            kw1.c.b(r8.getContext(), r1);
            IHostAction r13 = TTLiveSDK.hostService().action();
            Context r14 = r8.getContext();
            Room r15 = r8.e;
            if (r15 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L32:
            r13.startLive(r14, r15.id, r9);
            return;
        }
    }

    public static final class e implements mw1.f {
        public final /* synthetic */ HSLargeLiveCardView a;

        public e(HSLargeLiveCardView r1) {
            this.a = r1;
        }

        @Override // mw1.f
        public final void b(boolean r11) {
            if (r11 == false) goto L4;
            this.a.k = System.currentTimeMillis();
            return;
        L4:
            HSLargeLiveCardView r12 = this.a;
            if (r12.k <= 0) goto L54;
            long r0 = System.currentTimeMillis() - r12.k;
            Pair[] r5 = new Pair[8];
            r5[0] = TuplesKt.to("enter_from_merge", r12.i);
            r5[1] = TuplesKt.to("enter_method", "live_window");
            Room r6 = r12.e;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L10:
            r5[2] = TuplesKt.to("anchor_id", r6.getOwnerUserIdString());
            Room r7 = r12.e;
            if (r7 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L13:
            r5[3] = TuplesKt.to("room_id", String.valueOf(r7.id));
            Room r8 = r12.e;
            if (r8 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L16:
            r5[4] = TuplesKt.to("request_id", r8.getRequestId());
            Room r9 = r12.e;
            if (r9 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L19:
            r5[5] = TuplesKt.to("log_pb", r9.getLog_pb());
            r5[6] = TuplesKt.to("action_type", "click");
            r5[7] = TuplesKt.to("duration", String.valueOf(r0));
            Map r1 = MapsKt.mutableMapOf(r5);
            Room r2 = r12.e;
            if (r2 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L22:
            Long r10 = null;
            if (r2 == null) goto L25;
            RoomExtra r3 = r2.getExtra();
        L26:
            if (r3 == null) goto L42;
            Room r4 = r12.e;
            if (r4 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L30:
            if (r4 == null) goto L35;
            RoomExtra r13 = r4.getExtra();
            if (r13 == null) goto L35;
            if (r13.getXiguaUid() == 0) goto L42;
        L35:
            Room r14 = r12.e;
            if (r14 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L38:
            RoomExtra r15 = r14.getExtra();
            if (r15 == null) goto L41;
            r10 = Long.valueOf(r15.getXiguaUid());
        L41:
            r1.put("xg_uid", String.valueOf(r10));
        L42:
            Room r16 = r12.e;
            if (r16 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L45:
            if (r16 != null) goto L47;
        L48:
            Room r17 = r12.e;
            if (r17 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L51:
            r1.put("anchor_aid", String.valueOf(r17.appId));
        L52:
            kw1.c.d("livesdk_live_window_duration_v2", r1);
            goto L54
        L47:
            if (r16.appId == 0) goto L52;
        L25:
            r3 = null;
        L54:
            if (((FrameLayout) this.a.a(2131387768)).getVisibility() != 0) goto L58;
            ((FrameLayout) this.a.a(2131387768)).setVisibility(8);
            return;
        }

        @Override // mw1.f
        public final void a(int r5, int r6) {
            ViewGroup.LayoutParams r0 = ((FrameLayout) this.a.a(2131387768)).getLayoutParams();
            if (r0 == null) goto L10;
            if (r5 <= r6) goto L7;
            int r2 = (int) (this.a.d * 0.8f);
            r0.width = r2;
            r0.height = (int) (((r2 * 1.0f) * r6) / r5);
            return;
        L7:
            int r3 = (int) (this.a.d * 0.8f);
            r0.height = r3;
            r0.width = (int) (((r3 * 1.0f) * r5) / r6);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    static {
    }

    public HSLargeLiveCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HSLargeLiveCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final mw1.a getPreviewView() {
        return (mw1.a) this.g.getValue();
    }

    public final View a(int r3) {
        if (this.l != null) goto L5;
        this.l = new HashMap();
    L5:
        View r0 = (View) this.l.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this.l.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public final boolean enablePreview() {
        return true;
    }

    public final void onShow() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from_merge", this.i);
        r0.put("enter_method", "live_window");
        Room r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        String r2 = r1.getOwnerUserIdString();
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("anchor_id", r2);
        Room r4 = this.e;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L11:
        r0.put("room_id", String.valueOf(r4.id));
        r0.put("action_type", "click");
        Room r5 = this.e;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L14:
        String r6 = r5.getRequestId();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("request_id", r6);
        Room r7 = this.e;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L20:
        String r8 = r7.getLog_pb();
        if (r8 == null) goto L24;
        r3 = r8;
    L24:
        r0.put("log_pb", r3);
        Room r9 = this.e;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L27:
        Long r10 = null;
        if (r9 == null) goto L30;
        RoomExtra r11 = r9.getExtra();
    L32:
        if (r11 == null) goto L50;
        Room r12 = this.e;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L36:
        if (r12 == null) goto L41;
        RoomExtra r13 = r12.getExtra();
        if (r13 == null) goto L41;
        if (r13.getXiguaUid() == 0) goto L50;
    L41:
        Room r14 = this.e;
        if (r14 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L44:
        if (r14 == null) goto L48;
        RoomExtra r15 = r14.getExtra();
        if (r15 == null) goto L48;
        Long r16 = Long.valueOf(r15.getXiguaUid());
    L49:
        r0.put("xg_uid", String.valueOf(r16));
    L48:
        r16 = null;
    L50:
        Room r17 = this.e;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L53:
        if (r17 != null) goto L55;
    L56:
        Room r18 = this.e;
        if (r18 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L59:
        if (r18 == null) goto L61;
        r10 = Long.valueOf(r18.appId);
    L61:
        r0.put("anchor_aid", String.valueOf(r10.longValue()));
    L62:
        kw1.c.d("livesdk_live_show", r0);
        return;
    L55:
        if (r17.appId == 0) goto L62;
    L30:
        r11 = null;
        goto L32
    }

    public final void startPreview() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        mw1.a r1 = getPreviewView();
        if (r1 == null) goto L17;
        Room r2 = this.e;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L10:
        long r4 = r2.id;
        Room r3 = this.e;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L13:
        String r5 = r3.getOwnerUserIdString();
        Room r6 = this.e;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L16:
        r1.a(r5, r6, new e(this));
    L17:
        UtilityKotlinExtentionsKt.z((FrameLayout) a(2131387768), true);
        ((FrameLayout) a(2131387768)).removeAllViews();
        FrameLayout r0 = (FrameLayout) a(2131387768);
        Object r7 = getPreviewView();
        if (r7 == null) goto L24;
        r0.addView((View) r7);
        mw1.a r8 = getPreviewView();
        if (r8 == null) goto L25;
        r8.startPreview();
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public final void stopPreview(boolean r3) {
        if (this.j == true) goto L5;
        return;
    L5:
        this.j = false;
        UtilityKotlinExtentionsKt.z((FrameLayout) a(2131387768), false);
        mw1.a r0 = getPreviewView();
        if (r0 == null) goto L9;
        r0.stopPreview(r3);
        return;
    }

    public HSLargeLiveCardView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "";
        this.c = -1;
        this.d = -1;
        this.g = LazyKt.lazy(new HSLargeLiveCardView$previewView$2(r2));
        this.h = true;
        this.i = "unknown";
        View.inflate(getContext(), 2131567737, this);
        if (this.c > 0) goto L5;
        this.c = UIUtils.getScreenWidth(getContext());
    L5:
        this.d = this.c;
        HSImageView r5 = a(2131365198);
        int r6 = this.c;
        r5.setLayoutParams(new RelativeLayout.LayoutParams(r6, r6));
        ViewGroup.LayoutParams r7 = ((RelativeLayout) a(2131367728)).getLayoutParams();
        r7.height = this.d;
        ViewGroup.LayoutParams r8 = a(2131365168).getLayoutParams();
        r8.height = this.d / 2;
        setRatio(1.0f);
    }

    public final void bindRoom(Room r7, String r8, LiveCoverConfig r9) {
        Intrinsics.checkNotNullParameter(r7, "room");
        this.e = r7;
        if (r8 != null) goto L5;
        r8 = "unknown";
    L5:
        this.i = r8;
        k r10 = r7.getCover();
        if (r10 == null) goto L19;
        List r11 = r10.getUrls();
        if (r11 == null) goto L19;
        if ((!r11.isEmpty()) != true) goto L19;
        ImageModel r12 = r7.getCover();
        if (r12 == null) goto L18;
        ImageModel r13 = r12;
        Intrinsics.checkNotNull(r13);
        long[] r3 = new long[1];
        if (this.f != null) goto L16;
        this.f = new z0();
    L16:
        ImageLoader.d r14 = ImageLoader.load(r13);
        r14.g = true;
        r14.f = false;
        r14.e = new com.bytedance.android.livesdk.feed.openui.view.b(this, r3, r7);
        r14.a(a(2131365198));
    L21:
        if (r7.getOperationLabel() == null) goto L26;
        if (r9 != null) goto L24;
    L25:
        a(2131365210).setVisibility(0);
        ImageLoader.d r15 = ImageLoader.load(r7.getOperationLabel());
        r15.e = new b(this);
        r15.a(a(2131365210));
    L28:
        if (r7.getContentLabel() == null) goto L33;
        if (r9 != null) goto L31;
    L32:
        UIUtils.setViewVisibility(a(2131365209), 0);
        ImageLoader.d r16 = ImageLoader.load(r7.getContentLabel());
        r16.e = new c(this);
        r16.a(a(2131365209));
    L35:
        if ((r9 instanceof mw1.b) == false) goto L37;
        UtilityKotlinExtentionsKt.z((TextView) a(2131390528), ((mw1.b) r9).g);
    L37:
        User r17 = r7.getOwner();
        String r18 = null;
        if (r17 == null) goto L40;
        String r19 = r17.getCity();
    L42:
        if (StringUtils.isEmpty(r19) == false) goto L44;
        UtilityKotlinExtentionsKt.z((TextView) a(2131365201), false);
        UtilityKotlinExtentionsKt.z((ImageView) a(2131365183), false);
    L46:
        if (r7.isMediaRoom() == false) goto L52;
        TextView r20 = (TextView) a(2131365218);
        User r0 = r7.getOwner();
        if (r0 == null) goto L50;
        r18 = r0.getRealNickName();
    L50:
        r20.setText(r18);
        UtilityKotlinExtentionsKt.z((ImageView) a(2131365183), false);
        UtilityKotlinExtentionsKt.z((TextView) a(2131365201), false);
    L59:
        if (r7.getStatus() != 4) goto L61;
        a(2131365157).setVisibility(4);
    L63:
        if (this.h == false) goto L66;
        setOnClickListener(new d(this));
        return;
    L66:
        return;
    L61:
        a(2131365157).setVisibility(0);
        a(2131365157).setText(p1.b(r7));
        goto L63
    L52:
        if (TextUtils.isEmpty(r7.getTitle()) == false) goto L57;
        TextView r21 = (TextView) a(2131365218);
        User r1 = r7.getOwner();
        if (r1 == null) goto L56;
        r18 = r1.getRealNickName();
    L56:
        r21.setText(r18);
        goto L59
    L57:
        ((TextView) a(2131365218)).setText(r7.getTitle());
        goto L59
    L44:
        ((TextView) a(2131365201)).setText(r19);
        UtilityKotlinExtentionsKt.z((ImageView) a(2131365183), true);
        UtilityKotlinExtentionsKt.z((TextView) a(2131365201), true);
        goto L46
    L40:
        r19 = null;
        goto L42
    L31:
        if (r9.getEnableContentLabel() == true) goto L32;
    L33:
        UIUtils.setViewVisibility(a(2131365209), 8);
        goto L35
    L24:
        if (r9.getEnableOperationLabel() == true) goto L25;
    L26:
        a(2131365210).setVisibility(8);
        goto L28
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.ImageModel");
    L19:
        a(2131365198).setImageResource(2131250569);
        goto L21
    }

    public final void bindRoom(String r4, Map<String, String> r5, LiveCoverConfig r6) {
        Intrinsics.checkNotNullParameter(r4, "roomJson");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.e = (Room) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), r4, Room.class);
        String r7 = r5.get("key_enter_from_merge");
        if (r7 != null) goto L5;
        r7 = "unknown";
    L5:
        this.i = r7;
        String r8 = r5.get("key_request_id");
        String r9 = r5.get("key_log_pb");
        Room r0 = this.e;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L9:
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r0.setRequestId(r8);
        Room r10 = this.e;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L14:
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        r10.setLog_pb(r9);
        Room r11 = this.e;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L19:
        bindRoom(r11, this.i, r6);
    }

    public /* synthetic */ HSLargeLiveCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
