package com.larus.sheet.impl.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.office.base.service.c;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ic8.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import va8.n0;
import va8.r;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/sheet/impl/chat/SheetMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public SheetMessageExtServiceImpl() {
    }

    public final String service() {
        return "";
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    public final void a(Map<String, String> r9, e r10, IMessageExtService.a r11) {
        Intrinsics.checkNotNullParameter(r9, "map");
        Fragment r12 = com.larus.sheet.impl.chat.a.a();
        Map r13 = null;
        if (r12 == null) goto L9;
        b r14 = s1a.a.g(r12);
        if (r14 == null) goto L9;
        r r15 = r14.getAbility(r.class);
        if (r15 == null) goto L9;
        String r16 = r15.WE();
    L11:
        if (Intrinsics.areEqual(r16, "aisheet_detail") == true) goto L14;
        FLogger.a.i("SheetMsgExtServiceImpl", "It is not sheet scene, just return, scene=" + r16);
        return;
    L14:
        Fragment r17 = com.larus.sheet.impl.chat.a.a();
        if (r17 == null) goto L21;
        b r18 = s1a.a.g(r17);
        if (r18 == null) goto L21;
        n0 r19 = r18.getAbility(n0.class);
        if (r19 == null) goto L21;
        r19.D7(r9, null);
    L21:
        ISheetSdkProxyService r20 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r20 == null) goto L26;
        c r21 = r20.b();
        if (r21 == null) goto L26;
        r21.onLoadingStart();
    L26:
        Fragment r22 = com.larus.sheet.impl.chat.a.a();
        String r110 = "";
        if (r22 == null) goto L34;
        Bundle r23 = r22.getArguments();
        if (r23 == null) goto L34;
        String r24 = r23.getString("artifact_meta_id", "");
        if (r24 == null) goto L34;
        r110 = r24;
    L34:
        Fragment r25 = com.larus.sheet.impl.chat.a.a();
        if (r25 == null) goto L48;
        b r26 = s1a.a.g(r25);
        if (r26 == null) goto L49;
        mw9.a r27 = r26.getAbility(mw9.a.class);
        if (r27 != null) goto L41;
        return;
    L41:
        if (r110.length() <= 0) goto L43;
        boolean r0 = true;
    L44:
        if (r0 == false) goto L46;
        r13 = MapsKt.mapOf(TuplesKt.to("cot_ref_artifacts", r110));
    L46:
        r27.s(new t(false, null, null, null, r13, 0, 15));
        return;
    L43:
        r0 = false;
        goto L44
    L49:
        return;
    L48:
        return;
    L9:
        r16 = null;
        goto L11
    }
}
