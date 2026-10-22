package d9;

import com.google.protobuf.DescriptorProtos;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f6961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6970l;

    public a() {
        this.f6959a = false;
        this.f6960b = true;
        this.f6961c = null;
        this.f6962d = 10;
        this.f6963e = 3;
        this.f6964f = 3;
        this.f6965g = 10;
        this.f6966h = 3;
        this.f6967i = 3;
        this.f6968j = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
        this.f6969k = 120;
        this.f6970l = null;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder(" localEnable: ");
        r8.append(this.f6959a);
        r8.append(" probeEnable: ");
        r8.append(this.f6960b);
        r8.append(" hostFilter: ");
        HashMap r10 = this.f6961c;
        if (r10 == null) goto L5;
        int r11 = r10.size();
    L6:
        r8.append(r11);
        r8.append(" reqTo: ");
        r8.append(this.f6962d);
        r8.append("#");
        r8.append(this.f6963e);
        r8.append("#");
        r8.append(this.f6964f);
        r8.append(" reqErr: ");
        r8.append(this.f6965g);
        r8.append("#");
        r8.append(this.f6966h);
        r8.append("#");
        r8.append(this.f6967i);
        r8.append(" updateInterval: ");
        r8.append(this.f6968j);
        r8.append(" updateRandom: ");
        r8.append(this.f6969k);
        r8.append(" httpBlack: ");
        r8.append(this.f6970l);
        return r8.toString();
    L5:
        r11 = 0;
        goto L6
    }
}
