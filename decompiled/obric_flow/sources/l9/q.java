package l9;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f19588c;
    public JSONObject d;
    public long e;

    public q(File r5) {
        this.e = 0;
        this.f19588c = r5;
        String[] r10 = r5.getName().split("-|\\.");
        this.f19586a = Long.parseLong(r10[0]);
        this.f19587b = Long.parseLong(r10[1]);
    }
}
