package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.v;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends com.bytedance.android.live.revenuelink.connect.d {
    public final /* synthetic */ MultiRTCBizComponent a;

    public n(MultiRTCBizComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void Tg(int r6, i6 r7, ey.l r8) {
        Intrinsics.checkNotNullParameter(r7, "linkerMessage");
        Intrinsics.checkNotNullParameter(r7, "linkerMessage");
        i6 r9 = r7.castTo(i6.class);
        k6 r10 = r9.getReply();
        if (r10 != null) goto L5;
        return;
    L5:
        if (((int) r10.getReplyStatus()) != 1) goto L43;
        b7 r12 = r10.getMultiChannelInfo();
        if (r12 != null) goto L10;
    L28:
        com.bytedance.live.datacontext.m<String> r13 = this.a.p.getConnectionSubType();
        int r14 = (int) r10.getMatchType();
        if (r14 != 4) goto L31;
        String r15 = "random_nlink";
    L40:
        r13.setValue(r15);
        return;
    L31:
        if (r14 != 11) goto L33;
    L38:
        r15 = "random_individual";
        goto L40
    L33:
        if (r14 != 6) goto L35;
        r15 = "random_npk";
        goto L40
    L35:
        if (r14 == 7) goto L38;
        r15 = "manual_nlink";
        goto L40
    L10:
        if (r12.getUseMultiChannel() == false) goto L28;
        Map r1 = r12.getChannelMap();
        if (r1 == null) goto L28;
        if ((!r1.isEmpty()) != true) goto L28;
        MultiRTCBizComponent r0 = this.a;
        if (r0.e == true) goto L27;
        MultiAnchorLinkContext r2 = r0.p;
        k6 r16 = r9.getReply();
        if (r16 == null) goto L20;
        b7 r17 = r16.getMultiChannelInfo();
    L21:
        MultiAnchorLinkContext.setMultiChannelInfo$default(r2, r17, false, 2, null);
        Map<Long, String> r18 = r12.getChannelMap();
        if (r18 == null) goto L24;
        MultiRTCBizComponent r19 = this.a;
        r19.k.a1(r18, "onReceiveReply", String.valueOf(r19.getContext().G()));
    L24:
        UnexpectedFrameMonitor r20 = this.a.k();
        if (r20 == null) goto L27;
        r20.o("onReceiveReply");
        goto L27
    L20:
        r17 = null;
    L27:
        this.a.f.b("onReceiveReply");
        goto L28
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void Jd(d11.f r3, v r4, long r5, ey.l r7) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "_permitData");
        super.Jd(r3, r4, r5, r7);
        v r6 = r4.castTo(v.class);
        if (r3.c == 1) goto L5;
        return;
    L5:
        b7 r8 = r6.getMultiChannelInfo();
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.getUseMultiChannel() == false) goto L24;
        Map r9 = r8.getChannelMap();
        if (r9 != null) goto L12;
        return;
    L12:
        if ((!r9.isEmpty()) != true) goto L26;
        MultiRTCBizComponent r10 = this.a;
        if (r10.e == true) goto L21;
        MultiAnchorLinkContext.setMultiChannelInfo$default(r10.p, r6.getMultiChannelInfo(), false, 2, null);
        Map<Long, String> r12 = r8.getChannelMap();
        if (r12 == null) goto L18;
        MultiRTCBizComponent r13 = this.a;
        r13.k.a1(r12, "permitSuccess", String.valueOf(r13.getContext().G()));
    L18:
        UnexpectedFrameMonitor r14 = this.a.k();
        if (r14 == null) goto L21;
        r14.o("permitSuccess");
    L21:
        this.a.f.b("permitSuccess");
        return;
    L26:
        return;
    }
}
