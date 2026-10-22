package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.h;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends e {
    public static final /* synthetic */ int n = 0;
    public View i;
    public PositionNameTv j;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b k;
    public Integer l;
    public final m m;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.a$a, reason: collision with other inner class name */
    public static final class C0049a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e
    public final void r() {
    }

    @Override // jg0.c
    public final int o() {
        MicSeatScene r0 = this.b;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131566568;
    L5:
        if (r1 != 2) goto L7;
        return 2131566569;
    L7:
        if (r1 == 3) goto L9;
        return 0;
    L9:
        return 2131566578;
    }

    public final void v() {
        boolean r0 = gh0.b.a;
        StringBuilder r1 = new StringBuilder("updateEmptySeatPositionName, isShowFromFullScreenAll = ");
        MultiLinkSpecialViewBinder.a r2 = this.e;
        int r3 = -1;
        if (r2 == null) goto L5;
        int r4 = r2.d;
    L6:
        r1.append(h.f(r4));
        r1.append(", positionNameItem = ");
        MultiLinkSpecialViewBinder.a r5 = this.e;
        LinkmicPositionItem r6 = null;
        if (r5 == null) goto L9;
        LinkmicPositionItem r7 = r5.m;
    L10:
        r1.append(r7);
        r1.append(", positionNameTv = ");
        r1.append(this.j);
        gh0.b.a("AudioSpecialLayer", r1.toString(), false);
        MultiLinkSpecialViewBinder.a r8 = this.e;
        if (r8 == null) goto L14;
        r3 = r8.d;
    L14:
        if (h.f(r3) == true) goto L16;
        return;
    L16:
        PositionNameTv r9 = this.j;
        if (r9 == null) goto L38;
        MultiLinkSpecialViewBinder.a r10 = this.e;
        if (r10 == null) goto L21;
        r6 = r10.m;
    L21:
        LinkmicPositionItem r11 = r6;
        boolean r12 = gh0.a.d();
        MultiLinkSpecialViewBinder.a r13 = this.e;
        if (r13 == null) goto L24;
        int r14 = r13.f;
    L25:
        if (r13 == null) goto L28;
        List<Integer> r15 = r13.g;
        if (r15 == null) goto L28;
    L29:
        List<Integer> r16 = r15;
        MultiLinkSpecialViewBinder.a r17 = this.e;
        if (r17 == null) goto L32;
        int r18 = r17.d;
    L33:
        if (r18 <= 0) goto L35;
        boolean r19 = true;
    L36:
        PositionNameTv.y(r9, r11, r12, r14, r16, r19);
        return;
    L35:
        r19 = false;
        goto L36
    L32:
        r18 = 0;
    L28:
        r15 = CollectionsKt.emptyList();
        goto L29
    L24:
        r14 = 0;
        goto L25
    L38:
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = -1;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e, jg0.c, jg0.f
    public final void a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super.a(r8);
        this.k = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b((ImageView) q().findViewById(2131389651), (TextView) q().findViewById(2131389541), null, 0, true);
    }

    public final void u(MultiLinkSpecialViewBinder.a r6) {
        if (this.b != MicSeatScene.AUDIO_LINK_LARGE) goto L44;
        if (TeamFightContext.Companion.h() == false) goto L26;
        if (li0.d.g(null) == false) goto L26;
        Integer r0 = this.l;
        if (r0 == null) goto L26;
        if (r6.n == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.k;
        if (r7 == null) goto L65;
        r7.g(s1.B(2131922790));
    L65:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r8 = this.k;
        if (r8 == null) goto L71;
        String r9 = r8.c();
        if (r9 == null) goto L72;
        r3.c(q(), r9, true);
        return;
    L72:
        return;
    L71:
        return;
    L15:
        Intrinsics.checkNotNull(r0);
        int r10 = li0.d.b(r0.intValue());
        if (r10 != 1) goto L21;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r11 = this.k;
        if (r11 == null) goto L65;
        r11.g(s1.B(2131920070));
        goto L65
    L21:
        if (r10 != 2) goto L65;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r12 = this.k;
        if (r12 == null) goto L65;
        r12.g(s1.B(2131920069));
    L26:
        if (gh0.a.d() == true) goto L33;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r13 = this.k;
        if (r13 == null) goto L65;
        r13.g(s1.B(2131919824));
    L33:
        if (r6.n == false) goto L35;
    L40:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r14 = this.k;
        if (r14 == null) goto L65;
        r14.g(s1.B(2131919821));
        goto L65
    L35:
        if (je0.d.D() == true) goto L40;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r15 = this.k;
        if (r15 == null) goto L65;
        r15.g(s1.B(2131919833));
        goto L65
    L44:
        if (gh0.a.d() == true) goto L51;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L51;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r16 = this.k;
        if (r16 == null) goto L65;
        r16.g(s1.B(2131919824));
    L51:
        if (r6.n == false) goto L55;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r17 = this.k;
        if (r17 == null) goto L65;
        r17.g(s1.B(2131919823));
        goto L65
    L55:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r18 = MultiRevenueDataContext.a.a();
        if (r18 != null) goto L58;
    L62:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r19 = this.k;
        if (r19 == null) goto L65;
        r19.g(s1.B(2131919833));
        goto L65
    L58:
        if (r18.isGameShowing() != true) goto L62;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r20 = this.k;
        if (r20 == null) goto L65;
        r20.g(s1.B(2131917241));
        goto L65
    }

    @Override // jg0.f
    public final void d(Object r3, int r4) {
        MultiLinkSpecialViewBinder.a r5 = (MultiLinkSpecialViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r5, "itemData");
        super.s(r5);
        this.l = Integer.valueOf(r4);
        this.i = q().findViewById(2131389539);
        PositionNameTv r0 = (PositionNameTv) q().findViewById(2131389701);
        this.j = r0;
        if (r0 == null) goto L10;
        xg0.a r1 = this.c;
        if (r1 == null) goto L7;
        DataCenter r2 = r1.getDataCenter();
    L8:
        r0.setDataCenter(r2);
        goto L10
    L7:
        r2 = null;
    L10:
        if (n() != 0) goto L12;
        q().setOnClickListener(x0.a(new MultiLinkAudioCommonSpecialMicSeatBasicLayer$onBind$1(this)));
    L12:
        v();
        if (je0.d.D() == false) goto L22;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.k;
        if (r6 == null) goto L17;
        r6.g(s1.B(2131919821));
    L17:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.k;
        if (r7 == null) goto L27;
        String r8 = r7.c();
        if (r8 == null) goto L27;
        r3.c(q(), r8, true);
    L27:
        if (((IInteractService) k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(this.m.getUiLayout(), r4) == false) goto L33;
        View r9 = this.i;
        if (r9 == null) goto L39;
        ViewTreeObserver r10 = r9.getViewTreeObserver();
        if (r10 == null) goto L40;
        r10.addOnGlobalLayoutListener(new c(this));
        return;
    L40:
        return;
    L39:
        return;
    L33:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r11 = this.k;
        if (r11 == null) goto L42;
        TextView r12 = r11.k;
        if (r12 == null) goto L43;
        r12.setTranslationY(0.0f);
        return;
    L43:
        return;
    L42:
        return;
    L22:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r13 = this.k;
        if (r13 == null) goto L25;
        r13.e(0);
    L25:
        u(r5);
        goto L27
    }

    public a(MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.m = r3;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        t((MultiLinkSpecialViewBinder.a) r1, r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e
    public final void t(MultiLinkSpecialViewBinder.a r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        super.t(r3, r4, r5);
        this.l = Integer.valueOf(r4);
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L19;
        String r7 = r6.next();
        if (r7 == null) goto L4;
        int r0 = r7.hashCode();
        if (r0 != 817798352) goto L11;
        if (r7.equals("payload_key_position_item_update") == false) goto L4;
        v();
        goto L4
    L11:
        if (r0 != 1074297423) goto L4;
        if (r7.equals("payload_key_interact_state_update") == false) goto L4;
        u(r3);
        goto L4
    L19:
        v();
    }
}
