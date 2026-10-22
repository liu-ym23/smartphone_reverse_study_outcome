package pg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.utils.j0;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rj0.h;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e extends jg0.c<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a d;
    public TextView e;
    public PositionNameTv f;
    public SeatPosTagLabelTextView g;
    public TextView h;
    public View i;
    public long j;

    public final boolean s() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L9;
        ch0.e r2 = r0.k;
        if (r2 == null) goto L9;
        Map<String, Object> r3 = r2.d;
        if (r3 == null) goto L9;
        Object r4 = r3.get("EXT_KEY_ANCHOR_ID");
    L11:
        if ((r4 instanceof String) == true) goto L13;
        r4 = null;
    L13:
        String r5 = (String) r4;
        MultiLinkGuestViewBinder.a r6 = this.d;
        if (r6 == null) goto L22;
        ch0.e r7 = r6.k;
        if (r7 == null) goto L22;
        ILinkPlayerInfoBridge r8 = r7.a;
        if (r8 == null) goto L22;
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L22;
        String r10 = r9.getIdString();
    L23:
        m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L28;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L28;
        String r13 = r12.getOwnerUserIdString();
    L29:
        MultiLinkGuestViewBinder.a r14 = this.d;
        if (r14 == null) goto L39;
        ch0.e r15 = r14.k;
        if (r15 == null) goto L39;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L39;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L39;
        r1 = r17.getIdString();
    L39:
        if (Intrinsics.areEqual(r13, r1) == false) goto L41;
    L44:
        return true;
    L41:
        if (Intrinsics.areEqual(r10, r5) == true) goto L44;
        return false;
    L28:
        r13 = null;
    L22:
        r10 = null;
    L9:
        r4 = null;
        goto L11
    }

    public final void v() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L21;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L21;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L21;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L21;
        String r4 = r3.getIdString();
        if (r4 == null) goto L21;
        int r5 = cj0.e.h;
        h r6 = cj0.e.a.a();
        if (r6 == null) goto L19;
        Map<String, Long> r7 = r6.c();
        if (r7 == null) goto L19;
        Long r8 = r7.get(r4);
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L20:
        this.j = r9;
    L19:
        r9 = 0;
    L21:
        w(this.j);
    }

    public final void y() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        boolean r1 = false;
        ILinkPlayerInfoBridge r3 = null;
        if (r0 == null) goto L76;
        ch0.e r2 = r0.k;
        if (r2 == null) goto L76;
        ILinkPlayerInfoBridge r4 = r2.a;
        if (r4 == null) goto L76;
        g0 r5 = r4.getMicPosTagInfo();
        if (r5 == null) goto L76;
        if (r5.getTagTypeId() <= 0) goto L65;
        String r6 = r5.getPositionTagName();
        if (r6 == null) goto L65;
        if (r6.length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 != true) goto L65;
        TextView r8 = this.e;
        if (r8 != null) goto L22;
    L23:
        AppCompatTextView r9 = this.g;
        if (r9 == null) goto L28;
        if (r9.getVisibility() != 0) goto L28;
    L39:
        int r10 = j0.a;
        SeatPosTagLabelTextView r11 = this.g;
        MultiLinkGuestViewBinder.a r12 = this.d;
        if (r12 == null) goto L44;
        ch0.e r13 = r12.k;
        if (r13 == null) goto L44;
        ILinkPlayerInfoBridge r14 = r13.a;
    L45:
        if (r12 == null) goto L47;
        int r15 = r12.d;
    L48:
        if (r15 <= 0) goto L50;
        boolean r16 = true;
    L51:
        q().getContext();
        j0.b(r11, r5, r14, r16, this.b);
        SeatPosTagLabelTextView r17 = this.g;
        MultiLinkGuestViewBinder.a r18 = this.d;
        if (r18 == null) goto L56;
        ch0.e r19 = r18.k;
        if (r19 == null) goto L56;
        ILinkPlayerInfoBridge r20 = r19.a;
    L57:
        Context r21 = q().getContext();
        MultiLinkGuestViewBinder.a r22 = this.d;
        if (r22 == null) goto L60;
        int r23 = r22.d;
    L61:
        if (r23 <= 0) goto L63;
        boolean r24 = true;
    L64:
        j0.a(r17, r5, r20, r21, r24);
        Unit r25 = Unit.INSTANCE;
    L75:
        if (r25 == null) goto L76;
    L88:
        MultiLinkGuestViewBinder.a r26 = this.d;
        if (r26 == null) goto L91;
        int r27 = r26.d;
    L93:
        if (com.bytedance.android.live.liveinteract.utils.h.f(r27) == false) goto L122;
        MultiLinkGuestViewBinder.a r28 = this.d;
        if (r28 == null) goto L101;
        wg0.a r29 = r28.n;
        if (r29 == null) goto L101;
        if (r29.c != true) goto L101;
        boolean r30 = true;
    L102:
        if (r30 == false) goto L126;
        if (r28 == null) goto L121;
        ch0.e r31 = r28.k;
        if (r31 == null) goto L121;
        ILinkPlayerInfoBridge r32 = r31.a;
        if (r32 == null) goto L121;
        g0 r33 = r32.getMicPosTagInfo();
        if (r33 == null) goto L121;
        Intrinsics.checkNotNullParameter(r33, "$this$isAnchorLabel");
        if (r33.getTagType() != 3) goto L113;
    L116:
        boolean r34 = true;
    L117:
        if (r34 != true) goto L121;
        if (vm2.d.O() == false) goto L121;
        r1 = true;
        goto L121
    L113:
        if (r33.getTagTypeId() == 3) goto L116;
        r34 = false;
    L121:
        if (r1 == false) goto L122;
        return;
    L126:
        return;
    L101:
        r30 = false;
    L122:
        SeatPosTagLabelTextView r35 = this.g;
        if (r35 == null) goto L128;
        r35.setVisibility(8);
        return;
    L128:
        return;
    L91:
        r27 = -1;
        goto L93
    L63:
        r24 = false;
        goto L64
    L60:
        r23 = 0;
    L56:
        r20 = null;
        goto L57
    L50:
        r16 = false;
        goto L51
    L47:
        r15 = 0;
    L44:
        r14 = null;
    L28:
        if (n() > 0) goto L39;
        SeatPosTagLabelTextView r36 = this.g;
        if (r36 == null) goto L38;
        MultiLinkGuestViewBinder.a r37 = this.d;
        if (r37 == null) goto L36;
        ch0.e r38 = r37.k;
        if (r38 == null) goto L36;
        ILinkPlayerInfoBridge r39 = r38.a;
    L37:
        SeatPosTagLabelTextView.z(r36, 0, r39, this.b, null, 8);
    L36:
        r39 = null;
    L38:
        int r40 = j0.a;
        j0.d(r5);
        goto L39
    L22:
        if (r8.getVisibility() == 0) goto L65;
    L17:
        r7 = false;
    L65:
        SeatPosTagLabelTextView r41 = this.g;
        if (r41 == null) goto L74;
        MultiLinkGuestViewBinder.a r42 = this.d;
        if (r42 == null) goto L72;
        ch0.e r43 = r42.k;
        if (r43 == null) goto L72;
        ILinkPlayerInfoBridge r44 = r43.a;
    L73:
        SeatPosTagLabelTextView.z(r41, 8, r44, this.b, null, 8);
        r25 = Unit.INSTANCE;
    L72:
        r44 = null;
        goto L73
    L74:
        r25 = null;
    L76:
        SeatPosTagLabelTextView r45 = this.g;
        if (r45 == null) goto L84;
        MultiLinkGuestViewBinder.a r46 = this.d;
        if (r46 == null) goto L83;
        ch0.e r47 = r46.k;
        if (r47 == null) goto L83;
        r3 = r47.a;
    L83:
        SeatPosTagLabelTextView.z(r45, 8, r3, this.b, null, 8);
    L84:
        AppCompatTextView r48 = this.g;
        if (r48 == null) goto L87;
        r48.setText("");
    L87:
        Unit r49 = Unit.INSTANCE;
        goto L88
    }

    public final void z() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L24;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L25;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isHost() == false) goto L20;
        MultiLinkGuestViewBinder.a r3 = this.d;
        if (r3 == null) goto L14;
        int r4 = r3.d;
    L16:
        if (com.bytedance.android.live.liveinteract.utils.h.f(r4) == false) goto L20;
        TextView r5 = this.h;
        if (r5 == null) goto L26;
        r5.setVisibility(0);
        return;
    L26:
        return;
    L14:
        r4 = -1;
    L20:
        TextView r6 = this.h;
        if (r6 == null) goto L28;
        r6.setVisibility(8);
        return;
    L28:
        return;
    L25:
        return;
    }

    public void r() {
        this.e = (TextView) q().findViewById(2131362580);
        PositionNameTv r0 = (PositionNameTv) q().findViewById(2131389701);
        this.f = r0;
        if (r0 == null) goto L9;
        xg0.a r1 = this.c;
        if (r1 == null) goto L7;
        DataCenter r2 = r1.getDataCenter();
    L8:
        r0.setDataCenter(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        this.g = (SeatPosTagLabelTextView) q().findViewById(2131389764);
        this.h = (TextView) q().findViewById(2131389660);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void x() {
        int r1 = 8;
        boolean r2 = false;
        if (vm2.d.O() == false) goto L24;
        AppCompatTextView r0 = this.f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getVisibility() != 0) goto L90;
        AppCompatTextView r3 = this.f;
        if (r3 != null) goto L11;
        return;
    L11:
        if (s() == false) goto L21;
        MultiLinkGuestViewBinder.a r4 = this.d;
        if (r4 == null) goto L21;
        ch0.e r5 = r4.k;
        if (r5 == null) goto L21;
        ILinkPlayerInfoBridge r6 = r5.a;
        if (r6 == null) goto L21;
        if (r6.isEnlarged() == true) goto L21;
    L22:
        r3.setVisibility(r1);
        return;
    L21:
        r1 = 0;
        goto L22
    L90:
        return;
    L24:
        MultiLinkGuestViewBinder.a r7 = this.d;
        if (r7 == null) goto L30;
        wg0.a r8 = r7.n;
        if (r8 == null) goto L30;
        if (r8.a == true) goto L30;
    L35:
        TextView r9 = this.e;
        if (r9 == null) goto L92;
        UtilityKotlinExtentionsKt.t(r9);
        return;
    L92:
        return;
    L30:
        if (r7 == null) goto L32;
        int r10 = r7.d;
    L34:
        if (com.bytedance.android.live.liveinteract.utils.h.f(r10) == false) goto L35;
        if (CPositionContext.Companion.d() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L43;
        r2 = true;
    L43:
        if (s() == false) goto L57;
        if (r2 == false) goto L57;
        MultiLinkGuestViewBinder.a r11 = this.d;
        if (r11 == null) goto L57;
        ch0.e r12 = r11.k;
        if (r12 == null) goto L57;
        ILinkPlayerInfoBridge r13 = r12.a;
        if (r13 == null) goto L57;
        if (r13.isEnlarged() != true) goto L57;
        TextView r14 = this.e;
        if (r14 == null) goto L72;
        UtilityKotlinExtentionsKt.t(r14);
    L72:
        TextView r15 = this.e;
        if (r15 != null) goto L75;
        return;
    L75:
        if (r15.getVisibility() != 0) goto L94;
        SeatPosTagLabelTextView r16 = this.g;
        if (r16 == null) goto L85;
        MultiLinkGuestViewBinder.a r17 = this.d;
        if (r17 == null) goto L83;
        ch0.e r18 = r17.k;
        if (r18 == null) goto L83;
        ILinkPlayerInfoBridge r19 = r18.a;
    L84:
        SeatPosTagLabelTextView.z(r16, 8, r19, this.b, null, 8);
    L83:
        r19 = null;
    L85:
        AppCompatTextView r20 = this.f;
        if (r20 == null) goto L95;
        r20.setVisibility(8);
        return;
    L95:
        return;
    L94:
        return;
    L57:
        if (s() == false) goto L69;
        MultiLinkGuestViewBinder.a r21 = this.d;
        if (r21 == null) goto L69;
        ch0.e r22 = r21.k;
        if (r22 == null) goto L69;
        ILinkPlayerInfoBridge r23 = r22.a;
        if (r23 == null) goto L69;
        if (r23.isEnlarged() == true) goto L69;
        TextView r24 = this.e;
        if (r24 == null) goto L72;
        UtilityKotlinExtentionsKt.w(r24);
    L69:
        TextView r25 = this.e;
        if (r25 == null) goto L72;
        UtilityKotlinExtentionsKt.t(r25);
        goto L72
    L32:
        r10 = 0;
        goto L34
    }

    public final void A(MultiLinkGuestViewBinder.a r10) {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r4 = r0.booleanValue();
    L6:
        PositionNameTv r2 = this.f;
        if (r2 == null) goto L27;
        if (r10 == null) goto L12;
        ch0.e r3 = r10.k;
        if (r3 == null) goto L12;
        ILinkPlayerInfoBridge r5 = r3.a;
    L13:
        if (r10 == null) goto L15;
        int r6 = r10.f;
    L16:
        if (r10 == null) goto L19;
        List<Integer> r7 = r10.g;
        if (r7 == null) goto L19;
    L20:
        if (r10 == null) goto L22;
        int r11 = r10.d;
    L23:
        if (r11 <= 0) goto L25;
        boolean r8 = true;
    L26:
        PositionNameTv.x(r2, r5, r4, r6, r7, r8, 4);
        goto L27
    L25:
        r8 = false;
        goto L26
    L22:
        r11 = 0;
    L19:
        r7 = CollectionsKt.emptyList();
        goto L20
    L15:
        r6 = 0;
    L12:
        r5 = null;
    L27:
        x();
        MultiLinkGuestViewBinder.a r12 = this.d;
        if (r12 == null) goto L30;
        int r13 = r12.d;
    L32:
        if (com.bytedance.android.live.liveinteract.utils.h.f(r13) == false) goto L41;
        MultiLinkGuestViewBinder.a r14 = this.d;
        if (r14 == null) goto L40;
        wg0.a r15 = r14.n;
        if (r15 == null) goto L40;
        if (r15.c != true) goto L40;
        r1 = true;
    L40:
        if (r1 == true) goto L41;
        return;
    L41:
        AppCompatTextView r16 = this.f;
        if (r16 == null) goto L46;
        r16.setVisibility(8);
        return;
    L46:
        return;
    L30:
        r13 = -1;
        goto L32
    L5:
        r4 = false;
        goto L6
    }

    @Override // jg0.c, jg0.f
    public void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.i = q().findViewById(2131389689);
        r();
    }

    public void w(long r9) {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L40;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L41;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 != null) goto L10;
        return;
    L10:
        if (s() == false) goto L12;
    L32:
        View r10 = this.i;
        if (r10 == null) goto L42;
        r10.setVisibility(8);
        return;
    L42:
        return;
    L12:
        if (n() != 0) goto L32;
        long r3 = r2.getExpectLeaveTime();
        long r4 = r2.getJoinChannelTime();
        if (r3 != 0) goto L17;
    L28:
        View r11 = this.i;
        if (r11 == null) goto L39;
        r11.setVisibility(8);
        return;
    L39:
        return;
    L17:
        if (n() != 0) goto L28;
        long r5 = (r3 - r4) * ((long) 1000);
        if (r9 > 0) goto L24;
        View r12 = this.i;
        if (r12 == null) goto L36;
        r12.setVisibility(8);
        return;
    L36:
        return;
    L24:
        UIUtils.updateLayout(this.i, (int) ((((long) q().getWidth()) * r9) / r5), -3);
        View r13 = this.i;
        if (r13 == null) goto L38;
        r13.setVisibility(0);
        return;
    L38:
        return;
    L41:
        return;
    }

    public e(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        t((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public void t(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.d = r2;
        v();
        y();
        A(this.d);
        z();
        if (aj0.b.c(((IInteractService) k.n(IInteractService.class)).getCurrentUiLayout()) == false) goto L6;
        int r4 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.g(this, r3);
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        u((MultiLinkGuestViewBinder.a) r1, r2, r3);
    }

    public void u(MultiLinkGuestViewBinder.a r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        this.d = r3;
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L50;
        String r0 = r6.next();
        if (r0 == null) goto L4;
        switch(r0.hashCode()) {
            case -2054590407: goto L48;
            case -1313590636: goto L45;
            case -715388833: goto L42;
            case -703589172: goto L39;
            case -396649875: goto L36;
            case 236305799: goto L33;
            case 612019593: goto L30;
            case 683963210: goto L27;
            case 1416202744: goto L24;
            case 1524418136: goto L21;
            case 1856639921: goto L15;
            case 2014427442: goto L12;
            default: goto L4;
        };
    L12:
        if (r0.equals("payload_key_competition_open_status_update") == false) goto L4;
        y();
        A(this.d);
        goto L4
    L15:
        if (r0.equals("payload_key_tag_label_action_update") == false) goto L4;
        Object r1 = r3.k.d.remove("EXT_KEY_TAG_LABEL_ACTION");
        if ((r1 instanceof p) == true) goto L19;
        r1 = null;
    L19:
        p r2 = (p) r1;
        r3.k.d.remove("EXT_KEY_TAG_LABEL_ACTION_PAYLOAD");
        y();
        goto L4
    L21:
        if (r0.equals("payload_key_position_name_update") == false) goto L4;
        A(this.d);
        goto L4
    L24:
        if (r0.equals("payload_key_interact_song_golden_mic_display_state") == false) goto L4;
        y();
        goto L4
    L27:
        if (r0.equals("payload_key_room_state_update") == false) goto L4;
        y();
        A(this.d);
        goto L4
    L30:
        if (r0.equals("payload_key_link_mic_tag_info_update") == false) goto L4;
        y();
        A(this.d);
        goto L4
    L33:
        if (r0.equals("payload_key_feedview_interact_song_golden_mic_online_state") == false) goto L4;
        y();
        A(this.d);
        goto L4
    L36:
        if (r0.equals("payload_key_paid_link_time_remain_update") == false) goto L4;
        r3.k.d.remove("EXT_KEY_UPDATE_PAID_TIME_REMAIN");
        v();
        goto L4
    L39:
        if (r0.equals("payload_key_user_position") == false) goto L4;
    L43:
        t(r3, r4);
        goto L4
    L42:
        if (r0.equals("payload_key_is_c_position_update") == false) goto L4;
    L45:
        if (r0.equals("mic_room_host") == false) goto L4;
        z();
        goto L4
    L48:
        if (r0.equals("payload_key_play_mode_state_update") == false) goto L4;
        x();
        goto L4
    }
}
