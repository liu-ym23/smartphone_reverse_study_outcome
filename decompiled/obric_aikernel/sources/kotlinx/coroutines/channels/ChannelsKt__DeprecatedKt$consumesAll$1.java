package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n75#2:480\n1#3:481\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n*L\n26#1:480\n*E\n"})
final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ReceiveChannel<?>[] $channels;

    ChannelsKt__DeprecatedKt$consumesAll$1(ReceiveChannel<?>[] r10) {
        this.$channels = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r10) {
        ReceiveChannel<?>[] r11 = this.$channels;
        int r12 = r11.length;
        Throwable r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L12;
        i.b(r11[r14], r10);     // Catch: Throwable -> L7
    L11:
        r14 = r14 + 1;
    L7:
        th = move-exception;
        if (r13 != null) goto L10;
        r13 = th;
        goto L11
    L10:
        ExceptionsKt.addSuppressed(r13, th);
        goto L11
    L12:
        if (r13 != null) goto L14;
        return;
    L14:
        throw r13;
    }
}
