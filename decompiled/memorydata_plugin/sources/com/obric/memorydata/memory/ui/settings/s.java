package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptOutStore;", "", "readDisabled", "Lkotlin/Function0;", "", "writeDisabled", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "isDisabled", "markDisabled", "clear", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f11505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Boolean, Unit> f11506b;

    public s(Function0<Boolean> r3, Function1<? super Boolean, Unit> r4) {
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "readDisabled");
        Intrinsics.checkNotNullParameter(r6, "writeDisabled");
        this.f11505a = r5;
        this.f11506b = r6;
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f11505a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final void b() {
        this.f11506b.invoke(true);
    }

    public final void c() {
        this.f11506b.invoke(false);
    }
}
