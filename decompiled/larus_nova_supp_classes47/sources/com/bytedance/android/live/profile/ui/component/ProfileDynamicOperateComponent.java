package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.ActionConfig;
import com.bytedance.android.live.base.model.user.ActionConfigs;
import com.bytedance.android.live.base.model.user.FingerHeartInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePotentialCustomerInfo;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.ActionExtra;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.SecretChatApi;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.liveprocast.ILiveProDualDeviceServiceForOther;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileDynamicOperateComponent implements com.bytedance.android.live.profile.ui.base.g {
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 0;
    public static final float J = 0.0f;
    public List<Function2<Integer, View, Unit>> A;
    public final DataCenter B;
    public final com.bytedance.android.live.profile.ui.base.l C;
    public final Fragment a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public v32.b p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public final com.bytedance.android.live.profile.ui.util.h y;
    public Disposable z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ProfileDynamicOperateComponent a;
        public final /* synthetic */ Function1 b;

        public b(ProfileDynamicOperateComponent r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1 r0 = this.b;     // Catch: Throwable -> L8
            LinearLayout r1 = this.a.p();     // Catch: Throwable -> L8
            if (r1 == null) goto L5;
            int r2 = r1.getWidth();     // Catch: Throwable -> L8
        L6:
            r0.invoke(Integer.valueOf(r2 + UtilityKotlinExtentionsKt.i(20)));     // Catch: Throwable -> L8
            return;
        L5:
            r2 = 0;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final LinearLayout l() {
        return (LinearLayout) this.m.getValue();
    }

    public final FrameLayout m() {
        return (FrameLayout) this.n.getValue();
    }

    public final LinearLayout n() {
        return (LinearLayout) this.b.getValue();
    }

    public final FrameLayout o() {
        return (FrameLayout) this.q.getValue();
    }

    public final LinearLayout p() {
        return (LinearLayout) this.c.getValue();
    }

    public final HSImageView q() {
        return (HSImageView) this.d.getValue();
    }

    static {
        D = UtilityKotlinExtentionsKt.i(16);
        E = UtilityKotlinExtentionsKt.i(16);
        F = UtilityKotlinExtentionsKt.i(16);
        G = UtilityKotlinExtentionsKt.i(16);
        H = UtilityKotlinExtentionsKt.i(25);
        I = UtilityKotlinExtentionsKt.i(30);
        J = UtilityKotlinExtentionsKt.h(10);
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        v32.b r0 = this.p;
        if (r0 == null) goto L5;
        r0.unload();
    L5:
        v32.b r1 = this.p;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        LottieAnimationView r2 = (LottieAnimationView) this.s.getValue();
        if (r2 == null) goto L11;
        r2.cancelAnimation();
    L11:
        this.y.b();
        ActionConfigs r3 = this.C.b().getTargetUser().actionConfigs;
        if (r3 == null) goto L19;
        List r4 = r3.entrances;
        if (r4 == null) goto L19;
        Iterator r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        ((ActionConfig) r5.next()).setUpdateButtonClickedInMore(false);
    L19:
        List<Function2<Integer, View, Unit>> r6 = this.A;
        if (r6 == null) goto L22;
        ((ArrayList) r6).clear();
    L22:
        this.A = null;
        Disposable r7 = this.z;
        if (r7 == null) goto L27;
        r7.dispose();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.DynamicOperate.INSTANCE;
    }

    public static final void h(ProfileDynamicOperateComponent r4) {
        r4.getClass();
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L10;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L10;
        String r3 = r2.getUserId();
        if (r3 == null) goto L10;
    L11:
        IBaseUser r5 = r4.C.b().getRoomUser();
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.b(r3, String.valueOf(r5.getUserId())) == false) goto L14;
        r4.C.b().dismiss();
        return;
    L14:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.d(r5, OpenInputSource.SecretChat, null, 1);
        r4.C.b().dismiss();
        return;
    L10:
        r3 = "";
        goto L11
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r5, "user");
        String r6 = this.t;
        if (r6 == null) goto L6;
        this.C.a().getLogUseCaseForUi().o(r6);
    L6:
        if (this.u == false) goto L9;
        this.C.a().getLogUseCaseForUi().n();
    L9:
        if (this.v == false) goto L12;
        this.C.a().getLogUseCaseForUi().a();
    L12:
        if (this.w == false) goto L14;
        this.C.a().getLogUseCaseForUi().m("show");
    L14:
        long r0 = this.x;
        if (r0 != ActionConfig.TYPE_INVITE_ADVENTURE) goto L18;
        this.C.a().getLogUseCaseForUi().e();
    L23:
        com.bytedance.android.live.profile.ui.util.h r7 = this.y;
        com.bytedance.android.live.profile.profilecontext.a r1 = this.C.b();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "profileContext");
        List<String> r2 = r7.a.get("actions");
        if (r2 == null) goto L29;
        Iterator<T> r3 = r2.iterator();
    L27:
        if (r3.hasNext() == false) goto L29;
        String r4 = (String) r3.next();
        r1.recordBusinessShow(TrackArea.TopWhiteArea, r4);
    L29:
        List<String> r8 = r7.a.get("others");
        if (r8 == null) goto L35;
        Iterator<T> r9 = r8.iterator();
    L33:
        if (r9.hasNext() == false) goto L35;
        String r10 = (String) r9.next();
        r1.recordBusinessShow(TrackArea.TopWhiteArea, r10);
    L35:
        Map<String, String> r12 = r7.b;
        if (r12 == null) goto L41;
        r1.recordShowMap(r12);
        return;
    L41:
        return;
    L18:
        if (r0 != ActionConfig.TYPE_CHECK_ADVENTURE) goto L21;
        this.C.a().getLogUseCaseForUi().d();
        goto L23
    L21:
        if (r0 != ActionConfig.TYPE_GUEST_LINK_INVITE) goto L23;
        this.C.a().getLogUseCaseForUi().c();
        goto L23
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r14) {
        Intrinsics.checkNotNullParameter(r14, "user");
        ArrayList r0 = new ArrayList();
        ActionConfigs r1 = r14.actionConfigs;
        if (r1 == null) goto L7;
        List r2 = r1.entrances;
        if (r2 == null) goto L7;
        r0.addAll(r2);
    L7:
        int r3 = -1;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b == false) goto L26;
        Iterator r4 = r0.iterator();
        int r5 = 0;
    L11:
        if (r4.hasNext() == false) goto L23;
        if (((ActionConfig) r4.next()).actionType != ActionConfig.TYPE_SECRET_CHAT) goto L19;
        v0 r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b(this.B, this.C.b().getRoomUser()) == true) goto L17;
    L18:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L24;
        r5 = r5 + 1;
    L24:
        if (r5 < 0) goto L26;
        ListProtector.remove(r0, r5);
        goto L26
    L17:
        if (com.bytedance.android.live.profile.ui.base.i.m(this.C.b()) == true) goto L18;
    L19:
        r7 = false;
        goto L20
    L23:
        r5 = -1;
    L26:
        UserProfileEvent r8 = this.C.b().getUserProfileEvent();
        if (r8 == null) goto L32;
        if (r8.forceHideDynamicComponent != true) goto L32;
        r0.clear();
    L32:
        if (r0.isEmpty() == false) goto L35;
        return;
    L35:
        if (r14.potentialCustomerInfo == null) goto L45;
        ActionConfig r9 = new ActionConfig();
        ProfilePotentialCustomerInfo r10 = r14.potentialCustomerInfo;
        if (r10 == null) goto L39;
        String r12 = r10.text;
    L40:
        r9.title = r12;
        if (r10 == null) goto L43;
        String r13 = r10.jumpSchema;
    L44:
        r9.scheme = r13;
    L46:
        Iterator r15 = r0.iterator();
        int r16 = 0;
    L48:
        if (r15.hasNext() == false) goto L56;
        if (((ActionConfig) r15.next()).actionType != ActionConfig.TYPE_ANCHOR_RELATION) goto L52;
        boolean r17 = true;
    L53:
        if (r17 == true) goto L54;
        r16 = r16 + 1;
        goto L48
    L54:
        r3 = r16;
        goto L56
    L52:
        r17 = false;
    L56:
        if (r3 < 0) goto L58;
        ActionConfig r18 = (ActionConfig) ListProtector.remove(r0, r3);
    L59:
        if (r9 == null) goto L68;
        List<String> r19 = this.y.a.get("others");
        if (r19 == null) goto L63;
        r19.add("potential_anchor_user_relation");
    L63:
        ProfilePotentialCustomerInfo r110 = r14.potentialCustomerInfo;
        if (r110 == null) goto L66;
        String r111 = r110.subPanelJson;
    L67:
        Triple r20 = new Triple(r9, r111, "potential_anchor_user_relation");
    L71:
        if (r20 == null) goto L159;
        ActionConfig r112 = (ActionConfig) r20.getFirst();
        String r22 = (String) r20.getSecond();
        String r23 = (String) r20.getThird();
        LinearLayout r24 = l();
        if (r24 == null) goto L75;
        UtilityKotlinExtentionsKt.w(r24);
    L75:
        LinearLayout r25 = l();
        if (r25 == null) goto L78;
        TextView r26 = (TextView) r25.findViewById(2131380795);
    L79:
        if (r26 == null) goto L81;
        r26.setText(r112.title);
    L81:
        com.bytedance.android.live.profile.ui.util.h r27 = this.y;
        String r28 = r112.title;
        String r29 = "";
        if (r28 != null) goto L84;
        r28 = "";
    L84:
        Map<? extends String, ? extends String> r30 = MapsKt.mapOf(TuplesKt.to("analyze_text", r28));
        r27.getClass();
        Intrinsics.checkNotNullParameter(r30, "map");
        if (r27.b != null) goto L87;
        r27.b = new LinkedHashMap();
    L87:
        Map<String, String> r32 = r27.b;
        if (r32 == null) goto L206;
        r32.putAll(r30);
    L206:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L98
        if (r22 != null) goto L93;
        r22 = "";
    L93:
        String r34 = new JSONObject(r22).optString("msg_type");     // Catch: Throwable -> L98
        if (r34 != null) goto L96;
        r34 = "";
    L96:
        Object r35 = Result.constructor-impl(r34);     // Catch: Throwable -> L98
    L101:
        if (Result.isFailure-impl(r35) == false) goto L103;
        r35 = null;
    L103:
        String r36 = (String) r35;
        if (r36 == null) goto L107;
        r29 = r36;
    L107:
        LinearLayout r37 = l();
        if (r37 == null) goto L110;
        HSImageView r38 = (HSImageView) r37.findViewById(2131380793);
    L111:
        py.k r39 = r112.action;
        if (r39 != null) goto L114;
    L132:
        if (r38 == null) goto L134;
        UtilityKotlinExtentionsKt.t(r38);
    L134:
        LinearLayout r40 = l();
        if (r40 == null) goto L137;
        View r42 = r40.findViewById(2131380794);
    L139:
        if (r112.hideArrow == false) goto L142;
        if (r42 == null) goto L144;
        UtilityKotlinExtentionsKt.t(r42);
    L144:
        this.t = r29;
        String r43 = r112.getClickSchema();
        if (r43 != null) goto L147;
    L150:
        boolean r44 = true;
    L151:
        if (r44 == false) goto L155;
        LinearLayout r113 = l();
        if (r113 == null) goto L158;
        r113.setOnClickListener(null);
    L158:
        boolean r114 = true;
    L160:
        int r45 = r0.size();
        if (r45 != 0) goto L163;
        LinearLayout r46 = n();
        if (r46 == null) goto L196;
        UtilityKotlinExtentionsKt.t(r46);
    L196:
        if (r0.isEmpty() == true) goto L201;
        LinearLayout r47 = n();
        if (r47 == null) goto L201;
        r47.post(new k(this, r0));
    L201:
        if (r114 == false) goto L212;
        LinearLayout r115 = l();
        if (r115 == null) goto L213;
        r115.post(new ProfileDynamicOperateComponent$checkWidthLimit$1(this, r0));
        return;
    L213:
        return;
    L212:
        return;
    L163:
        if (r45 == 1) goto L183;
        if (r45 == 2) goto L183;
        LinearLayout r48 = n();
        if (r48 == null) goto L168;
        UtilityKotlinExtentionsKt.w(r48);
    L168:
        i((ActionConfig) ListProtector.get(r0, 0), p(), q(), (Space) this.e.getValue(), (TextView) this.f.getValue(), 0, r0);
        LinearLayout r49 = (LinearLayout) this.k.getValue();
        if (r49 == null) goto L171;
        UtilityKotlinExtentionsKt.w(r49);
    L171:
        HSImageView r50 = (HSImageView) this.h.getValue();
        if (r50 == null) goto L174;
        r50.setImageDrawable(s1.m(2131251361));
    L174:
        Space r52 = (Space) this.i.getValue();
        if (r52 == null) goto L177;
        UtilityKotlinExtentionsKt.t(r52);
    L177:
        TextView r53 = (TextView) this.j.getValue();
        if (r53 == null) goto L180;
        UtilityKotlinExtentionsKt.t(r53);
    L180:
        this.y.a("more");
        LinearLayout r54 = (LinearLayout) this.g.getValue();
        if (r54 == null) goto L196;
        r54.setOnClickListener(new ProfileDynamicOperateComponent$initDynamicTopIcon$2(this, r0));
    L183:
        LinearLayout r55 = n();
        if (r55 == null) goto L186;
        UtilityKotlinExtentionsKt.w(r55);
    L186:
        i((ActionConfig) ListProtector.get(r0, 0), p(), q(), (Space) this.e.getValue(), (TextView) this.f.getValue(), 0, r0);
        if (r0.size() != 2) goto L196;
        LinearLayout r56 = (LinearLayout) this.k.getValue();
        if (r56 == null) goto L191;
        UtilityKotlinExtentionsKt.w(r56);
    L191:
        i((ActionConfig) ListProtector.get(r0, 1), (LinearLayout) this.g.getValue(), (HSImageView) this.h.getValue(), (Space) this.i.getValue(), (TextView) this.j.getValue(), 1, r0);
        goto L196
    L155:
        LinearLayout r57 = l();
        if (r57 == null) goto L158;
        r57.setOnClickListener(new l(this, r23, r112, r29));
        goto L158
    L147:
        if (r43.length() == 0) goto L150;
        r44 = false;
        goto L151
    L142:
        if (r42 == null) goto L144;
        UtilityKotlinExtentionsKt.w(r42);
        goto L144
    L137:
        r42 = null;
        goto L139
    L114:
        if (r39.getUrls().isEmpty() == true) goto L132;
        if (r38 == null) goto L119;
        UtilityKotlinExtentionsKt.w(r38);
    L119:
        if (r39.getWidth() == 0) goto L127;
        if (r39.getHeight() == 0) goto L127;
        if (r38 == null) goto L124;
        a1.p(r38, UtilityKotlinExtentionsKt.i(r39.getWidth()));
    L124:
        if (r38 == null) goto L131;
        a1.k(r38, UtilityKotlinExtentionsKt.i(r39.getHeight()));
    L131:
        ImageLoader.bindImage(r38, r39);
    L127:
        if (r38 == null) goto L129;
        a1.p(r38, UtilityKotlinExtentionsKt.i(16));
    L129:
        if (r38 == null) goto L131;
        a1.k(r38, UtilityKotlinExtentionsKt.i(16));
        goto L131
    L110:
        r38 = null;
    L98:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L101
    L78:
        r26 = null;
        goto L79
    L159:
        r114 = false;
        goto L160
    L66:
        r111 = null;
        goto L67
    L68:
        if (r18 == null) goto L70;
        this.y.a(r18.actionName);
        r20 = new Triple(r18, r14.anchorAudienceRelationInfo, r18.actionName);
        goto L71
    L70:
        r20 = null;
        goto L71
    L58:
        r18 = null;
        goto L59
    L43:
        r13 = null;
        goto L44
    L39:
        r12 = null;
        goto L40
    L45:
        r9 = null;
        goto L46
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r6, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileDynamicOperateComponent update");
        this.y.b();
        LinearLayout r0 = n();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        LinearLayout r1 = l();
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        Space r2 = (Space) this.o.getValue();
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        FrameLayout r3 = m();
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        FrameLayout r4 = m();
        if (r4 == null) goto L17;
        a1.m(r4, 0);
    L17:
        HSImageView r5 = q();
        if (r5 == null) goto L20;
        r5.setVisibility(0);
    L20:
        HSImageView r7 = q();
        if (r7 == null) goto L23;
        r7.setImageDrawable(null);
    L23:
        HSImageView r8 = (HSImageView) this.h.getValue();
        if (r8 == null) goto L26;
        r8.setVisibility(0);
    L26:
        HSImageView r9 = (HSImageView) this.h.getValue();
        if (r9 == null) goto L29;
        r9.setImageDrawable(null);
    L29:
        LinearLayout r10 = (LinearLayout) this.k.getValue();
        if (r10 == null) goto L32;
        r10.setVisibility(8);
    L32:
        v32.b r12 = this.p;
        if (r12 == null) goto L35;
        r12.unload();
    L35:
        v32.b r13 = this.p;
        if (r13 == null) goto L38;
        r13.clear();
    L38:
        FrameLayout r14 = o();
        if (r14 == null) goto L41;
        r14.setVisibility(8);
    L41:
        FrameLayout r15 = o();
        if (r15 == null) goto L44;
        a1.m(r15, UtilityKotlinExtentionsKt.i(88));
    L44:
        TextView r16 = (TextView) this.r.getValue();
        if (r16 == null) goto L47;
        r16.setVisibility(0);
    L47:
        LottieAnimationView r17 = (LottieAnimationView) this.s.getValue();
        if (r17 == null) goto L50;
        r17.setVisibility(8);
    L50:
        this.t = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = 0;
        Space r18 = (Space) this.e.getValue();
        if (r18 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r18);
    L53:
        TextView r19 = (TextView) this.f.getValue();
        if (r19 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r19);
    L56:
        TextView r20 = (TextView) this.f.getValue();
        if (r20 == null) goto L59;
        r20.setText(null);
    L59:
        Space r22 = (Space) this.i.getValue();
        if (r22 == null) goto L62;
        UtilityKotlinExtentionsKt.t(r22);
    L62:
        TextView r23 = (TextView) this.j.getValue();
        if (r23 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r23);
    L65:
        TextView r24 = (TextView) this.j.getValue();
        if (r24 == null) goto L68;
        r24.setText(null);
    L68:
        List<Function2<Integer, View, Unit>> r25 = this.A;
        if (r25 == null) goto L71;
        ((ArrayList) r25).clear();
    L71:
        this.A = null;
        Disposable r26 = this.z;
        if (r26 == null) goto L74;
        r26.dispose();
    L74:
        g(r6);
    }

    public ProfileDynamicOperateComponent(DataCenter r2, com.bytedance.android.live.profile.ui.base.l r3) {
        Intrinsics.checkNotNullParameter(r3, "hostBehavior");
        this.B = r2;
        this.C = r3;
        this.a = r3.getHostFragment();
        this.b = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicIconLayout$2(this));
        this.c = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicLeftContainer$2(this));
        this.d = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicLeftIcon$2(this));
        this.e = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicLeftIconSpace$2(this));
        this.f = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicLeftIconText$2(this));
        this.g = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicRightContainer$2(this));
        this.h = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicRightIcon$2(this));
        this.i = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicRightIconSpace$2(this));
        this.j = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicRightIconText$2(this));
        this.k = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicRightGroup$2(this));
        this.l = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicDiggIcon$2(this));
        this.m = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicAnchorRelationLayout$2(this));
        this.n = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicDiggAnimationContainer$2(this));
        this.o = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicDiggDismissSpace$2(this));
        this.q = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicInviteCountContainer$2(this));
        this.r = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicInviteCountTv$2(this));
        this.s = LazyKt.lazy(new ProfileDynamicOperateComponent$mDynamicInviteAnimView$2(this));
        this.y = new com.bytedance.android.live.profile.ui.util.h();
    }

    public final void k(List<ActionConfig> r8, Function1<? super Integer, Unit> r9) {
        int r1 = 0;
        if (((ArrayList) r8).isEmpty() == false) goto L6;
        r9.invoke(0);
        return;
    L6:
        ActionConfig r10 = (ActionConfig) ListProtector.get(r8, 0);
        if (r10.actionType != ActionConfig.TYPE_DIGG) goto L9;
        r9.invoke(Integer.valueOf(UtilityKotlinExtentionsKt.i(57)));
        return;
    L9:
        String r0 = r10.getRightText();
        if (r0 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L21;
        py.k r12 = r10.action;
        if (r12 == null) goto L20;
        r1 = r12.getWidth();
    L20:
        r9.invoke(Integer.valueOf(UtilityKotlinExtentionsKt.i(r1 + 20)));
        return;
    L21:
        LinearLayout r13 = p();
        if (r13 == null) goto L24;
        r13.post(new b(this, r9));
        return;
    L24:
        r9.invoke(0);
        return;
    L12:
        if (r0.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    public static final void c(ProfileDynamicOperateComponent r10, ActionConfig r12, Function1 r13) {
        Disposable r0 = r10.z;
        if (r0 != null) goto L5;
    L7:
        long r1 = r10.C.b().getRoom().getId();
        FingerHeartInfo r14 = (FingerHeartInfo) JsonUtil.parse(r12.extraInfo, FingerHeartInfo.class);     // Catch: Exception -> L13
        if (r14 == null) goto L15;
        String r15 = r14.getFingerHeartContent();     // Catch: Exception -> L13
        if (r15 == null) goto L15;
    L16:
        String r5 = r15;
        String r16 = r10.C.b().getTargetUser().baseProfileInfo.getIdStr();
        SecretChatApi.a.getClass();
        SecretChatApi r2 = (SecretChatApi) com.bytedance.android.live.network.c.b().e(SecretChatApi.class);
        if (r2 == null) goto L29;
        Long r17 = StringsKt.toLongOrNull(r16);
        if (r17 == null) goto L21;
        long r3 = r17.longValue();
    L22:
        Observable r18 = r2.sendSecretChat(r1, r3, r5, 3, null, "non_paste");
        if (r18 == null) goto L29;
        Observable r19 = r18.subscribeOn(Schedulers.io());
        if (r19 == null) goto L29;
        Observable r110 = r19.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L29;
        Disposable r111 = r110.subscribe(new m(r13), new n(r13));
    L30:
        r10.z = r111;
        return;
    L21:
        r3 = 0;
    L29:
        r111 = null;
    L15:
        r15 = "";
    L13:
        e = move-exception;
        ALogger.e(NewProfileInfoViewModel.TAG, "parse FingerHeartInfo error", e);
        goto L15
    L5:
        if (r0.isDisposed() == true) goto L7;
        r13.invoke(Boolean.FALSE);
    }

    public static final boolean a(ProfileDynamicOperateComponent r5, String r6, boolean r7, String r8, long r9) {
        r5.getClass();
        if (r9 != ActionConfig.TYPE_LINK) goto L10;
        ILiveExternalCameraServiceForOther r0 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r0 == null) goto L10;
        if (r0.isDisableAbility() != true) goto L10;
        f2.c("相机连接过程中暂不支持设置", 0);
    L20:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L48;
        if (r7 == true) goto L32;
        if (r8 != null) goto L27;
        return false;
    L27:
        if (r8.length() <= 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 != true) goto L46;
        f2.c(r8, 0);
        return false;
    L46:
        return false;
    L29:
        r12 = false;
        goto L30
    L32:
        if (r6 != null) goto L34;
    L37:
        boolean r13 = true;
    L38:
        if (r13 == true) goto L49;
        Context r14 = r5.a.getContext();
        if (r14 == null) goto L43;
        r5.C.a().handleDynamicAction(r14, r6.toString());
    L43:
        return true;
    L49:
        return false;
    L34:
        if (r6.length() == 0) goto L37;
        r13 = false;
        goto L38
    L48:
        return false;
    L10:
        if (r9 != ActionConfig.TYPE_LINK) goto L21;
        ILiveProDualDeviceServiceForOther r15 = jc1.k.f(ILiveProDualDeviceServiceForOther.class);
        if (r15 == null) goto L21;
        if (r15.needDisableProfileVideoTalk() != true) goto L21;
        ILiveProDualDeviceServiceForOther r16 = jc1.k.f(ILiveProDualDeviceServiceForOther.class);
        if (r16 == null) goto L21;
        if (r16.isUsingLiveProPhoneCameraInBroadCast() != true) goto L21;
        f2.c("正在使用外接手机摄像头，暂不支持该功能", 0);
    L21:
        r10 = false;
        goto L22
    }

    public static void j(HSImageView r5, Space r6, TextView r7, py.k r8, String r9) {
        boolean r0 = false;
        if (r8 != null) goto L5;
    L14:
        UtilityKotlinExtentionsKt.t(r5);
        boolean r10 = false;
    L15:
        if (r9 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L27;
        if (r7 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r7);
    L24:
        if (r7 == null) goto L26;
        r7.setText(r9);
    L26:
        r0 = true;
    L29:
        if (r10 == false) goto L33;
        if (r0 == false) goto L33;
        if (r6 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r6);
        return;
    L36:
        return;
    L33:
        if (r6 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r6);
        return;
    L38:
        return;
    L27:
        if (r7 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r7);
        goto L29
    L17:
        if (r9.length() == 0) goto L20;
        r12 = false;
        goto L21
    L5:
        if (r8.getUrls().isEmpty() == true) goto L14;
        UtilityKotlinExtentionsKt.w(r5);
        if (r8.getWidth() != 0) goto L9;
    L13:
        ImageLoader.bindImage(r5, r8);
        r10 = true;
        goto L15
    L9:
        if (r8.getHeight() == 0) goto L13;
        int r2 = s1.f(r8.getWidth());
        int r3 = s1.f(r8.getHeight());
        ViewGroup.LayoutParams r4 = r5.getLayoutParams();
        if (r4 == null) goto L13;
        r4.width = r2;
        r4.height = r3;
        r5.setLayoutParams(r4);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public final void i(ActionConfig r18, View r19, HSImageView r20, Space r22, TextView r23, final int r24, final List<ActionConfig> r25) {
        if (r20 != null) goto L5;
        return;
    L5:
        ActionExtra r16 = null;
        if (r18.actionType != ActionConfig.TYPE_DIGG) goto L47;
        this.y.a(r18.actionName);
        r20.setImageDrawable(s1.m(2131249765));
        UtilityKotlinExtentionsKt.w(r20);
        Space r1 = (Space) this.o.getValue();
        if (r1 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r1);
    L10:
        FrameLayout r2 = m();
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r2);
    L13:
        if (r24 <= 0) goto L22;
        FrameLayout r3 = m();
        if (r3 == null) goto L17;
        final int r4 = a1.f(r3);
    L18:
        k(r25, new ProfileDynamicOperateComponent$processDiggButton$1(this, r4));
        Function2<Integer, View, Unit> r5 = new ProfileDynamicOperateComponent$processDiggButton$2(this, r4);
        List r6 = this.A;
        if (r6 != null) goto L21;
        r6 = new ArrayList();
        this.A = r6;
    L21:
        r6.add(r5);
        goto L22
    L17:
        r4 = 0;
    L22:
        FrameLayout r7 = m();
        if (r7 == null) goto L37;
        Context r8 = this.a.getContext();
        if (r8 == null) goto L37;
        Context r9 = this.a.getContext();
        if (r9 == null) goto L29;
        v32.b r10 = this.C.a().getLikeView(r9);
    L30:
        this.p = r10;
        if (r10 == null) goto L37;
        IBaseDiggService r12 = jc1.k.f(IBaseDiggService.class);
        if (r12 == null) goto L37;
        v32.a r13 = r12.getDefaultTapController(r8, new o(r10, r7, this));
        if (r13 == null) goto L37;
        r10.c(r13);
        r10.init();
        r10.load();
        goto L37
    L29:
        r10 = null;
    L37:
        r20.setOnClickListener(new p(this, r18));
        py.k r14 = r18.action;
        if (r14 == null) goto L42;
        py.k.b r15 = r14.getImageContent();
        if (r15 == null) goto L42;
        String r17 = r15.getName();
    L43:
        r3.b(r20, r17, Button.class);
        Space r26 = (Space) this.o.getValue();
        if (r26 == null) goto L46;
        r26.setOnClickListener(new q(this));
    L46:
        this.u = true;
        boolean r27 = true;
    L48:
        if (r27 == false) goto L51;
        return;
    L51:
        if (r18.isLeftIconValid() == true) goto L62;
        String r28 = r18.getRightText();
        if (r28 != null) goto L55;
    L58:
        boolean r29 = true;
    L59:
        if (r29 == false) goto L62;
        ALogger.e(NewProfileInfoViewModel.TAG, "bindActionConfig2View error, no icon no text");
        return;
    L55:
        if (r28.length() == 0) goto L58;
        r29 = false;
    L62:
        this.y.a(r18.actionName);
        j(r20, r22, r23, r18.getLeftIcon(), r18.getRightText());
        if (r19 == 0) goto L65;
        ?? r110 = 1;
        r19.setOnClickListener(new ProfileDynamicOperateComponent$bindActionConfig2View$1(this, r18, r19, r20, r22, r23, r24));
    L66:
        if (r19 == 0) goto L68;
        r19.setImportantForAccessibility(r110);
    L68:
        py.k r30 = r18.getLeftIcon();
        if (r30 == null) goto L73;
        py.k.b r32 = r30.getImageContent();
        if (r32 == null) goto L73;
        String r33 = r32.getName();
    L74:
        r3.b(r19, r33, Button.class);
        long r0 = r18.actionType;
        if (r0 != ActionConfig.TYPE_SEND_GIFT) goto L78;
        this.v = r110;
    L80:
        long r34 = ActionConfig.TYPE_GUEST_LINK_INVITE;
        if (r0 != r34) goto L84;
        this.x = r34;
    L84:
        if (r0 != ActionConfig.TYPE_INVITE_ADVENTURE) goto L86;
    L142:
        ActionExtra r35 = (ActionExtra) GsonHelper.getDefault().fromJson(r18.extraInfo, ActionExtra.class);     // Catch: Exception -> L89
    L91:
        if (r35 == null) goto L145;
        long r36 = r18.actionType;
        if (r36 != ActionConfig.TYPE_INVITE_ADVENTURE) goto L117;
        int r37 = ((ArrayList) r25).size();
        if (r24 <= 0) goto L97;
        ALogger.i("ProfileDynamicOperateComponent", "TYPE_INVITE_ADVENTURE index is " + r24);
    L115:
        this.x = ActionConfig.TYPE_INVITE_ADVENTURE;
        return;
    L97:
        Ref.IntRef r38 = new Ref.IntRef();
        int r39 = com.bytedance.android.live.profile.ui.util.u.a;
        r38.element = ((Number) ts0.a.f.getValue()).intValue();
        int r40 = r35.getSweepCount();
        if (r40 <= r38.element) goto L115;
        ALogger.i("ProfileDynamicOperateComponent", "showSweepAnim, maxAnimCount = " + r40 + ", curAnimCount = " + r38.element);
        LottieAnimationView r42 = (LottieAnimationView) this.s.getValue();
        if (r42 == null) goto L112;
        r42.addAnimatorListener(new r(r42, r20, r38));
        UtilityKotlinExtentionsKt.z(r42, true);
        if (r37 != 1) goto L108;
        if (((Boolean) com.bytedance.android.live.core.setting.o.a.getValue()).booleanValue() == false) goto L106;
        String r43 = i2.a;
        Intrinsics.checkNotNullParameter(r42, "$this$loadOfflineLottie");
        Intrinsics.checkNotNullParameter("/profile/lottie/profile_dynamic_sweep_anim_1.json", "key");
        i2.f(r42, "/profile/lottie/profile_dynamic_sweep_anim_1.json");
    L111:
        r42.setRepeatCount((r40 - r38.element) - 1);
        r42.setRepeatMode(1);
        goto L112
    L106:
        r42.setAnimation("profile_dynamic_sweep_anim_1.json");
        goto L111
    L108:
        if (((Boolean) com.bytedance.android.live.core.setting.o.a.getValue()).booleanValue() == false) goto L110;
        String r44 = i2.a;
        Intrinsics.checkNotNullParameter(r42, "$this$loadOfflineLottie");
        Intrinsics.checkNotNullParameter("/profile/lottie/profile_dynamic_sweep_anim_2.json", "key");
        i2.f(r42, "/profile/lottie/profile_dynamic_sweep_anim_2.json");
        goto L111
    L110:
        r42.setAnimation("profile_dynamic_sweep_anim_2.json");
    L112:
        LottieAnimationView r45 = (LottieAnimationView) this.s.getValue();
        if (r45 == null) goto L115;
        r45.playAnimation();
        goto L115
    L117:
        if (r36 == ActionConfig.TYPE_CHECK_ADVENTURE) goto L119;
        return;
    L119:
        if (o() != null) goto L122;
    L140:
        this.x = ActionConfig.TYPE_CHECK_ADVENTURE;
        return;
    L122:
        if ((!StringsKt.isBlank(r35.getInviteText())) == false) goto L124;
        r16 = r35;
    L124:
        if (r16 == null) goto L140;
        if (r24 <= 0) goto L134;
        FrameLayout r46 = o();
        if (r46 == null) goto L129;
        final int r111 = a1.f(r46);
    L130:
        k(r25, new ProfileDynamicOperateComponent$showInviteCount$$inlined$apply$lambda$1(r111, this, r24, r25));
        Function2<Integer, View, Unit> r47 = new ProfileDynamicOperateComponent$showInviteCount$$inlined$apply$lambda$2(r111, this, r24, r25);
        List r48 = this.A;
        if (r48 != null) goto L133;
        r48 = new ArrayList();
        this.A = r48;
    L133:
        r48.add(r47);
        goto L134
    L129:
        r111 = 0;
    L134:
        FrameLayout r49 = o();
        if (r49 == null) goto L137;
        UtilityKotlinExtentionsKt.z(r49, true);
    L137:
        TextView r50 = (TextView) this.r.getValue();
        if (r50 == null) goto L140;
        r50.setText(r16.getInviteText());
        goto L140
    L145:
        return;
    L89:
        e = move-exception;
        ALogger.i("ProfileDynamicOperateComponent", "extra info parse failed! ----- " + e.getMessage());
        r35 = null;
        goto L91
    L86:
        if (r0 == ActionConfig.TYPE_CHECK_ADVENTURE) goto L142;
        return;
    L78:
        if (r0 != ActionConfig.TYPE_LINK) goto L80;
        this.w = r110;
    L73:
        r33 = null;
        goto L74
    L65:
        r110 = 1;
    L42:
        r17 = null;
        goto L43
    L47:
        r27 = false;
        goto L48
    }
}
