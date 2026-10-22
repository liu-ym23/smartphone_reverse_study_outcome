package n10;

import android.widget.CompoundButton;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements CompoundButton.OnCheckedChangeListener {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L8;
        m<Boolean> r5 = r4.getOpenGamePerfPanel();
        if (r5 == null) goto L9;
        r5.setValue(Boolean.valueOf(r3));
        return;
    L9:
        return;
    }
}
