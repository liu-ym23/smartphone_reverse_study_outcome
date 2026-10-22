package com.bytedance.android.live.liveinteract.revenue.game.layer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.livesdk.message.model.rm;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jg0.d;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends jg0.a<MultiLinkFoldButtonViewBinder.a> implements d<MultiLinkFoldButtonViewBinder.a> {
    public static final /* synthetic */ int m = 0;
    public MultiLinkFoldButtonViewBinder.a e;
    public TextView f;
    public TextView g;
    public HSImageView h;
    public View i;
    public TextView j;
    public boolean k;
    public MultiLinkFoldButtonViewBinder.a l;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.game.layer.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 2131566607;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkGameFunctionLayer.name();
    }

    public final void s() {
        if (n() != 0) goto L62;
        LinkMicGameContext.a r0 = LinkMicGameContext.Companion;
        LinkMicGameContext r1 = r0.getContext();
        Object r2 = null;
        if (r1 == null) goto L7;
        List<rm.b> r3 = r1.getGameScores();
    L9:
        if (r0.e() == false) goto L43;
        if (r3 == null) goto L43;
        if ((!r3.isEmpty()) == false) goto L43;
        Iterator<T> r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L31;
        Object r5 = r4.next();
        String r6 = ((rm.b) r5).joinUid;
        MultiLinkFoldButtonViewBinder.a r7 = this.l;
        if (r7 == null) goto L27;
        MultiLinkFirstUserViewBinder.a r8 = r7.q;
        if (r8 == null) goto L27;
        e r9 = r8.k;
        if (r9 == null) goto L27;
        ILinkPlayerInfoBridge r10 = r9.a;
        if (r10 == null) goto L27;
        IBaseUser r11 = r10.getUser();
        if (r11 == null) goto L27;
        String r12 = r11.getIdString();
    L29:
        if (Intrinsics.areEqual(r6, r12) == false) goto L15;
        r2 = r5;
    L27:
        r12 = null;
    L31:
        rm.b r13 = (rm.b) r2;
        if (r13 != null) goto L34;
    L39:
        TextView r14 = this.j;
        if (r14 == null) goto L42;
        r14.setText("观战中");
    L42:
        this.k = true;
    L59:
        TextView r15 = this.j;
        if (r15 == null) goto L69;
        r15.setVisibility(0);
        return;
    L69:
        return;
    L34:
        if (r13.joinGame == false) goto L39;
        TextView r16 = this.j;
        if (r16 == null) goto L42;
        r16.setText(r13.score);
    L43:
        TextView r17 = this.j;
        if (r17 == null) goto L58;
        MultiLinkFoldButtonViewBinder.a r18 = this.l;
        if (r18 == null) goto L56;
        MultiLinkFirstUserViewBinder.a r19 = r18.q;
        if (r19 == null) goto L56;
        e r20 = r19.k;
        if (r20 == null) goto L56;
        ILinkPlayerInfoBridge r21 = r20.a;
        if (r21 == null) goto L56;
        String r22 = r21.getFanTicketDisplayStr();
        if (r22 == null) goto L56;
    L57:
        r17.setText(r22);
    L56:
        r22 = "";
    L58:
        this.k = false;
        goto L59
    L7:
        r3 = null;
        goto L9
    L62:
        TextView r23 = this.j;
        if (r23 == null) goto L71;
        r23.setVisibility(8);
        return;
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.f = (TextView) q().findViewById(2131390642);
        this.h = q().findViewById(2131389564);
        this.i = q().findViewById(2131389580);
        this.j = (TextView) q().findViewById(2131389589);
        this.g = (TextView) q().findViewById(2131389541);
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(n()) == false) goto L5;
        return;
    L5:
        if (n() == 0) goto L14;
        TextView r3 = this.f;
        if (r3 == null) goto L9;
        r3.setTextSize(6.0f);
    L9:
        TextView r4 = this.g;
        if (r4 == null) goto L15;
        r4.setTextSize(6.0f);
        return;
    L15:
        return;
    }

    public final void r(final MultiLinkFoldButtonViewBinder.a r10) {
        Intrinsics.checkNotNullParameter(r10, "itemData");
        this.l = r10;
        this.e = r10;
        MultiLinkFirstUserViewBinder.a r0 = r10.q;
        if (r0 == null) goto L46;
        e r3 = r0.k;
        if (r3 == null) goto L25;
        ILinkPlayerInfoBridge r4 = r3.a;
        if (r4 == null) goto L25;
        if (r4.isAnonymous() != true) goto L25;
        PipelineDraweeControllerBuilder r5 = Fresco.newDraweeControllerBuilder();
        e r6 = r0.k;
        if (r6 == null) goto L21;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L21;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L21;
        k r9 = r8.getAvatarMedium();
        if (r9 == null) goto L21;
        List r11 = r9.getUrls();
        if (r11 == null) goto L21;
        String r12 = (String) CollectionsKt.firstOrNull(r11);
    L22:
        AbstractDraweeController r13 = r5.setUri(r12).setControllerListener(new b(this)).build();
        HSImageView r14 = this.h;
        if (r14 == null) goto L39;
        r14.setController(r13);
    L39:
        e r1 = r0.k;
        if (r1 == null) goto L44;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L44;
        Integer r15 = Integer.valueOf(r2.getSilenceStatus());
    L45:
        t(r15.intValue());
        s();
    L44:
        r15 = null;
    L21:
        r12 = null;
    L25:
        HSImageView r16 = this.h;
        if (r16 == null) goto L30;
        Drawable r17 = r16.getBackground();
        if (r17 == null) goto L30;
        r17.setAlpha(1);
    L30:
        HSImageView r18 = this.h;
        e r19 = r0.k;
        if (r19 == null) goto L37;
        ILinkPlayerInfoBridge r20 = r19.a;
        if (r20 == null) goto L37;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L37;
        k r22 = r21.getAvatarMedium();
    L38:
        ImageUtil.loadRoundImageAntiFlink(r18, r22, 0);
    L37:
        r22 = null;
    L46:
        MultiLinkFoldButtonViewBinder.a r23 = this.e;
        if (r23 != null) goto L49;
    L53:
        TextView r24 = this.f;
        if (r24 == null) goto L57;
        r24.setVisibility(8);
    L57:
        if (r10.k == true) goto L59;
        TextView r25 = this.f;
        if (r25 == null) goto L76;
        StringCompanionObject r26 = StringCompanionObject.INSTANCE;
        r25.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r10.m)}, 1)));
    L76:
        q().setOnClickListener(null);
        TextView r27 = this.f;
        if (r27 == null) goto L79;
        r27.setCompoundDrawables(null, null, null, null);
    L79:
        MultiLinkFoldButtonViewBinder.a r28 = this.e;
        if (r28 != null) goto L82;
    L112:
        TextView r110 = this.g;
        if (r110 == null) goto L118;
        r110.setVisibility(8);
        return;
    L118:
        return;
    L82:
        if (r28.o != true) goto L112;
        TextView r29 = this.g;
        if (r29 == null) goto L86;
        r29.setVisibility(0);
    L86:
        final MultiLinkNormalEmptyViewBinder.a r111 = r10.p;
        if (n() != 0) goto L91;
        TextView r30 = this.g;
        if (r30 == null) goto L91;
        r30.setOnClickListener(x0.a(new MultiLinkGameFunctionLayer$updateEmptyView$1(this, r111)));
    L91:
        TextView r31 = this.g;
        if (r31 != null) goto L94;
    L109:
        TextView r112 = this.g;
        if (r112 == null) goto L116;
        Drawable r32 = s1.m(2131251694);
        r32.setBounds(0, 0, r32.getMinimumWidth(), r32.getMinimumHeight());
        Unit r33 = Unit.INSTANCE;
        r112.setCompoundDrawables(r32, null, null, null);
        return;
    L116:
        return;
    L94:
        if (gh0.a.d() == false) goto L96;
        String r113 = s1.B(2131919823);
    L108:
        r31.setText(r113);
        goto L109
    L96:
        if (r111 != null) goto L98;
    L100:
        if (r111 == null) goto L105;
        if (r111.h() != true) goto L105;
        r113 = s1.B(2131919823);
    L105:
        if (vm2.d.f0() != 0) goto L107;
        r113 = s1.B(2131919228);
        goto L108
    L107:
        r113 = s1.B(2131919833);
        goto L108
    L98:
        if (r111.g() != true) goto L100;
        r113 = s1.B(2131919824);
        goto L108
    L59:
        if (r10.l == false) goto L66;
        TextView r34 = this.f;
        if (r34 == null) goto L63;
        StringCompanionObject r35 = StringCompanionObject.INSTANCE;
        r34.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r10.m)}, 1)));
    L63:
        TextView r36 = this.f;
        if (r36 == null) goto L72;
        Drawable r37 = s1.m(2131250844);
        r37.setBounds(0, 0, r37.getMinimumWidth(), r37.getMinimumHeight());
        Unit r38 = Unit.INSTANCE;
        r36.setCompoundDrawables(r37, null, null, null);
    L72:
        ViewGroup r39 = q();
        Function1<View, Unit> r40 = new MultiLinkGameFunctionLayer$updateFoldButton$3(this, r10);
        Intrinsics.checkNotNullParameter(r40, "onClick");
        r39.setOnClickListener(new w0(r40, 1000));
        goto L79
    L66:
        TextView r41 = this.f;
        if (r41 == null) goto L69;
        StringCompanionObject r42 = StringCompanionObject.INSTANCE;
        r41.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r10.m)}, 1)));
    L69:
        TextView r43 = this.f;
        if (r43 == null) goto L72;
        Drawable r44 = s1.m(2131250845);
        r44.setBounds(0, 0, r44.getMinimumWidth(), r44.getMinimumHeight());
        Unit r45 = Unit.INSTANCE;
        r43.setCompoundDrawables(r44, null, null, null);
        goto L72
    L49:
        if (r23.n != true) goto L53;
        TextView r46 = this.f;
        if (r46 == null) goto L57;
        r46.setVisibility(0);
        goto L57
    }

    public final void t(int r2) {
        if (r2 == 0) goto L12;
        View r3 = this.i;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
    L6:
        View r4 = this.i;
        if ((r4 instanceof ImageView) == true) goto L9;
        r4 = null;
    L9:
        ImageView r5 = (ImageView) r4;
        if (r5 == null) goto L16;
        r5.setImageResource(2131251871);
        return;
    L16:
        return;
    L12:
        View r6 = this.i;
        if (r6 == null) goto L18;
        r6.setVisibility(8);
        return;
    }

    public a(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkFoldButtonViewBinder.a) r1);
    }

    @Override // jg0.d
    public final void e(int r1, p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(r2, ti0.a.b) == false) goto L6;
        s();
        return;
    }

    @Override // jg0.f
    public final void k(Object r3, int r4, Bundle r5) {
        MultiLinkFoldButtonViewBinder.a r6 = (MultiLinkFoldButtonViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r6, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        this.l = r6;
        Iterator<String> r7 = r5.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L71;
        String r8 = r7.next();
        if (r8 == null) goto L4;
        int r0 = r8.hashCode();
        if (r0 != (-2108878291)) goto L11;
        if (r8.equals("payload_key_fan_ticket_str_update") == false) goto L4;
        MultiLinkFirstUserViewBinder.a r9 = r6.q;
        Object r10 = null;
        if (r9 == null) goto L33;
        e r11 = r9.k;
        if (r11 == null) goto L33;
        Map<String, Object> r12 = r11.d;
        if (r12 == null) goto L33;
        Object r13 = r12.remove("EXT_KEY_QUICK_INTERACT_MESSAGE");
    L35:
        if ((r13 instanceof QuickInteractTask) == false) goto L38;
        r10 = r13;
    L38:
        QuickInteractTask r14 = (QuickInteractTask) r10;
        if (r14 == null) goto L86;
        ALogger.d("MultiLinkGameFunctionLayer", "updateFanTicketStr, task: " + r14);
        String r15 = r14.b;
        if (r15 != null) goto L43;
        return;
    L43:
        if (n() == 0) goto L45;
        TextView r16 = this.j;
        if (r16 == null) goto L68;
        r16.setVisibility(8);
    L68:
        TextView r17 = this.j;
        if (r17 == null) goto L88;
        r17.setText(r15);
        return;
    L88:
        return;
    L45:
        if (this.k == false) goto L49;
        TextView r18 = this.j;
        if (r18 == null) goto L68;
        r18.setVisibility(0);
        goto L68
    L49:
        MultiLinkFoldButtonViewBinder.a r19 = this.l;
        if (r19 == null) goto L62;
        MultiLinkFirstUserViewBinder.a r20 = r19.q;
        if (r20 == null) goto L62;
        e r21 = r20.k;
        if (r21 == null) goto L62;
        ILinkPlayerInfoBridge r22 = r21.a;
        if (r22 == null) goto L62;
        if (r22.isOpenSendGift() != true) goto L62;
        TextView r23 = this.j;
        if (r23 == null) goto L68;
        r23.setVisibility(0);
    L62:
        TextView r24 = this.j;
        if (r24 == null) goto L68;
        r24.setVisibility(8);
        goto L68
    L86:
        return;
    L33:
        r13 = null;
        goto L35
    L11:
        if (r0 != 2021952839) goto L4;
        if (r8.equals("payload_key_silence_status_update") == false) goto L4;
        MultiLinkFirstUserViewBinder.a r25 = r6.q;
        if (r25 == null) goto L22;
        e r26 = r25.k;
        if (r26 == null) goto L22;
        ILinkPlayerInfoBridge r27 = r26.a;
        if (r27 == null) goto L22;
        int r28 = r27.getSilenceStatus();
    L23:
        t(r28);
        return;
    L22:
        r28 = -1;
        goto L23
    L71:
        r(r6);
    }
}
