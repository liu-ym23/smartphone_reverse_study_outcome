package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import hd0.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkDynamicFloatEmptyMicSeatBasicLayer extends jg0.a<MultiLinkNormalEmptyViewBinder.a> {
    public MultiLinkNormalEmptyViewBinder.a e;
    public ViewGroup f;
    public ViewGroup g;
    public ImageView h;
    public TextView i;
    public final int j;

    public static final class a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 2131566600;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkDynamicFloatWindowEmptyLayer.name();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super.a(r6);
        this.f = (ViewGroup) q().findViewById(2131389538);
        this.g = (ViewGroup) q().findViewById(2131389537);
        this.h = (ImageView) q().findViewById(2131389534);
        this.i = (TextView) q().findViewById(2131389541);
        ViewGroup r7 = this.g;
        if (r7 == null) goto L6;
        r7.setBackgroundColor(ColorProtector.parseColor("#80161823"));
    L6:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L8;
    L10:
        com.bytedance.live.datacontext.m r8 = m.i().getRoom();
        if (r8 == null) goto L27;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L27;
        Map r10 = r9.getAnchorABMap();
        if (r10 == null) goto L27;
        if (r10.containsKey("linkmic_video_equal_enlarge_full") != true) goto L27;
        com.bytedance.live.datacontext.m r11 = m.i().getRoom();
        if (r11 == null) goto L23;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L23;
        String r13 = r12.getAnchorAbValue("linkmic_video_equal_enlarge_full");
    L25:
        if (Intrinsics.areEqual(r13, "1") == false) goto L27;
    L28:
        ViewGroup r14 = this.g;
        if (r14 == null) goto L33;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L33;
        r15.width = -1;
    L33:
        int r16 = this.j;
        if (r16 != 109) goto L36;
    L39:
        TextView r17 = this.i;
        if (r17 == null) goto L42;
        r17.setTextSize(9.0f);
    L42:
        ImageView r18 = this.h;
        if (r18 == null) goto L48;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L48;
        r19.width = UtilityKotlinExtentionsKt.i(8);
        r19.height = UtilityKotlinExtentionsKt.i(8);
    L48:
        if (this.j != 7) goto L59;
        xg0.a r20 = this.c;
        if (r20 != null) goto L52;
        return;
    L52:
        if (r20.getFeedType() != 5) goto L61;
        ImageView r21 = this.h;
        if (r21 == null) goto L62;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L63;
        r22.width = UtilityKotlinExtentionsKt.i(5);
        r22.height = UtilityKotlinExtentionsKt.i(5);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L59:
        return;
    L36:
        if (r16 == 111) goto L39;
        if (r16 != 15) goto L48;
    L23:
        r13 = null;
    L27:
        if (((Number) d.S5.getValue(null, d.a[354(0x162, float:4.96E-43)])).intValue() != 1) goto L33;
    L8:
        if (c.f().h() == true) goto L10;
        i0 r23 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.M(-1);
        goto L10
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(n()) == false) goto L5;
        return;
    L5:
        if (n() == 0) goto L11;
        TextView r3 = this.i;
        if (r3 == null) goto L12;
        r3.setTextSize(6.0f);
        return;
    L12:
        return;
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    public final void r(MultiLinkNormalEmptyViewBinder.a r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        this.e = r5;
        if (n() != 0) goto L7;
        ViewGroup r7 = this.g;
        if (r7 == null) goto L7;
        r7.setOnClickListener(x0.a(new MultiLinkDynamicFloatEmptyMicSeatBasicLayer$onBind$1(this)));
    L7:
        ViewGroup r8 = this.g;
        if (r8 == null) goto L10;
        r8.setBackgroundColor(ColorProtector.parseColor("#80161823"));
    L10:
        MultiLinkNormalEmptyViewBinder.a r9 = this.e;
        k r10 = null;
        if (r9 == null) goto L13;
        IVoiceLiveTheme r0 = r9.c;
    L14:
        if (r9 == null) goto L16;
        int r11 = r9.b();
    L17:
        boolean r1 = false;
        if (r11 < 0) goto L33;
        if (r0 == null) goto L23;
        List r2 = r0.getIconMicNormals();
        if (r2 == null) goto L23;
        int r3 = r2.size();
    L24:
        if (r11 >= r3) goto L33;
        if (r0 == null) goto L30;
        List r4 = r0.getIconMicNormals();
        if (r4 == null) goto L30;
        r10 = (k) ListProtector.get(r4, r11);
    L30:
        if (IVoiceLiveTheme.Companion.isImageModelValid(r10) == false) goto L33;
        if (r10 == null) goto L33;
        ImageUtil.loadImage(this.h, r10, 0);
    L23:
        r3 = 0;
    L33:
        ImageView r12 = this.h;
        if (r12 == null) goto L36;
        r12.setImageResource(2131251694);
    L36:
        TextView r13 = this.i;
        if (r13 != null) goto L39;
    L56:
        if (r0 == null) goto L71;
        String r14 = r0.getColorMicText();
        if (r14 != null) goto L60;
        return;
    L60:
        if (r14.length() <= 0) goto L62;
        r1 = true;
    L62:
        if (r1 != true) goto L73;
        TextView r15 = this.i;     // Catch: Exception -> L67
        if (r15 == null) goto L74;
        r15.setTextColor(Color.parseColor(r0.getColorMicText()));     // Catch: Exception -> L67
        return;
    L74:
        return;
    L67:
        ALogger.e("DynamicFloatEmptyMicSeatBasicLayer", "set color mic failed, color is " + r0.getColorMicText());
        return;
    L73:
        return;
    L71:
        return;
    L39:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L41;
        String r16 = s1.B(2131919823);
    L55:
        r13.setText(r16);
        goto L56
    L41:
        MultiLinkNormalEmptyViewBinder.a r17 = this.e;
        if (r17 != null) goto L44;
    L46:
        MultiLinkNormalEmptyViewBinder.a r18 = this.e;
        if (r18 == null) goto L52;
        if (r18.h() != true) goto L52;
        r16 = s1.B(2131919823);
    L52:
        if (d.f0() != 0) goto L54;
        r16 = s1.B(2131919228);
        goto L55
    L54:
        r16 = s1.B(2131919833);
        goto L55
    L44:
        if (r17.g() != true) goto L46;
        r16 = s1.B(2131919824);
        goto L55
    L16:
        r11 = -1;
        goto L17
    L13:
        r0 = null;
        goto L14
    }

    public MultiLinkDynamicFloatEmptyMicSeatBasicLayer(MicSeatScene r2, int r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.j = r3;
    }

    @Override // jg0.f
    public final void k(Object r2, int r3, Bundle r4) {
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r2;
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        r(r5, r3);
    }
}
