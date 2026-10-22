package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0081\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0002\b\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\b\u000eH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\u0017*\u001e\b\u0000\u0010\u001a\u001a\u0004\b\u0000\u0010\u0018\"\b\u0012\u0004\u0012\u00028\u00000\u00192\b\u0012\u0004\u0012\u00028\u00000\u0019*\f\b\u0000\u0010\u001b\"\u00020\u00002\u00020\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"", "instance", "", "identityHashCode", "(Ljava/lang/Object;)I", "R", "lock", "Lkotlin/Function0;", "block", "synchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/compose/runtime/Composer;", "composer", "", "Landroidx/compose/runtime/Composable;", "composable", "invokeComposable", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", ExifInterface.GPS_DIRECTION_TRUE, "invokeComposableForResult", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ST.IMPLICIT_ARG_NAME, "ensureMutable", "(Ljava/lang/Object;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/atomic/AtomicReference;", "AtomicReference", "TestOnly", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(Object r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
    }

    public static final int identityHashCode(Object r5) {
        return System.identityHashCode(r5);
    }

    public static final void invokeComposable(Composer r5, Function2<? super Composer, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r10, "composable");
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).mo2invoke(r5, 1);
    }

    public static final <T> T invokeComposableForResult(Composer r5, Function2<? super Composer, ? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r10, "composable");
        return (T) ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).mo2invoke(r5, 1);
    }

    @PublishedApi
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m4synchronized(Object r5, Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "lock");
        Intrinsics.checkNotNullParameter(r10, "block");
        monitor-enter(r5);
        R r11 = r10.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        return r11;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
