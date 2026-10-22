package ja;

/* JADX INFO: loaded from: classes.dex */
public final class h implements t<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f8756a;

    public h(Class r8) {
        this.f8756a = r8;
    }

    @Override // ja.t
    public final Object b() {
        Class r8 = this.f8756a;
        return z.f8815a.b(r8);
    L5:
        e = move-exception;
        throw new RuntimeException("Unable to create instance of " + r8 + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
    }
}
