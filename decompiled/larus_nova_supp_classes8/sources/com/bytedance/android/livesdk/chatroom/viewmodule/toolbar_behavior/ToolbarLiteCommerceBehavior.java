package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.commerce.ECLiteEntranceApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.shopping.LiveShoppingMessageHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.common.applog.AppLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarLiteCommerceBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarLiteCommerceBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {
    public static final /* synthetic */ int g = 0;
    public View a;
    public Room b;
    public vlc.d c;
    public DataCenter d;
    public View e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarLiteCommerceBehavior() {
        this.f = LazyKt.lazy(new ToolbarLiteCommerceBehavior$logParams$2(this));
    }

    public final void a(Context r7) {
        HashMap r0 = new HashMap();
        r0.put("user_id", TTLiveSDKContext.getHostService().h().n());
        r0.put("device_id", AppLog.v());
        Room r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.id);
    L6:
        r0.put("room_id", String.valueOf(r3));
        Room r4 = this.b;
        if (r4 == null) goto L9;
        r2 = r4.getOwnerUserIdString();
    L9:
        r0.put("author_id", String.valueOf(r2));
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        TTLiveSDKContext.getHostService().f().logV3("ecom_lite_transfer", r0);
        Room r5 = this.b;
        if (r5 == null) goto L12;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_entrance_click", (Map) this.f.getValue(), new Object[0]);
        IHostAction r6 = TTLiveSDKContext.getHostService().a();
        Bundle r8 = new Bundle();
        r8.putLong("com.ss.android.ugc.live.intent.extra.ROOM_ID", r5.id);
        com.bytedance.android.live.base.model.user.o0.a r9 = com.bytedance.android.live.base.model.user.o0.a;
        r5.getOwnerUserIdString();
        r9.getClass();
        r8.putLong("com.ss.android.ugc.live.intent.extra.USER_ID", 0);
        r8.putBoolean("com.ss.android.ugc.live.intent.extra.OPEN_DOUYIN", true);
        r8.putString("live.intent.extra.ENTER_FROM_MERGE", "dy_lite_app");
        r8.putString("live.intent.extra.ENTER_ENTER_METHOD", "live_tag_cart");
        Unit r10 = Unit.INSTANCE;
        r6.handleSchema(r7, "//live/detail", r8);
    L12:
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.L1;
        Boolean r12 = Boolean.TRUE;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r12);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void b(boolean r3) {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.d);
        ExtendedToolbarButton r1 = ToolbarButton.COMMERCE.extended();
        if (r3 == false) goto L5;
        r0.c(r1);
        return;
    L5:
        r0.i(r1);
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (r10 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10.getKey(), "CMD_DOUYIN_LITE_COMMERCE_READY") == true) goto L7;
    L13:
        boolean r0 = false;
    L14:
        View r3 = null;
        r3 = null;
        if (r0 == true) goto L18;
        r10 = null;
    L18:
        if (r10 == null) goto L112;
        kg1.a r11 = (kg1.a) r10.getData();
        if (r11 != null) goto L22;
    L30:
        if (r11 != null) goto L32;
    L109:
        b(false);
        return;
    L32:
        if (r11.b != true) goto L109;
        View r12 = this.a;
        if ((r12 instanceof ViewGroup) == true) goto L36;
        r12 = null;
    L36:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L71;
        DataCenter r1 = this.d;
        if (r1 == null) goto L45;
        Boolean r6 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
        LiveMode r7 = LiveMode.VIDEO;
        LiveMode r2 = (LiveMode) r1.get("data_live_mode", r7);
        if (r6.booleanValue() == false) goto L45;
        if (r2 != r7) goto L45;
        boolean r4 = true;
    L46:
        if (r4 == true) goto L68;
        DataCenter r5 = this.d;
        if (r5 == null) goto L55;
        Boolean r8 = (Boolean) r5.get("data_is_anchor", Boolean.FALSE);
        LiveMode r14 = (LiveMode) r5.get("data_live_mode", LiveMode.VIDEO);
        if (r8.booleanValue() == false) goto L55;
        if (r14 != LiveMode.AUDIO) goto L55;
        boolean r15 = true;
    L56:
        if (r15 == true) goto L68;
        DataCenter r16 = this.d;
        if (r16 == null) goto L65;
        Boolean r17 = (Boolean) r16.get("data_is_anchor", Boolean.FALSE);
        LiveMode r18 = (LiveMode) r16.get("data_live_mode", LiveMode.VIDEO);
        if (r17.booleanValue() == false) goto L65;
        if (r18 != LiveMode.SCREEN_RECORD) goto L65;
        boolean r19 = true;
    L66:
        if (r19 == true) goto L68;
        boolean r20 = true;
    L69:
        if (r20 == false) goto L71;
    L72:
        if (r13 == null) goto L100;
        Context r21 = r13.getContext();
        if (r21 == null) goto L100;
        Resources r22 = r21.getResources();
        if (r22 == null) goto L100;
        Configuration r23 = r22.getConfiguration();
        if (r23 == null) goto L100;
        if (r23.orientation != 2) goto L100;
        View r24 = this.a;
        if ((r24 instanceof ViewGroup) == true) goto L84;
        r24 = null;
    L84:
        ViewGroup r25 = (ViewGroup) r24;
        if (r25 == null) goto L87;
        int r26 = r25.getChildCount();
    L88:
        if (r26 < 1) goto L100;
        View r27 = this.a;
        if ((r27 instanceof ViewGroup) == true) goto L92;
        r27 = null;
    L92:
        ViewGroup r28 = (ViewGroup) r27;
        if (r28 == null) goto L95;
        View r29 = r28.getChildAt(0);
    L97:
        if ((r29 instanceof ViewGroup) == true) goto L99;
        r29 = null;
    L99:
        r13 = (ViewGroup) r29;
        goto L100
    L95:
        r29 = null;
        goto L97
    L87:
        r26 = 0;
    L100:
        if (r13 == null) goto L108;
        View r30 = this.a;
        if (r30 == null) goto L106;
        Context r31 = r30.getContext();
        if (r31 == null) goto L106;
        RelativeLayout r32 = new RelativeLayout(r31);
        ViewGroup.LayoutParams r33 = new ViewGroup.LayoutParams(-1, -1);
        Unit r34 = Unit.INSTANCE;
        r32.setLayoutParams(r33);
        ImageView r35 = new ImageView(r31);
        RelativeLayout.LayoutParams r36 = new RelativeLayout.LayoutParams((int) t6.a(r31, 36.0f), (int) t6.a(r31, 36.0f));
        r36.addRule(13);
        r35.setLayoutParams(r36);
        Intrinsics.checkNotNullParameter(r31, "context");
        r35.setBackgroundResource(2131252990);
        r32.addView(r35);
        r32.setOnClickListener(this);
        r3 = r32;
    L106:
        if (r3 == null) goto L108;
        this.e = r3;
        r13.addView(r3);
    L108:
        b(true);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_entrance_show", (Map) this.f.getValue(), new Object[0]);
        return;
    L65:
        r19 = false;
    L55:
        r15 = false;
    L68:
        r20 = false;
    L45:
        r4 = false;
    L71:
        r13 = null;
        goto L72
    L22:
        if (r11.a != true) goto L30;
        DataCenter r37 = this.d;
        if (r37 == null) goto L26;
        vlc.d r38 = (vlc.d) r37.get("data_message_manager");
    L27:
        this.c = r38;
        if (r38 == null) goto L30;
        r38.addMessageListener(BubbleId.Share, this);
        goto L30
    L26:
        r38 = null;
        goto L27
    L112:
        return;
    L7:
        if (this.b == null) goto L13;
        if ((this.a instanceof ViewGroup) == false) goto L13;
        if ((r10.getData() instanceof kg1.a) == false) goto L13;
        r0 = true;
        goto L14
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (r6 == null) goto L18;
        Integer r0 = Integer.valueOf(r6.getId());
        r0.intValue();
        if (Intrinsics.areEqual(this.e, r6) == true) goto L7;
        r0 = null;
    L7:
        if (r0 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.utils.f1.a(r0.intValue()) == true) goto L20;
        Context r7 = r6.getContext();
        if (puc.a.isInstalledApp(r7, "com.ss.android.ugc.aweme") == true) goto L13;
        com.bytedance.android.livesdk.widget.x0.b r1 = new com.bytedance.android.livesdk.widget.x0.b(r7, 4);
        r1.l(2131915898);
        r1.i(0, 2131921977, new q3(r7));
        r1.i(1, 2131915442, r3.a);
        r1.n();
        return;
    L13:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.L1.getValue()).booleanValue() == false) goto L15;
        a(r7);
        return;
    L15:
        com.bytedance.android.livesdk.widget.x0.b r2 = new com.bytedance.android.livesdk.widget.x0.b(r7, 4);
        r2.l(2131915899);
        r2.i(0, 2131915914, new o3(this, r7));
        r2.i(1, 2131915442, p3.a);
        r2.n();
        return;
    L20:
        return;
    }

    public final void onMessage(tlc.d r5) {
        String r0 = kg1.d.a;
        if (r5 == null) goto L59;
        boolean r2 = false;
        boolean r3 = true;
        if (r5.getIntType() != 1002) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        tlc.d r4 = r5;
    L11:
        if (r4 == null) goto L60;
        Integer r6 = LiveShoppingMessageHelper.INSTANCE.getMessageType(r5);
        if (r6 != null) goto L16;
    L18:
        if (r6 == null) goto L24;
        if (r6.intValue() != 14) goto L24;
        kg1.d.j = false;
        return;
    L24:
        if (r6 != null) goto L27;
    L29:
        if (r6 == null) goto L42;
        if (r6.intValue() != 10) goto L42;
    L33:
        if (r6 != null) goto L36;
    L37:
        r2 = true;
    L39:
        if (kg1.d.j == false) goto L63;
        kg1.d.a(true, r2);
        return;
    L63:
        return;
    L36:
        if (r6.intValue() == 10) goto L39;
    L42:
        if (r6 != null) goto L45;
    L47:
        if (r6 != null) goto L50;
        return;
    L50:
        if (r6.intValue() != 11) goto L65;
    L51:
        if (r6 != null) goto L54;
    L57:
        kg1.d.a(false, r3);
        return;
    L54:
        if (r6.intValue() != 11) goto L57;
        r3 = false;
        goto L57
    L65:
        return;
    L45:
        if (r6.intValue() != 1) goto L47;
    L27:
        if (r6.intValue() != 0) goto L29;
    L16:
        if (r6.intValue() != 13) goto L18;
        kg1.d.j = true;
        return;
    L60:
        return;
    L10:
        r4 = null;
        goto L11
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.c;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        r3.removeObserver(this);
        Disposable r5 = kg1.d.i;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        kg1.d.i = null;
        this.b = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.a = r4;
        boolean r6 = false;
        b(false);
        this.b = (Room) r5.get("data_room", null);
        this.d = r5;
        r5.observeForever("CMD_DOUYIN_LITE_COMMERCE_READY", this);
        String r7 = kg1.d.a;
        kg1.d.h = new WeakReference(this.d);
        if (kg1.d.g == false) goto L5;
        return;
    L5:
        if (kg1.d.f == true) goto L7;
        return;
    L7:
        if (kg1.d.e == false) goto L27;
        HashMap r8 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("first_enter", "true"), TuplesKt.to("entrance_info", "live_list_card")});
        String r0 = kg1.d.a;
        if (r0 == null) goto L11;
        r8.put("author_id", r0);
    L11:
        String r1 = kg1.d.b;
        if (r1 == null) goto L14;
        r8.put("sec_author_id", r1);
    L14:
        String r2 = kg1.d.c;
        if (r2 == null) goto L17;
        r8.put("room_id", r2);
    L17:
        IRoomCart r3 = kg1.d.d;
        if (r3 != null) goto L20;
        kg1.d.i = ((ECLiteEntranceApi) com.bytedance.android.live.network.c.b().e(ECLiteEntranceApi.class)).fetchPromotions(r8).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(kg1.b.a, kg1.c.a);
        return;
    L20:
        if (r3.getShowCartExt() != 1) goto L22;
        r6 = true;
    L22:
        kg1.d.a(r6, true);
        return;
    }
}
