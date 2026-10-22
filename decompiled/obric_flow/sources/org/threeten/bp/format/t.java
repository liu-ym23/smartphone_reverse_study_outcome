package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends fv.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.threeten.bp.chrono.i f21247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ZoneId f21248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f21249c;
    public boolean d;
    public final Period e;
    public ArrayList f;
    public final /* synthetic */ u g;

    public t(u r5) {
        this.g = r5;
        this.f21247a = null;
        this.f21248b = null;
        this.f21249c = new HashMap();
        this.e = Period.ZERO;
    }

    public final a a() {
        a r5 = new a();
        r5.f21194a.putAll(this.f21249c);
        u r10 = this.g;
        org.threeten.bp.chrono.i r11 = r10.b().f21247a;
        if (r11 != null) goto L7;
        r11 = r10.f21252c;
        if (r11 != null) goto L7;
        r11 = IsoChronology.INSTANCE;
    L7:
        r5.f21195b = r11;
        ZoneId r12 = this.f21248b;
        if (r12 == null) goto L10;
        r5.f21196c = r12;
    L11:
        r5.f = this.e;
        return r5;
    L10:
        r5.f21196c = null;
        goto L11
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final int get(org.threeten.bp.temporal.g r5) {
        HashMap r10 = this.f21249c;
        if (r10.containsKey(r5) == false) goto L7;
        return jm.c.x(((Long) r10.get(r5)).longValue());
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.temporal.d
    public final long getLong(org.threeten.bp.temporal.g r5) {
        HashMap r10 = this.f21249c;
        if (r10.containsKey(r5) == false) goto L7;
        return ((Long) r10.get(r5)).longValue();
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.temporal.d
    public final boolean isSupported(org.threeten.bp.temporal.g r5) {
        return this.f21249c.containsKey(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final Object query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return this.f21247a;
    L7:
        if (r5 == org.threeten.bp.temporal.h.f21286a) goto L14;
        if (r5 == org.threeten.bp.temporal.h.d) goto L14;
        return super.query(r5);
    L14:
        return this.f21248b;
    }

    public final String toString() {
        return this.f21249c.toString() + "," + this.f21247a + "," + this.f21248b;
    }
}
