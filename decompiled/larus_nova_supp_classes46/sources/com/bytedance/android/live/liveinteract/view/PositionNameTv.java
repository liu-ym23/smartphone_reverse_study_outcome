package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.h1;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import je0.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/PositionNameTv;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "c", "Z", "getViewIsTeamFightMode", "()Z", "setViewIsTeamFightMode", "(Z)V", "viewIsTeamFightMode", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "e", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PositionNameTv extends AppCompatTextView {
    public static String f;
    public final Context a;
    public final b b;
    public boolean c;
    public boolean d;
    public DataCenter e;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            IVoiceLiveTheme r2 = (IVoiceLiveTheme) r1;
        }
    }

    public PositionNameTv(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PositionNameTv(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        f = "#33000000";
    }

    public final boolean C() {
        if (this.c == false) goto L5;
    L8:
        return true;
    L5:
        if (h1.d() == true) goto L8;
        return false;
    }

    public final void D() {
        if ((this.a instanceof AppCompatActivity) == false) goto L15;
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L8:
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L11;
        x00.a r3 = r2.getThemeManager(r1, this.e);
    L12:
        if (r3 == null) goto L16;
        r3.j(this.a, this.b, 2);
        return;
    L16:
        return;
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = false;
        goto L8
    }

    public final void E() {
        if ((this.a instanceof AppCompatActivity) == false) goto L15;
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L8:
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L11;
        x00.a r3 = r2.getThemeManager(r1, this.e);
    L12:
        if (r3 == null) goto L16;
        r3.f(this.b, 2);
        return;
    L16:
        return;
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(ColorProtector.parseColor("#FE2C55"));
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(10));
        setBackground(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (d.u() == false) goto L6;
        D();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        if (d.u() == true) goto L5;
        return;
    L5:
        if (((Boolean) vm2.d.c7.getValue(null, vm2.d.a[415(0x19f, float:5.82E-43)])).booleanValue() == false) goto L9;
        E();
        return;
    }

    public final DataCenter getDataCenter() {
        return this.e;
    }

    public final boolean getViewIsTeamFightMode() {
        return this.c;
    }

    public static boolean A(ILinkPlayerInfoBridge r5) {
        if (r5 == null) goto L7;
        g0 r6 = r5.getMicPosTagInfo();
        if (r6 == null) goto L7;
        long r2 = r6.getTagTypeId();
    L9:
        if (r2 > 0) goto L17;
        ih0.b r0 = ((IInteractService) k.n(IInteractService.class)).dynamicService(null);
        if (r0 != null) goto L13;
    L15:
        return false;
    L13:
        if (r0.jl("adventure") != true) goto L15;
        return true;
    L17:
        return true;
    L7:
        r2 = 0;
        goto L9
    }

    public static boolean B(LinkmicPositionItem r8) {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        IBaseUser r3 = null;
        if (r0 == null) goto L24;
        i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L24;
        Iterable r2 = r1.getOnlineUserList();
        if (r2 == null) goto L24;
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        int r6 = ((ILinkPlayerInfoBridge) r5).getUserPositionFlex();
        if (r8 == null) goto L14;
        int r7 = (int) r8.getPosition();
    L15:
        if (r6 != r7) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L10;
    L21:
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r5;
        if (r10 == null) goto L24;
        r3 = r10.getUser();
        goto L24
    L17:
        r9 = false;
        goto L18
    L14:
        r7 = -1;
        goto L15
    L20:
        r5 = null;
    L24:
        if (r3 == null) goto L32;
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(String r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        f = r2;
        if (this.d == false) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(ColorProtector.parseColor(r2));
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(10));
        setBackground(r0);
    }

    public final void setDataCenter(DataCenter r1) {
        this.e = r1;
    }

    public final void setViewIsTeamFightMode(boolean r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PositionNameTv(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r2;
        this.b = b.a;
        setPadding(s1.f(2.0f), s1.f(1.0f), s1.f(2.0f), s1.f(1.0f));
        F(f);
        setTextSize(9.0f);
    }

    public /* synthetic */ PositionNameTv(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final boolean z(ILinkPlayerInfoBridge r4, int r5, List<Integer> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "guestInfo");
        Intrinsics.checkNotNullParameter(r6, "playModes");
        if (r4.getUser() == null) goto L8;
        if (InteractiveSongContext.Companion.f() == false) goto L8;
        return false;
    L8:
        if (ThemedCompetitionContext.Companion.g() == false) goto L16;
        if (r4.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L16;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.c() == true) goto L62;
        if (r7 == true) goto L65;
        return false;
    L65:
        return true;
    L62:
        return true;
    L16:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == false) goto L18;
    L19:
        String r8 = null;
        if (C() == false) goto L24;
        if (li0.d.g(null) == true) goto L24;
    L64:
        return false;
    L24:
        if (A(r4) == true) goto L64;
        if (d.P() == true) goto L64;
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == true) goto L64;
        Integer r9 = d.h();
        if (r9 != null) goto L33;
    L34:
        Integer r10 = d.h();
        if (r10 != null) goto L38;
    L51:
        Integer r11 = d.h();
        if (r11 != null) goto L55;
    L56:
        Integer r12 = d.h();
        if (r12 != null) goto L60;
        return true;
    L60:
        if (r12.intValue() == 30) goto L64;
        return true;
    L55:
        if (r11.intValue() == 28) goto L64;
    L38:
        if (r10.intValue() != 3) goto L51;
    L39:
        IBaseUser r13 = r4.getUser();
        if (r13 == null) goto L42;
        String r14 = r13.getIdString();
    L43:
        com.bytedance.live.datacontext.m r15 = m.i().getRoom();
        if (r15 == null) goto L49;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L49;
        r8 = r16.getOwnerUserIdString();
    L49:
        if (Intrinsics.areEqual(r14, r8) == false) goto L51;
    L42:
        r14 = null;
        goto L43
    L33:
        if (r9.intValue() == 6) goto L39;
    L18:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.b(r5, r6, r7, false) == false) goto L64;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(PositionNameTv r3, LinkmicPositionItem r4, boolean r5, int r6, List r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "playModes");
        if (InteractiveSongContext.Companion.f() == false) goto L8;
        if (B(r4) == false) goto L8;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L8:
        if (r6 != 25) goto L11;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L11:
        if (r6 != 29) goto L14;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L14:
        if (r6 != 15) goto L16;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L16:
        int r0 = c1.a;
        boolean r1 = false;
        if (c1.a(0, Integer.valueOf(r6)) == false) goto L20;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L20:
        if (ThemedCompetitionContext.Companion.g() == false) goto L29;
        if (r4 == null) goto L29;
        if (r4.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L29;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.c() == true) goto L54;
        if (r8 == true) goto L54;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L54:
        boolean r9 = k.n(IMiddlewareUserService.class).user().isAdmin();
        if (r4.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L57;
        r1 = true;
    L57:
        r3.d = r1;
        if (r5 == true) goto L61;
        if (r9 == true) goto L61;
    L64:
        if (TextUtils.isEmpty(r4.getActiveName()) == true) goto L66;
        r3.setText(r4.getActiveName());
        UtilityKotlinExtentionsKt.w(r3);
    L68:
        if (r3.getVisibility() == 0) goto L70;
        return;
    L70:
        if (r3.d == false) goto L72;
        r3.G();
        return;
    L72:
        r3.F(f);
        return;
    L66:
        UtilityKotlinExtentionsKt.t(r3);
    L61:
        if (r4.getVerifyStatus() != 1) goto L64;
        r3.setText(s1.B(2131918202));
        UtilityKotlinExtentionsKt.w(r3);
    L29:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == false) goto L31;
    L32:
        if (r4 != null) goto L34;
    L73:
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L34:
        if (r3.C() == false) goto L38;
        if (li0.d.g(null) == false) goto L73;
    L38:
        if (A(null) == true) goto L73;
        if (r6 == 7) goto L73;
        if (r6 == 110) goto L73;
        Integer r10 = d.h();
        if (r10 != null) goto L47;
    L48:
        Integer r11 = d.h();
        if (r11 == null) goto L54;
        if (r11.intValue() != 30) goto L54;
    L47:
        if (r10.intValue() == 28) goto L73;
    L31:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.b(r6, r7, r8, false) == false) goto L73;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x(PositionNameTv r4, ILinkPlayerInfoBridge r5, boolean r6, int r7, List r8, boolean r9, int r10) {
        boolean r1 = false;
        if ((r10 & 8) == 0) goto L9;
        Integer r11 = d.h();
        if (r11 == null) goto L7;
        r7 = r11.intValue();
        goto L9
    L7:
        r7 = 0;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        if ((r10 & 32) == 0) goto L14;
        r9 = false;
    L14:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "playModes");
        String r12 = null;
        if (r5 == null) goto L17;
        IBaseUser r0 = r5.getUser();
    L18:
        if (r0 == null) goto L23;
        if (InteractiveSongContext.Companion.f() == false) goto L23;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L23:
        if (r7 != 25) goto L26;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L26:
        if (r7 != 29) goto L28;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L28:
        int r2 = c1.a;
        if (c1.a(0, Integer.valueOf(r7)) == false) goto L31;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L31:
        ThemedCompetitionContext.a r3 = ThemedCompetitionContext.Companion;
        if (r3.g() == false) goto L41;
        if (r5 == null) goto L41;
        if (r5.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L41;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.c() == true) goto L124;
        if (r9 == true) goto L124;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L124:
        boolean r13 = k.n(IMiddlewareUserService.class).user().isAdmin();
        if (r5.getPositionType() != LinkmicPositionItem.LinkmicPositionType.PERFORMER.ordinal()) goto L127;
        boolean r14 = true;
    L128:
        r4.d = r14;
        if (r14 == false) goto L139;
        StringBuilder r15 = new StringBuilder("position = ");
        r15.append(Integer.valueOf(r5.getUserPosition()));
        r15.append(", activeName = ");
        r15.append(r5.getActiveName());
        r15.append(", enlarge = ");
        r15.append(Boolean.valueOf(r5.isEnlarged()));
        r15.append(", userId = ");
        IBaseUser r16 = r5.getUser();
        if (r16 == null) goto L133;
        String r17 = r16.getIdString();
    L134:
        r15.append(r17);
        r15.append(", nickName = ");
        IBaseUser r18 = r5.getUser();
        if (r18 == null) goto L137;
        String r19 = r18.getNickName();
    L138:
        r15.append(r19);
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.c.a("performerPositionBind", r15.toString());
        goto L139
    L137:
        r19 = null;
        goto L138
    L133:
        r17 = null;
    L139:
        if (r6 == true) goto L142;
        if (r13 == true) goto L142;
    L145:
        if (TextUtils.isEmpty(r5.getActiveName()) == true) goto L147;
        r4.setText(r5.getActiveName());
        UtilityKotlinExtentionsKt.w(r4);
    L149:
        if (r3.g() == false) goto L173;
        if (d.c() == null) goto L166;
        ILinkPlayerInfoBridge r20 = d.c();
        if (r20 == null) goto L157;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L157;
        String r22 = r21.getIdString();
    L158:
        com.bytedance.live.datacontext.m r23 = m.i().getRoom();
        if (r23 == null) goto L164;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L164;
        r12 = r24.getOwnerUserIdString();
    L164:
        if ((!Intrinsics.areEqual(r22, r12)) == false) goto L166;
        r1 = true;
    L157:
        r22 = null;
    L166:
        if (r1 == false) goto L173;
        if (r4.d == false) goto L173;
        if (r5.isEnlarged() == true) goto L173;
        r4.setVisibility(8);
    L173:
        if (r4.getVisibility() == 0) goto L175;
        return;
    L175:
        if (r4.d == false) goto L177;
        r4.G();
        return;
    L177:
        r4.F(f);
        return;
    L147:
        UtilityKotlinExtentionsKt.t(r4);
    L142:
        if (r5.getVerifyStatus() != 1) goto L145;
        r4.setText(s1.B(2131918202));
        UtilityKotlinExtentionsKt.w(r4);
        goto L149
    L127:
        r14 = false;
    L41:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == false) goto L43;
    L44:
        if (r5 != null) goto L46;
    L178:
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L46:
        if (r4.C() == false) goto L50;
        if (li0.d.g(null) == false) goto L178;
    L50:
        if (A(r5) == true) goto L178;
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == true) goto L178;
        Integer r25 = d.h();
        if (r25 != null) goto L57;
    L72:
        Integer r26 = d.h();
        if (r26 != null) goto L76;
    L89:
        Integer r27 = d.h();
        if (r27 != null) goto L93;
    L94:
        Integer r28 = d.h();
        if (r28 != null) goto L98;
    L113:
        Integer r29 = d.h();
        if (r29 != null) goto L117;
    L118:
        Integer r30 = d.h();
        if (r30 == null) goto L124;
        if (r30.intValue() != 30) goto L124;
    L117:
        if (r29.intValue() == 28) goto L178;
    L98:
        if (r28.intValue() != 112) goto L113;
    L99:
        IBaseUser r31 = r5.getUser();
        if (r31 == null) goto L102;
        String r32 = r31.getIdString();
    L103:
        com.bytedance.live.datacontext.m r33 = m.i().getRoom();
        if (r33 == null) goto L108;
        IRoom r34 = (IRoom) r33.getValue();
        if (r34 == null) goto L108;
        String r35 = r34.getOwnerUserIdString();
    L110:
        if (Intrinsics.areEqual(r32, r35) == false) goto L113;
        if (r5.isEnlarged() == false) goto L178;
    L108:
        r35 = null;
        goto L110
    L102:
        r32 = null;
        goto L103
    L93:
        if (r27.intValue() == 6) goto L99;
    L76:
        if (r26.intValue() != 43) goto L89;
        IBaseUser r36 = r5.getUser();
        if (r36 == null) goto L80;
        String r37 = r36.getIdString();
    L81:
        com.bytedance.live.datacontext.m r38 = m.i().getRoom();
        if (r38 == null) goto L86;
        IRoom r39 = (IRoom) r38.getValue();
        if (r39 == null) goto L86;
        String r40 = r39.getOwnerUserIdString();
    L88:
        if (Intrinsics.areEqual(r37, r40) == true) goto L178;
    L86:
        r40 = null;
        goto L88
    L80:
        r37 = null;
        goto L81
    L57:
        if (r25.intValue() != 3) goto L72;
        IBaseUser r41 = r5.getUser();
        if (r41 == null) goto L61;
        String r42 = r41.getIdString();
    L62:
        com.bytedance.live.datacontext.m r43 = m.i().getRoom();
        if (r43 == null) goto L67;
        IRoom r44 = (IRoom) r43.getValue();
        if (r44 == null) goto L67;
        String r45 = r44.getOwnerUserIdString();
    L69:
        if (Intrinsics.areEqual(r42, r45) == false) goto L72;
        if (r5.isEnlarged() == false) goto L178;
    L67:
        r45 = null;
        goto L69
    L61:
        r42 = null;
        goto L62
    L43:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.b(r7, r8, r9, false) == false) goto L178;
    L17:
        r0 = null;
        goto L18
    }
}
