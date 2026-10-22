package com.obric.oui.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH&J\u0015\u0010\f\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0007¢\u0006\u0002\b!J6\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013`\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInScrollView", "", "()Z", "setInScrollView", "(Z)V", "lastScrollX", "", "lastScrollY", "textWatchers", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInterEditText", "Landroid/widget/EditText;", "", "b", "setInScrollView1", "setTextFading", "leftFading", "topFading", "rightFading", "bottomFading", "fadingLength", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOForm extends ConstraintLayout {
    private boolean isInScrollView;
    private float lastScrollX;
    private float lastScrollY;
    private ArrayList<WeakReference<TextWatcher>> textWatchers;

    public AbsOForm(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AbsOForm(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public AbsOForm(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.textWatchers = new ArrayList();
    }

    public /* synthetic */ AbsOForm(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static /* synthetic */ void setTextFading$default(AbsOForm r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L22;
        if ((r13 & 1) == 0) goto L6;
        boolean r2 = false;
    L8:
        if ((r13 & 2) == 0) goto L10;
        boolean r3 = false;
    L12:
        if ((r13 & 4) == 0) goto L14;
        boolean r4 = false;
    L16:
        if ((r13 & 8) == 0) goto L18;
        boolean r5 = false;
    L19:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L18:
        r5 = r11;
        goto L19
    L14:
        r4 = r10;
        goto L16
    L10:
        r3 = r9;
        goto L12
    L6:
        r2 = r8;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextFading");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.isInScrollView == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.lastScrollY = r0;
    L34:
        this.lastScrollY = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        Intrinsics.checkNotNull(r3);
        if (r0 <= this.lastScrollX) goto L19;
        if (r3.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.lastScrollX = r0;
    L19:
        if (r0 >= this.lastScrollX) goto L23;
        if (r3.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r1 >= this.lastScrollY) goto L27;
        if (r3.canScrollVertically(1) == true) goto L30;
    L27:
        if (r1 <= this.lastScrollY) goto L31;
        if (r3.canScrollVertically(-1) == false) goto L31;
    L12:
        if (r2 == 3) goto L32;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    public abstract EditText getInterEditText();

    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.textWatchers;
    }

    public final boolean isInScrollView() {
        return this.isInScrollView;
    }

    public final void setInScrollView(boolean r1) {
        this.isInScrollView = r1;
    }

    public final void setInScrollView1(boolean r1) {
        this.isInScrollView = r1;
    }

    public final void setTextFading(boolean r7, boolean r8, boolean r9, boolean r10, int r11) {
        EditText r6 = getInterEditText();
        if (ZeusTransformUtils.instanceOf(r6, OFormEditText.class) == false) goto L6;
        ((OFormEditText) ZeusTransformUtils.preCheckCast(r6, OFormEditText.class, "com.obric.memorydata.plugin")).setTextFading(r7, r8, r9, r10, r11);
        return;
    }

    public final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textWatchers = r2;
    }
}
