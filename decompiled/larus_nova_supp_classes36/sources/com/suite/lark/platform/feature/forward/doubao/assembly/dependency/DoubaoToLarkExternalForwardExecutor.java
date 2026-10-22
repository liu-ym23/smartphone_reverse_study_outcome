package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.Transmit2ThreadTarget;
import com.bytedance.lark.pb.im.v1.TransmitDoubaoMessagesRequest;
import com.bytedance.lark.pb.im.v1.TransmitDoubaoMessagesResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoToLarkExternalForwardExecutor implements IExternalForwardExecutor {
    public final String a;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public final ErrorResult a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failure(error=" + this.a + ')';
            }

            public a(ErrorResult r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.assembly.dependency.DoubaoToLarkExternalForwardExecutor$b$b, reason: collision with other inner class name */
        public static final class C0247b extends b {
            public final TransmitDoubaoMessagesResponse a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0247b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0247b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(response=" + this.a + ')';
            }

            public C0247b(TransmitDoubaoMessagesResponse r2) {
                Intrinsics.checkNotNullParameter(r2, "response");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public static final class c {
        public final List<String> a;
        public final List<Transmit2ThreadTarget> b;
        public final Map<String, ForwardTargetBaseInfoNew> c;
        public final Map<String, ForwardTargetBaseInfoNew> d;
        public final Set<String> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "TransmitTargets(chatIds=" + this.a + ", threadTargets=" + this.b + ", chatId2TargetMap=" + this.c + ", threadTargetMap=" + this.d + ", replyInThreadIds=" + this.e + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<String> r2, List<Transmit2ThreadTarget> r3, Map<String, ? extends ForwardTargetBaseInfoNew> r4, Map<String, ? extends ForwardTargetBaseInfoNew> r5, Set<String> r6) {
            Intrinsics.checkNotNullParameter(r2, "chatIds");
            Intrinsics.checkNotNullParameter(r3, "threadTargets");
            Intrinsics.checkNotNullParameter(r4, "chatId2TargetMap");
            Intrinsics.checkNotNullParameter(r5, "threadTargetMap");
            Intrinsics.checkNotNullParameter(r6, "replyInThreadIds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public DoubaoToLarkExternalForwardExecutor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "quasiTitle");
        this.a = r2;
    }

    public static final c c(DoubaoToLarkExternalForwardExecutor r9, List r10) {
        r9.getClass();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        LinkedHashMap r3 = new LinkedHashMap();
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashSet r5 = new LinkedHashSet();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ForwardTargetBaseInfoNew r0 = ForwardDataUtils.f((SearchBaseInfo) r12.next());
        if (r0 == null) goto L4;
        r11.add(r0);
        goto L4
    L8:
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L35;
        ForwardTargetBaseInfoNew r14 = (ForwardTargetBaseInfoNew) r13.next();
        if ((r14 instanceof ForwardTargetChatterInfo) == true) goto L13;
        if ((r14 instanceof ForwardTargetGroupChatInfo) == true) goto L16;
        if ((r14 instanceof ForwardTargetShieldP2PChatInfo) == true) goto L19;
        if ((r14 instanceof ForwardTargetThreadInfo) == false) goto L10;
        ForwardTargetThreadInfo r6 = (ForwardTargetThreadInfo) r14;
        String r7 = r6.g.getId();
        String r8 = r6.h;
        Intrinsics.checkNotNull(r7);
        if (StringsKt.isBlank(r7) == true) goto L33;
        if (StringsKt.isBlank(r8) == true) goto L33;
        r2.add(new Transmit2ThreadTarget.Builder().channel_id(r7).thread_id(r8).build());
        r4.put(r7 + '#' + r8, r14);
        int r15 = r6.j;
        boolean r16 = true;
        if (r15 == 1) goto L31;
        r16 = false;
    L31:
        if (r16 == false) goto L10;
        r5.add(r8);
    L33:
        Log.w("DoubaoToLarkExternalForwardExecutor", "skip empty thread target, chatId=" + r7 + ", threadId=" + r8);
        goto L10
    L19:
        e(((ForwardTargetShieldP2PChatInfo) r14).h, r14, r1, r3);
        goto L10
    L16:
        e(((ForwardTargetGroupChatInfo) r14).j, r14, r1, r3);
        goto L10
    L13:
        e(((ForwardTargetChatterInfo) r14).h, r14, r1, r3);
        goto L10
    L35:
        if (r1.isEmpty() == false) goto L42;
        if (r2.isEmpty() == false) goto L42;
        throw new ErrorResult(-1, "target is empty");
    L42:
        return new c(r1, r2, r3, r4, r5);
    }

    public static final Map b(DoubaoToLarkExternalForwardExecutor r4, TransmitDoubaoMessagesResponse r5, Map r6, Map r7) {
        r4.getClass();
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r0 = r5.message_ids.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        String r3 = (String) r1.getValue();
        Intrinsics.checkNotNull(r2);
        if (StringsKt.isBlank(r2) == true) goto L4;
        Intrinsics.checkNotNull(r3);
        if (StringsKt.isBlank(r3) == true) goto L4;
        ForwardTargetBaseInfoNew r9 = (ForwardTargetBaseInfoNew) r6.get(r2);
        if (r9 == null) goto L4;
        r8.put(r3, r9);
        goto L4
    L13:
        Iterator r10 = r5.message2threads.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        Transmit2ThreadTarget r13 = (Transmit2ThreadTarget) r11.getValue();
        Intrinsics.checkNotNull(r12);
        if (StringsKt.isBlank(r12) == true) goto L15;
        ForwardTargetBaseInfoNew r14 = (ForwardTargetBaseInfoNew) r7.get(r13.channel_id + '#' + r13.thread_id);
        if (r14 == null) goto L15;
        r8.put(r12, r14);
        goto L15
    L22:
        return r8;
    }

    public static void e(String r1, ForwardTargetBaseInfoNew r2, List r3, Map r4) {
        if (StringsKt.isBlank(r1) == false) goto L6;
        Log.w("DoubaoToLarkExternalForwardExecutor", "skip empty chat target, targetId=" + r2.a);
        return;
    L6:
        ((ArrayList) r3).add(r1);
        r4.put(r1, r2);
    }

    public static void f(final String r1, final String r2, String r3, RichText r4, boolean r5) {
        if (StringsKt.isBlank(r1) == false) goto L5;
    L12:
        Log.w("DoubaoToLarkExternalForwardExecutor", "skip addition note, chatId=" + r1 + ", parentId=" + r2);
        return;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L12;
        if (i.l(r4) == false) goto L10;
        r4 = com.ss.android.lark.widget.richtext.c.c(r3);
    L10:
        j1.a r6 = new j1.a();
        r6.A = r4;
        ((MessageParams.a) r6).c = r1;
        ((MessageParams.a) r6).b = r2;
        ((MessageParams.a) r6).a = r2;
        ((MessageParams.a) r6).i = r2;
        ((MessageParams.a) r6).m = r5;
        ((MessageParams.a) r6).n = MessageParams.CreateScene.COMMON_SHARE;
        MessageParams<?, ?> r7 = r6.b();
        p r8 = ImSdkService.f();
        Intrinsics.checkNotNull(r7);
        r8.sendMessage(r7, new DoubaoToLarkExternalForwardExecutor$sendAdditionNote$1(r1, r2));
    }

    public static final void d(DoubaoToLarkExternalForwardExecutor r6, TransmitDoubaoMessagesResponse r7, Map r8, Set r9, String r10, RichText r11) {
        r6.getClass();
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
    L10:
        Iterator r13 = r7.message_ids.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L28;
        Map.Entry r2 = (Map.Entry) r13.next();
        String r3 = (String) r2.getKey();
        String r4 = (String) r2.getValue();
        Intrinsics.checkNotNull(r3);
        if (StringsKt.isBlank(r3) == true) goto L12;
        Intrinsics.checkNotNull(r4);
        if (StringsKt.isBlank(r4) == true) goto L12;
        ForwardTargetBaseInfoNew r5 = (ForwardTargetBaseInfoNew) r8.get(r3);
        if ((r5 instanceof ForwardTargetGroupChatInfo) == true) goto L21;
    L26:
        boolean r14 = false;
    L27:
        f(r3, r4, r10, r11, r14);
        goto L12
    L21:
        if (((ForwardTargetGroupChatInfo) r5).h != ChatDisplayModeSetting.THREAD) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L26;
        r14 = true;
        goto L27
    L23:
        r15 = false;
        goto L24
    L28:
        Iterator r16 = r7.message2threads.values().iterator();
    L30:
        if (r16.hasNext() == false) goto L41;
        Transmit2ThreadTarget r17 = (Transmit2ThreadTarget) r16.next();
        String r18 = r17.channel_id;
        String r19 = r17.thread_id;
        f(r18, r19, r10, r11, r9.contains(r19));
        goto L30
    L41:
        return;
    L8:
        if (i.l(r11) == false) goto L10;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static Object g(DoubaoToLarkExternalForwardExecutor r1, final List r2, final List r3, List r4, String r5, Continuation r6) {
        r1.getClass();
        if (r2.isEmpty() == false) goto L8;
        if (r3.isEmpty() == false) goto L8;
        return new b.a(new ErrorResult(-1, "target is empty"));
    L8:
        if (((ArrayList) r4).isEmpty() == false) goto L11;
        return new b.a(new ErrorResult(-1, "doubao message is empty"));
    L11:
        if (StringsKt.isBlank(r5) == true) goto L19;
        TransmitDoubaoMessagesRequest.Builder r7 = new TransmitDoubaoMessagesRequest.Builder().chat_ids(r2).thread_targets(r3).doubao_messages(r4).quasi_title(r5).need_quasi_message(Boxing.boxBoolean(true));
        SdkSender.IParser r8 = com.suite.lark.platform.feature.forward.doubao.assembly.dependency.a.a;
        final SafeContinuation r9 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        IGetDataCallback<TransmitDoubaoMessagesResponse> r0 = new DoubaoToLarkExternalForwardExecutor$transmitDoubaoMessages$2$callback$1(r9, r2, r3);
        SdkSender.asynSendRequestNonWrap(Command.TRANSMIT_DOUBAO_MESSAGES, r7, r0, r8);
        Object r10 = r9.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r6);
        return r10;
    L20:
        return r10;
    L19:
        return new b.a(new ErrorResult(-1, "quasiTitle is empty"));
    }

    @Override // com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor
    public final void a(CoroutineScope r12, Context r13, List<? extends SearchBaseInfo> r14, String r15, RichText r16, IExternalForwardExecutor.a r17) {
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "items");
        Intrinsics.checkNotNullParameter(r15, "note");
        Intrinsics.checkNotNullParameter(r16, "richText");
        Intrinsics.checkNotNullParameter(r17, "callback");
        BuildersKt.launch$default(r12, null, null, new DoubaoToLarkExternalForwardExecutor$execute$1(r17, this, r14, r15, r16, null), 3, null);
    }
}
