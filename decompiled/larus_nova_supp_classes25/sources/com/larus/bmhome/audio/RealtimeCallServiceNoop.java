package com.larus.bmhome.audio;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import z2a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0001\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J:\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010+\u001a\u0004\u0018\u00010\u00102\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006."}, d2 = {"Lcom/larus/bmhome/audio/RealtimeCallServiceNoop;", "Lcom/larus/bmhome/audio/IRealtimeCallService;", "<init>", "()V", "realtimeCallCheckManagerWaitingForLoginResult", "Lkotlin/Pair;", "", "getRealtimeCallCheckManagerWaitingForLoginResult", "()Lkotlin/Pair;", "setRealtimeCallCheckManagerWaitingForLoginResult", "(Lkotlin/Pair;)V", "startCall", "", "sourceFragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "convLastSectionId", "convLastMessageIndex", "", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "chatType", "enterFrom", "onJumpAction", "Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "enterMethod", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "extraOpenFlags", "", "extraBundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Landroid/content/Context;Ljava/lang/Integer;Landroid/os/Bundle;)V", "reportRaiseCallStatusForSwipe", "botId", "failReason", "success", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RealtimeCallServiceNoop implements IRealtimeCallService {
    public Pair<Boolean, Boolean> a;

    public RealtimeCallServiceNoop() {
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final void a(Fragment r1, String r2, String r3, Long r4, BotModel r5, RecommendFrom r6, String r7, e r8, SearchMobParam r9, String r10, by7.e r11, Context r12, Integer r13, Bundle r14) {
        Intrinsics.checkNotNullParameter("default", "chatType");
        Intrinsics.checkNotNullParameter(r7, "enterFrom");
        Intrinsics.checkNotNullParameter(r10, "enterMethod");
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final Pair<Boolean, Boolean> c() {
        return this.a;
    }

    @Override // com.larus.bmhome.audio.IRealtimeCallService
    public final void b(Pair<Boolean, Boolean> r1) {
        this.a = r1;
    }
}
