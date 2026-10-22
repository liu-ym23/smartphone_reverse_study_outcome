package gs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.obric.oui.tab.OTabLayoutBase;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f17174b;

    public a(LynxBaseScrollView r5) {
        this.f17173a = 1;
        this.f17174b = r5;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r10) {
        FrameLayout r11 = this.f17174b;
        switch(this.f17173a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        int r12 = r10.getAction();
        OTabLayoutBase r13 = (OTabLayoutBase) r11;
        if (r12 == 0) goto L13;
        if (r12 != 1) goto L10;
    L12:
        FastOutSlowInInterpolator r14 = OTabLayoutBase.F0;
        r13.getClass();
        r13.postInvalidate();
        return false;
    L10:
        if (r12 == 3) goto L12;
        return false;
    L13:
        FastOutSlowInInterpolator r15 = OTabLayoutBase.F0;
        r13.getClass();
        r13.postInvalidate();
        return false;
    L5:
        return !((LynxBaseScrollView) r11).f;
    }

    public a(OTabLayoutBase r5, int r10) {
        this.f17173a = 0;
        this.f17174b = r5;
    }
}
