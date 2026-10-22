package androidx.room.solver;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\u0006\u0010\f\u001a\u0002H\u0007¢\u0006\u0002\u0010\rR\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/solver/TypeAdapterExtras;", "", "()V", "data", "", "Lkotlin/reflect/KClass;", "getData", ExifInterface.GPS_DIRECTION_TRUE, STGroup.DICT_KEY, "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "putData", "", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypeAdapterExtras {
    private final Map<KClass<?>, Object> data;

    public TypeAdapterExtras() {
        this.data = new LinkedHashMap();
    }

    public final <T> T getData(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return (T) this.data.get(r5);
    }

    public final <T> void putData(KClass<T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "value");
        this.data.put(r5, r10);
    }
}
