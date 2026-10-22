package v70;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements a {
    public final View a;

    @Override // v70.a
    public final ViewPropertyAnimator a() {
        return this.a.animate();
    }

    @Override // v70.a
    public final int getVisibility() {
        return this.a.getVisibility();
    }

    @Override // v70.a
    public final int getWidth() {
        return this.a.getWidth();
    }

    @Override // v70.a
    public final View getView() {
        return this.a;
    }

    public c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }

    @Override // v70.a
    public final void setAlpha(float r2) {
        this.a.setAlpha(r2);
    }

    @Override // v70.a
    public final void setTranslationY(float r2) {
        this.a.setTranslationY(r2);
    }

    @Override // v70.a
    public final void setVisibility(int r2) {
        this.a.setVisibility(r2);
    }

    @Override // v70.a
    public final void setX(float r2) {
        this.a.setX(r2);
    }

    @Override // v70.a
    public final void b(int r2, int r3, int r4, int r5) {
        UIUtils.updateLayoutMargin(this.a, r2, r3, r4, r5);
    }
}
