package da1;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ c a;
    public final /* synthetic */ IRoom b;

    public d(c r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r1) {
        if (((bz.a) r1) == null) goto L6;
        q46.a r2 = ((q46.b) this.a).a;
        return;
    }
}
