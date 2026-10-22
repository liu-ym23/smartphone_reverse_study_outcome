package z22;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r2) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == false) goto L9;
        if (r0.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r0.exists() == false) goto L15;
        if (r0.delete() == true) goto L15;
        Logger.e("VideoRecordUtils", "Can not delete file: " + r0.getAbsolutePath());
        return false;
    L15:
        return r0.mkdirs();
    }

    public static void b(String r3) {
        ALogger.i("VideoRecordUtils", "safeDeleteFile " + r3);
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r3);
        if (r1.exists() == true) goto L15;
        ALogger.i("VideoRecordUtils", "safeDeleteFile file not exist");
        return;
    L15:
        ALogger.i("VideoRecordUtils", "safeDeleteFile result = " + r1.delete());
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    @JvmStatic
    public static final Observable<ILiveRecordService.RecordMetaData> c(String r11, String r13, long r14, long r15, long r17, String r19) {
        Intrinsics.checkNotNullParameter(r11, "originFilePath");
        Intrinsics.checkNotNullParameter(r19, "source");
        IMiddlewareRoomService r0 = k.f(IMiddlewareRoomService.class);
        if (r0 == null) goto L7;
        ILiveRecordService r1 = r0.getMiddlewareRecordService();
        if (r1 == null) goto L7;
        return r1.startReqAndWriteMetadata(r11, r13, r14, r15, r17, r19);
    L7:
        return null;
    }
}
