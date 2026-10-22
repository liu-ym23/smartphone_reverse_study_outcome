package fx1;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Action {
    public final /* synthetic */ MutableLiveData a;
    public final /* synthetic */ Observer b;

    public a(MutableLiveData r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        MutableLiveData r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeObserver(this.b);
        return;
    }
}
