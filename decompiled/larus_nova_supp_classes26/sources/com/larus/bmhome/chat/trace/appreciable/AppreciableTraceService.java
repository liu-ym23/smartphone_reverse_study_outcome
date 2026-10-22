package com.larus.bmhome.chat.trace.appreciable;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.IAppreciableTraceService;
import com.larus.im.bean.message.MessageTrackContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/AppreciableTraceService;", "Lcom/larus/bmhome/chat/api/IAppreciableTraceService;", "<init>", "()V", "onStartSendMsg", "", "localSendMsgId", "", "cvsId", "scene", "contentType", "", "onSendFailedBeforeACK", "errorType", "status", "onMessageShowOnScreen", "msg", "Lcom/larus/im/bean/message/Message;", "createMessageTrackContext", "Lcom/larus/im/bean/message/MessageTrackContext;", "businessSendStartTimestamp", "", "agentMode", "(JLjava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageTrackContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppreciableTraceService implements IAppreciableTraceService {
    public AppreciableTraceService() {
    }

    public final MessageTrackContext a(long r6, Integer r8) {
        Intrinsics.checkNotNullParameter("share_send", "scene");
        LruCache<String, CommonParamManager.CommonParam> r2 = CommonParamManager.a;
        Intrinsics.checkNotNullParameter("share_send", "scene");
        Map r3 = MapsKt.createMapBuilder();
        r3.put("c_trace_id", CommonParamManager.b());
        r3.put("scene", "share_send");
        if (r8 == null) goto L5;
        r3.put("agent_mode", String.valueOf(r8.intValue()));
    L5:
        Unit r9 = Unit.INSTANCE;
        return new MessageTrackContext(r6, MapsKt.build(r3));
    }

    public final void c(String r12, String r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r13, "cvsId");
        Intrinsics.checkNotNullParameter(r14, "scene");
        f.l(f.a, r12, r13, r14, r15, null, null, null, null, 240);
    }

    public final void b(String r2, String r3, int r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r3, "scene");
        f.a.getClass();
        f.i(r2, r3, r4, r5, r6);
    }
}
