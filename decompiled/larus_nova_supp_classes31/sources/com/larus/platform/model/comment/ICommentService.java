package com.larus.platform.model.comment;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.actionbar.segment.BotCommentRemoteHttpApi;
import com.story.ai.biz.comment.CommentComponent;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import qq9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/comment/ICommentService;", "", "showBotCommentPanel", "", "fragment", "Landroidx/fragment/app/Fragment;", "params", "Lcom/larus/platform/model/comment/api/ICommentInitData;", "dataMediator", "Lcom/larus/platform/model/comment/api/IDataMediator;", "tracker", "Lcom/larus/platform/model/comment/api/ICommentTracker;", "commentCallback", "Lcom/larus/platform/model/comment/api/ICommentCallback;", "releaseBotCommentPanel", "preloadBotCommentData", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "commentHttpApi", "Lcom/larus/platform/model/comment/api/CommentHttpApi;", "botId", "", "(Lcom/larus/platform/model/comment/api/CommentHttpApi;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessCommentComponentClazz", "Lcom/larus/ui/arch/component/external/delegate/BaseSlotWidget;", "Lcom/larus/ui/arch/component/external/SlotComponent;", "initialize", "initParams", "Lcom/larus/platform/model/comment/api/CommentComponentInitParams;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICommentService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<ICommentService> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(new b());
        }
    }

    static {
        a = a.a;
    }

    void a(Fragment r1);

    Object b(BotCommentRemoteHttpApi r1, String r2, Continuation r3);

    void c(Fragment r1, rq9.a r2);

    CommentComponent d();
}
