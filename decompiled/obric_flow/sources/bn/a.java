package bn;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.TextureView;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.canvas.LynxHeliumCanvas;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f962b;

    public a(Context r5) {
        super(r5);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (getParent() == null) goto L5;
        getParent().requestDisallowInterceptTouchEvent(this.f962b);
    L7:
        return super.dispatchTouchEvent(r5);
    L5:
        LynxLog.b(4, "LynxHeliumCanvasView", "requestDisallowInterceptTouchEvent failed, parent is null.");
        goto L7
    }

    public LynxHeliumCanvas getCanvasUI() {
        WeakReference r5 = this.f961a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (LynxHeliumCanvas) r5.get();
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        if (r5 == null) goto L4;
        LynxLog.b(3, "LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setBackgroundDrawable(null);
    }

    public void setCanvasUI(LynxHeliumCanvas r5) {
        this.f961a = new WeakReference(r5);
    }

    public void setConsumeAllEvents(boolean r5) {
        this.f962b = r5;
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r5) {
        if (r5 == null) goto L4;
        LynxLog.b(3, "LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setForeground(null);
    }
}
