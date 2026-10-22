package zoc;

import com.ss.android.lark.passportc.task.d;
import dagger.Lazy;
import io.reactivex.Observable;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d {
    public static final j0c.b b = null;

    @Inject
    public Lazy<h> a;

    public static final class a {
    }

    @Inject
    public b() {
    }

    public final /* synthetic */ boolean G() {
        return false;
    }

    public final /* synthetic */ Observable H(e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    public final List<j0c.b> dependencies() {
        return CollectionsKt.mutableListOf(new j0c.b[]{new j0c.b("switch_user")});
    }

    static {
        b = new j0c.b("floating_panel_init");
    }

    public final j0c.b F() {
        return b;
    }

    public final Observable<j0c.c> I(e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        j0c.b r0 = b;
        Lazy<h> r1 = this.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        r1 = null;
    L7:
        return Observable.just(new j0c.c(r0, true, r1.get().toString(), 4));
    }
}
