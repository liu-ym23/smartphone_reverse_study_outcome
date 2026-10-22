package com.bytedance.ai.resource.core.db;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J6\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column", "", "name", "", "type", "notNull", "defaultValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "getNotNull", "getDefaultValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column;", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column {
    private final String defaultValue;
    private final String name;
    private final String notNull;
    private final String type;

    public AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "notNull");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        this.name = r5;
        this.type = r10;
        this.notNull = r11;
        this.defaultValue = r12;
    }

    public static /* synthetic */ AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column copy$default(AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column r5, String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.notNull;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.defaultValue;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.notNull;
    }

    public final String component4() {
        return this.defaultValue;
    }

    public final AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column copy(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "notNull");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        return new AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column) == true) goto L8;
        return false;
    L8:
        AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column r10 = (AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notNull, r10.notNull) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultValue, r10.defaultValue) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNotNull() {
        return this.notNull;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = kk.a.b(this.type, r5, 31);
        int r11 = kk.a.b(this.notNull, r10, 31);
        return this.defaultValue.hashCode() + r11;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Column(name=");
        r5.append(this.name);
        r5.append(", type=");
        r5.append(this.type);
        r5.append(", notNull=");
        r5.append(this.notNull);
        r5.append(", defaultValue=");
        return j0.p(r5, this.defaultValue, ')');
    }
}
