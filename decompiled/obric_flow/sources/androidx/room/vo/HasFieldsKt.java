package androidx.room.vo;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"columnNames", "", "", "Landroidx/room/vo/HasFields;", "getColumnNames", "(Landroidx/room/vo/HasFields;)Ljava/util/List;", "findFieldByColumnName", "Landroidx/room/vo/Field;", "columnName", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HasFieldsKt {
    public static final Field findFieldByColumnName(HasFields r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "columnName");
        Iterator<Field> r11 = r5.getFields().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Field r12 = r11.next();
        if (Intrinsics.areEqual(r12.getColumnName(), r10) == false) goto L4;
    L10:
        return r12;
    L8:
        r12 = null;
        goto L10
    }

    public static final List<String> getColumnNames(HasFields r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getFields().getColumnNames$room_compiler();
    }
}
