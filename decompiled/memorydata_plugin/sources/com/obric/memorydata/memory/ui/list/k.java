package com.obric.memorydata.memory.ui.list;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/LongPressItemPressState;", "", "<init>", "()V", "currentViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "setCurrentPressed", "Lkotlin/Function2;", "", "", "show", "view", "setPressed", "clear", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<View> f11316b;
    private static Function2<? super View, ? super Boolean, Unit> c;

    static {
        f11315a = new k();
    }

    private k() {
    }

    public final void a() {
        WeakReference<View> r2 = f11316b;
        if (r2 == null) goto L9;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        Function2<? super View, ? super Boolean, Unit> r0 = c;
        if (r0 == null) goto L9;
        r0.invoke(r3, false);
    L9:
        c = null;
        f11316b = null;
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        WeakReference<View> r0 = f11316b;
        if (r0 == null) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != r4) goto L9;
        a();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void a(View r4, Function2<? super View, ? super Boolean, Unit> r5) {
        Function2<? super View, ? super Boolean, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "setPressed");
        WeakReference<View> r0 = f11316b;
        if (r0 == null) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == r4) goto L8;
        a();
    L8:
        r6.invoke(r4, true);
        f11316b = new WeakReference(r4);
        c = r6;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
