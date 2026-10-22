package e0c;

import android.app.Application;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public static final <T> T a(Application r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r1, DwarfSPIEntryPoint.class)).dwarfSPI().get(r2);
    }

    public static final <T> T b(l r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r1, DwarfSPIEntryPoint.class)).dwarfSPI().get(r2);
    }
}
