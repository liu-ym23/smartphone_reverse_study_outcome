package androidx.room.compiler.codegen;

import androidx.room.compiler.processing.XNullability;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B)\b\u0004\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/compiler/codegen/XTypeName;", "", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "java", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "kotlin", "Landroidx/room/compiler/processing/XNullability;", "nullability", "<init>", "(Lcom/squareup/javapoet/x;Lcom/squareup/kotlinpoet/a0;Landroidx/room/compiler/processing/XNullability;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/javapoet/x;", "getJava$room_compiler_processing", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "getKotlin$room_compiler_processing", "()Lcom/squareup/kotlinpoet/a0;", "Landroidx/room/compiler/processing/XNullability;", "getNullability$room_compiler_processing", "()Landroidx/room/compiler/processing/XNullability;", "isPrimitive", "()Z", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class XTypeName {
    public static final Companion Companion = null;
    private static final XTypeName PRIMITIVE_BOOLEAN = null;
    private static final XTypeName PRIMITIVE_BYTE = null;
    private static final XTypeName PRIMITIVE_CHAR = null;
    private static final XTypeName PRIMITIVE_DOUBLE = null;
    private static final XTypeName PRIMITIVE_FLOAT = null;
    private static final XTypeName PRIMITIVE_INT = null;
    private static final XTypeName PRIMITIVE_LONG = null;
    private static final XTypeName PRIMITIVE_SHORT = null;
    private static final c UNAVAILABLE_KTYPE_NAME = null;
    private final x java;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private final a0 f574kotlin;
    private final XNullability nullability;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u001d\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u001e\u0010#\u001a\u00060!j\u0002`\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/room/compiler/codegen/XTypeName$Companion;", "", "<init>", "()V", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "java", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "kotlin", "Landroidx/room/compiler/processing/XNullability;", "nullability", "Landroidx/room/compiler/codegen/XTypeName;", "invoke", "(Lcom/squareup/javapoet/x;Lcom/squareup/kotlinpoet/a0;Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/codegen/XTypeName;", "PRIMITIVE_BOOLEAN", "Landroidx/room/compiler/codegen/XTypeName;", "getPRIMITIVE_BOOLEAN", "()Landroidx/room/compiler/codegen/XTypeName;", "PRIMITIVE_BYTE", "getPRIMITIVE_BYTE", "PRIMITIVE_SHORT", "getPRIMITIVE_SHORT", "PRIMITIVE_INT", "getPRIMITIVE_INT", "PRIMITIVE_LONG", "getPRIMITIVE_LONG", "PRIMITIVE_CHAR", "getPRIMITIVE_CHAR", "PRIMITIVE_FLOAT", "getPRIMITIVE_FLOAT", "PRIMITIVE_DOUBLE", "getPRIMITIVE_DOUBLE", "Lcom/squareup/kotlinpoet/c;", "Lcom/squareup/kotlinpoet/javapoet/KClassName;", "UNAVAILABLE_KTYPE_NAME", "Lcom/squareup/kotlinpoet/c;", "getUNAVAILABLE_KTYPE_NAME$room_compiler_processing", "()Lcom/squareup/kotlinpoet/c;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static /* synthetic */ XTypeName invoke$default(Companion r5, x r10, a0 r11, XNullability r12, int r13, Object r14) {
            if ((r13 & 4) == 0) goto L6;
            r12 = XNullability.NONNULL;
        L6:
            return r5.invoke(r10, r11, r12);
        }

        public final XTypeName getPRIMITIVE_BOOLEAN() {
            return XTypeName.access$getPRIMITIVE_BOOLEAN$cp();
        }

        public final XTypeName getPRIMITIVE_BYTE() {
            return XTypeName.access$getPRIMITIVE_BYTE$cp();
        }

        public final XTypeName getPRIMITIVE_CHAR() {
            return XTypeName.access$getPRIMITIVE_CHAR$cp();
        }

        public final XTypeName getPRIMITIVE_DOUBLE() {
            return XTypeName.access$getPRIMITIVE_DOUBLE$cp();
        }

        public final XTypeName getPRIMITIVE_FLOAT() {
            return XTypeName.access$getPRIMITIVE_FLOAT$cp();
        }

        public final XTypeName getPRIMITIVE_INT() {
            return XTypeName.access$getPRIMITIVE_INT$cp();
        }

        public final XTypeName getPRIMITIVE_LONG() {
            return XTypeName.access$getPRIMITIVE_LONG$cp();
        }

        public final XTypeName getPRIMITIVE_SHORT() {
            return XTypeName.access$getPRIMITIVE_SHORT$cp();
        }

        public final c getUNAVAILABLE_KTYPE_NAME$room_compiler_processing() {
            return XTypeName.access$getUNAVAILABLE_KTYPE_NAME$cp();
        }

        public final XTypeName invoke(x r5, a0 r10, XNullability r11) {
            Intrinsics.checkNotNullParameter(r5, "java");
            Intrinsics.checkNotNullParameter(r10, "kotlin");
            Intrinsics.checkNotNullParameter(r11, "nullability");
            return new XTypeName(r5, r10, r11);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        PRIMITIVE_BOOLEAN = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Boolean.TYPE));
        PRIMITIVE_BYTE = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Byte.TYPE));
        PRIMITIVE_SHORT = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Short.TYPE));
        PRIMITIVE_INT = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Integer.TYPE));
        PRIMITIVE_LONG = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Long.TYPE));
        PRIMITIVE_CHAR = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Character.TYPE));
        PRIMITIVE_FLOAT = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Float.TYPE));
        PRIMITIVE_DOUBLE = XTypeNameKt.asPrimitiveTypeName(Reflection.getOrCreateKotlinClass(Double.TYPE));
        UNAVAILABLE_KTYPE_NAME = new c("androidx.room.compiler.codegen", new String[]{"Unavailable"});
    }

    public XTypeName(x r5, a0 r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "java");
        Intrinsics.checkNotNullParameter(r10, "kotlin");
        Intrinsics.checkNotNullParameter(r11, "nullability");
        this.java = r5;
        this.f574kotlin = r10;
        this.nullability = r11;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_BOOLEAN$cp() {
        return PRIMITIVE_BOOLEAN;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_BYTE$cp() {
        return PRIMITIVE_BYTE;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_CHAR$cp() {
        return PRIMITIVE_CHAR;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_DOUBLE$cp() {
        return PRIMITIVE_DOUBLE;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_FLOAT$cp() {
        return PRIMITIVE_FLOAT;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_INT$cp() {
        return PRIMITIVE_INT;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_LONG$cp() {
        return PRIMITIVE_LONG;
    }

    public static final /* synthetic */ XTypeName access$getPRIMITIVE_SHORT$cp() {
        return PRIMITIVE_SHORT;
    }

    public static final /* synthetic */ c access$getUNAVAILABLE_KTYPE_NAME$cp() {
        return UNAVAILABLE_KTYPE_NAME;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof XTypeName) == true) goto L8;
        return false;
    L8:
        XTypeName r10 = (XTypeName) r5;
        if (Intrinsics.areEqual(getJava$room_compiler_processing(), r10.getJava$room_compiler_processing()) == true) goto L11;
        return false;
    L11:
        a0 r11 = getKotlin$room_compiler_processing();
        c r12 = UNAVAILABLE_KTYPE_NAME;
        if (Intrinsics.areEqual(r11, r12) == false) goto L14;
    L18:
        return true;
    L14:
        if (Intrinsics.areEqual(r10.getKotlin$room_compiler_processing(), r12) == true) goto L18;
        if (Intrinsics.areEqual(getKotlin$room_compiler_processing(), r10.getKotlin$room_compiler_processing()) == true) goto L18;
        return false;
    }

    public x getJava$room_compiler_processing() {
        return this.java;
    }

    public a0 getKotlin$room_compiler_processing() {
        return this.f574kotlin;
    }

    public final XNullability getNullability$room_compiler_processing() {
        return this.nullability;
    }

    public int hashCode() {
        return getJava$room_compiler_processing().hashCode();
    }

    public final boolean isPrimitive() {
        return getJava$room_compiler_processing().k();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("XTypeName[");
        r5.append(getJava$room_compiler_processing());
        r5.append(" / ");
        if (Intrinsics.areEqual(getKotlin$room_compiler_processing(), UNAVAILABLE_KTYPE_NAME) == true) goto L5;
        r5.append(getKotlin$room_compiler_processing());
    L6:
        r5.append("]");
        return r5.toString();
    L5:
        r5.append("UNAVAILABLE");
        goto L6
    }
}
