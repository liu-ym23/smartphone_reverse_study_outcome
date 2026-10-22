package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DirectSendFileHelper {
    public static final Map<String, List<String>> a = null;
    public static int b;
    public static final ConcurrentHashMap<String, e> c = null;
    public static final AtomicInteger d = null;

    static {
        a = new LinkedHashMap();
        c = new ConcurrentHashMap();
        d = new AtomicInteger(0);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.chat.component.bottom.multimodal.d] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.chat.component.bottom.multimodal.c] */
    public static void a(final List r20, final boolean r21, final wc9.e r22, final String r23, final String r24, final String r25, final String r26, final String r27, final DirectSendData r28, final String r29, final ReferenceInfo r30, final b r31) {
        Intrinsics.checkNotNullParameter(r20, "entityList");
        Intrinsics.checkNotNullParameter(r22, "conversation");
        Intrinsics.checkNotNullParameter(r23, "botId");
        Intrinsics.checkNotNullParameter(r24, "fromScene");
        FLogger r13 = FLogger.a;
        r13.i("DirectSendFileHelper", "========== Direct send " + r20.size() + " files from " + r24 + " ==========");
        if (r28 != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        final boolean r1 = z2.a.getBasicExperienceCrashOptConfig().a();
        if (r28 == null) goto L13;
        t1a.b r0 = r28.getVContext();
        if (r0 == null) goto L13;
        ChatPageContext r10 = (ChatPageContext) r0.a(ChatPageContext.class);
    L14:
        final boolean r4 = r16;
        final ChatPageContext r210 = r10;
        final ?? r9 = new c(r1, r20, r21, r4, r22, r23, r24, r25, r26, r27, r28, r29, r30, r210, r31);
        if (r16 == false) goto L22;
        LinkedHashMap r2 = new LinkedHashMap();
        if (r28 == null) goto L21;
        Map r3 = r28.getMsgExtMap();
        if (r3 == null) goto L21;
        r2.putAll(r3);
    L21:
        Unit r5 = Unit.INSTANCE;
        zh8.a.a.getSender().l(r22.a, new NestedFileContent(r20, null, false, r2, 6, null), r210, new d(r9));
        return;
    L22:
        int r6 = wf9.b.a;
        String r7 = com.flow.kmp.common.util.i.a();
        r13.i("DirectSendFileHelper", "Skip prepare nested file message, local message id = " + r7);
        r9.invoke(r7, null);
        return;
    L13:
        r10 = null;
        goto L14
    L5:
        if (r28.getNeedPrepareNestedFileMsg() != true) goto L7;
        r16 = true;
        goto L8
    }
}
