package a2b;

import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.p1;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.api.service.impl.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface m {
    l5b.a a(GetThreadMessagesByPositionsRequest.Builder r1, s1 r2);

    l5b.b b(GetChannelThreadsRequest.Builder r1, p1 r2);

    void c(UpdateThreadRequest.Builder r1, IGetDataCallback<Void> r2);

    l5b.a d(GetThreadMessagesV2Request.Builder r1, q1.a r2);
}
