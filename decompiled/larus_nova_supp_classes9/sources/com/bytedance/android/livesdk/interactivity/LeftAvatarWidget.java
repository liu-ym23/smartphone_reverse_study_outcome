package com.bytedance.android.livesdk.interactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BorderInfo;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/LeftAvatarWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LeftAvatarWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int n = 0;
    public HSImageView a;
    public ImageView b;
    public FrameLayout c;
    public ImageView d;
    public TextView e;
    public CompositeDisposable f;
    public yo2.e g;
    public final LinkedList<pp1.c> h;
    public boolean i;
    public IUser j;
    public final int k;
    public final int l;
    public final int m;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567739;
    }

    public final void Aq() {
        yo2.e r0 = this.g;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.g = null;
    }

    public final void onUnload() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        CompositeDisposable r1 = this.f;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        this.f = null;
        this.h.clear();
        this.i = false;
        Aq();
    }

    public final void zq() {
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.g != null) goto L34;
        FrameLayout r0 = this.c;
        if (r0 != null) goto L9;
    L11:
        pp1.c r13 = this.h.poll();
        if (r13 != null) goto L14;
        return;
    L14:
        this.i = true;
        FrameLayout r2 = this.c;
        if (r2 == null) goto L35;
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r2.getParent() != null) goto L19;
    L23:
        boolean r1 = false;
    L24:
        if (r1 == true) goto L26;
        this.i = false;
        Aq();
        zq();
        return;
    L26:
        long r10 = r13.e;
        View r9 = LayoutInflater.from(((Widget) this).context).inflate(2131567740, null);
        TextView r15 = (TextView) r9.findViewById(2131364937);
        ImageView r7 = (ImageView) r9.findViewById(2131364888);
        View r8 = r9.findViewById(2131374737);
        final Ref.IntRef r6 = new Ref.IntRef();
        r6.element = 0;
        final Ref.IntRef r5 = new Ref.IntRef();
        r5.element = 0;
        final LeftAvatarWidget$showBubble$onBackgroundReady$1 r4 = new LeftAvatarWidget$showBubble$onBackgroundReady$1(this, r2, r15, r6, r5, r13, r7, r8, r9, r10);
        Function0<Unit> r3 = new LeftAvatarWidget$showBubble$useDefaultBackground$1(this, r6, r5, r4);
        py.k r11 = r13.f;
        if (r11 != null) goto L29;
    L31:
        r3.invoke();
        return;
    L29:
        if (r11.isValid() != true) goto L31;
        int r14 = a3.d;
        a3.a.a(r15, r13.f, new o(r4, r3), 0.0f);
        return;
    L19:
        if (r2.getApplicationWindowToken() == null) goto L23;
        if (r2.getVisibility() != 0) goto L23;
        r1 = true;
        goto L24
    L35:
        return;
    L9:
        if (r0.getVisibility() != 8) goto L11;
        return;
    }

    public LeftAvatarWidget() {
        this.h = new LinkedList();
        this.k = ((Integer) w1.a.getValue()).intValue();
        this.l = 1;
        this.m = 2;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        py.k r0 = null;
        if (r10 == null) goto L5;
        String r11 = r10.getKey();
    L6:
        if (r11 == null) goto L137;
        int r1 = r11.hashCode();
        if (r1 == (-1755684509)) goto L120;
        if (r1 == (-1741164106)) goto L14;
        return;
    L14:
        if (r11.equals("data_user_in_room") == false) goto L131;
        IRoom r13 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r13 != null) goto L19;
        return;
    L19:
        if (r13.allowGift() == true) goto L21;
        yq(false);
        return;
    L21:
        IUser r14 = (IUser) ((Widget) this).dataCenter.get("data_user_in_room", null);
        this.j = r14;
        if (r14 == null) goto L118;
        com.bytedance.android.live.base.model.user.e r15 = r14.getBottomEntry();
        if (r15 == null) goto L118;
        if (r15.getStatus() == 1) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r2 == true) goto L34;
        r15 = null;
    L34:
        if (r15 == null) goto L118;
        int r3 = this.k;
        if (r3 != this.l) goto L58;
        ImageView r4 = this.d;
        if (r4 == null) goto L40;
        r4.setVisibility(8);
    L40:
        TextView r5 = this.e;
        if (r5 == null) goto L43;
        r5.setVisibility(8);
    L43:
        ImageView r6 = this.b;
        if (r6 == null) goto L46;
        r6.setVisibility(8);
    L46:
        HSImageView r7 = this.a;
        if (r7 == null) goto L51;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L51;
        r8.width = com.bytedance.android.anniex.utils.j.a(38);
        r8.height = com.bytedance.android.anniex.utils.j.a(38);
    L51:
        String r16 = r15.getIcon();
        if (r16 == null) goto L54;
        a1.n(this.a, r16);
    L54:
        Bq("show", r15, "medal");
        FrameLayout r17 = this.c;
        if (r17 == null) goto L116;
        r17.setOnClickListener(new n(this, r15));
    L116:
        yq(true);
        return;
    L58:
        if (r3 != this.m) goto L117;
        IUser r18 = this.j;
        if (r18 == null) goto L62;
        py.f r19 = r18.getBorder();
    L64:
        if ((r19 instanceof BorderInfo) == true) goto L66;
        r19 = null;
    L66:
        BorderInfo r20 = (BorderInfo) r19;
        IUser r21 = this.j;
        if (r21 == null) goto L72;
        py.k r23 = r21.getAvatarThumb();
        if (r23 == null) goto L72;
        ImageUtil.loadRoundImage(this.a, r23);
    L72:
        if (r15.getMysteryMan() == false) goto L93;
        ImageView r24 = this.d;
        if (r24 == null) goto L76;
        r24.setVisibility(8);
    L76:
        TextView r25 = this.e;
        if (r25 == null) goto L79;
        r25.setVisibility(8);
    L79:
        if (r20 == null) goto L90;
        py.k r26 = r20.getDefaultIcon();
        if (r26 == null) goto L90;
        if ((!UtilityKotlinExtentionsKt.n(r26)) == false) goto L85;
        r0 = r26;
    L85:
        if (r0 == null) goto L90;
        ImageView r27 = this.b;
        if (r27 == null) goto L89;
        r27.setVisibility(0);
    L89:
        ImageUtil.loadRoundImage(this.b, r0);
    L103:
        if (r15.getHideGradeLevel() == false) goto L110;
        TextView r28 = this.e;
        if (r28 == null) goto L107;
        r28.setText("**");
    L107:
        TextView r29 = this.e;
        if (r29 == null) goto L113;
        r29.setTextSize(11.0f);
    L113:
        Bq("show", r15, "number");
        FrameLayout r30 = this.c;
        if (r30 == null) goto L116;
        r30.setOnClickListener(new m(this, r15));
        goto L116
    L110:
        TextView r31 = this.e;
        if (r31 == null) goto L113;
        r31.setText(String.valueOf(r15.getGradeLevel()));
    L90:
        ImageView r33 = this.b;
        if (r33 == null) goto L103;
        r33.setVisibility(8);
        goto L103
    L93:
        ImageView r34 = this.d;
        if (r34 == null) goto L96;
        r34.setVisibility(0);
    L96:
        TextView r35 = this.e;
        if (r35 == null) goto L99;
        r35.setVisibility(0);
    L99:
        ImageView r36 = this.b;
        if (r36 == null) goto L103;
        r36.setVisibility(8);
        goto L103
    L62:
        r19 = null;
        goto L64
    L117:
        yq(false);
        return;
    L28:
        if (this.k <= 0) goto L30;
        r2 = true;
    L118:
        yq(false);
        return;
    L131:
        return;
    L120:
        if (r11.equals("cmd_toolbar_left_avatar_bubble") == false) goto L136;
        FrameLayout r37 = this.c;
        if (r37 != null) goto L124;
    L126:
        pp1.c r38 = (pp1.c) ((Widget) this).dataCenter.get("cmd_toolbar_left_avatar_bubble", null);
        if (r38 == null) goto L141;
        this.h.offer(r38);
        zq();
        return;
    L141:
        return;
    L124:
        if (r37.getVisibility() != 8) goto L126;
        return;
    L136:
        return;
    L137:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void onInit(Object[] r4) {
        this.a = ((Widget) this).contentView.findViewById(2131363667);
        this.b = (ImageView) ((Widget) this).contentView.findViewById(2131363646);
        this.c = (FrameLayout) ((Widget) this).contentView.findViewById(2131377719);
        this.d = (ImageView) ((Widget) this).contentView.findViewById(2131363654);
        this.e = (TextView) ((Widget) this).contentView.findViewById(2131373880);
        if (PadConfigUtils.c() == false) goto L6;
        int r5 = s1.j(2131168967);
        int r0 = s1.j(2131168966);
        UIUtils.updateLayoutMargin(((Widget) this).contentView, r5, -3, r0, r5);
        return;
    }

    public final void onLoad(Object[] r3) {
        this.f = new CompositeDisposable();
        DataCenter r4 = ((Widget) this).dataCenter;
        IRoom r0 = null;
        if (r4 == null) goto L5;
        r0 = (IRoom) r4.get("data_room", null);
    L5:
        if (r0 != null) goto L7;
    L10:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L13;
        r5.observe("data_user_in_room", this);
    L13:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L17;
        r6.observe("cmd_toolbar_left_avatar_bubble", this);
        return;
    L17:
        return;
    L7:
        if (r0.allowGift() == true) goto L10;
        yq(false);
    }

    public final void yq(boolean r2) {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public static final void xq(LeftAvatarWidget r3, com.bytedance.android.live.base.model.user.e r4) {
        r3.getClass();
        String r0 = r4.getSchema();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2.a(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L14;
        r3.Bq("click", r4, "medal");
        IBaseLiveActionHandler r5 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r5 == null) goto L15;
        r5.handle(((Widget) r3).context, r0);
        return;
    L15:
        return;
    }

    public final void Bq(String r6, com.bytedance.android.live.base.model.user.e r7, String r8) {
        if (Intrinsics.areEqual(r6, "show") == false) goto L5;
        String r9 = "livesdk_toolbar_icon_show";
    L6:
        HashMap r0 = new HashMap();
        r0.put("privilege_level", String.valueOf(r7.getGradeLevel()));
        String r2 = "1";
        if (r7.getHideGradeLevel() == false) goto L9;
        Object r1 = "1";
    L10:
        r0.put("is_hide", r1);
        r0.put("icon_type", "privilege_icon");
        r0.put("icon_order", "-1");
        if (z.e(((Widget) this).dataCenter, false) == true) goto L14;
        r2 = "0";
    L14:
        r0.put("is_anchor", r2);
        if (r7.getMysteryMan() == false) goto L17;
        r8 = "mystery";
    L17:
        r0.put("show_type", r8);
        j0.l().sendLog(r9, r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L9:
        r1 = "0";
        goto L10
    L5:
        r9 = "livesdk_toolbar_icon_click";
        goto L6
    }

    public static final void wq(LeftAvatarWidget r10, Map r11, int r13, String r14) {
        Pair[] r0 = new Pair[5];
        IUser r1 = r10.j;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getIdString();
    L6:
        r0[0] = TuplesKt.to("user_id", r3);
        IUser r4 = r10.j;
        if (r4 == null) goto L11;
        py.d r5 = r4.getUserHonor();
        if (r5 == null) goto L11;
        String r6 = String.valueOf(r5.getLevel());
    L12:
        r0[1] = TuplesKt.to("privilege_level", r6);
        r0[2] = TuplesKt.to("location_from", "comment_left_avatar");
        r0[3] = TuplesKt.to("privilege_from", String.valueOf(r13));
        if (z.e(((Widget) r10).dataCenter, false) == false) goto L15;
        String r15 = "1";
    L16:
        r0[4] = TuplesKt.to("is_anchor", r15);
        Map r16 = MapsKt.mutableMapOf(r0);
        boolean r7 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r8 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
        if (r8 == null) goto L20;
        Map r9 = r8.q();
        if (r9 == null) goto L20;
    L21:
        r16.putAll(r9);
        if (r11 == null) goto L45;
        Iterator r17 = r11.entrySet().iterator();
    L24:
        boolean r18 = r17.hasNext();
        String r19 = BuildConfig.FLAVOR;
        if (r18 == false) goto L31;
        Map.Entry r20 = (Map.Entry) r17.next();
        Object r21 = r20.getKey();
        String r23 = (String) r20.getValue();
        if (r23 == null) goto L30;
        r19 = r23;
    L30:
        r16.put(r21, r19);
        goto L24
    L31:
        String r24 = (String) r11.get("message_type");
        if (r24 != null) goto L34;
        r24 = BuildConfig.FLAVOR;
    L34:
        r16.put("content", r24);
        if (r13 != 3) goto L40;
        String r25 = (String) r11.get("bubble_info");
        if (r25 != null) goto L39;
        r25 = BuildConfig.FLAVOR;
    L39:
        r16.put("bubble_info", r25);
    L40:
        String r110 = (String) r11.get("prop_id");
        if (r110 == null) goto L44;
        r19 = r110;
    L44:
        r16.put("prop_id", r19);
    L45:
        int r111 = r14.hashCode();
        if (r111 == 3529469) goto L54;
        if (r111 != 94750088) goto L57;
        if (r14.equals("click") == false) goto L57;
        r2 = "livesdk_room_bubble_click";
    L57:
        if (r13 != 14) goto L60;
        r16.put("message_type", "room_grouppk_matching");
    L60:
        if (r2 == null) goto L66;
        j0.l().sendLog(r2, r16, new Object[]{Room.class, am2.x.class});
        return;
    L66:
        return;
    L54:
        if (r14.equals("show") == false) goto L57;
        r2 = "livesdk_room_bubble_show";
    L20:
        r9 = new HashMap();
        goto L21
    L15:
        r15 = "0";
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
