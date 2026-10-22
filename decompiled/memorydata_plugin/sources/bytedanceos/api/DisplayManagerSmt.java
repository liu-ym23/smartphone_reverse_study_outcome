package bytedanceos.api;

import android.content.Context;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DisplayManagerSmt {
    public DisplayManagerSmt() {
    }

    public static DisplayManagerSmt getInstance() {
        throw new RuntimeException("should not call here");
    }

    public IBinder getDisplayToken(Context r1, int r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("should not call here");
    }
}
