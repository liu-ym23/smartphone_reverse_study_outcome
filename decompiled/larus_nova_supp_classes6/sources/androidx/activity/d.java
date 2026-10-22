package androidx.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements OnContextAvailableListener {
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ d(ComponentActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        ComponentActivity.u1(this.a, r2);
    }
}
