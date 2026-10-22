package com.larus.bmhome.audio;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import z2a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u009e\u0001\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0001¢\u0006\u0002\u0010&R&\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/larus/bmhome/audio/RealtimeCallService;", "Lcom/larus/bmhome/audio/IRealtimeCallService;", "<init>", "()V", "reportRaiseCallStatusForSwipe", "", "botId", "", "conversationId", "failReason", "success", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "startCall", "sourceFragment", "Landroidx/fragment/app/Fragment;", "convLastSectionId", "convLastMessageIndex", "", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "chatType", "enterFrom", "onJumpAction", "Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "enterMethod", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "extraOpenFlags", "", "extraBundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Landroid/content/Context;Ljava/lang/Integer;Landroid/os/Bundle;)V", "realtimeCallCheckManagerWaitingForLoginResult", "Lkotlin/Pair;", "", "getRealtimeCallCheckManagerWaitingForLoginResult", "()Lkotlin/Pair;", "setRealtimeCallCheckManagerWaitingForLoginResult", "(Lkotlin/Pair;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RealtimeCallService implements IRealtimeCallService {
    public static final RealtimeCallService b = null;
    public final /* synthetic */ IRealtimeCallService a;

    static {
        b = new RealtimeCallService();
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final void a(Fragment r17, String r18, String r19, Long r20, BotModel r21, RecommendFrom r22, String r23, e r24, SearchMobParam r25, String r26, by7.e r27, Context r28, Integer r29, Bundle r30) {
        Intrinsics.checkNotNullParameter("default", "chatType");
        Intrinsics.checkNotNullParameter(r23, "enterFrom");
        Intrinsics.checkNotNullParameter(r26, "enterMethod");
        this.a.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final void b(Pair<Boolean, Boolean> r2) {
        this.a.b(r2);
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final Pair<Boolean, Boolean> c() {
        return this.a.c();
    }

    private RealtimeCallService() {
        IRealtimeCallService r0 = (IRealtimeCallService) ServiceManager.get().getService(IRealtimeCallService.class);
        if (r0 != null) goto L5;
        r0 = new RealtimeCallServiceNoop();
    L5:
        this.a = r0;
    }
}
