package l8;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean[] f9176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9177b;

    /* JADX INFO: renamed from: l8.a$a, reason: collision with other inner class name */
    public static class C0111a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f9178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9179b;

        public C0111a() {
            this.f9178a = new boolean[b.values().length];
        }

        public final void a(String r8) {
            if (r8 == null) goto L12;
            if (r8.isEmpty() == true) goto L12;
            if (r8.getBytes(StandardCharsets.UTF_8).length > 1024) goto L10;
            this.f9179b = r8;
            return;
        L10:
            throw new n8.a("customInfo too long (max 1024 bytes)");
        L12:
            throw new n8.a("customInfo must not be null or empty");
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f9180a = null;

        static {
            f9180a = new b[]{new b("UDID", 0), new b("RPDID", 1), new b("RPUID", 2)};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f9180a.clone();
        }
    }

    public a(C0111a r8) {
        this.f9176a = (boolean[]) r8.f9178a.clone();
        this.f9177b = r8.f9179b;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("AttestationConfig{requestedIds=[");
        b[] r10 = b.values();
        int r11 = r10.length;
        boolean r12 = true;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        b r14 = r10[r13];
        if (this.f9176a[r14.ordinal()] == false) goto L9;
        if (r12 == true) goto L8;
        r8.append(", ");
    L8:
        r8.append(r14.name());
        r12 = false;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        r8.append("]");
        String r15 = this.f9177b;
        if (r15 == null) goto L13;
        r8.append(", customInfo='");
        r8.append(r15);
        r8.append('\'');
    L13:
        r8.append(", devHealthStatusRequired=false}");
        return r8.toString();
    }
}
