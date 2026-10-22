package nwb;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements com.ss.android.lark.passportc.task.d {
    public static final j0c.b a = null;

    public static final class a {
    }

    @Inject
    public h() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        a = new j0c.b("switch_user");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return Observable.just(new j0c.c(a, true, null, 12));
    }
}
