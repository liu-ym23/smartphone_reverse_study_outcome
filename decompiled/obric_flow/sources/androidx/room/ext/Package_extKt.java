package androidx.room.ext;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003¨\u0006\u0014"}, d2 = {"COLLECTION_PACKAGE", "", "getCOLLECTION_PACKAGE", "()Ljava/lang/String;", "LIFECYCLE_PACKAGE", "getLIFECYCLE_PACKAGE", "PACKAGE_NAME_OVERRIDES", "", "getPACKAGE_NAME_OVERRIDES", "()Ljava/util/Map;", "PACKAGE_NAME_OVERRIDES$delegate", "Lkotlin/Lazy;", "PAGING_PACKAGE", "getPAGING_PACKAGE", "ROOM_PACKAGE", "getROOM_PACKAGE", "SQLITE_PACKAGE", "getSQLITE_PACKAGE", "getOrDefault", STGroup.DICT_KEY, "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Package_extKt {
    private static final String COLLECTION_PACKAGE = null;
    private static final String LIFECYCLE_PACKAGE = null;
    private static final Lazy PACKAGE_NAME_OVERRIDES$delegate = null;
    private static final String PAGING_PACKAGE = null;
    private static final String ROOM_PACKAGE = null;
    private static final String SQLITE_PACKAGE = null;

    static {
        PACKAGE_NAME_OVERRIDES$delegate = LazyKt.lazy(Package_extKt$PACKAGE_NAME_OVERRIDES$2.INSTANCE);
        SQLITE_PACKAGE = getOrDefault("androidx.sqlite");
        ROOM_PACKAGE = getOrDefault("androidx.room");
        PAGING_PACKAGE = getOrDefault("androidx.paging");
        LIFECYCLE_PACKAGE = getOrDefault("androidx.lifecycle");
        COLLECTION_PACKAGE = getOrDefault("androidx.collection");
    }

    public static final String getCOLLECTION_PACKAGE() {
        return COLLECTION_PACKAGE;
    }

    public static final String getLIFECYCLE_PACKAGE() {
        return LIFECYCLE_PACKAGE;
    }

    private static final String getOrDefault(String r5) {
        return getPACKAGE_NAME_OVERRIDES().getOrDefault(r5, r5);
    }

    private static final Map<String, String> getPACKAGE_NAME_OVERRIDES() {
        return (Map) PACKAGE_NAME_OVERRIDES$delegate.getValue();
    }

    public static final String getPAGING_PACKAGE() {
        return PAGING_PACKAGE;
    }

    public static final String getROOM_PACKAGE() {
        return ROOM_PACKAGE;
    }

    public static final String getSQLITE_PACKAGE() {
        return SQLITE_PACKAGE;
    }
}
