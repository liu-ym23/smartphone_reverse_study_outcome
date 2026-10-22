package m20;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ XplayPerfPanelView a;

    public c(XplayPerfPanelView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        XplayPerfPanelView.c r5 = (XplayPerfPanelView.c) r4;
        ((ArrayList) this.a.c).clear();
        ((ArrayList) this.a.c).add("CPU(均值): " + r5.a);
        ((ArrayList) this.a.c).add("GPU(均值): " + r5.b);
        ((ArrayList) this.a.c).add("内存(MB)(均值) : " + r5.c);
        ((ArrayList) this.a.c).add("卡顿率(均值): " + r5.d);
        ((ArrayList) this.a.c).add("推流帧率(均值): " + r5.e);
        ((ArrayList) this.a.c).add("温度最大值: " + r5.f);
        List<String> r6 = this.a.c;
        StringBuilder r0 = new StringBuilder("xplay 分辨率: ");
        a r1 = XplayPerfPanelView.o;
        r0.append(r1.a);
        r0.append('-');
        r0.append(r1.b);
        ((ArrayList) r6).add(r0.toString());
        ((ArrayList) this.a.c).add("xplay 下行码率: " + r1.d + " kbps");
        ((ArrayList) this.a.c).add("xplay 渲染帧率: " + r1.c);
        RecyclerView.Adapter r7 = this.a.a.getAdapter();
        if (r7 == null) goto L6;
        r7.notifyItemRangeChanged(0, ((ArrayList) this.a.c).size());
        return;
    }
}
