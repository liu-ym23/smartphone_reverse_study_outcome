package svb;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Unit;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends MviRepository<Unit, Object, c> {
    public final a j;

    public static final class a implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c {
        public final /* synthetic */ b a;

        @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
        public final i1<Unit> b() {
            return this.a.g();
        }

        @Override // fvb.a
        public final void onDestroy() {
            this.a.i();
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public b() {
        this.j = new a(this);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final /* bridge */ /* synthetic */ Unit a() {
        return Unit.INSTANCE;
    }
}
