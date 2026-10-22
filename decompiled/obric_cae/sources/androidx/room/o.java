package androidx.room;

import android.database.sqlite.SQLiteProgram;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o implements a1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2662b;

    public o(SQLiteProgram r8) {
        this.f2661a = 1;
        he.i.f(r8, "delegate");
        this.f2662b = r8;
    }

    @Override // a1.d
    public final void R(int r8, String r10) {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        he.i.f(r10, "value");
        i(r8, r10);
        return;
    L7:
        he.i.f(r10, "value");
        ((SQLiteProgram) this.f2662b).bindString(r8, r10);
    }

    @Override // a1.d
    public final void W(int r8, long r10) {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i(r8, Long.valueOf(r10));
        return;
    L7:
        ((SQLiteProgram) this.f2662b).bindLong(r8, r10);
    }

    @Override // a1.d
    public final void Y(int r8, byte[] r10) {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i(r8, r10);
        return;
    L7:
        ((SQLiteProgram) this.f2662b).bindBlob(r8, r10);
    }

    public final void a(int r8, double r10) {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i(r8, Double.valueOf(r10));
        return;
    L7:
        ((SQLiteProgram) this.f2662b).bindDouble(r8, r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L6;
        };
    L5:
        return;
    L6:
        ((SQLiteProgram) this.f2662b).close();
    }

    @Override // a1.d
    public final void g0(int r8) {
        switch(this.f2661a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i(r8, null);
        return;
    L7:
        ((SQLiteProgram) this.f2662b).bindNull(r8);
    }

    public final void i(int r8, Object r10) {
        int r11 = r8 - 1;
        Object r12 = this.f2662b;
        if (r11 < ((List) r12).size()) goto L9;
        int r13 = ((List) r12).size();
        if (r13 > r11) goto L9;
    L6:
        ((List) r12).add(null);
        if (r13 == r11) goto L9;
        r13 = r13 + 1;
    L9:
        ((List) r12).set(r11, r10);
    }
}
