package com.larus.bmhome.chat.trace;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.c5;
import com.larus.bmhome.chat.component.list.d5;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.trace.SendingTextEditTriggeredScene;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface l0 {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final ConcurrentHashMap<String, s> b = null;

        public a() {
        }

        static {
            a = new a();
            b = new ConcurrentHashMap();
        }
    }

    static {
        a = a.a;
    }

    void A();

    void C(RecyclerView r1, int r2);

    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();

    void p(Message r1);

    void q(boolean r1, Message r2);

    void r(MessageAdapter r1);

    void s(ChatMessageList r1);

    void t(d5 r1);

    void u(RecyclerView r1, int r2, int r3);

    void v(Message r1);

    void w(SendingTextEditTriggeredScene r1);

    void x(c5 r1);

    void y(int r1, int r2);

    void z();
}
