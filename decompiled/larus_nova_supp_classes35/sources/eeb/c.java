package eeb;

import com.bytedance.lark.view_flow_wrapper.m;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import io.reactivex.Observable;
import j0c.e;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c implements com.ss.android.lark.passportc.task.c {
    public static final j0c.b c = null;
    public final Set<m> a;
    public final j0c.b b;

    public static final class a {
    }

    public final /* synthetic */ boolean G() {
        return false;
    }

    public final /* synthetic */ Observable H(e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        c = new j0c.b("FeedViewFlowForegroundLifecycleTask");
        Intrinsics.checkNotNullParameter("FeedViewFlowBackgroundLifecycleTask", IPortraitService.NAME);
    }

    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    public final j0c.b F() {
        return this.b;
    }

    public final Observable<j0c.c> I(e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Iterator<T> r6 = this.a.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        ((m) r6.next()).dispose();
        goto L4
    L7:
        return Observable.just(new j0c.c(this.b, true, null, 12));
    }

    public c(Set<? extends m> r2, j0c.b r3) {
        Intrinsics.checkNotNullParameter(r2, "disposables");
        Intrinsics.checkNotNullParameter(r3, "taskName");
        this.a = r2;
        this.b = r3;
    }
}
