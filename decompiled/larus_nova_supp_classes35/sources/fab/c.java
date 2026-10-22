package fab;

import com.bytedance.lark.pb.basic.v1.PushDataCorruptResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.corrupt.Reason;
import com.ss.android.lark.log.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class c implements com.ss.android.lark.sdk.g.b {
    public final /* synthetic */ e a;

    public /* synthetic */ c(e r1) {
        this.a = r1;
    }

    public final void a(byte[] r5) {
        final e r0 = this.a;
        r0.getClass();
        PushDataCorruptResponse r6 = (PushDataCorruptResponse) PushDataCorruptResponse.ADAPTER.decode(r5);     // Catch: IOException -> L8
        if (r6 != null) goto L6;
        Log.e("DataCorruptPush", "PUSH_DATA_CORRUPT receive, but response is null.");     // Catch: IOException -> L8
    L12:
    L10:
        Log.i("DataCorruptPush", "PUSH_DATA_CORRUPT receive,");
        return;
    L6:
        final Reason r7 = Reason.convert(r6.reason);     // Catch: IOException -> L8
        CoreThreadPool.getDefault().getUIExecutor().execute(new d(r0, r7));     // Catch: IOException -> L8
    L8:
        e = move-exception;
        Log.e("DataCorruptPush", e);
        goto L10
    }
}
