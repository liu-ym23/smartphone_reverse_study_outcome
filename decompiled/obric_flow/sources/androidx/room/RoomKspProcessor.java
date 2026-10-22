package androidx.room;

import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XRoundEnv;
import androidx.room.compiler.processing.ksp.KspBasicAnnotationProcessor;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.verifier.DatabaseVerifier;
import java.util.List;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomKspProcessor;", "Landroidx/room/compiler/processing/ksp/KspBasicAnnotationProcessor;", "Lhl/f;", "environment", "<init>", "(Lhl/f;)V", "", "Landroidx/room/DatabaseProcessingStep;", "processingSteps", "()Ljava/util/List;", "Landroidx/room/compiler/processing/XProcessingEnv;", "env", "Landroidx/room/compiler/processing/XRoundEnv;", "round", "", "postRound", "(Landroidx/room/compiler/processing/XProcessingEnv;Landroidx/room/compiler/processing/XRoundEnv;)V", "Provider", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomKspProcessor extends KspBasicAnnotationProcessor {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/RoomKspProcessor$Provider;", "", "<init>", "()V", "Lhl/f;", "environment", "Lhl/e;", "create", "(Lhl/f;)Lhl/e;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Provider {
        public Provider() {
        }

        public hl.e create(hl.f r5) {
            Intrinsics.checkNotNullParameter(r5, "environment");
            return new RoomKspProcessor(r5);
        }
    }

    public RoomKspProcessor(hl.f r5) {
        Intrinsics.checkNotNullParameter(r5, "environment");
        super(r5, DatabaseProcessingStep.Companion.getENV_CONFIG$room_compiler());
        if (Intrinsics.areEqual(Context.BooleanProcessorOptions.USE_NULL_AWARE_CONVERTER.getInputValue(getXProcessingEnv()), Boolean.FALSE) == false) goto L6;
        getXProcessingEnv().getMessager().printMessage(Diagnostic.Kind.WARNING, StringsKt.trimIndent("\n                    Disabling null-aware type analysis in KSP is a temporary flag that will be\n                    removed in a future release.\n                    If the null-aware type analysis is causing a bug in your application,\n                    please file a bug at " + ProcessorErrors.INSTANCE.getISSUE_TRACKER_LINK() + " with\n                    a sample app that reproduces your problem.\n                "));
        return;
    }

    @Override // androidx.room.compiler.processing.ksp.KspBasicAnnotationProcessor
    public /* bridge */ /* synthetic */ void onError() {
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
