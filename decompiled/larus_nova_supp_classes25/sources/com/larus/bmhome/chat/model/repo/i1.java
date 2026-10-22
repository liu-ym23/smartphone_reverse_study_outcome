package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 implements u1 {
    public static final i1 a = null;
    public static final MutableSharedFlow<IIMError> b = null;

    public i1() {
    }

    public final void a(Message r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        Intrinsics.checkNotNullParameter(r2, "record");
    }

    public final void d(String r1, int r2, ic8.w r3, Function1<? super Message, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Intrinsics.checkNotNullParameter(r4, "prepareResult");
    }

    public final void f(wc9.e r1, String r2, String r3, List<? extends ic8.w> r4, String r5, IIMCallback<List<Message>> r6, boolean r7, boolean r8, Long r9) {
        Intrinsics.checkNotNullParameter(r1, "conversation");
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "txtScene");
        Intrinsics.checkNotNullParameter(r4, "sendStrategies");
    }

    public final void h(Message r1, String r2, Map<String, String> r3, boolean r4, AttachmentInfo r5, NestedFileContent r6, String r7, ChatPageContext r8, Long r9) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "replaceText");
    }

    public final void k(String r1, List<? extends ic8.w> r2, String r3, boolean r4, String r5, IIMCallback<List<Message>> r6, boolean r7, Long r8) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r2, "strategies");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "sendFuncChannel");
    }

    public final void l(String r1, NestedFileContent r2, ChatPageContext r3, com.larus.bmhome.chat.component.bottom.multimodal.d r4) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r4, "prepareResult");
    }

    public final void n1(String r2, OmniBreakReason r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "breakReason");
    }

    public final void o(wc9.e r1, String r2, List<? extends ic8.w> r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "conversation");
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "strategies");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter("MultimodalInputComponentViewModel#sendMediaMessage", "sendFuncChannel");
    }

    public final void p(wc9.e r1, Message r2, ChatPageContext r3) {
        Intrinsics.checkNotNullParameter(r1, "conversation");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public final void q(String r1, Function1<? super Message, Unit> r2, ChatPageContext r3) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r2, "prepareResult");
    }

    public final void r(String r1, String r2, Map<String, String> r3) {
    }

    public final void streamAudioText(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void submitAudioText(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void t(String r1, wc9.e r2, String r3, Function1<? super Message, Unit> r4, ChatPageContext r5) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    public final void v(String r2, String r3, NestedFileContent r4, Map<String, String> r5, IIMCallback<Message> r6) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "localMessageId");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "bizExt");
        Intrinsics.checkNotNullParameter(r6, "callback");
    }

    public final void w(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    static {
        a = new i1();
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final MutableSharedFlow i() {
        return b;
    }

    public final List<ic8.w> c(List<Message> r1, ChatPageContext r2) {
        Intrinsics.checkNotNullParameter(r1, "messages");
        return CollectionsKt.emptyList();
    }

    public final Object m(Message r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    public final Object n(Message r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    public final void g(String r2, List<? extends ic8.w> r3, Function1<? super List<Message>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "strategies");
        Intrinsics.checkNotNullParameter(r4, "prepareResult");
        r4.invoke(CollectionsKt.emptyList());
    }

    public final void j(String r2, ai8.e r3, ai8.h r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "imageStrategy");
        Intrinsics.checkNotNullParameter(r4, "textStrategy");
        Intrinsics.checkNotNullParameter(r5, "prepareResult");
        r5.invoke(CollectionsKt.emptyList());
    }

    public final void e(String r1, ic8.w r2, Message r3, Function2<? super Message, ? super IIMError, Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (r4 == null) goto L6;
        r4.invoke(null, null);
        return;
    }

    public final void b(String r1, NestedFileContent r2, String r3, wc9.e r4, String r5, Map<String, String> r6, Map<String, String> r7, ReferenceInfo r8, ChatPageContext r9, Function1<? super List<Message>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r1, "txtContext");
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "nestedFileLocalMsgId");
        Intrinsics.checkNotNullParameter(r4, "conversation");
        Intrinsics.checkNotNullParameter(r5, "cvsId");
        Intrinsics.checkNotNullParameter(r6, "extras");
        Intrinsics.checkNotNullParameter(r7, "bizExtras");
        Intrinsics.checkNotNullParameter(r10, "prepareResult");
        r10.invoke(CollectionsKt.emptyList());
    }

    public final void u(String r1, String r2, UploadDataType r3, Function1<? super mr9.l, Unit> r4, Function1<? super mr9.k, Unit> r5, Function1<? super ResourceUploadError, Unit> r6, boolean r7, CountDownLatch r8, String r9, Boolean r10, mr9.c r11, String r12, FlowResourceScene r13, String r14) {
        Intrinsics.checkNotNullParameter(r1, "filePath");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "successCallback");
        Intrinsics.checkNotNullParameter(r5, "processCallback");
        Intrinsics.checkNotNullParameter(r6, "failedCallback");
        if (r8 == null) goto L6;
        r8.countDown();
        return;
    }

    public final void s(String r1, String r2, String r3, List<TextTagInfo> r4, Map<String, String> r5, Function2<? super Message, ? super IIMError, Unit> r6, MessageStatus r7, String r8, boolean r9, ReferenceInfo r10, String r11, String r12, ChatPageContext r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r1, "content");
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r11, "sendFuncChannel");
        if (r6 == null) goto L6;
        r6.invoke(null, null);
        return;
    }
}
