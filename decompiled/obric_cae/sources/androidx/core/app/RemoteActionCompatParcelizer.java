package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(h1.a r8) {
        RemoteActionCompat r10 = new RemoteActionCompat();
        Object r11 = r10.f1581a;
        if (r8.h(1) == false) goto L6;
        r11 = r8.m();
    L6:
        r10.f1581a = (IconCompat) r11;
        CharSequence r12 = r10.f1582b;
        if (r8.h(2) == false) goto L10;
        r12 = r8.g();
    L10:
        r10.f1582b = r12;
        CharSequence r13 = r10.f1583c;
        if (r8.h(3) == false) goto L14;
        r13 = r8.g();
    L14:
        r10.f1583c = r13;
        Parcelable r14 = r10.f1584d;
        if (r8.h(4) == false) goto L18;
        r14 = r8.k();
    L18:
        r10.f1584d = (PendingIntent) r14;
        boolean r15 = r10.f1585e;
        if (r8.h(5) == false) goto L22;
        r15 = r8.e();
    L22:
        r10.f1585e = r15;
        boolean r16 = r10.f1586f;
        if (r8.h(6) == false) goto L26;
        r16 = r8.e();
    L26:
        r10.f1586f = r16;
        return r10;
    }

    public static void write(RemoteActionCompat r8, h1.a r10) {
        r10.getClass();
        IconCompat r11 = r8.f1581a;
        r10.n(1);
        r10.v(r11);
        CharSequence r12 = r8.f1582b;
        r10.n(2);
        r10.q(r12);
        CharSequence r13 = r8.f1583c;
        r10.n(3);
        r10.q(r13);
        PendingIntent r14 = r8.f1584d;
        r10.n(4);
        r10.t(r14);
        boolean r15 = r8.f1585e;
        r10.n(5);
        r10.o(r15);
        boolean r16 = r8.f1586f;
        r10.n(6);
        r10.o(r16);
    }
}
