package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f8668c;

    public t(u r5, u r10) {
        this.f8668c = r5;
        super(r10);
    }

    @Override // com.google.common.base.u
    public final CharSequence b(Object r5) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        return this.f8668c.b(r5);
    }
}
