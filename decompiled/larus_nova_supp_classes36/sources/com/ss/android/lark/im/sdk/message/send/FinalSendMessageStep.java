package com.ss.android.lark.im.sdk.message.send;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.SendMessageRequest;
import com.bytedance.lark.pb.im.v1.SendMessageResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.PreMessageSendCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FinalSendMessageStep implements jkb.d<k> {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
    }

    public interface b {
        void a(SendMessageRequest.Builder r1, String r2, com.ss.android.lark.sdk.h r3, CapacityCallback<SendMessageResponse> r4);
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "FinalSendMessageStep";
    }

    public FinalSendMessageStep(b r2) {
        Intrinsics.checkNotNullParameter(r2, "sdkSender");
        this.a = r2;
    }

    @Override // jkb.d
    public final void a(jkb.b r9, jkb.c r10) {
        k r11 = (k) r9;
        Intrinsics.checkNotNullParameter(r11, "pipelineContext");
        Intrinsics.checkNotNullParameter(r10, "pipelineControl");
        Context r12 = ImSdk.a.getContext();
        MessageInfo r0 = r11.c;
        Intrinsics.checkNotNull(r0);
        final Message r1 = r0.getMessage();
        final Message.b r13 = ImSdkMessageUtils.b(r12, r1);
        final PreMessageSendCallback r2 = new PreMessageSendCallback(r1, r11.b);
        Function0<Unit> r3 = new FinalSendMessageStep$process$sendAction$1(this, r13, r2, r1);
        Long r4 = r11.d;
        Long r14 = r11.e;
        Log.d("FinalSendMessageStep", "queueId = " + r4);
        if (r4 == null) goto L28;
        if (r14 == null) goto L28;
        r13.e = (int) r14.longValue();
        Log.d("FinalSendMessageStep", "sequence = " + r14 + ", strictSendOrder = " + ((int) r14.longValue()) + ", messageId = " + r1.getId());
        Object r15 = m.a;
        long r5 = r4.longValue();
        long r16 = r14.longValue();
        Intrinsics.checkNotNullParameter(r3, "task");
        Object r6 = m.a;
        monitor-enter(r6);
        Map<Long, m.a> r7 = m.b;     // Catch: Throwable -> L25
        Long r8 = Long.valueOf(r5);     // Catch: Throwable -> L25
        LinkedHashMap r17 = (LinkedHashMap) r7;     // Catch: Throwable -> L25
        Object r18 = r17.get(r8);     // Catch: Throwable -> L25
        if (r18 != null) goto L10;
        r18 = new m.a(null);     // Catch: Throwable -> L25
        r17.put(r8, r18);     // Catch: Throwable -> L25
    L10:
        m.a r19 = (m.a) r18;     // Catch: Throwable -> L25
        if (r16 >= r19.b) goto L15;
        monitor-exit(r6);
        return;
    L15:
        r19.d.put(Long.valueOf(r16), r3);     // Catch: Throwable -> L25
        if (r19.c == false) goto L18;
    L20:
        boolean r20 = false;
    L21:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r6);
        if (r20 == false) goto L32;
        m.b(r5);
        return;
    L32:
        return;
    L18:
        if (r19.d.containsKey(Long.valueOf(r19.b)) == false) goto L20;
        r20 = true;
        r19.c = true;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L28:
        r3.invoke();
    }

    public final void b(Message.b r9, final IGetDataCallback<String> r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Log.i("FinalSendMessageStep", "putChatMessage:" + r9.c);
        if ((r10 instanceof PreMessageSendCallback) == false) goto L5;
        o r0 = ((PreMessageSendCallback) r10).mCallback;
    L6:
        StringBuilder r2 = new StringBuilder();
        if (r0 == null) goto L9;
        String r1 = r0.e() + '_';
    L10:
        r2.append(r1);
        r2.append(com.ss.android.lark.sdk.a.a());
        String r3 = r2.toString();
        com.ss.android.lark.sdk.h r4 = new com.ss.android.lark.sdk.h();
        boolean r5 = true;
        r4.b = true;
        SendMessageRequest.Builder r6 = new SendMessageRequest.Builder().cid(r9.a).file_handle(r9.b).preprocess_key(r9.c);
        int r7 = r9.e;
        if (r7 >= 0) goto L13;
    L15:
        r5 = false;
    L16:
        if (r5 == false) goto L18;
        Log.d("FinalSendMessageStep", "strictSendOrder = " + r9.e + ", cid = " + r9.a);
        r6.strict_send_order(Integer.valueOf(r9.e));
    L18:
        CapacityCallback<SendMessageResponse> r11 = new CapacityCallback(new FinalSendMessageStep$putChatMessage$wrappedCallback$1(r10));
        Intrinsics.checkNotNull(r6);
        this.a.a(r6, r3, r4, r11);
        return;
    L13:
        if (r7 >= Integer.MAX_VALUE) goto L15;
    L9:
        r1 = "";
        goto L10
    L5:
        r0 = null;
        goto L6
    }
}
