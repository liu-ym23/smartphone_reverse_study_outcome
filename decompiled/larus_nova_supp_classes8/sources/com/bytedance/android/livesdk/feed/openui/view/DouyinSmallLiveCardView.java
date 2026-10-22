package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.android.livesdk.widget.LiveCoverOptView;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.ui.ILiveCardView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/DouyinSmallLiveCardView;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/widget/FixedRatioRelativeLayout;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class DouyinSmallLiveCardView extends FixedRatioRelativeLayout implements ILiveCardView {
    public static final /* synthetic */ int i = 0;
    public String b;
    public Room c;
    public String d;
    public String e;
    public LiveCoverOptView f;
    public final CompositeDisposable g;
    public HashMap h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DouyinSmallLiveCardView a;

        public b(DouyinSmallLiveCardView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            DouyinSmallLiveCardView r8 = this.a;
            int r0 = DouyinSmallLiveCardView.i;
            r8.getClass();
            Bundle r1 = new Bundle();
            Room r2 = r8.c;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L5:
            r1.putString("log_pb", r2.getLog_pb());
            Room r3 = r8.c;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L8:
            r1.putString("request_id", r3.getRequestId());
            r1.putString("enter_from_merge", r8.d);
            r1.putString("enter_method", r8.e);
            Room r4 = r8.c;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L11:
            r1.putString("anchor_id", r4.getOwnerUserIdString());
            r1.putString("live.intent.extra.EXTRA_LIVE_FEED_URL_NEW", r8.b);
            Context r5 = r8.getContext();
            Room r6 = r8.c;
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
            Room r10 = r8.c;
            if (r10 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L23:
            r9.putAll(ArgumentsBuilder.buildRoomArgs(r10));
            if (r9.get("live.intent.extra.USER_ID") != null) goto L29;
            Room r11 = r8.c;
            if (r11 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L28:
            r9.putString("live.intent.extra.USER_ID", r11.getOwnerUserIdString());
        L29:
            int r12 = kw1.c.a;
            kw1.c.b(r8.getContext(), r1);
            IHostAction r13 = TTLiveSDK.hostService().action();
            Context r14 = r8.getContext();
            Room r15 = r8.c;
            if (r15 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L32:
            r13.startLive(r14, r15.id, r9);
            return;
        }
    }

    static {
    }

    public DouyinSmallLiveCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DouyinSmallLiveCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.h != null) goto L5;
        this.h = new HashMap();
    L5:
        View r0 = (View) this.h.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this.h.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public final boolean enablePreview() {
        return false;
    }

    public final void onShow() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from_merge", this.d);
        r0.put("enter_method", this.e);
        Room r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        String r2 = r1.getOwnerUserIdString();
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("anchor_id", r2);
        Room r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L11:
        r0.put("room_id", String.valueOf(r4.id));
        r0.put("action_type", "click");
        Room r5 = this.c;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L14:
        String r6 = r5.getRequestId();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("request_id", r6);
        Room r7 = this.c;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L20:
        String r8 = r7.getLog_pb();
        if (r8 == null) goto L24;
        r3 = r8;
    L24:
        r0.put("log_pb", r3);
        Room r9 = this.c;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L27:
        Long r10 = null;
        if (r9 == null) goto L30;
        RoomExtra r11 = r9.getExtra();
    L32:
        if (r11 == null) goto L48;
        Room r12 = this.c;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L36:
        RoomExtra r13 = r12.getExtra();
        if (r13 != null) goto L39;
    L40:
        Room r14 = this.c;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L43:
        RoomExtra r15 = r14.getExtra();
        if (r15 == null) goto L46;
        Long r16 = Long.valueOf(r15.getXiguaUid());
    L47:
        r0.put("xg_uid", String.valueOf(r16));
        goto L48
    L46:
        r16 = null;
        goto L47
    L39:
        if (r13.getXiguaUid() != 0) goto L40;
    L48:
        Room r17 = this.c;
        if (r17 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L51:
        if (r17 != null) goto L53;
    L54:
        Room r18 = this.c;
        if (r18 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L57:
        if (r18 == null) goto L59;
        r10 = Long.valueOf(r18.appId);
    L59:
        r0.put("anchor_aid", String.valueOf(r10.longValue()));
    L60:
        kw1.c.d("livesdk_live_show", r0);
        return;
    L53:
        if (r17.appId == 0) goto L60;
    L30:
        r11 = null;
        goto L32
    }

    public final void startPreview() {
        throw new NotImplementedError(null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g.isDisposed() == true) goto L6;
        this.g.dispose();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void stopPreview(boolean r3) {
        throw new NotImplementedError(null, 1, null);
    }

    public DouyinSmallLiveCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "";
        this.d = "unknown";
        this.e = "drawer_cover";
        CompositeDisposable r5 = new CompositeDisposable();
        this.g = r5;
        View.inflate(getContext(), 2131567840, this);
        this.f = a(2131378272);
        setRatio(1.0f);
        r5.add(xs2.b.a().b(yv1.b.class).subscribe(new com.bytedance.android.livesdk.feed.openui.view.a(this)));
    }

    public final void bindRoom(Room r8, String r9, LiveCoverConfig r10) {
        Intrinsics.checkNotNullParameter(r8, "room");
        this.c = r8;
        if (r9 != null) goto L5;
        r9 = "unknown";
    L5:
        this.d = r9;
        if (r8.getCover() != null) goto L8;
        a(2131365198).setBackground(getContext().getResources().getDrawable(2131250569));
    L9:
        LiveCoverOptView r11 = this.f;
        if (r11 == null) goto L26;
        boolean r1 = true;
        if (r10 == null) goto L14;
        boolean r2 = r10.getEnableOperationLabel();
    L15:
        if (r10 == null) goto L17;
        r1 = r10.getEnableContentLabel();
    L17:
        r11.c(r8);
        if (r1 == false) goto L20;
    L22:
        if (r2 == true) goto L26;
        if (r11.a.getVisibility() != 0) goto L26;
        r11.a.setVisibility(8);
        goto L26
    L20:
        if (r11.b.getVisibility() != 0) goto L22;
        r11.b.setVisibility(8);
        goto L22
    L14:
        r2 = true;
    L26:
        View r12 = findViewById(2131378262);
        if (r12.getVisibility() != 0) goto L33;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L32;
        ((LinearLayout.LayoutParams) r13).bottomMargin = LiveResUtil.dp2Px(4.0f);
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L33:
        ViewGroup.LayoutParams r14 = findViewById(2131378230).getLayoutParams();
        if (r14 == null) goto L58;
        ((LinearLayout.LayoutParams) r14).bottomMargin = 0;
        if ((r10 instanceof mw1.b) == false) goto L55;
        mw1.b r15 = (mw1.b) r10;
        Integer r16 = r15.e;
        if (r16 != null) goto L40;
    L54:
        UtilityKotlinExtentionsKt.z((TextView) a(2131390528), r15.g);
        goto L55
    L40:
        if (r16.intValue() <= 0) goto L54;
        GenericDraweeHierarchy r17 = a(2131365198).getHierarchy();
        if (r17 == null) goto L44;
        RoundingParams r18 = r17.getRoundingParams();
    L45:
        if (r18 == null) goto L47;
        r18.setCornersRadius(r16.intValue());
    L47:
        a(2131365198).getHierarchy().setRoundingParams(r18);
        View r19 = findViewById(2131368165);
        if ((r19.getBackground() instanceof GradientDrawable) == false) goto L54;
        Drawable r20 = r19.getBackground();
        if (r20 == null) goto L53;
        ((GradientDrawable) r20).setCornerRadius(r16.intValue());
        goto L54
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L44:
        r18 = null;
    L55:
        setOnClickListener(new b(this));
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L8:
        ImageLoader.bindImage(a(2131365198), r8.getCover(), 2131250569, a(2131365198).getWidth(), a(2131365198).getHeight(), null);
        goto L9
    }

    public final void bindRoom(String r4, Map<String, String> r5, LiveCoverConfig r6) {
        Intrinsics.checkNotNullParameter(r4, "roomJson");
        Intrinsics.checkNotNullParameter(r5, "params");
        Room r7 = (Room) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), r4, Room.class);
        String r0 = r5.get("key_enter_from_merge");
        if (r0 != null) goto L5;
        r0 = "unknown";
    L5:
        String r1 = r5.get("key_request_id");
        String r8 = r5.get("key_log_pb");
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r7.setRequestId(r1);
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r7.setLog_pb(r8);
        bindRoom(r7, r0, r6);
    }

    public /* synthetic */ DouyinSmallLiveCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
