package jr;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends g {
    public final /* synthetic */ int g;

    public /* synthetic */ c(int r5) {
        this.g = r5;
    }

    @Override // jr.g
    public final void e(View r5, float r10) {
        switch(this.g) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        r5.setTranslationZ(a(r10));
        return;
    L6:
        r5.setTranslationY(a(r10));
        return;
    L8:
        r5.setTranslationX(a(r10));
        return;
    L10:
        r5.setScaleY(a(r10));
        return;
    L12:
        r5.setScaleX(a(r10));
        return;
    L14:
        r5.setRotationY(a(r10));
        return;
    L16:
        r5.setRotationX(a(r10));
        return;
    L18:
        r5.setRotation(a(r10));
        return;
    L20:
        r5.setElevation(a(r10));
        return;
    L22:
        r5.setAlpha(a(r10));
    }
}
