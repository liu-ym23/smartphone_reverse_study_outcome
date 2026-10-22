package hm;

import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter$ExecutionPriority;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UIAnimaXPropsPrioritySetter$ExecutionPriority f17340b;

    public b(a r5, UIAnimaXPropsPrioritySetter$ExecutionPriority r10) {
        this.f17339a = r5;
        this.f17340b = r10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        return Integer.compare(this.f17340b.f9696a, ((b) r5).f17340b.f9696a);
    }
}
