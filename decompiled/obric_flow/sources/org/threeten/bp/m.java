package org.threeten.bp;

import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends fv.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21271b;

    public /* synthetic */ m(Object r5, int r10) {
        this.f21270a = r10;
        this.f21271b = r5;
    }

    @Override // org.threeten.bp.temporal.d
    public final long getLong(org.threeten.bp.temporal.g r5) {
        switch(this.f21270a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.temporal.d
    public final boolean isSupported(org.threeten.bp.temporal.g r5) {
        switch(this.f21270a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return false;
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final Object query(org.threeten.bp.temporal.i r5) {
        switch(this.f21270a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L8;
        return (org.threeten.bp.chrono.i) this.f21271b;
    L8:
        return super.query(r5);
    L10:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L13;
        return (ZoneId) this.f21271b;
    L13:
        return super.query(r5);
    }
}
