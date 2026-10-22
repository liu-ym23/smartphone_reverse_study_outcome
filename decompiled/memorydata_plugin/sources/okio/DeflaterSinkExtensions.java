package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "jvm"}, k = 2, mv = {1, 1, 11})
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink r2, Deflater r3) {
        Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "deflater");
        return new DeflaterSink(r4, r3);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink r1, Deflater r2, int r3, Object r4) {
        Sink r5 = (Sink) ZeusTransformUtils.wrapperContextForParams(r1, Sink.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = new Deflater();
    L5:
        Intrinsics.checkParameterIsNotNull(r5, "$receiver");
        Intrinsics.checkParameterIsNotNull(r2, "deflater");
        return new DeflaterSink(r5, r2);
    }
}
