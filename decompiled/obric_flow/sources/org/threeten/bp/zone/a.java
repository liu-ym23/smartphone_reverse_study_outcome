package org.threeten.bp.zone;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f21297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short[] f21298c;
    public final AtomicReferenceArray d;

    public a(String r5, String[] r10, short[] r11, AtomicReferenceArray r12) {
        this.d = r12;
        this.f21296a = r5;
        this.f21297b = r10;
        this.f21298c = r11;
    }

    public final String toString() {
        return this.f21296a;
    }
}
