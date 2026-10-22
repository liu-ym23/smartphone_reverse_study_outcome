package o0c;

import com.bytedance.supervisor.token.Token;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements ObservableTransformer<Object, Boolean> {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Token c;
    public final /* synthetic */ c d;

    public final ObservableSource<Boolean> apply(final Observable<Object> r6) {
        List r0 = c.b(this.d, this.a);
        PublishSubject r1 = PublishSubject.create();
        Observable r2 = Observable.fromIterable(r0);
        final boolean r3 = this.b;
        final Token r4 = this.c;
        Observable r7 = r2.concatMap(new d(this, r3, r6, r4)).toList().map(new e()).toObservable().doFinally(new f());
        List<PublishSubject<Boolean>> r5 = c.c;
        monitor-enter(r5);
        ((ArrayList) r5).add(r1);     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        if (((ArrayList) r5).size() >= 2) goto L9;
        return r7;
    L9:
        return Observable.concat(r1, r7).buffer(2).map(new g());
    L12:
        th = move-exception;
        throw th;
    }

    public j(c r1, String[] r2, boolean r3, Token r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
