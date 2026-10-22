package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.ContactPayload;
import com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.search.api.LarkChatServiceProxy;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\r"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpContactSearchActionHandlerServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchActionHandlerService;", "<init>", "()V", "onSearchItemClick", "", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "handleLarkContactClick", "chatId", "", "chatterId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpContactSearchActionHandlerServiceImpl implements SearchActionHandlerService {

    public static final class a {
    }

    static {
    }

    public KmpContactSearchActionHandlerServiceImpl() {
    }

    public final boolean V(FlowSearchData r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        if (Intrinsics.areEqual(r7.a, SlashMentionConfig.MENTION_CONTENT_CONTACT) == true) goto L5;
        return false;
    L5:
        ContactPayload r8 = r7.c;
        if ((r8 instanceof ContactPayload) == false) goto L8;
        ContactPayload r9 = r8;
    L9:
        if (r9 != null) goto L11;
        return false;
    L11:
        String r0 = r9.o;
        if ((!StringsKt.isBlank(r0)) == false) goto L22;
        LarkChatServiceProxy r2 = (LarkChatServiceProxy) ServiceManager.get().getService(LarkChatServiceProxy.class);
        if (r2 != null) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L22;
        return true;
    L16:
        if (r2.a(r0, "") != true) goto L18;
        r1 = true;
    L22:
        if (o0.d(r9.j) == false) goto L32;
        String r3 = r9.j;
        LarkChatServiceProxy r4 = (LarkChatServiceProxy) ServiceManager.get().getService(LarkChatServiceProxy.class);
        if (r4 != null) goto L26;
    L28:
        boolean r5 = false;
    L29:
        if (r5 == false) goto L32;
        FLogger.a.w("ContactSearchAction", "use rawId fallback to open group chat, rawId=" + r9.j);
        return true;
    L26:
        if (r4.a("", r3) != true) goto L28;
        r5 = true;
    L32:
        return false;
    L8:
        r9 = null;
        goto L9
    }
}
