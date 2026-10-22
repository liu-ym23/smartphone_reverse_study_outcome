package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.api.x;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.n1;
import com.larus.bmhome.chat.component.bottom.core.q1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import v19.m5;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements x {
    public static final /* synthetic */ int d = 0;
    public final CoroutineScope a;
    public final AtomicBoolean b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.api.x
    public final void c() {
        if (this.c == true) goto L6;
        return;
    L6:
        if (this.b.compareAndSet(false, true) == false) goto L9;
        FLogger.a.i("CoreInputSender", "[appendInterruptCommand] append interrupt command");
        return;
    }

    public final boolean d() {
        if (this.b.compareAndSet(true, false) == true) goto L5;
        return false;
    L5:
        if (this.c == false) goto L7;
        FLogger.a.i("CoreInputSender", "[consumeInterruptCommand] actually consumed");
        this.c = false;
        return true;
    L7:
        FLogger.a.i("CoreInputSender", "[consumeInterruptCommand] abort");
        return false;
    }

    public f() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = new AtomicBoolean(false);
    }

    @Override // com.larus.bmhome.chat.api.x
    public final void a(final y8 r24, final String r25, final ICoreInputAbility.OnSendParams r26, final String r27, Map r28, n1 r29) {
        Intrinsics.checkNotNullParameter(r24, "dependency");
        Intrinsics.checkNotNullParameter(r25, "originContent");
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r27, "sendScene");
        Intrinsics.checkNotNullParameter(r28, "ext");
        Intrinsics.checkNotNullParameter(r29, "originalLogic");
        MultiAttachmentInfo r1 = r26.getMultiAttachment();
        if (r1 == null) goto L6;
        String r2 = r1.getLocalMsgId();
        if (r2 == null) goto L6;
    L7:
        String r15 = r2;
        g1 r3 = r24.f70();
        ArrayList r4 = null;
        if (r3 == null) goto L10;
        NestedFileContent r14 = r3.b6(r15);
    L11:
        if (r14 == null) goto L23;
        List r5 = r14.getEntities();
        if (r5 == null) goto L23;
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        UplinkFileEntity r7 = (UplinkFileEntity) r6.next();
        if (Intrinsics.areEqual(((LinkedHashMap) r28).get("chat_raf_option"), "1") == false) goto L16;
        if (yc9.n1.d(r7) == false) goto L16;
        r7.setFileReviewStatus(Integer.valueOf(FileReviewState.PROCESSING.getValue()));
    L23:
        if (r14 == null) goto L38;
        List r8 = r14.getEntities();
        if (r8 == null) goto L38;
        r4 = new ArrayList();
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L38;
        Object r10 = r9.next();
        Integer r11 = ((UplinkFileEntity) r10).getUpLinkStatus();
        int r12 = UpLinkState.SUCCESS.getValue();
        if (r11 != null) goto L33;
    L34:
        boolean r13 = true;
    L36:
        if (r13 == false) goto L28;
        r4.add(r10);
        goto L28
    L33:
        if (r11.intValue() != r12) goto L34;
        r13 = false;
    L38:
        if (r4 != null) goto L40;
    L43:
        boolean r16 = true;
    L44:
        if (r16 == false) goto L47;
        r29.invoke();
        d();
        return;
    L47:
        this.c = true;
        y r17 = r24.u0();
        if (r17 == null) goto L60;
        final wc9.e r18 = r17.h();
        if (r18 == null) goto L60;
        final String r19 = r18.a;
        final ChatPageContext r20 = r26.chatPageContext;
        final Map r21 = com.larus.utils.h.c(r28, new Pair[0]);
        SuggestedAction r0 = r26.getSuggestedAction();
        if (r0 == null) goto L56;
        Map r22 = r0.getMsgExt();
        if (r22 == null) goto L56;
        r21.putAll(r22);
    L56:
        gd8.g r23 = r24.h2();
        if (r23 == null) goto L59;
        r23.mh(r19, "send_multi_attachment", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
    L59:
        final NestedFileContent r30 = r14;
        u1$a.b(zh8.a.a.getSender(), r25, r14, r15, r18, r19, r21, r26.getReferenceInfo(), r20, new d(this, r19, r30, r21, r26, r20, r25, r24, r18, r27), 64);
    L60:
        g1 r31 = r24.f70();
        if (r31 == null) goto L63;
        r31.W0();
    L63:
        bc8.a r32 = r24.aE();
        if (r32 == null) goto L79;
        r32.mX();
        return;
    L79:
        return;
    L40:
        if (r4.isEmpty() == true) goto L43;
        r16 = false;
        goto L44
    L10:
        r14 = null;
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.larus.bmhome.chat.api.x
    public final void b(y8 r21, ICoreInputAbility.OnSendParams r22, String r23, final AttachmentInfo r24, Map r25, List r26, String r27, final q1 r28) {
        Intrinsics.checkNotNullParameter(r21, "dependency");
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r23, "originContent");
        Intrinsics.checkNotNullParameter(r24, "attachment");
        Intrinsics.checkNotNullParameter(r25, "ext");
        Intrinsics.checkNotNullParameter(r28, "originalLogic");
        if (o0.d(r24.getTosKey()) == false) goto L6;
        r28.invoke(r24, r22.attachmentLocalMsgIds, r27);
        d();
        return;
    L6:
        this.c = true;
        y r3 = r21.u0();
        if (r3 == null) goto L28;
        wc9.e r12 = r3.h();
        if (r12 == null) goto L28;
        final String r13 = r12.a;
        ChatPageContext r11 = r22.chatPageContext;
        if (r26 == null) goto L14;
        String r4 = (String) CollectionsKt.firstOrNull(r26);
        if (r4 == null) goto L14;
    L15:
        String r10 = r4;
        n r5 = n.a;
        String r6 = r24.getFileIdentifier();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
        final UplinkFileEntity r7 = n.c.remove(r6);
        if (r7 == null) goto L28;
        NestedFileCacheManagerService r8 = NestedFileCacheManagerService.b;
        r8.c(r10, r7);
        final NestedFileContent r16 = r8.b6(r10);
        if (r16 == null) goto L28;
        gd8.g r9 = r21.h2();
        if (r9 == null) goto L27;
        r9.mh(r13, "send_single_attachment", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
    L27:
        zh8.a.a.getSender().b(r23, r16, r10, r12, r13, r25, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_single_attachment", "1")}), r22.getReferenceInfo(), r11, new c(r24, r7, r13, r16, this, r28));
    L14:
        int r14 = wf9.b.a;
        r4 = com.flow.kmp.common.util.i.a();
    L28:
        bc8.a r0 = r21.aE();
        if (r0 == null) goto L32;
        r0.mX();
        return;
    }

    public final void e(Message r22, List r23, boolean r24, wc9.e r25, String r26, ReferenceInfo r27, String r28, ChatPageContext r29) {
        Intrinsics.checkNotNullParameter(r22, "message");
        Intrinsics.checkNotNullParameter(r23, "entityList");
        Intrinsics.checkNotNullParameter(r25, "conversation");
        Intrinsics.checkNotNullParameter(r26, "botId");
        Intrinsics.checkNotNullParameter("resend", "fromScene");
        FLogger.a.i("CoreInputSender", "retrySendNestedFileMessage fromScene:resend, entityList:" + r23);
        ArrayList r6 = new ArrayList();
        Iterator r0 = r23.iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        Object r2 = r0.next();
        UplinkFileEntity r14 = (UplinkFileEntity) r2;
        Integer r15 = r14.getUpLinkStatus();
        int r8 = UpLinkState.FAIL.getValue();
        if (r15 != null) goto L9;
    L10:
        Integer r9 = r14.getUpLinkStatus();
        int r16 = UpLinkState.DEFAULT.getValue();
        if (r9 != null) goto L14;
    L16:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L4;
        r6.add(r2);
        goto L4
    L14:
        if (r9.intValue() != r16) goto L16;
    L17:
        r10 = true;
        goto L18
    L9:
        if (r15.intValue() == r8) goto L17;
    L21:
        if (r6.isEmpty() == false) goto L25;
        FLogger.a.i("CoreInputSender", "Retry direct send return: no failed file");
        return;
    L25:
        if (r6.isEmpty() == true) goto L33;
        Iterator r1 = r6.iterator();
    L29:
        if (r1.hasNext() == false) goto L33;
        if (m5.c(l1.d((UplinkFileEntity) r1.next())) == true) goto L29;
        boolean r11 = false;
    L34:
        if (r11 == true) goto L37;
        FLogger.a.i("CoreInputSender", "Retry direct send return: file not exist");
        return;
    L37:
        BuildersKt.launch$default(this.a, null, null, new CoreInputSender$retrySendNestedFileMessage$1(r22, r29, r25, r6, r23, this, r26, r24, "resend", null, null, null, r28, r27, null), 3, null);
        return;
    L33:
        r11 = true;
        goto L34
    }
}
