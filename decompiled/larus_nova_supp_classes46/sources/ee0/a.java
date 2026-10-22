package ee0;

import com.bytedance.android.live.core.log.ALogger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: ee0.a$a, reason: collision with other inner class name */
    public static final class C0203a {
        public static String a(ByteBuffer r2) {
            Intrinsics.checkNotNullParameter(r2, "buffer");
            CharBuffer r0 = Charset.forName("UTF-8").newDecoder().decode(r2);     // Catch: Throwable -> L5
            r2.flip();     // Catch: Throwable -> L5
            return r0.toString();
        L5:
            th = move-exception;
            ALogger.e("byteBufferToString", "byteBufferToString error!", th);
            th.printStackTrace();
            return null;
        }
    }

    static {
        new SimpleDateFormat("HH:mm:ss.SSS");
    }
}
