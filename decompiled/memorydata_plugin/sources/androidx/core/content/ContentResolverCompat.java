package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor query(ContentResolver r8, Uri r9, String[] r10, String r11, String[] r12, String r13, CancellationSignal r14) {
            return ZeusProviderTransform.query(r8, r9, r10, r11, r12, r13, r14, "com.obric.memorydata.plugin");
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver r7, Uri r8, String[] r9, String r10, String[] r11, String r12, androidx.core.os.CancellationSignal r13) {
        if (Build.VERSION.SDK_INT < 16) goto L16;
        if (r13 != null) goto L20;
        Object r14 = null;
    L9:
        return Api16Impl.query(r7, r8, r9, r10, r11, r12, (CancellationSignal) ZeusTransformUtils.preCheckCast(r14, CancellationSignal.class, "com.obric.memorydata.plugin"));
    L6:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, OperationCanceledException.class) == true) goto L14;
        throw e;
    L14:
        throw new androidx.core.os.OperationCanceledException();
    L20:
        r14 = r13.getCancellationSignalObject();     // Catch: Exception -> L6
        goto L9
    L16:
        if (r13 == null) goto L19;
        r13.throwIfCanceled();
    L19:
        return ZeusProviderTransform.query(r7, r8, r9, r10, r11, r12, "com.obric.memorydata.plugin");
    }
}
