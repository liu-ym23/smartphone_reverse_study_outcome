package androidx.core.util;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "out", "writeBytes", "array", "writeText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AtomicFileKt {
    public static final byte[] readBytes(android.util.AtomicFile r0) {
        return r0.readFully();
    }

    public static final String readText(android.util.AtomicFile r1, Charset r2) {
        return new String(r1.readFully(), r2);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return readText(r0, r1);
    }

    public static final void tryWrite(android.util.AtomicFile r2, Function1<? super FileOutputStream, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        FileOutputStream r0 = r2.startWrite();
        r4.invoke(r0);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.finishWrite(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.failWrite(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void writeBytes(android.util.AtomicFile r1, byte[] r2) {
        FileOutputStream r0 = r1.startWrite();
        r0.write(r2);     // Catch: Throwable -> L6
        r1.finishWrite(r0);
        return;
    L6:
        th = move-exception;
        r1.failWrite(r0);
        throw th;
    }

    public static final void writeText(android.util.AtomicFile r0, String r1, Charset r2) {
        byte[] r3 = r1.getBytes(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).getBytes(charset)");
        writeBytes(r0, r3);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        writeText(r0, r1, r2);
    }
}
