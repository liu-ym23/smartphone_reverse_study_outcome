package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    public static /* synthetic */ String[] accessor$Jsr305Settings$lambda0(Jsr305Settings r0) {
        return description_delegate$lambda$3(r0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Jsr305Settings) == true) goto L8;
        return false;
    L8:
        Jsr305Settings r6 = (Jsr305Settings) r5;
        if (this.globalLevel == r6.globalLevel) goto L12;
        return false;
    L12:
        if (this.migrationLevel == r6.migrationLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, r6.userDefinedLevelForSpecificAnnotation) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.globalLevel.hashCode() * 31;
        ReportLevel r1 = this.migrationLevel;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    private static final String[] description_delegate$lambda$3(Jsr305Settings r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        List r0 = CollectionsKt.createListBuilder();
        r0.add(r4.globalLevel.getDescription());
        ReportLevel r1 = r4.migrationLevel;
        if (r1 == null) goto L5;
        r0.add("under-migration:" + r1.getDescription());
    L5:
        Iterator<Map.Entry<FqName, ReportLevel>> r5 = r4.userDefinedLevelForSpecificAnnotation.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<FqName, ReportLevel> r2 = r5.next();
        r0.add("@" + r2.getKey() + ':' + r2.getValue().getDescription());
        goto L7
    L10:
        return (String[]) CollectionsKt.build(r0).toArray(new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel r2, ReportLevel r3, Map<FqName, ? extends ReportLevel> r4) {
        Intrinsics.checkNotNullParameter(r2, "globalLevel");
        Intrinsics.checkNotNullParameter(r4, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = r2;
        this.migrationLevel = r3;
        this.userDefinedLevelForSpecificAnnotation = r4;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$$Lambda$0(this));
        ReportLevel r0 = ReportLevel.IGNORE;
        if (r2 != r0) goto L8;
        if (r3 != r0) goto L8;
        if (r4.isEmpty() == false) goto L8;
        boolean r5 = true;
    L9:
        this.isDisabled = r5;
        return;
    L8:
        r5 = false;
        goto L9
    }

    public /* synthetic */ Jsr305Settings(ReportLevel r1, ReportLevel r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        this(r1, r2, r3);
    }
}
