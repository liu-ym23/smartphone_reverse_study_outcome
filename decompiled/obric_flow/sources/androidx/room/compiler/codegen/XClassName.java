package androidx.room.compiler.codegen;

import androidx.room.compiler.processing.XNullability;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.c;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a¨\u0006#"}, d2 = {"Landroidx/room/compiler/codegen/XClassName;", "Landroidx/room/compiler/codegen/XTypeName;", "Lcom/squareup/javapoet/e;", "Lcom/squareup/kotlinpoet/javapoet/JClassName;", "java", "Lcom/squareup/kotlinpoet/c;", "Lcom/squareup/kotlinpoet/javapoet/KClassName;", "kotlin", "Landroidx/room/compiler/processing/XNullability;", "nullability", "<init>", "(Lcom/squareup/javapoet/e;Lcom/squareup/kotlinpoet/c;Landroidx/room/compiler/processing/XNullability;)V", "", "nullable", "copy", "(Z)Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/javapoet/e;", "getJava$room_compiler_processing", "()Lcom/squareup/javapoet/e;", "Lcom/squareup/kotlinpoet/c;", "getKotlin$room_compiler_processing", "()Lcom/squareup/kotlinpoet/c;", "", "packageName", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "", "simpleNames", "Ljava/util/List;", "getSimpleNames", "()Ljava/util/List;", "canonicalName", "getCanonicalName", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XClassName extends XTypeName {
    public static final Companion Companion = null;
    private final String canonicalName;
    private final e java;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private final c f573kotlin;
    private final String packageName;
    private final List<String> simpleNames;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/compiler/codegen/XClassName$Companion;", "", "()V", "get", "Landroidx/room/compiler/codegen/XClassName;", "packageName", "", "names", "", "(Ljava/lang/String;[Ljava/lang/String;)Landroidx/room/compiler/codegen/XClassName;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XClassName get(String r5, String... r10) {
            Intrinsics.checkNotNullParameter(r5, "packageName");
            Intrinsics.checkNotNullParameter(r10, "names");
            String r11 = (String) ArraysKt.first(r10);
            Object[] r12 = ArraysKt.h(r10).toArray(new String[0]);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] r13 = (String[]) r12;
            return new XClassName(e.o(r5, r11, (String[]) Arrays.copyOf(r13, r13.length)), new c(r5, (String[]) Arrays.copyOf(r10, r10.length)), XNullability.NONNULL);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public XClassName(e r5, c r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "java");
        Intrinsics.checkNotNullParameter(r10, "kotlin");
        Intrinsics.checkNotNullParameter(r11, "nullability");
        super(r5, r10, r11);
        this.java = r5;
        this.f573kotlin = r10;
        this.packageName = getJava$room_compiler_processing().f14959w;
        this.simpleNames = getJava$room_compiler_processing().r();
        this.canonicalName = getJava$room_compiler_processing().A;
    }

    public final XClassName copy(boolean r5) {
        e r10 = getJava$room_compiler_processing();
        a0 r11 = a0.b(getKotlin$room_compiler_processing(), r5, null, 2);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.squareup.kotlinpoet.ClassName{ com.squareup.kotlinpoet.javapoet.TypeAliasesKt.KClassName }");
        c r12 = (c) r11;
        if (r5 == false) goto L5;
        XNullability r13 = XNullability.NULLABLE;
    L7:
        return new XClassName(r10, r12, r13);
    L5:
        r13 = XNullability.NONNULL;
        goto L7
    }

    public final String getCanonicalName() {
        return this.canonicalName;
    }

    @Override // androidx.room.compiler.codegen.XTypeName
    public /* bridge */ /* synthetic */ x getJava$room_compiler_processing() {
        return getJava$room_compiler_processing();
    }

    @Override // androidx.room.compiler.codegen.XTypeName
    public /* bridge */ /* synthetic */ a0 getKotlin$room_compiler_processing() {
        return getKotlin$room_compiler_processing();
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<String> getSimpleNames() {
        return this.simpleNames;
    }

    @Override // androidx.room.compiler.codegen.XTypeName
    public e getJava$room_compiler_processing() {
        return this.java;
    }

    @Override // androidx.room.compiler.codegen.XTypeName
    public c getKotlin$room_compiler_processing() {
        return this.f573kotlin;
    }
}
