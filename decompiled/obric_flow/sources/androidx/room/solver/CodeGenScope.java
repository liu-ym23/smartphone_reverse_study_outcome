package androidx.room.solver;

import ai.j0;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.writer.TypeWriter;
import com.squareup.javapoet.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/room/solver/CodeGenScope;", "", "Landroidx/room/writer/TypeWriter;", "writer", "<init>", "(Landroidx/room/writer/TypeWriter;)V", "Lcom/squareup/javapoet/g;", "Landroidx/room/compiler/codegen/JCodeBlockBuilder;", "builder", "()Lcom/squareup/javapoet/g;", "", "getTmpVar", "()Ljava/lang/String;", "prefix", "(Ljava/lang/String;)Ljava/lang/String;", "Landroidx/room/compiler/codegen/XCodeBlock;", "generate", "()Landroidx/room/compiler/codegen/XCodeBlock;", "fork", "()Landroidx/room/solver/CodeGenScope;", "Landroidx/room/writer/TypeWriter;", "getWriter", "()Landroidx/room/writer/TypeWriter;", "Landroidx/room/compiler/codegen/CodeLanguage;", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "getLanguage", "()Landroidx/room/compiler/codegen/CodeLanguage;", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "builder$delegate", "Lkotlin/Lazy;", "getBuilder", "()Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "", "", "tmpVarIndices", "Ljava/util/Map;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeGenScope {
    public static final String CLASS_PROPERTY_PREFIX = "__";
    public static final Companion Companion = null;
    public static final String TMP_VAR_DEFAULT_PREFIX = "_tmp";
    private final Lazy builder$delegate;
    private final CodeLanguage language;
    private final Map<String, Integer> tmpVarIndices;
    private final TypeWriter writer;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/room/solver/CodeGenScope$Companion;", "", "()V", "CLASS_PROPERTY_PREFIX", "", "TMP_VAR_DEFAULT_PREFIX", "getTmpVarString", "index", "", "prefix", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ String access$getTmpVarString(Companion r5, String r10, int r11) {
            return r5.getTmpVarString(r10, r11);
        }

        public final String getTmpVarString(int r5) {
            return getTmpVarString(CodeGenScope.TMP_VAR_DEFAULT_PREFIX, r5);
        }

        private Companion() {
        }

        private final String getTmpVarString(String r5, int r10) {
            if (r10 != 0) goto L4;
            String r11 = "";
        L6:
            return j0.j(r5, r11);
        L4:
            r11 = j0.g(r10, "_");
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CodeGenScope(TypeWriter r5) {
        Intrinsics.checkNotNullParameter(r5, "writer");
        this.writer = r5;
        this.language = r5.getCodeLanguage();
        this.builder$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.tmpVarIndices = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g builder() {
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        XCodeBlock.Builder.Companion.apply(getBuilder(), new AnonymousClass4(r5), AnonymousClass5.INSTANCE);
        T r10 = r5.element;
        if (r10 != 0) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("leakJavaBuilder");
        return null;
    L6:
        return (g) r10;
    }

    public final CodeGenScope fork() {
        CodeGenScope r5 = new CodeGenScope(this.writer);
        r5.tmpVarIndices.putAll(this.tmpVarIndices);
        return r5;
    }

    public final XCodeBlock generate() {
        return getBuilder().build();
    }

    public final XCodeBlock.Builder getBuilder() {
        return (XCodeBlock.Builder) this.builder$delegate.getValue();
    }

    public final CodeLanguage getLanguage() {
        return this.language;
    }

    public final String getTmpVar() {
        return getTmpVar(TMP_VAR_DEFAULT_PREFIX);
    }

    public final TypeWriter getWriter() {
        return this.writer;
    }

    public final String getTmpVar(String r5) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        if (StringsKt.P(r5, "_") == false) goto L14;
        if (StringsKt.P(r5, CLASS_PROPERTY_PREFIX) == true) goto L12;
        Integer r10 = this.tmpVarIndices.get(r5);
        if (r10 != null) goto L9;
        r10 = 0;
    L9:
        int r11 = r10.intValue();
        String r12 = Companion.access$getTmpVarString(Companion, r5, r11);
        this.tmpVarIndices.put(r5, Integer.valueOf(r11 + 1));
        return r12;
    L12:
        throw new IllegalArgumentException("Cannot use '__' for tmp variables.");
    L14:
        throw new IllegalArgumentException("Tmp variable prefixes should start with '_'.");
    }
}
