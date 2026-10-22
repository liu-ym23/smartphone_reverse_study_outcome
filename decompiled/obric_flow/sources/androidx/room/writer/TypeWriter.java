package androidx.room.writer;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomProcessor;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.processing.XFilerKt;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.solver.CodeGenScope;
import com.bytedance.ai.event.MessageIndication;
import com.squareup.javapoet.l;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.x;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u000256B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u0012\u001a\u00020\b2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u0015\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\"0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020'0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R$\u00104\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u00010-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010/¨\u00067"}, d2 = {"Landroidx/room/writer/TypeWriter;", "", "Landroidx/room/compiler/codegen/CodeLanguage;", "codeLanguage", "<init>", "(Landroidx/room/compiler/codegen/CodeLanguage;)V", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "builder", "", "addSuppressWarnings", "(Landroidx/room/compiler/codegen/XTypeSpec$Builder;)V", "adapterTypeSpecBuilder", "Landroidx/room/compiler/processing/XProcessingEnv;", "processingEnv", "addGeneratedAnnotationIfAvailable", "(Landroidx/room/compiler/codegen/XTypeSpec$Builder;Landroidx/room/compiler/processing/XProcessingEnv;)V", "", "", "set", "value", "makeUnique", "(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/String;", "createTypeSpecBuilder", "()Landroidx/room/compiler/codegen/XTypeSpec$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", STGroup.DICT_KEY, "get", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "write", "(Landroidx/room/compiler/processing/XProcessingEnv;)V", "Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "sharedField", "Lcom/squareup/javapoet/m;", "getOrCreateField", "(Landroidx/room/writer/TypeWriter$SharedFieldSpec;)Lcom/squareup/javapoet/m;", "Landroidx/room/writer/TypeWriter$SharedMethodSpec;", "sharedMethod", "Lcom/squareup/javapoet/t;", "getOrCreateMethod", "(Landroidx/room/writer/TypeWriter$SharedMethodSpec;)Lcom/squareup/javapoet/t;", "Landroidx/room/compiler/codegen/CodeLanguage;", "getCodeLanguage", "()Landroidx/room/compiler/codegen/CodeLanguage;", "", "sharedFieldSpecs", "Ljava/util/Map;", "sharedMethodSpecs", "sharedFieldNames", "Ljava/util/Set;", "sharedMethodNames", "metadata", "SharedFieldSpec", "SharedMethodSpec", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TypeWriter {
    private final CodeLanguage codeLanguage;
    private final Map<KClass<?>, Object> metadata;
    private final Set<String> sharedFieldNames;
    private final Map<String, m> sharedFieldSpecs;
    private final Set<String> sharedMethodNames;
    private final Map<String, t> sharedMethodSpecs;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/room/writer/TypeWriter$SharedFieldSpec;", "", "", "baseName", "Lcom/squareup/javapoet/x;", "type", "<init>", "(Ljava/lang/String;Lcom/squareup/javapoet/x;)V", "getUniqueKey", "()Ljava/lang/String;", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/l;", "builder", "", MessageIndication.STATUS_PREPARE, "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/l;)V", "classWriter", "name", "Lcom/squareup/javapoet/m;", "build", "(Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/m;", "Ljava/lang/String;", "getBaseName", "Lcom/squareup/javapoet/x;", "getType", "()Lcom/squareup/javapoet/x;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class SharedFieldSpec {
        private final String baseName;
        private final x type;

        public SharedFieldSpec(String r5, x r10) {
            Intrinsics.checkNotNullParameter(r5, "baseName");
            Intrinsics.checkNotNullParameter(r10, "type");
            this.baseName = r5;
            this.type = r10;
        }

        public final m build(TypeWriter r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "classWriter");
            Intrinsics.checkNotNullParameter(r10, "name");
            l r11 = m.a(this.type, r10, new Modifier[0]);
            prepare(r5, r11);
            return new m(r11);
        }

        public final String getBaseName() {
            return this.baseName;
        }

        public final x getType() {
            return this.type;
        }

        public abstract String getUniqueKey();

        public abstract void prepare(TypeWriter r5, l r10);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/room/writer/TypeWriter$SharedMethodSpec;", "", "", "baseName", "<init>", "(Ljava/lang/String;)V", "getUniqueKey", "()Ljava/lang/String;", "methodName", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/s;", "builder", "", MessageIndication.STATUS_PREPARE, "(Ljava/lang/String;Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/s;)V", "name", "Lcom/squareup/javapoet/t;", "build", "(Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/t;", "Ljava/lang/String;", "getBaseName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class SharedMethodSpec {
        private final String baseName;

        public SharedMethodSpec(String r5) {
            Intrinsics.checkNotNullParameter(r5, "baseName");
            this.baseName = r5;
        }

        public final t build(TypeWriter r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r10, "name");
            s r11 = new s(r10);
            prepare(r10, r5, r11);
            return new t(r11);
        }

        public final String getBaseName() {
            return this.baseName;
        }

        public abstract String getUniqueKey();

        public abstract void prepare(String r5, TypeWriter r10, s r11);
    }

    public TypeWriter(CodeLanguage r5) {
        Intrinsics.checkNotNullParameter(r5, "codeLanguage");
        this.codeLanguage = r5;
        this.sharedFieldSpecs = new LinkedHashMap();
        this.sharedMethodSpecs = new LinkedHashMap();
        this.sharedFieldNames = new LinkedHashSet();
        this.sharedMethodNames = new LinkedHashSet();
        this.metadata = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getSharedFieldSpecs$p(TypeWriter r5) {
        return r5.sharedFieldSpecs;
    }

    public static final /* synthetic */ Map access$getSharedMethodSpecs$p(TypeWriter r5) {
        return r5.sharedMethodSpecs;
    }

    private final void addGeneratedAnnotationIfAvailable(XTypeSpec.Builder r5, XProcessingEnv r10) {
        final XTypeElement r11 = r10.findGeneratedAnnotation();
        if (r11 == null) goto L6;
        final String r12 = RoomProcessor.class.getCanonicalName();
        XTypeSpec.Builder.Companion.apply(r5, new TypeWriter$addGeneratedAnnotationIfAvailable$1$1(r11, r12), new TypeWriter$addGeneratedAnnotationIfAvailable$1$2(r11, r12));
        return;
    }

    private final void addSuppressWarnings(XTypeSpec.Builder r5) {
        final String[] r10 = {"unchecked", "deprecation"};
        XTypeSpec.Builder.Companion.apply(r5, new AnonymousClass1(r10), new AnonymousClass2(r10));
    }

    private final String makeUnique(Set<String> r5, String r10) {
        if (StringsKt.P(r10, CodeGenScope.CLASS_PROPERTY_PREFIX) == true) goto L7;
        return makeUnique(r5, j0.C(CodeGenScope.CLASS_PROPERTY_PREFIX, r10));
    L7:
        if (r5.add(r10) == false) goto L9;
        return r10;
    L9:
        int r11 = 1;
    L11:
        if (r5.add(r10 + "_" + r11) == true) goto L13;
        r11 = r11 + 1;
        goto L11
    L13:
        return r10 + "_" + r11;
    }

    public abstract XTypeSpec.Builder createTypeSpecBuilder();

    public final <T> T get(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        T r10 = (T) this.metadata.get(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10;
    }

    public final CodeLanguage getCodeLanguage() {
        return this.codeLanguage;
    }

    public final m getOrCreateField(SharedFieldSpec r5) {
        Intrinsics.checkNotNullParameter(r5, "sharedField");
        Map<String, m> r10 = this.sharedFieldSpecs;
        String r11 = r5.getUniqueKey();
        m r12 = r10.get(r11);
        if (r12 != null) goto L6;
        r12 = r5.build(this, makeUnique(this.sharedFieldNames, r5.getBaseName()));
        r10.put(r11, r12);
    L6:
        return r12;
    }

    public final t getOrCreateMethod(SharedMethodSpec r5) {
        Intrinsics.checkNotNullParameter(r5, "sharedMethod");
        Map<String, t> r10 = this.sharedMethodSpecs;
        String r11 = r5.getUniqueKey();
        t r12 = r10.get(r11);
        if (r12 != null) goto L6;
        r12 = r5.build(this, makeUnique(this.sharedMethodNames, r5.getBaseName()));
        r10.put(r11, r12);
    L6:
        return r12;
    }

    public final void set(KClass<?> r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "value");
        this.metadata.put(r5, r10);
    }

    public final void write(XProcessingEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "processingEnv");
        XTypeSpec.Builder r10 = createTypeSpecBuilder();
        XTypeSpec.Builder.Companion.apply(r10, new C01511(this), C01522.INSTANCE);
        addGeneratedAnnotationIfAvailable(r10, r5);
        addSuppressWarnings(r10);
        XFilerKt.writeTo$default(r10.build(), r5.getFiler(), null, 2, null);
    }
}
