package ag8;

import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tx9.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ Message a;

    public /* synthetic */ l(Message r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Message r1 = this.a;
        int r2 = SendImageCell.t;
        t1.a(null, null, "chat", "user", r1.getMessageId(), Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(r1)), null, null, null, "default", null, "private", null, Boolean.FALSE, "pic", null, 76707);
        return Unit.INSTANCE;
    }
}
