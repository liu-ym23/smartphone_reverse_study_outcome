package com.larus.voicecall.impl.subtitle;

import android.app.Application;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.constant.ThemeType;
import com.larus.bmhome.view.FastScrollButton;
import com.larus.bmhome.view.MessageMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutRealtimeCallSubtitleBinding;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001M\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020\u001bJ \u0010Q\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020VJ\u0010\u0010W\u001a\u0002022\u0006\u0010X\u001a\u00020\u0007H\u0016J\u0010\u0010Y\u001a\u0002022\u0006\u0010S\u001a\u00020TH\u0003J\u0014\u0010Z\u001a\u0002022\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\J\u0006\u0010^\u001a\u000202J\b\u0010_\u001a\u00020\u0011H\u0002J\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u000202H\u0002J\u0006\u0010b\u001a\u000202J\u0010\u0010c\u001a\u0002022\b\b\u0002\u0010d\u001a\u00020\u0011J\b\u0010e\u001a\u000202H\u0002J\b\u0010f\u001a\u000202H\u0002J\u0012\u0010g\u001a\u0002022\b\b\u0002\u0010h\u001a\u00020\u0011H\u0002J\u0010\u0010i\u001a\u0002022\u0006\u0010j\u001a\u00020\u0007H\u0002J\b\u0010k\u001a\u000202H\u0002J\u0010\u0010l\u001a\u0002022\u0006\u0010m\u001a\u00020=H\u0002J\u0018\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020V2\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010r\u001a\u000202H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R9\u0010,\u001a!\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&RL\u0010;\u001a4\u0012\u0013\u0012\u00110=¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(?\u0012\u0004\u0012\u000202\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010N¨\u0006s"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutRealtimeCallSubtitleBinding;", "viewModel", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleViewModel;", "subtitleAdapter", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleAdapter;", "hasShowSubtitle", NameKeys.UnloadStrategy_No_Strategy, "isInit", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "collectJob", "Lkotlinx/coroutines/Job;", "hasReportSlide", "copySource", NameKeys.UnloadStrategy_No_Strategy, "tag", "isBottomReached", "menuHasShown", "needAutoScroll", "currentSceneMode", "Lkotlin/Function0;", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "getCurrentSceneMode", "()Lkotlin/jvm/functions/Function0;", "setCurrentSceneMode", "(Lkotlin/jvm/functions/Function0;)V", "scrollToEndDirectly", "getScrollToEndDirectly", "()Z", "setScrollToEndDirectly", "(Z)V", "subtitleImgRetryCallback", "Lkotlin/Function1;", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "rawData", NameKeys.UnloadStrategy_No_Strategy, "getSubtitleImgRetryCallback", "()Lkotlin/jvm/functions/Function1;", "setSubtitleImgRetryCallback", "(Lkotlin/jvm/functions/Function1;)V", "getRealtimeCallTracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getGetRealtimeCallTracer", "setGetRealtimeCallTracer", "subtitleLongClickListener", "Lkotlin/Function2;", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "view", LynxResourceModule.DATA_KEY, "getSubtitleLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setSubtitleLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "stateListener", "Lcom/larus/voicecall/impl/subtitle/listener/ISubtitleViewChangeListener;", "getStateListener", "()Lcom/larus/voicecall/impl/subtitle/listener/ISubtitleViewChangeListener;", "setStateListener", "(Lcom/larus/voicecall/impl/subtitle/listener/ISubtitleViewChangeListener;)V", "isBotSpeakingProvider", "setBotSpeakingProvider", "linearSmoothScroller", "com/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout$linearSmoothScroller$1", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout$linearSmoothScroller$1;", "onInterrupt", "type", "initView", "model", "actionProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "getRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "setVisibility", "visibility", "initRecyclerView", "onUserInsertPhoto", "list", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voicecall/impl/subtitle/bean/ImageProcessorWrapper;", "deleteLastPlacePhotoHolder", "isReachBottom", "initObservers", "ensureRecycler", "setGone", "setVisible", "isAuto", "triggerMob", "resetStatus", "enableAutoScroll", "isAppend", "scrollPositionItemToEnd", "position", "disableAutoScroll", "selectText", "markdownView", "setupScrollToBottomButton", "recyclerView", "button", "Lcom/larus/bmhome/view/FastScrollButton;", "refreshScrollToBottomVisibility", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSubtitleLayout extends ConstraintLayout {
    public static final /* synthetic */ int w = 0;
    public final LarusLayoutRealtimeCallSubtitleBinding a;
    public q0 b;
    public RealtimeCallSubtitleAdapter c;
    public boolean d;
    public boolean e;
    public e3a.b f;
    public ThemeType g;
    public Job h;
    public boolean i;
    public String j;
    public final String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public Function0<com.larus.voicecall.impl.scene.m> o;
    public boolean p;
    public Function1<? super c, Unit> q;
    public Function0<? extends IRealtimeCallTracer> r;
    public Function2<? super CustomMarkdownTextView, ? super c, Unit> s;
    public y3a.a t;
    public Function0<Boolean> u;
    public final RealtimeCallSubtitleLayout$linearSmoothScroller$1 v;

    public RealtimeCallSubtitleLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeCallSubtitleLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final RecyclerView getRecycler() {
        return this.a.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5() {
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        FLogger.a.i(this.k, "gone");
        Job r1 = this.h;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.h = null;
        com.larus.voicecall.impl.utils.c.f(this, false, 300, new n(this));
        if (com.larus.voicecall.impl.tracer.w.a <= 0) goto L14;
        com.larus.voicecall.impl.tracer.w.b += System.currentTimeMillis() - com.larus.voicecall.impl.tracer.w.a;
    L14:
        com.larus.voicecall.impl.tracer.w.a(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Function0<com.larus.voicecall.impl.scene.m> getCurrentSceneMode() {
        return this.o;
    }

    public final Function0<IRealtimeCallTracer> getGetRealtimeCallTracer() {
        return this.r;
    }

    public final boolean getScrollToEndDirectly() {
        return this.p;
    }

    public final y3a.a getStateListener() {
        return this.t;
    }

    public final Function1<c, Unit> getSubtitleImgRetryCallback() {
        return this.q;
    }

    public final Function2<CustomMarkdownTextView, c, Unit> getSubtitleLongClickListener() {
        return this.s;
    }

    public static final void R5(RealtimeCallSubtitleLayout r1) {
        if (r1.d == true) goto L6;
        r1.d = true;
        com.larus.utils.e1.x(r1.a.c);
        com.larus.utils.e1.o(r1.a.e);
        return;
    }

    public static final void S5(RealtimeCallSubtitleLayout r3) {
        FastScrollButton r0 = r3.a.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (z2.a.getRealtimeCallNewStyleConfig().c() == false) goto L11;
        r3.a.c.addOnLayoutChangeListener(new w(r3, r0));
        return;
    }

    public final void U5(boolean r7) {
        boolean r0 = !this.a.c.canScrollVertically(1);
        FLogger.a.i(this.k, "[isReachBottom] isBottomReached " + this.l + ", isReach:" + r0);
        if (r0 == false) goto L6;
        this.n = true;
    L6:
        if (r0 == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L16;
        if (this.n == true) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L23;
        if (this.p == true) goto L23;
        return;
    L23:
        if (this.a.b.getVisibility() != 0) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == true) goto L28;
        com.larus.utils.e1.x(this.a.b);
    L28:
        RealtimeCallSubtitleAdapter r4 = this.c;
        if (r4 == null) goto L43;
        if (r7 == false) goto L32;
    L40:
        this.a.c.scrollToPosition(r4.getItemCount() - 1);
        this.p = false;
        return;
    L32:
        if (this.p == true) goto L40;
        int r8 = r4.getItemCount() - 1;
        if (r8 < 0) goto L46;
        setTargetPosition(r8);
        RecyclerView.LayoutManager r9 = this.a.c.getLayoutManager();
        if (r9 == null) goto L44;
        r9.startSmoothScroll(this.v);
        return;
    L44:
        return;
    L46:
        return;
    L43:
        return;
    L25:
        r3 = false;
    L16:
        if (this.m == true) goto L18;
        r2 = true;
        goto L19
    L8:
        if (this.l == true) goto L11;
        r1 = false;
        goto L12
    }

    public final void Y5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        FLogger r1 = FLogger.a;
        r1.i("AAAAAAAAAAAAA", "BBBBBBBBBBBBBB  type=".concat(r5));
        RealtimeCallSubtitleAdapter r2 = this.c;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "type");
        r1.i("RealtimeCallSubtitleAdapter", "msg was interrupted～ type=" + r5 + " lastBlockHolder=" + r2.g);
        SubtitleBlockHolder r6 = r2.g;
        if (r6 == null) goto L11;
        r1.i("SubtitleBlockHolder", "msg was interrupted");
        c r0 = r6.e;
        if (r0 == null) goto L12;
        r6.T3(r0, false);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setBotSpeakingProvider(Function0<Boolean> r1) {
        this.u = r1;
    }

    public final void setCurrentSceneMode(Function0<com.larus.voicecall.impl.scene.m> r1) {
        this.o = r1;
    }

    public final void setGetRealtimeCallTracer(Function0<? extends IRealtimeCallTracer> r1) {
        this.r = r1;
    }

    public final void setScrollToEndDirectly(boolean r1) {
        this.p = r1;
    }

    public final void setStateListener(y3a.a r1) {
        this.t = r1;
    }

    public final void setSubtitleImgRetryCallback(Function1<? super c, Unit> r1) {
        this.q = r1;
    }

    public final void setSubtitleLongClickListener(Function2<? super CustomMarkdownTextView, ? super c, Unit> r1) {
        this.s = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r3) {
        super/*android.view.ViewGroup*/.setVisibility(r3);
        y3a.a r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 0) goto L7;
        boolean r4 = true;
    L8:
        r0.a(new y3a.d(r4));
        return;
    L7:
        r4 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setVisible(boolean r11) {
        FLogger r0 = FLogger.a;
        r0.i(this.k, "visible, isAuto:" + r11);
        RealtimeCallSubtitleAdapter r1 = this.c;
        if (r1 != null) goto L5;
    L7:
        q0 r2 = this.b;
        if (r2 == null) goto L14;
        ArrayList<c> r3 = r2.o;
        if (r3 == null) goto L14;
        if (r3.isEmpty() == true) goto L14;
        boolean r4 = true;
    L15:
        this.d = r4;
        r0.i(this.k, "[resetStatus] has subtitle:" + this.d);
        this.l = true;
        this.m = false;
        this.n = true;
        if (this.d == false) goto L18;
        com.larus.utils.e1.x(this.a.c);
        com.larus.utils.e1.o(this.a.e);
    L18:
        LifecycleOwner r5 = ViewTreeLifecycleOwner.get(this);
        if (r5 == null) goto L23;
        LifecycleCoroutineScope r6 = LifecycleOwnerKt.getLifecycleScope(r5);
        if (r6 == null) goto L23;
        Job r7 = BuildersKt.launch$default(r6, null, null, new RealtimeCallSubtitleLayout$initObservers$1(this, null), 3, null);
    L24:
        this.h = r7;
        if (r11 == false) goto L27;
        long r8 = 0;
    L28:
        com.larus.voicecall.impl.utils.c.f(this, true, r8, new q(this));
        boolean r9 = com.larus.voicecall.impl.tracer.w.c;
        com.larus.voicecall.impl.tracer.w.a = System.currentTimeMillis();
        com.larus.voicecall.impl.tracer.w.c = true;
        com.larus.voicecall.impl.tracer.w.a(r11);
        com.larus.voicecall.impl.tracer.w.c(false);
        SubtitleSingleImageHolder.f.clear();
        LinearLayoutManager r12 = this.a.c.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L31;
        LinearLayoutManager r13 = r12;
    L32:
        if (r13 == null) goto L43;
        int r10 = r13.findFirstVisibleItemPosition();
        int r14 = r13.findLastVisibleItemPosition();
        if (r10 > r14) goto L45;
    L35:
        RecyclerView.ViewHolder r15 = this.a.c.findViewHolderForAdapterPosition(r10);
        if ((r15 instanceof SubtitleSingleImageHolder) == false) goto L38;
        SubtitleSingleImageHolder r16 = (SubtitleSingleImageHolder) r15;
    L39:
        if (r16 == null) goto L41;
        r16.T3();
    L41:
        if (r10 == r14) goto L46;
        r10 = r10 + 1;
        goto L35
    L46:
        return;
    L38:
        r16 = null;
        goto L39
    L45:
        return;
    L43:
        return;
    L31:
        r13 = null;
        goto L32
    L27:
        r8 = 300;
    L23:
        r7 = null;
    L14:
        r4 = false;
        goto L15
    L5:
        if (this.a.c.isComputingLayout() == true) goto L7;
        r1.notifyDataSetChanged();
        this.a.c.scrollToPosition(r1.getItemCount() - 1);
        goto L7
    }

    public static final void T5(final RealtimeCallSubtitleLayout r10, final CustomMarkdownTextView r11) {
        if (r10.c == null) goto L5;
        MessageMenu r0 = new MessageMenu(r11, null, null, Boolean.TRUE, null, new r(r11, r10), SpeechEvent.SERVER_UPLINK_EVENT_MUTE_CALL);
    L6:
        FLogger.a.i(r10.k, "selectText");
        r10.m = true;
        if (r0 == null) goto L10;
        RecyclerView r12 = r10.a.c;
        WeakReference r13 = MessageMenu.x;
        r0.f(r12, null, null);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout$linearSmoothScroller$1] */
    public RealtimeCallSubtitleLayout(final Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562872, this);
        int r10 = 2131379657;
        View r2 = ViewBindings.findChildViewById(this, 2131379657);
        if (r2 == null) goto L13;
        r10 = 2131384070;
        RecyclerView r3 = ViewBindings.findChildViewById(this, 2131384070);
        if (r3 == null) goto L13;
        r10 = 2131385216;
        FastScrollButton r4 = ViewBindings.findChildViewById(this, 2131385216);
        if (r4 == null) goto L13;
        r10 = 2131388698;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131388698);
        if (r5 == null) goto L13;
        this.a = new LarusLayoutRealtimeCallSubtitleBinding(this, r2, r3, r4, r5);
        this.g = ThemeType.DEFAULT;
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.k = "RealtimeCallSubtitleLayout";
        this.l = true;
        this.n = true;
        this.v = new RealtimeCallSubtitleLayout$linearSmoothScroller$1(r7);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public final void V5(q0 r8, e3a.b r9, g r10) {
        Intrinsics.checkNotNullParameter(r9, "runtimeData");
        Intrinsics.checkNotNullParameter(r10, "actionProvider");
        if (this.e == false) goto L6;
        FLogger.a.i(this.k, "init");
        return;
    L6:
        boolean r0 = true;
        this.e = true;
        this.b = r8;
        this.f = r9;
        ThemeType r11 = ((h88.b) r9).i;
        this.g = r11;
        Application r12 = c4a.f.a;
        LarusLayoutRealtimeCallSubtitleBinding r13 = this.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r11, "themeType");
        c4a.f.b(r13.e, r11, true);
        if (this.g != ThemeType.IMMERS_BOT) goto L27;
        RealtimeCallUtil r14 = RealtimeCallUtil.a;
        e3a.b r15 = this.f;
        if (r15 != null) goto L11;
    L13:
        r0 = false;
    L14:
        r14.getClass();
        if (RealtimeCallUtil.e(r0) == false) goto L17;
        int r16 = i5.D();
    L18:
        ViewParent r17 = this.a.c.getParent();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r18 = (ViewGroup) r17;
        ViewGroup.LayoutParams r1 = r18.getLayoutParams();
        if (r1 == null) goto L26;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        ((ViewGroup.MarginLayoutParams) r2).height = r16;
        r2.topToTop = -1;
        r2.bottomToBottom = 0;
        r18.setLayoutParams(r2);
        RecyclerView r19 = this.a.c;
        ViewGroup.LayoutParams r3 = r19.getLayoutParams();
        if (r3 == null) goto L24;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        ((ViewGroup.MarginLayoutParams) r4).height = r16;
        r19.setLayoutParams(r4);
        goto L27
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L17:
        r16 = i5.P();
        goto L18
    L11:
        if (((h88.b) r15).d != true) goto L13;
    L27:
        final RecyclerView r20 = this.a.c;
        ThemeType r5 = this.g;
        q0 r6 = this.b;
        if (r6 == null) goto L32;
        ArrayList<c> r7 = r6.o;
        if (r7 == null) goto L32;
    L33:
        this.c = new RealtimeCallSubtitleAdapter(r5, r7, new t(this), new u(this), new v(this), r10);
        r20.setLayoutManager(new LinearLayoutManager(r20.getContext()));
        r20.setAdapter(this.c);
        r20.setItemAnimator(null);
        r20.addOnScrollListener(new RealtimeCallSubtitleLayout$initRecyclerView$3$4(this, r20));
        r20.setOnTouchListener(new o(this));
        if (z2.a.getRealtimeCallNewStyleConfig().c() == false) goto L37;
        LarusLayoutRealtimeCallSubtitleBinding r21 = this.a;
        final RecyclerView r22 = r21.c;
        final FastScrollButton r23 = r21.d;
        r23.setOnClickListener(new p(r22, r23, this));
        r22.addOnScrollListener(new RealtimeCallSubtitleLayout$setupScrollToBottomButton$2(this));
        return;
    L37:
        return;
    L32:
        r7 = new ArrayList();
        goto L33
    }

    public /* synthetic */ RealtimeCallSubtitleLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
