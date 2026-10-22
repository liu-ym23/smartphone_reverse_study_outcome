package com.obric.assistant.interaction.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/assistant/interaction/impl/ObricRealtimeCallExtServiceImpl$bindRealtimeCallStartupReadyIfNeeded$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallExtServiceImpl$bindRealtimeCallStartupReadyIfNeeded$listener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ String $attemptId;
    final /* synthetic */ View $decorView;
    final /* synthetic */ Ref.BooleanRef $firstFrameReported;
    final /* synthetic */ ViewTreeObserver $observer;
    final /* synthetic */ Ref.IntRef $reportAttempts;
    final /* synthetic */ ObricRealtimeCallExtServiceImpl this$0;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.$decorView.isShown() == true) goto L5;
    L23:
        return true;
    L5:
        if (this.$decorView.getAlpha() <= 0.0f) goto L23;
        if (this.$decorView.getWidth() <= 0) goto L23;
        if (this.$decorView.getHeight() <= 0) goto L23;
        Ref.BooleanRef r0 = this.$firstFrameReported;
        if (r0.element == true) goto L14;
        r0.element = true;
        IAssistantStartupTelemetry.a.b(AssistantStartupTelemetry.a, this.$attemptId);
    L14:
        AssistantStartupTelemetry r1 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r1.i("rtc_call_content_ready"), this.$attemptId) == true) goto L18;
        ObricRealtimeCallExtServiceImpl r2 = this.this$0;
        ViewTreeObserver r3 = this.$observer;
        Intrinsics.checkNotNull(r3);
        ObricRealtimeCallExtServiceImpl.access$removeRealtimeCallPreDrawListener(r2, r3, this);
        return true;
    L18:
        this.$reportAttempts.element++;
        if (IAssistantStartupTelemetry.a.c(r1, this.$attemptId, "rtc_call_content_ready") == false) goto L21;
    L22:
        ObricRealtimeCallExtServiceImpl r4 = this.this$0;
        ViewTreeObserver r5 = this.$observer;
        Intrinsics.checkNotNull(r5);
        ObricRealtimeCallExtServiceImpl.access$removeRealtimeCallPreDrawListener(r4, r5, this);
        goto L23
    L21:
        if (this.$reportAttempts.element < 3) goto L23;
        goto L22
    }

    public ObricRealtimeCallExtServiceImpl$bindRealtimeCallStartupReadyIfNeeded$listener$1(View r1, Ref.BooleanRef r2, String r3, ObricRealtimeCallExtServiceImpl r4, ViewTreeObserver r5, Ref.IntRef r6) {
        this.$decorView = r1;
        this.$firstFrameReported = r2;
        this.$attemptId = r3;
        this.this$0 = r4;
        this.$observer = r5;
        this.$reportAttempts = r6;
    }
}
