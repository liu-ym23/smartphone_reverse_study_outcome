package bytedanceos.api;

import android.os.IBinder;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TransactionSmt {
    public TransactionSmt() {
    }

    public static TransactionSmt getInstance() {
        throw new RuntimeException("should not call here");
    }

    public void setAnimationProperty(IBinder r1, ArrayList<Pair<String, String>> r2) {
        IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r1, IBinder.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("should not call here");
    }

    public void startAnimation(IBinder r2) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("should not call here");
    }

    public void stopAnimation(IBinder r2) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("should not call here");
    }
}
