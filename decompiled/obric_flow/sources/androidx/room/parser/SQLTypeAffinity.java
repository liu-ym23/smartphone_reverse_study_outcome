package androidx.room.parser;

import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.CommonTypeNames;
import com.squareup.javapoet.c;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/parser/SQLTypeAffinity;", "", "<init>", "(Ljava/lang/String;I)V", "Landroidx/room/compiler/processing/XProcessingEnv;", "env", "", "Lcom/squareup/javapoet/x;", "typeNames", "", "Landroidx/room/compiler/processing/XType;", "withBoxedAndNullableTypes", "(Landroidx/room/compiler/processing/XProcessingEnv;[Lcom/squareup/javapoet/x;)Ljava/util/List;", "getTypeMirrors", "(Landroidx/room/compiler/processing/XProcessingEnv;)Ljava/util/List;", "Companion", "NULL", "TEXT", "INTEGER", "REAL", "BLOB", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum SQLTypeAffinity extends Enum<SQLTypeAffinity> {
    private static final /* synthetic */ SQLTypeAffinity[] $VALUES = null;
    public static final SQLTypeAffinity BLOB = null;
    public static final Companion Companion = null;
    public static final SQLTypeAffinity INTEGER = null;
    public static final SQLTypeAffinity NULL = null;
    public static final SQLTypeAffinity REAL = null;
    public static final SQLTypeAffinity TEXT = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/parser/SQLTypeAffinity$Companion;", "", "()V", "fromAnnotationValue", "Landroidx/room/parser/SQLTypeAffinity;", "value", "", "(Ljava/lang/Integer;)Landroidx/room/parser/SQLTypeAffinity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final SQLTypeAffinity fromAnnotationValue(Integer r5) {
            if (r5 != null) goto L5;
        L7:
            if (r5 != null) goto L10;
        L12:
            if (r5 != null) goto L15;
        L17:
            if (r5 != null) goto L20;
        L22:
            return null;
        L20:
            if (r5.intValue() != 2) goto L22;
            return SQLTypeAffinity.TEXT;
        L15:
            if (r5.intValue() != 4) goto L17;
            return SQLTypeAffinity.REAL;
        L10:
            if (r5.intValue() != 3) goto L12;
            return SQLTypeAffinity.INTEGER;
        L5:
            if (r5.intValue() != 5) goto L7;
            return SQLTypeAffinity.BLOB;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[SQLTypeAffinity.values().length];
            r5[SQLTypeAffinity.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r5[SQLTypeAffinity.INTEGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r5[SQLTypeAffinity.REAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[SQLTypeAffinity.BLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r5;
        }
    }

    private static final /* synthetic */ SQLTypeAffinity[] $values() {
        return new SQLTypeAffinity[]{NULL, TEXT, INTEGER, REAL, BLOB};
    }

    static {
        NULL = new SQLTypeAffinity("NULL", 0);
        TEXT = new SQLTypeAffinity("TEXT", 1);
        INTEGER = new SQLTypeAffinity("INTEGER", 2);
        REAL = new SQLTypeAffinity("REAL", 3);
        BLOB = new SQLTypeAffinity("BLOB", 4);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private SQLTypeAffinity(String r5, int r10) {
        super(r5, r10);
    }

    public static SQLTypeAffinity valueOf(String r5) {
        return (SQLTypeAffinity) Enum.valueOf(SQLTypeAffinity.class, r5);
    }

    public static SQLTypeAffinity[] values() {
        return (SQLTypeAffinity[]) $VALUES.clone();
    }

    private final List<XType> withBoxedAndNullableTypes(XProcessingEnv r10, x... r11) {
        ArrayList r5 = new ArrayList();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        CollectionsKt.b(r5, SequencesKt.sequence(new SQLTypeAffinity$withBoxedAndNullableTypes$1$1(r10, r11[r13], null)));
        r13 = r13 + 1;
        goto L3
    L6:
        return CollectionsKt.toList(r5);
    }

    public final List<XType> getTypeMirrors(XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r10, "env");
        int r5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 == 4) goto L17;
        return null;
    L17:
        return withBoxedAndNullableTypes(r10, new x[]{new c(x.f)});
    L18:
        return withBoxedAndNullableTypes(r10, new x[]{x.f15027l, x.f15026k});
    L19:
        return withBoxedAndNullableTypes(r10, new x[]{x.f15023h, x.f, x.f15025j, x.f15024i, x.g});
    L15:
        return withBoxedAndNullableTypes(r10, new x[]{CommonTypeNames.INSTANCE.getSTRING()});
    }
}
