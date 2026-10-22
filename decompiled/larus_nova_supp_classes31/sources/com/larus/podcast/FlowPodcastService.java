package com.larus.podcast;

import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.podcast.handler.PodcastGenerationHandler;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import vr9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/podcast/FlowPodcastService;", "Lcom/larus/podcast/IFlowPodcastService;", "<init>", "()V", "createMenuItem", "Lcom/larus/platform/api/creation/IBaseMenuItem;", "action", "Lcom/larus/im/bean/bot/AnswerAction;", "generatePodcast", "", "podcastGenerateContext", "Lcom/larus/podcast/menu/PodcastGenerateContext;", "onSuccess", "Lkotlin/Function0;", "onFail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowPodcastService implements IFlowPodcastService {
    public FlowPodcastService() {
    }

    @Override // com.larus.podcast.IFlowPodcastService
    public final l0 a(AnswerAction r44) {
        if (r44 == null) goto L5;
        String r0 = r44.getName();
        if (r0 == null) goto L5;
    L6:
        String r4 = r0;
        if (r4.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        int r3 = 2131899667;
    L14:
        return new l0(2131899667, r3, r4, null, null, null, null, null, null, false, false, null, Integer.valueOf(c.b(2130971825, null, 2131241961)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4104, 127);
    L12:
        r3 = 0;
        goto L14
    L9:
        r1 = false;
    L5:
        r0 = "";
        goto L6
    }

    @Override // com.larus.podcast.IFlowPodcastService
    public final void b(a r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "podcastGenerateContext");
        PodcastGenerationHandler.a(r2, r3, r4);
    }
}
