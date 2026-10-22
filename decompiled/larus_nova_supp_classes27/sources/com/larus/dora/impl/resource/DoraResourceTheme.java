package com.larus.dora.impl.resource;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceTheme;", "", "directoryName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDirectoryName", "()Ljava/lang/String;", "LIGHT", "NIGHT", "lookupOrder", "", "getLookupOrder$impl_mainlandRelease", "()Ljava/util/List;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceTheme extends Enum<DoraResourceTheme> {
    public static final DoraResourceTheme LIGHT = null;
    public static final DoraResourceTheme NIGHT = null;
    public static final /* synthetic */ DoraResourceTheme[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String directoryName;

    public static EnumEntries<DoraResourceTheme> getEntries() {
        return b;
    }

    static {
        DoraResourceTheme r0 = new DoraResourceTheme("LIGHT", 0, "light");
        LIGHT = r0;
        DoraResourceTheme r1 = new DoraResourceTheme("NIGHT", 1, "night");
        NIGHT = r1;
        DoraResourceTheme[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static DoraResourceTheme[] values() {
        return (DoraResourceTheme[]) a.clone();
    }

    public final List<DoraResourceTheme> getLookupOrder$impl_mainlandRelease() {
        DoraResourceTheme r0 = NIGHT;
        if (this != r0) goto L6;
        return CollectionsKt.listOf(new DoraResourceTheme[]{r0, LIGHT});
    L6:
        return CollectionsKt.listOf(LIGHT);
    }

    public final String getDirectoryName() {
        return this.directoryName;
    }

    public static DoraResourceTheme valueOf(String r1) {
        return (DoraResourceTheme) a.a(DoraResourceTheme.class, r1);
    }

    public DoraResourceTheme(String r1, int r2, String r3) {
        super(r1, r2);
        this.directoryName = r3;
    }
}
