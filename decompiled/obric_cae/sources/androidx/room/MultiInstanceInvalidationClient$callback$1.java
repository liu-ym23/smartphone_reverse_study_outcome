package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2594b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f2595a;

    public MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient r8) {
        this.f2595a = r8;
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public final void M(String[] r8) {
        he.i.f(r8, "tables");
        MultiInstanceInvalidationClient r10 = this.f2595a;
        r10.f2582c.execute(new k(0, r10, r8));
    }
}
