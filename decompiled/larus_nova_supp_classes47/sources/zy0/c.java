package zy0;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wy0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c extends Disposable, a {
    void dispose();

    xy0.a<?> g();

    boolean isDisposed();

    void l1(Function1<? super e, Unit> r1);

    xy0.a<?> w();
}
