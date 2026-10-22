package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d7 extends s9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.q f8941c;

    public /* synthetic */ d7(Iterator r5, com.google.common.base.q r10, int r11) {
        this.f8940b = r11;
        this.f8941c = r10;
        super(r5);
    }

    @Override // com.google.common.collect.s9
    public final Object a(Object r5) {
        switch(this.f8940b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8941c.apply(r5);
    L7:
        return new ImmutableEntry(r5, this.f8941c.apply(r5));
    }
}
