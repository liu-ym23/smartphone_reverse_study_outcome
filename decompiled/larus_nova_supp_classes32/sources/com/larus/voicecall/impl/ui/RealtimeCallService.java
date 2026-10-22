package com.larus.voicecall.impl.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.audio.IRealtimeCallService;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0001\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u0010(J:\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010.H\u0016R@\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006/"}, d2 = {"Lcom/larus/voicecall/impl/ui/RealtimeCallService;", "Lcom/larus/bmhome/audio/IRealtimeCallService;", "<init>", "()V", "value", "Lkotlin/Pair;", NameKeys.UnloadStrategy_No_Strategy, "realtimeCallCheckManagerWaitingForLoginResult", "getRealtimeCallCheckManagerWaitingForLoginResult", "()Lkotlin/Pair;", "setRealtimeCallCheckManagerWaitingForLoginResult", "(Lkotlin/Pair;)V", "startCall", NameKeys.UnloadStrategy_No_Strategy, "sourceFragment", "Landroidx/fragment/app/Fragment;", "conversationId", NameKeys.UnloadStrategy_No_Strategy, "convLastSectionId", "convLastMessageIndex", NameKeys.UnloadStrategy_No_Strategy, "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "chatType", "enterFrom", "onJumpAction", "Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "enterMethod", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "extraOpenFlags", NameKeys.UnloadStrategy_No_Strategy, "extraBundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Landroid/content/Context;Ljava/lang/Integer;Landroid/os/Bundle;)V", "reportRaiseCallStatusForSwipe", "botId", "failReason", "success", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallService implements IRealtimeCallService {
    public RealtimeCallService() {
    }

    public final Pair<Boolean, Boolean> c() {
        Pair<Boolean, Boolean> r0 = com.larus.voicecall.impl.l.i;
        return com.larus.voicecall.impl.l.i;
    }

    public final void b(Pair<Boolean, Boolean> r1) {
        com.larus.voicecall.impl.l.i = r1;
    }

    public final void a(Fragment r41, String r42, String r43, Long r44, BotModel r45, RecommendFrom r46, String r47, z2a.e r48, SearchMobParam r49, String r50, by7.e r51, Context r52, Integer r53, Bundle r54) {
        Intrinsics.checkNotNullParameter(LynxUIWebView.DEFAULT, "chatType");
        Intrinsics.checkNotNullParameter(r47, "enterFrom");
        Intrinsics.checkNotNullParameter(r50, "enterMethod");
        RealtimeCallHelperKt.i(new b3a.c(r41, r42, r43, r44, r45, r46, LynxUIWebView.DEFAULT, r47, r50, r48, false, r49, null, r51, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r52, r53, r54, null, null, null, 2147472384, 124), false);
    }
}
