package r42;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class i {
    public final int a;
    public boolean b;
    public final List<t> c;

    public abstract boolean a();

    public abstract void b(vlc.d r1, aa2.e r2);

    public i(IRoom r2) {
        this.a = g.d();
        this.c = new ArrayList();
        if (r2 == null) goto L7;
        IRoomAuthStatus r0 = r2.getRoomAuthStatus();
        if (r0 == null) goto L7;
        r0.isEnableFirstFetchHistory();
    L7:
        if (r2 == null) goto L12;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L13;
        r3.isEnableLoadMoreHistory();
        return;
    L13:
        return;
    }
}
