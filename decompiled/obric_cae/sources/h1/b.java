package h1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f7895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f7896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f7897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7902k;

    public b(Parcel r10) {
        this(r10, r10.dataPosition(), r10.dataSize(), "", new n.b(), new n.b(), new n.b());
    }

    @Override // h1.a
    public final b a() {
        Parcel r8 = this.f7896e;
        int r10 = r8.dataPosition();
        int r11 = this.f7901j;
        if (r11 != this.f7897f) goto L6;
        r11 = this.f7898g;
    L6:
        return new b(r8, r10, r11, android.aimedia.a.i(new StringBuilder(), this.f7899h, "  "), this.f7892a, this.f7893b, this.f7894c);
    }

    @Override // h1.a
    public final boolean e() {
        if (this.f7896e.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // h1.a
    public final byte[] f() {
        Parcel r8 = this.f7896e;
        int r10 = r8.readInt();
        if (r10 >= 0) goto L6;
        return null;
    L6:
        byte[] r11 = new byte[r10];
        r8.readByteArray(r11);
        return r11;
    }

    @Override // h1.a
    public final CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f7896e);
    }

    @Override // h1.a
    public final boolean h(int r8) {
    L3:
        if (this.f7901j >= this.f7898g) goto L12;
        int r10 = this.f7902k;
        if (r10 == r8) goto L6;
        if (String.valueOf(r10).compareTo(String.valueOf(r8)) > 0) goto L9;
        int r11 = this.f7901j;
        Parcel r12 = this.f7896e;
        r12.setDataPosition(r11);
        int r13 = r12.readInt();
        this.f7902k = r12.readInt();
        this.f7901j += r13;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.f7902k != r8) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // h1.a
    public final int i() {
        return this.f7896e.readInt();
    }

    @Override // h1.a
    public final <T extends Parcelable> T k() {
        ClassLoader r8 = b.class.getClassLoader();
        return (T) this.f7896e.readParcelable(r8);
    }

    @Override // h1.a
    public final String l() {
        return this.f7896e.readString();
    }

    @Override // h1.a
    public final void n(int r8) {
        w();
        this.f7900i = r8;
        this.f7895d.put(r8, this.f7896e.dataPosition());
        r(0);
        r(r8);
    }

    @Override // h1.a
    public final void o(boolean r8) {
        this.f7896e.writeInt(r8 ? 1 : 0);
    }

    @Override // h1.a
    public final void p(byte[] r8) {
        Parcel r10 = this.f7896e;
        if (r8 == null) goto L5;
        r10.writeInt(r8.length);
        r10.writeByteArray(r8);
        return;
    L5:
        r10.writeInt(-1);
    }

    @Override // h1.a
    public final void q(CharSequence r8) {
        TextUtils.writeToParcel(r8, this.f7896e, 0);
    }

    @Override // h1.a
    public final void r(int r8) {
        this.f7896e.writeInt(r8);
    }

    @Override // h1.a
    public final void t(Parcelable r8) {
        this.f7896e.writeParcelable(r8, 0);
    }

    @Override // h1.a
    public final void u(String r8) {
        this.f7896e.writeString(r8);
    }

    public final void w() {
        int r8 = this.f7900i;
        if (r8 < 0) goto L6;
        int r10 = this.f7895d.get(r8);
        Parcel r11 = this.f7896e;
        int r12 = r11.dataPosition();
        r11.setDataPosition(r10);
        r11.writeInt(r12 - r10);
        r11.setDataPosition(r12);
        return;
    }

    public b(Parcel r8, int r10, int r11, String r12, n.b<String, Method> r13, n.b<String, Method> r14, n.b<String, Class> r15) {
        super(r13, r14, r15);
        this.f7895d = new SparseIntArray();
        this.f7900i = -1;
        this.f7902k = -1;
        this.f7896e = r8;
        this.f7897f = r10;
        this.f7898g = r11;
        this.f7901j = r10;
        this.f7899h = r12;
    }
}
