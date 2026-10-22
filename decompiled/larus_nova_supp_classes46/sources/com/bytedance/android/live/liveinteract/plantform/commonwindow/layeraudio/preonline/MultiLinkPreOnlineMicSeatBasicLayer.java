package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jc1.k;
import je0.d;
import jg0.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkPreOnlineMicSeatBasicLayer extends c<MultiLinkPreOnlineViewBinder.a> implements Observer<Integer> {
    public ImageView d;
    public TextView e;
    public PositionNameTv f;
    public View g;
    public MultiLinkPreOnlineViewBinder.a h;

    public void t() {
    }

    public void u() {
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        hd0.c.f().e(this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, android.widget.TextView, com.bytedance.android.live.liveinteract.view.PositionNameTv] */
    public final void w() {
        Boolean r0 = m.i().isAnchor();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.booleanValue();
    L6:
        ?? r3 = this.f;
        if (r3 == 0) goto L76;
        MultiLinkPreOnlineViewBinder.a r4 = this.h;
        if (r4 == null) goto L11;
        LinkmicPositionItem r5 = r4.n;
    L12:
        String r6 = PositionNameTv.f;
        Integer r7 = d.h();
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
    L16:
        List r9 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r9, "playModes");
        if (InteractiveSongContext.Companion.f() == false) goto L22;
        if (PositionNameTv.B(r5) == false) goto L22;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L22:
        if (r8 != 25) goto L25;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L25:
        if (r8 != 29) goto L28;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L28:
        if (r8 != 30) goto L31;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L31:
        if (ThemedCompetitionContext.Companion.g() == false) goto L39;
        if (r5 == null) goto L39;
        if (r5.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L39;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.c() == true) goto L55;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L55:
        boolean r10 = k.n(IMiddlewareUserService.class).user().isAdmin();
        if (r5.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L58;
        r1 = true;
    L58:
        r3.d = r1;
        if (r2 == true) goto L62;
        if (r10 == true) goto L62;
    L65:
        if (TextUtils.isEmpty(r5.getActiveName()) == true) goto L67;
        r3.setText(r5.getActiveName());
        UtilityKotlinExtentionsKt.w(r3);
    L69:
        if (r3.getVisibility() == 0) goto L71;
        return;
    L71:
        if (r3.d == false) goto L73;
        r3.G();
        return;
    L73:
        r3.F(PositionNameTv.f);
        return;
    L67:
        UtilityKotlinExtentionsKt.t(r3);
    L62:
        if (r5.getVerifyStatus() != 1) goto L65;
        r3.setText(s1.B(2131918202));
        UtilityKotlinExtentionsKt.w(r3);
    L39:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == false) goto L41;
    L42:
        if (r5 != null) goto L44;
    L74:
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L44:
        if (r3.C() == false) goto L48;
        if (li0.d.g(null) == false) goto L74;
    L48:
        if (PositionNameTv.A(null) == true) goto L74;
        Integer r11 = d.h();
        if (r11 == null) goto L55;
        if (r11.intValue() != 28) goto L55;
    L41:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.b(r8, r9, false, false) == false) goto L74;
    L15:
        r8 = 0;
        goto L16
    L11:
        r5 = null;
        goto L12
    L76:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.d = (ImageView) q().findViewById(2131389534);
        this.e = (TextView) q().findViewById(2131389688);
        PositionNameTv r3 = (PositionNameTv) q().findViewById(2131389701);
        this.f = r3;
        if (r3 == null) goto L9;
        xg0.a r0 = this.c;
        if (r0 == null) goto L7;
        DataCenter r1 = r0.getDataCenter();
    L8:
        r3.setDataCenter(r1);
        goto L9
    L7:
        r1 = null;
    L9:
        this.g = q().findViewById(2131389538);
        HSImageView r4 = q().findViewById(2131389536);
        hd0.c.f().c(this);
    }

    public final void onChanged(Object r1) {
        Integer r2 = (Integer) r1;
        v(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
    }

    public final void v(int r3) {
        TextView r0 = this.e;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        TextView r1 = this.e;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        if (r3 != 1) goto L19;
        TextView r4 = this.e;
        if (r4 == null) goto L13;
        r4.setText(2131923211);
    L13:
        TextView r5 = this.e;
        if (r5 == null) goto L16;
        r5.setSelected(true);
    L16:
        u();
        TextView r6 = this.e;
        if (r6 == null) goto L40;
        r6.setOnClickListener(x0.a(new MultiLinkPreOnlineMicSeatBasicLayer$updateOperatorBtn$1(this)));
        return;
    L40:
        return;
    L19:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L30;
        TextView r7 = this.e;
        if (r7 == null) goto L24;
        r7.setText(2131921173);
    L24:
        TextView r8 = this.e;
        if (r8 == null) goto L27;
        r8.setSelected(false);
    L27:
        u();
        TextView r9 = this.e;
        if (r9 == null) goto L42;
        r9.setOnClickListener(x0.a(new MultiLinkPreOnlineMicSeatBasicLayer$updateOperatorBtn$2(this)));
        return;
    L42:
        return;
    L30:
        TextView r10 = this.e;
        if (r10 == null) goto L33;
        r10.setSelected(false);
    L33:
        TextView r11 = this.e;
        if (r11 == null) goto L36;
        r11.setText(2131923209);
    L36:
        u();
        TextView r12 = this.e;
        if (r12 == null) goto L44;
        r12.setOnClickListener(x0.a(new MultiLinkPreOnlineMicSeatBasicLayer$updateOperatorBtn$3(this)));
        return;
    }

    public MultiLinkPreOnlineMicSeatBasicLayer(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkPreOnlineViewBinder.a) r1, r2);
    }

    public void r(MultiLinkPreOnlineViewBinder.a r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        this.h = r7;
        if (r7 == null) goto L15;
        IBaseUser r9 = r7.k;
        if (r9 == null) goto L15;
        ImageView r0 = this.d;
        py.k r10 = r9.getAvatarThumbKt();
        MicSeatScene r1 = this.b;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_LARGE;
        int r3 = 2131169246;
        if (r1 != r2) goto L10;
        int r4 = 2131169249;
    L11:
        int r5 = s1.j(r4);
        if (this.b != r2) goto L14;
        r3 = 2131169249;
    L14:
        a1.w(r0, r10, r5, s1.j(r3));
        goto L15
    L10:
        r4 = 2131169246;
    L15:
        v(r7.l);
        w();
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        s((MultiLinkPreOnlineViewBinder.a) r1, r2, r3);
    }

    public void s(MultiLinkPreOnlineViewBinder.a r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.h = r1;
    }
}
