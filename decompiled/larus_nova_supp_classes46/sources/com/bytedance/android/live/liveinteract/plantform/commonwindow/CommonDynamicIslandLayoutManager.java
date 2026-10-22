package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.k51;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import tf0.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonDynamicIslandLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonDynamicIslandLayoutManager extends RecyclerView.LayoutManager implements Observer<KVData>, ug0.a {
    public final String a;
    public final CompositeDisposable b;
    public RecyclerView c;
    public boolean d;
    public final Map<Integer, List<tf0.a>> e;
    public Boolean f;
    public Boolean g;
    public boolean h;
    public final List<Float> i;
    public final int j;
    public final double k;
    public Function0<Unit> l;
    public final DataCenter m;
    public final boolean n;

    @Override // ug0.a
    public final void U3(m r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layoutConfig");
    }

    @Override // ug0.a
    public final void e(int r1) {
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // ug0.a
    public final boolean isDynamicAnimating() {
        return this.d;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r3) {
        return new Pair(Integer.valueOf(s1.f(80.0f)), Integer.valueOf(s1.f(80.0f)));
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r2) {
        return new Pair(0, 0);
    }

    public final void onAttachedToWindow(RecyclerView r3) {
        super.onAttachedToWindow(r3);
        this.c = r3;
        ALogger.i(this.a, "observe DATA_DYNAMIC_ISLAND_LAYOUT_ANIMTE animRecyclerView=" + this.n + ", this=" + this + ", dataCenter=" + this.m + ", stack=" + Log.getStackTraceString(new Throwable()));
        DataCenter r4 = this.m;
        if (r4 == null) goto L6;
        r4.observeForever("data_dynamic_island_layout_animte", this);
    L6:
        if (this.n == true) goto L11;
        DataCenter r5 = this.m;
        if (r5 == null) goto L12;
        r5.observeForever("data_dynamic_island_layout_seat_update", this);
        return;
    L12:
        return;
    }

    public final void onChanged(Object r8) {
        final KVData r9 = (KVData) r8;
        Object r0 = null;
        if (r9 == null) goto L5;
        String r1 = r9.getKey();
    L6:
        if (r1 == null) goto L59;
        int r2 = r1.hashCode();
        if (r2 == (-591676989)) goto L25;
        if (r2 == (-53645630)) goto L14;
        return;
    L14:
        if (r1.equals("data_dynamic_island_layout_animte") == false) goto L45;
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r3 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r3 != null) goto L18;
    L23:
        u((u) r9.getData());
        return;
    L18:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r3) != true) goto L23;
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = null;
        r4.element = new AnonymousClass1(this, r9, r4);
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r10 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r10 == null) goto L22;
        r10.zn((Function0) r4.element);
    L22:
        ALogger.i(this.a, "3d兼容-灵活布局动画到来，但3d动画播放中，等待3d动画播完... layoutManager=" + this);
        return;
    L45:
        return;
    L25:
        if (r1.equals("data_dynamic_island_layout_seat_update") == false) goto L57;
        Object r11 = r9.getData();
        if ((r11 instanceof Integer) == false) goto L30;
        r0 = r11;
    L30:
        Integer r5 = (Integer) r0;
        if (r5 == null) goto L58;
        int r12 = r5.intValue();
        Iterator r6 = ((LinkedHashMap) this.e).entrySet().iterator();
    L34:
        if (r6.hasNext() == false) goto L61;
        Map.Entry r7 = (Map.Entry) r6.next();
        Integer r13 = (Integer) r7.getKey();
        if (r13 == null) goto L34;
        if (r12 != r13.intValue()) goto L34;
        List<tf0.a> r14 = (List) r7.getValue();
        Animator r15 = t(Integer.valueOf(r12), r14, true, false);
        ALogger.i(this.a, "获取绑定一个麦位的动画组 pos=" + r12 + ", animGroupList=" + r14);
        if (r15 == null) goto L43;
        r15.setDuration(0);
    L43:
        if (r15 == null) goto L34;
        r15.start();
        goto L34
    L61:
        return;
    L58:
        return;
    L57:
        return;
    L59:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final AnimatorSet s(final u r11) {
        Intrinsics.checkNotNullParameter(r11, "seatAnimateInfo");
        AnimatorSet r0 = new AnimatorSet();
        AnimatorSet.Builder r2 = r0.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        Map<String, List<tf0.a>> r4 = r11.a();
        if (r4 == null) goto L12;
        Iterator<Map.Entry<String, List<tf0.a>>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<String, List<tf0.a>> r6 = r5.next();
        String r7 = r6.getKey();
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(CastIntegerProtector.parseInt(r7));
    L11:
        List<tf0.a> r9 = r6.getValue();
        Animator r10 = t(r8, r9, false, true);
        ALogger.i(this.a, "获取一个麦位的动画组 " + r9);
        w(r2, r10);
        goto L6
    L10:
        r8 = null;
    L12:
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r0, new CommonDynamicIslandLayoutManager$doAnimate$2(this, r11));
        ALogger.i(this.a, "执行灵活布局动画 " + r0);
        r0.start();
        this.d = true;
        return r0;
    }

    @Override // ug0.a
    public final void setDynamicAnimatorListener(Function0<Unit> r1) {
        this.l = r1;
    }

    public final AnimatorSet u(u r6) {
        if (r6 != null) goto L26;
        return null;
    L26:
        ALogger.i(this.a, "processAnimateInfo, lynxRelative=" + this.g + " nativeRelative=" + this.f + " seatAnimateInfo=" + r6);     // Catch: Exception -> L23
        String r1 = this.a;     // Catch: Exception -> L23
        StringBuilder r3 = new StringBuilder("processAnimateInfo, stack_track=");     // Catch: Exception -> L23
        r3.append(Log.getStackTraceString(new Throwable()));     // Catch: Exception -> L23
        ALogger.i(r1, r3.toString());     // Catch: Exception -> L23
        if (this.g != null) goto L13;
        Boolean r0 = r6.c();     // Catch: Exception -> L23
        if (r0 == null) goto L10;
        boolean r2 = r0.booleanValue();     // Catch: Exception -> L23
    L11:
        this.g = Boolean.valueOf(r2);     // Catch: Exception -> L23
        goto L13
    L10:
        r2 = false;
    L13:
        if (Intrinsics.areEqual(r6.getType(), "add") == false) goto L15;
        x(r6);     // Catch: Exception -> L23
        AnimatorSet r4 = s(r6);     // Catch: Exception -> L23
    L17:
        if (getChildCount() != 0) goto L19;
    L22:
        return r4;
    L19:
        if (this.n == false) goto L21;
        r6.b = true;     // Catch: Exception -> L23
        goto L22
    L21:
        r6.a = true;     // Catch: Exception -> L23
        goto L22
    L15:
        x(r6);     // Catch: Exception -> L23
        r4 = s(r6);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ALogger.e(this.a, "processAnimateInfo error!", e);
        return null;
    }

    public final void x(u r4) {
        if (r4 == null) goto L13;
        Map<String, List<tf0.a>> r5 = r4.a();
        if (r5 == null) goto L17;
        Iterator<Map.Entry<String, List<tf0.a>>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, List<tf0.a>> r0 = r6.next();
        String r1 = r0.getKey();
        if (r1 == null) goto L11;
        Integer r2 = Integer.valueOf(CastIntegerProtector.parseInt(r1));
    L12:
        List<tf0.a> r3 = r0.getValue();
        this.e.put(r2, r3);
        goto L7
    L11:
        r2 = null;
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public CommonDynamicIslandLayoutManager(DataCenter r7, boolean r8) {
        this.m = r7;
        this.n = r8;
        this.a = "CommonDynamicIslandLayoutManager";
        this.b = new CompositeDisposable();
        this.e = new LinkedHashMap();
        this.h = true;
        ReadOnlyProperty r9 = vm2.d.R7;
        KProperty[] r0 = vm2.d.a;
        List<Float> r2 = ((k51) r9.getValue(null, r0[456(0x1c8, float:6.39E-43)])).c();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.35f), Float.valueOf(0.39f), Float.valueOf(0.42f)});
    L5:
        this.i = r2;
        this.j = ((k51) r9.getValue(null, r0[456(0x1c8, float:6.39E-43)])).a();
        this.k = ((k51) r9.getValue(null, r0[456(0x1c8, float:6.39E-43)])).b();
    }

    public static void w(AnimatorSet.Builder r1, Animator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeWith");
        if (r2 == null) goto L6;
        r1.with(r2);
        return;
    }

    public final void onAdapterChanged(RecyclerView.Adapter<?> r3, RecyclerView.Adapter<?> r4) {
        super.onAdapterChanged(r3, r4);
        ALogger.w(this.a, "attach-dettach test, onAdapterChanged newAdapter " + r4);
    }

    public final void onDetachedFromWindow(RecyclerView r2, RecyclerView.Recycler r3) {
        super.onDetachedFromWindow(r2, r3);
        ALogger.i(this.a, "remove DATA_DYNAMIC_ISLAND_LAYOUT_ANIMTE animRecyclerView=" + this.n + ", this=" + this + ", dataCenter=" + this.m + ", stack=" + Log.getStackTraceString(new Throwable()));
        DataCenter r4 = this.m;
        if (r4 == null) goto L5;
        r4.removeObserver(this);
    L5:
        this.b.clear();
        if (this.n == true) goto L11;
        DataCenter r5 = this.m;
        if (r5 == null) goto L12;
        r5.put("data_dynamic_island_layout_animte", null);
        return;
    L12:
        return;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r21, RecyclerView.State r22) {
        Intrinsics.checkNotNullParameter(r21, "recycler");
        Intrinsics.checkNotNullParameter(r22, "state");
        if (r22.getItemCount() >= 8) goto L6;
        removeAndRecycleAllViews(r21);
        return;
    L6:
        detachAndScrapAttachedViews(r21);
        int r8 = r22.getItemCount();
        int r10 = 0;
    L7:
        if (r10 >= r8) goto L16;
        System.currentTimeMillis();
        View r11 = r21.getViewForPosition(r10);
        if (r11 == null) goto L10;
        Pair<Integer, Integer> r0 = a(r10);
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        r11.getLayoutParams().width = r1;
        r11.getLayoutParams().height = r2;
        addView(r11);
        measureChildWithMargins(r11, 0, 0);
        layoutDecoratedWithMargins(r11, 0 - getDecoratedMeasuredWidth(r11), 0 - getDecoratedMeasuredHeight(r11), 0, 0);
        View r3 = r11.findViewById(2131389701);
        if (r3 == null) goto L14;
        r3.setAlpha(0.0f);
    L14:
        r10 = r10 + 1;
        goto L7
    L10:
        return;
    L16:
        if (this.h == false) goto L63;
        DataCenter r4 = this.m;
        PointF r5 = null;
        if (r4 == null) goto L20;
        u r6 = (u) r4.get("data_dynamic_island_layout_animte", null);
    L22:
        if (r6 == null) goto L40;
        boolean r7 = this.n;
        if (r7 == false) goto L26;
        boolean r9 = r6.b;
    L27:
        if (r9 == true) goto L40;
        if (r7 == false) goto L30;
        boolean r12 = r6.b;
    L31:
        if (r12 == true) goto L54;
        String r13 = this.a;
        if (r7 == false) goto L35;
        String r14 = "动画rv";
    L36:
        ALogger.i(r13, "3d兼容-第一次布局Lynx... ".concat(r14));
        AnimatorSet r15 = u(r6);
        this.d = true;
        if (r15 == null) goto L54;
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r15, new CommonDynamicIslandLayoutManager$onLayoutChildrenLynx$$inlined$let$lambda$1(this));
        goto L54
    L35:
        r14 = "布局rv";
    L54:
        this.h = false;
        return;
    L30:
        r12 = r6.a;
        goto L31
    L26:
        r9 = r6.a;
    L40:
        ALogger.i(this.a, "3d兼容-第一次布局Natvie更新...");
        AnimatorSet r16 = new AnimatorSet();
        AnimatorSet.Builder r17 = r16.play(ValueAnimator.ofInt(new int[]{1}).setDuration(0));
        int r18 = getItemCount();
        int r19 = 0;
    L41:
        if (r19 >= r18) goto L53;
        ArrayList r20 = new ArrayList();
        RecyclerView r23 = this.c;
        if (r23 == null) goto L47;
        double r110 = ((((double) r19) * ((1.0d / ((double) 9)) * ((double) 360))) - ((double) 90)) * 0.017453292519943295d;
        double r24 = ((Number) ListProtector.get(this.i, 2)).floatValue() * r23.getHeight();
        r5 = new PointF((float) (((double) (r23.getX() + (r23.getWidth() / 2))) + (Math.cos(r110) * r24)), (float) ((((double) (r23.getHeight() / 2)) + (Math.sin(r110) * r24)) + ((double) 15)));
        r5.x = s1.G((int) r5.x);
        r5.y = s1.G((int) r5.y);
    L47:
        if (r5 != null) goto L49;
        tf0.a r111 = null;
    L50:
        if (r111 == null) goto L52;
        r20.add(r111);
    L52:
        int r25 = this.j;
        AnimatorSet r112 = r16;
        double r26 = 2;
        double r113 = 1;
        r20.add(new tf0.a("gift_icon", CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(this.k * r113)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(((double) r25) / r26)), TuplesKt.to("y", Double.valueOf(r25 - 9))}))})));
        int r27 = this.j;
        r20.add(new tf0.a("nickname", CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(r113 * this.k)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(((double) r27) / r26)), TuplesKt.to("y", Double.valueOf(r27 + 8))}))})));
        this.f = Boolean.TRUE;
        AnimatorSet.Builder r28 = r17;
        w(r28, t(Integer.valueOf(r19), r20, false, true));
        r19 = r19 + 1;
        r17 = r28;
        r18 = r18;
        r16 = r112;
        r5 = null;
        goto L41
    L49:
        r111 = new tf0.a("seat", CollectionsKt.mutableListOf(new tf0.t[]{new tf0.t("scale", Double.valueOf(((double) 1) * this.k)), new tf0.t("translate", MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Double.valueOf(r5.x)), TuplesKt.to("y", Double.valueOf(r5.y))}))}));
        goto L50
    L53:
        AnimatorSet r114 = r16;
        this.d = true;
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r114, new CommonDynamicIslandLayoutManager$onLayoutChildrenNative$4(this));
        r114.start();
        goto L54
    L20:
        r6 = null;
        goto L22
    }

    public final Float q(Float r2, View r3) {
        if (r2 == null) goto L10;
        if (r3 == null) goto L12;
        int r0 = r3.getWidth();
        r3.getHeight();
        RecyclerView r4 = this.c;
        if (r4 == null) goto L9;
        r4.getY();
    L9:
        return Float.valueOf(r2.floatValue() - (r0 / 2));
    L12:
        return null;
    L10:
        return null;
    }

    public static boolean p(CommonDynamicIslandLayoutManager r0, Float r1, Float r2) {
        r0.getClass();
        if (Intrinsics.areEqual(r1, r2) == false) goto L6;
    L7:
        return true;
    L6:
        if (Math.abs(r1.floatValue() - r2.floatValue()) < 0.001f) goto L7;
        return false;
    }

    public static Float r(CommonDynamicIslandLayoutManager r2, Float r3, View r4) {
        Boolean r0 = r2.g;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        boolean r1 = r0.booleanValue();
    L9:
        boolean r5 = !r1;
        r2.getClass();
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        r4.getWidth();
        int r6 = r4.getHeight();
        RecyclerView r7 = r2.c;
        if (r7 == null) goto L16;
        Number r8 = Float.valueOf(r7.getY());
    L17:
        if (r5 == false) goto L23;
        return Float.valueOf((r3.floatValue() - (r6 / 2)) - r8.intValue());
    L23:
        return Float.valueOf(r3.floatValue() - (r6 / 2));
    L16:
        r8 = 0;
    L20:
        return null;
    L5:
        Boolean r9 = r2.f;
        if (r9 == null) goto L8;
        Intrinsics.checkNotNull(r9);
        r1 = r9.booleanValue();
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    public final Animator t(Integer r8, List<tf0.a> r9, boolean r10, boolean r11) {
        AnimatorSet r0 = null;
        if (r8 == null) goto L5;
        View r1 = getChildAt(r8.intValue());
    L6:
        if (r8 == null) goto L32;
        if (r9 == null) goto L32;
        if (r1 == null) goto L32;
        int r12 = r8.intValue();
        r0 = new AnimatorSet();
        AnimatorSet.Builder r2 = r0.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        Iterator<T> r13 = r9.iterator();
    L11:
        if (r13.hasNext() == false) goto L32;
        tf0.a r3 = (tf0.a) r13.next();
        String r4 = r3.b();
        if (r4 == null) goto L11;
        int r5 = r4.hashCode();
        if (r5 != 3526149) goto L18;
        if (r4.equals("seat") == false) goto L11;
        if (r10 == true) goto L11;
        w(r2, v(r1, r3, r11, Integer.valueOf(r12)));
        goto L11
    L18:
        if (r5 != 70690926) goto L20;
        if (r4.equals("nickname") == false) goto L11;
        w(r2, v(r1.findViewById(2131389587), r3, r11, Integer.valueOf(r12)));
        w(r2, v(r1.findViewById(2131389541), r3, r11, Integer.valueOf(r12)));
        goto L11
    L20:
        if (r5 != 570280488) goto L11;
        if (r4.equals("gift_icon") == false) goto L11;
        w(r2, v(r1.findViewById(2131389570), r3, r11, Integer.valueOf(r12)));
        w(r2, v(r1.findViewById(2131389576), r3, r11, Integer.valueOf(r12)));
    L32:
        return r0;
    L5:
        r1 = null;
        goto L6
    }

    public final AnimatorSet v(final View r29, tf0.a r30, boolean r31, Integer r32) {
        if (r29 != null) goto L5;
        return null;
    L5:
        AnimatorSet r4 = new AnimatorSet();
        AnimatorSet.Builder r6 = r4.play(ValueAnimator.ofInt(new int[]{1}).setDuration(1));
        List<tf0.t> r10 = r30.a();
        if (r10 == null) goto L249;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L249;
        tf0.t r12 = (tf0.t) r11.next();
        String r13 = r12.f();
        float r16 = 1.0f;
        int r15 = 2;
        switch(r13.hashCode()) {
            case -1392296225: goto L181;
            case -1267206133: goto L157;
            case -787957717: goto L141;
            case 109250890: goto L117;
            case 1052832078: goto L15;
            default: goto L12;
        };
    L12:
        r4 = r4;
        r6 = r6;
        r11 = r11;
        long r5 = 1;
    L247:
        r11 = r11;
        r6 = r6;
        r4 = r4;
        goto L9
    L117:
        r4 = r4;
        r6 = r6;
        r11 = r11;
        long r7 = 1;
        if (r13.equals("scale") == false) goto L140;
        Object r3 = r12.h();
        if ((r3 instanceof Double) == true) goto L122;
        r3 = null;
    L122:
        Double r8 = (Double) r3;
        if (r8 == null) goto L125;
        r16 = (float) r8.doubleValue();
    L125:
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(r29, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{r16}), PropertyValuesHolder.ofFloat("scaleY", new float[]{r16})});
        r9.setDuration(r12.c());
        Long r14 = r12.b();
        if (r14 == null) goto L128;
        r9.setStartDelay(r14.longValue());
    L128:
        List<Float> r17 = r12.e();
        if (r17 != null) goto L131;
    L136:
        Long r18 = r12.g();
        if (r18 == null) goto L139;
        r9.setRepeatCount((int) r18.longValue());
    L139:
        w(r6, r9);
        goto L140
    L131:
        if (r17.size() < 4) goto L134;
        r9.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r17, 0)).floatValue(), ((Number) ListProtector.get(r17, 1)).floatValue(), ((Number) ListProtector.get(r17, 2)).floatValue(), ((Number) ListProtector.get(r17, 3)).floatValue()));
        goto L136
    L134:
        if (r17.size() < 2) goto L136;
        r9.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r17, 0)).floatValue(), ((Number) ListProtector.get(r17, 1)).floatValue()));
    L140:
        r5 = r7;
        goto L247
    L141:
        r4 = r4;
        r6 = r6;
        r11 = r11;
        if (r13.equals("wiggle") == false) goto L180;
        long r19 = r12.c();
        Long r20 = r12.g();
        if (r20 == null) goto L146;
        long r21 = r20.longValue();
    L147:
        long r22 = r19 * r21;
        ValueAnimator r23 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(0);
        r23.setDuration(r22);
        Object r24 = r12.h();
        if ((r24 instanceof Double) == true) goto L150;
        r24 = null;
    L150:
        Double r25 = (Double) r24;
        if (r25 == null) goto L153;
        r16 = (float) r25.doubleValue();
    L153:
        final float r110 = r29.getX();
        final float r111 = r29.getY();
        ALogger.i(this.a, "wiggle at(" + r110 + ',' + r111 + "),duration=" + r22 + ",amp=");
        r23.addUpdateListener(new d(((float) 5) * r16, r29, r110, r111));
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r23, new CommonDynamicIslandLayoutManager$getWiggleAnimate$2(r29, r110, r111));
        Long r26 = r12.b();
        if (r26 == null) goto L156;
        r23.setStartDelay(r26.longValue());
    L156:
        w(r6, r23);
        goto L180
    L146:
        r21 = 1;
    L180:
        r5 = 1;
        goto L247
    L157:
        r4 = r4;
        r6 = r6;
        r11 = r11;
        if (r13.equals("opacity") == false) goto L180;
        Object r27 = r12.h();
        if ((r27 instanceof Double) == true) goto L162;
        r27 = null;
    L162:
        Double r28 = (Double) r27;
        if (r28 == null) goto L165;
        r16 = (float) r28.doubleValue();
    L165:
        ObjectAnimator r33 = ObjectAnimator.ofPropertyValuesHolder(r29, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{r16})});
        r33.setDuration(r12.c());
        Long r34 = r12.b();
        if (r34 == null) goto L168;
        r33.setStartDelay(r34.longValue());
    L168:
        List<Float> r35 = r12.e();
        if (r35 != null) goto L171;
    L176:
        Long r36 = r12.g();
        if (r36 == null) goto L179;
        r33.setRepeatCount((int) r36.longValue());
    L179:
        w(r6, r33);
        goto L180
    L171:
        if (r35.size() < 4) goto L174;
        r33.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r35, 0)).floatValue(), ((Number) ListProtector.get(r35, 1)).floatValue(), ((Number) ListProtector.get(r35, 2)).floatValue(), ((Number) ListProtector.get(r35, 3)).floatValue()));
        goto L176
    L174:
        if (r35.size() < 2) goto L176;
        r33.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r35, 0)).floatValue(), ((Number) ListProtector.get(r35, 1)).floatValue()));
        goto L176
    L181:
        r4 = r4;
        r6 = r6;
        r11 = r11;
        r5 = 1;
        if (r13.equals("bezier") == false) goto L247;
        Object r37 = r12.d();
        if ((r37 instanceof Map) == true) goto L186;
        r37 = null;
    L186:
        Map r38 = (Map) r37;
        if (r38 == null) goto L191;
        Double r39 = (Double) r38.get("x");
        if (r39 == null) goto L191;
        Float r40 = Float.valueOf(s1.f((float) r39.doubleValue()));
    L192:
        Object r41 = r12.d();
        if ((r41 instanceof Map) == true) goto L195;
        r41 = null;
    L195:
        Map r42 = (Map) r41;
        if (r42 == null) goto L200;
        Double r43 = (Double) r42.get("y");
        if (r43 == null) goto L200;
        Float r44 = Float.valueOf(s1.f((float) r43.doubleValue()));
    L201:
        Object r112 = r12.h();
        if ((r112 instanceof Map) == true) goto L204;
        r112 = null;
    L204:
        Map r113 = (Map) r112;
        if (r113 == null) goto L209;
        Double r45 = (Double) r113.get("x");
        if (r45 == null) goto L209;
        Float r46 = Float.valueOf(s1.f((float) r45.doubleValue()));
    L210:
        Object r114 = r12.h();
        if ((r114 instanceof Map) == true) goto L213;
        r114 = null;
    L213:
        Map r115 = (Map) r114;
        if (r115 == null) goto L218;
        Double r47 = (Double) r115.get("y");
        if (r47 == null) goto L218;
        Float r48 = Float.valueOf(s1.f((float) r47.doubleValue()));
    L219:
        if (r40 == null) goto L244;
        if (r44 == null) goto L244;
        if (r46 == null) goto L244;
        if (r48 == null) goto L244;
        if (p(this, r40, r46) == true) goto L226;
    L228:
        ALogger.i(this.a, "bezier from(" + r40 + ',' + r44 + ")->to(" + r46 + ',' + r48 + "), pos=" + r32);
        Path r116 = new Path();
        r116.moveTo(r40.floatValue(), r44.floatValue());
        List<tf0.s> r49 = r12.a();
        if (r49 == null) goto L244;
        List<tf0.s> r50 = r49;
        ArrayList r51 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r50, 10));
        Iterator<T> r52 = r50.iterator();
    L232:
        if (r52.hasNext() == false) goto L234;
        tf0.s r117 = (tf0.s) r52.next();
        r51.add(new tf0.s(s1.f(r117.a()), s1.f(r117.b())));
        goto L232
    L234:
        int r53 = r51.size();
        if (r53 != 0) goto L237;
        r116.lineTo(r46.floatValue(), r48.floatValue());
    L241:
        PathMeasure r54 = new PathMeasure(r116, false);
        ValueAnimator r55 = ValueAnimator.ofFloat(new float[]{0.0f, r54.getLength()});
        r55.addUpdateListener(new b(this, r54, r29, r32));
        r55.setDuration(r12.c());
        Long r56 = r12.b();
        if (r56 == null) goto L245;
        r55.setStartDelay(r56.longValue());
    L245:
        w(r6, r55);
        goto L247
    L237:
        if (r53 == 1) goto L239;
        r116.cubicTo(((tf0.s) ListProtector.get(r51, 0)).a(), ((tf0.s) ListProtector.get(r51, 0)).b(), ((tf0.s) ListProtector.get(r51, 1)).a(), ((tf0.s) ListProtector.get(r51, 1)).b(), r46.floatValue(), r48.floatValue());
        goto L241
    L239:
        r116.quadTo(((tf0.s) ListProtector.get(r51, 0)).a(), ((tf0.s) ListProtector.get(r51, 0)).b(), r46.floatValue(), r48.floatValue());
        goto L241
    L226:
        if (p(this, r44, r48) == false) goto L228;
    L244:
        r55 = null;
    L218:
        r48 = null;
    L209:
        r46 = null;
    L200:
        r44 = null;
    L191:
        r40 = null;
        goto L192
    L15:
        if (r13.equals("translate") == false) goto L116;
        boolean r118 = Intrinsics.areEqual(r30.b(), "seat");
        Object r119 = r12.h();
        if ((r119 instanceof Map) == true) goto L19;
        r119 = null;
    L19:
        Map r120 = (Map) r119;
        if (r120 == null) goto L24;
        Double r121 = (Double) r120.get("x");
        if (r121 == null) goto L24;
        Float r122 = Float.valueOf(s1.f((float) r121.doubleValue()));
    L25:
        Object r123 = r12.h();
        if ((r123 instanceof Map) == true) goto L28;
        r123 = null;
    L28:
        Map r124 = (Map) r123;
        if (r124 == null) goto L33;
        Double r57 = (Double) r124.get("y");
        if (r57 == null) goto L33;
        Float r58 = Float.valueOf(s1.f((float) r57.doubleValue()));
    L34:
        if (r122 == null) goto L78;
        if (r58 == null) goto L78;
        if (r118 == false) goto L43;
        r122 = q(r122, r29);
        Float r59 = r(this, r58, r29);
        if (r59 == null) goto L40;
        r58 = Float.valueOf(r59.floatValue() + s1.f(10.0f));
    L41:
        ALogger.i(this.a, "translate to(" + r122 + ',' + r58 + ')');
        goto L78
    L40:
        r58 = null;
        goto L41
    L43:
        int r60 = r29.getWidth();
        int r61 = r29.getHeight();
        Object r125 = r29.getParent();
        if ((r125 instanceof View) == true) goto L46;
        r125 = null;
    L46:
        View r126 = (View) r125;
        if (r126 == null) goto L50;
        View r62 = r126.findViewById(2131389564);
        if (r62 == null) goto L50;
    L57:
        if (r62 != null) goto L59;
        Pair r63 = null;
    L69:
        if (r63 == null) goto L72;
        Number r127 = (Integer) r63.getSecond();
        if (r127 == null) goto L72;
    L73:
        if (r63 == null) goto L76;
        Number r65 = (Integer) r63.getFirst();
        if (r65 == null) goto L76;
    L77:
        ALogger.i(this.a, "element " + r30.b() + " translate to(" + r122 + ',' + r58 + "), avatar left " + r65 + " top " + r127 + ", width " + r60 + " height " + r61);
        r122 = Float.valueOf(r122.floatValue() + r65.floatValue());
        r58 = Float.valueOf(r58.floatValue() + r127.floatValue());
    L76:
        r65 = Float.valueOf(0.0f);
    L72:
        r127 = Float.valueOf(0.0f);
        goto L73
    L59:
        int r128 = 0;
        int r129 = 0;
        int r210 = 0;
    L60:
        if (r128 >= r15) goto L68;
        if ((r62.getParent() instanceof View) == false) goto L68;
        r129 = r129 + r62.getLeft();
        r210 = r210 + r62.getTop();
        Object r66 = r62.getParent();
        if (r66 == null) goto L67;
        r62 = (View) r66;
        r128 = r128 + 1;
        r15 = 2;
        goto L60
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L68:
        r63 = new Pair(Integer.valueOf(r129), Integer.valueOf(r210));
    L50:
        Object r67 = r29.getParent();
        if ((r67 instanceof View) == true) goto L53;
        r67 = null;
    L53:
        View r68 = (View) r67;
        if (r68 == null) goto L56;
        r62 = r68.findViewById(2131389607);
        goto L57
    L56:
        r62 = null;
    L78:
        if (r122 == null) goto L114;
        if (r58 == null) goto L114;
        float r69 = r58.floatValue();
        float r70 = r122.floatValue();
        if (r118 == false) goto L97;
        ObjectAnimator r71 = ObjectAnimator.ofPropertyValuesHolder(r29, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{r70}), PropertyValuesHolder.ofFloat("y", new float[]{r69})});
        r71.setDuration(r12.c());
        Long r72 = r12.b();
        if (r72 == null) goto L85;
        r71.setStartDelay(r72.longValue());
    L85:
        List<Float> r73 = r12.e();
        if (r73 != null) goto L88;
    L93:
        Long r74 = r12.g();
        if (r74 == null) goto L96;
        r71.setRepeatCount((int) r74.longValue());
    L96:
        r7 = 1;
        Animator r75 = r71;
    L115:
        w(r6, r75);
        goto L140
    L88:
        if (r73.size() < 4) goto L91;
        r71.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r73, 0)).floatValue(), ((Number) ListProtector.get(r73, 1)).floatValue(), ((Number) ListProtector.get(r73, 2)).floatValue(), ((Number) ListProtector.get(r73, 3)).floatValue()));
        goto L93
    L91:
        if (r73.size() < 2) goto L93;
        r71.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r73, 0)).floatValue(), ((Number) ListProtector.get(r73, 1)).floatValue()));
        goto L93
    L97:
        PointF r76 = new PointF(r29.getX(), r29.getY());
        PointF r77 = new PointF(r70, r69);
        r7 = 1;
        ValueAnimator r78 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1);
        r78.setDuration(r12.c());
        Long r79 = r12.b();
        if (r79 == null) goto L100;
        r78.setStartDelay(r79.longValue());
    L100:
        if (r31 == true) goto L102;
        r78.setDuration(0);
        r78.setStartDelay(0);
    L102:
        List<Float> r80 = r12.e();
        if (r80 != null) goto L105;
    L110:
        Long r81 = r12.g();
        if (r81 == null) goto L113;
        r78.setRepeatCount((int) r81.longValue());
    L113:
        r78.addUpdateListener(new c(r77, r76, this, r29));
        r75 = r78;
        goto L115
    L105:
        if (r80.size() < 4) goto L108;
        r78.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r80, 0)).floatValue(), ((Number) ListProtector.get(r80, 1)).floatValue(), ((Number) ListProtector.get(r80, 2)).floatValue(), ((Number) ListProtector.get(r80, 3)).floatValue()));
        goto L110
    L108:
        if (r80.size() < 2) goto L110;
        r78.setInterpolator(new PathInterpolator(((Number) ListProtector.get(r80, 0)).floatValue(), ((Number) ListProtector.get(r80, 1)).floatValue()));
    L114:
        r7 = 1;
        r75 = null;
    L33:
        r58 = null;
    L24:
        r122 = null;
        goto L25
    L116:
        r4 = r4;
        r6 = r6;
        r11 = r11;
    L249:
        return r4;
    }
}
