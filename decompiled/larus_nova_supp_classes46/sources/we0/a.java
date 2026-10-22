package we0;

import ch0.g;
import ch0.h;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.c;
import java.util.ArrayList;
import java.util.List;
import xe0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements c {
    public a() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.c
    public final List<h> a() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        return LinkmicOnlineFloatWindowManager.c.a().D;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.c
    public final void b() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().E = null;
        ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().D).clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.c
    public final g d() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        return LinkmicOnlineFloatWindowManager.c.a().E;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.c
    public final boolean c() {
        return j.d();
    }
}
