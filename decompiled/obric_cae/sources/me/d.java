package me;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f9352a;

    public d(Iterator r8) {
        this.f9352a = r8;
    }

    @Override // me.b
    public final Iterator<Object> iterator() {
        return this.f9352a;
    }
}
