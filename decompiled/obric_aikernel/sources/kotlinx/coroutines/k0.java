package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10604g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10605c;

    public static final class a implements CoroutineContext.Key<k0> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f10604g = new a(null);
    }

    public k0(String r10) {
        super(f10604g);
        this.f10605c = r10;
    }

    public final String c0() {
        return this.f10605c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f10605c, ((k0) r10).f10605c) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f10605c.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f10605c + ')';
    }
}
