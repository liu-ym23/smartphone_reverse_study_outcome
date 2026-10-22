package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004^_`aB'\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0007¢\u0006\u0004\b\\\u0010]J6\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J2\u0010\u0012\u001a\u00020\t2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u0016\u001a\u00020\t2#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0011Js\u0010\u001f\u001a\u00020\t2b\u0010\u000f\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0017H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJs\u0010\"\u001a\u00020\t2b\u0010\u000f\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\t0\u0017H\u0000¢\u0006\u0004\b!\u0010\u001eJ4\u0010%\u001a\u00020\t2#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\u000bH\u0000¢\u0006\u0004\b$\u0010\u0011J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020&H\u0014J\b\u0010)\u001a\u00020&H\u0014J\b\u0010*\u001a\u00020&H\u0014J\u0012\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00103\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u000101H\u0016J\u0018\u00106\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J0\u0010<\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\b\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010@\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0014R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010ER\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010E¨\u0006b"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "leftFading", "topFading", "rightFading", "bottomFading", "", "fadingLength", "", "setTextFading", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "hasFocus", "action", "onFocusChange$OUI_standardRelease", "(Lkotlin/jvm/functions/Function1;)V", "onFocusChange", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onOnTouchEvent$OUI_standardRelease", "onOnTouchEvent", "Lkotlin/Function4;", "", "s", CommonConsts.APM_INNER_EVENT_COST_START, CommonConsts.COUNT_TYPE, "after", "beforeTextChanged$OUI_standardRelease", "(Lkotlin/jvm/functions/Function4;)V", "beforeTextChanged", "before", "onTextChanged$OUI_standardRelease", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged$OUI_standardRelease", "afterTextChanged", "", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "Landroid/view/inputmethod/CompletionInfo;", "text", "onCommitCompletion", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "setOnFocusChangeListener", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "performLongClick", "selStart", "selEnd", "onSelectionChanged", "Lcom/obric/oui/forms/OEditText$d;", "textWatcherWrapper", "Lcom/obric/oui/forms/OEditText$d;", "isBottomFading", "Z", "isTopFading", "isPerformingLongClick", "isLeftFading", "Lcom/obric/oui/forms/OEditText$c;", "onTouchListenerWrapper", "Lcom/obric/oui/forms/OEditText$c;", "Lcom/obric/oui/forms/OEditText$b;", "onFocusChangeListenerWrapper", "Lcom/obric/oui/forms/OEditText$b;", "Lcom/obric/oui/forms/OEditText$a;", "commitCompletionListener", "Lcom/obric/oui/forms/OEditText$a;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$a;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$a;)V", "isRightFading", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OEditText extends AppCompatEditText {
    private a commitCompletionListener;
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isPerformingLongClick;
    private boolean isRightFading;
    private boolean isTopFading;
    private final b onFocusChangeListenerWrapper;
    private final c onTouchListenerWrapper;
    private final d textWatcherWrapper;

    public interface a {
        void a(CompletionInfo r10);
    }

    private static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Function1<? super Boolean, Unit> f6574c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View.OnFocusChangeListener f6575g;

        public b() {
        }

        public final View.OnFocusChangeListener a() {
            return this.f6575g;
        }

        public final void b(Function1<? super Boolean, Unit> r10) {
            this.f6574c = r10;
        }

        public final void c(View.OnFocusChangeListener r10) {
            this.f6575g = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            Function1<? super Boolean, Unit> r12 = this.f6574c;
            if (r12 == null) goto L5;
            Unit r13 = r12.invoke(Boolean.valueOf(r11));
        L5:
            View.OnFocusChangeListener r14 = this.f6575g;
            if (r14 == null) goto L9;
            r14.onFocusChange(r10, r11);
            return;
        }
    }

    private static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Function1<? super MotionEvent, Unit> f6576c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View.OnTouchListener f6577g;

        public c() {
        }

        public final void a(Function1<? super MotionEvent, Unit> r10) {
            this.f6576c = r10;
        }

        public final void b(View.OnTouchListener r10) {
            this.f6577g = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            Function1<? super MotionEvent, Unit> r12 = this.f6576c;
            if (r12 == null) goto L5;
            Unit r13 = r12.invoke(r11);
        L5:
            View.OnTouchListener r14 = this.f6577g;
            if (r14 != null) goto L10;
            return false;
        L10:
            return r14.onTouch(r10, r11);
        }
    }

    private static final class d implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> f6578c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> f6579g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Function1<? super Editable, Unit> f6580h;

        public d() {
        }

        public final void a(Function1<? super Editable, Unit> r10) {
            this.f6580h = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            Function1<? super Editable, Unit> r11 = this.f6580h;
            if (r11 == null) goto L6;
            Unit r12 = r11.invoke(r10);
            return;
        }

        public final void b(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r10) {
            this.f6579g = r10;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r14 = this.f6579g;
            if (r14 == null) goto L6;
            Unit r15 = r14.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
            return;
        }

        public final void c(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r10) {
            this.f6578c = r10;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r14 = this.f6578c;
            if (r14 == null) goto L6;
            Unit r15 = r14.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
            return;
        }
    }

    @JvmOverloads
    public OEditText(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OEditText(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OEditText(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        b r13 = new b();
        this.onFocusChangeListenerWrapper = r13;
        c r14 = new c();
        this.onTouchListenerWrapper = r14;
        d r15 = new d();
        this.textWatcherWrapper = r15;
        setOnFocusChangeListener(r13);
        super.setOnTouchListener(r14);
        addTextChangedListener(r15);
        setHighlightColor(r10.getColor(u8.c.oui_text_highlight_color));
    }

    public /* synthetic */ OEditText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static /* synthetic */ void setTextFading$default(OEditText r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((r16 & 2) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r16 & 4) == 0) goto L13;
        boolean r20 = false;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r21 = false;
    L18:
        r10.setTextFading(r18, r19, r20, r21, r15);
        return;
    L17:
        r21 = r14;
        goto L18
    L13:
        r20 = r13;
        goto L15
    L9:
        r19 = r12;
        goto L11
    L5:
        r18 = r11;
        goto L7
    }

    public final void afterTextChanged$OUI_standardRelease(Function1<? super Editable, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        this.textWatcherWrapper.a(r10);
    }

    public final void beforeTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        this.textWatcherWrapper.b(r10);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    public final a getCommitCompletionListener() {
        return this.commitCompletionListener;
    }

    @Override // android.widget.TextView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r10 = super.getOnFocusChangeListener();
        if ((r10 instanceof b) == true) goto L5;
        return r10;
    L5:
        return ((b) r10).a();
    }

    @Override // android.widget.TextView, android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r10) {
        super.onCommitCompletion(r10);
        a r11 = this.commitCompletionListener;
        if (r11 == null) goto L6;
        r11.a(r10);
        return;
    }

    public final void onFocusChange$OUI_standardRelease(Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        this.onFocusChangeListenerWrapper.b(r10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void onOnTouchEvent$OUI_standardRelease(Function1<? super MotionEvent, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        this.onTouchListenerWrapper.a(r10);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int r10, int r11) {
        super.onSelectionChanged(r10, r11);
        if (r10 == r11) goto L5;
        boolean r12 = true;
    L7:
        if (this.isPerformingLongClick == true) goto L11;
        if (r12 == false) goto L12;
        q9.a.b(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r12 = false;
        goto L7
    }

    public final void onTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        this.textWatcherWrapper.c(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.isPerformingLongClick = true;
        boolean r10 = super.performLongClick();
        this.isPerformingLongClick = false;
        return r10;
    }

    public final void setCommitCompletionListener(a r10) {
        this.commitCompletionListener = r10;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r10) {
        if ((r10 instanceof b) == false) goto L5;
        super.setOnFocusChangeListener(r10);
        return;
    L5:
        this.onFocusChangeListenerWrapper.c(r10);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r10) {
        this.onTouchListenerWrapper.b(r10);
    }

    public final void setTextFading(boolean r10, boolean r11, boolean r12, boolean r13, int r14) {
        setFadingEdgeLength(r14);
        this.isLeftFading = r10;
        this.isTopFading = r11;
        this.isRightFading = r12;
        this.isBottomFading = r13;
        boolean r15 = false;
        if (r10 == true) goto L7;
        if (r12 == true) goto L7;
        boolean r16 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r16);
        if (this.isTopFading == false) goto L11;
    L12:
        r15 = true;
    L13:
        setVerticalFadingEdgeEnabled(r15);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r16 = true;
        goto L8
    }
}
