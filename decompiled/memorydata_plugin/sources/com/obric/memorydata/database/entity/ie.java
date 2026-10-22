package com.obric.memorydata.database.entity;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"runWithPostCommitIndex", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "write", "Lkotlin/Function0;", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ie {
    public static final <T> T a(final RoomDatabase r2, Function0<? extends T> r3) {
        Function0<? extends T> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "write");
        if (r2.inTransaction() == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return (T) id.f9213a.a(new $$Lambda$ie$R_5w3hJbY_Hr_RKdaIzXiRaj70(r2), r4);
    L13:
        throw new IllegalStateException("semantic write requires the outer transaction to own post-commit index registration".toString());
    L5:
        if (id.f9213a.a() == true) goto L8;
        r0 = false;
        goto L9
    }

    private static final Object a(Function0 r2) {
        return ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final Object b(RoomDatabase r2, Function0 r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        return r2.runInTransaction(new $$Lambda$ie$2aWcj_tC5wCUTEpYM6EjD7mVY(r4));
    }

    /* JADX INFO: renamed from: lambda$2aWcj_tC-5wCUTEp-YM6EjD7mVY, reason: not valid java name */
    public static /* synthetic */ Object m552lambda$2aWcj_tC5wCUTEpYM6EjD7mVY(Function0 r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$R_5w3hJbY_Hr-_RKdaIzXiRaj70, reason: not valid java name */
    public static /* synthetic */ Object m553lambda$R_5w3hJbY_Hr_RKdaIzXiRaj70(RoomDatabase r0, Function0 r1) {
        return b(r0, r1);
    }
}
