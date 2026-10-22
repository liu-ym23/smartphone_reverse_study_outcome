package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f1591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f1592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q[] f1593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public final int f1598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f1599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PendingIntent f1600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1601k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IconCompat f1602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f1603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PendingIntent f1604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f1606e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f1607f;

        public a(int r8, String r10, PendingIntent r11) {
            if (r8 != 0) goto L4;
            IconCompat r12 = null;
        L5:
            Bundle r13 = new Bundle();
            this.f1605d = true;
            this.f1607f = true;
            this.f1602a = r12;
            this.f1603b = j.c(r10);
            this.f1604c = r11;
            this.f1606e = r13;
            this.f1605d = true;
            this.f1607f = true;
            return;
        L4:
            r12 = IconCompat.a("", r8);
            goto L5
        }
    }

    public h(IconCompat r8, CharSequence r10, PendingIntent r11, Bundle r12, q[] r13, q[] r14, boolean r15, int r16, boolean r17, boolean r18, boolean r19) {
        this.f1595e = true;
        this.f1592b = r8;
        if (r8 == null) goto L10;
        int r20 = r8.f1677a;
        if (r20 != (-1)) goto L8;
        r20 = IconCompat.c.c(r8.f1678b);
    L8:
        if (r20 != 2) goto L10;
        this.f1598h = r8.b();
    L10:
        this.f1599i = j.c(r10);
        this.f1600j = r11;
        if (r12 != null) goto L14;
        r12 = new Bundle();
    L14:
        this.f1591a = r12;
        this.f1593c = r13;
        this.f1594d = r15;
        this.f1596f = r16;
        this.f1595e = r17;
        this.f1597g = r18;
        this.f1601k = r19;
    }
}
