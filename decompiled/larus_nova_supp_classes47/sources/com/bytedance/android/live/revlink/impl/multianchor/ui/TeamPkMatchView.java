package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gd0.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/TeamPkMatchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "battleConfigSetting", "", "setBattleConfigSetting", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/a;", "changeTeamSupportCallback", "setChangeTeamSupportCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "Gender", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamPkMatchView extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a a;
    public com.bytedance.android.live.revlink.impl.multianchor.ui.a b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final ImageView i;
    public final HSImageView j;
    public boolean k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/TeamPkMatchView$Gender;", "", "MALE", "FEMALE", "UNKNOWN", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Gender extends Enum<Gender> {
        public static final Gender FEMALE = null;
        public static final Gender MALE = null;
        public static final Gender UNKNOWN = null;
        public static final /* synthetic */ Gender[] a = null;

        static {
            Gender r1 = new Gender("MALE", 0);
            MALE = r1;
            Gender r2 = new Gender("FEMALE", 1);
            FEMALE = r2;
            Gender r3 = new Gender("UNKNOWN", 2);
            UNKNOWN = r3;
            a = new Gender[]{r1, r2, r3};
        }

        public static Gender valueOf(String r1) {
            return (Gender) r27.a.a(Gender.class, r1);
        }

        public static Gender[] values() {
            return (Gender[]) a.clone();
        }

        public Gender(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final py.k a;
        public final String b;
        public final int c;
        public boolean d;
        public boolean e;
        public final int f;
        public final IBaseUser g;
        public final boolean h;

        public b(py.k r2, String r3, Gender r4, int r5, boolean r6, boolean r7, int r8, IBaseUser r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r2, "avatar");
            Intrinsics.checkNotNullParameter(r3, "nickName");
            Intrinsics.checkNotNullParameter(r4, "gender");
            Intrinsics.checkNotNullParameter(r9, "user");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TeamPkMatchView a;
        public final /* synthetic */ b b;

        public c(TeamPkMatchView r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            TeamPkMatchView r1 = this.a;
            IBaseUser r2 = this.b.g;
            int r3 = TeamPkMatchView.l;
            r1.getClass();
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r4 == null) goto L5;
            int r5 = r4.getCurrentMode();
        L6:
            long r7 = 0;
            if (v.a(r5, 64) == false) goto L17;
            com.bytedance.android.live.revlink.impl.multianchor.service.a r6 = r1.a;
            if (r6 == null) goto L27;
            com.bytedance.android.live.revenuelink.connect.n r8 = r6.getLinkOutManagerFn();
            if (r8 == null) goto L28;
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r9 = com.bytedance.android.live.revlink.impl.global.b.u();
            if (r9 == null) goto L15;
            r7 = r9.a();
        L15:
            long r13 = r2.getLiveRoomId();
            String r15 = iz.a.a(r2);
            Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
            r8.e(new d11.c(7, r7, r13, r15, r2.getCastSecUid(), 0, "ceiling_view_canel_individual"), null);
            return;
        L28:
            return;
        L27:
            return;
        L17:
            if (v.a(r5, 4) == false) goto L30;
            com.bytedance.android.live.revlink.impl.pk.service.b r10 = com.bytedance.android.live.revlink.impl.global.b.N();
            if (r10 == null) goto L31;
            com.bytedance.android.live.revenuelink.connect.n r12 = r10.getLinkOutManagerFn();
            if (r12 == null) goto L32;
            LinkCrossRoomDataHolder r14 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r14 == null) goto L25;
            r7 = r14.c();
        L25:
            long r16 = r2.getLiveRoomId();
            String r17 = iz.a.a(r2);
            Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
            r12.e(new d11.c(1, r7, r16, r17, r2.getCastSecUid(), 0, "ceiling_view_canel_individual"), null);
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    static {
        int r0 = r41.c.a;
        py.k r1 = vh7.f.c(py.k.class);
        Gender r2 = Gender.UNKNOWN;
        IBaseUser r3 = vh7.f.c(IBaseUser.class);
        Intrinsics.checkNotNullParameter(r1, "avatar");
        Intrinsics.checkNotNullParameter("", "nickName");
        Intrinsics.checkNotNullParameter(r2, "gender");
        Intrinsics.checkNotNullParameter(r3, "user");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TeamPkMatchView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = com.bytedance.android.live.revlink.impl.global.b.t();
        this.k = true;
        setWillNotDraw(false);
        LayoutInflater.from(getContext()).inflate(2131567497, this);
        this.c = (LinearLayout) findViewById(2131388297);
        this.d = (LinearLayout) findViewById(2131388299);
        this.e = (LinearLayout) findViewById(2131388298);
        this.f = (LinearLayout) findViewById(2131388300);
        this.g = (LinearLayout) findViewById(2131388302);
        this.h = (LinearLayout) findViewById(2131388301);
        this.i = (ImageView) findViewById(2131388303);
        this.j = findViewById(2131378321);
    }

    public static void S5(List r5) {
        ArrayList r0 = (ArrayList) r5;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        int r1 = r0.size() - 1;
        int r2 = r5.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        if (((b) ListProtector.get(r5, r3)).h == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        r1 = r3;
    L12:
        if (r1 == (r0.size() - 1)) goto L17;
        Collections.swap(r5, r0.size() - 1, r1);
        return;
    }

    public static void T5(List r4) {
        if (((ArrayList) r4).isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r4.size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (((b) ListProtector.get(r4, r2)).h == true) goto L12;
        r2 = r2 + 1;
    L12:
        if (r2 == 0) goto L17;
        Collections.swap(r4, 0, r2);
        return;
    L17:
        return;
    L11:
        r2 = 0;
        goto L12
    }

    public final void setBattleConfigSetting(IBattleConfigSetting r9) {
        if (r9 == null) goto L14;
        if (r9.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L14;
        ImageView r10 = this.i;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L9:
        r10.setImageResource(2131251475);
        ImageView r12 = this.i;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L12:
        UIUtils.updateLayout(r12, UtilityKotlinExtentionsKt.i(36), UtilityKotlinExtentionsKt.i(17));
        return;
    L14:
        if (r9 == null) goto L18;
        w2 r5 = r9.getShellConfig();
        if (r5 == null) goto L18;
        long r6 = r5.getType();
    L20:
        if (r6 <= 0) goto L38;
        if (r9 == null) goto L38;
        w2 r13 = r9.getShellConfig();
        if (r13 == null) goto L38;
        String r14 = r13.getName();
        if (r14 == null) goto L38;
        if (r14.length() <= 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 != true) goto L38;
        ImageView r16 = this.i;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L34:
        r16.setImageResource(2131251543);
        ImageView r17 = this.i;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L37:
        UIUtils.updateLayout(r17, UtilityKotlinExtentionsKt.i(36), UtilityKotlinExtentionsKt.i(17));
        return;
    L29:
        r15 = false;
    L38:
        ImageView r18 = this.i;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L41:
        r18.setImageResource(2131251542);
        ImageView r19 = this.i;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L44:
        UIUtils.updateLayout(r19, UtilityKotlinExtentionsKt.i(30), UtilityKotlinExtentionsKt.i(18));
        return;
    L18:
        r6 = 0;
        goto L20
    }

    public final void setChangeTeamSupportCallback(com.bytedance.android.live.revlink.impl.multianchor.ui.a r2) {
        Intrinsics.checkNotNullParameter(r2, "changeTeamSupportCallback");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TeamPkMatchView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = com.bytedance.android.live.revlink.impl.global.b.t();
        this.k = true;
        setWillNotDraw(false);
        LayoutInflater.from(getContext()).inflate(2131567497, this);
        this.c = (LinearLayout) findViewById(2131388297);
        this.d = (LinearLayout) findViewById(2131388299);
        this.e = (LinearLayout) findViewById(2131388298);
        this.f = (LinearLayout) findViewById(2131388300);
        this.g = (LinearLayout) findViewById(2131388302);
        this.h = (LinearLayout) findViewById(2131388301);
        this.i = (ImageView) findViewById(2131388303);
        this.j = findViewById(2131378321);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(List r20, List r22) {
        Intrinsics.checkNotNullParameter(r20, "team1");
        Intrinsics.checkNotNullParameter(r22, "team2");
        LinearLayout r3 = this.d;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L5:
        r3.removeAllViews();
        LinearLayout r4 = this.e;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L8:
        r4.removeAllViews();
        LinearLayout r5 = this.g;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L11:
        r5.removeAllViews();
        LinearLayout r6 = this.h;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L14:
        r6.removeAllViews();
        this.k = false;
        com.bytedance.android.live.revlink.impl.multianchor.ui.a r8 = this.b;
        if (r8 == null) goto L17;
        boolean r9 = r8.Zl();
    L18:
        if (r9 == false) goto L20;
        S5(r20);
        S5(r22);
    L21:
        ArrayList r10 = (ArrayList) r20;
        ArrayList r12 = (ArrayList) r22;
        if ((r10.size() + r12.size()) <= 6) goto L27;
        HSImageView r13 = this.j;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("bgImage");
    L26:
        r13.setActualImageResource(2131250004);
    L31:
        List r14 = CollectionsKt.plus(r20, r22);
        if (r14.size() > 4) goto L34;
        int r15 = UtilityKotlinExtentionsKt.i(50);
    L35:
        boolean r16 = true;
        if (r10.size() != 1) goto L41;
        if (((b) ListProtector.get(r20, 0)).h == false) goto L41;
    L44:
        r16 = false;
    L46:
        if (r14.size() > 6) goto L85;
        LinearLayout r17 = this.d;
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L50:
        r17.setVisibility(0);
        LinearLayout r18 = this.g;
        if (r18 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L53:
        r18.setVisibility(0);
        LinearLayout r19 = this.e;
        if (r19 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L56:
        r19.setVisibility(8);
        LinearLayout r23 = this.h;
        if (r23 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L59:
        r23.setVisibility(8);
        LinearLayout r7 = this.c;
        if (r7 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("leftContainer");
    L62:
        ViewGroup.LayoutParams r24 = r7.getLayoutParams();
        if (r24 == null) goto L84;
        ((LinearLayout.LayoutParams) r24).weight = r10.size();
        LinearLayout r25 = this.f;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
    L67:
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L82;
        ((LinearLayout.LayoutParams) r26).weight = r12.size();
        int r27 = r10.size();
        int r28 = 0;
    L70:
        if (r28 >= r27) goto L75;
        LinearLayout r29 = this.d;
        if (r29 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L74:
        R5(r29, (b) ListProtector.get(r20, r28), r15, r16);
        r28 = r28 + 1;
        goto L70
    L75:
        int r1 = r12.size();
        int r30 = 0;
    L76:
        if (r30 >= r1) goto L205;
        LinearLayout r32 = this.g;
        if (r32 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L80:
        R5(r32, (b) ListProtector.get(r22, r30), r15, r16);
        r30 = r30 + 1;
        goto L76
    L205:
        return;
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L84:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L85:
        LinearLayout r33 = this.d;
        if (r33 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L88:
        r33.setVisibility(0);
        LinearLayout r34 = this.g;
        if (r34 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L91:
        r34.setVisibility(0);
        LinearLayout r35 = this.e;
        if (r35 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L94:
        r35.setVisibility(0);
        LinearLayout r36 = this.h;
        if (r36 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L97:
        r36.setVisibility(0);
        int r37 = Math.max(r10.size(), r12.size());
        int r110 = 0;
    L98:
        if (r110 >= r37) goto L137;
        int r111 = r37;
        if (r110 >= r10.size()) goto L117;
        LinearLayout r38 = this.d;
        if (r38 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L104:
        int r39 = r38.getChildCount();
        ArrayList r112 = r10;
        LinearLayout r40 = this.g;
        if (r40 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L108:
        if ((r39 + r40.getChildCount()) >= 6) goto L113;
        LinearLayout r42 = this.d;
        if (r42 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L112:
        R5(r42, (b) ListProtector.get(r20, r110), r15, r16);
    L119:
        if (r110 >= r12.size()) goto L136;
        LinearLayout r43 = this.d;
        if (r43 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L123:
        int r44 = r43.getChildCount();
        LinearLayout r45 = this.g;
        if (r45 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L127:
        if ((r44 + r45.getChildCount()) >= 6) goto L132;
        LinearLayout r46 = this.g;
        if (r46 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L131:
        R5(r46, (b) ListProtector.get(r22, r110), r15, r16);
        goto L136
    L132:
        LinearLayout r47 = this.h;
        if (r47 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L135:
        R5(r47, (b) ListProtector.get(r22, r110), r15, r16);
    L136:
        r110 = r110 + 1;
        r37 = r111;
        r10 = r112;
        goto L98
    L113:
        LinearLayout r48 = this.e;
        if (r48 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L116:
        R5(r48, (b) ListProtector.get(r20, r110), r15, r16);
        goto L119
    L117:
        r112 = r10;
        goto L119
    L137:
        LinearLayout r2 = this.d;
        if (r2 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L140:
        int r49 = r2.getChildCount();
        LinearLayout r50 = this.e;
        if (r50 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L144:
        if (r49 <= r50.getChildCount()) goto L155;
        LinearLayout r52 = this.e;
        if (r52 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L148:
        View r53 = new View(getContext());
        LinearLayout.LayoutParams r54 = new LinearLayout.LayoutParams(0, 0);
        LinearLayout r113 = this.d;
        if (r113 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L151:
        int r114 = r113.getChildCount();
        LinearLayout r115 = this.e;
        if (r115 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("leftBottomContainer");
    L154:
        r54.weight = r114 - r115.getChildCount();
        r54.gravity = 17;
        Unit r55 = Unit.INSTANCE;
        r52.addView(r53, r54);
    L155:
        LinearLayout r56 = this.g;
        if (r56 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L158:
        int r57 = r56.getChildCount();
        LinearLayout r58 = this.h;
        if (r58 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L162:
        if (r57 <= r58.getChildCount()) goto L173;
        LinearLayout r59 = this.h;
        if (r59 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L166:
        View r60 = new View(getContext());
        LinearLayout.LayoutParams r62 = new LinearLayout.LayoutParams(0, 0);
        LinearLayout r63 = this.g;
        if (r63 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L169:
        int r64 = r63.getChildCount();
        LinearLayout r116 = this.h;
        if (r116 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("rightBottomContainer");
    L172:
        r62.weight = r64 - r116.getChildCount();
        r62.gravity = 17;
        Unit r65 = Unit.INSTANCE;
        r59.addView(r60, 0, r62);
    L173:
        LinearLayout r66 = this.c;
        if (r66 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("leftContainer");
    L176:
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();
        if (r67 == null) goto L194;
        LinearLayout.LayoutParams r68 = (LinearLayout.LayoutParams) r67;
        LinearLayout r69 = this.d;
        if (r69 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("leftTopContainer");
    L181:
        r68.weight = r69.getChildCount();
        LinearLayout r70 = this.f;
        if (r70 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
    L184:
        ViewGroup.LayoutParams r72 = r70.getLayoutParams();
        if (r72 == null) goto L192;
        LinearLayout.LayoutParams r73 = (LinearLayout.LayoutParams) r72;
        LinearLayout r74 = this.g;
        if (r74 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("rightTopContainer");
    L189:
        r73.weight = r74.getChildCount();
        return;
    L192:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L194:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L41:
        if (r12.size() != 1) goto L46;
        if (((b) ListProtector.get(r22, 0)).h == false) goto L46;
    L34:
        r15 = UtilityKotlinExtentionsKt.i(40);
        goto L35
    L27:
        HSImageView r75 = this.j;
        if (r75 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bgImage");
    L30:
        r75.setActualImageResource(2131250003);
        goto L31
    L20:
        T5(r20);
        T5(r22);
        goto L21
    L17:
        r9 = false;
        goto L18
    }

    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        HSImageView r5 = this.j;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgImage");
    L5:
        if (r5 == null) goto L8;
        r5.measure(View.MeasureSpec.makeMeasureSpec(s1.f(375.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(s1.f(111.0f), 1073741824));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TeamPkMatchView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = com.bytedance.android.live.revlink.impl.global.b.t();
        this.k = true;
        setWillNotDraw(false);
        LayoutInflater.from(getContext()).inflate(2131567497, this);
        this.c = (LinearLayout) findViewById(2131388297);
        this.d = (LinearLayout) findViewById(2131388299);
        this.e = (LinearLayout) findViewById(2131388298);
        this.f = (LinearLayout) findViewById(2131388300);
        this.g = (LinearLayout) findViewById(2131388302);
        this.h = (LinearLayout) findViewById(2131388301);
        this.i = (ImageView) findViewById(2131388303);
        this.j = findViewById(2131378321);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(LinearLayout r10, b r12, int r13, boolean r14) {
        TeamPkItemView r0 = new TeamPkItemView(getContext());
        r0.setChangeTeamSupportCallback(this.b);
        int r3 = 0;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(0, -2);
        float r2 = 1.0f;
        r1.weight = 1.0f;
        r1.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r10.addView(r0, r1);
        if (r12 == null) goto L89;
        boolean r5 = true;
        if (this.k == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r6 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r6 == null) goto L12;
        if (r6.Qd() == true) goto L16;
    L12:
        if (r12.d == false) goto L14;
    L15:
        boolean r7 = true;
    L17:
        c r8 = new c(this, r12);
        Intrinsics.checkNotNullParameter(r12, "itemInfo");
        Intrinsics.checkNotNullParameter(r8, "onCloseClickListener");
        HSImageView r9 = r0.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("imageAvatarBound");
    L20:
        r9.setVisibility(0);
        HSImageView r15 = r0.b;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("imageAvatar");
    L23:
        ImageUtil.loadRoundImage(r15, r12.a);
        r15.setVisibility(0);
        TextView r16 = r0.c;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("tvNickname");
    L26:
        r16.setText(r12.b);
        r16.setAlpha(1.0f);
        View r17 = r0.f;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("changeTeamClickArea");
    L29:
        if (r14 == true) goto L32;
        r2 = 0.4f;
    L32:
        r17.setAlpha(r2);
        HSImageView r18 = r0.b;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("imageAvatar");
    L35:
        UIUtils.updateLayout(r18, r13, r13);
        boolean r19 = r12.h;
        HSImageView r110 = r0.g;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L38:
        r110.setSelected(false);
        TextView r111 = r0.h;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L41:
        r111.setSelected(false);
        if (r19 == false) goto L58;
        HSImageView r112 = r0.g;
        if (r112 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L47:
        if (r112.isSelected() == true) goto L67;
        TextView r113 = r0.h;
        if (r113 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L52:
        if (r113.isSelected() == true) goto L67;
        View r114 = r0.f;
        if (r114 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("changeTeamClickArea");
    L57:
        r114.setVisibility(0);
    L62:
        View r115 = r0.f;
        if (r115 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("changeTeamClickArea");
    L65:
        r115.setOnClickListener(new t(r0));
    L67:
        if (r12.f == 1) goto L70;
        r5 = false;
    L70:
        TextView r116 = r0.d;
        if (r116 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
    L74:
        if (r5 == false) goto L76;
        int r20 = 0;
    L77:
        r116.setVisibility(r20);
        if (r12.c != 4) goto L80;
        int r117 = 2131914812;
    L81:
        r116.setText(r117);
        VHeadView r118 = r0.e;
        if (r118 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L84:
        if (r5 == false) goto L87;
        if (r7 == false) goto L87;
    L88:
        r118.setVisibility(r3);
        r118.setOnClickListener(r8);
        return;
    L87:
        r3 = 8;
        goto L88
    L80:
        r117 = 2131914827;
        goto L81
    L76:
        r20 = 8;
        goto L77
    L58:
        View r119 = r0.f;
        if (r119 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("changeTeamClickArea");
    L61:
        r119.setVisibility(4);
        goto L62
    L14:
        if (r12.e == true) goto L15;
    L16:
        r7 = false;
        goto L17
    L89:
        r0.setVisibility(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        ImageView r6 = this.i;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L5:
        int r7 = r6.getLeft();
        ImageView r8 = this.i;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vsImage");
    L8:
        int r9 = r7 + (r8.getWidth() / 2);
        HSImageView r10 = this.j;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bgImage");
    L11:
        if (r10 == null) goto L14;
        float r12 = r9;
        r10.layout((int) (r12 - (getWidth() / 2.0f)), 0, (int) (r12 + (getWidth() / 2.0f)), getHeight());
        return;
    }
}
