package com.larus.community.impl.detail.prompt;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0013J\u0014\u0010%\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$J\u0006\u0010\u000e\u001a\u00020\u000fJ\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fullText", "", "expandText", "maxLines", "isExpanded", "", "expandTextColor", "isCalculated", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onSizeChanged", "w", "h", "oldw", "oldh", "updateText", "setMaxCollapsedLines", "setExpandText", "setExpandTextColor", "color", "expand", "expandAction", "Lkotlin/Function0;", "setExpandListener", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "SavedState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationExpandableTextView extends AppCompatTextView {
    public static final /* synthetic */ int h = 0;
    public String a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public Function0<Unit> g;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationExpandableTextView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isExpanded", "", "()Z", "setExpanded", "(Z)V", "fullText", "", "getFullText", "()Ljava/lang/String;", "setFullText", "(Ljava/lang/String;)V", "writeToParcel", "", "out", "flags", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public boolean a;
        public String b;

        public static final class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "source");
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "source");
            super(r4);
            String r0 = "";
            this.b = "";
            boolean r2 = true;
            if (r4.readInt() == 1) goto L6;
            r2 = false;
        L6:
            this.a = r2;
            String r5 = r4.readString();
            if (r5 == null) goto L10;
            r0 = r5;
        L10:
            this.b = r0;
        }

        public SavedState(Parcelable r1) {
            super(r1);
            this.b = "";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "out");
            super.writeToParcel(r2, r3);
            r2.writeInt(this.a ? 1 : 0);
            r2.writeString(this.b);
        }
    }

    public static final class a extends ClickableSpan {
        public final /* synthetic */ CreationExpandableTextView a;

        /* JADX INFO: renamed from: com.larus.community.impl.detail.prompt.CreationExpandableTextView$a$a, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnGlobalLayoutListenerC0019a implements ViewTreeObserver.OnGlobalLayoutListener {
            public final /* synthetic */ CreationExpandableTextView a;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Function0<Unit> r0 = this.a.g;
                if (r0 == null) goto L6;
                r0.invoke();
                return;
            }

            public ViewTreeObserverOnGlobalLayoutListenerC0019a(CreationExpandableTextView r1) {
                this.a = r1;
            }
        }

        public a(CreationExpandableTextView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [android.widget.TextView, com.larus.community.impl.detail.prompt.CreationExpandableTextView] */
        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a.setMaxLines(Integer.MAX_VALUE);
            CreationExpandableTextView r4 = this.a;
            CreationExpandableTextView.y(r4, r4.a, TextView.BufferType.NORMAL);
            ?? r5 = this.a;
            r5.d = true;
            r5.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0019a(this.a));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            super.updateDrawState(r2);
            r2.setColor(this.a.e);
            r2.setUnderlineText(false);
        }
    }

    public CreationExpandableTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationExpandableTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void x(CreationExpandableTextView r0) {
        setText$lambda$2(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        if (this.d == false) goto L26;
        super/*android.widget.TextView*/.setText(this.a, TextView.BufferType.NORMAL);
        this.f = true;
        return;
    L26:
        super/*android.widget.TextView*/.setText(this.a, TextView.BufferType.NORMAL);     // Catch: Exception -> L23
        setMaxLines(this.c);     // Catch: Exception -> L23
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Exception -> L23
        Layout r1 = getLayout();     // Catch: Exception -> L23
        if (r1 == null) goto L29;
        int r4 = getLineCount();     // Catch: Exception -> L23
        int r5 = this.c;     // Catch: Exception -> L23
        if (r4 > r5) goto L12;
        super/*android.widget.TextView*/.setText(this.a, TextView.BufferType.NORMAL);     // Catch: Exception -> L23
        this.f = true;     // Catch: Exception -> L23
        return;
    L12:
        int r6 = r5 - 1;     // Catch: Exception -> L23
        int r7 = r1.getLineEnd(r6);     // Catch: Exception -> L23
        r1.getLineVisibleEnd(r6);     // Catch: Exception -> L23
        int r8 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();     // Catch: Exception -> L23
        float r9 = getPaint().measureText(this.b);     // Catch: Exception -> L23
        float r10 = getPaint().measureText("...");     // Catch: Exception -> L23
        float r11 = r1.getLineWidth(r6);     // Catch: Exception -> L23
        String r2 = this.a.substring(r1.getLineStart(r6), r7);     // Catch: Exception -> L23
        int r12 = 0;
    L14:
        if (((r11 + r9) + r10) <= r8) goto L18;
        if (r12 >= r2.length()) goto L18;
        r12 = r12 + 1;     // Catch: Exception -> L23
        r11 = getPaint().measureText(r2.substring(0, r2.length() - r12));     // Catch: Exception -> L23
    L18:
        int r13 = (r7 - r12) - 3;     // Catch: Exception -> L23
        if (r13 > 0) goto L21;
        return;
    L21:
        String r0 = this.a.substring(0, r13) + "...";     // Catch: Exception -> L23
        SpannableString r3 = new SpannableString(r0 + this.b);     // Catch: Exception -> L23
        r3.setSpan(new a(this), r0.length(), r0.length() + this.b.length(), 33);     // Catch: Exception -> L23
        super/*android.widget.TextView*/.setText(r3, TextView.BufferType.SPANNABLE);     // Catch: Exception -> L23
        setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Exception -> L23
        this.f = true;     // Catch: Exception -> L23
        return;
    L29:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        super/*android.widget.TextView*/.setText(this.a, TextView.BufferType.NORMAL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super/*android.widget.TextView*/.onSaveInstanceState());
        r1.a = this.d;
        String r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r1.b = r0;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void setText$lambda$2(CreationExpandableTextView r2) {
        if (r2.getLineCount() <= r2.c) goto L5;
        r2.z();
        return;
    L5:
        r2.f = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super/*android.widget.TextView*/.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super/*android.widget.TextView*/.onRestoreInstanceState(r3.getSuperState());
        boolean r0 = r3.a;
        this.d = r0;
        this.a = r3.b;
        if (r0 == false) goto L9;
        setMaxLines(Integer.MAX_VALUE);
        setText(this.a, TextView.BufferType.NORMAL);
        return;
    L9:
        setMaxLines(this.c);
        post(new r(this));
    }

    public final void setExpandListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "expandAction");
        this.g = r2;
    }

    public final void setExpandText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "expandText");
        this.b = r2;
        if (this.d == true) goto L6;
        z();
        return;
    }

    public final void setExpandTextColor(int r1) {
        this.e = r1;
        if (this.d == true) goto L6;
        z();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaxCollapsedLines(int r2) {
        this.c = r2;
        if (this.d == true) goto L6;
        setMaxLines(r2);
        z();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r3, TextView.BufferType r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        String r0 = r3.toString();
        this.a = r0;
        this.f = false;
        if (this.d == false) goto L6;
        super/*android.widget.TextView*/.setText(r0, r4);
        return;
    L6:
        super/*android.widget.TextView*/.setText(r3, r4);
        post(new t(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationExpandableTextView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = "";
        this.b = r5.getString(2131906831);
        this.c = 3;
        this.e = r5.getResources().getColor(2131103143);
        if (r6 == null) goto L8;
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130970954, 2130970955, 2130970956}, 0, 0);
        this.c = r8.getInt(2, 3);
        String r0 = r8.getString(0);
        if (r0 != null) goto L7;
        r0 = " " + r5.getString(2131906831);
    L7:
        this.b = r0;
        this.e = r8.getColor(1, r5.getResources().getColor(2131103143));
        r8.recycle();
    L8:
        setMaxLines(this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void y(CreationExpandableTextView r0, CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.TextView*/.setText(r1, r2);
    }

    public /* synthetic */ CreationExpandableTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        return;
    L5:
        if (this.f == false) goto L7;
        return;
    L7:
        if (this.d == false) goto L9;
        return;
    L9:
        if (this.a.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L18;
        post(new s(this));
        return;
    L18:
        return;
    L11:
        r5 = false;
        goto L12
    }
}
