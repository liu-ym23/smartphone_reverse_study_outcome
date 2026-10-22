package com.ss.android.lark.movable.preview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.ss.android.lark.movable.MovableGlobalManager;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.selection.h;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/movable/preview/MovableTablePreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "movableView", "Lcom/ss/android/lark/movable/MarkdownMovableView;", "contentContainer", "Landroid/widget/LinearLayout;", "lastAppliedMovableWidthPx", "", "currentMarkdown", "", "copyStrategy", "Lcom/ss/android/lark/movable/selection/MovableCopyStrategy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateMovableViewWidth", "containerWidthPx", "renderMarkdownIfReady", "widthPx", "getCurrentMovableWidthPx", "onCopyClicked", "resolveCopyStrategy", "resolveRenderConfig", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "toggleOrientation", "onDestroyView", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MovableTablePreviewFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public MarkdownMovableView d;
    public LinearLayout e;
    public int f;
    public String g;
    public h h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MovableTablePreviewFragment a;

        public b(MovableTablePreviewFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MovableTablePreviewFragment r0 = this.a;     // Catch: Throwable -> L8
            LinearLayout r1 = r0.e;     // Catch: Throwable -> L8
            if (r1 == null) goto L5;
            int r2 = r1.getWidth();     // Catch: Throwable -> L8
        L6:
            MovableTablePreviewFragment.S90(r0, r2);     // Catch: Throwable -> L8
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

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ MovableTablePreviewFragment a;

        public c(MovableTablePreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            if (r10 <= 0) goto L6;
            MovableTablePreviewFragment.S90(this.a, r10);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MovableTablePreviewFragment a;

        public d(MovableTablePreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.requireActivity().finish();
        }
    }

    public static final class e extends com.ss.android.lark.ui.c {
        public final /* synthetic */ MovableTablePreviewFragment d;

        public e(MovableTablePreviewFragment r2) {
            this.d = r2;
            super(2131254165, 2131102418);
        }

        public final void performAction(View r5) {
            MovableTablePreviewFragment r6 = this.d;
            int r0 = MovableTablePreviewFragment.i;
            Context r1 = r6.getContext();
            if (r1 == null) goto L23;
            String r2 = r6.g;
            if (StringsKt.isBlank(r2) == false) goto L9;
            Log.w("MovableTablePreviewFragment", "copy ignored: markdown not ready");
            return;
        L9:
            if (r6.h.a(r2, r2, r1) == true) goto L24;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
            r6.h.b(r2, r2, r1);     // Catch: Throwable -> L13
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        L15:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L22;
            Log.e("MovableTablePreviewFragment", "copy failed", r8, true);
            return;
        L22:
            return;
        L13:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L24:
            return;
        }
    }

    public static final class f extends com.ss.android.lark.ui.c {
        public final /* synthetic */ MovableTablePreviewFragment d;

        public f(MovableTablePreviewFragment r2) {
            this.d = r2;
            super(2131254972, 0);
        }

        public final void performAction(View r2) {
            MovableTablePreviewFragment r3 = this.d;
            int r0 = MovableTablePreviewFragment.i;
            FragmentActivity r4 = r3.getActivity();
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.getRequestedOrientation() != 0) goto L8;
            int r1 = 1;
        L9:
            r4.setRequestedOrientation(r1);
            return;
        L8:
            r1 = 0;
            goto L9
        }
    }

    static {
    }

    public MovableTablePreviewFragment() {
        this.g = "";
        this.h = new com.ss.android.lark.movable.selection.a();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        MarkdownMovableView r0 = this.d;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.d = null;
        this.e = null;
        this.f = 0;
    }

    public final void T90(int r4) {
        MarkdownMovableView r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(this.g) == true) goto L13;
        if (r4 > 0) goto L9;
        return;
    L9:
        if (r0.getMovableDocumentInfo() != null) goto L15;
        Context r1 = r0.getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r2 = r1.getResources();
        MarkdownMovableView.k(r0, this.g, (int) ((r4 / WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density) + 0.5f));
        return;
    L15:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        this.f = 0;
        View r3 = getView();
        if (r3 == null) goto L6;
        r3.post(new b(this));
        return;
    }

    public static final void S90(MovableTablePreviewFragment r3, int r4) {
        MarkdownMovableView r0 = r3.d;
        if (r0 == null) goto L26;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L9:
        if (r2 == null) goto L27;
        int r5 = RangesKt.coerceAtLeast((r4 - r2.leftMargin) - r2.rightMargin, 0);
        if (r5 > 0) goto L14;
        return;
    L14:
        if (r5 == r3.f) goto L28;
        r3.f = r5;
        if (r2.width == r5) goto L23;
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        if (r6 == null) goto L22;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        r7.width = r5;
        r0.setLayoutParams(r7);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L23:
        r3.T90(r5);
        return;
    L28:
        return;
    L27:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        String r7 = requireArguments().getString("markdown_key");
        ViewGroup.MarginLayoutParams r8 = null;
        if (r7 == null) goto L5;
        String r0 = com.ss.android.lark.movable.preview.a.a.get(r7);
    L6:
        int r1 = 0;
        if (r0 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        Log.w("MovableTablePreviewFragment", "markdown not found for key=" + r7 + ", finish");
        requireActivity().finish();
        return;
    L17:
        Log.i("MovableTablePreviewFragment", "table markdown size=" + r0.length());
        this.g = r0;
        MarkdownMovableView r9 = this.d;
        if (r9 == null) goto L32;
        int r3 = r9.getWidth();
        if (r3 <= 0) goto L23;
        r1 = r3;
        goto L32
    L23:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r8 = (ViewGroup.MarginLayoutParams) r10;
    L26:
        if (r8 == null) goto L32;
        LinearLayout r11 = this.e;
        if (r11 == null) goto L31;
        r1 = r11.getWidth();
    L31:
        r1 = (r1 - r8.leftMargin) - r8.rightMargin;
    L32:
        T90(r1);
        return;
    L9:
        if (StringsKt.isBlank(r0) == true) goto L12;
        r2 = false;
        goto L14
    L5:
        ConcurrentHashMap<String, String> r4 = com.ss.android.lark.movable.preview.a.a;
        r0 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Context r10 = requireContext();
        int r11 = requireArguments().getInt("source_instance_id", -1);
        MovableView r12 = MovableGlobalManager.d.a().b(r11);
        if (r12 == null) goto L7;
        h r13 = r12.getCopyStrategy();
        if (r13 == null) goto L7;
    L8:
        this.h = r13;
        LinearLayout r14 = new LinearLayout(r10);
        r14.setOrientation(1);
        r14.setBackgroundResource(2131100548);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        CommonTitleBar r2 = new CommonTitleBar(r10);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r2.setLeftClickListener(new d(this));
        r2.setTitle("");
        r2.addAction(new e(this));
        r2.addAction(new f(this));
        r14.addView(r2);
        ScrollView r3 = new ScrollView(r10);
        r3.setBackgroundResource(2131100548);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r3.setFillViewport(true);
        LinearLayout r1 = new LinearLayout(r10);
        r1.setOrientation(1);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r1.addOnLayoutChangeListener(new c(this));
        this.e = r1;
        MarkdownMovableView r15 = new MarkdownMovableView(r10, null);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -2);
        r16.leftMargin = com.ss.android.lark.movable.utils.e.a(12);
        r16.rightMargin = com.ss.android.lark.movable.utils.e.a(12);
        r16.topMargin = com.ss.android.lark.movable.utils.e.a(10);
        r16.bottomMargin = com.ss.android.lark.movable.utils.e.a(10);
        r15.setLayoutParams(r16);
        r15.setupMarkdown(new MovableTablePreviewFragment$onCreateView$md$1$2(this));
        this.d = r15;
        r1.addView(r15);
        r3.addView(r1);
        r14.addView(r3);
        return r14;
    L7:
        r13 = new com.ss.android.lark.movable.selection.a();
        goto L8
    }
}
