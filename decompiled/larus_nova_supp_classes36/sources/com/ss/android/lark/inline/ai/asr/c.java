package com.ss.android.lark.inline.ai.asr;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.asr.subprompt.SubPromptRecyclerView;
import com.ss.android.lark.inline.ai.logic.InlineAIStatus;
import com.ss.android.lark.inline.ai.logic.h;
import com.ss.android.lark.inline.ai.ui.richtext.AIPreviewData;
import com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import slb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final slb.g a;
    public final wlb.e b;
    public final ConstraintLayout c;
    public final nsb.b d;
    public final i1<Boolean> e;
    public final StateFlowImpl f;
    public final CoroutineScope g;
    public RichtextPreviewWebview h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InlineAIStatus.values().length];
            r0[InlineAIStatus.Init.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[InlineAIStatus.Waiting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[InlineAIStatus.Writing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[InlineAIStatus.Finished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[InlineAIStatus.Closed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.c$c, reason: collision with other inner class name */
    public static final class C0101c implements com.ss.android.lark.inline.ai.ui.richtext.b {
        public final /* synthetic */ c a;

        public C0101c(c r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.b
        public final void a(RenderProcessGoneDetail r4) {
            if (Build.VERSION.SDK_INT < 26) goto L8;
            if (r4 == null) goto L6;
            Boolean r5 = Boolean.valueOf(r4.didCrash());
        L7:
            String r6 = String.valueOf(r5);
        L9:
            Log.i("InlineAIPanelController", "onRenderProcessGone== crash: ".concat(r6));
            this.a.a();
            int r0 = zlb.a.d;
            zlb.a.C0355a.e(406, "render gone, crash: " + r6 + '}', 0);
            return;
        L6:
            r5 = null;
            goto L7
        L8:
            r6 = InvRouter.UNKNOWN;
            goto L9
        }
    }

    static {
    }

    public final void a() {
        NestedScrollingChild3 r0 = this.h;
        if (r0 == null) goto L17;
        ViewParent r1 = r0.getParent();     // Catch: Exception -> L12
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r1).removeView(r0);     // Catch: Exception -> L12
    L7:
        RichtextPreviewWebview r2 = this.h;     // Catch: Exception -> L12
        if (r2 == null) goto L10;
        r2.destroy();     // Catch: Exception -> L12
    L10:
        this.h = null;     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.i("InlineAIAsrView", "destroyRichtextPreviewWebview== e: " + e);
        return;
    }

    public final void b() {
        a();
        ((LinearLayout) this.c.findViewById(2131381556)).removeAllViews();
        ((SubPromptRecyclerView) this.c.findViewById(2131387580)).setData(null);
        this.c.findViewById(2131375377).cancelAnimation();
        ViewParent r0 = this.c.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 != null) goto L8;
    L11:
        BuildersKt.launch$default(this.g, null, null, new InlineAIAsrView$removeFromContainer$2(this, null), 3, null);
        return;
    L8:
        if (Intrinsics.areEqual(r1.getFocusedChild(), this.c) == false) goto L10;
        r1.clearFocus();
    L10:
        r1.removeView(this.c);
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void d(com.ss.android.lark.inline.ai.logic.f r12) {
        String r1 = null;
        if (((Boolean) this.f.getValue()).booleanValue() == true) goto L11;
        this.c.getViewTreeObserver().addOnPreDrawListener(new d(this));
        ViewGroup r0 = this.a.d;
        if (r0 == null) goto L7;
        r0.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    L7:
        c((FrameLayout) this.c.findViewById(2131367812), "...", null, null, null);
        ViewGroup r2 = this.a.d;
        if (r2 == null) goto L10;
        r2.requestChildFocus(this.c, null);
    L10:
        BuildersKt.launch$default(this.g, null, null, new InlineAIAsrView$addToContainer$2(this, null), 3, null);
    L11:
        h r3 = com.ss.android.lark.inline.ai.logic.g.a(r12);
        AppCompatTextView r4 = this.c.findViewById(2131370214);
        String r5 = "";
        if (r3 == null) goto L18;
        j r6 = r3.f;
        if (r6 == null) goto L18;
        String r7 = r6.d;
        if (r7 == null) goto L18;
    L19:
        r4.setText(r7);
        FrameLayout r8 = (FrameLayout) this.c.findViewById(2131367812);
        if (r3 == null) goto L22;
        r1 = r3.d;
    L22:
        if (r1 == null) goto L26;
        r5 = r1;
    L26:
        if (r5.length() != 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
        String r10 = "...";
    L32:
        c(r8, r10, r12.b, com.ss.android.lark.inline.ai.logic.g.b(r12), r12.a);
        return;
    L31:
        r10 = r5;
        goto L32
    L28:
        r9 = false;
    L18:
        r7 = "";
        goto L19
    }

    public c(slb.g r2, InlineAIAsrController.d r3, InlineAIAsrController.c r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "subPromptClickListener");
        this.a = r2;
        this.b = r3;
        ConstraintLayout r5 = LayoutInflater.from(r2.getActivity()).inflate(2131561542, r2.d, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.c = r5;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        nsb.b r8 = (nsb.b) r7;
        if (r8 != null) goto L13;
        Log.w("InlineAIAsrView", "MyAIApi SPI not bound, fallback to degraded behavior");
    L13:
        this.d = r8;
        Boolean r9 = Boolean.FALSE;
        i1<Boolean> r0 = j1.a(r9);
        if (r8 == null) goto L19;
        i1<Boolean> r10 = r8.isEnable();
        if (r10 == null) goto L19;
        r0 = r10;
    L19:
        this.e = r0;
        this.f = j1.a(r9);
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c.findViewById(2131370207).setOnClickListener(new e(this));
        this.c.findViewById(2131375411).setOnClickListener(new f(this));
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [android.webkit.WebView, com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview] */
    public final void c(FrameLayout r20, String r21, String r22, String r23, InlineAIStatus r24) {
        if (this.h != null) goto L7;
        FragmentActivity r5 = this.a.getActivity();
        FragmentActivity r7 = this.a.getActivity();
        ScenarioType r15 = ScenarioType.VoiceInput;
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r15, "scenario");
        ?? r2 = new RichtextPreviewWebview(r5, new wlb.h(r7, null, this.a.d, new wlb.j(r7), null, null, -1, false, r15, null, true), this.b, new C0101c(this));
        FragmentActivity r3 = this.a.getActivity();
        com.ss.android.lark.storage.a r6 = com.ss.android.lark.inline.ai.logic.b.a;
        r2.setBackgroundColor(ContextCompat.getColor(r3, 2131100557));
        this.h = r2;
        r2.q();
        RichtextPreviewWebview r4 = this.h;
        if (r4 == null) goto L7;
        r4.r(Integer.toHexString(ContextCompat.getColor(this.a.getActivity(), 2131100549)).substring(2).toUpperCase(Locale.ROOT), "0,16,0,16", "fullscreen");
    L7:
        NestedScrollingChild3 r8 = this.h;
        String r9 = null;
        if (r8 == null) goto L10;
        ViewParent r10 = r8.getParent();
    L12:
        if (Intrinsics.areEqual(r10, r20) == true) goto L16;
        if (r10 == null) goto L15;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r10).removeView(this.h);
    L15:
        r20.removeAllViews();
        r20.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
    L16:
        boolean r1 = h18.f.a(this.a.getActivity());
        RichtextPreviewWebview r11 = this.h;
        if (r11 != null) goto L19;
        return;
    L19:
        if (r1 == false) goto L21;
        String r12 = "dark";
    L22:
        String r13 = r12;
        String r14 = Integer.toHexString(ContextCompat.getColor(this.a.getActivity(), 2131100549)).substring(2).toUpperCase(Locale.ROOT);
        if (r24 != InlineAIStatus.Finished) goto L25;
        r9 = "finish";
    L25:
        AIPreviewData r16 = new AIPreviewData(r21, null, r22, r23, r13, r14, r9, null, 130, null);
        com.ss.android.lark.inline.ai.ui.richtext.g r17 = r11.S;
        if (r17 == null) goto L30;
        amb.d r18 = r17.g;
        if (r18 == null) goto L30;
        r18.b();
    L30:
        com.ss.android.lark.inline.ai.ui.richtext.g r19 = r11.S;
        if (r19 == null) goto L35;
        r19.a(r16);
        return;
    L35:
        return;
    L21:
        r12 = "light";
        goto L22
    L10:
        r10 = null;
        goto L12
    }
}
