package androidx.core.app;

import android.app.Person;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f1656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IconCompat f1657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1661f;

    public static class a {
        public static o a(Person r8) {
            b r10 = new b();
            r10.f1662a = r8.getName();
            if (r8.getIcon() == null) goto L14;
            Icon r11 = r8.getIcon();
            PorterDuff.Mode r12 = IconCompat.f1676k;
            r11.getClass();
            int r13 = IconCompat.c.c(r11);
            if (r13 != 2) goto L7;
            IconCompat r14 = IconCompat.a(IconCompat.c.b(r11), IconCompat.c.a(r11));
        L15:
            r10.f1663b = r14;
            r10.f1664c = r8.getUri();
            r10.f1665d = r8.getKey();
            r10.f1666e = r8.isBot();
            r10.f1667f = r8.isImportant();
            return new o(r10);
        L7:
            if (r13 != 4) goto L9;
            Uri r15 = IconCompat.a.a(r11);
            r15.getClass();
            String r16 = r15.toString();
            r16.getClass();
            r14 = new IconCompat(4);
            r14.f1678b = r16;
            goto L15
        L9:
            if (r13 == 6) goto L11;
            r14 = new IconCompat(-1);
            r14.f1678b = r11;
            goto L15
        L11:
            Uri r17 = IconCompat.a.a(r11);
            r17.getClass();
            String r18 = r17.toString();
            r18.getClass();
            r14 = new IconCompat(6);
            r14.f1678b = r18;
            goto L15
        L14:
            r14 = null;
            goto L15
        }

        public static Person b(o r8) {
            Person.Builder r10 = new Person.Builder().setName(r8.f1656a);
            Icon r11 = null;
            IconCompat r12 = r8.f1657b;
            if (r12 == null) goto L6;
            r12.getClass();
            r11 = IconCompat.a.c(r12, null);
        L6:
            return r10.setIcon(r11).setUri(r8.f1658c).setKey(r8.f1659d).setBot(r8.f1660e).setImportant(r8.f1661f).build();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f1662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f1663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1667f;
    }

    public o(b r8) {
        this.f1656a = r8.f1662a;
        this.f1657b = r8.f1663b;
        this.f1658c = r8.f1664c;
        this.f1659d = r8.f1665d;
        this.f1660e = r8.f1666e;
        this.f1661f = r8.f1667f;
    }
}
