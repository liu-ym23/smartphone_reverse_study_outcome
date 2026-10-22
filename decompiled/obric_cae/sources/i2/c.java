package i2;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f8101b;

    public c(b r8, Window.Callback r10) {
        this.f8101b = r8;
        super(r10);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r8) {
        b r10 = this.f8101b;
        if (r10.f8095f == true) goto L6;
        r10.f8091b.a(r8.getEventTime());
    L6:
        return this.f8135a.dispatchKeyEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        b r10 = this.f8101b;
        if (r10.f8095f == true) goto L6;
        r10.f8091b.a(r8.getEventTime());
    L6:
        return this.f8135a.dispatchTouchEvent(r8);
    }
}
