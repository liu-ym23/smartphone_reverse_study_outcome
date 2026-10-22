package c41;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public IRoom a;
    public final MutableLiveData<g90.a> b;
    public final MutableLiveData<Unit> c;
    public final Context d;
    public final FrameLayout e;

    public final Context getContext() {
        return this.d;
    }

    public a(Context r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.d = r2;
        this.e = r3;
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
    }
}
