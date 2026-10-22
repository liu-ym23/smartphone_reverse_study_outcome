package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import il.p;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"Landroidx/room/compiler/processing/ksp/ReferenceStack;", "", "<init>", "()V", "Lil/p;", "ksType", "", "contains", "(Lil/p;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "withReference", "(Lil/p;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/collections/ArrayDeque;", "_queue", "Lkotlin/collections/ArrayDeque;", "get_queue", "()Lkotlin/collections/ArrayDeque;", "get_queue$annotations", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ReferenceStack {
    private final ArrayDeque<p> _queue;

    public ReferenceStack() {
        this._queue = new ArrayDeque();
    }

    public static /* synthetic */ void get_queue$annotations() {
    }

    public final boolean contains(p r5) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        return this._queue.contains(r5);
    }

    public final ArrayDeque<p> get_queue() {
        return this._queue;
    }

    public final <T> T withReference(p r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        Intrinsics.checkNotNullParameter(r10, "block");
        get_queue().addLast(r5);     // Catch: Throwable -> L6
        T r11 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        get_queue().removeLast();
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        get_queue().removeLast();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
