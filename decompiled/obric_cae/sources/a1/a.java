package a1;

import androidx.room.o;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f15b;

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    public static final class C0000a {
        public static void a(o r8, Object[] r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            int r11 = r10.length;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L44;
            Object r13 = r10[r12];
            r12 = r12 + 1;
            if (r13 == null) goto L8;
            if ((r13 instanceof byte[]) == true) goto L11;
            if ((r13 instanceof Float) == true) goto L14;
            if ((r13 instanceof Double) == true) goto L17;
            if ((r13 instanceof Long) == true) goto L21;
            if ((r13 instanceof Integer) == true) goto L24;
            if ((r13 instanceof Short) == true) goto L27;
            if ((r13 instanceof Byte) == true) goto L30;
            if ((r13 instanceof String) == false) goto L36;
            r8.R(r12, (String) r13);
            goto L5
        L36:
            if ((r13 instanceof Boolean) == false) goto L43;
            if (((Boolean) r13).booleanValue() == false) goto L40;
            long r14 = 1;
        L41:
            r8.W(r12, r14);
            goto L5
        L40:
            r14 = 0;
            goto L41
        L43:
            throw new IllegalArgumentException("Cannot bind " + r13 + " at index " + r12 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        L30:
            int r15 = ((Number) r13).byteValue();
        L31:
            r14 = r15;
            goto L41
        L27:
            r15 = ((Number) r13).shortValue();
            goto L31
        L24:
            r15 = ((Number) r13).intValue();
            goto L31
        L21:
            r14 = ((Number) r13).longValue();
            goto L41
        L17:
            double r16 = ((Number) r13).doubleValue();
        L18:
            r8.a(r12, r16);
            goto L5
        L14:
            r16 = ((Number) r13).floatValue();
            goto L18
        L11:
            r8.Y(r12, (byte[]) r13);
            goto L5
        L8:
            r8.g0(r12);
            goto L5
        }
    }

    public a(String r8) {
        i.f(r8, "query");
        this(r8, null);
    }

    @Override // a1.e
    public final String a() {
        return this.f14a;
    }

    @Override // a1.e
    public final void i(o r8) {
        C0000a.a(r8, this.f15b);
    }

    public a(String r8, Object[] r10) {
        i.f(r8, "query");
        this.f14a = r8;
        this.f15b = r10;
    }
}
