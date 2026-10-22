package androidx.room.compiler.processing.util;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import javax.lang.model.SourceVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"isValidJavaSourceName", "", "", "sanitizeAsJavaParameterName", "argIndex", "", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NamingUtilsKt {
    public static final boolean isValidJavaSourceName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SourceVersion.isName(r5);
    }

    public static final String sanitizeAsJavaParameterName(String r5, int r10) {
        if (r5 == null) goto L7;
        if (SourceVersion.isName(r5) == false) goto L7;
        return r5;
    L7:
        return j0.g(r10, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
    }
}
