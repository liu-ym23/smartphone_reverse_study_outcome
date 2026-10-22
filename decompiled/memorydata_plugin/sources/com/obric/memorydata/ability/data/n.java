package com.obric.memorydata.ability.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ability/data/ReferenceCount;", "", "<init>", "()V", "refCount", "", "canRelease", "", "decRef", "", "getRefCount", "incRef", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8339a;

    public n() {
    }

    public final boolean d() {
        if (this.f8339a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        this.f8339a--;
    }

    public final void f() {
        this.f8339a++;
    }
}
