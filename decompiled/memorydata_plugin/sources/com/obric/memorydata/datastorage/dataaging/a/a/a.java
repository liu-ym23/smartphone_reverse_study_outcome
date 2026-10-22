package com.obric.memorydata.datastorage.dataaging.a.a;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J=\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\bH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/wrapper/intf/IDatabaseWrapper;", "", "getNthElementPrimaryKeySortedByAutoIncrementPrimaryKey", "", "tableName", "autoIncrementPrimaryKeyName", "whereClause", "n", "", "deleteRowsByCondition", "queryPrimaryKeyValuesByCondition", "", "", "primaryKey", "afterPrimaryKey", "limit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)Ljava/util/List;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {
    int a(String r1, String r2);

    String a(String r1, String r2, String r3, int r4);

    List<Long> a(String r1, String r2, String r3);

    List<Long> a(String r1, String r2, String r3, Long r4, int r5);
}
