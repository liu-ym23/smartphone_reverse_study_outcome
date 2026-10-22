package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.view.View;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.PSInteractionMsgClickUtil;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ec2.p0;
import java.lang.ref.WeakReference;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<l4> implements o {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        IBaseUser r0 = this.b.getUser();
        String r1 = this.b.getActionContent();
        SpannableType r2 = SpannableType.NORMAL;
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.d(r0, r1, i0.a(2131107646), i0.a(2131107646), null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107646);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getUser(), null, false, this.e));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(tb2.c.DEFAULT_TEXT));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getActionContent()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r5) {
        Lazy r0 = PSInteractionMsgClickUtil.a;
        boolean r1 = this.e;
        l4 r2 = this.b;
        if (r1 == true) goto L30;
        if (r2 == null) goto L30;
        if (((Boolean) PSInteractionMsgClickUtil.a.getValue()).booleanValue() == false) goto L30;
        if (PSInteractionMsgClickUtil.c(r5) == false) goto L30;
        if (PSInteractionMsgClickUtil.a(r2) == false) goto L17;
        if (((fc2.h) PSInteractionMsgClickUtil.d.getValue()).b() == false) goto L30;
        boolean r3 = PSInteractionMsgClickUtil.e(r2.getOrInitPublicAreaCommon().getDefaultClickSchemaUrl());
    L31:
        if (r3 == false) goto L40;
        if (PSInteractionMsgClickUtil.a(this.b) == false) goto L36;
        PSInteractionMsgClickUtil.f("follow", "others", this.e);
    L38:
        return true;
    L36:
        if (PSInteractionMsgClickUtil.d(this.b) == false) goto L38;
        PSInteractionMsgClickUtil.f("share", "others", this.e);
        goto L38
    L40:
        return super.E(r5);
    L17:
        if (PSInteractionMsgClickUtil.d(r2) == false) goto L30;
        if (((fc2.h) PSInteractionMsgClickUtil.d.getValue()).d() == false) goto L30;
        if (((Boolean) p0.a.getValue()).booleanValue() == false) goto L28;
        RxBusAbility r4 = RxBusAbility.INSTANCE;
        if (r5 == null) goto L26;
        DataCenter r6 = r5.getDataCenter();
    L27:
        r4.getRxBus(r6).post(new pt2.a("screen_msg_area"));
    L29:
        r3 = true;
        goto L31
    L26:
        r6 = null;
        goto L27
    L28:
        xs2.b.a().post(new pt2.a("screen_msg_area"));
    L30:
        r3 = false;
        goto L31
    }

    public h0(l4 r1, MessageSceneType r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r1, ReportObject r2, boolean r3) {
        if (PSInteractionMsgClickUtil.a(this.b) == false) goto L6;
        PSInteractionMsgClickUtil.f("follow", "audience_name", this.e);
    L9:
        return super.E(null);
    L6:
        if (PSInteractionMsgClickUtil.d(this.b) == false) goto L9;
        PSInteractionMsgClickUtil.f("share", "audience_name", this.e);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void H(View r2, g52.c r3, TextMessageRenderViewHolder r4, WeakReference r5) {
        l4 r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        J("none");
        return;
    L12:
        super.H(r2, r3, r4, r5);
        return;
    L5:
        if (r0.getOrInitPublicAreaCommon().getForbidProfile() == true) goto L8;
        r1 = false;
        goto L9
    }
}
