package ag8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ SendImageCell a;

    public /* synthetic */ b(SendImageCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SendImageCell r0 = this.a;
        int r1 = SendImageCell.t;
        ChatParam r2 = (ChatParam) lf8.a.c(r0, ChatParam.class);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ChatParam(null, null, null, null, null, 255);
    }
}
