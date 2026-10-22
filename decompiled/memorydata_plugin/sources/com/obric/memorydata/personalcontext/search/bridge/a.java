package com.obric.memorydata.personalcontext.search.bridge;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007J*\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u001d\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchBridgeUtils;", "", "<init>", "()V", "getRawData", "Landroid/database/Cursor;", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "getMapData", "", "", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getEntityKey", OaidModel.KEY_ID, "", "type", "", "(JLjava/lang/Integer;)Ljava/lang/String;", "cursorToMapList", "resultCursor", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12279a = null;

    static {
        f12279a = new a();
    }

    private a() {
    }

    private final List<Map<String, Object>> a(Cursor r9) {
        Cursor r8 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r9, Cursor.class, "com.obric.memorydata.plugin");
        List<Map<String, Object>> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L7:
        if (r2.moveToNext() == false) goto L12;
        Map<String, Object> r3 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        int r4 = 0;
        int r5 = r2.getColumnCount();     // Catch: Throwable -> L14
    L9:
        if (r4 >= r5) goto L11;
        r3.put(r2.getColumnName(r4), r2.getString(r4));     // Catch: Throwable -> L14
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r10.add(r3);     // Catch: Throwable -> L14
        goto L7
    L12:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r11, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L19:
        return r10;
    }

    public final Cursor a(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r3 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        MemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L8
        if (r1.isOpen() == true) goto L6;
        return null;
    L6:
        return RoomDatabase.query$default((RoomDatabase) ZeusTransformUtils.preCheckCast(r1, RoomDatabase.class, "com.obric.memorydata.plugin"), r3, null, 2, null);
    L8:
        th = move-exception;
        Ensure.ensureNotReachHere(th, "NativeEntitySearch getRawData error");
        RunLog.INSTANCE.error("NativeEntitySearch", "getRawData failed", th);
        return null;
    }

    public final String a(long r1, Integer r3) {
        if (r3 != null) goto L6;
        return String.valueOf(r1);
    L6:
        return new StringBuilder().append(r1).append('_').append(r3).toString();
    }

    public final List<Map<String, Object>> a(SupportSQLiteDatabase r3, SupportSQLiteQuery r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "db");
        Intrinsics.checkNotNullParameter(r6, ChatMessage.TYPE_QUERY);
        return a(r5.query(r6));
    }

    public final List<Map<String, Object>> b(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        return a(a(r4));
    }
}
