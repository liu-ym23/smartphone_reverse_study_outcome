package d90;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.jj1;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import ju1.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final boolean a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$enableLandscapeDrawerEntrance");
        if (l(r4) == false) goto L25;
        Intrinsics.checkNotNullParameter(r4, "$this$isVSSpecialDrawerSupportLandscape");
        Integer[] r2 = {3, 2};
        Room r5 = q(r4);
        if (r5 == null) goto L15;
        EpisodeExtraInfo r6 = r5.getEpisodeExtra2();
        if (r6 == null) goto L15;
        VSConfigDrawer r7 = r6.getVsConfigDrawer();
        if (r7 == null) goto L15;
        MatchDrawer r8 = r7.drawer;
        if (r8 == null) goto L15;
        Integer r9 = r8.getDisplayMode();
        if (r9 == null) goto L15;
        int r11 = r9.intValue();
    L17:
        if (ArraysKt.contains(r2, Integer.valueOf(r11)) == true) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == false) goto L26;
        return true;
    L26:
        return false;
    L19:
        if (((jj1) oj1.a.getValue()).c() == false) goto L21;
        r12 = true;
    L15:
        r11 = 0;
        goto L17
    L25:
        return false;
    }

    public static final boolean c(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isAnchor");
        return z.e(r1.h, false);
    }

    public static final boolean d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isCommentaryRoom");
        Room r3 = q(r2);
        RoomSpecificSceneTypeInfo r0 = null;
        if (r3 == null) goto L5;
        RoomSpecificSceneTypeInfo r4 = r3.getSceneTypeInfo();
    L7:
        if ((r4 instanceof RoomSpecificSceneTypeInfo) == false) goto L10;
        r0 = r4;
    L10:
        if (r0 != null) goto L12;
    L14:
        return false;
    L12:
        if (r0.isCommentaryRoom() != true) goto L14;
        return true;
    L5:
        r4 = null;
        goto L7
    }

    public static final boolean e(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isHorizontalStream");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 == null) goto L7;
        m r6 = r5.getRoom();
        if (r6 == null) goto L7;
        Room r7 = (Room) r6.getValue();
    L9:
        if (r7 == null) goto L21;
        StreamUrl r1 = r7.getStreamUrl();
        if (r1 != null) goto L13;
    L15:
        StreamUrlExtra r8 = r7.getStreamUrlExtraSafely();
        if (r8.getWidth() <= r8.getHeight()) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        return true;
    L18:
        r9 = false;
        goto L19
    L13:
        if (r1.getStreamOrientation() != 2) goto L15;
        return true;
    L21:
        return false;
    L7:
        r7 = null;
        goto L9
    }

    public static final boolean f(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isLandscape");
        return !i(r1);
    }

    public static final boolean g(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isLandscapeMarginOpt");
        if (f(r4) == false) goto L11;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 == null) goto L11;
        m r6 = r5.isOptLandscapeMargin();
        if (r6 == null) goto L11;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean h(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMediaOrVs");
        if (e.b(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (k(r1) == true) goto L8;
        return false;
    }

    public static final boolean i(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isPortrait");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return true;
    }

    public static final boolean j(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isVSFirstShow");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 == null) goto L13;
        Room r6 = r5.getVsRoom();
        if (r6 == null) goto L13;
        EpisodeExtraInfo r7 = r6.getEpisodeExtra2();
        if (r7 == null) goto L13;
        IBaseEpisodeMod r8 = r7.getMod();
        if (r8 == null) goto L13;
        if (r8.getEpisodeStage() != EpisodeMod.EpisodeStageType.PREMIERE) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean k(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isVSRoom");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 == null) goto L7;
        Room r6 = r5.getVsRoom();
        if (r6 == null) goto L7;
        return r6.isMergeVSRoom();
    L7:
        return false;
    }

    public static final boolean l(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isVSSpecialDrawer");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isVSSpecialDrawer() != true) goto L7;
        return true;
    }

    public static final boolean m(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isVSSpecialDrawerSupportPortrait");
        Integer[] r0 = {3, 1};
        Room r5 = q(r4);
        if (r5 == null) goto L13;
        EpisodeExtraInfo r6 = r5.getEpisodeExtra2();
        if (r6 == null) goto L13;
        VSConfigDrawer r7 = r6.getVsConfigDrawer();
        if (r7 == null) goto L13;
        MatchDrawer r8 = r7.drawer;
        if (r8 == null) goto L13;
        Integer r9 = r8.getDisplayMode();
        if (r9 == null) goto L13;
        int r11 = r9.intValue();
    L15:
        if (ArraysKt.contains(r0, Integer.valueOf(r11)) == true) goto L17;
        return false;
    L17:
        if (((jj1) oj1.a.getValue()).f() == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        r11 = 0;
        goto L15
    }

    public static final boolean n(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isVSVerticalStream");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isVSVerticalStream() != true) goto L7;
        return true;
    }

    public static final LiveMode o(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$liveMode");
        DataCenter r3 = r2.h;
        if (r3 != null) goto L5;
        return null;
    L5:
        return (LiveMode) r3.get("data_live_mode", null);
    }

    public static final int p(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$loadStrategy");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4.h, 0, 2);
        if (r5 == null) goto L14;
        j r6 = r5.getDynamicStrategy();
        if (r6 == null) goto L15;
        IDynamicStrategyContext r7 = (IDynamicStrategyContext) r6.getValue();
        if (r7 == null) goto L16;
        PropertyOwner r8 = r7.getStrategy("live_component_strategy");
        if (r8 == null) goto L17;
        n r9 = (n) r8.a;
        if (r9 != null) goto L13;
        return 0;
    L13:
        return r9.b(0);
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    L14:
        return 0;
    }

    public static final Room q(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        DataCenter r3 = r2.h;
        if (r3 != null) goto L5;
        return null;
    L5:
        return (Room) r3.get("data_room", null);
    }

    public static final void b(a r4, j70.f r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$initShowState");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        DataCenter r7 = r4.h;     // Catch: Throwable -> L8
        DataCenter r1 = null;
        if (r7 == null) goto L6;
        r1 = r7.put("data_component_show_state", new kw2.a("state_init", r5.b, null, r6));     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
