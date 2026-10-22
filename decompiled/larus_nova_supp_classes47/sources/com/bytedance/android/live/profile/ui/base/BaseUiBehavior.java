package com.bytedance.android.live.profile.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileConstant;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platform.ILiveProfilePlatformService;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.model.LifecycleStateType;
import com.bytedance.android.live.profile.monitor.LifecycleType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.standard.honour.ProfileStandardHonourWallComponent;
import com.bytedance.android.live.profile.standard.tag.ProfileStandardTagListComponent;
import com.bytedance.android.live.profile.ui.component.ProfileCommonComponent;
import com.bytedance.android.live.profile.ui.component.ProfileDynamicOperateComponent;
import com.bytedance.android.live.profile.ui.component.ProfileSkinCustomComponent;
import com.bytedance.android.live.profile.ui.component.ProfileTextInfoComponent;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.y;
import com.bytedance.android.live.profile.ui.util.ProfileComponentManagerImp;
import com.bytedance.android.live.profile.ui.util.t;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livesdk.config.mg;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdk.widget.MaxHeightScrollView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rs0.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class BaseUiBehavior implements l {
    public static final /* synthetic */ int m = 0;
    public final NewProfileInfoViewModel a;
    public final int b;
    public final int c;
    public final List<g> d;
    public final ArrayList<g> e;
    public final Map<g, f> f;
    public List<? extends ViewGroup> g;
    public final ProfileComponentManagerImp h;
    public final com.bytedance.android.live.profile.profilecontext.a i;
    public final CompositeDisposable j;
    public final Fragment k;
    public final com.bytedance.android.live.profile.model.d l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.base.BaseUiBehavior$update$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<NewProfileUser, Boolean> {
        public AnonymousClass2(BaseUiBehavior r8) {
            super(1, r8, BaseUiBehavior.class, "isConfigShopComponent", "isConfigShopComponent(Lcom/bytedance/android/live/base/model/user/NewProfileUser;)Z", 0);
        }

        public final boolean invoke(NewProfileUser r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            BaseUiBehavior r0 = (BaseUiBehavior) ((CallableReference) this).receiver;
            int r1 = BaseUiBehavior.m;
            return r0.m(r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return Boolean.valueOf(invoke((NewProfileUser) r1));
        }
    }

    static {
    }

    public DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> d(DataAssembler<st0.b> r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    public DataAssembler e(ProfileStandardHonourWallComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final boolean isVertical() {
        return this.a.isVertical();
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final NewProfileInfoViewModel a() {
        return this.a;
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final com.bytedance.android.live.profile.profilecontext.a b() {
        return this.i;
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final int c() {
        return this.b;
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final Fragment getHostFragment() {
        return this.k;
    }

    @Override // com.bytedance.android.live.profile.ui.base.l
    public final int getTargetType() {
        return this.c;
    }

    public final com.bytedance.android.live.profile.model.d getType() {
        return this.l;
    }

    public final void i(final g r6) {
        ProfileMonitor.a r0 = ProfileMonitor.g;
        com.bytedance.android.live.profile.profilecontext.a r1 = this.i;
        if (r1 == null) goto L5;
        ProfileMonitor r2 = r1.getProfileMonitor();
    L6:
        ComponentType r3 = r6.getComponentType();
        LifecycleType r4 = LifecycleType.OnComponentDestroy;
        Function0<Unit> r5 = new BaseUiBehavior$destroyComponent$1(r6);
        r0.getClass();
        ProfileMonitor.a.c(r2, r3, r4, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final <T extends View> T j(int r2) {
        View r0 = this.k.getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findViewById(r2);
    }

    public final boolean m(NewProfileUser r5) {
        if (isVertical() == false) goto L5;
    L7:
        ProfileStyleParams r0 = r5.getProfileStyleParams();
        if (r0 != null) goto L10;
        return false;
    L10:
        if (((int) r0.getProfileStyle()) != ProfileConstant.ProfileType.SHOP.getType()) goto L19;
        EcomInfo r6 = r5.ecomInfo;
        if (r6 == null) goto L14;
        int r7 = r6.getEcomType();
    L15:
        if (r7 == 0) goto L20;
        return true;
    L20:
        return false;
    L14:
        r7 = 0;
        goto L15
    L19:
        return false;
    L5:
        if (((Boolean) mg.a.getValue()).booleanValue() == false) goto L7;
        return false;
    }

    public final void n(boolean r3) {
        View r0 = this.k.getView();
        if (r0 == null) goto L5;
        MaxHeightScrollView r1 = (MaxHeightScrollView) r0.findViewById(2131380815);
    L6:
        if (r1 == null) goto L12;
        if (r3 == false) goto L9;
        int r4 = UtilityKotlinExtentionsKt.i(332);
    L10:
        r1.setHeightMax(r4);
        return;
    L9:
        r4 = -1;
        goto L10
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [android.view.View, com.bytedance.android.live.profile.customview.ProfileNestedScrollView] */
    public final void o(NewProfileUser r18) {
        Intrinsics.checkNotNullParameter(r18, "user");
        ((ArrayList) this.d).clear();
        ((LinkedHashMap) this.f).clear();
        this.e.clear();
        ArrayList<g> r3 = this.e;
        Intrinsics.checkNotNullParameter(r18, "user");
        ArrayList<g> r2 = new ArrayList();
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        r2.add(new ProfileCommonComponent(this));
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        r2.add(new ProfileSkinCustomComponent(this));
        if (isVertical() == false) goto L5;
        ProfileComponentManagerImp r5 = this.h;
        DataCenter r6 = this.a.getRoomDataCenter();
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        r2.add(new ProfileDynamicOperateComponent(r6, this));
    L5:
        View r7 = this.k.getView();
        if (r7 == null) goto L13;
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131380743);
        if (r8 == null) goto L13;
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        Intrinsics.checkNotNullParameter(r8, "container");
        DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> r9 = d(jc1.k.n(ILiveProfilePlatformService.class).createButtonAreaComponent(this, r8), r18);
        if (r9 == null) goto L13;
        r9.c(r2);
    L13:
        if (this.i.isMyLive() == false) goto L15;
        int r10 = 2131380837;
    L16:
        View r12 = this.k.getView();
        if (r12 == null) goto L26;
        FlowLayout r13 = (ViewGroup) r12.findViewById(r10);
        if (r13 == null) goto L26;
        r13.setPadding(UtilityKotlinExtentionsKt.i(16), 0, UtilityKotlinExtentionsKt.i(16), 0);
        if ((r13 instanceof FlowLayout) == false) goto L23;
        FlowLayout r14 = r13;
        r14.setItemSpacing(UtilityKotlinExtentionsKt.i(4));
        r14.setLineSpacing(UtilityKotlinExtentionsKt.i(4));
    L23:
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        Intrinsics.checkNotNullParameter(r13, "container");
        DataAssembler r15 = g(new ProfileStandardTagListComponent(this, r13), r18);
        if (r15 == null) goto L27;
        r15.c(r2);
    L27:
        View r16 = this.k.getView();
        if (r16 == null) goto L39;
        ViewGroup r17 = (ViewGroup) r16.findViewById(2131380826);
        if (r17 == null) goto L39;
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        Intrinsics.checkNotNullParameter(r17, "container");
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L34;
        ProfileTextInfoComponent r19 = null;
    L35:
        if (r19 == null) goto L41;
        DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> r110 = f(r19, r18);
        if (r110 == null) goto L41;
        r110.c(r2);
    L41:
        if (this.i.isMyLive() == false) goto L43;
        int r111 = 2131380834;
    L44:
        View r112 = this.k.getView();
        if (r112 == null) goto L51;
        ViewGroup r113 = (ViewGroup) r112.findViewById(r111);
        if (r113 == null) goto L51;
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        Intrinsics.checkNotNullParameter(r113, "container");
        y r114 = h(new y(this, r113), r18);
        if (r114 == null) goto L52;
        r114.c(r2);
    L52:
        ((ArrayList) this.d).addAll(r2);
        Map<g, f> r115 = this.f;
        com.bytedance.android.live.profile.profilecontext.a r116 = this.i;
        if (r116 == null) goto L98;
        Iterator r20 = ((List) this.h.a.getValue()).iterator();
    L57:
        if (r20.hasNext() == false) goto L62;
        Object r117 = r20.next();
        if (((b) r117).d(r18, r116) == false) goto L57;
    L63:
        b r22 = (b) r117;
        if (r22 == null) goto L67;
        nt0.a r4 = r22.a(r116);
        r115.put(r4, r22);
        Unit r23 = Unit.INSTANCE;
        r2.add(r4);
        goto L98
    L67:
        if (m(r18) == false) goto L70;
        this.h.getClass();
        r2.add(ProfileComponentManagerImp.a(this));
        goto L98
    L70:
        if (r18.useStandardHonorWallV3() == true) goto L72;
    L76:
        View r24 = this.k.getView();
        if (r24 == null) goto L79;
        ViewGroup r25 = (ViewGroup) r24.findViewById(2131380822);
    L80:
        if (r25 == null) goto L97;
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "host");
        Intrinsics.checkNotNullParameter(r25, "container");
        DataAssembler r26 = e(new ProfileStandardHonourWallComponent(this, r25), r18);
        if (r26 == null) goto L90;
        r26.c(r2);
        if (isVertical() == true) goto L90;
        View r27 = this.k.getView();
        if (r27 == null) goto L90;
        ViewGroup r28 = (ViewGroup) r27.findViewById(2131380824);
        if (r28 == null) goto L90;
        UtilityKotlinExtentionsKt.w(r28);
    L90:
        int r29 = com.bytedance.android.live.profile.ui.util.i.a;
        if (com.bytedance.android.livesdk.m.c() == false) goto L97;
        IMiddlewareHostBusiness r30 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r30 == null) goto L97;
        IHostLargeFontService r32 = r30.getLiveLargeFontService();
        if (r32 == null) goto L97;
        r32.noZoom(r25);
    L97:
        n(true);
    L79:
        r25 = null;
        goto L80
    L72:
        if (isVertical() == true) goto L76;
        View r33 = this.k.getView();
        if (r33 == null) goto L79;
        r25 = (ViewGroup) r33.findViewById(2131380823);
        goto L80
    L62:
        r117 = null;
    L98:
        Map<g, f> r34 = this.f;
        com.bytedance.android.live.profile.profilecontext.a r35 = this.i;
        if (r35 == null) goto L109;
        Iterator r36 = ((List) this.h.b.getValue()).iterator();
    L103:
        if (r36.hasNext() == false) goto L109;
        f r118 = (f) r36.next();
        if (r118.d(r18, r35) == true) goto L107;
        ALogger.i(NewProfileInfoViewModel.TAG, "组件-" + r118.getComponentType().getDescription() + "-不能加载");
        goto L103
    L107:
        ALogger.i(NewProfileInfoViewModel.TAG, "组件-" + r118.getComponentType().getDescription() + "-加载");
        g r37 = r118.a(r35);
        r34.put(r37, r118);
        Unit r119 = Unit.INSTANCE;
        r2.add(r37);
    L109:
        this.g = CollectionsKt.listOf(new ViewGroup[]{r13, r17, r113});
        r3.addAll(r2);
        ArrayList r38 = new ArrayList();
        Iterator<g> r39 = this.e.iterator();
    L111:
        if (r39.hasNext() == false) goto L130;
        g r40 = r39.next();
        f r42 = (f) ((LinkedHashMap) this.f).get(r40);
        if (r42 != null) goto L114;
        l(r40, r18);
        goto L111
    L114:
        List<ComponentType> r43 = r42.c();
        if (r43 == null) goto L125;
        Iterator<T> r44 = r43.iterator();
    L118:
        if (r44.hasNext() == false) goto L125;
        ComponentType r45 = (ComponentType) r44.next();
        Iterator<g> r46 = this.e.iterator();
    L121:
        if (r46.hasNext() == false) goto L118;
        if (Intrinsics.areEqual(r46.next().getComponentType(), r45) == false) goto L121;
        boolean r47 = false;
    L126:
        if (r47 == true) goto L127;
        r38.add(r40);
        goto L111
    L127:
        k(r40, r18, r42);
    L125:
        r47 = true;
        goto L126
    L130:
        Set r48 = CollectionsKt.toSet(r38);
        this.e.removeAll(r48);
        CollectionsKt.removeAll(((LinkedHashMap) this.f).keySet(), r48);
        if (com.bytedance.android.live.profile.b.a == true) goto L197;
        int r49 = t.a;
        View r50 = this.k.getView();
        if (r50 == null) goto L136;
        View r52 = r50.findViewById(2131383208);
    L137:
        View r53 = this.k.getView();
        if (r53 == null) goto L140;
        View r54 = r53.findViewById(2131380737);
    L141:
        View r55 = this.k.getView();
        if (r55 == null) goto L144;
        View r56 = r55.findViewById(2131380743);
    L145:
        ProfileStyleParams r1 = r18.getProfileStyleParams();
        if (r1 == null) goto L148;
        float r57 = r1.getProfileDynamicSpaceHeight();
    L149:
        int r58 = s1.f(r57);
        if (r58 > 1) goto L152;
        r58 = 1;
    L152:
        if (r52 == null) goto L156;
        ViewGroup.LayoutParams r59 = r52.getLayoutParams();
        if (r59 == null) goto L156;
        r59.height = r58;
    L156:
        if (r54 == null) goto L158;
        ViewGroup.LayoutParams r60 = r54.getLayoutParams();
    L160:
        if ((r60 instanceof ConstraintLayout.LayoutParams) == true) goto L162;
        r60 = null;
    L162:
        ConstraintLayout.LayoutParams r62 = (ConstraintLayout.LayoutParams) r60;
        if (r62 == null) goto L165;
        ((ViewGroup.MarginLayoutParams) r62).topMargin += r58;
    L165:
        if (r54 == null) goto L168;
        r54.setLayoutParams(r62);
    L168:
        if (r57 >= 10) goto L180;
        if (r56 == null) goto L171;
        ViewGroup.LayoutParams r63 = r56.getLayoutParams();
    L173:
        if ((r63 instanceof ConstraintLayout.LayoutParams) == true) goto L175;
        r63 = null;
    L175:
        ConstraintLayout.LayoutParams r64 = (ConstraintLayout.LayoutParams) r63;
        if (r64 == null) goto L178;
        ((ViewGroup.MarginLayoutParams) r64).topMargin += r58;
    L178:
        if (r56 == null) goto L190;
        r56.setLayoutParams(r64);
    L190:
        if (isVertical() == true) goto L197;
        View r65 = this.k.getView();
        if (r65 == null) goto L194;
        View r120 = r65.findViewById(2131380855);
    L195:
        if (r120 == null) goto L197;
        r120.setVisibility(8);
        goto L197
    L194:
        r120 = null;
        goto L195
    L171:
        r63 = null;
        goto L173
    L180:
        if (r56 == null) goto L182;
        ViewGroup.LayoutParams r66 = r56.getLayoutParams();
    L184:
        if ((r66 instanceof ConstraintLayout.LayoutParams) == true) goto L186;
        r66 = null;
    L186:
        ConstraintLayout.LayoutParams r67 = (ConstraintLayout.LayoutParams) r66;
        if (r67 == null) goto L190;
        ((ViewGroup.MarginLayoutParams) r67).topMargin = (((ViewGroup.MarginLayoutParams) r67).topMargin + r58) - ((int) s1.e(7.0f));
        r56.setLayoutParams(r67);
        goto L190
    L182:
        r66 = null;
        goto L184
    L158:
        r60 = null;
        goto L160
    L148:
        r57 = 1.0f;
        goto L149
    L144:
        r56 = null;
        goto L145
    L140:
        r54 = null;
        goto L141
    L136:
        r52 = null;
    L197:
        List<? extends ViewGroup> r68 = this.g;
        if (r68 == null) goto L208;
        Iterator<T> r69 = r68.iterator();
    L201:
        if (r69.hasNext() == false) goto L208;
        ViewGroup r70 = (ViewGroup) r69.next();
        if (r70 == null) goto L201;
        if (r70.getChildCount() != 0) goto L201;
        UIUtils.setViewVisibility(r70, 8);
    L208:
        if (this.i.isVertical() == true) goto L219;
        com.bytedance.android.live.profile.model.d r72 = this.l;
        if (r72.c != 2) goto L219;
        if (r72.a != 0) goto L219;
        View r73 = this.k.getView();
        if (r73 == null) goto L219;
        ViewGroup r74 = (ViewGroup) r73.findViewById(2131380845);
        if (r74 == null) goto L219;
        UtilityKotlinExtentionsKt.t(r74);
    L219:
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L232;
        View r75 = this.k.getView();
        if (r75 == null) goto L232;
        View r76 = r75.findViewById(2131380862);
        if (r76 == null) goto L225;
        UtilityKotlinExtentionsKt.t(r76);
    L225:
        View r77 = r75.findViewById(2131380861);
        if (r77 == null) goto L228;
        UtilityKotlinExtentionsKt.t(r77);
    L228:
        View r78 = r75.findViewById(2131380826);
        if (r78 == null) goto L232;
        UtilityKotlinExtentionsKt.t(r78);
    L232:
        if (this.i.isMyLive() == false) goto L268;
        ?? r79 = (ProfileNestedScrollView) j(2131380828);
        if (r79 == 0) goto L239;
        a1.k(r79, i.a(this.i));
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L238;
        a1.p(r79, -1);
    L238:
        r79.setMyLiveScroll(true);
    L239:
        Space r80 = (Space) j(2131380763);
        if (r80 == null) goto L242;
        r80.setVisibility(8);
    L242:
        View r82 = j(2131380839);
        if (r82 == null) goto L245;
        r82.setVisibility(8);
    L245:
        View r83 = j(2131380831);
        if (r83 == null) goto L248;
        r83.setVisibility(0);
    L248:
        View r84 = j(2131380853);
        if (r84 == null) goto L251;
        r84.setVisibility(8);
    L251:
        View r85 = j(2131380862);
        if (r85 == null) goto L254;
        r85.setVisibility(8);
    L254:
        View r86 = j(2131380861);
        if (r86 == null) goto L257;
        r86.setVisibility(8);
    L257:
        View r87 = j(2131380835);
        if (r87 == null) goto L260;
        r87.setVisibility(0);
    L260:
        View r88 = j(2131380786);
        if (r88 == null) goto L264;
        r88.setVisibility(8);
    L264:
        if (isVertical() == true) goto L268;
        View r89 = j(2131380845);
        if (r89 == null) goto L268;
        a1.k(r89, -2);
    L268:
        Disposable r90 = i.j(this.i, new BaseUiBehavior$start$2(this));
        if (r90 == null) goto L297;
        RxUtilKt.c(r90, this.j);
        return;
    L297:
        return;
    L51:
        r113 = null;
        goto L52
    L43:
        r111 = 2131380786;
        goto L44
    L34:
        r19 = new ProfileTextInfoComponent(this, r17);
    L39:
        r17 = null;
    L26:
        r13 = null;
        goto L27
    L15:
        r10 = 2131380853;
        goto L16
    }

    public final void update(final NewProfileUser r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        ALogger.e("NewUserProfile_ProfilePre", "BeseUiBehavior update");
        StringBuilder r1 = new StringBuilder("preload components: ");
        ArrayList<g> r2 = this.e;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<g> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        g r5 = r4.next();
        r3.add(r5.getComponentType().getClass().getSimpleName() + "@" + r5.hashCode());
        goto L6
    L8:
        r1.append(r3);
        ALogger.e("NewUserProfile_ProfilePre", r1.toString());
        n(false);
        int r6 = com.bytedance.android.live.profile.ui.util.g.a;
        com.bytedance.android.live.profile.profilecontext.a r7 = this.i;
        ArrayList<g> r8 = this.e;
        List r9 = (List) this.h.a.getValue();
        List r10 = (List) this.h.b.getValue();
        List<g> r12 = this.d;
        com.bytedance.android.live.profile.ui.util.j r13 = new com.bytedance.android.live.profile.ui.util.j(new com.bytedance.android.live.profile.ui.util.f(new AnonymousClass2(this), new AnonymousClass3(this)), new com.bytedance.android.live.profile.ui.util.f(new AnonymousClass4(this), new AnonymousClass5(this, r15)));
        Intrinsics.checkNotNullParameter(r7, "profileContext");
        Intrinsics.checkNotNullParameter(r15, "newUser");
        Intrinsics.checkNotNullParameter(r8, "loadedComponents");
        Intrinsics.checkNotNullParameter(r9, "businessOpenAreaDescriptions");
        Intrinsics.checkNotNullParameter(r10, "allDescriptions");
        Intrinsics.checkNotNullParameter(r12, "loadComponents");
        Intrinsics.checkNotNullParameter(r13, "loadInfo");
        com.bytedance.android.live.profile.ui.util.e r14 = new com.bytedance.android.live.profile.ui.util.e(null);
        LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator<g> r17 = r8.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        g r18 = r17.next();
        r16.put(r18.getComponentType(), r18);
        goto L10
    L12:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r10.iterator();
    L14:
        if (r20.hasNext() == false) goto L18;
        Object r110 = r20.next();
        if (((f) r110).d(r15, r7) == false) goto L14;
        r19.add(r110);
        goto L14
    L18:
        Iterator r22 = r19.iterator();
    L20:
        if (r22.hasNext() == false) goto L22;
        f r23 = (f) r22.next();
        r14.a.put(r23.a(r7), r23);
        goto L20
    L22:
        Map<g, f> r24 = r14.a;
        LinkedHashMap r25 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator r26 = ((ArrayList) r12).iterator();
    L24:
        if (r26.hasNext() == false) goto L26;
        Object r111 = r26.next();
        g r112 = (g) r111;
        r25.put(r111, null);
        goto L24
    L26:
        r24.putAll(r25);
        Iterator r27 = r9.iterator();
    L28:
        if (r27.hasNext() == false) goto L32;
        Object r28 = r27.next();
        if (((b) r28).d(r15, r7) == false) goto L28;
    L33:
        b r29 = (b) r28;
        if (r29 == null) goto L38;
        nt0.a r30 = r29.a(r7);
        r14.a.put(r30, r29);
        if (r30 == null) goto L38;
    L50:
        ArrayList r32 = new ArrayList();
        Set<g> r33 = r14.a.keySet();
        HashSet r34 = new HashSet();
        Iterator<T> r35 = r33.iterator();
    L52:
        if (r35.hasNext() == false) goto L54;
        r34.add(((g) r35.next()).getComponentType());
        goto L52
    L54:
        Iterator<Map.Entry<g, f>> r36 = r14.a.entrySet().iterator();
    L56:
        if (r36.hasNext() == false) goto L67;
        Map.Entry<g, f> r37 = r36.next();
        f r38 = r37.getValue();
        if (r38 == null) goto L56;
        List<ComponentType> r39 = r38.c();
        if (r39 == null) goto L56;
        Iterator<T> r40 = r39.iterator();
    L63:
        if (r40.hasNext() == false) goto L56;
        if (r34.contains((ComponentType) r40.next()) == false) goto L63;
        r32.add(r37.getKey());
        goto L56
    L67:
        Map<g, f> r42 = r14.a;
        CollectionsKt.removeAll(r42.keySet(), CollectionsKt.toSet(r32));
        LinkedHashMap r43 = new LinkedHashMap();
        Iterator<Map.Entry<g, f>> r44 = r14.a.entrySet().iterator();
    L69:
        if (r44.hasNext() == false) goto L76;
        Map.Entry<g, f> r45 = r44.next();
        if (r16.containsKey(r45.getKey().getComponentType()) == false) goto L69;
        g r46 = (g) r16.get(r45.getKey().getComponentType());
        if (r46 == null) goto L75;
        f r47 = (f) r43.put(r46, r45.getValue());
    L75:
        r44.remove();
        goto L69
    L76:
        r14.a.putAll(r43);
        Map<g, f> r48 = r14.a;
        Map<g, f> r49 = r14.b;
        Iterator<Map.Entry<g, f>> r50 = r48.entrySet().iterator();
    L78:
        if (r50.hasNext() == false) goto L82;
        Map.Entry<g, f> r52 = r50.next();
        if ((!r16.containsKey(r52.getKey().getComponentType())) == false) goto L78;
        r49.put(r52.getKey(), r52.getValue());
        goto L78
    L82:
        Map<g, f> r53 = r14.a;
        Map<g, f> r54 = r14.d;
        Iterator<Map.Entry<g, f>> r55 = r53.entrySet().iterator();
    L84:
        if (r55.hasNext() == false) goto L88;
        Map.Entry<g, f> r56 = r55.next();
        if (r16.containsKey(r56.getKey().getComponentType()) == false) goto L84;
        r54.put(r56.getKey(), r56.getValue());
        goto L84
    L88:
        Set<g> r57 = r14.a.keySet();
        ArrayList r58 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r57, 10));
        Iterator<T> r59 = r57.iterator();
    L90:
        if (r59.hasNext() == false) goto L92;
        r58.add(((g) r59.next()).getComponentType());
        goto L90
    L92:
        List<g> r60 = r14.c;
        Iterator r62 = r16.entrySet().iterator();
    L94:
        if (r62.hasNext() == false) goto L98;
        Map.Entry r63 = (Map.Entry) r62.next();
        if ((!r58.contains(r63.getKey())) == false) goto L94;
        r60.add((g) r63.getValue());
        goto L94
    L98:
        ALogger.e("NewUserProfile_ProfilePre", "compare result components: " + r14);
        this.a.getLifecycleState().a(new com.bytedance.android.live.profile.model.b(LifecycleStateType.BEFORE_UPDATE));
        Map<g, f> r0 = r14.a;
        Map<g, f> r64 = r14.b;
        List<g> r65 = r14.c;
        Map<g, f> r66 = r14.d;
        Iterator<T> r67 = r65.iterator();
    L100:
        if (r67.hasNext() == false) goto L102;
        i((g) r67.next());
        goto L100
    L102:
        Iterator<Map.Entry<g, f>> r68 = r64.entrySet().iterator();
    L104:
        if (r68.hasNext() == false) goto L109;
        Map.Entry<g, f> r69 = r68.next();
        g r70 = r69.getKey();
        f r72 = r69.getValue();
        if (r72 != null) goto L107;
        l(r70, r15);
        goto L104
    L107:
        k(r70, r15, r72);
        goto L104
    L109:
        Iterator<Map.Entry<g, f>> r73 = r66.entrySet().iterator();
    L111:
        if (r73.hasNext() == false) goto L113;
        r73.next().getKey().update(r15);
        goto L111
    L113:
        this.e.clear();
        ArrayList<g> r113 = this.e;
        ArrayList r74 = new ArrayList(r0.size());
        Iterator<Map.Entry<g, f>> r75 = r0.entrySet().iterator();
    L115:
        if (r75.hasNext() == false) goto L117;
        r74.add(r75.next().getKey());
        goto L115
    L117:
        r113.addAll(r74);
        ((LinkedHashMap) this.f).clear();
        Iterator<Map.Entry<g, f>> r114 = r0.entrySet().iterator();
    L119:
        if (r114.hasNext() == false) goto L123;
        Map.Entry<g, f> r76 = r114.next();
        f r77 = r76.getValue();
        if (r77 == null) goto L119;
        this.f.put(r76.getKey(), r77);
        goto L119
    L123:
        this.a.getLifecycleState().a(new com.bytedance.android.live.profile.model.b(LifecycleStateType.UPDATE_FINISHED));
        return;
    L38:
        if (((Boolean) r13.a.a.invoke(r15)).booleanValue() == false) goto L44;
        Map<g, f> r78 = r14.a;
        g r79 = (g) r16.get(ComponentType.ShopComponent.INSTANCE);
        if (r79 != null) goto L42;
        r79 = (g) r13.a.b.invoke();
    L42:
        r78.put(r79, null);
        goto L50
    L44:
        if (((Boolean) r13.b.a.invoke(r15)).booleanValue() == false) goto L49;
        Map<g, f> r80 = r14.a;
        g r82 = (g) r16.get(ComponentType.StandardHonourWall.INSTANCE);
        if (r82 != null) goto L48;
        r82 = (g) r13.b.b.invoke();
    L48:
        r80.put(r82, null);
        goto L50
    L49:
        Unit r83 = Unit.INSTANCE;
        goto L50
    L32:
        r28 = null;
        goto L33
    }

    public BaseUiBehavior(Fragment r3, com.bytedance.android.live.profile.model.d r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "type");
        this.k = r3;
        this.l = r4;
        NewProfileInfoViewModel r0 = jc1.k.n(ILiveProfilePlatformService.class).createProfileViewModel(r3);
        this.a = r0;
        this.b = r4.a;
        this.c = r4.b;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.h = new ProfileComponentManagerImp();
        this.i = new com.bytedance.android.live.profile.profilecontext.a(r0, new com.bytedance.android.live.profile.profilecontext.b(r3, r3.getView()));
        this.j = new CompositeDisposable();
    }

    public DataAssembler<? extends com.bytedance.android.live.profile.ui.component.base.b> f(ProfileTextInfoComponent r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "user");
        r2.h(new st0.g(0));
        return r2;
    }

    public DataAssembler g(ProfileStandardTagListComponent r3, final NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "user");
        r3.i(new st0.f(8), new BaseUiBehavior$configTagListComponent$1(r4));
        r3.h(new st0.f(7));
        r3.h(new st0.f(0));
        r3.h(new st0.f(1));
        r3.h(new st0.f(2));
        r3.h(new st0.f(3));
        r3.h(new st0.f(4));
        r3.h(new st0.f(5));
        r3.h(new st0.f(6));
        ot0.e r5 = new ot0.e(this.k, this.a);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r3.c = r5;
        return r3;
    }

    public y h(y r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "user");
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L5;
        return null;
    L5:
        int r1 = y.g;
        String r5 = y.a.b(r4);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r3.h(new st0.g(2, r5));
        return r3;
    }

    public final void l(final g r7, final NewProfileUser r8) {
        r7.f();
        ProfileMonitor.a r0 = ProfileMonitor.g;
        com.bytedance.android.live.profile.profilecontext.a r1 = this.i;
        ProfileMonitor r2 = null;
        if (r1 == null) goto L5;
        ProfileMonitor r3 = r1.getProfileMonitor();
    L6:
        ComponentType r4 = r7.getComponentType();
        LifecycleType r5 = LifecycleType.BindUserData;
        Function0<Unit> r6 = new BaseUiBehavior$initOldComponent$1(r7, r8);
        r0.getClass();
        ProfileMonitor.a.c(r3, r4, r5, r6);
        com.bytedance.android.live.profile.profilecontext.a r9 = this.i;
        if (r9 == null) goto L9;
        r2 = r9.getProfileMonitor();
    L9:
        ProfileMonitor.a.c(r2, r7.getComponentType(), LifecycleType.LoadSkin, new BaseUiBehavior$initOldComponent$2(r7, r8));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void k(final g r8, final NewProfileUser r9, f r10) {
        r8.f();
        com.bytedance.android.live.profile.profilecontext.a r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        final c r12 = r10.b(r0);
        View r1 = this.k.getView();
        if (r1 == null) goto L12;
        final ViewGroup r2 = (ViewGroup) r1.findViewById(r12.a);
        if (r2 == null) goto L13;
        ProfileMonitor.a r3 = ProfileMonitor.g;
        ProfileMonitor r4 = r0.getProfileMonitor();
        ComponentType r5 = r8.getComponentType();
        LifecycleType r6 = LifecycleType.InitView;
        Function0<Unit> r7 = new BaseUiBehavior$initDescriptionComponent$1(this, r8, r2, r12);
        r3.getClass();
        ProfileMonitor.a.c(r4, r5, r6, r7);
        ProfileMonitor.a.c(r0.getProfileMonitor(), r8.getComponentType(), LifecycleType.BindUserData, new BaseUiBehavior$initDescriptionComponent$2(r8, r9));
        return;
    L13:
        return;
    }
}
