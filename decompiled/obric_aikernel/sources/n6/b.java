package n6;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f11263c;

    private b(boolean r10, String r11, HashMap<String, String> r12) {
        this.f11261a = r10;
        this.f11262b = r11;
        this.f11263c = r12;
    }

    public static b a(boolean r10, String r11, HashMap<String, String> r12) {
        return new b(r10, r11, r12);
    }

    public String b() {
        return this.f11262b;
    }

    public HashMap<String, String> c() {
        return this.f11263c;
    }

    public boolean d() {
        return this.f11261a;
    }
}
