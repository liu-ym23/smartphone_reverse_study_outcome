package x4;

/* JADX INFO: loaded from: classes.dex */
public final class d extends wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f13390a;

    public d(boolean r8) {
        this.f13390a = r8;
    }

    @Override // wd.a
    public final boolean markAsNewUser() {
        return !this.f13390a;
    }

    @Override // wd.a
    public final int triggerType() {
        return 0;
    }
}
