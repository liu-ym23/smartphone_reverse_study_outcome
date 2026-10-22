package com.prolificinteractive.materialcalendarview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import fy7.a;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.zone.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MaterialCalendarViewInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r0 = getContext();
        if (a.a.getAndSet(true) == true) goto L19;
        b r1 = new fy7.b(r0);
        if (b.a.get() == true) goto L18;
        AtomicReference<b> r2 = b.b;
    L8:
        if (r2.compareAndSet(null, r1) == true) goto L9;
        if (r2.get() == null) goto L8;
        boolean r3 = false;
    L13:
        if (r3 == true) goto L19;
        throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
    L9:
        r3 = true;
        goto L13
    L18:
        throw new IllegalStateException("Already initialized");
    L19:
        return true;
    }

    public MaterialCalendarViewInitProvider() {
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r3, ProviderInfo r4) {
        if (r4 == null) goto L10;
        if ("com.prolificinteractive.materialcalendarview.materialcalendarviewinitprovider".equals(r4.authority) == true) goto L8;
        super.attachInfo(r3, r4);
        return;
    L8:
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    L10:
        throw new NullPointerException("MaterialCalendarViewInitProvider ProviderInfo cannot be null.");
    }
}
