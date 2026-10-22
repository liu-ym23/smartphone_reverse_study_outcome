package com.obric.assistant.spi.message;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/spi/message/IObricAppreciablePoint;", "", "onStartSendMsg", "", "localSendMsgId", "", "onSendAck", "localMsgId", "msgId", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAppreciablePoint {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final IObricAppreciablePoint b = null;

        public a() {
        }

        static {
            a = new a();
            b = (IObricAppreciablePoint) ServiceManager.get().getService(IObricAppreciablePoint.class);
        }
    }

    static {
        a = a.a;
    }

    void a(String r1, String r2);

    void b(String r1);
}
