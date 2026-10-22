package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4297a;

    private h(h r1) {
        this.f4297a = r1.f4297a;
    }

    /* synthetic */ h(h r1, AnonymousClass1 r2) {
        this(r1);
    }

    private h(String r3) {
        this.f4297a = (String) ZeusTransformUtils.preCheckCast(n.a(r3), String.class, "com.obric.memorydata.plugin");
    }

    public static h a(char r1) {
        return new h(String.valueOf(r1));
    }

    public static h a(String r1) {
        return new h(r1);
    }

    public <A extends Appendable> A a(A r3, Iterator<? extends Object> r4) {
        A r5 = (A) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        n.a(r5);
        if (r6.hasNext() == false) goto L7;
    L4:
        r5.append(a(r6.next()));
        if (r6.hasNext() == false) goto L7;
        r5.append(this.f4297a);
    L7:
        return r5;
    }

    CharSequence a(Object r2) {
        Objects.requireNonNull(r2);
        if (ZeusTransformUtils.instanceOf(r2, CharSequence.class) == false) goto L6;
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L6:
        return r2.toString();
    }

    public final String a(Iterable<? extends Object> r3) {
        return a(((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    public final String a(Iterator<? extends Object> r3) {
        Iterator<? extends Object> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        return a(new StringBuilder(), r4).toString();
    }

    public final String a(Object[] r1) {
        return a(Arrays.asList(r1));
    }

    public final StringBuilder a(StringBuilder r3, Iterator<? extends Object> r4) {
        a(r3, (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L5
        return r3;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public h b(final String r2) {
        n.a(r2);
        return new AnonymousClass1(this, this, r2);
    }
}
