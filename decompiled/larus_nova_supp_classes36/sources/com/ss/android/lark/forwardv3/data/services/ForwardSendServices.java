package com.ss.android.lark.forwardv3.data.services;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.Transmit2ThreadTarget;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.Forward$Type;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.forwardv3.utils.Constants$ForwardTargetType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardSendServices {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public ForwardSendServices() {
    }

    public static final void a(Map r5, Map r6) {
        StringBuilder r0 = new StringBuilder("forward to chat:\n");
        if (r5 == null) goto L8;
        Iterator r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r7.next();
        r0.append("   chatId: " + ((String) r2.getKey()) + " <---> messageId: " + ((String) r2.getValue()) + '\n');
    L8:
        r0.append("forward to thread:\n");
        if (r6 == null) goto L14;
        Iterator r8 = r6.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r9 = (Map.Entry) r8.next();
        r0.append("   messageId: " + ((String) r9.getKey()) + " <---> thread's threadId: " + ((Transmit2ThreadTarget) r9.getValue()).thread_id + ", channelId: " + ((Transmit2ThreadTarget) r9.getValue()).channel_id + '\n');
    L14:
        Log.i("ForwardSendServices", r0.toString());
    }

    public static Map d(List r8, boolean r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L45;
        ForwardTargetBaseInfoNew r1 = (ForwardTargetBaseInfoNew) r10.next();
        boolean r2 = false;
        if (r9 == false) goto L27;
        if ((r1 instanceof ForwardTargetThreadInfo) == true) goto L4;
        if ((r1 instanceof ForwardTargetGroupChatInfo) == false) goto L27;
        ForwardTargetGroupChatInfo r4 = (ForwardTargetGroupChatInfo) r1;
        Chat.ChatMode r5 = r4.g;
        if (r5 != Chat.ChatMode.THREAD_V2) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L4;
        if (r4.h != ChatDisplayModeSetting.THREAD) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
    L23:
        r7 = false;
        goto L24
    L15:
        if (r5 == Chat.ChatMode.THREAD) goto L18;
        r6 = false;
    L27:
        if ((r1 instanceof ForwardTargetChatterInfo) == false) goto L30;
        g r3 = new g(((ForwardTargetChatterInfo) r1).h);
    L42:
        if (r3 == null) goto L4;
        r0.put(r1, r3);
        goto L4
    L30:
        if ((r1 instanceof ForwardTargetGroupChatInfo) == false) goto L33;
        r3 = new g(((ForwardTargetGroupChatInfo) r1).j);
        goto L42
    L33:
        if ((r1 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L36;
        r3 = new g(((ForwardTargetShieldP2PChatInfo) r1).h);
        goto L42
    L36:
        if ((r1 instanceof ForwardTargetThreadInfo) == false) goto L41;
        ForwardTargetThreadInfo r11 = (ForwardTargetThreadInfo) r1;
        String r12 = r11.g.getId();
        String r13 = r11.h;
        if (r11.j != 1) goto L40;
        r2 = true;
    L40:
        r3 = new g(r12, true, r13, r2);
        goto L42
    L41:
        r3 = null;
        goto L42
    L45:
        return r0;
    }

    public static Map c(Map r6, Map r7, List r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r9.next();
        Iterator r2 = r8.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        ForwardTargetBaseInfoNew r3 = (ForwardTargetBaseInfoNew) r2.next();
        if ((r3 instanceof ForwardTargetGroupChatInfo) == true) goto L11;
        if ((r3 instanceof ForwardTargetShieldP2PChatInfo) == true) goto L16;
        if ((r3 instanceof ForwardTargetChatterInfo) == false) goto L7;
        if (Intrinsics.areEqual(((ForwardTargetChatterInfo) r3).h, r1.getKey()) == false) goto L7;
        r0.put(r1.getValue(), r3);
        goto L7
    L16:
        if (Intrinsics.areEqual(((ForwardTargetShieldP2PChatInfo) r3).h, r1.getKey()) == false) goto L7;
        r0.put(r1.getValue(), r3);
        goto L7
    L11:
        if (Intrinsics.areEqual(r3.a, r1.getKey()) == false) goto L7;
        r0.put(r1.getValue(), r3);
        goto L7
    L23:
        Iterator r10 = r7.entrySet().iterator();
    L25:
        if (r10.hasNext() == false) goto L36;
        Map.Entry r11 = (Map.Entry) r10.next();
        Iterator r4 = r8.iterator();
    L28:
        if (r4.hasNext() == false) goto L25;
        ForwardTargetBaseInfoNew r5 = (ForwardTargetBaseInfoNew) r4.next();
        if ((r5 instanceof ForwardTargetThreadInfo) == false) goto L28;
        ForwardTargetThreadInfo r12 = (ForwardTargetThreadInfo) r5;
        if (Intrinsics.areEqual(r12.h, ((Transmit2ThreadTarget) r11.getValue()).thread_id) == false) goto L28;
        if (Intrinsics.areEqual(r12.g.getId(), ((Transmit2ThreadTarget) r11.getValue()).channel_id) == false) goto L28;
        r0.put(r11.getKey(), r5);
        goto L28
    L36:
        StringBuilder r13 = new StringBuilder();
        r13.append("callback map result size: " + r0.size() + '\n');
        Iterator r14 = r0.entrySet().iterator();
    L38:
        if (r14.hasNext() == false) goto L40;
        Map.Entry r15 = (Map.Entry) r14.next();
        StringBuilder r16 = new StringBuilder("   messageId: ");
        r16.append((String) r15.getKey());
        r16.append(", target id: ");
        r16.append(((ForwardTargetBaseInfoNew) r15.getValue()).a);
        r16.append(", target type: ");
        Constants$ForwardTargetType.a r17 = Constants$ForwardTargetType.Companion;
        int r18 = ((ForwardTargetBaseInfoNew) r15.getValue()).getType();
        r17.getClass();
        r16.append(Constants$ForwardTargetType.a.a(r18));
        r16.append('\n');
        r13.append(r16.toString());
        goto L38
    L40:
        Log.i("ForwardSendServices", r13.toString());
        return r0;
    }

    public static void e(Map r3, Map r4, List r5, List r6) {
        Iterator r7 = ((LinkedHashMap) d(r6, false)).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) r7.next();
        if (((g) r0.getValue()).b == true) goto L7;
        r3.put(((g) r0.getValue()).a, r0.getKey());
        goto L4
    L7:
        Transmit2ThreadTarget r1 = new Transmit2ThreadTarget.Builder().thread_id(((g) r0.getValue()).c).channel_id(((g) r0.getValue()).a).build();
        r4.put(((g) r0.getValue()).c, r1);
        if (((g) r0.getValue()).d == false) goto L4;
        ArrayList r2 = (ArrayList) r5;
        r2.add(((g) r0.getValue()).c);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larksuite.framework.callback.IGetDataCallback, com.ss.android.lark.forwardv3.data.services.ForwardSendServices$sendAdditionNote$noteCallback$1] */
    public static void f(final String r2, final String r3, String r4, RichText r5, boolean r6, final oib.d r7) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        if (i.l(r5) == false) goto L13;
        Log.e("ForwardSendServices", "note is null or richText is null");
        return;
    L13:
        if (i.l(r5) == false) goto L15;
        r5 = com.ss.android.lark.widget.richtext.c.c(r4);
    L15:
        j1.a r8 = new j1.a();
        r8.A = r5;
        ((MessageParams.a) r8).c = r2;
        ((MessageParams.a) r8).b = r3;
        ((MessageParams.a) r8).a = r3;
        ((MessageParams.a) r8).i = r3;
        ((MessageParams.a) r8).m = r6;
        j1 r9 = r8.b();
        ?? r10 = new ForwardSendServices$sendAdditionNote$noteCallback$1(r2, r3, r7);
        Log.i("ForwardSendServices", "start to send note \n   chatId: " + r2 + " <---> note parent id: " + r3);
        tib.f r11 = (tib.f) ForwardModuleV3.b.getValue();
        if (r11 != 0) goto L19;
        r10.onError(new ErrorResult("IForwardImDependency is not registered"));
        return;
    L19:
        Intrinsics.checkNotNull(r9);
        r11.sendMessage(r9, r10);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static void g(String r15, RichText r16, Map r17, Map r18, Map r19, List r20, oib.d r21) {
        if (r15.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (i.l(r16) == false) goto L11;
        return;
    L11:
        if ((!r17.isEmpty()) == false) goto L32;
        Iterator r1 = r19.entrySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L32;
        Map.Entry r6 = (Map.Entry) r1.next();
        if (StringsKt.isBlank((CharSequence) r6.getKey()) == true) goto L14;
        String r10 = (String) r17.get(r6.getKey());
        if (r10 == null) goto L14;
        if ((r6.getValue() instanceof ForwardTargetGroupChatInfo) == false) goto L29;
        Object r7 = r6.getValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo");
        if (((ForwardTargetGroupChatInfo) r7).h != ChatDisplayModeSetting.THREAD) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        boolean r13 = true;
    L30:
        StringBuilder r9 = new StringBuilder("send addition note to normal chat, but is reply in thread: ");
        r9.append(r13);
        r9.append("\nchatId: ");
        r9.append((String) r6.getKey());
        r9.append(", type: ");
        Constants$ForwardTargetType.a r11 = Constants$ForwardTargetType.Companion;
        int r12 = ((ForwardTargetBaseInfoNew) r6.getValue()).getType();
        r11.getClass();
        r9.append(Constants$ForwardTargetType.a.a(r12));
        r9.append(", parentId: ");
        r9.append(r10);
        Log.i("ForwardSendServices", r9.toString());
        f((String) r6.getKey(), r10, r15, r16, r13, r21);
        goto L14
    L26:
        r8 = false;
    L29:
        r13 = false;
    L32:
        if ((!r18.isEmpty()) == false) goto L37;
        Iterator r2 = r18.values().iterator();
    L35:
        if (r2.hasNext() == false) goto L46;
        Transmit2ThreadTarget r3 = (Transmit2ThreadTarget) r2.next();
        boolean r14 = r20.contains(r3.thread_id);
        Log.i("ForwardSendServices", "send addition note to thread, is reply in thread: " + r14 + "\nchatId: " + r3.channel_id + ", parentId: " + r3.thread_id);
        f(r3.channel_id, r3.thread_id, r15, r16, r14, r21);
        goto L35
    L46:
        return;
    L37:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void b(int r15, boolean r16, int r17, int r18, int r19, String r20, RichText r21, String r22, List r23, IGetDataCallback r24, OnForwardContentListener r25, oib.d r26, ErrorResult r27, Context r28, Map r29, Map r30, Map.Entry r31, int r32) {
        if (TextUtils.isEmpty(r22) == false) goto L7;
        StringBuilder r7 = new StringBuilder("messageId is null error\n   chatId is: ");
        r7.append(((g) r31.getValue()).a);
        r7.append("\n   parentId is: ");
        r7.append(((g) r31.getValue()).c);
        r7.append("\n   target type is: ");
        Constants$ForwardTargetType.a r9 = Constants$ForwardTargetType.Companion;
        int r10 = ((ForwardTargetBaseInfoNew) r31.getKey()).getType();
        r9.getClass();
        r7.append(Constants$ForwardTargetType.a.a(r10));
        Log.e("ForwardSendServices", r7.toString());
    L10:
        if (r15 != r17) goto L17;
        Log.i("ForwardSendServices", "start send note for sendMessage");
        String r11 = ((g) r31.getValue()).a;
        String r8 = ((g) r31.getValue()).c;
        if (StringsKt.isBlank(r8) == false) goto L14;
        String r12 = r22;
    L15:
        f(r11, r12, r20, r21, ((g) r31.getValue()).d, r26);
        goto L17
    L14:
        r12 = r8;
    L17:
        if (r18 != r19) goto L48;
        Log.i("ForwardSendServices", "start handle callback");
        UICallbackExecutor.execute(b.a);
        String r0 = null;
        if (r16 == false) goto L38;
        if (r25 == null) goto L25;
        if (r27 == null) goto L23;
        String r1 = r27.getDisplayMsg();
    L24:
        r25.onFailed(r1);
        goto L25
    L23:
        r1 = null;
    L25:
        if (r24 != null) goto L27;
    L31:
        boolean r2 = zib.b.d;
        Forward$Type.Companion.getClass();
        String r3 = Forward$Type.a.a(r32);
        if (r27 == null) goto L34;
        int r4 = r27.getCode();
    L35:
        if (r27 == null) goto L37;
        r0 = r27.getDebugMsg();
    L37:
        zib.b.d(r3, r4, r0, "common_send_message");
        return;
    L34:
        r4 = -1;
        goto L35
    L27:
        if (r27 == null) goto L29;
        String r5 = r27.getDisplayMsg();
    L30:
        r24.onError(new ForwardErrorResultV3(r5, false));
        goto L31
    L29:
        r5 = null;
        goto L30
    L38:
        boolean r13 = true;
        if ((r28 instanceof Activity) == false) goto L42;
        if (r25 == null) goto L44;
        r13 = r25.m((Activity) r28, c(r29, r30, r23), true);
    L44:
        if (r24 == null) goto L46;
        r24.onSuccess(new rib.d(r13));
    L46:
        zib.b.f();
        return;
    L42:
        if (r25 == null) goto L44;
        r13 = r25.m(null, c(r29, r30, r23), true);
        goto L44
    L48:
        return;
    L7:
        if ((((ForwardTargetBaseInfoNew) r31.getKey()) instanceof ForwardTargetThreadInfo) == false) goto L9;
        r30.put(r22, new Transmit2ThreadTarget.Builder().channel_id(((g) r31.getValue()).a).thread_id(((g) r31.getValue()).c).build());
        goto L10
    L9:
        r29.put(((g) r31.getValue()).a, r22);
        goto L10
    }
}
