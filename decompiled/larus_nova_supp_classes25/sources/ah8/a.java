package ah8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.layout.item.w4;
import com.larus.bmhome.chat.list.cell.widget.WidgetCell;
import ei9.e;
import eo8.b;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ WidgetCell a;

    public /* synthetic */ a(WidgetCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        WidgetCell r0 = this.a;
        List r1 = WidgetCell.h;
        w4 r2 = r0.e;
        if (r2 == null) goto L5;
        Fragment r3 = e.b(r2);
    L7:
        return new b(r3, null, null, null, null, null, null, null, null, null, 2044);
    L5:
        r3 = null;
        goto L7
    }
}
