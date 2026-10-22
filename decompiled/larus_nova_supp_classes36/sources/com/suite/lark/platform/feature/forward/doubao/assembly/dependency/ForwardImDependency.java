package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.MGetThreadsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.api.service.impl.m1;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tib.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(f.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J6\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J$\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0016¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/assembly/dependency/ForwardImDependency;", "Lcom/ss/android/lark/forwardv3/dependency/IForwardImDependency;", "<init>", "()V", "sendMessage", "", "messageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "sendImages", "chatId", "imagePaths", "", "keepOrigin", "", "getThreadTopicsByIds", "threadIds", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "forward-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardImDependency implements f {
    public ForwardImDependency() {
    }

    @Override // tib.f
    public void getThreadTopicsByIds(List<String> r4, IGetDataCallback<ThreadTopic> r5) {
        Intrinsics.checkNotNullParameter(r4, "threadIds");
        Intrinsics.checkNotNullParameter(r5, "callback");
        q1 r0 = q1.d.a;
        if (CollectionUtils.isEmpty(r4) == false) goto L6;
        if (r5 == null) goto L8;
        r5.onError(new ErrorResult("thread id is empty"));
        return;
    L8:
        return;
    L6:
        MGetThreadsRequest.Builder r1 = new MGetThreadsRequest.Builder();
        r1.thread_ids(r4).for_normal_chat_message(Boolean.FALSE).strategy(SyncDataStrategy.TRY_LOCAL);
        SdkSender.asynSendRequestNonWrap(Command.MGET_THREADS, r1, r5, new m1(r4));
    }

    @Override // tib.f
    public void sendMessage(MessageParams<?, ?> r2, IGetDataCallback<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
        ImSdkService.f().sendMessage(r2, r3);
    }

    @Override // tib.f
    public void sendImages(String r2, List<String> r3, boolean r4, IGetDataCallback<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "imagePaths");
        ImSdkService.f().sendImages(r2, r3, r4, r5);
    }
}
