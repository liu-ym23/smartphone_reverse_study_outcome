package xca;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static AppIntentMessage a(Message r4) {
            zda.a r1 = zda.a.a;     // Catch: Exception -> L11
            if (r4 == null) goto L6;
            String r5 = r4.getContent();     // Catch: Exception -> L11
        L7:
            if (r5 != null) goto L9;
            r5 = NameKeys.UnloadStrategy_No_Strategy;
        L9:
            r1.getClass();     // Catch: Exception -> L11
            return zda.a.e(r5);
        L6:
            r5 = null;
        L11:
            e = move-exception;
            FLogger.a.e("IMsgProcessor", "parseAppIntentMessageHybridEntity failed e = " + e);
            return null;
        }
    }

    static {
        a = a.a;
    }
}
