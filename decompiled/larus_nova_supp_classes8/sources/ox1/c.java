package ox1;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final InnerContextEntity.FloatWindowDataSource a(InnerContextEntity.InnerFloatExtra r5) {
        if (r5 == null) goto L7;
        Long r2 = r5.getEnterRoomId();
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L8:
        if (r5 == null) goto L10;
        Room r4 = r5.getOuterRoom();
    L11:
        if (r4 == null) goto L14;
        return new e(r5.getOuterRoom());
    L14:
        if (r3 <= 0) goto L17;
        return new b(r3);
    L17:
        return new a();
    L10:
        r4 = null;
    L7:
        r3 = 0;
        goto L8
    }
}
