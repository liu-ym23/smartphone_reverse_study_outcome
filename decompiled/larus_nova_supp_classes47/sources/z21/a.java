package z21;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public IRoom a;
    public final MutableLiveData<Unit> b;
    public mx0.a c;
    public final MutableLiveData<Unit> d;
    public final Context e;
    public final FrameLayout f;

    public final Context getContext() {
        return this.e;
    }

    public a(Context r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.e = r2;
        this.f = r3;
        this.b = new MutableLiveData();
        this.d = new MutableLiveData();
    }
}
