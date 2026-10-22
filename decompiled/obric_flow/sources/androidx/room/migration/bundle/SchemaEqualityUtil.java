package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00052\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\tJ6\u0010\u0003\u001a\u00020\u0004\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u000bJH\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/migration/bundle/SchemaEqualityUtil;", "", "()V", "checkSchemaEquality", "", "K", "Landroidx/room/migration/bundle/SchemaEquality;", "item1", "item2", "(Landroidx/room/migration/bundle/SchemaEquality;Landroidx/room/migration/bundle/SchemaEquality;)Z", "list1", "", "list2", ExifInterface.GPS_DIRECTION_TRUE, "map1", "", "map2", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SchemaEqualityUtil {
    public static final SchemaEqualityUtil INSTANCE = null;

    static {
        INSTANCE = new SchemaEqualityUtil();
    }

    private SchemaEqualityUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, K extends SchemaEquality<K>> boolean checkSchemaEquality(Map<T, ? extends K> r5, Map<T, ? extends K> r10) {
        if (r5 != null) goto L7;
        if (r10 != null) goto L23;
        return true;
    L23:
        return false;
    L7:
        if (r10 == null) goto L23;
        if (r5.size() != r10.size()) goto L23;
        Set<Map.Entry<T, ? extends K>> r11 = r5.entrySet();
        if ((r11 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L29;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (INSTANCE.checkSchemaEquality((SchemaEquality) r13.getValue(), r10.get(r13.getKey())) == true) goto L19;
    L29:
        return true;
    L15:
        if (r11.isEmpty() == false) goto L17;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K extends SchemaEquality<K>> boolean checkSchemaEquality(List<? extends K> r10, List<? extends K> r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L27;
        return true;
    L27:
        return false;
    L7:
        if (r11 == null) goto L27;
        if (r10.size() != r11.size()) goto L27;
        if (r10.isEmpty() == true) goto L34;
        Iterator<T> r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L35;
        SchemaEquality r5 = (SchemaEquality) r12.next();
        if (r11.isEmpty() == true) goto L27;
        Iterator<T> r13 = r11.iterator();
    L23:
        if (r13.hasNext() == false) goto L27;
        SchemaEquality r14 = (SchemaEquality) r13.next();
        if (INSTANCE.checkSchemaEquality(r5, r14) == false) goto L23;
    L35:
        return true;
    L34:
        return true;
    }

    public final <K extends SchemaEquality<K>> boolean checkSchemaEquality(K r5, K r10) {
        if (r5 != null) goto L6;
        if (r10 != null) goto L10;
        return true;
    L10:
        return false;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        return r5.isSchemaEqual(r10);
    }
}
