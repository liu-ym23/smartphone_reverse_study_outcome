package androidx.room.compiler.processing;

import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\nH\u0017J8\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\nH\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XProcessingStep;", "", "annotations", "", "", "process", "Landroidx/room/compiler/processing/XElement;", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "elementsByAnnotation", "", "isLastRound", "", "processOver", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XProcessingStep {
    Set<String> annotations();

    @Deprecated(level = DeprecationLevel.WARNING, message = "We're combining processOver() and this process() overload.", replaceWith = @ReplaceWith(expression = "process(XProcessingEnv, Map<String, Set<XElement>>, Boolean)", imports = {}))
    default Set<XElement> process(XProcessingEnv r5, Map<String, ? extends Set<? extends XElement>> r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "elementsByAnnotation");
        return SetsKt.emptySet();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "We're combining processOver() and the original process().", replaceWith = @ReplaceWith(expression = "process(XProcessingEnv, Map<String, Set<XElement>>, Boolean)", imports = {}))
    default void processOver(XProcessingEnv r5, Map<String, ? extends Set<? extends XElement>> r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "elementsByAnnotation");
    }

    default Set<XElement> process(XProcessingEnv r5, Map<String, ? extends Set<? extends XElement>> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "elementsByAnnotation");
        if (r11 == false) goto L6;
        processOver(r5, r10);
        return SetsKt.emptySet();
    L6:
        return process(r5, r10);
    }
}
