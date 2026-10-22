package obric.flow.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ST.IMPLICIT_ARG_NAME, "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetryKt$retryOrThrow$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final RetryKt$retryOrThrow$2 INSTANCE = null;

    static {
        INSTANCE = new RetryKt$retryOrThrow$2();
    }

    public RetryKt$retryOrThrow$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }
}
