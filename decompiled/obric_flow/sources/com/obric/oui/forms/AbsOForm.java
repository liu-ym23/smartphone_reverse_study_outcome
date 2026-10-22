package com.obric.oui.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012R>\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u000f\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "", "setInScrollView1", "(Z)V", "setInScrollView", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "g", "Ljava/util/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "textWatchers", "j", "Z", "isInScrollView", "()Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOForm extends ConstraintLayout {
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13231j;

    @JvmOverloads
    public AbsOForm(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.f13231j == false) goto L36;
        float r5 = r10.getX();
        float r11 = r10.getY();
        int r12 = r10.getAction();
        if (r12 != 0) goto L8;
        this.f13229h = r11;
        goto L36
    L8:
        if (r12 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r12 != 2) goto L12;
        EditText r13 = getInterEditText();
        Intrinsics.checkNotNull(r13);
        if (r5 <= this.f13230i) goto L20;
        if (r13.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f13230i = r5;
        this.f13229h = r11;
    L20:
        if (r5 >= this.f13230i) goto L24;
        if (r13.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r11 >= this.f13229h) goto L28;
        if (r13.canScrollVertically(1) == true) goto L31;
    L28:
        if (r11 <= this.f13229h) goto L32;
        if (r13.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r12 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r10);
    }

    public abstract EditText getInterEditText();

    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.g;
    }

    public final void setInScrollView(boolean r5) {
        this.f13231j = r5;
    }

    @JvmName(name = "setInScrollView1")
    public final void setInScrollView1(boolean r5) {
        this.f13231j = r5;
    }

    public final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g = r5;
    }

    @JvmOverloads
    public AbsOForm(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ AbsOForm(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public AbsOForm(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.g = new ArrayList();
    }
}
