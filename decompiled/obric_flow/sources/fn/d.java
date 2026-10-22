package fn;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16951b;

    public /* synthetic */ d(boolean r5, int r10) {
        this.f16950a = r10;
        this.f16951b = r5;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r10) {
        switch(this.f16950a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return !this.f16951b;
    L7:
        return !this.f16951b;
    }
}
