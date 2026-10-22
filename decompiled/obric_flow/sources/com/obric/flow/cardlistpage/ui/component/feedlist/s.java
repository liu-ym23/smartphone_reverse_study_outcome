package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Toast;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import cn.nubia.neopush.commons.Constant;
import com.drakeet.multitype.MultiTypeAdapter;
import com.lynx.tasm.behavior.p0;
import com.obric.flow.cardlistpage.R$dimen;
import com.obric.flow.cardlistpage.R$string;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.data.TravelCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.CardItemDecoration;
import com.obric.flow.cardlistpage.ui.drag.DragInsertRecyclerView;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import obric.flow.nlwidget.ui.feeds.drag.CardItemTouchHelperCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends com.obric.flow.cardlistpage.mvi.c {
    public static long A;
    public final Context d;
    public final RecyclerView e;
    public final gu.d f;
    public final AppWidgetManager g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final obric.flow.miniappwidget.l f11600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f11601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MultiTypeAdapter f11602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.obric.flow.cardlistpage.ui.viewbinder.h f11603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.flow.cardlistpage.ui.viewbinder.f f11604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CardItemTouchHelperCallback f11605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ItemTouchHelper f11606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public kq.b f11607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f11608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f11609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11610r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function2 f11611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.fragment.app.d f11612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Interpolator f11613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f11614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f11615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f11616y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f11617z;

    public s(Context r5, RecyclerView r10, CoroutineScope r11, gu.d r12, AppWidgetManager r13, obric.flow.miniappwidget.l r14, u r15, CardFeedLayout r16) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        Intrinsics.checkNotNullParameter(r12, "appWidgetHost");
        Intrinsics.checkNotNullParameter(r13, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r14, "miniAppWidgetHost");
        Intrinsics.checkNotNullParameter(r15, "owner");
        Intrinsics.checkNotNullParameter(r16, "parent");
        super(new w(new v(), 0), r11, r16);
        this.d = r5;
        this.e = r10;
        this.f = r12;
        this.g = r13;
        this.f11600h = r14;
        this.f11601i = r15;
        this.f11602j = new MultiTypeAdapter(0);
        this.f11608p = new Rect();
        this.f11609q = new Rect();
        this.f11611t = new FeedListComponent$renderInvalidationListener$1(this);
        this.f11612u = new androidx.fragment.app.d(this, 24);
        i();
        this.f11613v = PathInterpolatorCompat.create(0.25f, 0.46f, 0.45f, 0.94f);
        this.f11614w = 0.8f;
        this.f11615x = 0.7f;
        this.f11616y = 1.0f;
    }

    public static final void k(s r10, BaseCardModel r11) {
        r10.getClass();
        if ((r11 instanceof MiniAppWidgetCardModel) == false) goto L5;
        MiniAppWidgetCardModel r12 = (MiniAppWidgetCardModel) r11;
    L6:
        if (r12 == null) goto L14;
        obric.flow.miniappwidget.l r13 = r10.f11600h;
        String r5 = r13.f20491a;
        String r14 = r12.getId();
        String r15 = r12.getInstanceId();
        String r16 = r12.getAppletId();
        String r17 = r12.getWidgetId();
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("miniAppWidget destroy hostId=", r5, " cardId=", r14, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r18, r15, " appletId=", r16, " widgetId=");
        String r19 = androidx.room.jarjarred.org.antlr.runtime.a.w(r18, r17, "FeedListComponent", "tag", "msg");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L13;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r19);
        r13.d(r12.getInstanceId(), r12.getAppletId(), r12.getWidgetId());
        return;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L14:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static final Object l(s r17, List r18, ContinuationImpl r19) {
        r17.getClass();
        if ((r19 instanceof FeedListComponent$refreshMiniAppWidgets$1) == false) goto L7;
        FeedListComponent$refreshMiniAppWidgets$1 r5 = (FeedListComponent$refreshMiniAppWidgets$1) r19;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
        s r11 = r17;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        Iterator r15 = (Iterator) r5.L$1;
        s r16 = (s) r5.L$0;
        ResultKt.throwOnFailure(r12);
        Iterator r20 = r15;
        r11 = r16;
    L22:
        if (r20.hasNext() == false) goto L39;
        MiniAppWidgetCardModel r21 = (MiniAppWidgetCardModel) r20.next();
        String r22 = r11.f11600h.f20491a;
        String r23 = r21.getId();
        String r24 = r21.getInstanceId();
        String r25 = r21.getAppletId();
        String r110 = r21.getWidgetId();
        StringBuilder r26 = androidx.constraintlayout.motion.widget.a.y("miniAppWidget refresh hostId=", r22, " cardId=", r23, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r26, r24, " appletId=", r25, " widgetId=");
        String r27 = androidx.room.jarjarred.org.antlr.runtime.a.w(r26, r110, "FeedListComponent", "tag", "msg");
        org.koin.core.a r111 = su.a.f22013b;
        if (r111 == null) goto L37;
        ((ju.b) r111.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r27);
        String r28 = r21.getInstanceId();
        r5.L$0 = r11;
        r5.L$1 = r20;
        r5.label = 1;
        obric.flow.miniappwidget.l r29 = r11.f11600h;
        obric.flow.miniappwidget.a r30 = (obric.flow.miniappwidget.a) r29.f.get(r28);
        if (r30 == null) goto L31;
        StringBuilder r112 = new StringBuilder("refreshWidget hostId=");
        androidx.constraintlayout.motion.widget.a.C(r112, r29.f20491a, " instanceId=", r28, " cardId=");
        r112.append(r30.f20458c);
        r112.append(" appletId=");
        r112.append(r30.d);
        r112.append(" widgetId=");
        String r31 = androidx.room.jarjarred.org.antlr.runtime.a.w(r112, r30.e, "MiniAppWidgetHost", "tag", "msg");
        org.koin.core.a r32 = su.a.f22013b;
        if (r32 == null) goto L35;
        ((ju.b) r32.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r31);
        if (r30.f(r5) != r13) goto L22;
        goto L22
    L35:
        throw new IllegalStateException("KoinApplication has not been started");
    L31:
        if (Boxing.boxBoolean(false) != r13) goto L22;
        return r13;
    L37:
        throw new IllegalStateException("KoinApplication has not been started");
    L39:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        ArrayList r33 = new ArrayList();
        Iterator r34 = r18.iterator();
    L16:
        if (r34.hasNext() == false) goto L20;
        Object r35 = r34.next();
        if ((r35 instanceof MiniAppWidgetCardModel) == false) goto L16;
        r33.add(r35);
        goto L16
    L20:
        r20 = r33.iterator();
    L7:
        r11 = r17;
        r5 = new FeedListComponent$refreshMiniAppWidgets$1(r11, r19);
        goto L8
    }

    public static final Object m(s r10, List r11, ContinuationImpl r12) {
        r10.getClass();
        if ((r12 instanceof FeedListComponent$refreshStepCounterWidgetIfNeeded$1) == false) goto L7;
        FeedListComponent$refreshStepCounterWidgetIfNeeded$1 r5 = (FeedListComponent$refreshStepCounterWidgetIfNeeded$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (s) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        if (((Boolean) r14).booleanValue() == false) goto L36;
        r10.getClass();
        long r17 = SystemClock.uptimeMillis();
        if ((r17 - A) < 60000) goto L37;
        A = r17;
        Intent r18 = new Intent();
        r18.setComponent(new ComponentName("com.obric.health", "com.obric.health.service.StepCounterService"));
        r18.putExtra("START_ACTION", "APPWIDGET_UPDATE");
        r18.addFlags(268435456);
        r10.d.startForegroundService(r18);     // Catch: Exception -> L26
    L31:
        return Unit.INSTANCE;
    L26:
        e = move-exception;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter("refresh step counter widget failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L33;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("FeedListComponent", "refresh step counter widget failed", e);
        goto L31
    L33:
        throw new IllegalStateException("KoinApplication has not been started");
    L37:
        return Unit.INSTANCE;
    L36:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.z r20 = Dispatchers.getIO();
        FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1 r21 = new FeedListComponent$refreshStepCounterWidgetIfNeeded$hasStepCounterWidget$1(r11, r10, null);
        r5.L$0 = r10;
        r5.label = 1;
        r14 = BuildersKt.withContext(r20, r21, r5);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r5 = new FeedListComponent$refreshStepCounterWidgetIfNeeded$1(r10, r12);
        goto L8
    }

    public static final Object n(List r10, s r11, Continuation r12) {
        r11.getClass();
        if ((r12 instanceof FeedListComponent$renderCards$1) == false) goto L7;
        FeedListComponent$renderCards$1 r5 = (FeedListComponent$renderCards$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        boolean r17 = r5.Z$0;
        List r18 = (List) r5.L$1;
        s r19 = (s) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L63:
        DiffUtil.DiffResult r110 = (DiffUtil.DiffResult) r14;
        if (r17 == false) goto L68;
        r19.getClass();
        long r20 = SystemClock.elapsedRealtime() + 220;
        if (r20 <= r19.s) goto L68;
        r19.s = r20;
    L68:
        MultiTypeAdapter r21 = r19.f11602j;
        List r22 = CollectionsKt.toMutableList(r18);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.f7569a = r22;
        r110.dispatchUpdatesTo(r19.f11602j);
        r19.f11617z = r18;
        r19.e.invalidateItemDecorations();
        r19.y();
    L70:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (Intrinsics.areEqual(r11.f11617z, r10) == true) goto L70;
        List r111 = r11.f11617z;
        if (r111 != null) goto L19;
        r111 = CollectionsKt.emptyList();
    L19:
        ArrayList r23 = new ArrayList();
        Iterator r24 = r111.iterator();
    L21:
        if (r24.hasNext() == false) goto L25;
        Object r25 = r24.next();
        if ((r25 instanceof MiniAppWidgetCardModel) == false) goto L21;
        r23.add(r25);
        goto L21
    L25:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r10.iterator();
    L27:
        if (r27.hasNext() == false) goto L32;
        Object r28 = r27.next();
        if ((r28 instanceof MiniAppWidgetCardModel) == false) goto L27;
        r26.add(r28);
        goto L27
    L32:
        if (r23.isEmpty() == false) goto L37;
        if (r26.isEmpty() == false) goto L37;
        boolean r29 = false;
    L59:
        kotlinx.coroutines.z r30 = Dispatchers.getDefault();
        FeedListComponent$renderCards$diffResult$1 r31 = new FeedListComponent$renderCards$diffResult$1(r111, r10, null);
        r5.L$0 = r11;
        r5.L$1 = r10;
        r5.Z$0 = r29;
        r5.label = 1;
        r14 = BuildersKt.withContext(r30, r31, r5);
        if (r14 == r15) goto L85;
        r19 = r11;
        r18 = r10;
        r17 = r29;
        goto L63
    L85:
        return r15;
    L37:
        if (r111.size() == r10.size()) goto L39;
    L38:
        r29 = true;
        goto L59
    L39:
        ArrayList r32 = new ArrayList(CollectionsKt.h(r111));
        Iterator r33 = r111.iterator();
    L41:
        if (r33.hasNext() == false) goto L43;
        r32.add(((BaseCardModel) r33.next()).getId());
        goto L41
    L43:
        ArrayList r34 = new ArrayList(CollectionsKt.h(r10));
        Iterator r35 = r10.iterator();
    L45:
        if (r35.hasNext() == false) goto L48;
        r34.add(((BaseCardModel) r35.next()).getId());
        goto L45
    L48:
        if (Intrinsics.areEqual(r32, r34) == false) goto L38;
        ArrayList r36 = new ArrayList(CollectionsKt.h(r23));
        Iterator r37 = r23.iterator();
    L52:
        if (r37.hasNext() == false) goto L54;
        r36.add(((MiniAppWidgetCardModel) r37.next()).getInstanceId());
        goto L52
    L54:
        ArrayList r38 = new ArrayList(CollectionsKt.h(r26));
        Iterator r39 = r26.iterator();
    L56:
        if (r39.hasNext() == false) goto L58;
        r38.add(((MiniAppWidgetCardModel) r39.next()).getInstanceId());
        goto L56
    L58:
        r29 = !Intrinsics.areEqual(r36, r38);
    L7:
        r5 = new FeedListComponent$renderCards$1(r11, r12);
        goto L8
    }

    public static final void o(s r5, RecyclerView.ViewHolder r10) {
        r5.getClass();
        View r11 = r10.itemView;
        if ((r11 instanceof WidgetBox) == false) goto L5;
        WidgetBox r12 = (WidgetBox) r11;
    L6:
        if (r12 == null) goto L8;
        r5.e(new b(r12));
    L8:
        ItemTouchHelper r13 = r5.f11606n;
        if (r13 == null) goto L12;
        r13.startDrag(r10);
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static final void p(s r10, View r11, long r12, Function0 r13) {
        r10.getClass();
        SpringAnimation r5 = new SpringAnimation(r11, DynamicAnimation.SCALE_X, 1.0f);
        SpringForce r14 = r5.getSpring();
        float r15 = r10.f11615x;
        r14.setDampingRatio(r15);
        r5.getSpring().setStiffness(200.0f);
        SpringAnimation r16 = new SpringAnimation(r11, DynamicAnimation.SCALE_Y, 1.0f);
        r16.getSpring().setDampingRatio(r15);
        r16.getSpring().setStiffness(200.0f);
        r11.animate().cancel();
        r11.animate().alpha(r10.f11616y).setDuration(r12).setInterpolator(r10.f11613v).withEndAction(new androidx.fragment.app.d(r13)).withStartAction(new a2.b(13, r11, r10)).start();
        r5.start();
        r16.start();
    }

    public static final boolean q(RecyclerView r5, List r10, View r11) {
        int r12 = r5.getChildAdapterPosition(r11);
        if (r12 != (-1)) goto L6;
        return false;
    L6:
        if (r10 == null) goto L8;
        Object r13 = CollectionsKt.getOrNull(r10, r12);
    L10:
        return r13 instanceof FakeWidgetCardModel;
    L8:
        r13 = null;
        goto L10
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r13) {
        o r14 = (o) r13;
        Intrinsics.checkNotNullParameter(r14, Constant.COMMAND);
        if (Intrinsics.areEqual(r14, l.f11591a) == false) goto L6;
        x(true);
        return;
    L6:
        if (Intrinsics.areEqual(r14, m.f11592a) == false) goto L8;
        x(false);
        return;
    L8:
        boolean r5 = r14 instanceof i;
        CoroutineScope r10 = (CoroutineScope) this.f11532b;
        if (r5 == false) goto L12;
        i r15 = (i) r14;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$refreshCards$1(this, r15.f11587a, r15.f11588b, null), 3, null);
        return;
    L12:
        if ((r14 instanceof h) == false) goto L15;
        h r16 = (h) r14;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$addCardFromPicker$1(this, r16.f11584a, r16.f11585b, r16.f11586c, r16.d, null, null), 3, null);
        return;
    L15:
        if ((r14 instanceof n) == false) goto L18;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$updateCardData$1(this, ((n) r14).f11593a, null), 3, null);
        return;
    L18:
        if ((r14 instanceof j) == false) goto L21;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$removeCardById$1(this, ((j) r14).f11589a, null), 3, null);
        return;
    L21:
        if ((r14 instanceof k) == false) goto L27;
        String r17 = ((k) r14).f11590a;
        if (StringsKt.isBlank(r17) == true) goto L54;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$removeMiniAppWidgetsByAppletId$1(this, r17, null), 3, null);
        return;
    L54:
        return;
    L27:
        if ((r14 instanceof f) == false) goto L41;
        AppWidgetManager r11 = this.g;
        int r18 = ((f) r14).f11582a;
        AppWidgetProviderInfo r12 = r11.getAppWidgetInfo(r18);
        Context r19 = this.d;
        if (r12 != null) goto L35;
        String r110 = "getAppWidgetInfo null:" + r18;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L34;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("FeedListComponent", r110);
        Toast.makeText(r19, R$string.widget_load_failed, 0).show();
        return;
    L34:
        throw new IllegalStateException("KoinApplication has not been started");
    L35:
        int r21 = r19.getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        f(new h(r18, ((r19.getResources().getDisplayMetrics().widthPixels - (r19.getResources().getDimensionPixelSize(R$dimen.card_list_page_left_space_new) * 2)) - (3 * r21)) / 4, r19.getResources().getDimensionPixelSize(R$dimen.card_height), r21));
        eq.b r111 = com.lynx.tasm.utils.k.r();
        JSONObject r112 = new JSONObject();
        String r22 = r12.label;
        if (r22 != null) goto L38;
        r22 = "";
    L39:
        r112.put("widget_name", r22);
        Unit r23 = Unit.INSTANCE;
        r111.a("click_add_widget", r112);
        return;
    L38:
        Intrinsics.checkNotNull(r22);
        goto L39
    L41:
        if ((r14 instanceof g) == false) goto L53;
        BuildersKt.launch$default(r10, null, null, new FeedListComponent$addMiniAppWidget$1(this, ((g) r14).f11583a, null, "click_add_mini_app_widget", null), 3, null);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
        ArrayList r5 = new ArrayList();
        MultiTypeAdapter r10 = this.f11602j;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f7569a = r5;
        Context r11 = this.d;
        Intrinsics.checkNotNullParameter(r11, "context");
        FeedListComponent$NoPredictiveGridLayoutManager r12 = new FeedListComponent$NoPredictiveGridLayoutManager(r11, 4);
        RecyclerView r13 = this.e;
        r13.setLayoutManager(r12);
        r13.addOnScrollListener(new FeedListComponent$setupLayoutManager$1(this));
        r13.addOnLayoutChangeListener(new com.bytedance.ai.widget.contianer.c(this, 2));
        r12.setSpanSizeLookup(new FeedListComponent$setupLayoutManager$spanSizeLookup$1(this));
        int r14 = r11.getResources().getDimensionPixelSize(R$dimen.card_list_page_left_space_new);
        int r15 = r11.getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        int r16 = r11.getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        r r17 = new r(this);
        r13.addItemDecoration(new CardItemDecoration(this.f11602j, r14, r15, r16, r17));
        r13.setOnDragListener(new q(this));
        Function3<WidgetBox, WidgetCardModel, AppWidgetProviderInfo, Unit> r18 = new FeedListComponent$setupAdapterBinders$1(this);
        Function1<RecyclerView.ViewHolder, Unit> r19 = new FeedListComponent$setupAdapterBinders$2(this);
        Function1<RecyclerView.ViewHolder, Unit> r20 = new FeedListComponent$setupAdapterBinders$3(this);
        AppWidgetManager r110 = this.g;
        RecyclerView r111 = this.e;
        com.obric.flow.cardlistpage.ui.viewbinder.h r21 = new com.obric.flow.cardlistpage.ui.viewbinder.h(this.d, this.f, r110, r111, r18, r19, r20);
        this.f11603k = r21;
        r10.b(WidgetCardModel.class, r21);
        obric.flow.miniappwidget.l r112 = this.f11600h;
        r112.f();
        Unit r22 = Unit.INSTANCE;
        Function2<WidgetBox, MiniAppWidgetCardModel, Unit> r113 = new FeedListComponent$setupAdapterBinders$6(this);
        Function1<RecyclerView.ViewHolder, Unit> r23 = new FeedListComponent$setupAdapterBinders$7(this);
        Function1<RecyclerView.ViewHolder, Unit> r24 = new FeedListComponent$setupAdapterBinders$8(this);
        CoroutineScope r114 = (CoroutineScope) this.f11532b;
        com.obric.flow.cardlistpage.ui.viewbinder.f r25 = new com.obric.flow.cardlistpage.ui.viewbinder.f(this.d, r112, r114, this.e, r113, r23, r24);
        this.f11604l = r25;
        r10.b(MiniAppWidgetCardModel.class, r25);
        r10.b(FakeWidgetCardModel.class, new com.obric.flow.cardlistpage.ui.viewbinder.a(3));
        r10.b(HeaderWidgetCardModel.class, new com.obric.flow.cardlistpage.ui.viewbinder.b(3));
        r10.b(TravelCardModel.class, new com.obric.flow.cardlistpage.ui.viewbinder.g(3));
        r13.setAdapter(r10);
        r13.setItemAnimator(new FeedListComponent$setupItemAnimator$1(this));
        obric.flow.nlwidget.ui.feeds.drag.a r26 = new obric.flow.nlwidget.ui.feeds.drag.a(r10, this.f11603k, this.f11604l);
        Function0<Unit> r27 = new FeedListComponent$setupItemTouchHelper$1(this);
        Function1<List<? extends BaseCardModel>, Unit> r28 = new FeedListComponent$setupItemTouchHelper$2(this);
        CardItemTouchHelperCallback r29 = new CardItemTouchHelperCallback(r10, this.e, r26, r27, r28);
        this.f11605m = r29;
        Intrinsics.checkNotNullParameter(r29, "callback");
        ItemTouchHelper r30 = new ItemTouchHelper(r29);
        this.f11606n = r30;
        r30.attachToRecyclerView(r13);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.obric.flow.cardlistpage.ui.drag.DragInsertRecyclerView");
        ItemTouchHelper r31 = this.f11606n;
        Intrinsics.checkNotNull(r31);
        this.f11607o = new kq.b((DragInsertRecyclerView) r13, r31);
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        FeedListComponent$observeState$1 r5 = new FeedListComponent$observeState$1(this, null);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
    }

    public final void r(float r10, float r11, Intent r12) {
        Intrinsics.checkNotNullParameter(r12, "intent");
        kq.b r5 = this.f11607o;
        if (r5 == null) goto L5;
        kq.b.a(r5, r10, r11);
    L5:
        Iterator r13 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.f11531a).b()).b().iterator();
        int r14 = 0;
    L7:
        if (r13.hasNext() == false) goto L12;
        if ((((BaseCardModel) r13.next()) instanceof FakeWidgetCardModel) == true) goto L13;
        r14 = r14 + 1;
    L13:
        FeedListComponent$resolveExternalDrop$1 r15 = new FeedListComponent$resolveExternalDrop$1(r14, r12, this, null);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r15, 3, null);
        return;
    L12:
        r14 = -1;
        goto L13
    }

    public final void s(float r12, float r13) {
        if (r12 == 0.0f) goto L5;
    L7:
        kq.b r11 = this.f11607o;
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.d == false) goto L15;
        int[] r5 = new int[2];
        DragInsertRecyclerView r10 = r11.f19460a;
        r10.getLocationOnScreen(r5);
        float r14 = r12 - r5[0];
        float r15 = r13 - r5[1];
        MotionEvent r16 = MotionEvent.obtain(r11.f19462c, SystemClock.uptimeMillis(), 2, r14, r15, 0);
        Intrinsics.checkNotNull(r16);
        r10.a(r16);
        r16.recycle();
        return;
    L15:
        return;
    L5:
        if (r13 != 0.0f) goto L7;
    }

    public final void t(float r19, float r20, int r21, int r22, int r23, int r24) {
        int r13 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.f11531a).b()).b().size();
        final RecyclerView r14 = this.e;
        Intrinsics.checkNotNullParameter(r14, "rv");
        RecyclerView.Adapter r5 = r14.getAdapter();
        int r10 = 0;
        if (r5 != null) goto L6;
    L4:
        int r11 = 0;
    L81:
        int r15 = RangesKt.coerceIn(r11, r10, r13);
        d(new y(r15, r21, r22, r23, r24, r19, r20));
        r14.postDelayed(new p0(this, r15, 1, r19, r20), 100);
        StringBuilder r12 = new StringBuilder("onAddWidgetDragStart x:");
        r12.append(r19);
        r12.append(" y:");
        r12.append(r20);
        r12.append(" spanX:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r12, r21, " spanY:", r22, " minWidth:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r12, r23, " minHeight:", r24, " position:");
        r12.append(r15);
        r12.append(" size:");
        r12.append(r13);
        String r16 = r12.toString();
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L86;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r16);
        return;
    L86:
        throw new IllegalStateException("KoinApplication has not been started");
    L6:
        if ((r5 instanceof MultiTypeAdapter) == false) goto L8;
        MultiTypeAdapter r18 = (MultiTypeAdapter) r5;
    L9:
        if (r18 == null) goto L11;
        List r25 = r18.f7569a;
    L12:
        int r26 = r14.getChildCount();
        if (r26 == 0) goto L4;
        int r27 = r26 - 1;
        Iterator r28 = SequencesKt.map(CollectionsKt.asSequence(RangesKt.downTo(r27, 0)), new FeedListComponent$findInsertIndex$lastRealChild$1(r14)).iterator();
    L17:
        if (r28.hasNext() == false) goto L21;
        Object r29 = r28.next();
        View r30 = (View) r29;
        Intrinsics.checkNotNull(r30);
        if (q(r14, r25, r30) == true) goto L17;
    L22:
        View r31 = (View) r29;
        if (r31 != null) goto L25;
    L27:
        View r32 = r14.findChildViewUnder(r19, r20);
        if (r32 == null) goto L33;
        if (q(r14, r25, r32) == false) goto L33;
        r32 = null;
    L33:
        if (r32 != null) goto L43;
        int r33 = 0;
        float r34 = Float.MAX_VALUE;
        r32 = null;
    L36:
        if (r33 >= r26) goto L43;
        View r110 = r14.getChildAt(r33);
        Intrinsics.checkNotNull(r110);
        if (q(r14, r25, r110) == true) goto L42;
        float r35 = Math.abs(r20 - ((r110.getBottom() + r110.getTop()) / 2.0f));
        if (r35 >= r34) goto L42;
        r34 = r35;
        r32 = r110;
    L42:
        r33 = r33 + 1;
    L43:
        if (r32 != null) goto L46;
        r11 = r5.getItemCount();
    L45:
        r10 = 0;
        goto L81
    L46:
        int r36 = r14.getChildAdapterPosition(r32);
        int r37 = SequencesKt.b(ViewGroupKt.getChildren(r14), r32);
        if (r36 != (-1)) goto L49;
        r11 = r5.getItemCount();
        goto L45
    L49:
        float r38 = (r32.getBottom() + r32.getTop()) / 2.0f;
        ViewGroup.LayoutParams r39 = r32.getLayoutParams();
        if ((r39 instanceof GridLayoutManager.LayoutParams) == false) goto L52;
        GridLayoutManager.LayoutParams r40 = (GridLayoutManager.LayoutParams) r39;
    L54:
        if (r20 >= r38) goto L63;
        if (r21 != 4) goto L62;
        if (r40 == null) goto L62;
        if (r40.getSpanSize() != 2) goto L62;
        if (r40.getSpanIndex() <= 1) goto L62;
        r11 = r36 - 1;
    L62:
        r11 = r36;
        goto L45
    L63:
        if (r21 != 4) goto L80;
        if (r40 == null) goto L80;
        if (r40.getSpanSize() != 2) goto L80;
        if (r40.getSpanIndex() > 1) goto L80;
        if (r37 >= r27) goto L80;
        ViewGroup.LayoutParams r41 = r14.getChildAt(r37 + 1).getLayoutParams();
        if ((r41 instanceof GridLayoutManager.LayoutParams) == false) goto L73;
        GridLayoutManager.LayoutParams r42 = (GridLayoutManager.LayoutParams) r41;
    L74:
        if (r42 == null) goto L80;
        if (r42.getSpanSize() != 2) goto L80;
        if (r42.getSpanIndex() <= 1) goto L80;
        r11 = r36 + 2;
        goto L45
    L73:
        r42 = null;
    L80:
        r11 = r36 + 1;
        goto L45
    L52:
        r40 = null;
        goto L54
    L25:
        if (r20 < r31.getBottom()) goto L27;
        r11 = r5.getItemCount();
        goto L81
    L21:
        r29 = null;
        goto L22
    L11:
        r25 = null;
        goto L12
    L8:
        r18 = null;
        goto L9
    }

    public final void u(float r5, float r10) {
        kq.b r11 = this.f11607o;
        if (r11 == null) goto L5;
        kq.b.a(r11, r5, r10);
    L5:
        Iterator r12 = ((v) ((com.obric.flow.cardlistpage.mvi.a) this.f11531a).b()).b().iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L12;
        if ((((BaseCardModel) r12.next()) instanceof FakeWidgetCardModel) == true) goto L13;
        r13 = r13 + 1;
    L13:
        d(new x(r13, r5, r10));
        return;
    L12:
        r13 = -1;
        goto L13
    }

    public final void v(long r5) {
        boolean r10 = this.f11610r;
        androidx.fragment.app.d r11 = this.f11612u;
        RecyclerView r12 = this.e;
        if (r10 == false) goto L5;
        r12.removeCallbacks(r11);
    L5:
        this.f11610r = true;
        r12.postDelayed(r11, r5);
    }

    public final long w() {
        long r5 = this.s;
        if (r5 > 0) goto L5;
        return 0;
    L5:
        long r10 = r5 - SystemClock.elapsedRealtime();
        if (r10 > 0) goto L9;
        this.s = 0;
        return 0;
    L9:
        return r10;
    }

    public final void x(boolean r14) {
        obric.flow.miniappwidget.l r10 = this.f11600h;
        gu.d r11 = this.f;
        if (r14 == false) goto L27;
        r11.startListening();
        String r15 = "miniAppWidget foreground hostId=" + r10.f20491a;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L26;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r15);
        String r16 = r10.f20491a;
        r10.f20496j.set(true);     // Catch: Throwable -> L15
        ConcurrentHashMap r13 = r10.f;
        String r5 = "onForeground hostId=" + r16 + " activeCount=" + r13.size();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r5, "msg");     // Catch: Throwable -> L15
        org.koin.core.a r17 = su.a.f22013b;     // Catch: Throwable -> L15
        if (r17 == null) goto L18;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r5);     // Catch: Throwable -> L15
        r10.e();     // Catch: Throwable -> L15
        Iterator r18 = r13.values().iterator();     // Catch: Throwable -> L15
    L13:
        if (r18.hasNext() == false) goto L22;
        ((obric.flow.miniappwidget.a) r18.next()).c();     // Catch: Throwable -> L15
    L22:
        y();
        return;
    L18:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        String r19 = "onForeground failed hostId=" + r16;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L24;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r19, th);
        goto L22
    L24:
        throw new IllegalStateException("KoinApplication has not been started");
    L26:
        throw new IllegalStateException("KoinApplication has not been started");
    L27:
        r11.stopListening();
        String r110 = "miniAppWidget background hostId=" + r10.f20491a;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        org.koin.core.a r111 = su.a.f22013b;
        if (r111 == null) goto L45;
        ((ju.b) r111.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r110);
        String r112 = r10.f20491a;
        r10.f20496j.set(false);     // Catch: Throwable -> L33
        String r21 = "onBackground hostId=" + r112 + " activeCount=" + r10.f.size();     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r21, "msg");     // Catch: Throwable -> L33
        org.koin.core.a r22 = su.a.f22013b;     // Catch: Throwable -> L33
        if (r22 == null) goto L36;
        ((ju.b) r22.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r21);     // Catch: Throwable -> L33
        r10.e().onBackground();     // Catch: Throwable -> L33
    L40:
        y();
        return;
    L36:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        String r113 = "onBackground failed hostId=" + r112;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r113, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r23 = su.a.f22013b;
        if (r23 == null) goto L43;
        ((ju.b) r23.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r113, th);
        goto L40
    L43:
        throw new IllegalStateException("KoinApplication has not been started");
    L45:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void y() {
        v(Math.max(16, w()));
    }

    public final void z(int r10) {
        kotlinx.coroutines.z r5 = Dispatchers.getIO();
        FeedListComponent$updateEditedWidget$1 r11 = new FeedListComponent$updateEditedWidget$1(this, r10, null);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, r5, null, r11, 2, null);
    }
}
