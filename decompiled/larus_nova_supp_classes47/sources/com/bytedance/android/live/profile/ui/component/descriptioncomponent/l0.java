package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.DressVisitorInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.VisitorStatistic;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 extends com.bytedance.android.live.profile.ui.base.k {
    public ImageView b;
    public TextView c;
    public TextView d;
    public SimpleIndicatorTextSwitcher e;
    public View f;
    public View g;
    public View h;
    public Context i;
    public Disposable j;
    public Disposable k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final com.bytedance.android.live.profile.ui.base.h q;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ l0 a;

        public a(l0 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.profile.model.a r6 = (com.bytedance.android.live.profile.model.a) r5;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.a != EnterExitStateType.ENTER_END) goto L23;
            Disposable r7 = this.a.k;
            Disposable r0 = null;
            if (r7 != null) goto L10;
        L15:
            this.a.k = Observable.timer(1, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k0(this));
            Disposable r8 = this.a.j;
            if (r8 != null) goto L18;
            return;
        L18:
            if ((!r8.isDisposed()) == false) goto L20;
            r0 = r8;
        L20:
            if (r0 == null) goto L25;
            r0.dispose();
            return;
        L25:
            return;
        L10:
            if ((!r7.isDisposed()) == true) goto L13;
            r7 = null;
        L13:
            if (r7 == null) goto L15;
            r7.dispose();
            goto L15
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ l0 a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ NewProfileUser c;

        public b(l0 r1, HashMap r2, NewProfileUser r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            String r1 = null;
            this.a.q.recordBusinessClick("visitor_entrance", null);
            if (this.a.getContext() == null) goto L37;
            boolean r2 = false;
            this.a.q.sendLog("livesdk_profile_card_visitor_entrance_click", this.b, new Object[0]);
            l0 r12 = this.a;
            Context r0 = r12.getContext();
            NewProfileUser r3 = this.c;
            if (r0 == null) goto L38;
            DressVisitorInfo r4 = r3.dressVisitorInfo;
            String r5 = "";
            if (r4 == null) goto L11;
            String r6 = r4.jumpSchema;
            if (r6 == null) goto L11;
        L12:
            Uri r7 = UriProtector.parse(r6);
            String r8 = UriProtector.getQueryParameter(r7, "url");
            if (r8 != null) goto L15;
            r8 = "";
        L15:
            Uri.Builder r9 = UriProtector.parse(r8).buildUpon();
            DressSuitInfo r13 = r3.getDressSuitInfo();
            if (r13 == null) goto L18;
            String r14 = r13.getUserSuitId();
        L19:
            if (r14 != null) goto L21;
        L22:
            r2 = true;
        L23:
            if (r2 == false) goto L25;
            r1 = "none";
        L29:
            r9.appendQueryParameter("package_id", r1);
            UserProfileEvent r15 = r12.q.getUserProfileEvent();
            if (r15 == null) goto L35;
            String r16 = r15.mClickUserPosition;
            if (r16 == null) goto L35;
            r5 = r16;
        L35:
            r9.appendQueryParameter("click_user_position", r5);
            jc1.k.n(IBaseLiveActionHandler.class).handle(r0, i2.e(r7, "url").buildUpon().appendQueryParameter("url", r9.build().toString()).build().toString());
            return;
        L25:
            DressSuitInfo r17 = r3.getDressSuitInfo();
            if (r17 == null) goto L28;
            r1 = r17.getUserSuitId();
        L28:
            Intrinsics.checkNotNull(r1);
            goto L29
        L21:
            if (r14.length() != 0) goto L23;
        L18:
            r14 = null;
        L11:
            r6 = "";
            goto L12
        L38:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ l0 a;
        public final /* synthetic */ HashMap b;

        public c(l0 r1, HashMap r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.q.recordBusinessClick("visitor_entrance", null);
            f2.b(2131921755, 0);
            this.a.q.sendLog("livesdk_profile_card_visitor_entrance_click", this.b, new Object[0]);
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.j;
        Disposable r1 = null;
        if (r0 != null) goto L5;
    L10:
        Disposable r2 = this.k;
        if (r2 != null) goto L13;
        return;
    L13:
        if ((!r2.isDisposed()) == false) goto L15;
        r1 = r2;
    L15:
        if (r1 == null) goto L19;
        r1.dispose();
        return;
    L19:
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.VisitorCount.INSTANCE;
    }

    public final Context getContext() {
        return this.i;
    }

    public l0(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.q = r2;
        this.l = "entrance_type";
        this.m = "red_dot";
        this.n = "visitor_number";
        this.o = "click_user_position";
        this.p = "package_id";
    }

    public static String j(long r7) {
        if (r7 <= 9999) goto L10;
        double r8 = Math.round((r7 / ((double) 10000)) * ((double) 100)) / 100.0d;
        if ((r8 % ((double) 1)) == 0.0d) goto L11;
        StringBuilder r1 = new StringBuilder();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        r1.append(StringsKt.trimEnd(StringsKt.trimEnd(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r8)}, 1)), new char[]{'0'}), new char[]{'.'}));
        r1.append("万");
        return r1.toString();
    L11:
        return String.valueOf((int) r8) + "万";
    L10:
        return String.valueOf(r7);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        this.i = r3.getContext();
        if (ProfilePreInflateUtil.a() == false) goto L5;
        View r4 = ((com.bytedance.android.live.profile.ui.base.e) r3).b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_VISITOR_COUNT, true);
    L6:
        View r0 = null;
        if (r4 == null) goto L9;
        SimpleIndicatorTextSwitcher r1 = (SimpleIndicatorTextSwitcher) r4.findViewById(2131389891);
    L10:
        this.e = r1;
        if (r4 == null) goto L13;
        ImageView r2 = (ImageView) r4.findViewById(2131389711);
    L14:
        this.b = r2;
        if (r4 == null) goto L17;
        TextView r5 = (TextView) r4.findViewById(2131389893);
    L18:
        this.c = r5;
        if (r4 == null) goto L21;
        TextView r6 = (TextView) r4.findViewById(2131389895);
    L22:
        this.d = r6;
        if (r4 == null) goto L25;
        View r7 = r4.findViewById(2131389759);
    L26:
        this.f = r7;
        if (r4 == null) goto L29;
        View r8 = r4.findViewById(2131389892);
    L30:
        this.g = r8;
        if (r4 == null) goto L33;
        r0 = r4.findViewById(2131389894);
    L33:
        this.h = r0;
        SimpleIndicatorTextSwitcher r9 = this.e;
        if (r9 == null) goto L37;
        r9.setAnimateFirstView(false);
        return;
    L37:
        return;
    L29:
        r8 = null;
        goto L30
    L25:
        r7 = null;
        goto L26
    L21:
        r6 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r2 = null;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r4 = ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567213, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        this.q.recordBusinessShow(TrackArea.TopWhiteArea, "visitor_entrance");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r17) {
        Intrinsics.checkNotNullParameter(r17, "user");
        ProfileSkin r3 = r17.mProfileSkin;
        if (r3 == null) goto L7;
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L7;
        String r5 = r4.visitorButtonColor;
    L8:
        View r6 = this.g;
        if (r6 == null) goto L11;
        com.bytedance.android.live.profile.ui.util.m.f(r6, r5);
    L11:
        HashMap r7 = new HashMap();
        String r8 = this.o;
        UserProfileEvent r9 = this.q.getUserProfileEvent();
        if (r9 == null) goto L15;
        String r10 = r9.mClickUserPosition;
        if (r10 == null) goto L15;
    L16:
        r7.put(r8, r10);
        String r12 = this.p;
        DressSuitInfo r13 = r17.getDressSuitInfo();
        if (r13 == null) goto L19;
        String r14 = r13.getUserSuitId();
    L21:
        if (r14 != null) goto L23;
    L26:
        boolean r15 = true;
    L27:
        if (r15 == false) goto L29;
        String r16 = "none";
    L34:
        r7.put(r12, r16);
        DressVisitorInfo r18 = r17.dressVisitorInfo;
        if (r18 == null) goto L37;
        Integer r19 = Integer.valueOf(r18.buttonStatus);
    L38:
        if (r19 == null) goto L46;
        if (r19.intValue() != 0) goto L46;
        View r1 = this.g;
        if (r1 == null) goto L175;
        r1.setVisibility(8);
    L175:
        this.q.sendLog("livesdk_profile_card_visitor_entrance_show", r7, new Object[0]);
        return;
    L46:
        if (r19 != null) goto L49;
    L153:
        if (r19 == null) goto L175;
        if (r19.intValue() != 2) goto L175;
        r7.put(this.m, DataType.FALSE);
        r7.put(this.l, "unavailable");
        String r2 = this.n;
        DressVisitorInfo r20 = r17.dressVisitorInfo;
        if (r20 == null) goto L162;
        VisitorStatistic r22 = r20.visitorStatistic;
        if (r22 == null) goto L162;
        long r23 = r22.visitorCount;
    L163:
        r7.put(r2, String.valueOf(r23));
        ImageView r24 = this.b;
        if (r24 == null) goto L166;
        r24.setVisibility(0);
    L166:
        TextView r25 = this.d;
        if (r25 == null) goto L169;
        r25.setVisibility(0);
    L169:
        TextView r26 = this.d;
        if (r26 == null) goto L172;
        r26.setText(s1.B(2131921757));
    L172:
        View r27 = this.g;
        if (r27 == null) goto L175;
        r27.setOnClickListener(new c(this, r7));
    L162:
        r23 = 0;
        goto L163
    L49:
        if (r19.intValue() != 1) goto L153;
        com.bytedance.android.live.profile.ui.util.w.a r28 = com.bytedance.android.live.profile.ui.util.w.a;
        Context r110 = this.i;
        r28.getClass();
        if (r110 != null) goto L54;
    L56:
        boolean r111 = false;
    L57:
        if (r111 == false) goto L68;
        TextView r29 = this.c;
        if (r29 == null) goto L61;
        r29.setVisibility(0);
    L61:
        View r30 = this.f;
        if (r30 == null) goto L64;
        r30.setVisibility(0);
    L64:
        TextView r32 = this.c;
        if (r32 == null) goto L67;
        r32.setText(s1.B(2131921756));
    L67:
        r7.put(this.l, "unlock");
        SharedPrefHelper r33 = SharedPrefHelper.b(this.i);
        r33.l("live.pref.PREF_PROFILE_VISITOR_COUNT_ENTRANCE_FIRST_SHOW", 1);
        r33.a();
        r7.put(this.m, DataType.FALSE);
    L144:
        String r34 = this.n;
        DressVisitorInfo r35 = r17.dressVisitorInfo;
        if (r35 == null) goto L149;
        VisitorStatistic r36 = r35.visitorStatistic;
        if (r36 == null) goto L149;
        long r37 = r36.visitorCount;
    L150:
        r7.put(r34, String.valueOf(r37));
        View r38 = this.g;
        if (r38 == null) goto L175;
        r38.setOnClickListener(new b(this, r7, r17));
    L149:
        r37 = 0;
        goto L150
    L68:
        TextView r39 = this.c;
        if (r39 == null) goto L71;
        r39.setVisibility(0);
    L71:
        SimpleIndicatorTextSwitcher r40 = this.e;
        if (r40 == null) goto L74;
        r40.setVisibility(0);
    L74:
        View r42 = this.f;
        if (r42 == null) goto L77;
        r42.setVisibility(0);
    L77:
        TextView r43 = this.c;
        if (r43 == null) goto L80;
        r43.setText(s1.B(2131921758));
    L80:
        r7.put(this.l, "visitor");
        DressVisitorInfo r44 = r17.dressVisitorInfo;
        if (r44 == null) goto L83;
        int r45 = r44.achievementType;
    L85:
        if (r45 == 0) goto L87;
        boolean r46 = com.bytedance.android.live.profile.ui.util.w.a.a(this.i, "live.pref.PREF_PROFILE_VISITOR_COUNT_ACHIEVEMENT_TYPE" + r45);
    L88:
        if (r46 == false) goto L97;
        View r47 = this.h;
        if (r47 == null) goto L92;
        r47.setVisibility(0);
    L92:
        r7.put(this.m, DataType.TRUE);
        DressVisitorInfo r48 = r17.dressVisitorInfo;
        if (r48 == null) goto L95;
        int r49 = r48.achievementType;
    L96:
        SharedPrefHelper r50 = SharedPrefHelper.b(this.i);
        r50.l("live.pref.PREF_PROFILE_VISITOR_COUNT_ACHIEVEMENT_TYPE" + r49, Long.valueOf(System.currentTimeMillis()));
        r50.a();
    L98:
        Context r52 = this.i;
        if (r52 != null) goto L101;
        long r112 = 0;
    L102:
        DressVisitorInfo r53 = r17.dressVisitorInfo;
        if (r53 == null) goto L107;
        VisitorStatistic r54 = r53.visitorStatistic;
        if (r54 == null) goto L107;
        long r113 = r54.visitorCount;
    L108:
        long r114 = r113 - r112;
        if (com.bytedance.android.live.profile.ui.util.w.a.a(this.i, "live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME") == false) goto L111;
    L127:
        SimpleIndicatorTextSwitcher r55 = this.e;
        if (r55 == null) goto L143;
        Context r56 = this.i;
        Intrinsics.checkNotNullParameter(r17, "user");
        if (r56 != null) goto L132;
        long r57 = 0;
    L139:
        String r58 = j(r57);
        Intrinsics.checkNotNullParameter(r58, "text1");
        if (r55.getChildCount() == 0) goto L142;
        r55.removeAllViews();
    L142:
        r55.addView(r55.a(r58), 0);
        goto L143
    L132:
        SharedPrefHelper r59 = SharedPrefHelper.b(r56);
        DressVisitorInfo r60 = r17.dressVisitorInfo;
        if (r60 == null) goto L137;
        VisitorStatistic r62 = r60.visitorStatistic;
        if (r62 == null) goto L137;
        r57 = r62.visitorCount;
    L138:
        r59.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", Long.valueOf(r57));
        r59.a();
    L137:
        r57 = 0;
    L143:
        SharedPrefHelper r63 = SharedPrefHelper.b(this.i);
        r63.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
        r63.a();
        goto L144
    L111:
        if (r114 <= 0) goto L127;
        SimpleIndicatorTextSwitcher r64 = this.e;
        if (r64 == null) goto L118;
        String r65 = "+" + j(r114);
        String r66 = j(r113);
        Intrinsics.checkNotNullParameter(r65, "text1");
        Intrinsics.checkNotNullParameter(r66, "text2");
        if (r64.getChildCount() == 0) goto L117;
        r64.removeAllViews();
    L117:
        TextView r67 = new TextView(r64.getContext());
        r67.setSingleLine();
        r67.setTextSize(1, 15.0f);
        r67.setTextColor(r67.getResources().getColor(2131108099));
        r67.setText(r65);
        r67.setSingleLine(true);
        r67.setIncludeFontPadding(false);
        r67.setGravity(8388613);
        r67.setIncludeFontPadding(false);
        r64.addView(r67, 0);
        r64.addView(r64.a(r66), 1);
    L118:
        Disposable r68 = this.j;
        if (r68 != null) goto L121;
    L126:
        this.j = this.q.getEnterExitState().subscribe(new a(this));
        SharedPrefHelper r69 = SharedPrefHelper.b(this.i);
        r69.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", Long.valueOf(r113));
        r69.a();
        SharedPrefHelper r70 = SharedPrefHelper.b(this.i);
        r70.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
        r70.a();
        goto L144
    L121:
        if ((!r68.isDisposed()) == false) goto L123;
        Disposable r72 = r68;
    L124:
        if (r72 == null) goto L126;
        r72.dispose();
        goto L126
    L123:
        r72 = null;
    L107:
        r113 = 0;
        goto L108
    L101:
        r112 = SharedPrefHelper.b(r52).i("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", -1);
        goto L102
    L95:
        r49 = 0;
        goto L96
    L97:
        r7.put(this.m, DataType.FALSE);
        goto L98
    L87:
        r46 = false;
        goto L88
    L83:
        r45 = 0;
        goto L85
    L54:
        if (SharedPrefHelper.b(r110).h("live.pref.PREF_PROFILE_VISITOR_COUNT_ENTRANCE_FIRST_SHOW", -1) != (-1)) goto L56;
        r111 = true;
        goto L57
    L37:
        r19 = null;
        goto L38
    L29:
        DressSuitInfo r73 = r17.getDressSuitInfo();
        if (r73 == null) goto L32;
        r16 = r73.getUserSuitId();
    L33:
        Intrinsics.checkNotNull(r16);
        goto L34
    L32:
        r16 = null;
        goto L33
    L23:
        if (r14.length() == 0) goto L26;
        r15 = false;
        goto L27
    L19:
        r14 = null;
    L15:
        r10 = "";
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileVisitorCountComponent update");
    }
}
