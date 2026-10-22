package com.obric.memorydata.database.c;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/review/MemoryReviewSnapshotSyncState;", "", "<init>", "()V", "disabledDepth", "com/obric/memorydata/database/review/MemoryReviewSnapshotSyncState$disabledDepth$1", "Lcom/obric/memorydata/database/review/MemoryReviewSnapshotSyncState$disabledDepth$1;", "isDisabled", "", "disabled", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f8858b = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/memorydata/database/review/MemoryReviewSnapshotSyncState$disabledDepth$1", "Ljava/lang/ThreadLocal;", "", "initialValue", "()Ljava/lang/Integer;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ThreadLocal<Integer> {
        a() {
        }

        public Integer a() {
            return 0;
        }

        @Override // java.lang.ThreadLocal
        public /* synthetic */ Integer initialValue() {
            return a();
        }
    }

    static {
        f8857a = new e();
        f8858b = new a();
    }

    private e() {
    }

    public final <T> T a(Function0<? extends T> r4) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "block");
        a r5 = f8858b;
        r5.set(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5.get(), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));
        T r6 = (T) r3.invoke();
        r5.set(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5.get(), Number.class, "com.obric.memorydata.plugin")).intValue() - 1));
        return r6;
    L6:
        th = move-exception;
        f8858b.set(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(f8858b.get(), Number.class, "com.obric.memorydata.plugin")).intValue() - 1));
        throw th;
    }

    public final boolean a() {
        if (((Number) ZeusTransformUtils.preCheckCast(f8858b.get(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
