package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService;
import com.bytedance.salamander.anniex.r3;
import com.bytedance.salamander.anniex.s3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<no name provided>", "", "login", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$fetchHistory$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function0 $generateHistoryUrl;
    final /* synthetic */ e $globalData;
    final /* synthetic */ f0 $props;
    final /* synthetic */ Function1 $setEnableLiveHistory;
    final /* synthetic */ Function1 $setHistoryExtraData;
    final /* synthetic */ Function1 $setHistoryList;

    public MainpageDrawerRefreshViewKt$LiveDrawerMainRefreshView$1$fetchHistory$1(e r1, f0 r2, Function1 r3, Function0 r4, Function1 r5, Function1 r6) {
        this.$globalData = r1;
        this.$props = r2;
        this.$setEnableLiveHistory = r3;
        this.$generateHistoryUrl = r4;
        this.$setHistoryList = r5;
        this.$setHistoryExtraData = r6;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Boolean) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean r5) {
        e r0 = this.$globalData;
        boolean r1 = false;
        if (r0 == null) goto L13;
        Function0<? extends r3> r2 = r0.d;
        if (r2 == null) goto L13;
        r3 r3 = (r3) r2.invoke();
        if (r3 == null) goto L13;
        s3 r4 = r3.b;
        if (r4 == null) goto L13;
        Boolean r6 = r4.a;
        if (r6 == null) goto L13;
        boolean r7 = r6.booleanValue();
    L14:
        if (r7 == true) goto L18;
        if (r5 == null) goto L17;
        r1 = r5.booleanValue();
    L17:
        if (r1 == true) goto L18;
        return;
    L18:
        Long r8 = this.$props.b.getType();
        long r9 = LiveDrawerLiveFeedTabType.Recommend.getValue();
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.longValue() != r9) goto L28;
        int r10 = p30.e.a;
        IIESLiveRTSJSBService r11 = jc1.k.f(IIESLiveRTSJSBService.class);
        if (r11 == null) goto L30;
        r11.getEnableLiveHistoryRTS(new p30.h(), new AnonymousClass1(this));
        return;
    L30:
        return;
    L28:
        return;
    L13:
        r7 = false;
        goto L14
    }
}
