package ala;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.CalendarContract;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements e {
    public final Long b;
    public final String c;

    /* JADX INFO: renamed from: ala.a$a, reason: collision with other inner class name */
    public static final class C0001a {
    }

    static {
    }

    @Override // ala.e
    public final Uri toUri() {
        Uri.Builder r0 = CalendarContract.Calendars.CONTENT_URI.buildUpon();
        Long r1 = this.b;
        if (r1 == null) goto L6;
        ContentUris.appendId(r0, r1.longValue());
    L6:
        if (this.c == null) goto L9;
        r0.appendQueryParameter("caller_is_syncadapter", "true");
        r0.appendQueryParameter("account_name", this.c);
        r0.appendQueryParameter("account_type", AccountType.LOCAL);
    L9:
        return r0.build();
    }

    @Override // ala.e
    public final Long getId() {
        return this.b;
    }

    public /* synthetic */ a(Long r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this(r2, null);
    }

    public a(Long r1, String r2) {
        this.b = r1;
        this.c = r2;
    }
}
