package androidx.room.solver.types;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\r\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/room/solver/types/TypeConverter;", "", "from", "Landroidx/room/compiler/processing/XType;", "to", "cost", "Landroidx/room/solver/types/TypeConverter$Cost;", "(Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/types/TypeConverter$Cost;)V", "getCost", "()Landroidx/room/solver/types/TypeConverter$Cost;", "getFrom", "()Landroidx/room/compiler/processing/XType;", "getTo", "convert", "", "inputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "", "outputVarName", "doConvert", "Cost", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TypeConverter {
    private final Cost cost;
    private final XType from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final XType f688to;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001e\u001fB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u000f\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0011\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0002\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/room/solver/types/TypeConverter$Cost;", "", "converters", "", "nullSafeWrapper", "upCasts", "requireNotNull", "(IIII)V", "values", "", "([I)V", "getConverters$annotations", "()V", "getConverters", "()I", "getNullSafeWrapper$annotations", "getNullSafeWrapper", "getRequireNotNull$annotations", "getRequireNotNull", "getUpCasts$annotations", "getUpCasts", "compareTo", "other", "equals", "", "", "hashCode", "plus", "toString", "", "Buckets", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Cost implements Comparable<Cost> {
        private static final Cost CONVERTER = null;
        public static final Companion Companion = null;
        private static final Cost NULL_SAFE = null;
        private static final Cost REQUIRE_NOT_NULL = null;
        private static final Cost UP_CAST = null;
        private final int[] values;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/room/solver/types/TypeConverter$Cost$Buckets;", "", "()V", "CONVERTER", "", "NULL_SAFE", "REQUIRE_NOT_NULL", "SIZE", "UP_CAST", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Buckets {
            public static final int CONVERTER = 1;
            public static final Buckets INSTANCE = null;
            public static final int NULL_SAFE = 2;
            public static final int REQUIRE_NOT_NULL = 0;
            public static final int SIZE = 4;
            public static final int UP_CAST = 3;

            static {
                INSTANCE = new Buckets();
            }

            private Buckets() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/room/solver/types/TypeConverter$Cost$Companion;", "", "()V", "CONVERTER", "Landroidx/room/solver/types/TypeConverter$Cost;", "getCONVERTER", "()Landroidx/room/solver/types/TypeConverter$Cost;", "NULL_SAFE", "getNULL_SAFE", "REQUIRE_NOT_NULL", "getREQUIRE_NOT_NULL", "UP_CAST", "getUP_CAST", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final Cost getCONVERTER() {
                return Cost.access$getCONVERTER$cp();
            }

            public final Cost getNULL_SAFE() {
                return Cost.access$getNULL_SAFE$cp();
            }

            public final Cost getREQUIRE_NOT_NULL() {
                return Cost.access$getREQUIRE_NOT_NULL$cp();
            }

            public final Cost getUP_CAST() {
                return Cost.access$getUP_CAST$cp();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            int r5 = 0;
            int r10 = 0;
            int r11 = 1;
            int r12 = 0;
            UP_CAST = new Cost(r5, r10, r11, r12, 10, null);
            int r13 = 0;
            int r14 = 1;
            int r15 = 0;
            int r16 = 0;
            NULL_SAFE = new Cost(r13, r14, r15, r16, 12, null);
            int r17 = 1;
            int r18 = 0;
            CONVERTER = new Cost(r17, r5, r10, r18, 14, null);
            int r19 = 0;
            int r110 = 0;
            int r111 = 1;
            REQUIRE_NOT_NULL = new Cost(r19, r13, r110, r111, 6, null);
        }

        private Cost(int[] r5) {
            this.values = r5;
            if (r5.length != 4) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Failed requirement.");
        }

        public static final /* synthetic */ Cost access$getCONVERTER$cp() {
            return CONVERTER;
        }

        public static final /* synthetic */ Cost access$getNULL_SAFE$cp() {
            return NULL_SAFE;
        }

        public static final /* synthetic */ Cost access$getREQUIRE_NOT_NULL$cp() {
            return REQUIRE_NOT_NULL;
        }

        public static final /* synthetic */ Cost access$getUP_CAST$cp() {
            return UP_CAST;
        }

        @VisibleForTesting
        public static /* synthetic */ void getConverters$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getNullSafeWrapper$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getRequireNotNull$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getUpCasts$annotations() {
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Cost r5) {
            return compareTo2(r5);
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof Cost) == true) goto L6;
            return false;
        L6:
            if (compareTo2((Cost) r5) != 0) goto L9;
            return true;
        L9:
            return false;
        }

        public final int getConverters() {
            return this.values[1];
        }

        public final int getNullSafeWrapper() {
            return this.values[2];
        }

        public final int getRequireNotNull() {
            return this.values[0];
        }

        public final int getUpCasts() {
            return this.values[3];
        }

        public int hashCode() {
            return this.values[1];
        }

        public final Cost plus(Cost r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            int[] r5 = new int[4];
            int r11 = 0;
        L3:
            if (r11 >= 4) goto L6;
            r5[r11] = this.values[r11] + r10.values[r11];
            r11 = r11 + 1;
            goto L3
        L6:
            return new Cost(r5);
        }

        public String toString() {
            return "Cost[upcast:" + getUpCasts() + ",nullsafe:" + getNullSafeWrapper() + ",converters:" + getConverters() + ",requireNotNull:" + getRequireNotNull() + "]";
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Cost r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            int r10 = 0;
        L4:
            if (r10 >= 4) goto L9;
            int r11 = Intrinsics.compare(this.values[r10], r5.values[r10]);
            if (r11 != 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return r11;
        L9:
            return 0;
        }

        public /* synthetic */ Cost(int r5, int r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r10 = 0;
        L6:
            if ((r13 & 4) == 0) goto L9;
            r11 = 0;
        L9:
            if ((r13 & 8) == 0) goto L11;
            r12 = 0;
        L11:
            this(r5, r10, r11, r12);
        }

        public Cost(int r5, int r10, int r11, int r12) {
            this(new int[]{r12, r5, r10, r11});
        }
    }

    public TypeConverter(XType r5, XType r10, Cost r11) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r10, "to");
        Intrinsics.checkNotNullParameter(r11, "cost");
        this.from = r5;
        this.f688to = r10;
        this.cost = r11;
    }

    public final String convert(String r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        return doConvert(r5, r10);
    }

    public String doConvert(String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        String r5 = r11.getTmpVar();
        r11.builder().c(a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{this.f688to.getTypeName(), r5});
        doConvert(r10, r5, r11);
        return r5;
    }

    public abstract void doConvert(String r5, String r10, CodeGenScope r11);

    public final Cost getCost() {
        return this.cost;
    }

    public final XType getFrom() {
        return this.from;
    }

    public final XType getTo() {
        return this.f688to;
    }

    public final void convert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "outputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        doConvert(r5, r10, r11);
    }

    public /* synthetic */ TypeConverter(XType r5, XType r10, Cost r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = Cost.Companion.getCONVERTER();
    L5:
        this(r5, r10, r11);
    }
}
