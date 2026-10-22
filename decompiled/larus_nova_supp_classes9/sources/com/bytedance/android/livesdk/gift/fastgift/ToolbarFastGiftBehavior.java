package com.bytedance.android.livesdk.gift.fastgift;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ToolbarFastGiftBehavior extends zr2.k implements yz0.m, com.bytedance.android.scope.o {
    public View b;
    public DataCenter c;
    public boolean d;
    public Disposable e;
    public final Lazy f;
    public final yz0.k g;
    public final h01.a h;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.d i;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final void onStart() {
    }

    public final void onWidgetLoaded() {
    }

    public final void x() {
    }

    private final Context getContext() {
        return this.g.getContext();
    }

    public final IRoom getRoom() {
        return this.g.getRoom();
    }

    public final void onStop() {
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = true;
        this.h.f5(RevToolbarConstants.FastGift, this);
    }

    public final void i() {
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == false) goto L6;
        this.h.Ye(RevToolbarConstants.FastGift, this, ToolbarFastGiftBehavior$onRoomReady$1.INSTANCE);
        return;
    }

    public final void onViewReady() {
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L5;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).e(RevToolbarButton.FastGift, this);
        return;
    L5:
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.b() == true) goto L8;
        return;
    L8:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.toolbar.a.j.getValue(null, com.bytedance.android.livesdk.gift.platform.business.toolbar.a.a[8])).booleanValue() == false) goto L14;
        Lazy r1 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(this.g.getDataCenter(), NewToolbarButtonConstants.ToolbarFastGift.INSTANCE, new g0(this));
        return;
    }

    public static final /* synthetic */ Context w(ToolbarFastGiftBehavior r0) {
        return r0.getContext();
    }

    public final void a(final zr2.n r9) {
        Intrinsics.checkNotNullParameter(r9, "command");
        if (this.d == false) goto L5;
        return;
    L5:
        boolean r1 = false;
        Object r5 = null;
        if ((r9 instanceof zr2.r) == false) goto L48;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.a() == false) goto L19;
        FragmentActivity r0 = getContext();
        if (r0 == null) goto L17;
        MutableLiveData<Boolean> r2 = ((FastGiftViewModel) ViewModelProviders.of(r0).get(FastGiftViewModel.class)).getBehaviorVisible();
        if (((zr2.r) r9).a != 0) goto L14;
        boolean r6 = true;
    L15:
        r2.postValue(Boolean.valueOf(r6));
        goto L19
    L14:
        r6 = false;
        goto L15
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L19:
        if (((zr2.r) r9).a == 0) goto L21;
        return;
    L21:
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == false) goto L23;
        return;
    L23:
        zr2.c r10 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c);
        RevToolbarButton r3 = RevToolbarButton.FastGift;
        if (r10.f(r3) == false) goto L92;
        IRoomAuthStatus r11 = getRoom().getRoomAuthStatus();
        if (r11 == null) goto L31;
        if (r11.getEnableGift() != true) goto L31;
        r1 = true;
    L31:
        if (getRoom().isMediaRoom() != true) goto L35;
        if (r1 == true) goto L35;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(r3);
    L35:
        if (com.bytedance.android.livesdk.gift.platform.business.a.c() != 1) goto L38;
        if (r1 == true) goto L38;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(r3);
    L38:
        IMainRoom r13 = getRoom().castToOrNull(IMainRoom.class);
        if (r13 == null) goto L44;
        Map r14 = r13.getAnchorAbMap();
        if (r14 == null) goto L44;
        r5 = (String) r14.get("gift_hide_tip");
    L44:
        if (Intrinsics.areEqual(r5, "2") == false) goto L93;
        if (r1 == true) goto L94;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(r3);
        return;
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L48:
        if ((r9 instanceof zr2.e) == false) goto L82;
        IRoomAuthStatus r4 = getRoom().getRoomAuthStatus();
        if (r4 == null) goto L55;
        if (r4.getEnableGift() != true) goto L55;
        r1 = true;
    L55:
        if (com.bytedance.android.livesdk.gift.platform.business.a.c() != 1) goto L58;
        if (r1 == true) goto L58;
        return;
    L58:
        IMainRoom r7 = getRoom().castToOrNull(IMainRoom.class);
        if (r7 == null) goto L64;
        Map r8 = r7.getAnchorAbMap();
        if (r8 == null) goto L64;
        r5 = (String) r8.get("gift_hide_tip");
    L64:
        if (Intrinsics.areEqual(r5, "2") == false) goto L67;
        if (r1 == true) goto L67;
        return;
    L67:
        View r15 = this.b;
        if (r15 == null) goto L70;
        zr2.e r16 = (zr2.e) r9;
        this.i.wf(r16, r16.j, getContext(), r15, new ToolbarFastGiftBehavior$onCommand$$inlined$let$lambda$1(this, r9));
    L70:
        Map r17 = ((zr2.e) r9).i;
        HashMap r18 = new HashMap();
        if (r17 == null) goto L80;
        String r19 = (String) r17.get("message_type");
        String r20 = BuildConfig.FLAVOR;
        if (r19 != null) goto L75;
        r19 = BuildConfig.FLAVOR;
    L75:
        r18.put("message_type", r19);
        String r21 = (String) r17.get("ploy_id");
        if (r21 == null) goto L79;
        r20 = r21;
    L79:
        r18.put("ploy_id", r20);
    L80:
        r18.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        mz0.n r23 = new mz0.n();
        Map r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r18, "map");
        r24.putAll(r18);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.ROOM);
        List r26 = r23.b;
        ArrayList r27 = (ArrayList) r26;
        r27.addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r29);
        ((f80.a) r29).w3("commonguide_popup_show", r23.a, r23.b);
        return;
    L82:
        if ((r9 instanceof zr2.f) == false) goto L97;
        View r30 = this.b;
        if ((r30 instanceof FastGiftViewV3) == false) goto L87;
        r5 = r30;
    L87:
        FastGiftViewV3 r31 = (FastGiftViewV3) r5;
        if (r31 == null) goto L98;
        zr2.f r33 = (zr2.f) r9;
        r31.o(r31.A.getGift());
        return;
    L98:
        return;
    }

    public final void d(zr2.h r5) {
        Intrinsics.checkNotNullParameter(r5, "button");
        if (this.d == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == false) goto L27;
        DataCenter r0 = this.c;
        IRoom r2 = null;
        if (r0 == null) goto L10;
        r2 = (IRoom) r0.get("data_room", null);
    L10:
        if (r2 == null) goto L14;
        IRoomAuthStatus r1 = r2.getRoomAuthStatus();
        if (r1 == null) goto L14;
        r1.setEnableGift(true);
    L14:
        DataCenter r3 = this.c;
        if (r3 == null) goto L17;
        r3.put("data_room", r2);
    L17:
        getContext();
        if (r5.c == false) goto L21;
        y(r5.b, r5.a);     // Catch: Throwable -> L23
    L24:
        return;
    L21:
        A(r5.b, r5.a);     // Catch: Throwable -> L23
    L28:
        return;
    }

    public final void A(String r3, py.k r4) {
        h1 r5 = (h1) GsonProtectorUtils.fromJson(GsonHelper.get(), r3, h1.class);
        if (r5 == null) goto L11;
        r5.enableImageFormatOpt(((Boolean) this.f.getValue()).booleanValue());
        GiftManagerKt.z.getClass();
        GiftManagerKt.F(r5);
        View r6 = this.b;
        Unit r1 = null;
        if ((r6 instanceof FastGiftViewV3) == true) goto L7;
        r6 = null;
    L7:
        FastGiftViewV3 r7 = (FastGiftViewV3) r6;
        if (r7 == null) goto L10;
        r7.C = r4;
        r7.m();
        r1 = Unit.INSTANCE;
    L10:
        if (r1 == null) goto L11;
        return;
    L11:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(RevToolbarButton.FastGift);
        Unit r8 = Unit.INSTANCE;
    }

    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        if (this.d == false) goto L5;
        return;
    L5:
        this.b = r6;
        h01.a r0 = this.h;
        com.bytedance.android.live.revenue.core.a r1 = com.bytedance.android.live.revenue.core.util.k.a();
        boolean r2 = false;
        if (r1 == null) goto L10;
        yz0.k r3 = com.bytedance.android.live.revenue.core.util.f.c(r1, yz0.k.class);
        if (r3 == null) goto L10;
        boolean r4 = r3.isAnchor();
    L11:
        r0.k1(r4, this.b);
        this.c = r7;
        py.k r5 = null;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == false) goto L25;
        getContext();
        boolean r8 = r6 instanceof FastGiftViewV3;
        if (r8 == true) goto L16;
        View r9 = null;
    L17:
        FastGiftViewV3 r10 = (FastGiftViewV3) r9;
        if (r10 == null) goto L20;
        r10.g(r7);
    L20:
        if (r8 == true) goto L22;
        r6 = null;
    L22:
        FastGiftViewV3 r11 = (FastGiftViewV3) r6;
        if (r11 == null) goto L82;
        r11.o(r11.A.getGift());
        return;
    L82:
        return;
    L16:
        r9 = r6;
        goto L17
    L25:
        IRoomAuthStatus r13 = getRoom().getRoomAuthStatus();
        if (r13 != null) goto L28;
    L30:
        boolean r14 = false;
    L32:
        if (getRoom().isMediaRoom() == false) goto L39;
        if (r14 == true) goto L36;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(RevToolbarButton.FastGift);
        goto L39
    L36:
        if (GiftManagerKt.p() == null) goto L38;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).b(RevToolbarButton.FastGift);
        goto L39
    L38:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.c).d(RevToolbarButton.FastGift);
    L39:
        getContext();
        boolean r15 = r6 instanceof FastGiftViewV3;
        if (r15 == true) goto L42;
        View r16 = null;
    L43:
        FastGiftViewV3 r17 = (FastGiftViewV3) r16;
        if (r17 == null) goto L46;
        r17.g(r7);
    L46:
        if (r15 == true) goto L48;
        r6 = null;
    L48:
        FastGiftViewV3 r18 = (FastGiftViewV3) r6;
        if (r18 == null) goto L52;
        r18.o(r18.A.getGift());
    L52:
        if (GiftManagerKt.p() != null) goto L84;
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L80;
        com.bytedance.live.datacontext.n<my1.a> r20 = r19.getFastTaskGiftModel();
        if (r20 == null) goto L80;
        my1.a r21 = (my1.a) r20.getValue();
        if (r21 == null) goto L80;
        if (r21.b == null) goto L62;
        boolean r23 = true;
    L63:
        if (r23 == true) goto L66;
        r21 = null;
    L66:
        if (r21 == null) goto L80;
        GiftManagerKt r24 = GiftManagerKt.z;
        if (r21.a == null) goto L70;
        r2 = true;
    L70:
        h1 r25 = r21.b;
        Intrinsics.checkNotNull(r25);
        r24.getClass();
        GiftManagerKt.G(r2, r25);
        View r26 = this.b;
        if ((r26 instanceof FastGiftViewV3) == true) goto L73;
        r26 = null;
    L73:
        FastGiftViewV3 r27 = (FastGiftViewV3) r26;
        if (r27 == null) goto L79;
        h1 r28 = r21.b;
        if (r28 == null) goto L78;
        r5 = r28.getImage();
    L78:
        r27.C = r5;
        r27.m();
        r5 = Unit.INSTANCE;
    L79:
        if (r5 == null) goto L80;
        return;
    L62:
        r23 = false;
    L80:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(r7).d(RevToolbarButton.FastGift);
        Unit r29 = Unit.INSTANCE;
        return;
    L84:
        return;
    L42:
        r16 = r6;
        goto L43
    L28:
        if (r13.getEnableGift() != true) goto L30;
        r14 = true;
    L10:
        r4 = false;
        goto L11
    }

    public final void y(String r7, py.k r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L26
        my1.a r1 = (my1.a) GsonHelper.get().fromJson(r7, my1.a.class);     // Catch: Throwable -> L26
        if (r1 == null) goto L24;
        boolean r2 = true;
        View r3 = null;
        if ((!TextUtils.isEmpty(r1.speedyGift)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L24;
        my1.b r4 = (my1.b) GsonHelper.get().fromJson(r1.personalGiftStr, my1.b.class);     // Catch: Throwable -> L26
        h1 r5 = (h1) GsonHelper.get().fromJson(r1.speedyGift, h1.class);     // Catch: Throwable -> L26
        if (r5 == null) goto L12;
        r5.enableImageFormatOpt(((Boolean) this.f.getValue()).booleanValue());     // Catch: Throwable -> L26
    L12:
        GiftManagerKt r6 = GiftManagerKt.z;     // Catch: Throwable -> L26
        if (r4 != null) goto L16;
        r2 = false;
    L16:
        r6.getClass();     // Catch: Throwable -> L26
        GiftManagerKt.G(r2, r5);     // Catch: Throwable -> L26
        View r9 = this.b;     // Catch: Throwable -> L26
        if ((r9 instanceof FastGiftViewV3) == false) goto L20;
        r3 = r9;
    L20:
        FastGiftViewV3 r10 = (FastGiftViewV3) r3;     // Catch: Throwable -> L26
        if (r10 == null) goto L33;
        r10.C = r5.getImage();     // Catch: Throwable -> L26
        r10.m();     // Catch: Throwable -> L26
        return;
    L33:
        return;
    L24:
        A(r7, r8);     // Catch: Throwable -> L26
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L29:
        if (Result.exceptionOrNull-impl(r11) == null) goto L34;
        A(r7, r8);
        return;
    L34:
        return;
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public ToolbarFastGiftBehavior(yz0.k r2, h01.a r3, com.bytedance.android.livesdk.revenue.service.toolbar.d r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "toolbarService");
        Intrinsics.checkNotNullParameter(r4, "bubbleManager");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.f = LazyKt.lazy(ToolbarFastGiftBehavior$fastGiftImageFormate$2.INSTANCE);
    }
}
