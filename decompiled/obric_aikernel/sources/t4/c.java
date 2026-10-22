package t4;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f12965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f12966c;

    public c(int r10, Map<String, String> r11, byte[] r12) {
        this.f12964a = r10;
        this.f12965b = r11;
        this.f12966c = r12;
    }

    public c(int r10, byte[] r11) {
        this.f12964a = r10;
        this.f12966c = r11;
    }

    @Nullable
    public Map<String, String> a() {
        return this.f12965b;
    }

    public byte[] b() {
        return this.f12966c;
    }

    public int c() {
        return this.f12964a;
    }
}
