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
    public Jsr305Settings(ReportLevel r5, ReportLevel r10, Map<FqName, ? extends ReportLevel> r11) {
        Intrinsics.checkNotNullParameter(r5, "globalLevel");
        Intrinsics.checkNotNullParameter(r11, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = r5;
        this.migrationLevel = r10;
        this.userDefinedLevelForSpecificAnnotation = r11;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$description$2(this));
        ReportLevel r12 = ReportLevel.IGNORE;
        if (r5 != r12) goto L8;
        if (r10 != r12) goto L8;
        if (r11.isEmpty() == false) goto L8;
        boolean r13 = true;
    L9:
        this.isDisabled = r13;
        return;
    L8:
        r13 = false;
        goto L9
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Jsr305Settings) == true) goto L8;
        return false;
    L8:
        Jsr305Settings r10 = (Jsr305Settings) r5;
        if (this.globalLevel == r10.globalLevel) goto L12;
        return false;
    L12:
        if (this.migrationLevel == r10.migrationLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, r10.userDefinedLevelForSpecificAnnotation) == true) goto L17;
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
        int r5 = this.globalLevel.hashCode() * 31;
        ReportLevel r10 = this.migrationLevel;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = this.userDefinedLevelForSpecificAnnotation.hashCode();
        return r12 + ((r5 + r11) * 31);
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public /* synthetic */ Jsr305Settings(ReportLevel r5, ReportLevel r10, Map r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = MapsKt.emptyMap();
    L8:
        this(r5, r10, r11);
    }
}
