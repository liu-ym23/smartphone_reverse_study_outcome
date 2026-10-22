package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ y<?>[] $channels;

    ChannelsKt__DeprecatedKt$consumesAll$1(y<?>[] r1) {
        this.$channels = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable r3) {
        invoke2((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r5) {
        y<?>[] r4 = this.$channels;
        int r0 = r4.length;
        Throwable r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        o.a(r4[r2], r5);     // Catch: Throwable -> L7
    L11:
        r2 = r2 + 1;
    L7:
        th = move-exception;
        if (r1 != null) goto L10;
        r1 = th;
        goto L11
    L10:
        ExceptionsKt.addSuppressed(r1, th);
        goto L11
    L12:
        if (r1 != null) goto L14;
        return;
    L14:
        throw r1;
    }
}
