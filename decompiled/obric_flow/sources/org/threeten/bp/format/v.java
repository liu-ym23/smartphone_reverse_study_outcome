package org.threeten.bp.format;

import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends fv.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.chrono.b f21253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.temporal.d f21254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.chrono.i f21255c;
    public final /* synthetic */ ZoneId d;

    public v(org.threeten.bp.chrono.b r5, org.threeten.bp.temporal.d r10, org.threeten.bp.chrono.i r11, ZoneId r12) {
        this.f21253a = r5;
        this.f21254b = r10;
        this.f21255c = r11;
        this.d = r12;
    }

    @Override // org.threeten.bp.temporal.d
    public final long getLong(org.threeten.bp.temporal.g r5) {
        org.threeten.bp.chrono.b r10 = this.f21253a;
        if (r10 == null) goto L9;
        if (r5.isDateBased() == false) goto L9;
        return r10.getLong(r5);
    L9:
        return this.f21254b.getLong(r5);
    }

    @Override // org.threeten.bp.temporal.d
    public final boolean isSupported(org.threeten.bp.temporal.g r5) {
        org.threeten.bp.chrono.b r10 = this.f21253a;
        if (r10 == null) goto L9;
        if (r5.isDateBased() == false) goto L9;
        return r10.isSupported(r5);
    L9:
        return this.f21254b.isSupported(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final Object query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return this.f21255c;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L11;
        return this.d;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L15;
        return this.f21254b.query(r5);
    L15:
        return r5.d(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final ValueRange range(org.threeten.bp.temporal.g r5) {
        org.threeten.bp.chrono.b r10 = this.f21253a;
        if (r10 == null) goto L9;
        if (r5.isDateBased() == false) goto L9;
        return r10.range(r5);
    L9:
        return this.f21254b.range(r5);
    }
}
