package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0002H7B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\rJ\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b$\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b%\u0010\"J\u0017\u0010'\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b'\u0010 J\u000f\u0010(\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b(\u0010\"J\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\rJ\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u000fJ\u0017\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010,¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b2\u0010\rJ\u000f\u00103\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b3\u0010\u001cJ\u0017\u00105\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b5\u0010 J\u000f\u00106\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b6\u0010\"J\u0015\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\rJ\r\u0010=\u001a\u00020\u0006¢\u0006\u0004\b=\u0010\u000fJ\u0015\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0010¢\u0006\u0004\b?\u0010\u0013J\u0015\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u0010¢\u0006\u0004\bA\u0010\u0013R\u0017\u0010G\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "getType", "()I", "", "enabled", "setEnabled", "(Z)V", "setInputType", "getInputType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "Landroid/view/View;", "getCustomStart", "()Landroid/view/View;", "", "label", "setLabel", "(Ljava/lang/CharSequence;)V", "getLabel", "()Ljava/lang/CharSequence;", MessageIndication.CONTENT_TYPE_TEXT, "setText", "getText", "hint", "setHint", "getHint", "lines", "setMaxLines", "getMaxLines", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setCustomEnd", "getCustomEnd", "tip", "setTip", "getTip", "Lcom/obric/oui/forms/h;", "limitStateChangeListener", "setLimitStateChangeListener", "(Lcom/obric/oui/forms/h;)V", "count", "setLimitCount", "getLimitCount", "auto", "setAutoChangeWithLimit", "isError", "setTextState", "Lcom/obric/oui/forms/OEditText;", "i", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "ErrorBackgroundSpan", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OInputLayout extends FrameLayout {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13255c;
    public int d;
    public final LinearLayout e;
    public final FrameLayout f;
    public final FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OTextView f13256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OEditText f13257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CharSequence f13258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f13260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f13261m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f13262n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f13264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f13265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OTextView f13266r;
    public final OTextView s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OTextView f13267t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13268u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f13269v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f13272y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13273z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$ErrorBackgroundSpan;", "Landroid/text/style/BackgroundColorSpan;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorBackgroundSpan extends BackgroundColorSpan {
    }

    @JvmOverloads
    public OInputLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static boolean c(int r5) {
        int r10 = r5 & 4095;
        if (r10 != 129) goto L5;
        boolean r11 = true;
    L7:
        if (r10 != 225) goto L9;
        boolean r12 = true;
    L11:
        if (r10 != 18) goto L13;
        boolean r13 = true;
    L14:
        if (r11 == true) goto L18;
        if (r12 == true) goto L18;
        if (r13 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L7
    }

    public void a(Editable r5) {
    }

    public int b(Editable r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.length();
    }

    public void d(boolean r5) {
        if (this.f13253a != 1) goto L5;
        return;
    L5:
        FrameLayout r10 = this.g;
        int r11 = 8;
        if (r10.getChildCount() == 0) goto L10;
        if (r5 == false) goto L9;
        r11 = 0;
    L9:
        r10.setVisibility(r11);
        return;
    L10:
        r10.setVisibility(8);
    }

    public final void e() {
        if (this.f13253a == 0) goto L5;
    L12:
        int r5 = 8;
    L13:
        this.f13260l.setVisibility(r5);
        return;
    L5:
        if (this.f13261m == false) goto L12;
        Editable r10 = this.f13257i.getText();
        if (r10 == null) goto L12;
        if (r10.length() == 0) goto L12;
        r5 = 0;
        goto L13
    }

    public final void f() {
        if (this.f13253a == 0) goto L5;
    L14:
        int r5 = 8;
    L15:
        this.f13262n.setVisibility(r5);
        return;
    L5:
        if (this.f13263o == false) goto L14;
        if (c(this.f13259k) == false) goto L14;
        Editable r10 = this.f13257i.getText();
        if (r10 == null) goto L14;
        if (r10.length() == 0) goto L14;
        r5 = 0;
        goto L15
    }

    public final void g() {
        boolean r5 = true;
        if (getMaxLines() != 1) goto L6;
        r5 = false;
    L6:
        int r10 = this.f13259k;
        if (r5 == true) goto L9;
    L11:
        int r11 = r10 ^ 131072;
    L12:
        OEditText r12 = this.f13257i;
        r12.setInputType(r11);
        r12.invalidate();
        return;
    L9:
        if (c(r10) == true) goto L11;
        r11 = r10 | 131072;
        goto L12
    }

    public final View getCustomEnd() {
        FrameLayout r5 = this.f13264p;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final View getCustomStart() {
        FrameLayout r5 = this.g;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f13257i.getEllipsize();
    }

    public final CharSequence getHint() {
        return this.f13257i.getHint();
    }

    public final int getInputType() {
        return this.f13259k;
    }

    public final CharSequence getLabel() {
        return this.f13256h.getText();
    }

    public final int getLimitCount() {
        return this.f13268u;
    }

    public final int getMaxLines() {
        return this.f13257i.getMaxLines();
    }

    public CharSequence getText() {
        return this.f13257i.getText();
    }

    public final CharSequence getTip() {
        return this.f13266r.getText();
    }

    public final int getType() {
        return this.f13253a;
    }

    public final OEditText getVInput() {
        return this.f13257i;
    }

    public final void h() {
        int r5 = this.f13268u;
        OTextView r10 = this.f13267t;
        OTextView r11 = this.s;
        OEditText r12 = this.f13257i;
        if (r5 <= 0) goto L5;
        StringBuilder r13 = new StringBuilder();
        Editable r14 = r12.getText();
        Intrinsics.checkNotNull(r14);
        r13.append(b(r14));
        r13.append('/');
        r13.append(this.f13268u);
        r11.setText(r13.toString());
        StringBuilder r15 = new StringBuilder();
        Editable r16 = r12.getText();
        Intrinsics.checkNotNull(r16);
        r15.append(b(r16));
        r15.append('/');
        r15.append(this.f13268u);
        r10.setText(r15.toString());
    L5:
        int r17 = 8;
        boolean r18 = false;
        if (this.f13253a == 0) goto L8;
    L10:
        int r19 = 8;
    L11:
        r11.setVisibility(r19);
        if (this.f13253a == 1) goto L14;
    L16:
        r10.setVisibility(r17);
        if (this.f13268u <= 0) goto L26;
        Editable r20 = r12.getText();
        if (r20 == null) goto L26;
        if (r20.length() == 0) goto L26;
        Editable r21 = r12.getText();
        Intrinsics.checkNotNull(r21);
        if (b(r21) <= this.f13268u) goto L26;
        r18 = true;
    L26:
        boolean r22 = this.f13272y;
        if (r18 == r22) goto L29;
        this.f13272y = r18;
        j();
        return;
    L29:
        if (r22 == false) goto L33;
        j();
        return;
    L33:
        return;
    L14:
        if (this.f13269v == false) goto L16;
        r17 = 0;
        goto L16
    L8:
        if (this.f13269v == false) goto L10;
        r19 = 0;
        goto L11
    }

    public final void i() {
        int r5 = this.f13253a;
        LinearLayout r10 = this.e;
        FrameLayout r11 = this.f;
        OTextView r12 = this.f13256h;
        OEditText r13 = this.f13257i;
        if (r5 == 0) goto L5;
        int r14 = com.lynx.tasm.utils.a.B(12, this);
        int r15 = com.lynx.tasm.utils.a.B(8, this);
        if (r11.getVisibility() != 0) goto L12;
        int r16 = com.lynx.tasm.utils.a.B(0, this);
    L13:
        r10.setPadding(r14, r15, 0, r16);
        r12.setPadding(0, 0, com.lynx.tasm.utils.a.B(12, this), 0);
        r13.setPadding(0, 0, com.lynx.tasm.utils.a.B(12, this), 0);
        r13.setScrollBarStyle(33554432);
        r11.setPadding(com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(6, this), com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(8, this));
        return;
    L12:
        r16 = com.lynx.tasm.utils.a.B(8, this);
        goto L13
    L5:
        if (r12.getVisibility() != 0) goto L7;
        int r17 = com.lynx.tasm.utils.a.C(this, 8.5d);
    L8:
        r10.setPadding(com.lynx.tasm.utils.a.B(12, this), r17, com.lynx.tasm.utils.a.B(8, this), r17);
        r12.setPadding(0, 0, 0, 0);
        r13.setPadding(0, 0, 0, 0);
        r13.setScrollBarStyle(0);
        int r18 = com.lynx.tasm.utils.a.B(5, this);
        r11.setPadding(com.lynx.tasm.utils.a.B(12, this), r18, com.lynx.tasm.utils.a.B(8, this), r18);
        return;
    L7:
        r17 = com.lynx.tasm.utils.a.B(13, this);
        goto L8
    }

    public final void j() {
        if (this.f13272y == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        setTextState(r5);
        return;
    L5:
        if (this.f13270w == false) goto L7;
        r5 = true;
        goto L8
    }

    public final void setAutoChangeWithLimit(boolean r5) {
        this.f13270w = r5;
        j();
    }

    public final void setCustomEnd(int r5) {
        FrameLayout r10 = this.f13264p;
        r10.removeAllViews();
        if (r5 == 0) goto L9;
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setCustomStart(int r5) {
        FrameLayout r10 = this.g;
        r10.removeAllViews();
        if (r5 == 0) goto L9;
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r5) {
        this.g.removeAllViews();
        if (r5 != 0) goto L5;
        setCustomStart(R$layout.o_input_custom_start_area_code);
        return;
    L5:
        d(false);
    }

    public final void setEllipsize(TextUtils.TruncateAt r5) {
        this.f13257i.setEllipsize(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator<View> r10 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setEnabled(r5);
        goto L4
    L6:
        this.f13257i.setEnabled(r5);
    }

    public final void setHint(CharSequence r5) {
        this.f13257i.setHint(r5);
    }

    public final void setInputType(int r5) {
        if ((r5 & 1) != 0) goto L12;
        if ((r5 & 2) != 0) goto L12;
        if ((r5 & 3) != 0) goto L12;
        if ((r5 & 4) != 0) goto L12;
        r5 = r5 | 1;
    L12:
        if (this.f13259k == r5) goto L14;
        this.f13259k = r5;
    L14:
        g();
        f();
        a(this.f13257i.getText());
    }

    public final void setLabel(CharSequence r5) {
        this.f13256h.setText(r5);
    }

    public void setLimitCount(int r5) {
        if (this.f13268u != r5) goto L5;
        return;
    L5:
        this.f13268u = r5;
        h();
        a(this.f13257i.getText());
    }

    public final void setLimitStateChangeListener(h r5) {
        Intrinsics.checkNotNullParameter(r5, "limitStateChangeListener");
    }

    public final void setMaxLines(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.d = r5;
        boolean r10 = true;
        if (r5 == 1) goto L8;
        r10 = false;
    L8:
        OEditText r11 = this.f13257i;
        r11.setSingleLine(r10);
        r11.setMaxLines(r5);
        g();
    }

    public final void setText(CharSequence r5) {
        OEditText r10 = this.f13257i;
        r10.setText(r5);
        a(r10.getText());
    }

    public final void setTextState(boolean r13) {
        if (this.f13271x == false) goto L5;
        return;
    L5:
        this.f13271x = true;
        OEditText r5 = this.f13257i;
        int r10 = r5.getSelectionStart();
        int r11 = r5.getSelectionEnd();
        Editable r12 = r5.getText();
        if (r12 == null) goto L35;
        int r14 = r12.length();     // Catch: Exception -> L10
        if (r13 == false) goto L12;
        int r15 = ContextCompat.getColor(getContext(), R$color.oui_functional_red_2);     // Catch: Exception -> L10
    L13:
        ErrorBackgroundSpan[] r16 = (ErrorBackgroundSpan[]) r12.getSpans(0, r14, ErrorBackgroundSpan.class);     // Catch: Exception -> L10
        int r17 = r16.length;     // Catch: Exception -> L10
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L19;
        ErrorBackgroundSpan r19 = r16[r18];     // Catch: Exception -> L10
        if (r19.getBackgroundColor() == r15) goto L20;
        r18 = r18 + 1;     // Catch: Exception -> L10
    L20:
        if (r19 != null) goto L22;
        r19 = new ErrorBackgroundSpan(r15);     // Catch: Exception -> L10
    L22:
        int r20 = r16.length;     // Catch: Exception -> L10
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L25;
        r12.removeSpan(r16[r21]);     // Catch: Exception -> L10
        r21 = r21 + 1;     // Catch: Exception -> L10
        goto L23
    L25:
        r12.setSpan(r19, 0, r14, 33);     // Catch: Exception -> L10
        if (r10 < 0) goto L31;
        if (r10 > r14) goto L31;
        if (r11 < 0) goto L31;
        if (r11 > r14) goto L31;
        r5.setSelection(r10, r11);     // Catch: Exception -> L10
    L31:
        r5.setSelection(r10, r14);     // Catch: Exception -> L10
        goto L35
    L19:
        r19 = null;
        goto L20
    L12:
        r15 = 0;
    L10:
        e = move-exception;
        Log.e("OInputLayout", Intrinsics.stringPlus("Error setTextState: ", e));
    L35:
        if (this.f13273z == r13) goto L41;
        this.f13273z = r13;
        if (r13 == false) goto L39;
        int r22 = R$drawable.o_input_cursor_red;
    L40:
        r5.setTextCursorDrawable(r22);
        goto L41
    L39:
        r22 = R$drawable.o_input_cursor_blue;
    L41:
        Resources r23 = getResources();
        if (r13 == false) goto L44;
        int r24 = R$color.oui_functional_red_6;
    L45:
        this.f13266r.setTextColor(r23.getColor(r24));
        Resources r25 = getResources();
        if (r13 == false) goto L48;
        int r26 = R$color.oui_functional_red_6;
    L49:
        this.s.setTextColor(r25.getColor(r26));
        Resources r27 = getResources();
        if (r13 == false) goto L52;
        int r110 = R$color.oui_functional_red_6;
    L53:
        this.f13267t.setTextColor(r27.getColor(r110));
        this.f13271x = false;
        return;
    L52:
        r110 = R$color.oui_basic_text_3b;
        goto L53
    L48:
        r26 = R$color.oui_basic_text_3b;
        goto L49
    L44:
        r24 = R$color.oui_basic_text_3b;
        goto L45
    }

    public final void setTip(CharSequence r5) {
        this.f13266r.setText(r5);
    }

    public void setType(int r5) {
        boolean r10 = true;
        if (r5 == 0) goto L6;
        if (r5 == 1) goto L6;
        return;
    L6:
        this.f13253a = r5;
        int r11 = this.f13254b;
        if (r11 != (-1)) goto L12;
        if (r5 != 0) goto L11;
        r11 = (int) com.lynx.tasm.utils.a.G(22.0f, this);
        goto L12
    L11:
        r11 = com.lynx.tasm.utils.a.B(120, this);
    L12:
        OEditText r12 = this.f13257i;
        r12.setMinimumHeight(r11);
        int r13 = this.f13255c;
        if (r13 != (-1)) goto L19;
        if (r5 != 0) goto L18;
        int r14 = 66;
    L17:
        r13 = com.lynx.tasm.utils.a.B(r14, this);
        goto L19
    L18:
        r14 = 240;
    L19:
        r12.setMaxHeight(r13);
        int r15 = this.d;
        if (r15 != (-1)) goto L25;
        if (r5 != 0) goto L24;
        r15 = 1;
        goto L25
    L24:
        r15 = 12;
    L25:
        if (r15 == 1) goto L28;
        r10 = false;
    L28:
        r12.setSingleLine(r10);
        r12.setMaxLines(r15);
        g();
        i();
        h();
        e();
        f();
    }

    @JvmOverloads
    public OInputLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OInputLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference failed for: r13v10, types: [com.obric.oui.forms.OInputLayout$initInput$1, java.lang.Object, kotlin.jvm.internal.Lambda] */
    @JvmOverloads
    public OInputLayout(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        this.f13254b = -1;
        this.f13255c = -1;
        this.d = -1;
        this.f13259k = 131073;
        this.f13268u = -1;
        View r16 = LayoutInflater.from(r13).inflate(R$layout.o_input_view_layout, this, true);
        if (r16 == null) goto L98;
        FrameLayout r17 = (FrameLayout) r16;
        LinearLayout r18 = (LinearLayout) findViewById(R$id.input_container);
        this.e = r18;
        LinearLayout r5 = (LinearLayout) findViewById(R$id.edit_container);
        FrameLayout r10 = (FrameLayout) findViewById(R$id.helper_container);
        this.f = r10;
        this.g = (FrameLayout) findViewById(R$id.custom_start_container);
        OTextView r11 = (OTextView) findViewById(R$id.label);
        this.f13256h = r11;
        OEditText r12 = (OEditText) findViewById(R$id.input);
        this.f13257i = r12;
        if (this.f13253a != 0) goto L7;
        int r19 = (int) com.lynx.tasm.utils.a.G(22.0f, this);
    L8:
        r12.setMinimumHeight(r19);
        if (this.f13253a != 0) goto L12;
        int r20 = 66;
    L13:
        r12.setMaxHeight(com.lynx.tasm.utils.a.B(r20, this));
        FrameLayout r21 = (FrameLayout) findViewById(R$id.custom_end_container);
        this.f13264p = r21;
        this.f13265q = findViewById(R$id.input_divider);
        this.f13260l = (ImageView) findViewById(R$id.clear);
        this.f13262n = (ImageView) findViewById(R$id.eyes);
        OTextView r22 = (OTextView) findViewById(R$id.tip);
        this.f13266r = r22;
        this.s = (OTextView) findViewById(R$id.limit_single);
        OTextView r23 = (OTextView) findViewById(R$id.limit_multi);
        this.f13267t = r23;
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r12.setFocusable(true);
        r12.setFocusableInTouchMode(true);
        if (r14 == null) goto L100;
        TypedArray r110 = getContext().getTheme().obtainStyledAttributes(r14, R$styleable.OInputLayout, r15, 0);
        setType(r110.getInt(R$styleable.OInputLayout_oinput_type, 0));
        if (r110.getBoolean(R$styleable.OInputLayout_oinput_showInputBackground, false) == false) goto L19;
        int r111 = getResources().getColor(R$color.oui_fill_list_item_card);
    L20:
        r18.setBackgroundColor(r111);
        this.f13254b = r110.getDimensionPixelSize(R$styleable.OInputLayout_oinput_minHeight, -1);
        this.f13255c = r110.getDimensionPixelSize(R$styleable.OInputLayout_oinput_maxHeight, -1);
        setCustomStart(r110.getResourceId(R$styleable.OInputLayout_oinput_customStart, 0));
        d(r110.getBoolean(R$styleable.OInputLayout_oinput_showCustomStart, false));
        setLabel(r110.getString(R$styleable.OInputLayout_oinput_label));
        boolean r112 = r110.getBoolean(R$styleable.OInputLayout_oinput_showLabel, false);
        CharSequence r113 = getLabel();
        int r24 = 8;
        if (r113 != null) goto L23;
    L29:
        r11.setVisibility(8);
    L30:
        i();
        setText(r110.getString(R$styleable.OInputLayout_oinput_text));
        setHint(r110.getString(R$styleable.OInputLayout_oinput_hint));
        this.f13258j = r110.getText(R$styleable.OInputLayout_android_digits);
        this.f13259k = r110.getInt(R$styleable.OInputLayout_android_inputType, this.f13259k);
        setMaxLines(r110.getInt(R$styleable.OInputLayout_android_maxLines, -1));
        if (r110.hasValue(R$styleable.OInputLayout_android_ellipsize) == false) goto L46;
        int r114 = r110.getInt(R$styleable.OInputLayout_android_ellipsize, 0);
        if (r114 != 1) goto L35;
        TextUtils.TruncateAt r115 = TextUtils.TruncateAt.START;
    L45:
        setEllipsize(r115);
        goto L46
    L35:
        if (r114 != 2) goto L37;
        r115 = TextUtils.TruncateAt.MIDDLE;
        goto L45
    L37:
        if (r114 != 3) goto L39;
        r115 = TextUtils.TruncateAt.END;
        goto L45
    L39:
        if (r114 == 4) goto L41;
        r115 = null;
        goto L45
    L41:
        r115 = TextUtils.TruncateAt.MARQUEE;
    L46:
        setCustomEnd(r110.getResourceId(R$styleable.OInputLayout_oinput_customEnd, 0));
        boolean r116 = r110.getBoolean(R$styleable.OInputLayout_oinput_showCustomEnd, false);
        if (this.f13253a != 1) goto L50;
    L56:
        this.f13261m = r110.getBoolean(R$styleable.OInputLayout_oinput_showClear, false);
        this.f13263o = r110.getBoolean(R$styleable.OInputLayout_oinput_showEyes, false);
        setTip(r110.getString(R$styleable.OInputLayout_oinput_tip));
        boolean r117 = r110.getBoolean(R$styleable.OInputLayout_oinput_showTip, false);
        CharSequence r118 = getTip();
        if (r118 != null) goto L59;
    L65:
        r22.setVisibility(8);
    L67:
        if (r22.getVisibility() != 0) goto L70;
    L71:
        int r119 = 0;
    L73:
        r10.setVisibility(r119);
        setLimitCount(r110.getInt(R$styleable.OInputLayout_oinput_limitCount, -1));
        boolean r120 = r110.getBoolean(R$styleable.OInputLayout_oinput_showLimit, false);
        if (this.f13269v == r120) goto L83;
        this.f13269v = r120;
        h();
        if (r22.getVisibility() != 0) goto L80;
    L81:
        r24 = 0;
    L82:
        r10.setVisibility(r24);
        goto L83
    L80:
        if (r23.getVisibility() != 0) goto L82;
    L83:
        setAutoChangeWithLimit(r110.getBoolean(R$styleable.OInputLayout_oinput_autoChangeWithLimit, false));
        goto L100
    L70:
        if (r23.getVisibility() == 0) goto L71;
        r119 = 8;
        goto L73
    L59:
        if (r118.length() == 0) goto L65;
        if (r117 == false) goto L63;
        int r121 = 0;
    L64:
        r22.setVisibility(r121);
        goto L67
    L63:
        r121 = 8;
        goto L64
    L50:
        if (r21.getChildCount() == 0) goto L55;
        if (r116 == false) goto L53;
        int r122 = 0;
    L54:
        r21.setVisibility(r122);
        goto L56
    L53:
        r122 = 8;
        goto L54
    L55:
        r21.setVisibility(8);
        goto L56
    L23:
        if (r113.length() == 0) goto L29;
        if (r112 == false) goto L27;
        int r123 = 0;
    L28:
        r11.setVisibility(r123);
        goto L30
    L27:
        r123 = 8;
        goto L28
    L19:
        r111 = 0;
    L100:
        Method r124 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", null);     // Catch: Exception -> L99
        r124.setAccessible(true);     // Catch: Exception -> L99
        r124.invoke(r12, null);     // Catch: Exception -> L99
    L85:
        CharSequence r125 = this.f13258j;
        if (r125 == null) goto L92;
        r12.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r125)));
        int r126 = this.f13259k;
        if (r126 != 0) goto L91;
        r126 = 1;
    L91:
        this.f13259k = r126;
    L92:
        int r127 = this.f13259k;
        if (r127 == 0) goto L95;
        setInputType(r127);
    L95:
        ?? r128 = new OInputLayout$initInput$1(this);
        Intrinsics.checkNotNullParameter(r128, "action");
        r12.f13245a.f13332a = r128;
        Function4<CharSequence, Integer, Integer, Integer, Unit> r129 = new OInputLayout$initInput$2(this);
        Intrinsics.checkNotNullParameter(r129, "action");
        c r130 = r12.f13247c;
        r130.f13330b = r129;
        Function1<Editable, Unit> r131 = new OInputLayout$initInput$3(this);
        Intrinsics.checkNotNullParameter(r131, "action");
        r130.f13331c = r131;
        final int r132 = 0;
        this.f13260l.setOnClickListener(new g(this, r132));
        final int r133 = 1;
        this.f13262n.setOnClickListener(new g(this, r133));
        final int r134 = 2;
        this.e.setOnClickListener(new g(this, r134));
        LinearLayout r135 = this.e;
        r135.setClipToOutline(true);
        r135.setOutlineProvider(new br.c(this, 5));
        r135.invalidateOutline();
        return;
    L12:
        r20 = 240;
        goto L13
    L7:
        r19 = com.lynx.tasm.utils.a.B(120, this);
        goto L8
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
