package kl;

import androidx.core.view.ViewCompat;
import com.gyf.barlibrary.BarHide;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18658c;
    public final BarHide d;
    public boolean e;
    public final HashMap f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f18661j;

    public b() {
        this.f18656a = 0;
        this.f18657b = ViewCompat.MEASURED_STATE_MASK;
        this.f18658c = ViewCompat.MEASURED_STATE_MASK;
        this.d = BarHide.FLAG_SHOW_BAR;
        this.e = false;
        this.f = new HashMap();
        this.g = 18;
        this.f18659h = true;
        this.f18660i = true;
        this.f18661j = true;
    }

    public final Object clone() {
        return (b) super.clone();
    L4:
        return null;
    }
}
