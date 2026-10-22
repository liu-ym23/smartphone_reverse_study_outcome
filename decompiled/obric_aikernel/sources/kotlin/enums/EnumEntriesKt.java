package kotlin.enums;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumEntriesKt {
    @SinceKotlin(version = "1.8")
    @PublishedApi
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(Function0<E[]> r10) {
        Intrinsics.checkNotNullParameter(r10, "entriesProvider");
        return new EnumEntriesList(r10.invoke());
    }

    @SinceKotlin(version = "1.8")
    @PublishedApi
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entries");
        return new EnumEntriesList(r10);
    }
}
