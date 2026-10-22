package com.obric.memorydata.database.manager;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/manager/ContentTimeIndexCleanup;", "", "<init>", "()V", "clear", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "contentTimeTables", "", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9559a = null;

    static {
        f9559a = new a();
    }

    private a() {
    }

    public final void a(SupportSQLiteDatabase r4, List<String> r5) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "database");
        Intrinsics.checkNotNullParameter(r6, "contentTimeTables");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r3.execSQL("DELETE FROM `" + ((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) + '`');
        goto L4
    }
}
