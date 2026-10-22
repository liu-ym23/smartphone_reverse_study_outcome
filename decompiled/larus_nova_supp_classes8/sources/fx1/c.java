package fx1;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.message.model.n4;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class c<T> implements e<T> {
    public final String a;
    public final CompositeDisposable b;
    public Function2<? super TriggerId, ? super T, Unit> c;

    @Override // fx1.e
    public void a() {
        d("startObserve", new Pair[0]);
        this.b.clear();
    }

    @Override // fx1.e
    public void reset() {
        this.c = null;
        this.b.clear();
    }

    public c() {
        this.a = "BaseFeedbackTrigger";
        this.b = new CompositeDisposable();
    }

    public static n4 f(long r1) {
        n4 r0 = new n4();
        r0.actionId = Long.valueOf(r1);
        return r0;
    }

    @Override // fx1.e
    public final void b(Function2<? super TriggerId, ? super T, Unit> r1) {
        this.c = r1;
    }

    public final void c(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoBind");
        this.b.add(r2);
    }

    public final void e(T r3) {
        Function2<? super TriggerId, ? super T, Unit> r0 = this.c;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(getId(), r3);
        return;
    }

    public final void d(String r5, Pair<String, ? extends Object>... r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r6, "args");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        String r2 = getId().name();
        Intrinsics.checkNotNullParameter(r2, "page");
        r1.a = r2;
        r1.c(r5);
        int r7 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r7) goto L8;
        Pair<String, ? extends Object> r4 = r6[r3];
        Object r8 = r4.getSecond();
        if (r8 == null) goto L7;
        r1.a((String) r4.getFirst(), r8);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r1.d();
    }
}
