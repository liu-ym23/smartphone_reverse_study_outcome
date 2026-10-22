package kz8;

import android.os.SystemClock;
import com.larus.im.d;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r19, long r20, String r22, List r23, String r24, Continuation r25) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r25));
        FLogger.a.i("MessageSearch", "searchMessage start");
        long r1 = SystemClock.elapsedRealtime();
        NativeMessageServiceImpl r3 = d.e();
        z2 r4 = z2.a;
        if (r4.getChatListSearchConfig().c == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        r3.searchMessageByFts(new FtsSearchParam(r19, true, r20, 20, r10, r22, r23, null, null, 384, null), new a(r1, r24, r0));
        Object r2 = r0.getOrThrow();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r25);
    L11:
        return r2;
    L5:
        if (r4.searchForceByLike() == true) goto L7;
        r10 = true;
        goto L8
    }
}
