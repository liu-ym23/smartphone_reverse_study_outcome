package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import ec2.k1;
import ec2.t;
import ec2.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/DanmakuRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DanmakuRenderEngineView extends RenderEngineView {
    public RenderRequest h;
    public final boolean i;
    public final boolean j;
    public long k;
    public long l;
    public int m;

    public static final class a {
    }

    static {
    }

    public DanmakuRenderEngineView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DanmakuRenderEngineView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean k() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.i == false) goto L6;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L17;
        if (r6.getAction() != 0) goto L17;
        final float r0 = r6.getX();
        final float r1 = r6.getY();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        RenderRequest r3 = this.h;
        if (r3 == null) goto L8;
        r3.a(new DanmakuRenderEngineView$findClickableItem$1(r0, r1, r2));
    L8:
        tc2.d r4 = (tc2.d) r2.element;
        if (r4 == null) goto L17;
        r4.onClick(this);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        ALogger.e("DanmakuRenderEngineView", e);
        return true;
    L17:
        return super/*android.view.View*/.onTouchEvent(r6);
    }

    public final void g(final Canvas r8, RenderRequest r9) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        Intrinsics.checkNotNullParameter(r9, "request");
        this.m++;
        if (this.k <= 0) goto L7;
        long r4 = this.l + (System.currentTimeMillis() - this.k);
        this.l = r4;
        if (r4 < 1000) goto L7;
        this.l = 0;
        com.bytedance.android.livesdk.interactivity.utils.j.a.debug("DanmakuRender", "一秒刷新 " + this.m + " 帧");
        this.m = 0;
    L7:
        this.k = System.currentTimeMillis();
        r9.a(new DanmakuRenderEngineView$render$1(this, r8));
        this.h = r9;
    }

    public DanmakuRenderEngineView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = ((Boolean) t.a.getValue()).booleanValue();
        this.j = ((Boolean) u.a.getValue()).booleanValue();
        ((Boolean) k1.a.getValue()).booleanValue();
    }

    public /* synthetic */ DanmakuRenderEngineView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
