package s8;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12751b;

    public e(float r10, float r11) {
        this.f12750a = r10;
        this.f12751b = r11;
    }

    public final float a() {
        return this.f12750a;
    }

    public final float b() {
        return this.f12751b;
    }

    public final float c() {
        return this.f12750a;
    }

    public final float d() {
        return this.f12751b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L10;
        e r11 = (e) r10;
        if (Float.compare(this.f12750a, r11.f12750a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f12751b, r11.f12751b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f12750a) * 31) + Float.hashCode(this.f12751b);
    }

    public String toString() {
        return "Point(x=" + this.f12750a + ", y=" + this.f12751b + ")";
    }
}
