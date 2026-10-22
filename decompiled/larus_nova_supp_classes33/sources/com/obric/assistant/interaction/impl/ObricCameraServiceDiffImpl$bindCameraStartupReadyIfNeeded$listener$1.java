package com.obric.assistant.interaction.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/assistant/interaction/impl/ObricCameraServiceDiffImpl$bindCameraStartupReadyIfNeeded$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "o_camera_extension_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCameraServiceDiffImpl$bindCameraStartupReadyIfNeeded$listener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ String $attemptId;
    final /* synthetic */ View $decorView;
    final /* synthetic */ ViewTreeObserver $observer;
    final /* synthetic */ Ref.IntRef $reportAttempts;
    final /* synthetic */ ObricCameraServiceDiffImpl this$0;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        AssistantStartupTelemetry r0 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r0.i("camera_content_ready"), this.$attemptId) == true) goto L7;
        ObricCameraServiceDiffImpl r1 = this.this$0;
        ViewTreeObserver r2 = this.$observer;
        Intrinsics.checkNotNull(r2);
        ObricCameraServiceDiffImpl.access$removeCameraReadyListener(r1, r2, this);
        AtomicReference<String> r3 = uga.c.a;
        uga.c.a(this.$attemptId);
        return true;
    L7:
        if (this.$decorView.isShown() == true) goto L9;
    L20:
        return true;
    L9:
        if (this.$decorView.getAlpha() <= 0.0f) goto L20;
        if (this.$decorView.getWidth() <= 0) goto L20;
        if (this.$decorView.getHeight() <= 0) goto L20;
        IAssistantStartupTelemetry.a.b(r0, this.$attemptId);
        this.$reportAttempts.element++;
        if (IAssistantStartupTelemetry.a.c(r0, this.$attemptId, "camera_content_ready") == false) goto L18;
    L19:
        ObricCameraServiceDiffImpl r4 = this.this$0;
        ViewTreeObserver r5 = this.$observer;
        Intrinsics.checkNotNull(r5);
        ObricCameraServiceDiffImpl.access$removeCameraReadyListener(r4, r5, this);
        AtomicReference<String> r6 = uga.c.a;
        uga.c.a(this.$attemptId);
        goto L20
    L18:
        if (this.$reportAttempts.element < 3) goto L20;
        goto L19
    }

    public ObricCameraServiceDiffImpl$bindCameraStartupReadyIfNeeded$listener$1(String r1, ObricCameraServiceDiffImpl r2, ViewTreeObserver r3, View r4, Ref.IntRef r5) {
        this.$attemptId = r1;
        this.this$0 = r2;
        this.$observer = r3;
        this.$decorView = r4;
        this.$reportAttempts = r5;
    }
}
