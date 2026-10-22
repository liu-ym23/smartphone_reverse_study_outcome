package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 {
    public static final IRoom a = null;

    static {
        a = vh7.f.c(IRoom.class);
    }

    public static final IAbilityCenter a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$currentAbility");
        return (IAbilityCenter) r2.get("data_room_ablity_center", null);
    }

    public static final IAbilityCenter b(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$currentSessionAbility");
        return (IAbilityCenter) r2.get("data_session_ablity_center", null);
    }

    public static final boolean c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isInPreview");
        return ((Boolean) r2.get("data_current_is_preview", Boolean.FALSE)).booleanValue();
    }

    public static /* synthetic */ boolean e(DataCenter r1) {
        return d(r1, false);
    }

    public static final boolean f(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.AUDIO) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean g(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.MEDIA) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean h(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.SCREEN_RECORD) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean i(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r2 = LiveMode.VIDEO;
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", r2);
        if (r1 == false) goto L10;
        if (r5 != r2) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static final boolean j(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMiddlewareMediaRoom");
        Intrinsics.checkNotNullParameter(r2, "$this$roomType");
        IRoomType r3 = (IRoomType) r2.get("data_room", null);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.isMediaRoom();
    }

    public static final boolean k(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMiddlewareMergeVSRoom");
        Intrinsics.checkNotNullParameter(r2, "$this$roomType");
        IRoomType r3 = (IRoomType) r2.get("data_room", null);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.isMergeVSRoom();
    }

    public static final y m(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$middlewareCommon");
        IRoom r0 = (IRoom) r3.get("data_room");
        Object r1 = r3.get("data_is_portrait");
        if (r1 != null) goto L5;
        r1 = Boolean.TRUE;
    L5:
        boolean r2 = ((Boolean) r1).booleanValue();
        Object r4 = r3.get("data_is_anchor");
        if (r4 != null) goto L9;
        r4 = Boolean.FALSE;
    L9:
        return new y(r0, r2, ((Boolean) r4).booleanValue());
    }

    public static final IRoom n(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$middlewareRoom");
        return (IRoom) r2.get("data_room", a);
    }

    public static final IRoom o(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$safeRoom");
        return (IRoom) r2.get("data_room", null);
    }

    public static final String p(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uniqueId");
        return (String) r2.get("data_room_unique_id", null);
    }

    public static final boolean d(DataCenter r1, boolean r2) {
        if (r1 == null) goto L6;
        Boolean r3 = (Boolean) r1.get("data_is_anchor", Boolean.valueOf(r2));
        if (r3 == null) goto L6;
        return r3.booleanValue();
    L6:
        return false;
    }

    public static final boolean l(DataCenter r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMiddlewarePortrait");
        return ((Boolean) r1.get("data_is_portrait", Boolean.valueOf(r2))).booleanValue();
    }
}
