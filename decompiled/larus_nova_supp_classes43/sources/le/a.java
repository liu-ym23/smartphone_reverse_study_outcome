package le;

import com.bytedance.android.ec.adapter.api.model.ECLiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final String b;
    public final ECLiveMode c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    /* JADX INFO: renamed from: le.a$a, reason: collision with other inner class name */
    public static final class C0179a {
        public String a;
        public String b;
        public ECLiveMode c;
        public String d;
        public final String e;
        public boolean f;
        public final boolean g;
        public boolean h;

        public final a a() {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public C0179a() {
            this.a = "";
            this.b = "";
            this.c = ECLiveMode.VIDEO;
            this.d = "";
            this.e = "";
            this.g = true;
        }
    }

    public a(String r1, String r10, ECLiveMode r11, String r12, String r13, boolean r14, boolean r15, boolean r16) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }
}
