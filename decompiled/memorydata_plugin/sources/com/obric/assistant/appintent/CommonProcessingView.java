package com.obric.assistant.appintent;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.obric.memorydata.memory.ui.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/appintent/CommonProcessingView;", "Landroid/opengl/GLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "render", "Lcom/obric/memorydata/memory/ui/animation/CommonProcessingRender;", "show", "", "hide", "onEnd", "Lkotlin/Function0;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonProcessingView extends GLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f6931a;

    public CommonProcessingView(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        super(r12, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin"));
        getHolder().setFormat(-2);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setPreserveEGLContextOnPause(true);
        c r0 = new c(r12);
        this.f6931a = r0;
        setRenderer((GLSurfaceView.Renderer) ZeusTransformUtils.preCheckCast(r0, GLSurfaceView.Renderer.class, "com.obric.memorydata.plugin"));
        setRenderMode(1);
    }

    public /* synthetic */ CommonProcessingView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private static final void a(CommonProcessingView r0) {
        r0.f6931a.a();
    }

    private static final void a(CommonProcessingView r2, Function0 r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        r2.f6931a.a(r4);
    }

    /* JADX INFO: renamed from: lambda$QK0gGIed_-W_EEF4DVRE0WkSwXM, reason: not valid java name */
    public static /* synthetic */ void m366lambda$QK0gGIed_W_EEF4DVRE0WkSwXM(CommonProcessingView r0, Function0 r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$m7SRuVEL1H2e9XexbKvyrH-lvD4, reason: not valid java name */
    public static /* synthetic */ void m367lambda$m7SRuVEL1H2e9XexbKvyrHlvD4(CommonProcessingView r0) {
        a(r0);
    }

    public final void a() {
        queueEvent(new $$Lambda$CommonProcessingView$m7SRuVEL1H2e9XexbKvyrHlvD4(this));
    }

    public final void a(Function0<Unit> r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        queueEvent(new $$Lambda$CommonProcessingView$QK0gGIed_W_EEF4DVRE0WkSwXM(this, r4));
    }
}
