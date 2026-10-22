package org.sqlite.date;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f21084c = null;
    public static final d d = null;
    public static final d e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21086b;

    static {
        int r5 = 0;
        f21084c = new d("(Z|(?:[+-]\\d{2}))", r5);
        d = new d("(Z|(?:[+-]\\d{2}\\d{2}))", r5);
        e = new d("(Z|(?:[+-]\\d{2}(?::)\\d{2}))", r5);
    }

    public /* synthetic */ d(String r5, int r10) {
        this.f21085a = r10;
        this.f21086b = r5;
    }

    @Override // org.sqlite.date.f
    public final boolean a(FastDateParser r5, StringBuilder r10) {
        switch(this.f21085a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        FastDateParser.access$100(r10, this.f21086b, true);
        return false;
    L6:
        r10.append(this.f21086b);
        return true;
    }

    @Override // org.sqlite.date.f
    public boolean b() {
        switch(this.f21085a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = this.f21086b;
        char r10 = r5.charAt(0);
        if (r10 != '\'') goto L10;
        r10 = r5.charAt(1);
    L10:
        return Character.isDigit(r10);
    L5:
        return super.b();
    }

    @Override // org.sqlite.date.f
    public void c(FastDateParser r5, Calendar r10, String r11) {
        switch(this.f21085a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return;
    L6:
        if (r11.equals("Z") == false) goto L8;
        r10.setTimeZone(TimeZone.getTimeZone("UTC"));
        return;
    L8:
        r10.setTimeZone(TimeZone.getTimeZone("GMT".concat(r11)));
    }
}
