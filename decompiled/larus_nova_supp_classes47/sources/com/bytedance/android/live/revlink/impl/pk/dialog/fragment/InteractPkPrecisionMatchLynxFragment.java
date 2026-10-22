package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class InteractPkPrecisionMatchLynxFragment {
    public static final /* synthetic */ int d = 0;
    public zy0.d a;
    public final Context b;
    public final PkPrecisionMatchDataContext c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        PkPrecisionMatchDataContext r0 = this.c;
        if (r0 == null) goto L24;
        d2 r1 = r0.getBattlePrecisionMatch();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getMatcherList().size() <= 2) goto L10;
        String r2 = DataType.TRUE;
    L11:
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r3 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r3.getClass();
        String r4 = (String) com.bytedance.android.live.revlink.impl.settings.dynamic.a.G.getValue(r3, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[31]);
        String r5 = b(r1.getMatcherList());
        Uri r6 = com.bytedance.revenue.platform.api.core.e.a(r4).buildUpon().appendQueryParameter("title", r1.getTitle()).appendQueryParameter("sub_title", r1.getSubTitle()).appendQueryParameter("play_mode", String.valueOf(r1.getPlayMode())).appendQueryParameter("is_multi", r2).appendQueryParameter("match_users", r5).appendQueryParameter("cur_battle_rule", r1.getBattleRule()).appendQueryParameter("wait_seconds", String.valueOf(r1.getWaitSeconds())).appendQueryParameter("precision_match_id", String.valueOf(r1.getPrecisionMatchId())).build();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        cy0.e.a.getClass();     // Catch: Throwable -> L14
        cy0.j r8 = cy0.e.a.a;     // Catch: Throwable -> L14
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L14
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(vy0.b.class));     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L14
        this.a = ((vy0.b) ((f80.a) r9)).U0(this.b, r6, InteractPkPrecisionMatchLynxFragment$show$1$1.INSTANCE);     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.exceptionOrNull-impl(r10);
        if (r12 == null) goto L25;
        int r13 = w.a;
        if (v.a() == false) goto L26;
        int r14 = ToastUtil.a;
        ToastUtil.b(r12.getMessage(), 0);
        return;
    L26:
        return;
    L25:
        return;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L10:
        r2 = DataType.FALSE;
        goto L11
    }

    public final Context getContext() {
        return this.b;
    }

    public static String b(List r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L36
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L36
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L36
    L5:
        if (r9.hasNext() == false) goto L34;
        IBattlePrecisionMatcher r3 = (IBattlePrecisionMatcher) r9.next();     // Catch: Throwable -> L36
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L36
        r4.put("user_id", String.valueOf(r3.getUserId()));     // Catch: Throwable -> L36
        IRoom r5 = r3.getRoom();     // Catch: Throwable -> L36
        Long r6 = null;
        if (r5 == null) goto L11;
        IBaseUser r7 = r5.getOwner();     // Catch: Throwable -> L36
        if (r7 == null) goto L11;
        String r10 = r7.getNickName();     // Catch: Throwable -> L36
    L12:
        r4.put("nick_name", r10);     // Catch: Throwable -> L36
        IRoom r12 = r3.getRoom();     // Catch: Throwable -> L36
        if (r12 == null) goto L17;
        IRoomStats r13 = r12.getStats();     // Catch: Throwable -> L36
        if (r13 == null) goto L17;
        String r14 = r13.getUserCountStr();     // Catch: Throwable -> L36
    L18:
        r4.put("audience_count", r14);     // Catch: Throwable -> L36
        IRoom r15 = r3.getRoom();     // Catch: Throwable -> L36
        if (r15 == null) goto L29;
        IBaseUser r16 = r15.getOwner();     // Catch: Throwable -> L36
        if (r16 == null) goto L29;
        py.k r17 = r16.getAvatarThumbKt();     // Catch: Throwable -> L36
        if (r17 == null) goto L29;
        List r18 = r17.getUrls();     // Catch: Throwable -> L36
        if (r18 == null) goto L29;
        String r19 = (String) ListProtector.get(r18, 0);     // Catch: Throwable -> L36
        if (r19 == null) goto L29;
        String r20 = URLEncoder.encode(r19, "UTF-8");     // Catch: Throwable -> L36
    L30:
        r4.put("avatar", r20);     // Catch: Throwable -> L36
        IRoom r22 = r3.getRoom();     // Catch: Throwable -> L36
        if (r22 == null) goto L33;
        r6 = Long.valueOf(r22.getId());     // Catch: Throwable -> L36
    L33:
        r4.put("room_id", String.valueOf(r6));     // Catch: Throwable -> L36
        r4.put("ready_status", String.valueOf(r3.getStatus()));     // Catch: Throwable -> L36
        r2.put(r4);     // Catch: Throwable -> L36
    L29:
        r20 = null;
    L17:
        r14 = null;
    L11:
        r10 = null;
        goto L12
    L34:
        Object r23 = Result.constructor-impl(r2.toString());     // Catch: Throwable -> L36
    L38:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L45;
        int r25 = w.a;
        if (v.a() == false) goto L43;
        int r26 = ToastUtil.a;
        ToastUtil.b("转换匹配用户数据失败: " + r24.getMessage(), 0);
    L43:
        r24.printStackTrace();
    L45:
        if (Result.isFailure-impl(r23) == false) goto L48;
        r23 = "[]";
    L48:
        return (String) r23;
    L36:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }

    public InteractPkPrecisionMatchLynxFragment(Context r2, PkPrecisionMatchDataContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.c = r3;
    }
}
