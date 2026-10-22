package com.bytedance.als.dsl;

import android.os.SystemClock;
import com.bytedance.als.lazy.ALSInternalLazyHelperComponent;
import com.bytedance.objectcontainer.ObjectContainer;
import e6.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/als/b;", "API_COMPONENT", "Lcom/bytedance/als/LogicComponent;", "LOGIC_COMPONENT", "Lcom/bytedance/objectcontainer/ObjectContainer;", "it", "invoke", "(Lcom/bytedance/objectcontainer/ObjectContainer;)Lcom/bytedance/als/LogicComponent;", "com/bytedance/als/dsl/AlsComponentBuilder$component$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class AlsComponentBuilder$$special$$inlined$component$1 extends Lambda implements Function1<ObjectContainer, ALSInternalLazyHelperComponent> {
    final /* synthetic */ ComponentNothingBuilder $builder;
    final /* synthetic */ AlsComponentBuilder this$0;

    public AlsComponentBuilder$$special$$inlined$component$1(AlsComponentBuilder r1, ComponentNothingBuilder r10) {
        super(1);
    }

    public final ALSInternalLazyHelperComponent invoke(ObjectContainer r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        int r0 = b.a;
        SystemClock.uptimeMillis();
        new ALSInternalLazyHelperComponent(r10);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ObjectContainer) r1);
    }
}
