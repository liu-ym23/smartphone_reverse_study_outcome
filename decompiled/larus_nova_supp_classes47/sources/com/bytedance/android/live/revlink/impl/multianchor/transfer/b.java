package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k31.h;
import k31.i;
import k31.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final f a;
    public final m31.b b;
    public k31.c c;
    public Disposable d;
    public final boolean e;
    public final DeviceType f;
    public final boolean g;
    public final Boolean h;

    public final void a(m r19) {
        Intrinsics.checkNotNullParameter(r19, "transferParam");
        View r2 = r19.d;
        LiveMode r4 = null;
        if ((r2 instanceof AbsLivePlayerView) == true) goto L5;
        r2 = null;
    L5:
        AbsLivePlayerView r9 = (AbsLivePlayerView) r2;
        if (r9 != null) goto L8;
        return;
    L8:
        int r6 = r19.a;
        if (r6 == 0) goto L50;
        int r7 = r19.b;
        if (r7 == 0) goto L53;
        d r3 = new d(r6, r7, r19.c, r9, r19.e, r19.f, r19.g, r19.h, r19.i, r19.j, r19.k, r19.l);
        e r1 = this.a.a(r3.f, r3.e);
        if (r1 == null) goto L54;
        boolean r5 = true;
        if (r3.l == true) goto L19;
    L33:
        com.bytedance.android.livesdk.revenue.service.room.c r8 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r8 == null) goto L38;
        com.bytedance.android.livesdk.revenue.room.a r10 = r8.getRoomContext();
        if (r10 == null) goto L38;
        IRoomBase r12 = r10.getCommonRoom();
    L39:
        IRoom r13 = (IRoom) r12;
        if (r13 == null) goto L43;
        r4 = r13.getStreamType();
    L43:
        if (r4 == LiveMode.SCREEN_RECORD) goto L46;
        r5 = false;
    L46:
        k31.c r14 = r1.b(new l31.a(r3.a, r3.b, r3.c, r3.g, r3.h, r3.i, r3.j, r3.k), this.g, this.h, r5);
        if (r14 == null) goto L52;
        d(r14, r3);
        return;
    L52:
        return;
    L38:
        r12 = null;
        goto L39
    L19:
        if (r3.e == true) goto L33;
        if (r1.a() == true) goto L33;
        if (this.g == true) goto L33;
        m31.b r15 = this.b;
        l31.a r16 = new l31.a(r3.a, r3.b, r3.c, r3.g, r3.h, null, r3.j, r3.k);
        r15.getClass();
        k31.c r17 = m31.b.a(r16);
        if (r17 == null) goto L27;
        d(r17, r3);
    L27:
        Disposable r18 = this.d;
        if (r18 != null) goto L30;
    L32:
        ToastUtil.a(2131917688, 0);
        this.d = Observable.just(1).delay(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(a.a);
        return;
    L30:
        if (r18.isDisposed() == true) goto L32;
        return;
    L54:
        return;
    L53:
        return;
    }

    public b(boolean r1, Boolean r2) {
        this.g = r1;
        this.h = r2;
        this.a = new f();
        this.b = new m31.b();
        k31.e r3 = new k31.e();
        if (z41.d.c.B6() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.e = r4;
        this.f = r3.getDeviceType();
        return;
    L5:
        if (FoldScreenUtils.f() == true) goto L7;
        r4 = true;
        goto L8
    }

    public static void c(AbsLivePlayerView r5, h r6) {
        ViewGroup.LayoutParams r2 = null;
        jy0.b.c("ttlive_anchor_link_player", "do updateLayout " + r6, null, 4);
        Objects.toString(r6);
        ViewGroup.LayoutParams r0 = r5.getRenderView().getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L6;
        r2 = r0;
    L6:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3 != null) goto L9;
        return;
    L9:
        r5.getRenderView().setScaleType(4);
        r5.getRenderView().setStrictMeasureData(new StrictMeasureData(r6.a, r6.b));
        r3.width = r6.a;
        r3.height = r6.b;
        r3.gravity = b31.c.a(r6.e);
        r3.topMargin = r6.c;
        r3.leftMargin = r6.d;
        r5.getRenderView().setLayoutParams(r3);
    }

    public final boolean b(ILiveMode r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "liveMode");
        if (this.e == false) goto L6;
        int r3 = m31.a.a;
        return m31.a.a(m31.d.a(r1), this.f);
    L6:
        int r4 = m31.a.a;
        return m31.a.a(m31.d.a(r1), rc0.b.a());
    }

    public final void d(k31.c r27, d r28) {
        this.c = r27;
        String r4 = r28.g;
        k31.f r0 = r28.h;
        boolean r6 = true;
        if (r0 == null) goto L14;
        p0 r5 = r0.b;
        if (r5 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        r27.e = r7;
        r27.f = c31.a.a();
        h r1 = r27.a(r0);
        if (r1 == null) goto L93;
        c(r28.d, r1);
        return;
    L93:
        return;
    L7:
        if (r5.i() != UILayout.FULL.ordinal()) goto L9;
        r7 = true;
        goto L10
    L14:
        if (r4 == null) goto L94;
        String r8 = "";
        Intrinsics.checkNotNullParameter(r4, "sei");
        JSONObject r9 = com.bytedance.android.live.revenue.common.player.utils.a.j(r4);     // Catch: Throwable -> L26
        if (r9 != null) goto L20;
    L32:
        int r2 = 0;
    L34:
        if (r2 != UILayout.FULL.ordinal()) goto L36;
        boolean r3 = true;
    L37:
        r27.e = r3;
        r27.f = c31.a.a();
        q r10 = r28.i;
        Intrinsics.checkNotNullParameter(r4, "sei");
        i.a r12 = i.g;
        int r13 = r27.a;
        int r14 = r27.b;
        if (r10 == null) goto L40;
        JSONObject r15 = r10.b;
    L41:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r4, "sei");
        if (r15 != null) goto L45;
        r6 = false;
    L45:
        n0 r16 = com.bytedance.android.live.revenue.common.player.utils.a.a(r4, r6);
        if (r15 == null) goto L50;
        JSONArray r17 = com.bytedance.android.live.revenue.common.player.utils.a.c(r15);
        if (r17 != null) goto L54;
    L77:
        i r18 = null;
    L78:
        if (r18 != null) goto L81;
        h r19 = null;
    L88:
        if (r19 == null) goto L95;
        c(r28.d, r19);
        return;
    L95:
        return;
    L81:
        if (r27.e == false) goto L87;
        b03.a r20 = b03.a.a;
        int r22 = s1.w();
        int r23 = (r22 * 9) / 16;
        GravityDef r24 = GravityDef.CENTER_HORIZONTAL;
        if (r23 <= s1.y()) goto L85;
        GravityDef r25 = GravityDef.RIGHT;
        int r26 = s1.y() - r23;
        GravityDef r29 = r25;
    L86:
        r19 = new h(r23, r22, 0, r26, r29);
        goto L88
    L85:
        r29 = r24;
        r26 = 0;
        goto L86
    L87:
        r19 = new h(r18.a, r18.b, r27.c - r18.d, r27.d - r18.c, GravityDef.LEFT_TOP);
    L54:
        if (r16 != null) goto L66;
        double r110 = com.bytedance.android.live.revenue.common.player.utils.a.i(r17);
        double r111 = com.bytedance.android.live.revenue.common.player.utils.a.d(r17);
        if (r110 <= 0.0d) goto L77;
        if (r111 <= 0.0d) goto L77;
        int r112 = (int) (((double) r13) / r110);
        int r113 = (int) (((double) r14) / r111);
        double r30 = com.bytedance.android.live.revenue.common.player.utils.a.i(r17);
        double r32 = com.bytedance.android.live.revenue.common.player.utils.a.d(r17);
        if (r30 <= 0.0d) goto L77;
        if (r32 <= 0.0d) goto L77;
        double r114 = r112;
        double r33 = r113;
        r18 = new i(r112, r113, (int) (com.bytedance.android.live.revenue.common.player.utils.a.g(r17) * r114), (int) (com.bytedance.android.live.revenue.common.player.utils.a.h(r17) * r33), (int) (r114 * r30), (int) (r33 * r32));
        goto L78
    L66:
        double r34 = com.bytedance.android.live.revenue.common.player.utils.a.i(r17);
        double r35 = com.bytedance.android.live.revenue.common.player.utils.a.d(r17);
        if (r34 <= 0.0d) goto L77;
        if (r35 <= 0.0d) goto L77;
        double r115 = ((double) r13) / r34;
        double r116 = (r115 * ((double) r16.f())) / ((double) r16.b());
        double r36 = ((((double) r14) / r35) * ((double) r16.e())) / ((double) r16.a());
        int r37 = (int) r116;
        int r38 = (int) r36;
        double r39 = com.bytedance.android.live.revenue.common.player.utils.a.i(r17);
        double r117 = com.bytedance.android.live.revenue.common.player.utils.a.d(r17);
        if (r39 <= 0.0d) goto L77;
        if (r117 <= 0.0d) goto L77;
        float r40 = r37;
        int r42 = (int) ((r16.b() * r40) / r16.f());
        float r43 = r38;
        int r44 = (int) ((r16.a() * r43) / r16.e());
        double r45 = r42;
        double r46 = r44;
        r18 = new i(r37, r38, (int) (((double) ((int) ((r40 * r16.c()) / r16.f()))) + (com.bytedance.android.live.revenue.common.player.utils.a.g(r17) * r45)), (int) (((double) ((int) ((r43 * r16.d()) / r16.e()))) + (com.bytedance.android.live.revenue.common.player.utils.a.h(r17) * r46)), (int) (r45 * r39), (int) (r46 * r117));
        goto L78
    L50:
        r17 = com.bytedance.android.live.revenue.common.player.utils.a.b(r4);
        if (r17 != null) goto L54;
    L40:
        r15 = null;
        goto L41
    L36:
        r3 = false;
        goto L37
    L20:
        if (r9.has("app_data") == false) goto L32;
        JSONObject r47 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r9, "app_data"), "")).optJSONObject("anchor_interact_info");     // Catch: Throwable -> L26
        if (r47 == null) goto L32;
        r2 = r47.optInt("layout_type");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        jy0.b.d("SeiUtils", "parse sei: " + r4 + " failed");
        String r48 = th.getMessage();
        if (r48 == null) goto L31;
        r8 = r48;
    L31:
        jy0.b.d("SeiUtils", r8);
        goto L32
    }
}
