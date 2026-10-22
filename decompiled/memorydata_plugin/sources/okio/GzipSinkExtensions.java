package okio;

import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, d2 = {NetConst.GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "jvm"}, k = 2, mv = {1, 1, 11})
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        return new GzipSink(r3);
    }
}
