package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import hd0.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkDynamicFloatEmptyMicSeatBasicLayerOld extends jg0.a<MultiLinkNormalEmptyViewBinder.a> {
    public MultiLinkNormalEmptyViewBinder.a e;
    public ViewGroup f;
    public HSImageView g;
    public View h;
    public ImageView i;
    public TextView j;

    public static final class a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 2131566601;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkDynamicFloatWindowEmptyLayerOld.name();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.a(r4);
        this.f = (ViewGroup) q().findViewById(2131389538);
        this.g = q().findViewById(2131389536);
        this.h = q().findViewById(2131389539);
        this.i = (ImageView) q().findViewById(2131389534);
        this.j = (TextView) q().findViewById(2131389541);
        HSImageView r5 = this.g;
        if (r5 == null) goto L5;
        r5.setBackgroundColor(ColorProtector.parseColor("#322542"));
    L5:
        HSImageView r6 = this.g;
        if (r6 == null) goto L12;
        ConstraintLayout.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L11;
        int r2 = s1.f(28.0f);
        ((ViewGroup.MarginLayoutParams) r7).height = r2;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        View r8 = this.h;
        if (r8 == null) goto L20;
        ConstraintLayout.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L18;
        int r0 = s1.f(28.0f);
        ((ViewGroup.MarginLayoutParams) r9).height = r0;
        goto L20
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L22;
        return;
    L22:
        if (c.f().h() == true) goto L26;
        i0 r10 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.M(-1);
        return;
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(n()) == false) goto L5;
        return;
    L5:
        if (n() == 0) goto L11;
        TextView r3 = this.j;
        if (r3 == null) goto L12;
        r3.setTextSize(6.0f);
        return;
    L12:
        return;
    }

    public MultiLinkDynamicFloatEmptyMicSeatBasicLayerOld(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    public final void r(MultiLinkNormalEmptyViewBinder.a r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        this.e = r5;
        if (n() != 0) goto L7;
        HSImageView r7 = this.g;
        if (r7 == null) goto L7;
        r7.setOnClickListener(x0.a(new MultiLinkDynamicFloatEmptyMicSeatBasicLayerOld$onBind$1(this)));
    L7:
        int r8 = o00.a.a;
        o00.a.a(this.g);
        View r9 = this.h;
        k r10 = null;
        if (r9 == null) goto L10;
        r9.setBackground(null);
    L10:
        MultiLinkNormalEmptyViewBinder.a r11 = this.e;
        if (r11 == null) goto L13;
        IVoiceLiveTheme r12 = r11.c;
    L14:
        ImageView r0 = this.i;
        if (r0 == null) goto L17;
        r0.setImageResource(2131251693);
    L17:
        MultiLinkNormalEmptyViewBinder.a r1 = this.e;
        if (r1 == null) goto L20;
        int r2 = r1.b();
    L21:
        boolean r3 = false;
        if (r2 < 0) goto L37;
        if (r12 == null) goto L27;
        List r4 = r12.getIconMicNormals();
        if (r4 == null) goto L27;
        int r13 = r4.size();
    L28:
        if (r2 >= r13) goto L37;
        if (r12 == null) goto L34;
        List r14 = r12.getIconMicNormals();
        if (r14 == null) goto L34;
        r10 = (k) ListProtector.get(r14, r2);
    L34:
        if (IVoiceLiveTheme.Companion.isImageModelValid(r10) == false) goto L37;
        if (r10 == null) goto L37;
        ImageUtil.loadImage(this.i, r10, 0);
    L27:
        r13 = 0;
    L37:
        TextView r15 = this.j;
        if (r15 != null) goto L40;
    L54:
        if (r12 == null) goto L69;
        String r16 = r12.getColorMicText();
        if (r16 != null) goto L58;
        return;
    L58:
        if (r16.length() <= 0) goto L60;
        r3 = true;
    L60:
        if (r3 != true) goto L71;
        TextView r17 = this.j;     // Catch: Exception -> L65
        if (r17 == null) goto L72;
        r17.setTextColor(Color.parseColor(r12.getColorMicText()));     // Catch: Exception -> L65
        return;
    L72:
        return;
    L65:
        ALogger.e("DynamicFloatEmptyMicSeatBasicLayer", "set color mic failed, color is " + r12.getColorMicText());
        return;
    L71:
        return;
    L69:
        return;
    L40:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L42;
        String r18 = s1.B(2131919823);
    L53:
        r15.setText(r18);
        goto L54
    L42:
        MultiLinkNormalEmptyViewBinder.a r19 = this.e;
        if (r19 != null) goto L45;
    L47:
        MultiLinkNormalEmptyViewBinder.a r20 = this.e;
        if (r20 != null) goto L50;
    L52:
        r18 = s1.B(2131919833);
        goto L53
    L50:
        if (r20.h() != true) goto L52;
        r18 = s1.B(2131919823);
        goto L53
    L45:
        if (r19.g() != true) goto L47;
        r18 = s1.B(2131919824);
        goto L53
    L20:
        r2 = -1;
        goto L21
    L13:
        r12 = null;
        goto L14
    }

    @Override // jg0.f
    public final void k(Object r2, int r3, Bundle r4) {
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r2;
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        r(r5, r3);
    }
}
