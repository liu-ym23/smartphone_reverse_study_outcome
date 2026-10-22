package egb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.multi_select.ContentListenerImpl;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface e {
    void a(Context r1, Chat r2, ArrayList r3, int r4, ContentListener r5);

    void b(Context r1, Chat r2, ArrayList r3, ContentListenerImpl r4);

    void c(Context r1, Chat r2, String r3, String r4, Fragment r5);

    void d(Context r1, int r2, Message r3, String r4, boolean r5, ContentListener r6);
}
