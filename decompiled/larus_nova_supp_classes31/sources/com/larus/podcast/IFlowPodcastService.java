package com.larus.podcast;

import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.AnswerAction;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import vr9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/larus/podcast/IFlowPodcastService;", "", "createMenuItem", "Lcom/larus/platform/api/creation/IBaseMenuItem;", "action", "Lcom/larus/im/bean/bot/AnswerAction;", "generatePodcast", "", "podcastGenerateContext", "Lcom/larus/podcast/menu/PodcastGenerateContext;", "onSuccess", "Lkotlin/Function0;", "onFail", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IFlowPodcastService {
    l0 a(AnswerAction r1);

    void b(a r1, Function0<Unit> r2, Function0<Unit> r3);
}
