package kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u000f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u000f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"check", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkNotNull", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "error", "", "message", "require", "requireNotNull", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/PreconditionsKt")
@SourceDebugExtension({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    public PreconditionsKt__PreconditionsKt() {
    }

    @InlineOnly
    private static final void check(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException("Check failed.");
    }

    @InlineOnly
    private static final <T> T checkNotNull(T r5) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new IllegalStateException("Required value was null.");
    }

    @InlineOnly
    private static final Void error(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        throw new IllegalStateException(r5.toString());
    }

    @InlineOnly
    private static final void require(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @InlineOnly
    private static final <T> T requireNotNull(T r5) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new IllegalArgumentException("Required value was null.");
    }

    @InlineOnly
    private static final void check(boolean r5, Function0<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "lazyMessage");
        if (r5 == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(r10.invoke().toString());
    }

    @InlineOnly
    private static final <T> T checkNotNull(T r5, Function0<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "lazyMessage");
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException(r10.invoke().toString());
    }

    @InlineOnly
    private static final void require(boolean r5, Function0<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "lazyMessage");
        if (r5 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r10.invoke().toString());
    }

    @InlineOnly
    private static final <T> T requireNotNull(T r5, Function0<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "lazyMessage");
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException(r10.invoke().toString());
    }
}
