package com.bytedance.android.live.broadcastgame.api;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameLaunchSource;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.InteractItemGroupProperty;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 c2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\ba\u0010bJ\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u000fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\tR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\tR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u000fR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\tR'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010\u000fR!\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010\u000fR!\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0007\u001a\u0004\b+\u0010\u000fR!\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0007\u001a\u0004\b.\u0010\u000fR!\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\u000fR!\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0007\u001a\u0004\b3\u0010\tR!\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0007\u001a\u0004\b7\u00108R!\u0010<\u001a\b\u0012\u0004\u0012\u00020%058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0007\u001a\u0004\b;\u00108R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0007\u001a\u0004\b>\u0010\u000fR!\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0007\u001a\u0004\bA\u0010\u000fR!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001a058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0007\u001a\u0004\bD\u00108R!\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0007\u001a\u0004\bG\u0010\u000fR!\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0007\u001a\u0004\bI\u0010\u000fR!\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0007\u001a\u0004\bM\u0010\tR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0007\u001a\u0004\bP\u00108R!\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0007\u001a\u0004\bS\u0010\u000fR!\u0010W\u001a\b\u0012\u0004\u0012\u00020\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0007\u001a\u0004\bV\u00108R!\u0010Z\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0007\u001a\u0004\bY\u0010\u000fR!\u0010]\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0007\u001a\u0004\b\\\u0010\tR!\u0010`\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0007\u001a\u0004\b_\u0010\t¨\u0006e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/AnchorGameContext;", "Lcom/bytedance/android/live/broadcastgame/api/InteractGameContext;", "", "clickIconByNormal", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "currentGame$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentGame", "()Lcom/bytedance/live/datacontext/n;", "currentGame", "Lcom/bytedance/live/datacontext/m;", "", "clickIconSourceType$delegate", "getClickIconSourceType", "()Lcom/bytedance/live/datacontext/m;", "clickIconSourceType", "clickIconGroupType$delegate", "getClickIconGroupType", "clickIconGroupType", "guideActivityName$delegate", "getGuideActivityName", "guideActivityName", "tempStoreGuideLaunchInfo$delegate", "getTempStoreGuideLaunchInfo", "tempStoreGuideLaunchInfo", "", "isGuideBubbleShowed$delegate", "isGuideBubbleShowed", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractItemGroupProperty;", "gameGroupPropertyMap$delegate", "getGameGroupPropertyMap", "gameGroupPropertyMap", "", "recentUsedInteractItemIdList$delegate", "getRecentUsedInteractItemIdList", "recentUsedInteractItemIdList", "", "recentUsedGameIdListMaxSize$delegate", "getRecentUsedGameIdListMaxSize", "recentUsedGameIdListMaxSize", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/GameLaunchSource;", "openGameLaunchSource$delegate", "getOpenGameLaunchSource", "openGameLaunchSource", "openGameStartId$delegate", "getOpenGameStartId", "openGameStartId", "isRequsetingAppStart$delegate", "isRequsetingAppStart", "startGameSource$delegate", "getStartGameSource", "startGameSource", "Lcom/bytedance/live/datacontext/k;", "openGameTestFloatBall$delegate", "getOpenGameTestFloatBall", "()Lcom/bytedance/live/datacontext/k;", "openGameTestFloatBall", "initGameTestFloatBall$delegate", "getInitGameTestFloatBall", "initGameTestFloatBall", "openGamePerfPanel$delegate", "getOpenGamePerfPanel", "openGamePerfPanel", "openGamePerfUploadState$delegate", "getOpenGamePerfUploadState", "openGamePerfUploadState", "openGamePerfUploadEvent$delegate", "getOpenGamePerfUploadEvent", "openGamePerfUploadEvent", "isLaunchFromPerfTest$delegate", "isLaunchFromPerfTest", "openGameIntroCardAutoShow$delegate", "getOpenGameIntroCardAutoShow", "openGameIntroCardAutoShow", "Landroid/view/ViewGroup;", "interactPlayContainer$delegate", "getInteractPlayContainer", "interactPlayContainer", "openGameMoreDialog$delegate", "getOpenGameMoreDialog", "openGameMoreDialog", "openCapture$delegate", "getOpenCapture", "openCapture", "showKeyBoard$delegate", "getShowKeyBoard", "showKeyBoard", "searchWord$delegate", "getSearchWord", "searchWord", "lynxDetailExtra$delegate", "getLynxDetailExtra", "lynxDetailExtra", "clickIconSource$delegate", "getClickIconSource", "clickIconSource", "<init>", "()V", "Companion", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGameContext extends InteractGameContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p clickIconGroupType$delegate;
    private final p clickIconSource$delegate;
    private final p clickIconSourceType$delegate;
    private final p currentGame$delegate;
    private final p gameGroupPropertyMap$delegate;
    private final p guideActivityName$delegate;
    private final p initGameTestFloatBall$delegate;
    private final p interactPlayContainer$delegate;
    private final p isGuideBubbleShowed$delegate;
    private final p isLaunchFromPerfTest$delegate;
    private final p isRequsetingAppStart$delegate;
    private final p lynxDetailExtra$delegate;
    private final p openCapture$delegate;
    private final p openGameIntroCardAutoShow$delegate;
    private final p openGameLaunchSource$delegate;
    private final p openGameMoreDialog$delegate;
    private final p openGamePerfPanel$delegate;
    private final p openGamePerfUploadEvent$delegate;
    private final p openGamePerfUploadState$delegate;
    private final p openGameStartId$delegate;
    private final p openGameTestFloatBall$delegate;
    private final p recentUsedGameIdListMaxSize$delegate;
    private final p recentUsedInteractItemIdList$delegate;
    private final p searchWord$delegate;
    private final p showKeyBoard$delegate;
    private final p startGameSource$delegate;
    private final p tempStoreGuideLaunchInfo$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static AnchorGameContext a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(InteractGameContext.CONTEXT_KEY);
            if ((r0 instanceof AnchorGameContext) == true) goto L6;
            r0 = null;
        L6:
            return (AnchorGameContext) r0;
        }

        @Deprecated(message = "弹幕玩法解耦过多Context", replaceWith = @ReplaceWith(expression = "isPlayingGame()", imports = {}))
        @JvmStatic
        public static boolean b(InteractID r1) {
            Intrinsics.checkNotNullParameter(r1, "interactId");
            AnchorGameContext r0 = a();
            if (r0 == null) goto L11;
            n<u> r2 = r0.getCurrentGame();
            if (r2 == null) goto L11;
            u r3 = (u) r2.getValue();
            if (r3 == null) goto L11;
            if (r3.interactId != r1.getValue()) goto L11;
            return true;
        L11:
            return false;
        }
    }

    @JvmStatic
    public static final AnchorGameContext getGameContext() {
        Companion.getClass();
        return a.a();
    }

    @Deprecated(message = "弹幕玩法解耦过多Context", replaceWith = @ReplaceWith(expression = "isPlayingGame()", imports = {}))
    @JvmStatic
    public static final boolean isPlayingGame(InteractID r1) {
        Companion.getClass();
        return a.b(r1);
    }

    public final m<String> getClickIconGroupType() {
        return (m) this.clickIconGroupType$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<String> getClickIconSource() {
        return (n) this.clickIconSource$delegate.a(this, $$delegatedProperties[26]);
    }

    public final m<String> getClickIconSourceType() {
        return (m) this.clickIconSourceType$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<u> getCurrentGame() {
        return (n) this.currentGame$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<InteractItemGroupProperty> getGameGroupPropertyMap() {
        return (n) this.gameGroupPropertyMap$delegate.a(this, $$delegatedProperties[6]);
    }

    public final n<String> getGuideActivityName() {
        return (n) this.guideActivityName$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Integer> getInitGameTestFloatBall() {
        return (k) this.initGameTestFloatBall$delegate.a(this, $$delegatedProperties[14]);
    }

    public final n<ViewGroup> getInteractPlayContainer() {
        return (n) this.interactPlayContainer$delegate.a(this, $$delegatedProperties[20]);
    }

    public final n<String> getLynxDetailExtra() {
        return (n) this.lynxDetailExtra$delegate.a(this, $$delegatedProperties[25]);
    }

    public final m<Boolean> getOpenCapture() {
        return (m) this.openCapture$delegate.a(this, $$delegatedProperties[22]);
    }

    public final m<Boolean> getOpenGameIntroCardAutoShow() {
        return (m) this.openGameIntroCardAutoShow$delegate.a(this, $$delegatedProperties[19]);
    }

    public final m<GameLaunchSource> getOpenGameLaunchSource() {
        return (m) this.openGameLaunchSource$delegate.a(this, $$delegatedProperties[9]);
    }

    public final k<Unit> getOpenGameMoreDialog() {
        return (k) this.openGameMoreDialog$delegate.a(this, $$delegatedProperties[21]);
    }

    public final m<Boolean> getOpenGamePerfPanel() {
        return (m) this.openGamePerfPanel$delegate.a(this, $$delegatedProperties[15]);
    }

    public final k<Boolean> getOpenGamePerfUploadEvent() {
        return (k) this.openGamePerfUploadEvent$delegate.a(this, $$delegatedProperties[17]);
    }

    public final m<Boolean> getOpenGamePerfUploadState() {
        return (m) this.openGamePerfUploadState$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<String> getOpenGameStartId() {
        return (m) this.openGameStartId$delegate.a(this, $$delegatedProperties[10]);
    }

    public final k<Boolean> getOpenGameTestFloatBall() {
        return (k) this.openGameTestFloatBall$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Integer> getRecentUsedGameIdListMaxSize() {
        return (m) this.recentUsedGameIdListMaxSize$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<List<String>> getRecentUsedInteractItemIdList() {
        return (m) this.recentUsedInteractItemIdList$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<String> getSearchWord() {
        return (m) this.searchWord$delegate.a(this, $$delegatedProperties[24]);
    }

    public final k<Unit> getShowKeyBoard() {
        return (k) this.showKeyBoard$delegate.a(this, $$delegatedProperties[23]);
    }

    public final n<String> getStartGameSource() {
        return (n) this.startGameSource$delegate.a(this, $$delegatedProperties[12]);
    }

    public final n<String> getTempStoreGuideLaunchInfo() {
        return (n) this.tempStoreGuideLaunchInfo$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> isGuideBubbleShowed() {
        return (m) this.isGuideBubbleShowed$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> isLaunchFromPerfTest() {
        return (m) this.isLaunchFromPerfTest$delegate.a(this, $$delegatedProperties[18]);
    }

    public final m<Boolean> isRequsetingAppStart() {
        return (m) this.isRequsetingAppStart$delegate.a(this, $$delegatedProperties[11]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "currentGame", "getCurrentGame()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "clickIconSourceType", "getClickIconSourceType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "clickIconGroupType", "getClickIconGroupType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "guideActivityName", "getGuideActivityName()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "tempStoreGuideLaunchInfo", "getTempStoreGuideLaunchInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "isGuideBubbleShowed", "isGuideBubbleShowed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "gameGroupPropertyMap", "getGameGroupPropertyMap()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "recentUsedInteractItemIdList", "getRecentUsedInteractItemIdList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "recentUsedGameIdListMaxSize", "getRecentUsedGameIdListMaxSize()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGameLaunchSource", "getOpenGameLaunchSource()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGameStartId", "getOpenGameStartId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "isRequsetingAppStart", "isRequsetingAppStart()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "startGameSource", "getStartGameSource()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGameTestFloatBall", "getOpenGameTestFloatBall()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "initGameTestFloatBall", "getInitGameTestFloatBall()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGamePerfPanel", "getOpenGamePerfPanel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGamePerfUploadState", "getOpenGamePerfUploadState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGamePerfUploadEvent", "getOpenGamePerfUploadEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "isLaunchFromPerfTest", "isLaunchFromPerfTest()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGameIntroCardAutoShow", "getOpenGameIntroCardAutoShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "interactPlayContainer", "getInteractPlayContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openGameMoreDialog", "getOpenGameMoreDialog()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "openCapture", "getOpenCapture()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "showKeyBoard", "getShowKeyBoard()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "searchWord", "getSearchWord()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "lynxDetailExtra", "getLynxDetailExtra()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorGameContext.class, "clickIconSource", "getClickIconSource()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final boolean isPlayingEffectGame() {
        Companion.getClass();
        AnchorGameContext r0 = a.a();
        if (r0 == null) goto L11;
        n<u> r1 = r0.getCurrentGame();
        if (r1 == null) goto L11;
        u r2 = (u) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.interactId != InteractID.EffectGame.getValue()) goto L11;
        return true;
    L11:
        return false;
    }

    @JvmStatic
    public static final boolean isPlayingGame() {
        Companion.getClass();
        AnchorGameContext r0 = a.a();
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isPlayingGame();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public AnchorGameContext() {
        this.currentGame$delegate = q.c(this);
        this.clickIconSourceType$delegate = q.d(this, "normal");
        this.clickIconGroupType$delegate = q.d(this, "all_used");
        this.guideActivityName$delegate = q.c(this);
        this.tempStoreGuideLaunchInfo$delegate = q.c(this);
        Boolean r0 = Boolean.FALSE;
        this.isGuideBubbleShowed$delegate = q.d(this, r0);
        this.gameGroupPropertyMap$delegate = q.c(this);
        this.recentUsedInteractItemIdList$delegate = q.d(this, new ArrayList());
        this.recentUsedGameIdListMaxSize$delegate = q.d(this, 4);
        this.openGameLaunchSource$delegate = q.d(this, GameLaunchSource.Panel);
        this.openGameStartId$delegate = q.d(this, "");
        this.isRequsetingAppStart$delegate = q.d(this, r0);
        this.startGameSource$delegate = q.c(this);
        this.openGameTestFloatBall$delegate = com.bytedance.live.datacontext.e.b(this);
        this.initGameTestFloatBall$delegate = com.bytedance.live.datacontext.e.b(this);
        this.openGamePerfPanel$delegate = q.d(this, r0);
        this.openGamePerfUploadState$delegate = q.d(this, r0);
        this.openGamePerfUploadEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.isLaunchFromPerfTest$delegate = q.d(this, r0);
        this.openGameIntroCardAutoShow$delegate = q.d(this, r0);
        this.interactPlayContainer$delegate = q.c(this);
        this.openGameMoreDialog$delegate = com.bytedance.live.datacontext.e.b(this);
        this.openCapture$delegate = q.d(this, Boolean.TRUE);
        this.showKeyBoard$delegate = com.bytedance.live.datacontext.e.b(this);
        this.searchWord$delegate = q.d(this, "");
        this.lynxDetailExtra$delegate = q.c(this);
        this.clickIconSource$delegate = q.c(this);
    }

    public final void clickIconByNormal() {
        getClickIconSourceType().setValue("normal");
        getGuideActivityName().setValue(null);
    }
}
