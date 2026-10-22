package yu0;

import io.reactivex.subjects.SingleSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements zv0.e {
    public final /* synthetic */ SingleSubject a;

    @Override // zv0.e
    public final void b() {
        this.a.onSuccess(Unit.INSTANCE);
    }

    public a(SingleSubject r1) {
        this.a = r1;
    }

    @Override // zv0.e
    public final void a(Throwable r2) {
        this.a.onSuccess(Unit.INSTANCE);
    }

    @Override // zv0.e
    public final void c(zv0.d r2) {
        this.a.onSuccess(Unit.INSTANCE);
    }
}
