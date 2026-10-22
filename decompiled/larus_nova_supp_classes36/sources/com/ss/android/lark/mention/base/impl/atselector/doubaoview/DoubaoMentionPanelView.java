package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.adapter.DoubaoAtSelectBaseAdapter;
import com.ss.android.lark.mention.base.impl.atselector.view.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0007J,\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007J\b\u0010!\u001a\u00020\u001aH\u0007J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010&\u001a\u00020\u001aJ\b\u0010'\u001a\u00020\u001aH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionPanelView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/mention/base/impl/atselector/view/OnTextChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "bindJob", "Lkotlinx/coroutines/Job;", "debounceHelper", "Lcom/ss/android/lark/mention/base/impl/atselector/view/TextChangeDebounceHelper;", "adapter", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/adapter/DoubaoAtSelectBaseAdapter;", "ui", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionPanelUi;", "delegate", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionPanelView$Delegate;", "viewModel", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionViewModel;", "initListeners", "", "updateMaxHeight", "maxHeightPx", "bind", "autoLoadRecommend", "", "showCloseButton", "unbind", "onTextChanged", "text", "", "handleTextChange", "clear", "onDetachedFromWindow", "Companion", "Delegate", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoMentionPanelView extends FrameLayout implements m {
    public static final /* synthetic */ int f = 0;
    public final CoroutineScope a;
    public Job b;
    public final DoubaoMentionPanelUi c;
    public c d;
    public DoubaoMentionViewModel e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DoubaoMentionPanelView a;

        public a(DoubaoMentionPanelView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.i("DoubaoMentionPanelView", "closeButton clicked, viewHash=" + System.identityHashCode(this.a));
            this.a.b();
            c r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.c();
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(Map<String, ChatChatter> r1);

        void c();

        void d(boolean r1);
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DoubaoMentionPanelView a;

        public d(DoubaoMentionPanelView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.e.scrollToPosition(0);     // Catch: Throwable -> L4
            LinearLayoutManager r0 = this.a.c.e.getLayoutManager();     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");     // Catch: Throwable -> L4
            r0.scrollToPositionWithOffset(0, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public DoubaoMentionPanelView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoubaoMentionPanelView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        DoubaoMentionViewModel r0 = this.e;
        if (r0 == null) goto L5;
        r0.resetSelectedResult();
    L5:
        DoubaoMentionViewModel r1 = this.e;
        if (r1 == null) goto L8;
        r1.clearSearch();
    L8:
        this.c.e.post(new d(this));
    }

    public final void c() {
        Log.i("DoubaoMentionPanelView", "unbind viewHash=" + System.identityHashCode(this));
        Job r0 = this.b;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.b = null;
        this.d = null;
        this.e = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("DoubaoMentionPanelView", "onDetachedFromWindow viewHash=" + System.identityHashCode(this));
        c();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.view.m
    public final void h(String r5) {
        StringBuilder r0 = new StringBuilder("onTextChanged len=");
        if (r5 == null) goto L5;
        Integer r1 = Integer.valueOf(r5.length());
    L6:
        r0.append(r1);
        r0.append(", viewHash=");
        r0.append(System.identityHashCode(this));
        Log.d("DoubaoMentionPanelView", r0.toString());
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        DoubaoMentionViewModel r2 = this.e;
        if (r2 != null) goto L12;
        Log.w("DoubaoMentionPanelView", "handleTextChange ignored: viewModel is null");
        return;
    L12:
        String r6 = StringsKt.trim(r5).toString();
        if (r6.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        Log.i("DoubaoMentionPanelView", "handleTextChange -> clearSearch");
        r2.clearSearch();
        return;
    L18:
        Log.i("DoubaoMentionPanelView", "handleTextChange -> search keyLen=" + r6.length());
        r2.search(r6);
        return;
    L15:
        r3 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public DoubaoMentionPanelView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        DoubaoAtSelectBaseAdapter r7 = new DoubaoAtSelectBaseAdapter(r4);
        DoubaoMentionPanelUi r0 = new DoubaoMentionPanelUi(r4, r7);
        this.c = r0;
        Intrinsics.checkNotNullParameter(this, "parent");
        setBackgroundResource(2131233994);
        LinearLayout r8 = new LinearLayout(getContext());
        r8.setOrientation(1);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r8.addView(r0.d);
        r8.addView(r0.e);
        addView(r8);
        addView(r0.f);
        e r9 = new e(this);
        Intrinsics.checkNotNullParameter(r9, "listener");
        r7.b = r9;
        r0.b.setOnClickListener(new a(this));
        Log.i("DoubaoMentionPanelView", "init viewHash=" + System.identityHashCode(this));
    }

    public /* synthetic */ DoubaoMentionPanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(DoubaoMentionViewModel r10, c r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "delegate");
        Log.i("DoubaoMentionPanelView", "bind autoLoadRecommend=" + r12 + ", viewHash=" + System.identityHashCode(this) + ", vmHash=" + System.identityHashCode(r10) + ", delegate=" + r11.getClass().getSimpleName());
        this.e = r10;
        this.d = r11;
        View r0 = this.c.b;
        if (r13 == false) goto L5;
        int r14 = 0;
    L6:
        r0.setVisibility(r14);
        Job r15 = this.b;
        if (r15 == null) goto L9;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L9:
        this.b = BuildersKt.launch$default(this.a, null, null, new DoubaoMentionPanelView$bind$1(r10, this, r11, null), 3, null);
        if (r12 == false) goto L13;
        Log.i("DoubaoMentionPanelView", "auto loadRecommend");
        r10.loadRecommend();
        return;
    L13:
        return;
    L5:
        r14 = 8;
        goto L6
    }
}
