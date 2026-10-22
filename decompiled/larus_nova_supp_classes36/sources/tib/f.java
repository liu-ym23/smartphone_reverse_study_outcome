package tib;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.MessageParams;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f {
    void getThreadTopicsByIds(List<String> r1, IGetDataCallback<ThreadTopic> r2);

    void sendImages(String r1, List<String> r2, boolean r3, IGetDataCallback<String> r4);

    void sendMessage(MessageParams<?, ?> r1, IGetDataCallback<String> r2);
}
