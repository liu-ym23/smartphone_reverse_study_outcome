package androidx.room;

import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XRoundEnv;
import androidx.room.compiler.processing.javac.JavacBasicAnnotationProcessor;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.util.SimpleJavaVersion;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.vo.Warning;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/room/RoomProcessor;", "Landroidx/room/compiler/processing/javac/JavacBasicAnnotationProcessor;", "()V", "jdkVersionHasBugReported", "", "getSupportedOptions", "", "", "getSupportedSourceVersion", "Ljavax/lang/model/SourceVersion;", "methodParametersVisibleInClassFiles", "postRound", "", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "round", "Landroidx/room/compiler/processing/XRoundEnv;", "processingSteps", "", "Landroidx/room/DatabaseProcessingStep;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomProcessor extends JavacBasicAnnotationProcessor {
    private boolean jdkVersionHasBugReported;

    public RoomProcessor() {
        super(AnonymousClass1.INSTANCE);
    }

    private final boolean methodParametersVisibleInClassFiles() {
        SimpleJavaVersion.Companion r5 = SimpleJavaVersion.Companion;
        SimpleJavaVersion r10 = r5.getCurrentVersion();
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.compareTo2(r5.getVERSION_11_0_0()) < 0) goto L8;
        return true;
    L8:
        String r11 = System.getProperty("java.vendor");
        if (r11 == null) goto L11;
        boolean r12 = StringsKt.e(r11, "JetBrains", true);
    L12:
        if (r12 == true) goto L14;
    L16:
        if (r12 == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r10, r5.getVERSION_1_8_0_202()) == false) goto L25;
        String r13 = System.getProperty("java.runtime.version");
        if (r13 != null) goto L22;
        return false;
    L22:
        return !Intrinsics.areEqual(r13, "1.8.0_202-release-1483-b39-5396753");
    L25:
        return false;
    L14:
        if (r10.compareTo2(r5.getVERSION_1_8_0_202()) <= 0) goto L16;
        return true;
    L11:
        r12 = false;
        goto L12
    }

    public Set<String> getSupportedOptions() {
        Set<String> r5 = CollectionsKt.toMutableSet(Context.Companion.getARG_OPTIONS());
        if (Context.BooleanProcessorOptions.INCREMENTAL.getValue(getXProcessingEnv()) == true) goto L5;
    L10:
        return r5;
    L5:
        if (methodParametersVisibleInClassFiles() == false) goto L8;
        r5.add("org.gradle.annotation.processing.isolating");
        goto L10
    L8:
        if (this.jdkVersionHasBugReported == true) goto L10;
        new Context(getXProcessingEnv()).getLogger().w(Warning.JDK_VERSION_HAS_BUG, ProcessorErrors.INSTANCE.getJDK_VERSION_HAS_BUG(), new Object[0]);
        this.jdkVersionHasBugReported = true;
        goto L10
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override // androidx.room.compiler.processing.XBasicAnnotationProcessor
    public void postRound(XProcessingEnv r5, XRoundEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "round");
        if (r10.isProcessingOver() == false) goto L6;
        DatabaseVerifier.Companion.cleanup();
        return;
    }

    @Override // androidx.room.compiler.processing.XBasicAnnotationProcessor
    public /* bridge */ /* synthetic */ Iterable processingSteps() {
        return processingSteps();
    }

    @Override // androidx.room.compiler.processing.XBasicAnnotationProcessor
    public List<DatabaseProcessingStep> processingSteps() {
        return CollectionsKt.listOf(new DatabaseProcessingStep());
    }
}
