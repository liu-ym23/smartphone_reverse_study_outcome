package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T> extends Observable<T> implements t<T> {
    public b() {
    }

    public final b<T> c() {
        if (ZeusTransformUtils.instanceOf(this, a.class) == false) goto L6;
        return this;
    L6:
        return new a(this);
    }
}
