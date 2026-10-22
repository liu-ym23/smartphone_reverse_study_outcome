package py;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.util.MessageTypeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface m {
    public static final a l2 = null;

    public static final class a {
        public static final AtomicInteger a = null;
        public static final MessageTypeMap b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            a = new AtomicInteger(1000000);
            b = new MessageTypeMap(new ConcurrentHashMap());
        }

        public static void a(MessageType r2) {
            Intrinsics.checkNotNullParameter(r2, "messageType");
            MessageTypeMap r0 = b;
            if (r0.getMessageIntType(r2.getWsMethod()) != null) goto L6;
            r0.put(Integer.valueOf(a.getAndIncrement()), r2.getWsMethod());
            return;
        }
    }

    static {
        l2 = a.c;
    }

    int getIntTypeExt();

    String getWsMethod();
}
