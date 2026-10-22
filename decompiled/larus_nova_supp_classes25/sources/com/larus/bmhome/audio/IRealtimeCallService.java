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
import z2a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J©\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H&¢\u0006\u0002\u0010%J:\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010+H&R&\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006,"}, d2 = {"Lcom/larus/bmhome/audio/IRealtimeCallService;", "", "realtimeCallCheckManagerWaitingForLoginResult", "Lkotlin/Pair;", "", "getRealtimeCallCheckManagerWaitingForLoginResult", "()Lkotlin/Pair;", "setRealtimeCallCheckManagerWaitingForLoginResult", "(Lkotlin/Pair;)V", "startCall", "", "sourceFragment", "Landroidx/fragment/app/Fragment;", "conversationId", "", "convLastSectionId", "convLastMessageIndex", "", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "chatType", "enterFrom", "onJumpAction", "Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "enterMethod", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "extraOpenFlags", "", "extraBundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Lcom/larus/voicecall/api/OnRealtimeCallJumpAction;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Landroid/content/Context;Ljava/lang/Integer;Landroid/os/Bundle;)V", "reportRaiseCallStatusForSwipe", "botId", "failReason", "success", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IRealtimeCallService {

    public static final class a {
        public static /* synthetic */ void a(RealtimeCallService r15, Fragment r16, String r17, String r18, Long r19, BotModel r20, RecommendFrom r21, String r22, e r23, String r24, by7.e r25, Context r26, Integer r27, Bundle r28, int r29) {
            if ((r29 & 1024) == 0) goto L5;
            String r10 = "";
        L7:
            if ((r29 & 2048) == 0) goto L9;
            by7.e r11 = null;
        L11:
            if ((r29 & 4096) == 0) goto L13;
            Context r12 = null;
        L15:
            if ((r29 & 8192) == 0) goto L17;
            Integer r13 = null;
        L19:
            if ((r29 & 16384) == 0) goto L21;
            Bundle r14 = null;
        L22:
            r15.a(r16, r17, r18, r19, r20, r21, r22, r23, null, r10, r11, r12, r13, r14);
            return;
        L21:
            r14 = r28;
            goto L22
        L17:
            r13 = r27;
            goto L19
        L13:
            r12 = r26;
            goto L15
        L9:
            r11 = r25;
            goto L11
        L5:
            r10 = r24;
            goto L7
        }
    }

    void a(Fragment r1, String r2, String r3, Long r4, BotModel r5, RecommendFrom r6, String r7, e r8, SearchMobParam r9, String r10, by7.e r11, Context r12, Integer r13, Bundle r14);

    void b(Pair<Boolean, Boolean> r1);

    Pair<Boolean, Boolean> c();
}
