package ala;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.CalendarContract;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements e {
    public final long b;
    public final String c;

    @Override // ala.e
    public final Long getId() {
        return Long.valueOf(this.b);
    }

    @Override // ala.e
    public final Uri toUri() {
        Uri.Builder r0 = CalendarContract.Events.CONTENT_EXCEPTION_URI.buildUpon();
        ContentUris.appendId(r0, this.b).appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.c).appendQueryParameter("account_type", AccountType.LOCAL);
        return r0.build();
    }

    public c(long r1, String r3) {
        this.b = r1;
        this.c = r3;
    }
}
