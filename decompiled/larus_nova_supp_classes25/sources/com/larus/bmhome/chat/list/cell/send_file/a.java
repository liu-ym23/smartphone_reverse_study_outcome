package com.larus.bmhome.chat.list.cell.send_file;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.layout.item.f4;
import com.larus.bmhome.chat.sendimage.e;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ SendFileCell a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ a(SendFileCell r1, Context r2, Message r3, String r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r19) {
        SendFileCell r2 = this.a;
        Context r4 = this.b;
        Message r6 = this.c;
        String r5 = this.d;
        String r3 = this.e;
        String r1 = this.f;
        int r8 = SendFileCell.i;
        Intrinsics.checkNotNullParameter((f4) r19, "it");
        if (r2.h == true) goto L62;
        if (r4 == null) goto L63;
        int r7 = MultimodalSendCostTrace.a;
        String r9 = r6.getLocalMessageId();
        String r10 = "";
        if (r9 != null) goto L10;
        String r11 = "";
    L11:
        MultimodalSendCostTrace.b(r11, r6.getLocalMessageId(), r6.getConversationId(), null, AttachmentAreaType.SINGLE_ATTACHMENT, null, null, StringsKt.substringAfterLast$default(r5, '.', null, 2, null));
        List r12 = e.f(r3).getFileList();
        if (r12 == null) goto L14;
        SendFile r13 = (SendFile) CollectionsKt.firstOrNull(r12);
    L16:
        if (m5.c(r1) == false) goto L44;
        ImFileUtil r14 = ImFileUtil.a;
        Intrinsics.checkNotNull(r1);
        r14.getClass();
        if (ImFileUtil.B(r4, r1, r5, null) == false) goto L30;
        String r15 = r6.getLocalMessageId();
        if (r15 == null) goto L23;
        r10 = r15;
    L23:
        List r16 = e.f(r3).getFileList();
        if (r16 == null) goto L28;
        SendFile r17 = (SendFile) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L28;
        String r18 = r17.getTosKey();
    L29:
        MultimodalSendCostTrace.f(r10, r18, r6.getMessageId(), true, null);
    L42:
        FLogger.a.i("SendFileCell", "localID:" + r6.getLocalMessageId() + ", path:" + r1);
    L61:
        return Unit.INSTANCE;
    L28:
        r18 = null;
        goto L29
    L30:
        int r20 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r21 = r6.getLocalMessageId();
        if (r21 != null) goto L33;
        String r110 = "";
    L34:
        String r111 = r6.getMessageId();
        if (r13 == null) goto L37;
        String r112 = r13.getTosKey();
    L38:
        if (r13 == null) goto L40;
        String r113 = r13.getResourceId();
    L41:
        com.larus.bmhome.chat.trace.multimodal.a.d(r110, r111, true, "message_file_open_third_party_error", r112, r113);
        goto L42
    L40:
        r113 = null;
        goto L41
    L37:
        r112 = null;
        goto L38
    L33:
        r110 = r21;
        goto L34
    L44:
        if (NetworkUtils.isNetworkAvailable(r4) == true) goto L57;
        s.a.g(r4, 2131908080, false);
        int r22 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r23 = r6.getLocalMessageId();
        if (r23 != null) goto L48;
        String r114 = "";
    L49:
        String r115 = r6.getMessageId();
        if (r13 == null) goto L52;
        String r116 = r13.getTosKey();
    L53:
        if (r13 == null) goto L55;
        String r117 = r13.getResourceId();
    L56:
        com.larus.bmhome.chat.trace.multimodal.a.d(r114, r115, false, "message_file_open_no_net_work", r116, r117);
        return Unit.INSTANCE;
    L55:
        r117 = null;
        goto L56
    L52:
        r116 = null;
        goto L53
    L48:
        r114 = r23;
        goto L49
    L57:
        FLogger.a.i("SendFileCell", "localID:" + r6.getLocalMessageId() + ", file not exist, path:" + r1);
        CoroutineScope r24 = (CoroutineScope) r2.g.getValue();
        if (r24 == null) goto L61;
        BuildersKt.launch$default(r24, Dispatchers.getIO(), null, new SendFileCell$setupImgViewAndTextView$1$1(r2, r3, r4, r5, r6, r13, null), 2, null);
        goto L61
    L14:
        r13 = null;
        goto L16
    L10:
        r11 = r9;
        goto L11
    L63:
        return Unit.INSTANCE;
    L62:
        return Unit.INSTANCE;
    }
}
