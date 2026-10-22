package com.ss.android.lark.keyboard.edittext2.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.content.ContextCompat;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001f\u0010\u001c\u001a\u00020\r2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0002J'\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0+H\u0014J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u00020\u000fH\u0014J\u0018\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J*\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\u0010\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\rH\u0002J\u0016\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006F"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionAfterTextChanged", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "blockReselect", "", "useAnchorFilter", "getUseAnchorFilter", "()Z", "setUseAnchorFilter", "(Z)V", "setKeyListener", "keyListener", "Landroid/text/method/KeyListener;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "setFilters", "filters", "", "Landroid/text/InputFilter;", "([Landroid/text/InputFilter;)V", "setInputType", "type", "decorKeyListener", "decorInputConnection", "inputConnection", "decorFilters", "([Landroid/text/InputFilter;)[Landroid/text/InputFilter;", "updateKeyListener", "updateFilters", "prepareInputFilters", "", "onTextContextMenuItem", "id", "interceptContextMenuItem", "getClipBoardManager", "Landroid/content/ClipboardManager;", "beforeTextCopy", "prepareClipDataBeforeCopy", "Landroid/content/ClipData;", "beforeTextPaste", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "resolveAttachedEditSpanHolderIfNeed", "changedSequence", "Landroid/text/Spanned;", "setupTextWatcherSpanNotification", "setParseAnchorEnable", "parseUrl", "showLinkIfNotParseUrl", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class RichTextFunctionEditText extends FunctionEditText {
    public final LinkedList<Function0<Unit>> c;
    public boolean d;
    public boolean e;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ RichTextFunctionEditText a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(RichTextFunctionEditText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
            Function0<Unit> r2 = this.a.c.pollLast();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    static {
    }

    public RichTextFunctionEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RichTextFunctionEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ClipboardManager getClipBoardManager() {
        return (ClipboardManager) ContextCompat.getSystemService(getContext(), ClipboardManager.class);
    }

    public boolean f() {
        return RichTextCopyUtils.f(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        setFilters(super/*android.widget.EditText*/.getFilters());
    }

    public final boolean getUseAnchorFilter() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean e(int r5) {
        RichText r0 = ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).i(getSelectionStart(), getSelectionEnd());
        RichTextCopyUtils.e(r0.getInnerText(), r0);
        ClipData r1 = ClipData.newPlainText("RichTextFunctionEditText", RichTextCopyUtils.a(r0.getInnerText()));
        super.onTextContextMenuItem(r5);
        ClipboardManager r6 = getClipBoardManager();
        if (r6 != null) goto L12;
        return false;
    L12:
        qf7.a r2 = qf7.a.a;     // Catch: SensitiveAPIException -> L8
        Token r3 = RichTextCopyUtils.a;     // Catch: SensitiveAPIException -> L8
        r2.a(r6, r1, RichTextCopyUtils.a);     // Catch: SensitiveAPIException -> L8
        return true;
    L8:
        e = move-exception;
        Log.e("RichTextFunctionEditText", "beforeTextCopy: set primary clip failed: " + e.getMessage());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.base.FunctionEditText
    public final InputConnection onCreateInputConnection(EditorInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "outAttrs");
        InputConnection r4 = super.onCreateInputConnection(r3);
        m r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof m) == false) goto L8;
        r0 = (m) r4;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return new m(this, r4);
    }

    public final boolean onTextContextMenuItem(int r3) {
        switch(r3) {
            case 16908320: goto L6;
            case 16908321: goto L6;
            case 16908322: goto L5;
            default: goto L4;
        };
    L4:
        boolean r1 = false;
    L7:
        if (r1 == false) goto L9;
    L10:
        return true;
    L9:
        if (super.onTextContextMenuItem(r3) == true) goto L10;
        return false;
    L5:
        r1 = f();
        goto L7
    L6:
        r1 = e(r3);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFilters(InputFilter[] r7) {
        if (r7 != null) goto L8;
        ArrayList r8 = new ArrayList();
        r8.add(new q());
        if (this.e == false) goto L7;
        r8.add(new com.ss.android.lark.keyboard.edittext2.widget.a(this));
    L7:
        InputFilter[] r9 = (InputFilter[]) r8.toArray(new InputFilter[0]);
    L18:
        super/*android.widget.EditText*/.setFilters(r9);
        return;
    L8:
        ArrayList r1 = new ArrayList();
        int r2 = r7.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        InputFilter r4 = r7[r3];
        if ((!(r4 instanceof d)) == false) goto L13;
        r1.add(r4);
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        List r10 = CollectionsKt.toMutableList(r1);
        ArrayList r5 = new ArrayList();
        r5.add(new q());
        if (this.e == false) goto L17;
        r5.add(new com.ss.android.lark.keyboard.edittext2.widget.a(this));
    L17:
        r10.addAll(0, r5);
        r9 = (InputFilter[]) r10.toArray(new InputFilter[0]);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInputType(int r1) {
        super/*android.widget.EditText*/.setInputType(r1);
        setKeyListener(super/*android.widget.EditText*/.getKeyListener());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setKeyListener(KeyListener r3) {
        n r0 = null;
        if (r3 != null) goto L6;
    L11:
        super/*android.widget.EditText*/.setKeyListener(r0);
        return;
    L6:
        if ((r3 instanceof n) == false) goto L8;
        r0 = (n) r3;
    L8:
        if (r0 != null) goto L11;
        r0 = new n(r3);
        goto L11
    }

    public final void setUseAnchorFilter(boolean r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSelectionChanged(int r10, int r11) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        h r0 = h.a;
        Intrinsics.checkNotNullParameter(this, "editText");
        Editable r1 = getEditableText();
        Pair r2 = TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r11));
        if (r10 < 0) goto L16;
        if (r11 < 0) goto L16;
        Intrinsics.checkNotNull(r1);
        com.ss.android.lark.keyboard.edittext2.span.k[] r3 = (com.ss.android.lark.keyboard.edittext2.span.k[]) r1.getSpans(0, r1.length(), com.ss.android.lark.keyboard.edittext2.span.k.class);
        com.ss.android.lark.keyboard.edittext2.span.k.a r4 = new com.ss.android.lark.keyboard.edittext2.span.k.a(r10, r11);
        int r5 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        com.ss.android.lark.keyboard.edittext2.span.k.a r7 = r3[r6].e(r4.a, r4.b, r1);
        if (r7 == null) goto L14;
        r4 = r7;
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        r2 = TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r11));
    L16:
        int r8 = ((Number) r2.component1()).intValue();
        int r9 = ((Number) r2.component2()).intValue();
        this.d = false;
        if (r8 != r10) goto L19;
        if (r9 != r11) goto L19;
    L20:
        super/*android.widget.EditText*/.onSelectionChanged(r8, r9);
        return;
    L19:
        Log.d("RichTextFunctionEditText", "onSelectionChanged: selection updated");
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RichTextFunctionEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new LinkedList();
        this.e = true;
        setKeyListener(super/*android.widget.EditText*/.getKeyListener());
        g();
        addTextChangedListener(new k());
        addTextChangedListener(new l());
        addTextChangedListener(new j(this));
        addTextChangedListener(new b(this));
        setMovementMethod(new o());
    }

    public /* synthetic */ RichTextFunctionEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super/*android.widget.EditText*/.onTextChanged(r1, r2, r3, r4);
        if (r1 != null) goto L5;
        return;
    L5:
        CharSequence r5 = r1.subSequence(r2, r4 + r2);
        if ((r5 instanceof Spanned) == false) goto L8;
        Spanned r6 = (Spanned) r5;
    L9:
        if (r6 == null) goto L15;
        final Spanned r7 = (Spanned) r5;
        LinkedList<Function0<Unit>> r8 = this.c;
        if (r8 == null) goto L16;
        r8.offer(new RichTextFunctionEditText$resolveAttachedEditSpanHolderIfNeed$1(r7, this));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r6 = null;
        goto L9
    }
}
