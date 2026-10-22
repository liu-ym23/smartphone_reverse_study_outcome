package com.obric.assistant.spi.chat;

import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/chat/ReceiveStreamMessageTypeOverriderDelegate;", "Lcom/obric/assistant/spi/chat/IReceiveStreamMessageTypeOverrider;", "<init>", "()V", "overrideMessageType", "", "msg", "Lcom/larus/im/bean/message/Message;", "defaultType", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveStreamMessageTypeOverriderDelegate implements IReceiveStreamMessageTypeOverrider {
    public static final ReceiveStreamMessageTypeOverriderDelegate b = null;
    public final /* synthetic */ IReceiveStreamMessageTypeOverrider a;

    static {
        b = new ReceiveStreamMessageTypeOverriderDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider
    public final String a(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.a(r2, r3);
    }

    private ReceiveStreamMessageTypeOverriderDelegate() {
        IReceiveStreamMessageTypeOverrider r0 = (IReceiveStreamMessageTypeOverrider) ServiceManager.get().getService(IReceiveStreamMessageTypeOverrider.class);
        if (r0 != null) goto L5;
        r0 = new DefaultReceiveStreamMessageTypeOverriderImpl();
    L5:
        this.a = r0;
    }
}
