package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.MmStringCheckUtil;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\u0018\u0000 D2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J(\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0015J\u001a\u0010-\u001a\u00020\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fJ$\u0010/\u001a\u00020\u00002\u001c\u0010.\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u0012J\u0014\u00100\u001a\u00020\u00002\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017J\"\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00132\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u000fJ\u0010\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u000106J\b\u00107\u001a\u00020\u0010H\u0002J\u0006\u00108\u001a\u00020\u0010J\u001a\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\"\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u0006\u0010B\u001a\u00020\u0010J\u0006\u0010C\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006F"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView;", "Lcom/suite/lark/emm/design/edittext/SCAppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastText", "", "coveredTextView", "Landroid/view/View;", "editDownCallback", "Lkotlin/Function1;", "", "editErrorCallback", "Lkotlin/Function2;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/MmStringCheckUtil$StringCheckoutErrorType;", "editDownCondition", "", "sizeChangeCallBack", "Lkotlin/Function0;", "needInsertSpace", "editErrorType", "keyboardShownAfterFocus", "pendingKeyboardHideByBack", "lastShowKeyboardUptimeMs", "", "textWatcher", "com/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView$textWatcher$1", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView$textWatcher$1;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onSizeChanged", "w", "h", "oldw", "oldh", "coverView", "view", "need", "onEditDown", "callback", "onEditError", "onSizeChange", "editDownPredicate", "error", "predicate", "onCoveredViewClick", "text", "", "showKeyboard", "hideKeyboard", "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onDestroy", "onKeyboardHide", "Companion", "EnterAndLengthInputFilter", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmCoveredEditTextView extends SCAppCompatEditText {
    public static final /* synthetic */ int j = 0;
    public View b;
    public Function1<? super String, Unit> c;
    public Function2<? super String, ? super MmStringCheckUtil.StringCheckoutErrorType, Unit> d;
    public boolean e;
    public final MmStringCheckUtil.StringCheckoutErrorType f;
    public boolean g;
    public boolean h;
    public long i;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r18, int r19, int r20, Spanned r21, int r22, int r23) {
            int r4 = bwb.b.a;
            MmUiLogScene r5 = MmUiLogScene.FOUNDATION;
            bwb.b.b(r5, "filter", "source=" + r18 + ", start=" + r19 + ", end=" + r20 + ", dest=" + r21 + ", dstart=" + r22 + ", dend=" + r23, null, 8);
            String r6 = "";
            if (r18 == null) goto L8;
            CharSequence r0 = r18.subSequence(r19, r20);
            if (r0 == null) goto L8;
            String r1 = r0.toString();
            if (r1 == null) goto L8;
        L9:
            if (r21 == null) goto L15;
            String r2 = r21.toString();
            if (r2 == null) goto L15;
            r6 = r2;
        L15:
            if (StringsKt.contains$default(r1, '\n', false, 2, null) == false) goto L17;
            bwb.b.b(r5, "filter", "replace enter", null, 8);
            String r3 = StringsKt.replace$default(r1, "\n", "", false, 4, null);
        L18:
            int r7 = RangesKt.coerceAtLeast(50 - RangesKt.coerceAtLeast(r6.length() - RangesKt.coerceAtLeast(r23 - r22, 0), 0), 0);
            if (r3.length() <= r7) goto L23;
            bwb.b.b(r5, "filter", "limit length", null, 8);
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a(2131892849);
            return r3.subSequence(0, r7);
        L23:
            if (Intrinsics.areEqual(r3, r1) == false) goto L26;
            return null;
        L26:
            return r3;
        L17:
            r3 = r1;
        L8:
            r1 = "";
            goto L9
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ MmCoveredEditTextView a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(MmCoveredEditTextView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r9) {
            if (this.a.e == true) goto L6;
            return;
        L6:
            if (r9 == null) goto L8;
            String r10 = r9.toString();
        L10:
            if (r10 != null) goto L13;
            int r11 = bwb.b.a;
            bwb.b.b(MmUiLogScene.FOUNDATION, "afterTextChanged", "data is null", null, 8);
            return;
        L13:
            int r3 = bwb.b.a;
            MmUiLogScene r4 = MmUiLogScene.FOUNDATION;
            bwb.b.b(r4, "afterTextChanged", "data=".concat(r10), null, 8);
            boolean r5 = false;
            if (r10.length() != 0) goto L16;
            boolean r6 = true;
        L17:
            if (r6 == false) goto L20;
            this.a.setText(" ");
            return;
        L20:
            if (StringsKt.last(r10) != ' ') goto L28;
            String r12 = StringsKt.trim(r10).toString();
            if (r12.length() <= 0) goto L24;
            r5 = true;
        L24:
            if (r5 == false) goto L29;
            bwb.b.b(r4, "afterTextChanged", "delete space", null, 8);
            this.a.setText(r12);
            this.a.setSelection(r12.length());
            return;
        L29:
            return;
        L28:
            return;
        L16:
            r6 = false;
            goto L17
        L8:
            r10 = null;
            goto L10
        }
    }

    static {
    }

    public MmCoveredEditTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmCoveredEditTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final InputConnection onCreateInputConnection(EditorInfo r5) {
        InputConnection r0 = super/*androidx.appcompat.widget.AppCompatEditText*/.onCreateInputConnection(r5);
        if (r5 == null) goto L10;
        int r1 = r5.imeOptions;
        int r2 = r1 & 255;
        if ((r2 & 4) == 0) goto L7;
        r5.imeOptions = (r1 ^ r2) | 4;
    L7:
        int r3 = r5.imeOptions;
        if ((1073741824 & r3) == 0) goto L10;
        r5.imeOptions = r3 & (-1073741825);
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyPreIme(int r4, KeyEvent r5) {
        if (r4 != 4) goto L13;
        boolean r0 = false;
        if (r5 != null) goto L7;
    L9:
        if (r0 == false) goto L13;
        this.h = true;
        return true;
    L7:
        if (r5.getAction() != 1) goto L9;
        r0 = true;
    L13:
        return super/*android.widget.EditText*/.onKeyPreIme(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmCoveredEditTextView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.f = MmStringCheckUtil.StringCheckoutErrorType.NOT_DEFINE;
        c r6 = new c(this);
        wvb.g r7 = new wvb.g();
        View r0 = getRootView();
        Intrinsics.checkNotNullParameter(r0, "rootView");
        ViewCompat.setOnApplyWindowInsetsListener(r0, new wvb.f(r7));
        Function1<Integer, Unit> r1 = new AnonymousClass1(r3, this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r7.a.a = r1;
        addTextChangedListener(r6);
        setFilters(new b[]{new b()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFocusChanged(boolean r4, int r5, Rect r6) {
        super/*android.widget.EditText*/.onFocusChanged(r4, r5, r6);
        if (r4 == true) goto L20;
        int r7 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onFocusChanged", "lost focus", null, 8);
        boolean r8 = false;
        this.g = false;
        this.h = false;
        String r9 = String.valueOf(getText());
        MmStringCheckUtil r10 = new MmStringCheckUtil(r9);
        if (r9.length() != 0) goto L7;
        r8 = true;
    L7:
        if (r8 == false) goto L9;
        r10.a = true;
        r10.b = MmStringCheckUtil.StringCheckoutErrorType.NULL_OR_EMPTY;
    L9:
        MmStringCheckUtil.StringCheckoutErrorType r11 = this.f;
        Function1<String, Boolean> r0 = new C02161(this);
        Intrinsics.checkNotNullParameter(r0, "predict");
        if (((Boolean) r0.invoke(r9)).booleanValue() == false) goto L12;
        r10.a = true;
        r10.b = r11;
    L12:
        Function1<String, Unit> r12 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r12, "callBack");
        if (r10.a == false) goto L15;
        lvb.a.b("StringCheckUtil", "checkoutStringNotNull failed, sourceStr=".concat(r9));
    L16:
        Function2<String, MmStringCheckUtil.StringCheckoutErrorType, Unit> r13 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r13, "callBack");
        if (r10.a == false) goto L21;
        r13.invoke(r9, r10.b);
        return;
    L21:
        return;
    L15:
        r12.invoke(r9);
        goto L16
    }

    public /* synthetic */ MmCoveredEditTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = R.attr.editTextStyle;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super/*android.widget.EditText*/.onSizeChanged(r2, r3, r4, r5);
        if (r5 == r3) goto L6;
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onSizeChanged", "on size change, oldH=" + r5 + ", newH=" + r3, null, 8);
        return;
    }
}
