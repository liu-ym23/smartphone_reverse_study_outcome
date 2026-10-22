package androidx.room.paging.util;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u0001\u001a$\u0010\u000b\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001ah\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u00190\u0017\u001a\u0016\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a'\u0010\u001b\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u000f*\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u000f0\u001c¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"INITIAL_ITEM_COUNT", "", "INVALID", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "", "getINVALID", "()Landroidx/paging/PagingSource$LoadResult$Invalid;", "getLimit", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "key", "getOffset", "itemCount", "queryDatabase", "Landroidx/paging/PagingSource$LoadResult;", "Value", "sourceQuery", "Landroidx/room/RoomSQLiteQuery;", "db", "Landroidx/room/RoomDatabase;", "cancellationSignal", "Landroid/os/CancellationSignal;", "convertRows", "Lkotlin/Function1;", "Landroid/database/Cursor;", "", "queryItemCount", "getClippedRefreshKey", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "room-paging_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoomPagingUtilKt {
    public static final int INITIAL_ITEM_COUNT = -1;
    private static final PagingSource.LoadResult.Invalid<Object, Object> INVALID = null;

    static {
        INVALID = new PagingSource.LoadResult.Invalid();
    }

    public static final <Value> Integer getClippedRefreshKey(PagingState<Integer, Value> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Integer r0 = r2.getAnchorPosition();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(Math.max(0, r0.intValue() - (r2.getConfig().initialLoadSize / 2)));
    }

    public static final PagingSource.LoadResult.Invalid<Object, Object> getINVALID() {
        return INVALID;
    }

    public static final int getLimit(PagingSource.LoadParams<Integer> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        if (ZeusTransformUtils.instanceOf(r1, PagingSource.LoadParams.Prepend.class) == false) goto L8;
        if (r2 >= r1.getLoadSize()) goto L8;
        return r2;
    L8:
        return r1.getLoadSize();
    }

    public static final int getOffset(PagingSource.LoadParams<Integer> r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        if (ZeusTransformUtils.instanceOf(r2, PagingSource.LoadParams.Prepend.class) == false) goto L9;
        if (r3 >= r2.getLoadSize()) goto L19;
        return 0;
    L19:
        return r3 - r2.getLoadSize();
    L9:
        if (ZeusTransformUtils.instanceOf(r2, PagingSource.LoadParams.Append.class) == false) goto L12;
        return r3;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, PagingSource.LoadParams.Refresh.class) == false) goto L17;
        if (r3 >= r4) goto L15;
        return r3;
    L15:
        return Math.max(0, r4 - r2.getLoadSize());
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public static final <Value> PagingSource.LoadResult<Integer, Value> queryDatabase(PagingSource.LoadParams<Integer> r10, RoomSQLiteQuery r11, RoomDatabase r12, int r13, CancellationSignal r14, Function1<? super Cursor, ? extends List<? extends Value>> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r11, "sourceQuery");
        Intrinsics.checkNotNullParameter(r12, "db");
        Intrinsics.checkNotNullParameter(r16, "convertRows");
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r10.getKey(), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r3 = getLimit(r10, r1);
        int r8 = getOffset(r10, r1, r13);
        RoomSQLiteQuery r17 = RoomSQLiteQuery.Companion.acquire("SELECT * FROM ( " + r11.getSql() + " ) LIMIT " + r3 + " OFFSET " + r8, r11.getArgCount());
        r17.copyArgumentsFrom(r11);
        Cursor r18 = r12.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r17, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"), r14);
        List r5 = (List) ZeusTransformUtils.preCheckCast(r16.invoke(r18), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        r18.close();
        r17.release();
        int r19 = r5.size() + r8;
        if (r5.isEmpty() == false) goto L11;
    L15:
        Integer r110 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
    L16:
        Integer r7 = r110;
        if (r8 > 0) goto L19;
    L22:
        Integer r6 = null;
    L24:
        return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page(r5, r6, r7, r8, Math.max(0, r13 - r19)), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
    L19:
        if (r5.isEmpty() == true) goto L22;
        r6 = Integer.valueOf(r8);
        goto L24
    L11:
        if (r5.size() < r3) goto L15;
        if (r19 >= r13) goto L15;
        r110 = Integer.valueOf(r19);
    L25:
        th = move-exception;
        r18.close();
        r17.release();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public static /* synthetic */ PagingSource.LoadResult queryDatabase$default(PagingSource.LoadParams r6, RoomSQLiteQuery r7, RoomDatabase r8, int r9, CancellationSignal r10, Function1 r11, int r12, Object r13) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        if ((r12 & 16) == 0) goto L6;
        r10 = null;
    L6:
        return queryDatabase(r6, r7, r8, r9, r10, r5);
    }

    public static final int queryItemCount(RoomSQLiteQuery r3, RoomDatabase r4) {
        Intrinsics.checkNotNullParameter(r3, "sourceQuery");
        Intrinsics.checkNotNullParameter(r4, "db");
        RoomSQLiteQuery r0 = RoomSQLiteQuery.Companion.acquire("SELECT COUNT(*) FROM ( " + r3.getSql() + " )", r3.getArgCount());
        r0.copyArgumentsFrom(r3);
        Cursor r5 = RoomDatabase.query$default(r4, (SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"), null, 2, null);
    L10:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    L4:
        if (r5.moveToFirst() == false) goto L8;
        int r6 = r5.getInt(0);     // Catch: Throwable -> L10
        r5.close();
        r0.release();
        return r6;
    L8:
        r5.close();
        r0.release();
        return 0;
    }
}
