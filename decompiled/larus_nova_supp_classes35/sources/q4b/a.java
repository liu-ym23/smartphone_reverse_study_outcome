package q4b;

import android.net.Uri;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.File;
import java.util.List;
import m5b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends b {
    Message e(String r1, String r2, String r3, String r4, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r5);

    void f(List<String> r1, boolean r2, String r3, String r4, int r5, String r6, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r7);

    void h(List<? extends Photo> r1, String r2, String r3, int r4, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r5);

    void i(List<? extends File> r1);

    void q(List<? extends Uri> r1);

    void r(StickerFileInfo r1, String r2, String r3, PartialReplyInfo r4);
}
