package ep1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.um;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends e {
    public final DataCenter a;

    @Override // ep1.e, ep1.c
    public final String b() {
        if (z.i(this.a) == false) goto L8;
        if (um.a.getValue().booleanValue() == false) goto L8;
        return s1.B(2131914874);
    L8:
        return s1.B(2131915345);
    }

    public b() {
        this.a = null;
    }
}
