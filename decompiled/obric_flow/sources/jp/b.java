package jp;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RunMode f18404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RepeatMode f18405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f18406c;
    public WeakReference d;
    public long e;
    public int f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18408i;

    public final void a(boolean r5) {
        WeakReference r10 = this.d;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        Iterator r11 = this.f18406c.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((fp.a) r11.next()).b(false, false, r5);
        goto L7
    L9:
        this.e = 0;
        this.f = -1;
        this.g = 1.0f;
        this.f18407h = 0;
    }
}
