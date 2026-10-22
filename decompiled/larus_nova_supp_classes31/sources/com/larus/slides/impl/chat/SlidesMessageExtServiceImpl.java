package com.larus.slides.impl.chat;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.office.base.service.c;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ic8.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import va8.k0;
import va8.r;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/slides/impl/chat/SlidesMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public SlidesMessageExtServiceImpl() {
    }

    public final String service() {
        return "";
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    public final void a(Map<String, String> r9, e r10, IMessageExtService.a r11) {
        Intrinsics.checkNotNullParameter(r9, "map");
        Fragment r12 = com.larus.slides.impl.chat.a.a();
        if (r12 == null) goto L9;
        b r13 = s1a.a.g(r12);
        if (r13 == null) goto L9;
        r r14 = r13.getAbility(r.class);
        if (r14 == null) goto L9;
        String r15 = r14.WE();
    L11:
        if (Intrinsics.areEqual(r15, "aippt_new_detail") == true) goto L14;
        FLogger.a.i(" SlidesMsgExtServiceImpl", "It is not slides scene, just return, scene=" + r15);
        return;
    L14:
        Fragment r16 = com.larus.slides.impl.chat.a.a();
        if (r16 == null) goto L21;
        b r17 = s1a.a.g(r16);
        if (r17 == null) goto L21;
        k0 r18 = r17.getAbility(k0.class);
        if (r18 == null) goto L21;
        r18.D7(r9, null);
    L21:
        ISlidesSdkProxyService r19 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r19 == null) goto L26;
        c r20 = r19.b();
        if (r20 == null) goto L26;
        r20.onLoadingStart();
    L26:
        Fragment r21 = com.larus.slides.impl.chat.a.a();
        if (r21 == null) goto L34;
        b r22 = s1a.a.g(r21);
        if (r22 == null) goto L35;
        vw9.a r23 = r22.getAbility(vw9.a.class);
        if (r23 == null) goto L36;
        r23.s(new t(false, null, null, null, null, 0, 31));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L9:
        r15 = null;
        goto L11
    }
}
