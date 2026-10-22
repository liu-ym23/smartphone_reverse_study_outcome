package com.larus.bmhome.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.mainbot.impl.databinding.LarusDeepThinkHeaderVideoBgBinding;
import com.larus.utils.logger.FLogger;
import j19.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import po8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0019J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/view/DeepThinkHeaderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoSurface", "Landroid/view/Surface;", "tag", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepThinkHeaderVideoBgBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusDeepThinkHeaderVideoBgBinding;", "binding$delegate", "Lkotlin/Lazy;", MusicAppletPage.KEY_PATH, "Landroid/graphics/Path;", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "showFrame", "", "frame", "play", "video", "Lcom/larus/bmhome/chat/view/DeepThinkVideoDiskExt$VoiceVideo;", "tryInitVideoController", "initSurfaceView", "textureView", "Landroid/view/TextureView;", "release", "pause", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkHeaderVideoView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Lazy b;
    public final Path c;

    public static final class a {
    }

    static {
    }

    public DeepThinkHeaderVideoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepThinkHeaderVideoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusDeepThinkHeaderVideoBgBinding getBinding() {
        return (LarusDeepThinkHeaderVideoBgBinding) this.b.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        int r1 = getMeasuredWidth();     // Catch: Throwable -> L5
        int r2 = getMeasuredHeight();     // Catch: Throwable -> L5
        float r9 = c.c(16);     // Catch: Throwable -> L5
        this.c.reset();     // Catch: Throwable -> L5
        this.c.addRoundRect(0.0f, 0.0f, r1, r2, r9, r9, Path.Direction.CW);     // Catch: Throwable -> L5
        r12.clipPath(this.c);     // Catch: Throwable -> L5
        super.dispatchDraw(r12);     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L14;
        FLogger.a.e(this.a, "dispatchDraw failed:" + r14);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public DeepThinkHeaderVideoView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "TextSourceVideoView-" + hashCode();
        this.b = LazyKt.lazy(new f(r2, this));
        this.c = new Path();
    }

    public /* synthetic */ DeepThinkHeaderVideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
