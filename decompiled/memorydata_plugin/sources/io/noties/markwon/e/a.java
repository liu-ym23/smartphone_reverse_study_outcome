package io.noties.markwon.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/pool/ReuseDrawablePool;", "", "()V", "pool", "", "Lio/noties/markwon/image/AsyncDrawable;", "clear", "", "obtain", "predict", "Lkotlin/Function1;", "", "recycle", "drawable", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<io.noties.markwon.a.a> f16487a;

    public final io.noties.markwon.a.a a(Function1<? super io.noties.markwon.a.a, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "predict");
        Iterator<io.noties.markwon.a.a> r0 = this.f16487a.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r0.next()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 >= 0) goto L16;
        return null;
    L16:
        return (io.noties.markwon.a.a) ZeusTransformUtils.preCheckCast(this.f16487a.remove(r2), io.noties.markwon.a.a.class, "com.obric.memorydata.plugin");
    L9:
        r2 = -1;
        goto L10
    }
}
