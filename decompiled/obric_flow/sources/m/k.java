package m;

import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import com.zte.aimodel.IResponseCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends IResponseCallback.Stub {
    @Override // com.zte.aimodel.IResponseCallback
    public final void onFailure(String r5) {
        a.A("onFailure err=", r5, m.g);
    }

    @Override // com.zte.aimodel.IResponseCallback
    public final boolean onSuccess(String r5, boolean r10) {
        String r11 = m.g;
        Log.d(r11, "onSuccess, result=" + r5);
        Log.d(r11, "onSuccess, isEnd=" + r10);
        return false;
    }
}
