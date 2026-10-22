package jr;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends l {
    public final /* synthetic */ int f;

    public /* synthetic */ h(int r5) {
        this.f = r5;
    }

    @Override // jr.l
    public final void c(View r5, float r10) {
        switch(this.f) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
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
        r5.setPivotY(a(r10));
        return;
    L22:
        r5.setPivotX(a(r10));
        return;
    L24:
        r5.setElevation(a(r10));
        return;
    L26:
        r5.setAlpha(a(r10));
    }
}
