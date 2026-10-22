package q;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f21423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f21424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21425c;

    public j(PointF r5, boolean r10, List r11) {
        this.f21424b = r5;
        this.f21425c = r10;
        this.f21423a = new ArrayList(r11);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ShapeData{numCurves=");
        r5.append(this.f21423a.size());
        r5.append("closed=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f21425c, '}');
    }

    public j() {
        this.f21423a = new ArrayList();
    }
}
