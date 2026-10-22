package h01;

import android.view.View;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zr2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends dy0.d {
    String W6(RevToolbarConstants r1, IRoom r2, boolean r3, RevResKeyEnum r4);

    void Ye(RevToolbarConstants r1, k r2, Function1<? super d, Unit> r3);

    void Za(RevToolbarConstants r1);

    void f5(RevToolbarConstants r1, k r2);

    void k1(boolean r1, View r2);

    void s0(RevToolbarConstants r1);

    boolean wk(RevToolbarConstants r1, IRoom r2, boolean r3, RevResKeyEnum r4);

    void y9(DataCenter r1, boolean r2);
}
