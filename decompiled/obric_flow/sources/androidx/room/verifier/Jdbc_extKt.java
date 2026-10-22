package androidx.room.verifier;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.ext.String_extKt;
import androidx.room.parser.SQLTypeAffinity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\bH\u0000\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\bH\u0000\u001a2\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\b2\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00020\fH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u0011\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/sql/ResultSet;", "f", "Lkotlin/Function1;", "columnInfo", "Landroidx/room/verifier/ColumnInfo;", "Ljava/sql/PreparedStatement;", "columnNames", "", "map", "Lkotlin/Function2;", "", "Ljava/sql/ResultSetMetaData;", "tryGetAffinity", "Landroidx/room/parser/SQLTypeAffinity;", "columnIndex", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Jdbc_extKt {
    public static final /* synthetic */ SQLTypeAffinity access$tryGetAffinity(PreparedStatement r5, int r10) {
        return tryGetAffinity(r5, r10);
    }

    public static final <T> List<T> collect(ResultSet r5, Function1<? super ResultSet, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "f");
        ArrayList r11 = new ArrayList();
    L13:
    L7:
        th = move-exception;
        r5.close();
        throw th;
    L4:
        if (r5.next() == false) goto L9;
        r11.add(r10.invoke(r5));     // Catch: Throwable -> L7
        goto L13
    L9:
        r5.close();
        return r11;
    }

    public static final List<ColumnInfo> columnInfo(final PreparedStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return map(r5, new AnonymousClass1(r5));
    }

    public static final List<String> columnNames(PreparedStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return map(r5, C01441.INSTANCE);
    }

    private static final <T> List<T> map(PreparedStatement r5, Function2<? super Integer, ? super ResultSetMetaData, ? extends T> r10) {
        int r11 = r5.getMetaData().getColumnCount();     // Catch: SQLException -> L4
    L5:
        IntRange r12 = new IntRange(1, r11);
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<Integer> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r13.add(r10.mo2invoke(Integer.valueOf(((IntIterator) r14).nextInt()), r5.getMetaData()));
        goto L7
    L9:
        return r13;
    L4:
        r11 = 0;
        goto L5
    }

    private static final SQLTypeAffinity tryGetAffinity(PreparedStatement r5, int r10) {
        return SQLTypeAffinity.valueOf(String_extKt.capitalize(r5.getMetaData().getColumnTypeName(r10), Locale.US));
    L5:
        return SQLTypeAffinity.NULL;
    }
}
