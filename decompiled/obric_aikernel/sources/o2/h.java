package o2;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f11478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11479d;

    public h(boolean r10) {
        this.f11477b = true;
        this.f11476a = r10;
    }

    public h(boolean r10, boolean r11, Map<String, String> r12) {
        this.f11477b = true;
        this.f11476a = r10;
        this.f11477b = r11;
        this.f11478c = r12;
    }

    public Map<String, String> a() {
        return this.f11478c;
    }

    public String b() {
        return this.f11479d;
    }

    public boolean c() {
        return this.f11477b;
    }

    public boolean d() {
        return this.f11476a;
    }

    public void e(Map<String, String> r10) {
        this.f11478c = r10;
    }

    void f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.f11479d = r10;
    }
}
