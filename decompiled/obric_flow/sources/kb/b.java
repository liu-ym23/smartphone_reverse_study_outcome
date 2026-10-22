package kb;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18630c;
    public long d;
    public String e;
    public long f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Uri f18632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f18634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18635l;

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BdMediaItem{id=");
        r5.append(this.f18628a);
        r5.append(", name='");
        r5.append(this.f18629b);
        r5.append("', modify=");
        r5.append(this.f18630c);
        r5.append(", dateAdded=");
        r5.append(this.d);
        r5.append(", mimeType='");
        r5.append(this.e);
        r5.append("', duration=0, fileSize=");
        r5.append(this.f);
        r5.append(", width=");
        r5.append(this.g);
        r5.append(", height=");
        r5.append(this.f18631h);
        r5.append(", musicType=0, uri=");
        r5.append(this.f18632i);
        r5.append(", relativePath='");
        r5.append(this.f18633j);
        r5.append("', dateToken=");
        r5.append(this.f18634k);
        r5.append(", orientation=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.f18635l, ", resolution='null', album='null', artist='null', title='null', albumId=0}");
    }
}
