package com.bytedance.android.live.broadcast.api.gamepromote;

import android.os.Bundle;
import com.bytedance.android.live.broadcast.api.model.n0;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 s2\u00020\u0001:\u0001tB\u0007¢\u0006\u0004\bq\u0010rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\rR!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\rR!\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\rR!\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR!\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\rR!\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR!\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR!\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\rR\"\u0010E\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010F\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR!\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\rR!\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\rR!\u0010W\u001a\b\u0012\u0004\u0012\u00020T0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\rR!\u0010[\u001a\b\u0012\u0004\u0012\u00020X0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\rR\"\u0010\\\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0011\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R\"\u0010_\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0011\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u0015R\"\u0010b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0011\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015R\"\u0010e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u0011\u001a\u0004\bf\u0010\u0013\"\u0004\bg\u0010\u0015R\"\u0010h\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010i\u001a\u0004\bo\u0010k\"\u0004\bp\u0010m¨\u0006u"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/gamepromote/GamePromoteDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "isCardShowing", "hasDownloadingGame", "", "gameId", "isGameDownloading", "couldReportCardFullShow", "Lcom/bytedance/live/datacontext/m;", "introduceCardVisible$delegate", "Lcom/bytedance/live/datacontext/p;", "getIntroduceCardVisible", "()Lcom/bytedance/live/datacontext/m;", "introduceCardVisible", "", "lastManualFinishTime", "J", "getLastManualFinishTime", "()J", "setLastManualFinishTime", "(J)V", "lastAutoFinishTime", "getLastAutoFinishTime", "setLastAutoFinishTime", "", "autoShowTimes", "I", "getAutoShowTimes", "()I", "setAutoShowTimes", "(I)V", "cardShowWhenEnter$delegate", "getCardShowWhenEnter", "cardShowWhenEnter", "gamePromoteIconShown$delegate", "getGamePromoteIconShown", "gamePromoteIconShown", "autoIntroGameId$delegate", "getAutoIntroGameId", "autoIntroGameId", "autoIntroGameName$delegate", "getAutoIntroGameName", "autoIntroGameName", "needCardPadLinkAnim$delegate", "getNeedCardPadLinkAnim", "needCardPadLinkAnim", "gameCardAnimState$delegate", "getGameCardAnimState", "gameCardAnimState", "gamePadAnimState$delegate", "getGamePadAnimState", "gamePadAnimState", "gamePadEnterAnimShow$delegate", "getGamePadEnterAnimShow", "gamePadEnterAnimShow", "gameCardPadLinkAnimShow$delegate", "getGameCardPadLinkAnimShow", "gameCardPadLinkAnimShow", "updateIntroduceCardItem$delegate", "getUpdateIntroduceCardItem", "updateIntroduceCardItem", "cancelLinkAnim$delegate", "getCancelLinkAnim", "cancelLinkAnim", "Lcom/bytedance/android/live/broadcast/api/model/n0;", "hasIntroduceCard$delegate", "getHasIntroduceCard", "hasIntroduceCard", "currentGameId", "Ljava/lang/String;", "getCurrentGameId", "()Ljava/lang/String;", "setCurrentGameId", "(Ljava/lang/String;)V", "miniGameOpenSchema", "getMiniGameOpenSchema", "setMiniGameOpenSchema", "gameDetailDismissed$delegate", "getGameDetailDismissed", "gameDetailDismissed", "closeCardDirectly$delegate", "getCloseCardDirectly", "closeCardDirectly", "Landroid/os/Bundle;", "externalEnterRoomData$delegate", "getExternalEnterRoomData", "externalEnterRoomData", "Lcom/bytedance/android/live/broadcast/api/gamepromote/a;", "installIntroCard$delegate", "getInstallIntroCard", "installIntroCard", "enterCardRequestStartTime", "getEnterCardRequestStartTime", "setEnterCardRequestStartTime", "enterCardReceiveResponseTime", "getEnterCardReceiveResponseTime", "setEnterCardReceiveResponseTime", "enterCardShowTime", "getEnterCardShowTime", "setEnterCardShowTime", "cardIconLoadingDuration", "getCardIconLoadingDuration", "setCardIconLoadingDuration", "cardIconLoadStatus", "Z", "getCardIconLoadStatus", "()Z", "setCardIconLoadStatus", "(Z)V", "cardFirstReport", "getCardFirstReport", "setCardFirstReport", "<init>", "()V", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String ENTER = "enter";
    public static final String GAME_TYPE_MINI = "2";
    public static final String GAME_TYPE_MOBILE = "1";
    public static final String LIVE = "live";
    private final p autoIntroGameId$delegate;
    private final p autoIntroGameName$delegate;
    private int autoShowTimes;
    private final p cancelLinkAnim$delegate;
    private boolean cardFirstReport;
    private boolean cardIconLoadStatus;
    private long cardIconLoadingDuration;
    private final p cardShowWhenEnter$delegate;
    private final p closeCardDirectly$delegate;
    private String currentGameId;
    private long enterCardReceiveResponseTime;
    private long enterCardRequestStartTime;
    private long enterCardShowTime;
    private final p externalEnterRoomData$delegate;
    private final p gameCardAnimState$delegate;
    private final p gameCardPadLinkAnimShow$delegate;
    private final p gameDetailDismissed$delegate;
    private final p gamePadAnimState$delegate;
    private final p gamePadEnterAnimShow$delegate;
    private final p gamePromoteIconShown$delegate;
    private final p hasIntroduceCard$delegate;
    private final p installIntroCard$delegate;
    private final p introduceCardVisible$delegate;
    private long lastAutoFinishTime;
    private long lastManualFinishTime;
    private String miniGameOpenSchema;
    private final p needCardPadLinkAnim$delegate;
    private final p updateIntroduceCardItem$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "introduceCardVisible", "getIntroduceCardVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "cardShowWhenEnter", "getCardShowWhenEnter()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gamePromoteIconShown", "getGamePromoteIconShown()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "autoIntroGameId", "getAutoIntroGameId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "autoIntroGameName", "getAutoIntroGameName()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "needCardPadLinkAnim", "getNeedCardPadLinkAnim()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gameCardAnimState", "getGameCardAnimState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gamePadAnimState", "getGamePadAnimState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gamePadEnterAnimShow", "getGamePadEnterAnimShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gameCardPadLinkAnimShow", "getGameCardPadLinkAnimShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "updateIntroduceCardItem", "getUpdateIntroduceCardItem()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "cancelLinkAnim", "getCancelLinkAnim()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "hasIntroduceCard", "getHasIntroduceCard()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "gameDetailDismissed", "getGameDetailDismissed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "closeCardDirectly", "getCloseCardDirectly()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "externalEnterRoomData", "getExternalEnterRoomData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteDataContext.class, "installIntroCard", "getInstallIntroCard()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<String> getAutoIntroGameId() {
        return (m) this.autoIntroGameId$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<String> getAutoIntroGameName() {
        return (m) this.autoIntroGameName$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getCancelLinkAnim() {
        return (m) this.cancelLinkAnim$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<Boolean> getCardShowWhenEnter() {
        return (m) this.cardShowWhenEnter$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getCloseCardDirectly() {
        return (m) this.closeCardDirectly$delegate.a(this, $$delegatedProperties[14]);
    }

    public final m<Bundle> getExternalEnterRoomData() {
        return (m) this.externalEnterRoomData$delegate.a(this, $$delegatedProperties[15]);
    }

    public final m<Integer> getGameCardAnimState() {
        return (m) this.gameCardAnimState$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getGameCardPadLinkAnimShow() {
        return (m) this.gameCardPadLinkAnimShow$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> getGameDetailDismissed() {
        return (m) this.gameDetailDismissed$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Integer> getGamePadAnimState() {
        return (m) this.gamePadAnimState$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getGamePadEnterAnimShow() {
        return (m) this.gamePadEnterAnimShow$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<Boolean> getGamePromoteIconShown() {
        return (m) this.gamePromoteIconShown$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<n0> getHasIntroduceCard() {
        return (m) this.hasIntroduceCard$delegate.a(this, $$delegatedProperties[12]);
    }

    public final m<com.bytedance.android.live.broadcast.api.gamepromote.a> getInstallIntroCard() {
        return (m) this.installIntroCard$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<Boolean> getIntroduceCardVisible() {
        return (m) this.introduceCardVisible$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getNeedCardPadLinkAnim() {
        return (m) this.needCardPadLinkAnim$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> getUpdateIntroduceCardItem() {
        return (m) this.updateIntroduceCardItem$delegate.a(this, $$delegatedProperties[10]);
    }

    public final boolean couldReportCardFullShow() {
        if (this.enterCardRequestStartTime >= 0) goto L5;
    L11:
        return false;
    L5:
        if (this.enterCardReceiveResponseTime < 0) goto L11;
        if (this.enterCardShowTime < 0) goto L11;
        if (this.cardIconLoadingDuration < 0) goto L11;
        return true;
    }

    public final boolean hasDownloadingGame() {
        IHostGameCP r0 = k.f(IHostGameCP.class);
        if (r0 == null) goto L7;
        Set r1 = r0.getDownloadingGames();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    public GamePromoteDataContext() {
        Boolean r0 = Boolean.FALSE;
        this.introduceCardVisible$delegate = q.d(this, r0);
        this.cardShowWhenEnter$delegate = q.d(this, r0);
        this.gamePromoteIconShown$delegate = q.d(this, r0);
        this.autoIntroGameId$delegate = q.d(this, "");
        this.autoIntroGameName$delegate = q.d(this, "");
        this.needCardPadLinkAnim$delegate = q.d(this, r0);
        this.gameCardAnimState$delegate = q.d(this, 0);
        this.gamePadAnimState$delegate = q.d(this, 0);
        this.gamePadEnterAnimShow$delegate = q.d(this, r0);
        this.gameCardPadLinkAnimShow$delegate = q.d(this, r0);
        this.updateIntroduceCardItem$delegate = q.d(this, Boolean.TRUE);
        this.cancelLinkAnim$delegate = q.d(this, r0);
        this.hasIntroduceCard$delegate = q.d(this, new n0());
        this.currentGameId = "";
        this.miniGameOpenSchema = "";
        this.gameDetailDismissed$delegate = q.d(this, r0);
        this.closeCardDirectly$delegate = q.d(this, r0);
        this.externalEnterRoomData$delegate = q.d(this, new Bundle());
        this.installIntroCard$delegate = q.d(this, new com.bytedance.android.live.broadcast.api.gamepromote.a(0));
        this.enterCardRequestStartTime = -1;
        this.enterCardReceiveResponseTime = -1;
        this.enterCardShowTime = -1;
        this.cardIconLoadingDuration = -1;
        this.cardFirstReport = true;
    }

    public final boolean isCardShowing() {
        return ((Boolean) getIntroduceCardVisible().getValue()).booleanValue();
    }

    public final int getAutoShowTimes() {
        return this.autoShowTimes;
    }

    public final boolean getCardFirstReport() {
        return this.cardFirstReport;
    }

    public final boolean getCardIconLoadStatus() {
        return this.cardIconLoadStatus;
    }

    public final long getCardIconLoadingDuration() {
        return this.cardIconLoadingDuration;
    }

    public final String getCurrentGameId() {
        return this.currentGameId;
    }

    public final long getEnterCardReceiveResponseTime() {
        return this.enterCardReceiveResponseTime;
    }

    public final long getEnterCardRequestStartTime() {
        return this.enterCardRequestStartTime;
    }

    public final long getEnterCardShowTime() {
        return this.enterCardShowTime;
    }

    public final long getLastAutoFinishTime() {
        return this.lastAutoFinishTime;
    }

    public final long getLastManualFinishTime() {
        return this.lastManualFinishTime;
    }

    public final String getMiniGameOpenSchema() {
        return this.miniGameOpenSchema;
    }

    public final boolean isGameDownloading(String r2) {
        Intrinsics.checkNotNullParameter(r2, "gameId");
        IHostGameCP r0 = k.f(IHostGameCP.class);
        if (r0 == null) goto L7;
        Set r1 = r0.getDownloadingGames();
        if (r1 == null) goto L7;
        return r1.contains(r2);
    L7:
        return false;
    }

    public final void setAutoShowTimes(int r1) {
        this.autoShowTimes = r1;
    }

    public final void setCardFirstReport(boolean r1) {
        this.cardFirstReport = r1;
    }

    public final void setCardIconLoadStatus(boolean r1) {
        this.cardIconLoadStatus = r1;
    }

    public final void setCardIconLoadingDuration(long r1) {
        this.cardIconLoadingDuration = r1;
    }

    public final void setCurrentGameId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentGameId = r2;
    }

    public final void setEnterCardReceiveResponseTime(long r1) {
        this.enterCardReceiveResponseTime = r1;
    }

    public final void setEnterCardRequestStartTime(long r1) {
        this.enterCardRequestStartTime = r1;
    }

    public final void setEnterCardShowTime(long r1) {
        this.enterCardShowTime = r1;
    }

    public final void setLastAutoFinishTime(long r1) {
        this.lastAutoFinishTime = r1;
    }

    public final void setLastManualFinishTime(long r1) {
        this.lastManualFinishTime = r1;
    }

    public final void setMiniGameOpenSchema(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.miniGameOpenSchema = r2;
    }
}
