package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveMoreBgView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveMoreBgView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f6919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f6920b;

    /* JADX WARN: Multi-variable type inference failed */
    public ProactiveMoreBgView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public ProactiveMoreBgView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.f6919a = new Paint(1);
        this.f6920b = new Path();
    }

    public /* synthetic */ ProactiveMoreBgView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    @Override // android.view.View
    public void onDraw(Canvas r23) {
        Intrinsics.checkNotNullParameter(r23, "canvas");
        super.onDraw(r23);
        float r2 = getWidth();
        float r3 = getHeight();
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        if (r3 <= 0.0f) goto L10;
        float r4 = r2 / 360.0f;
        float r5 = r3 / 61.0f;
        this.f6920b.reset();
        float r14 = r4 * 0.0f;
        float r15 = r5 * 16.9991f;
        this.f6920b.moveTo(r14, r15);
        float r17 = r5 * 0.0f;
        this.f6920b.cubicTo(r14, r15, r4 * 101.602f, r17, r4 * 180.107f, r17);
        float r16 = r4 * 258.613f;
        float r6 = r4 * 360.0f;
        this.f6920b.cubicTo(r16, r17, r6, r15, r6, r15);
        float r7 = 64.9992f * r5;
        this.f6920b.lineTo(r6, r7);
        this.f6920b.lineTo(r14, r7);
        this.f6920b.close();
        this.f6919a.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, r5 * 40.5321f, 0.0f, 0.0f, new int[]{0, -2130706433}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        r23.drawPath(this.f6920b, this.f6919a);
        return;
    }
}
