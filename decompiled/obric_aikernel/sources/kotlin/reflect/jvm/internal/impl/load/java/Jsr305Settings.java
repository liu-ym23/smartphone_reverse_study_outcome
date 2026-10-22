package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel r10, ReportLevel r11, Map<FqName, ? extends ReportLevel> r12) {
        Intrinsics.checkNotNullParameter(r10, "globalLevel");
        Intrinsics.checkNotNullParameter(r12, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = r10;
        this.migrationLevel = r11;
        this.userDefinedLevelForSpecificAnnotation = r12;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$description$2(this));
        ReportLevel r13 = ReportLevel.IGNORE;
        if (r10 != r13) goto L8;
        if (r11 != r13) goto L8;
        if (r12.isEmpty() == false) goto L8;
        boolean r14 = true;
    L9:
        this.isDisabled = r14;
        return;
    L8:
        r14 = false;
        goto L9
    }

    public /* synthetic */ Jsr305Settings(ReportLevel r10, ReportLevel r11, Map r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = MapsKt.emptyMap();
    L8:
        this(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Jsr305Settings) == true) goto L8;
        return false;
    L8:
        Jsr305Settings r11 = (Jsr305Settings) r10;
        if (this.globalLevel == r11.globalLevel) goto L12;
        return false;
    L12:
        if (this.migrationLevel == r11.migrationLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, r11.userDefinedLevelForSpecificAnnotation) == true) goto L17;
        return false;
    L17:
        return true;
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

    public int hashCode() {
        int r10 = this.globalLevel.hashCode() * 31;
        ReportLevel r11 = this.migrationLevel;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((r10 + r12) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }
}
