package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.config.kb0;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        f2.g();
        Map r0 = vm2.d.M0().c();
        int r1 = 27;
        if (r0 != null) goto L5;
    L10:
        int r3 = 27;
    L12:
        if (vm2.d.T0() == true) goto L14;
        return;
    L14:
        if (this.f == r3) goto L18;
        ALogger.i("MultiLinkCommonVoiceFeedPreview", "loadLayoutConfigFailed try to load 1v8, uiLayout=" + r10.a + ", traceInfo=" + r10.c.a);
        MultiLinkCommonVoiceFeedPreview r2 = this.a;
        r2.b2 = 3;
        r2.V1 = r3;
        MultiLinkCommonVoiceFeedPreview.S(r2, r3, 3, true, true, null, 16);
        return;
    L18:
        return;
    L5:
        if (r0.containsKey(Integer.valueOf(r10.a)) != true) goto L10;
        Integer r4 = (Integer) r0.get(Integer.valueOf(r10.a));
        if (r4 == null) goto L9;
        r1 = r4.intValue();
    L9:
        r3 = r1;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r9, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "response");
        r10.a.c = this.b;
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(MultiLinkCommonVoiceFeedPreview.x(this.a), "MultiLinkCommonVoiceFeedPreview", this.a.hashCode(), "onSuccess: spendTime = " + (System.currentTimeMillis() - this.c) + ", targetUILayout = " + this.d + ", trace = " + r9.c.a, false, 8, null);
        this.a.d0(r10.a);
        if (this.e == true) goto L5;
        return;
    L5:
        if (((Boolean) kb0.a.getValue()).booleanValue() == false) goto L14;
        this.a.R();
        MultiLinkCommonVoiceFeedPreview r11 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12 = r11.d;
        if (r12 == null) goto L9;
        r11.g0(null, r12);
    L9:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r13 = this.a.getDynamicWidget();
        if (r13 == null) goto L15;
        r13.onViewHolderSelected();
        return;
    L15:
        return;
    }

    public s(MultiLinkCommonVoiceFeedPreview r1, boolean r2, long r3, int r5, boolean r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
