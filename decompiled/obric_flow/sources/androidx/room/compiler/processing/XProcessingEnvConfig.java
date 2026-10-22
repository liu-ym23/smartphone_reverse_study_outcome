package androidx.room.compiler.processing;

import androidx.constraintlayout.motion.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnvConfig;", "", "excludeMethodsWithInvalidJvmSourceNames", "", "disableAnnotatedElementValidation", "(ZZ)V", "getDisableAnnotatedElementValidation", "()Z", "getExcludeMethodsWithInvalidJvmSourceNames", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toBuilder", "Landroidx/room/compiler/processing/XProcessingEnvConfig$Builder;", "toString", "", "Builder", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XProcessingEnvConfig {
    public static final Companion Companion = null;
    private static final XProcessingEnvConfig DEFAULT = null;
    private final boolean disableAnnotatedElementValidation;
    private final boolean excludeMethodsWithInvalidJvmSourceNames;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnvConfig$Builder;", "", "baseline", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "(Landroidx/room/compiler/processing/XProcessingEnvConfig;)V", "instance", "build", "disableAnnotatedElementValidation", "value", "", "excludeMethodsWithInvalidJvmSourceNames", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private XProcessingEnvConfig instance;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final XProcessingEnvConfig build() {
            return this.instance;
        }

        public final Builder disableAnnotatedElementValidation(boolean r5) {
            this.instance = XProcessingEnvConfig.copy$default(this.instance, false, r5, 1, null);
            return this;
        }

        public final Builder excludeMethodsWithInvalidJvmSourceNames(boolean r5) {
            this.instance = XProcessingEnvConfig.copy$default(this.instance, r5, false, 2, null);
            return this;
        }

        public Builder(XProcessingEnvConfig r5) {
            Intrinsics.checkNotNullParameter(r5, "baseline");
            this.instance = r5;
        }

        public /* synthetic */ Builder(XProcessingEnvConfig r5, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            boolean r12 = false;
            r5 = new XProcessingEnvConfig(r12, r12, 3, null);
        L5:
            this(r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnvConfig$Companion;", "", "()V", "DEFAULT", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "getDEFAULT", "()Landroidx/room/compiler/processing/XProcessingEnvConfig;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XProcessingEnvConfig getDEFAULT() {
            return XProcessingEnvConfig.access$getDEFAULT$cp();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new Companion(null);
        Object[] r5 = 0 == true ? 1 : 0;
        DEFAULT = new Builder(r5, 1, 0 == true ? 1 : 0).build();
    }

    private XProcessingEnvConfig(boolean r5, boolean r10) {
        this.excludeMethodsWithInvalidJvmSourceNames = r5;
        this.disableAnnotatedElementValidation = r10;
    }

    public static final /* synthetic */ XProcessingEnvConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ XProcessingEnvConfig copy$default(XProcessingEnvConfig r5, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.excludeMethodsWithInvalidJvmSourceNames;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.disableAnnotatedElementValidation;
    L9:
        return r5.copy(r10, r11);
    }

    public final boolean component1() {
        return this.excludeMethodsWithInvalidJvmSourceNames;
    }

    public final boolean component2() {
        return this.disableAnnotatedElementValidation;
    }

    public final XProcessingEnvConfig copy(boolean r5, boolean r10) {
        return new XProcessingEnvConfig(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof XProcessingEnvConfig) == true) goto L8;
        return false;
    L8:
        XProcessingEnvConfig r10 = (XProcessingEnvConfig) r5;
        if (this.excludeMethodsWithInvalidJvmSourceNames == r10.excludeMethodsWithInvalidJvmSourceNames) goto L12;
        return false;
    L12:
        if (this.disableAnnotatedElementValidation == r10.disableAnnotatedElementValidation) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean getDisableAnnotatedElementValidation() {
        return this.disableAnnotatedElementValidation;
    }

    public final boolean getExcludeMethodsWithInvalidJvmSourceNames() {
        return this.excludeMethodsWithInvalidJvmSourceNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r5 = this.excludeMethodsWithInvalidJvmSourceNames;
        ?? r10 = 1;
        ?? r11 = r5;
        if (r5 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = r11 * 31;
        boolean r13 = this.disableAnnotatedElementValidation;
        if (r13 == true) goto L10;
        r10 = r13;
    L10:
        return r12 + r10;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("XProcessingEnvConfig(excludeMethodsWithInvalidJvmSourceNames=");
        r5.append(this.excludeMethodsWithInvalidJvmSourceNames);
        r5.append(", disableAnnotatedElementValidation=");
        return a.w(r5, this.disableAnnotatedElementValidation, ')');
    }

    public /* synthetic */ XProcessingEnvConfig(boolean r5, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = false;
    L8:
        this(r5, r10);
    }
}
