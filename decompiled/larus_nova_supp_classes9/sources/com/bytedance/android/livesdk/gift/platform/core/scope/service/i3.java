package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.message.model.n6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i3 implements com.bytedance.android.scope.o {
    public final List<n6> a;
    public boolean b;
    public boolean c;
    public final a d;

    public static final class a implements u02.a {
        public final /* synthetic */ i3 a;

        @Override // u02.a
        public final void onEnd() {
            i3 r0 = this.a;
            r0.b = false;
            r0.a();
        }

        @Override // u02.a
        public final void onStart() {
            this.a.b = true;
        }

        public a(i3 r1) {
            this.a = r1;
        }
    }

    public final void onStart() {
        this.c = true;
    }

    public final void onStop() {
        this.c = false;
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.n<PKBattlePropEffectWidget> r1 = r0.getPkBattlePropEffectWidget();
        if (r1 == null) goto L11;
        PKBattlePropEffectWidget r2 = (PKBattlePropEffectWidget) r1.getValue();
        if (r2 == null) goto L12;
        r2.c = null;
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void a() {
        int r1 = 0;
        if (((ArrayList) this.a).size() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (this.b == false) goto L10;
        return;
    L10:
        if (this.c == false) goto L163;
        Boolean r3 = null;
        if (((ArrayList) this.a).size() != 0) goto L15;
        n6 r2 = null;
    L17:
        if (r2 == null) goto L19;
        long r6 = r2.getBattleId();
    L21:
        if (r6 == 0) goto L30;
        if (r2 == null) goto L29;
        long r4 = r2.getBattleId();
        kc0.e r7 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService();
        if (r7 == null) goto L26;
        Long r8 = Long.valueOf(r7.getPkId());
    L28:
        if (r4 == r8.longValue()) goto L30;
        return;
    L26:
        r8 = null;
        goto L28
    L29:
        return;
    L30:
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L35;
        com.bytedance.live.datacontext.n<PKBattlePropEffectWidget> r9 = r5.getPkBattlePropEffectWidget();
        if (r9 == null) goto L35;
        PKBattlePropEffectWidget r10 = (PKBattlePropEffectWidget) r9.getValue();
    L36:
        if (r2 == null) goto L161;
        py.k r11 = r2.getAnimation();
        if (r11 == null) goto L162;
        if (r10 == null) goto L44;
        a r13 = this.d;
        Intrinsics.checkNotNullParameter(r13, "l");
        if (r10.c != null) goto L44;
        r10.c = r13;
    L44:
        if (r10 != null) goto L46;
    L133:
        Intrinsics.checkNotNullParameter(r2, "msg");
        HashMap r14 = new HashMap();
        com.bytedance.android.livesdk.revenue.service.user.a r15 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        if (r15 == null) goto L139;
        IBaseUser r16 = r15.b();
        if (r16 == null) goto L139;
        String r17 = iz.a.a(r16);
        if (r17 == null) goto L139;
    L140:
        r14.put("user_id", r17);
        if (r2.getReason() != 2) goto L144;
        String r18 = "high_money";
    L147:
        r14.put("get_type", r18);
        if (r2.getStatus() != 1) goto L150;
        String r19 = "1";
    L151:
        r14.put("is_get_buffer_card", r19);
        r14.put("prop_id", String.valueOf(r2.getId()));
        kc0.e r20 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService();
        if (r20 == null) goto L156;
        Map r21 = r20.h();
        if (r21 == null) goto L156;
        r14.putAll(r21);
    L156:
        mz0.n r23 = new mz0.n();
        Map r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r24.putAll(r14);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.PAGE_SOURCE_LOG);
        r25.b(LogCommon.ROOM);
        ((ArrayList) r23.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3("livesdk_connection_get_buffer_card_result_show", r23.a, r23.b);
        return;
    L150:
        r19 = "0";
        goto L151
    L144:
        if (r2.getReason() != 3) goto L146;
        r18 = "send_buff_card_gift";
        goto L147
    L146:
        r18 = "mvp";
    L139:
        r17 = BuildConfig.FLAVOR;
        goto L140
    L46:
        if (r2.getStatus() != 1) goto L48;
        boolean r28 = true;
    L49:
        Intrinsics.checkNotNullParameter(r11, "image");
        List r29 = r11.getUrls();
        if (r29 != null) goto L52;
    L57:
        String r30 = null;
    L58:
        if (r30 != null) goto L65;
        HSImageView r31 = r10.b;
        if (r31 == null) goto L62;
        r31.setVisibility(8);
    L62:
        u02.a r33 = r10.c;
        if (r33 == null) goto L133;
        r33.onEnd();
        goto L133
    L65:
        r10.g = r28;
        u02.a r34 = r10.c;
        if (r34 == null) goto L68;
        r34.onStart();
    L68:
        HSImageView r35 = r10.b;
        if (r35 == null) goto L71;
        r35.setVisibility(0);
    L71:
        HSImageView r36 = r10.b;
        if (r36 == null) goto L74;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
    L76:
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == true) goto L78;
        r37 = null;
    L78:
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (r38 == null) goto L109;
        r38.leftMargin = (com.bytedance.android.live.core.utils.s1.y() - r38.width) / 2;
        p11.h r39 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService();
        if (r39 == null) goto L83;
        RevPkState r40 = r39.d();
    L84:
        p11.e r41 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getMultiAnchorService();
        if (r41 == null) goto L90;
        p11.g r43 = r41.k();
        if (r43 == null) goto L90;
        r3 = Boolean.valueOf(r43.isMultiPk());
    L90:
        if (gd0.v.a(x12.b.a(), 4) == false) goto L97;
        if (r40 != RevPkState.PK) goto L94;
    L95:
        oq2.d r44 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService().G();
        int r45 = r44.a + r44.c;
    L108:
        r38.topMargin = r45 - (r38.height / 2);
        goto L109
    L94:
        if (r40 == RevPkState.PENAL) goto L95;
    L97:
        if (gd0.v.a(x12.b.a(), 64) == true) goto L99;
    L103:
        b03.a r46 = b03.a.a;
        float r47 = (com.bytedance.android.live.core.utils.s1.w() - com.bytedance.android.live.core.utils.s1.A()) * 0.6f;
        if (r47 < 0) goto L107;
        r1 = (int) r47;
    L107:
        r45 = r1;
        goto L108
    L99:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L103;
        gt1.b r48 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getMultiAnchorStatus();
        if (r48 == null) goto L107;
        r1 = r48.getBottom();
        goto L107
    L83:
        r40 = null;
    L109:
        HSImageView r49 = r10.b;
        if (r49 == null) goto L112;
        r49.setLayoutParams(r38);
    L112:
        HSImageView r50 = r10.b;
        if (r50 == null) goto L115;
        r50.setTranslationX(0.0f);
    L115:
        HSImageView r51 = r10.b;
        if (r51 == null) goto L118;
        r51.setTranslationY(0.0f);
    L118:
        HSImageView r53 = r10.b;
        if (r53 == null) goto L121;
        r53.setAlpha(1.0f);
    L121:
        HSImageView r54 = r10.b;
        if (r54 == null) goto L124;
        r54.setScaleX(1.0f);
    L124:
        HSImageView r55 = r10.b;
        if (r55 == null) goto L127;
        r55.setScaleY(1.0f);
    L127:
        AnimatedDrawable2 r56 = r10.d;
        if (r56 == null) goto L130;
        r56.stop();
    L130:
        HSImageView r57 = r10.b;
        if (r57 == null) goto L133;
        r57.setController(Fresco.newDraweeControllerBuilder().setUri(r30).setControllerListener(new u02.b(r10)).build());
        goto L133
    L74:
        r37 = null;
        goto L76
    L52:
        if ((!r29.isEmpty()) == true) goto L55;
        r29 = null;
    L55:
        if (r29 == null) goto L57;
        r30 = (String) ListProtector.get(r29, 0);
        goto L58
    L48:
        r28 = false;
        goto L49
    L162:
        return;
    L161:
        return;
    L35:
        r10 = null;
        goto L36
    L19:
        r6 = 0;
        goto L21
    L15:
        r2 = (n6) ListProtector.remove(this.a, 0);
        goto L17
    L163:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public i3() {
        this.a = new ArrayList();
        this.d = new a(this);
    }
}
