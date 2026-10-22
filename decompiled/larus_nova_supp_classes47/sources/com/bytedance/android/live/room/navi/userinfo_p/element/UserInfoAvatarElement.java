package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoAvatarPresenter;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdk.config.pv0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import j40.b1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoAvatarElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoAvatarElement extends BaseElement implements Observer<KVData> {
    public HSImageView d;
    public d91.a e;
    public final String f;
    public IRoom g;
    public final CompositeDisposable h;
    public final Lazy i;
    public final HSImageView j;
    public final HSImageView k;
    public final HSImageView l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UserInfoAvatarElement a;

        public a(UserInfoAvatarElement r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ((UserInfoAvatarPresenter) this.a.i.getValue()).f(null);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IBaseUser a;

        public b(IBaseUser r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l91.a.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ IBaseUser a;

        public c(IBaseUser r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l91.a.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        if (((Boolean) pv0.a.getValue()).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(this.k, 8);
        HSImageView r0 = this.l;
        this.d = r0;
        UIUtils.setViewVisibility(r0, 0);
    L7:
        if (((Boolean) com.bytedance.android.live.misc.c.a.getValue()).booleanValue() == true) goto L9;
        return;
    L9:
        if (this.c.isAnchor() == true) goto L11;
        return;
    L11:
        if (a0.g(this.c.getDataCenter()) == true) goto L16;
        this.j.setOnClickListener(new a(this));
        return;
    L16:
        return;
    L5:
        this.d = this.k;
        goto L7
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        ALogger.d(this.f, "onWidgetPrepareViewOnLoad");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L5;
        s(true, false);
    L6:
        getDataCenter().put("cmd_userinfo_widget_show", Boolean.TRUE);
        return;
    L5:
        s(true, true);
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        this.g = getRoom();
        vlc.d r0 = (vlc.d) getDataCenter().get("data_message_manager", null);
        if (r0 != null) goto L5;
        return;
    L5:
        if (getRoom() == null) goto L9;
        this.e = new d91.a(r0, getRoom().getOwnerUserIdString(), new UserInfoAvatarElement$initEvents$1(this));
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        getDataCenter().removeObserver(this);
        b1 r0 = b1.a;
        if (r0.getValue() != null) goto L5;
    L13:
        this.h.clear();
        d91.a r1 = this.e;
        if (r1 == null) goto L16;
        r1.a.removeMessageListener(r1);
    L16:
        this.e = null;
        n91.c r2 = (n91.c) b().getElementInteractVm().getService(n91.c.class);     // Catch: Exception -> L46
        if (r2 == null) goto L20;
        View r3 = r2.getContentView();     // Catch: Exception -> L46
    L22:
        if (this.j == null) goto L51;
        if (r3 != null) goto L25;
        return;
    L25:
        if (r3.getParent() != null) goto L53;
        HSImageView r4 = this.j;     // Catch: Exception -> L46
        if (r4 == null) goto L29;
        Object r5 = r4.getTag(2131389795);     // Catch: Exception -> L46
    L30:
        if (r5 == null) goto L39;
        HSImageView r6 = this.j;     // Catch: Exception -> L46
        if (r6 == null) goto L34;
        Object r7 = r6.getTag(2131389795);     // Catch: Exception -> L46
    L35:
        if (r7 == null) goto L38;
        o((IBaseUser) r7);     // Catch: Exception -> L46
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");     // Catch: Exception -> L46
    L34:
        r7 = null;
    L39:
        HSImageView r8 = this.j;     // Catch: Exception -> L46
        if (r8 == null) goto L42;
        r8.setImageDrawable(null);     // Catch: Exception -> L46
    L42:
        HSImageView r9 = this.j;     // Catch: Exception -> L46
        if (r9 == null) goto L54;
        r9.setBackgroundDrawable(null);     // Catch: Exception -> L46
        return;
    L54:
        return;
    L29:
        r5 = null;
        goto L30
    L53:
        return;
    L51:
        return;
    L20:
        r3 = null;
    L46:
        e = move-exception;
        ALogger.e(this.f, e);
        return;
    L5:
        if (((e51) r0.getValue()).e() == false) goto L13;
        IRoom r10 = getRoom();
        if (r10 == null) goto L12;
        IBaseUser r12 = r10.getOwner();
        if (r12 == null) goto L50;
        int r13 = y.a;
        y.a(getDataCenter(), this.h, "logAnchorAvatar->onUnload", new b(r12));
        goto L13
    L50:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final String g() {
        return this.f;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r4) {
        ALogger.d(this.f, "onWidgetRoomEntered");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L8;
        if (r4 == null) goto L8;
        IBaseUser r0 = r4.getOwner();
        if (r0 == null) goto L8;
        p(r0);
    L8:
        IRoom r1 = this.g;
        if (r1 == null) goto L24;
        if (r4 == null) goto L24;
        IBaseUser r2 = r1.getOwner();
        IBaseUser r5 = r4.getOwner();
        if (r2 == null) goto L24;
        if (r5 == null) goto L24;
        py.k r3 = r2.getAvatarThumbKt();
        py.k r6 = r5.getAvatarThumbKt();
        if (r3 == null) goto L24;
        if (r6 == null) goto L24;
        if (r3.equalsOnlyUri(r6) == false) goto L24;
        boolean r7 = false;
    L25:
        s(r7, true);
        if (isAnchor() == true) goto L29;
    L36:
        DataCenter r8 = getDataCenter();
        Boolean r9 = Boolean.FALSE;
        if (((Boolean) r8.get("cmd_has_click_anchor_profile", r9)).booleanValue() == true) goto L39;
        return;
    L39:
        if (FirstCompShowConfig.INSTANCE.preloadClickUseful() == false) goto L43;
        ((UserInfoAvatarPresenter) this.i.getValue()).f(null);
        getDataCenter().put("cmd_has_click_anchor_profile", r9);
        return;
    L43:
        return;
    L29:
        if (getDataCenter() == null) goto L36;
        if (y3.m(getDataCenter()).n(ToolbarButton.GROUP_PURCHASE) == false) goto L35;
        ns0.a r10 = ns0.c.a();
        if (r10 == null) goto L35;
        r10.noticeGroupPurchaseShowing(this.j);
    L35:
        getDataCenter().observe("data_toolbar_visible", this);
    L24:
        r7 = true;
        goto L25
    }

    public final void o(IBaseUser r3) {
        if (r3 == null) goto L12;
        StringBuilder r0 = new StringBuilder("{\"uri\":\"");
        if (r3.getAvatarThumbKt() == null) goto L6;
        String r1 = String.valueOf(r3.getAvatarThumbKt());
    L7:
        r0.append(r1);
        r0.append("\",\"anchor_id\":\"");
        r0.append(r3.getIdString());
        r0.append("\",\"name\":\"");
        r0.append(r3.getNickName());
        r0.append("\",\"mUserHead visible\":\"");
        if (this.j.getVisibility() != 0) goto L10;
        String r4 = "VISIABLE";
    L11:
        r0.append(r4);
        r0.append("\"\"}");
        String r5 = r0.toString();
    L13:
        ALogger.e(this.f, r5);
        return;
    L10:
        r4 = "INVISIABLE";
        goto L11
    L6:
        r1 = "";
        goto L7
    L12:
        r5 = "null";
        goto L13
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (this.c.a() == false) goto L19;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L24;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1324558617) goto L12;
        return;
    L12:
        if (r0.equals("data_toolbar_visible") == true) goto L14;
        return;
    L14:
        if (TextUtils.equals((String) r5.getData(), "GROUP_PURCHASE") == false) goto L22;
        ns0.a r6 = ns0.c.a();
        if (r6 == null) goto L23;
        r6.noticeGroupPurchaseShowing(this.j);
        return;
    L23:
        return;
    L22:
        return;
    L24:
        return;
    }

    public final void p(IBaseUser r4) {
        b1 r0 = b1.a;
        if (r0.getValue() != null) goto L5;
    L6:
        int r1 = y.a;
        y.a(getDataCenter(), this.h, "logAnchorAvatar->updateUserInfo", new c(r4));
        return;
    L5:
        if (((e51) r0.getValue()).e() == false) goto L6;
    }

    public final void r(py.k r10) {
        HSImageView r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        int r5 = s1.f(51.0f);
        ImageLoader.bindImage(this.d, r10, null, r5, r5, null, null, true);
        return;
    L7:
        if (r0 == null) goto L11;
        r0.setImageDrawable(null);
        return;
    }

    public final void s(boolean r10, boolean r12) {
        if (this.c.a() == true) goto L5;
        return;
    L5:
        IRoom r0 = getRoom();
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getOwner();
    L9:
        o(r1);
        if (r1 == null) goto L72;
        if (r10 == false) goto L73;
        this.j.setTag(2131389795, r1);
        if (ImageUtil.isActivityOK(this.c.getContext()) == false) goto L59;
        if (this.c.getAvatarThumb() == null) goto L59;
        FirstCompShowConfig r13 = FirstCompShowConfig.INSTANCE;
        String r5 = "";
        if (r13.avatarUsePreloadData() == false) goto L26;
        DataCenter r4 = getDataCenter();
        if (r4 == null) goto L21;
        String r6 = (String) r4.get("log_action_type", "");
    L22:
        boolean r7 = TextUtils.equals("click", r6);
        if (r13.onlyPreloadClick() == true) goto L27;
        r7 = true;
    L27:
        if (r7 == false) goto L54;
        IRoom r14 = getRoom();
        if (r14 == null) goto L31;
        long r8 = r14.getRoomId();
        Map r15 = com.bytedance.android.live.base.h.a;
        String r16 = String.valueOf(r8);
        Intrinsics.checkNotNullParameter(r16, "roomId");
        py.k r17 = (py.k) ((LinkedHashMap) com.bytedance.android.live.base.h.a).get(r16);
    L33:
        if (r17 == null) goto L42;
        List r9 = r17.getUrls();
        if (r9 == null) goto L42;
        String r18 = (String) CollectionsKt.firstOrNull(r9);
        if (r18 == null) goto L42;
        String r19 = StringsKt.substringAfterLast$default(r18, "/", null, 2, null);
        if (r19 == null) goto L42;
        r5 = r19;
    L42:
        py.k r20 = this.c.getAvatarThumb();
        if (r20 == null) goto L49;
        List r22 = r20.getUrls();
        if (r22 == null) goto L49;
        String r23 = (String) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L49;
        String r24 = StringsKt.substringAfterLast$default(r23, "/", null, 2, null);
    L50:
        boolean r25 = r5.equals(r24);
        ALogger.d("RoomContainerPreloadBusiness", "preloadUrl  " + r5 + "  avatarUrl " + r24 + " isSameUrl " + r25 + ' ');
        if (r17 == null) goto L53;
        if (r25 == false) goto L53;
    L55:
        FrescoLoader r110 = FrescoLoader.with(this.c.getContext()).load(r17).placeholder(2131250965).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP);
        int r26 = s1.f(32.0f);
        r110.resize(r26, r26);
        r110.into(this.j);
        if (r12 == false) goto L59;
        p(r1);
    L53:
        r17 = this.c.getAvatarThumb();
    L49:
        r24 = null;
        goto L50
    L31:
        r17 = null;
        goto L33
    L54:
        r17 = this.c.getAvatarThumb();
        goto L55
    L21:
        r6 = null;
        goto L22
    L26:
        r7 = false;
    L59:
        if (((Number) com.bytedance.android.live.misc.f.a.getValue()).intValue() > 0) goto L61;
    L63:
        py.f r111 = r1.getBorder();
        if (r111 == null) goto L70;
        com.bytedance.android.live.profit.dress.a r112 = (com.bytedance.android.live.profit.dress.a) yt0.c.a().getDressData(r111.getDressId(), 1, this.f + ": updateUserInfo");
        if (r112 == null) goto L68;
        py.k r113 = r112.b;
    L69:
        r(r113);
        return;
    L68:
        r113 = r111.getDefaultIcon();
        goto L69
    L70:
        r(null);
        return;
    L61:
        if (this.c.getAvatarThumb() != null) goto L63;
        this.j.setActualImageResource(2131250965);
        goto L63
    L73:
        return;
    L72:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public UserInfoAvatarElement(final m91.d r2, HSImageView r3, HSImageView r4, HSImageView r5) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserHead");
        Intrinsics.checkNotNullParameter(r4, "oldAvatarBorder");
        Intrinsics.checkNotNullParameter(r5, "newAvatarBorder");
        super(r2);
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.f = "UserInfoAvatarElement";
        this.h = new CompositeDisposable();
        this.i = LazyKt.lazy(new UserInfoAvatarElement$presenter$2(r2));
    }
}
