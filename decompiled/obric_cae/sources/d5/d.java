package d5;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6789d;

    public d() {
        this.f6787b = true;
        this.f6788c = false;
        this.f6789d = false;
    }

    public abstract boolean a(JSONObject r8);

    public void b(JSONObject r8) {
    }

    public d(boolean r8, boolean r10) {
        this.f6787b = r8;
        this.f6788c = r10;
        this.f6789d = false;
    }
}
