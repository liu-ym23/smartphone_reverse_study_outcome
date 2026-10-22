package com.obric.assistant.window;

import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/window/ObricWindowComponentRegistry;", "Lcom/larus/ui/arch/modulizer/di/IComponentRegistry;", "<init>", "()V", "register", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowComponentRegistry implements IComponentRegistry {
    public ObricWindowComponentRegistry() {
    }

    public final int priority() {
        return 0;
    }

    public final void register() {
        IComponentRegistry.a r0 = IComponentRegistry.a;
        Function1 r1 = new n1();
        r0.getClass();
        IComponentRegistry.a.b(r1);
    }
}
