package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "jvm"}, k = 2, mv = {1, 1, 11})
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source r2, Inflater r3) {
        Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "inflater");
        return new InflaterSource(r4, r3);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source r1, Inflater r2, int r3, Object r4) {
        Source r5 = (Source) ZeusTransformUtils.wrapperContextForParams(r1, Source.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = new Inflater();
    L5:
        Intrinsics.checkParameterIsNotNull(r5, "$receiver");
        Intrinsics.checkParameterIsNotNull(r2, "inflater");
        return new InflaterSource(r5, r2);
    }
}
