package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"toExpandedRecordsList", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes$Record;", "metadata.jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmNameResolverKt {
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(List<JvmProtoBuf.StringTableTypes.Record> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        r10.ensureCapacity(r5.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        JvmProtoBuf.StringTableTypes.Record r12 = r11.next();
        int r13 = r12.getRange();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L4;
        r10.add(r12);
        r14 = r14 + 1;
        goto L6
    L8:
        r10.trimToSize();
        return r10;
    }
}
