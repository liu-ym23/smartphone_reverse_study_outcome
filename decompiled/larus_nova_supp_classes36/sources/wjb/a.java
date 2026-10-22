package wjb;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.task.d;
import io.reactivex.Observable;
import j0c.b;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d {
    public static final b a = null;

    /* JADX INFO: renamed from: wjb.a$a, reason: collision with other inner class name */
    public static final class C0341a {
    }

    @Inject
    public a() {
    }

    public final /* synthetic */ boolean G() {
        return false;
    }

    public final /* synthetic */ Observable H(e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    public final List<b> dependencies() {
        return CollectionsKt.mutableListOf(new b[]{new b("switch_user")});
    }

    static {
        a = new b("load_on_boarding");
    }

    public final b F() {
        return a;
    }

    public final Observable<c> I(e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Scene r6 = r5.b;
        Scene r7 = Scene.FIRST_ONLINE;
        return Observable.just(new c(a, true, null, 12));
    }
}
