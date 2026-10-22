package s18;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public boolean a;
    public String b;
    public String c;
    public String d;
    public String e;

    public final String toString() {
        return "ValidatorResult{valid=" + this.a + ", msg='" + this.b + "', invalidType='" + this.c + "', invalidTypeMsg='" + this.d + "'}";
    }

    public b() {
        this.a = true;
    }

    public b(String r2) {
        this.a = false;
        this.b = r2;
    }
}
