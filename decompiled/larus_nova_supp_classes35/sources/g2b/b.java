package g2b;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class b implements TimeInterpolator {
    public /* synthetic */ b() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r6) {
        if (r6 > 0.5d) goto L6;
        return 0.0f;
    L6:
        return (r6 * 2.0f) - 1.0f;
    }
}
