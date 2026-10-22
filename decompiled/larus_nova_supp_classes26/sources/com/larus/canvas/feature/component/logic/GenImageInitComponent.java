package com.larus.canvas.feature.component.logic;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.view.ChatConstraintLayout$b;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.service.bean.AlbumImage;
import com.larus.canvas.service.bean.IImageInfo;
import com.larus.canvas.service.bean.LocalFileImage;
import com.larus.canvas.service.bean.NetworkImage;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000203H\u0016J\b\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000203H\u0002J\b\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u000203H\u0002J+\u0010=\u001a\u0002032\u001c\u0010>\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002030@\u0012\u0006\u0012\u0004\u0018\u00010A0?H\u0002¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u000203H\u0002J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u000203H\u0002J\b\u0010H\u001a\u000203H\u0002J\b\u0010I\u001a\u000203H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/canvas/feature/component/logic/GenImageInitComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "canvasTitleAbility", "Lcom/larus/canvas/feature/component/title/ITitleAbility;", "getCanvasTitleAbility", "()Lcom/larus/canvas/feature/component/title/ITitleAbility;", "canvasTitleAbility$delegate", "Lkotlin/Lazy;", "imagePagerAbility", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "getImagePagerAbility", "()Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "imagePagerAbility$delegate", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "hostUiPolicy", "Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "hostUiPolicy$delegate", "canvasEditorAbility", "Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "getCanvasEditorAbility", "()Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "canvasEditorAbility$delegate", "canvasInstructionAbility", "Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "getCanvasInstructionAbility", "()Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "canvasInstructionAbility$delegate", "canvasImageEditAbility", "Lcom/larus/canvas/feature/component/input/ICanvasImageEditAbility;", "getCanvasImageEditAbility", "()Lcom/larus/canvas/feature/component/input/ICanvasImageEditAbility;", "canvasImageEditAbility$delegate", "bottomInsetUpdateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/bmhome/view/ChatConstraintLayout$OnBottomInsetUpdateListener;", "needHandleInitialInstructionTabInfo", "", "onAttach", "", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "afterViewBind", "attachComponents", "handleInitialOptionId", "handleInitialAIBeautify", "handleInitialInstructionTabInfo", "doOnceOnResume", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "initCanvasEditorComponent", "initTitleView", "resolveTitleLeftIconRes", "", "handleBottomInsetUpdate", "handlePassedImage", "initImagePagerComponent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenImageInitComponent extends BaseContentWidget {
    public static final Lazy<hq9.s0> w = null;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final CopyOnWriteArrayList<ChatConstraintLayout$b> u;
    public boolean v;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CanvasHostUiPolicy.TitleLeftAction.values().length];
            r0[CanvasHostUiPolicy.TitleLeftAction.BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CanvasHostUiPolicy.TitleLeftAction.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        new a();
        w = LazyKt.lazy(new o());
    }

    public final my8.q h3() {
        return (my8.q) this.p.getValue();
    }

    public final n2 m3() {
        return (n2) this.o.getValue();
    }

    public final CanvasHostUiPolicy p3() {
        return (CanvasHostUiPolicy) this.q.getValue();
    }

    public final void y2() {
        k1a.b.b(this, new l(this));
    }

    public GenImageInitComponent() {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.m = LazyKt.lazy(r0, new w(this));
        this.n = LazyKt.lazy(r0, new x(this));
        this.o = LazyKt.lazy(r0, new y(this));
        this.p = LazyKt.lazy(r0, new z(this));
        this.q = LazyKt.lazy(r0, new a0(this));
        this.r = LazyKt.lazy(new b0(this));
        this.s = LazyKt.lazy(new c0(this));
        this.t = LazyKt.lazy(new d0(this));
        this.u = new CopyOnWriteArrayList();
    }

    public final void P2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageInitComponent$handleBottomInsetUpdate$1(this, null), 3, null);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        fy8.i r0 = (fy8.i) this.r.getValue();
        String r1 = "";
        if (r0 == null) goto L58;
        String r6 = getContext().getString(2131900606);
        Pair[] r2 = new Pair[10];
        my8.q r3 = h3();
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.b();
    L8:
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r2[0] = TuplesKt.to("bot_id", r5);
        my8.q r7 = h3();
        if (r7 == null) goto L13;
        String r8 = r7.n;
    L14:
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r2[1] = TuplesKt.to("action_bar_key", r8);
        my8.q r9 = h3();
        if (r9 == null) goto L19;
        String r10 = r9.a();
    L20:
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r2[2] = TuplesKt.to("action_bar_template_id", r10);
        my8.q r11 = h3();
        if (r11 == null) goto L25;
        String r12 = r11.t;
    L26:
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        r2[3] = TuplesKt.to("current_page", r12);
        my8.q r13 = h3();
        if (r13 == null) goto L31;
        String r14 = r13.q;
    L32:
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        r2[4] = TuplesKt.to("enter_method", r14);
        my8.q r15 = h3();
        if (r15 == null) goto L37;
        String r16 = r15.d();
    L38:
        if (r16 != null) goto L40;
        r16 = "";
    L40:
        r2[5] = TuplesKt.to("previous_page", r16);
        r2[6] = TuplesKt.to("show_from", "ai_generate_feed_image");
        my8.q r17 = h3();
        if (r17 == null) goto L43;
        String r18 = r17.w;
    L44:
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        r2[7] = TuplesKt.to("ai_create_show_mode", r18);
        my8.q r19 = h3();
        if (r19 == null) goto L49;
        String r20 = r19.r;
    L50:
        if (r20 != null) goto L52;
        r20 = "";
    L52:
        r2[8] = TuplesKt.to("pic_source_message_id", r20);
        my8.q r21 = h3();
        if (r21 == null) goto L55;
        r4 = r21.s;
    L55:
        if (r4 != null) goto L57;
        r4 = "";
    L57:
        r2[9] = TuplesKt.to("source_creation_task_id", r4);
        r0.XX(new fy8.j("", r6, 1, MapsKt.mapOf(r2), 25));
        goto L58
    L49:
        r20 = null;
        goto L50
    L43:
        r18 = null;
        goto L44
    L37:
        r16 = null;
        goto L38
    L31:
        r14 = null;
        goto L32
    L25:
        r12 = null;
        goto L26
    L19:
        r10 = null;
        goto L20
    L13:
        r8 = null;
        goto L14
    L7:
        r5 = null;
    L58:
        Lazy<hq9.s0> r22 = w;
        if (com.larus.utils.o0.d(((hq9.s0) r22.getValue()).b) == false) goto L67;
        fy8.i r23 = (fy8.i) this.r.getValue();
        if (r23 == null) goto L67;
        String r24 = ((hq9.s0) r22.getValue()).b;
        if (r24 == null) goto L66;
        r1 = r24;
    L66:
        r23.p2(r1);
    L67:
        com.larus.canvas.feature.component.resultdisplay.image.r r25 = (com.larus.canvas.feature.component.resultdisplay.image.r) this.n.getValue();
        if (r25 == null) goto L77;
        int r26 = i5.k0();
        CanvasHostUiPolicy r27 = p3();
        int r28 = i5.h();
        CanvasHostUiPolicy r29 = p3();
        int r30 = i5.k0();
        int r31 = i5.c0();
        if (r29.a == false) goto L73;
        r30 = r31;
    L73:
        if (r27.a == false) goto L75;
        r28 = RangesKt.coerceAtLeast(r28, r30);
    L75:
        r25.uX(new com.larus.canvas.feature.component.resultdisplay.image.q(r26, r28, new m(this), new n(this)));
        return;
    }

    public final void onViewCreated(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r12, "view");
        com.larus.canvas.feature.component.title.k r13 = (com.larus.canvas.feature.component.title.k) this.m.getValue();
        if (r13 == null) goto L5;
        r13.N50(new v(this));
    L5:
        this.u.add(new g0(this));
        my8.q r14 = h3();
        if (r14 == null) goto L8;
        IImageInfo r15 = (IImageInfo) r14.e.getValue();
    L10:
        if ((r15 instanceof AlbumImage) == false) goto L15;
        n2 r1 = m3();
        if (r1 == null) goto L25;
        AlbumImage r16 = (AlbumImage) r15;
        r1.tM(r16.a, r16.c);
    L25:
        my8.q r17 = h3();
        if (r17 == null) goto L33;
        Integer r18 = (Integer) r17.j.getValue();
        if (r18 == null) goto L33;
        int r19 = r18.intValue();
        if (3 != r19) goto L32;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageInitComponent$handleInitialAIBeautify$1$1(this, null), 3, null);
        goto L33
    L32:
        FLogger.a.i("GenImageInitComponent", "needHandleInitialInstructionTabInfo, initialMsgInstructionId: " + r19);
        this.v = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageInitComponent$handleInitialAIBeautify$1$2(this, r19, null), 3, null);
    L33:
        my8.q r110 = h3();
        if (r110 == null) goto L46;
        Integer r111 = (Integer) r110.l.getValue();
        if (r111 == null) goto L47;
        int r112 = r111.intValue();
        FLogger.a.i("GenImageInitComponent", "handleInitailOptionId optionId: " + r112);
        my8.q r2 = h3();
        if (r2 == null) goto L48;
        String r3 = (String) r2.k.getValue();
        if (r3 == null) goto L49;
        this.v = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageInitComponent$handleInitialOptionId$1$1(this, r3, r112, null), 3, null);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L15:
        if ((r15 instanceof NetworkImage) == false) goto L20;
        NetworkImage r113 = (NetworkImage) r15;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        ky8.j r114 = new ky8.j(r113.a, r113.b, r113.d, r113.c, r113.e, null, 32);
        n2 r4 = m3();
        if (r4 == null) goto L25;
        r4.Fp(r114);
        goto L25
    L20:
        if ((r15 instanceof LocalFileImage) == false) goto L24;
        LocalFileImage r115 = (LocalFileImage) r15;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        ky8.j r116 = new ky8.j(r115.b, null, r115.d, r115.c, r115.a, null, 34);
        n2 r5 = m3();
        if (r5 == null) goto L25;
        r5.SS(r116);
        goto L25
    L24:
        if (r15 == null) goto L25;
        throw new NoWhenBranchMatchedException();
    L8:
        r15 = null;
        goto L10
    }

    public static final void Y2(GenImageInitComponent r8, Function1 r9) {
        r8.getClass();
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), null, null, new GenImageInitComponent$doOnceOnResume$1(r8, r0, r9, null), 3, null);
    }
}
