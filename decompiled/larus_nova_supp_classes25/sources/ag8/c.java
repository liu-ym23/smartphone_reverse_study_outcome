package ag8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ SendImageCell a;

    public /* synthetic */ c(SendImageCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SendImageCell r1 = this.a;
        int r2 = SendImageCell.t;
        y r3 = (y) r1.g.getValue();
        if (r3 == null) goto L7;
        BotModel r4 = r3.j0();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    }
}
