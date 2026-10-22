package com.larus.uaigc.music.template;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.Logger;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.platform.api.g0;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusPageTemplateBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.c7;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0001%\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u001bJF\u0010,\u001a\u00020\f2>\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\u0004\u0018\u0001`\rJ&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00105\u001a\u00020\fH\u0002J\u0010\u00106\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0002J\u0006\u00107\u001a\u00020\fJ\u000e\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u000209J\b\u0010<\u001a\u00020\fH\u0016J\b\u0010=\u001a\u00020\fH\u0016J\b\u0010>\u001a\u00020\fH\u0016J\b\u0010?\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020\fH\u0002RF\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\u0004\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "musicTemplateChoose", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "enterFrom", "", "Lcom/larus/uaigc/music/template/TemplateChooseCallback;", "botId", "chatType", "binding", "Lcom/larus/uaigc/impl/databinding/LarusPageTemplateBinding;", "spanCount", "", "adapter", "Lcom/larus/uaigc/music/template/MusicTemplateAdapter;", "hasMore", "", "inLoading", "offset", "model", "Lcom/larus/uaigc/music/template/MusicTemplateModel;", "dismissListener", "Lkotlin/Function0;", "previousPage", "compatDoubleTabMarginBottom", "hideTitleBar", "isMusicAppletTemplatePage", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "appletLifecycleCallback", "com/larus/uaigc/music/template/MusicTemplateListFragment$appletLifecycleCallback$1", "Lcom/larus/uaigc/music/template/MusicTemplateListFragment$appletLifecycleCallback$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUp", "data", "setMusicTemplateChoose", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "resetPadding", "generateTitleBar", "scrollToTop", "chatTitleBar", "Lcom/larus/platform/api/IChatTitle;", "setTitleBar", "chatTitle", "onResume", "onPause", "onDestroy", "requestFirstTemplateList", "requestMoreTemplateRecommendList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateListFragment extends Fragment {
    public static final /* synthetic */ int s = 0;
    public Function2<? super bq8.a, ? super String, Unit> d;
    public String e;
    public String f;
    public LarusPageTemplateBinding g;
    public int h;
    public MusicTemplateAdapter i;
    public boolean j;
    public boolean k;
    public int l;
    public MusicTemplateModel m;
    public boolean n;
    public boolean o;
    public final et3.c p;
    public final b q;
    public g0 r;

    public static final class a {
    }

    public static final class b implements ir8.c.a {
        public final /* synthetic */ MusicTemplateListFragment a;

        public final void a() {
            Intrinsics.checkNotNullParameter("db_2c90E66", "appId");
            if (this.a.o == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual("db_2c90E66", "db_2c90E66") == false) goto L16;
            Logger.i("MusicTemplateListFragment", "music applet template background, pause template players");
            MusicTemplateAdapter r0 = this.a.i;
            if (r0 == null) goto L15;
            Iterator<MusicTemplateAdapter.MusicViewHolder> r1 = r0.l.iterator();
        L11:
            if (r1.hasNext() == false) goto L17;
            r1.next().e.a();
            goto L11
        L17:
            return;
        L15:
            return;
        }

        public b(MusicTemplateListFragment r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.music.template.MusicTemplateListFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListFragment$onViewCreated$3", f = "MusicTemplateListFragment.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MusicTemplateListFragment this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.music.template.MusicTemplateListFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListFragment$onViewCreated$3$1", f = "MusicTemplateListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ MusicTemplateListFragment this$0;

            public AnonymousClass1(MusicTemplateListFragment r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
                r0.I$0 = ((Number) r3).intValue();
                return r0;
            }

            public final Object invoke(int r1, Continuation<? super Unit> r2) {
                return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke(((Number) r1).intValue(), (Continuation) r2);
            }

            public final Object invokeSuspend(Object r9) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r9);
                int r10 = this.I$0;
                Logger.i("MusicTemplateListFragment", "collect read index " + r10);
                MusicTemplateListFragment r0 = this.this$0;
                if (r10 <= (r0.l - 1)) goto L8;
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new MusicTemplateListFragment$requestMoreTemplateRecommendList$1(r0, null), 3, null);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(MusicTemplateListFragment r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MusicTemplateRepository r7 = MusicTemplateRepository.a;
            MutableSharedFlow<Integer> r8 = MusicTemplateRepository.b;
            AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void S90() {
        LarusPageTemplateBinding r0 = this.g;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        e1.x(r1);
    L7:
        LarusPageTemplateBinding r2 = this.g;
        if (r2 == null) goto L12;
        LoadingWithRetryView r3 = r2.d;
        if (r3 == null) goto L12;
        e1.o(r3);
    L12:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MusicTemplateListFragment$requestFirstTemplateList$1(this, null), 3, null);
    }

    public final void onDestroy() {
        CopyOnWriteArraySet r0 = ir8.c.a;
        ir8.c.c(this.q);
        super.onDestroy();
    }

    public MusicTemplateListFragment() {
        this.h = 2;
        this.p = new et3.c("List_MusicTemplate", false, null);
        this.q = new b(this);
    }

    public final void onPause() {
        super.onPause();
        com.larus.bmhome.music.player.b.a.getClass();
        com.larus.bmhome.music.player.b.a.i = true;
    }

    public final void onResume() {
        super.onResume();
        com.larus.bmhome.music.player.b.a.getClass();
        int r0 = 0;
        com.larus.bmhome.music.player.b.a.i = false;
        Bundle r1 = getArguments();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (true != r1.getBoolean("adapt_nav_bar_padding")) goto L7;
    L8:
        if (r2 == false) goto L21;
        LarusPageTemplateBinding r3 = this.g;
        if (r3 == null) goto L22;
        ConstraintLayout r4 = r3.a;
        if (r4.isAttachedToWindow() == false) goto L19;
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r4);
        if (r5 == null) goto L18;
        Insets r6 = r5.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r6 == null) goto L18;
        r0 = r6.bottom;
    L18:
        int r7 = r4.getPaddingStart();
        int r8 = r4.getPaddingTop();
        int r9 = r4.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:resetPadding,start:" + r7 + ",top:" + r8 + ",end:" + r9 + ",bottom:" + r0);
        r4.setPaddingRelative(r7, r8, r9, r0);
        return;
    L19:
        r4.addOnAttachStateChangeListener(new o(r4));
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        String r5 = r4.getString("argBotId", "");
        if (r5 == null) goto L6;
    L7:
        this.e = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("arg_chat_type", "");
        if (r7 == null) goto L11;
    L12:
        this.f = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L15;
        r8.getString("argPreviousPage", "");
    L15:
        Bundle r9 = getArguments();
        boolean r0 = false;
        if (r9 == null) goto L18;
        r9.getBoolean("compatDoubleTabMargin", false);
    L18:
        Bundle r10 = getArguments();
        if (r10 == null) goto L21;
        boolean r11 = r10.getBoolean("argument_hide_title_bar", false);
    L22:
        this.n = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L25;
        r0 = r12.getBoolean("argument_is_music_applet_template", false);
    L25:
        this.o = r0;
        if (r0 == false) goto L29;
        CopyOnWriteArraySet r13 = ir8.c.a;
        b r14 = this.q;
        Intrinsics.checkNotNullParameter(r14, "callback");
        ir8.c.a.add(r14);
        return;
    L29:
        return;
    L21:
        r11 = false;
    L11:
        r7 = "";
    L6:
        r5 = "";
        goto L7
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Context r9 = getContext();
        if (r9 == null) goto L5;
        float r10 = c7.d(Integer.valueOf(com.larus.utils.i.d(r9)));
    L7:
        if (r10 <= 500.0f) goto L9;
        this.h = 3;
    L9:
        LarusPageTemplateBinding r11 = this.g;
        if (r11 == null) goto L14;
        LoadingWithRetryView r12 = r11.d;
        if (r12 == null) goto L14;
        r12.setOnRetryListener(new j(this));
    L14:
        S90();
        LarusPageTemplateBinding r13 = this.g;
        if (r13 == null) goto L19;
        RecyclerView r14 = r13.e;
        if (r14 == null) goto L19;
        r14.addOnScrollListener(new AnonymousClass2(this));
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        LarusPageTemplateBinding r15 = this.g;
        if (r15 == null) goto L24;
        RecyclerView r0 = r15.e;
        if (r0 == null) goto L24;
        y6.f(r0, new k(this), new l(), 0.0f, new m(this), 57);
    L24:
        LarusPageTemplateBinding r16 = this.g;
        if (r16 != null) goto L27;
        return;
    L27:
        if (this.n == false) goto L29;
        e1.o(r16.f);
    L46:
        r16.c.setEnabled(false);
        return;
    L29:
        FrameLayout r17 = r16.f;
        if (r17.getChildCount() == 0) goto L32;
        boolean r1 = true;
    L33:
        if (r1 == true) goto L35;
    L37:
        r17.removeAllViews();
        View r2 = this.r;
        if (r2 != null) goto L40;
    L42:
        Context r3 = getContext();
        if (r3 == null) goto L46;
        ViewGroup r4 = IAIChatUgcAIGCService.a.O(r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r5 = r4;
        r17.addView(r5);
        ViewGroup.LayoutParams r18 = r5.getLayoutParams();
        r18.width = -1;
        r18.height = -1;
        goto L46
    L40:
        if ((r2 instanceof View) == false) goto L42;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        r17.addView(r2);
        goto L46
    L35:
        if ((ViewGroupKt.get(r17, 0) instanceof g0) == false) goto L37;
    L32:
        r1 = false;
        goto L33
    L5:
        r10 = 200.0f;
        goto L7
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131563077, r9, false);
        int r12 = 2131379091;
        RecyclerView r2 = ViewBindings.findChildViewById(r11, 2131379091);
        if (r2 == null) goto L15;
        r12 = 2131384141;
        SwipeRefreshLayout r3 = ViewBindings.findChildViewById(r11, 2131384141);
        if (r3 == null) goto L15;
        r12 = 2131384472;
        LoadingWithRetryView r4 = ViewBindings.findChildViewById(r11, 2131384472);
        if (r4 == null) goto L15;
        r12 = 2131388332;
        RecyclerView r5 = ViewBindings.findChildViewById(r11, 2131388332);
        if (r5 == null) goto L15;
        r12 = 2131388843;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131388843);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        this.g = new LarusPageTemplateBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
