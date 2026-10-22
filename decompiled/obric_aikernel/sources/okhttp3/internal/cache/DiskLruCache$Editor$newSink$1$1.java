package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class DiskLruCache$Editor$newSink$1$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ c this$0;
    final /* synthetic */ c.b this$1;

    DiskLruCache$Editor$newSink$1$1(c r10, c.b r11) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IOException r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOException r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        throw null;
    }
}
