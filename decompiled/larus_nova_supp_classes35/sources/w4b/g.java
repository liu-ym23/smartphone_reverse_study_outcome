package w4b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatwindow.view.burn.CountDownView;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface g {
    boolean a();

    void b(Context r1, ColumnsInfo r2);

    View c(ViewGroup r1, MessageInfo r2);

    void d(m2b.a r1, y6b.a<StickerContentVO> r2);

    int e();

    void f();

    void g(Context r1, l1 r2, Fragment r3);

    void h(Context r1, String r2, String r3);

    RichText i(com.ss.android.lark.widget.richtext.RichText r1);

    void j(Context r1, l1 r2);

    void k(m2b.a r1, y6b.a<ShareGroupChatContentVO> r2);

    void l();

    void m(FragmentActivity r1);

    void n(Context r1);

    void o();

    void openChat(Context r1, ChatBundle r2);

    boolean p(View r1, MessageInfo r2, v4b.d r3);

    s4b.a<CountDownView> q();

    void r();

    void s(m2b.a r1, y6b.a<MediaContentVO> r2);

    void t(Context r1, Fragment r2, ChatBundle r3);

    void u(FragmentActivity r1, String r2, String r3, Fragment r4);

    void v(yya.a r1, Message.DisabledAction.Action r2);

    void w(m2b.a r1, y6b.a<ImageContentVO> r2);

    void x();

    void y(Context r1, TableInfo r2);
}
