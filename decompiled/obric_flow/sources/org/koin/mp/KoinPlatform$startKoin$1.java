package org.koin.mp;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.b;
import org.koin.core.logger.Level;
import uu.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lorg/koin/core/b;", "", "invoke", "(Lorg/koin/core/b;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class KoinPlatform$startKoin$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Level $level;
    final /* synthetic */ List<a> $modules;

    public KoinPlatform$startKoin$1(Level r5, List<a> r10) {
        this.$level = r5;
        this.$modules = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$startKoin");
        Level r10 = this.$level;
        Intrinsics.checkNotNullParameter(r10, "level");
        tu.a r11 = new tu.a(r10);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "logger");
        org.koin.core.a r12 = r5.f21002a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "logger");
        r12.f21001c = r11;
        r5.a(this.$modules);
    }
}
