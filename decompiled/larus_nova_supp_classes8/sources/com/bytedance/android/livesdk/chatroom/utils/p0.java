package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import com.bytedance.android.live.customize.ILiveFeedDrawerTool;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.config.qv;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0 {
    public static final List<String> a = null;
    public static final List<String> b = null;

    static {
        a = Arrays.asList(new String[]{"live_program_list*", "discover_page*", "live_merge*", "live_merge_activity*"});
        b = Arrays.asList(new String[]{"home_team", "sjb_venue", "sjb_stars_subpage", "sjb_commentator_subpage", "sjb_imp_content_subpage", "smp_homepage"});
    }

    public static boolean a() {
        ILiveFeedDrawerTool r0 = jc1.k.f(ILiveFeedDrawerTool.class);
        if (r0 == null) goto L15;
        IMiddlewareRoomService r3 = jc1.k.f(IMiddlewareRoomService.class);
        if (r3 != null) goto L7;
        return false;
    L7:
        ILiveOntologyInfoManager r4 = r3.getLiveOntologyRecord();
        String r5 = r4.getEnterFromMerge();
        String r6 = r4.getEnterMethod();
        if (((Boolean) qv.a.getValue()).booleanValue() == true) goto L10;
        return false;
    L10:
        if (r0.canShowMoreEntrance(r5, r6) == true) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r0.getLiveFeedUrlDrawer(r5)) == true) goto L56;
        return true;
    L56:
        return false;
    L15:
        ILiveOntologyInfoManager r1 = jc1.k.f(IMiddlewareLiveService.class).getLiveOntologyRecord();
        if (TextUtils.equals("live_program_list", r1.getEnterMethod()) == false) goto L19;
        return true;
    L19:
        if (TextUtils.equals("discover_page", r1.getEnterFromMerge()) == false) goto L22;
        return true;
    L22:
        if (TextUtils.equals("live_merge", r1.getEnterFromMerge()) == false) goto L25;
        return true;
    L25:
        if (TextUtils.equals("live_merge_activity", r1.getEnterFromMerge()) == false) goto L28;
        return true;
    L28:
        if (TextUtils.equals("covid19", r1.getEnterFromMerge()) == false) goto L31;
        return true;
    L31:
        if (TextUtils.equals("general_search", r1.getEnterFromMerge()) == false) goto L36;
        if (TextUtils.equals("covid19", r1.getEnterMethod()) == false) goto L36;
        return true;
    L36:
        if (b.contains(r1.getEnterFromMerge()) == false) goto L39;
        return true;
    L39:
        if (TextUtils.equals("homepage_follow", r1.getEnterFromMerge()) == true) goto L41;
    L43:
        MiddlewareRoomContext r7 = MiddlewareRoomContext.getShared();
        if (r7 == null) goto L51;
        if (r7.isVSSpecialDrawer() == false) goto L51;
        if (oj1.a.getValue().e() == false) goto L51;
        r1.enableMakeSureLiveDrawerUrlNotNULL();
    L51:
        if (r1.getLiveDrawerUrl() == null) goto L57;
        return true;
    L57:
        return false;
    L41:
        if (TextUtils.equals("live_cell_cover", r1.getEnterMethod()) == false) goto L43;
        return false;
    }

    public static boolean b(IRoom r7) {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.getShared();
        if (r0 == null) goto L8;
        if (((Boolean) r0.isAnchor().getValue()).booleanValue() == false) goto L8;
        return false;
    L8:
        if (r0 != null) goto L10;
    L49:
        if (r7 == null) goto L60;
        if (r7.getRoomAuthStatus() == null) goto L60;
        if (a() == true) goto L56;
        return false;
    L56:
        if (r7.getRoomAuthStatus().getMoreAnchor() == 2) goto L62;
        return true;
    L62:
        return false;
    L60:
        return a();
    L10:
        if (r0.isVSSpecialDrawer() == false) goto L49;
        if (((Boolean) r0.isPortraitInteraction().getValue()).booleanValue() == false) goto L31;
        Intrinsics.checkNotNullParameter(r0, "$this$isVSSpecialDrawerSupportPortrait");
        Integer[] r3 = {3, 1};
        EpisodeExtraInfo r1 = ((Room) r0.getRoom().getValue()).getEpisodeExtra2();
        if (r1 == null) goto L22;
        VSConfigDrawer r2 = r1.getVsConfigDrawer();
        if (r2 == null) goto L22;
        MatchDrawer r4 = r2.drawer;
        if (r4 == null) goto L22;
        Integer r5 = r4.getDisplayMode();
        if (r5 == null) goto L22;
        int r6 = r5.intValue();
    L24:
        if (ArraysKt.contains(r3, Integer.valueOf(r6)) == true) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L49;
        return false;
    L26:
        if (oj1.a.getValue().f() == false) goto L28;
        r8 = true;
    L22:
        r6 = 0;
        goto L24
    L31:
        Intrinsics.checkNotNullParameter(r0, "$this$isVSSpecialDrawerSupportLandscape");
        Integer[] r9 = {3, 2};
        EpisodeExtraInfo r10 = ((Room) r0.getRoom().getValue()).getEpisodeExtra2();
        if (r10 == null) goto L40;
        VSConfigDrawer r11 = r10.getVsConfigDrawer();
        if (r11 == null) goto L40;
        MatchDrawer r12 = r11.drawer;
        if (r12 == null) goto L40;
        Integer r13 = r12.getDisplayMode();
        if (r13 == null) goto L40;
        int r14 = r13.intValue();
    L42:
        if (ArraysKt.contains(r9, Integer.valueOf(r14)) == true) goto L44;
    L46:
        boolean r15 = false;
    L47:
        if (r15 == true) goto L49;
        return false;
    L44:
        if (oj1.a.getValue().c() == false) goto L46;
        r15 = true;
    L40:
        r14 = 0;
        goto L42
    }
}
