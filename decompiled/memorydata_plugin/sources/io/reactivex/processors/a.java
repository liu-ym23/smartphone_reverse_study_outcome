package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T> extends g<T> implements j<T>, org.a.a<T, T> {
    public a() {
    }

    public final a<T> b() {
        if (ZeusTransformUtils.instanceOf(this, b.class) == false) goto L6;
        return this;
    L6:
        return new b(this);
    }
}
