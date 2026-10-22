package androidx.room.compiler.processing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XBasicAnnotationProcessor;", "", "xProcessingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "getXProcessingEnv", "()Landroidx/room/compiler/processing/XProcessingEnv;", "initialize", "", "env", "postRound", "round", "Landroidx/room/compiler/processing/XRoundEnv;", "processingSteps", "", "Landroidx/room/compiler/processing/XProcessingStep;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XBasicAnnotationProcessor {
    XProcessingEnv getXProcessingEnv();

    default void initialize(XProcessingEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "env");
    }

    default void postRound(XProcessingEnv r5, XRoundEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "round");
    }

    Iterable<XProcessingStep> processingSteps();
}
