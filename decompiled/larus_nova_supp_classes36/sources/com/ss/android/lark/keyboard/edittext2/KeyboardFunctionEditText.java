package com.ss.android.lark.keyboard.edittext2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.compat.c;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rcc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J$\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u00103\u001a\u00020\u00192\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0016J\u001b\u00105\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020$2\u0006\u0010&\u001a\u000209H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSizeChangeListener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "selectionChangeListener", "Lcom/ss/android/lark/keyboard/edittext2/compat/OnSelectionChangedListener;", "keyPreIMeHandler", "Lcom/ss/android/lark/keyboard/edittext2/compat/OnKeyPreImeHandler;", "multiOnKeyListener", "", "Landroid/view/View$OnKeyListener;", "getMultiOnKeyListener", "()Ljava/util/List;", "setMultiOnKeyListener", "(Ljava/util/List;)V", "actionOnTouchFinish", "Lkotlin/Function0;", "", "setOnKeyPreImeHandler", "keyPreImeHandler", "setSelectionChangedListener", "listener", "setOnSizeChangeListener", "addOnKeyListener", "onKeyListener", "index", "removeOnKeyListener", "onKeyPreIme", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSelectionChanged", "selStart", "selEnd", "onSizeChanged", "w", "h", "oldw", "oldh", "handleKey", "v", "Landroid/view/View;", "setOnKeyListener", "l", "doOnTouchFinish", "action", "doOnTouchFinish$keyboard_base_release", "onTouchEvent", "Landroid/view/MotionEvent;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class KeyboardFunctionEditText extends RichTextFunctionEditText {
    public d f;
    public com.ss.android.lark.keyboard.edittext2.compat.d g;
    public c h;
    public List<View.OnKeyListener> i;
    public Function0<Unit> j;

    public static final class b {
    }

    static {
    }

    public KeyboardFunctionEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KeyboardFunctionEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public void setOnKeyListener(View.OnKeyListener r1) {
    }

    public final List<View.OnKeyListener> getMultiOnKeyListener() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        boolean r3 = super/*android.widget.EditText*/.onTouchEvent(r2);
        this.j.invoke();
        return r3;
    }

    public final void setMultiOnKeyListener(List<View.OnKeyListener> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setOnKeyPreImeHandler(c r1) {
        this.h = r1;
    }

    public final void setOnSizeChangeListener(d r2) {
        Intrinsics.checkNotNullParameter(r2, "onSizeChangeListener");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSelectionChangedListener(com.ss.android.lark.keyboard.edittext2.compat.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.g = r3;
        r3.C(getSelectionStart(), getSelectionEnd());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyPreIme(int r4, KeyEvent r5) {
        c r0 = this.h;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        return true;
    L11:
        if (r4 != 66) goto L20;
        if (r5 != null) goto L14;
    L16:
        if (r1 == false) goto L20;
        dispatchKeyEvent(r5);
        return true;
    L14:
        if (r5.isShiftPressed() != true) goto L16;
        r1 = true;
    L20:
        return super/*android.widget.EditText*/.onKeyPreIme(r4, r5);
    L5:
        if (r0.a(r4, r5) != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final void onSelectionChanged(int r2, int r3) {
        super.onSelectionChanged(r2, r3);
        com.ss.android.lark.keyboard.edittext2.compat.d r4 = this.g;
        if (r4 == null) goto L6;
        r4.C(getSelectionStart(), getSelectionEnd());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeyboardFunctionEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = new ArrayList();
        this.j = KeyboardFunctionEditText$actionOnTouchFinish$1.INSTANCE;
        super/*android.widget.EditText*/.setOnKeyListener(new a(this));
    }

    public /* synthetic */ KeyboardFunctionEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.EditText*/.onSizeChanged(r1, r2, r3, r4);
        d r5 = this.f;
        if (r5 == null) goto L6;
        r5.a(r1, r3, r4);
        return;
    }
}
