package com.obric.assistant.card.manager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.card.layout.viewholder.LarkMessageViewHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final ConcurrentHashMap<String, CountDownTimer> a = null;
    public static final ConcurrentHashMap<String, Long> b = null;
    public static final ConcurrentHashMap<String, InterfaceC0076a> c = null;
    public static final Handler d = null;
    public static final ConcurrentHashMap<String, Integer> e = null;

    /* JADX INFO: renamed from: com.obric.assistant.card.manager.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
        void onFinish();

        void onTick(long r1);
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Intrinsics.checkNotNullParameter(r3, "error");
            FLogger.a.i("LarkMessageTimerManager", "larkMessage notifyStatusChange updateStatus failure localMsgId:" + this.a);
        }

        public final void onSuccess(Object r5) {
            Message r6 = (Message) r5;
            Intrinsics.checkNotNullParameter(r6, "message");
            Map r0 = r6.getExt();
            if (r0 == null) goto L6;
            final Map r1 = MapsKt.toMutableMap(r0);
            if (r1 == null) goto L6;
        L7:
            r1.put("lark_message_card_status", String.valueOf(this.b));
            com.larus.im.d.e().x(this.a, new e(r1), null);
            FLogger.a.i("LarkMessageTimerManager", "larkMessage notifyStatusChange updateStatus success localMsgId:" + r6.getLocalMessageId());
            return;
        L6:
            r1 = new LinkedHashMap();
            goto L7
        }

        public b(String r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new Handler(Looper.getMainLooper());
        e = new ConcurrentHashMap();
    }

    public static void a(String r2, LarkMessageViewHolder.b r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        if (r3 == null) goto L5;
        c.put(r2, r3);
    L6:
        ConcurrentHashMap<String, CountDownTimer> r0 = a;
        if (r0.containsKey(r2) == false) goto L14;
        Long r4 = b.get(r2);
        if (r4 == null) goto L18;
        long r1 = r4.longValue();
        if (r3 == null) goto L19;
        r3.onTick(r1);
        return;
    L19:
        return;
    L18:
        return;
    L14:
        d r5 = new d(r2);
        r0.put(r2, r5);
        r5.start();
        if (r3 == null) goto L20;
        r3.onTick(5000);
        return;
    L20:
        return;
    L5:
        c.remove(r2);
        goto L6
    }

    public static void b(String r2, int r3) {
        Integer r0 = Integer.valueOf(r3);
        e.put(r2, r0);
        com.larus.im.d.e().m(r2, new b(r2, r3));
        IAgentAppIntentIDL r1 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r1 == null) goto L6;
        r1.notifyLarkSendStausChanged(r2, r3);
        return;
    }
}
