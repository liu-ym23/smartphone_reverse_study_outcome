package com.larus.business.markdown.impl.common;

import android.content.Context;
import android.text.method.MovementMethod;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.ext.tables.e;
import io.noties.markwon.scrollable.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/impl/common/PluginManager;", "", "()V", "_movementMethodAllowInterceptPlugin", "Lio/noties/markwon/movement/MovementMethodPlugin;", "get_movementMethodAllowInterceptPlugin", "()Lio/noties/markwon/movement/MovementMethodPlugin;", "_movementMethodAllowInterceptPlugin$delegate", "Lkotlin/Lazy;", "_movementMethodAllowInterceptPluginInstance", "_movementMethodPlugin", "get_movementMethodPlugin", "_movementMethodPlugin$delegate", "_movementMethodPluginInstance", "getMovementMethodPluginInstance", "fallBackContext", "Landroid/content/Context;", "allowParentInterceptTouchWhenOverScroll", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static io.noties.markwon.c.b f5172b;
    private static final Lazy c = null;
    private static io.noties.markwon.c.b d;
    private static final Lazy e = null;

    static {
        f5171a = new b();
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PluginManager$_movementMethodPlugin$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PluginManager$_movementMethodAllowInterceptPlugin$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ io.noties.markwon.c.b a() {
        return f5172b;
    }

    public static final /* synthetic */ void a(io.noties.markwon.c.b r0) {
        f5172b = r0;
    }

    public static final /* synthetic */ io.noties.markwon.c.b b() {
        return d;
    }

    public static final /* synthetic */ void b(io.noties.markwon.c.b r0) {
        d = r0;
    }

    private final io.noties.markwon.c.b c() {
        return (io.noties.markwon.c.b) ZeusTransformUtils.preCheckCast(c.getValue(), io.noties.markwon.c.b.class, "com.obric.memorydata.plugin");
    }

    private final io.noties.markwon.c.b d() {
        return (io.noties.markwon.c.b) ZeusTransformUtils.preCheckCast(e.getValue(), io.noties.markwon.c.b.class, "com.obric.memorydata.plugin");
    }

    public final io.noties.markwon.c.b a(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "fallBackContext");
        if (r6 == false) goto L7;
        io.noties.markwon.c.b r4 = d();
        if (r4 != null) goto L12;
        d r8 = new d(r7, (MovementMethod) ZeusTransformUtils.preCheckCast(new e((MovementMethod) ZeusTransformUtils.preCheckCast(new io.noties.markwon.c.c(), MovementMethod.class, "com.obric.memorydata.plugin")), MovementMethod.class, "com.obric.memorydata.plugin"), true);
    L10:
        io.noties.markwon.c.b r9 = io.noties.markwon.c.b.a((MovementMethod) ZeusTransformUtils.preCheckCast(r8, MovementMethod.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "create(\n                …          )\n            )");
        return r9;
    L12:
        return r4;
    L7:
        io.noties.markwon.c.b r10 = c();
        if (r10 != null) goto L13;
        r8 = new d(r7, (MovementMethod) ZeusTransformUtils.preCheckCast(new e((MovementMethod) ZeusTransformUtils.preCheckCast(new io.noties.markwon.c.c(), MovementMethod.class, "com.obric.memorydata.plugin")), MovementMethod.class, "com.obric.memorydata.plugin"), false);
        goto L10
    L13:
        return r10;
    }
}
