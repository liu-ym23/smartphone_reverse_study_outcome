package ds1;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ VSChorusConcertWidget a;

    public b(VSChorusConcertWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L6;
    L14:
        if (r6 != null) goto L17;
    L25:
        int r1 = VSChorusConcertWidget.l;
        this.a.zq("onControlStatusListener PlayerViewControl.KEY.PlayerShadowBottom:" + r6);
        return;
    L17:
        if (r6.intValue() != 1) goto L25;
        VSChorusConcertWidget r2 = this.a;
        int r3 = VSChorusConcertWidget.l;
        r2.zq("播控组件 隐藏");
        es1.a r0 = this.a.xq(false);
        if (r0 == null) goto L25;
        if (r0.a != true) goto L25;
        FrameLayout r4 = this.a.a;
        if (r4 == null) goto L25;
        r4.setAlpha(1.0f);
        goto L25
    L6:
        if (r6.intValue() != 0) goto L14;
        VSChorusConcertWidget r7 = this.a;
        int r8 = VSChorusConcertWidget.l;
        r7.zq("播控组件 显示");
        es1.a r9 = this.a.xq(false);
        if (r9 == null) goto L25;
        if (r9.a != true) goto L25;
        FrameLayout r10 = this.a.a;
        if (r10 == null) goto L25;
        r10.setAlpha(0.2f);
        goto L25
    }
}
