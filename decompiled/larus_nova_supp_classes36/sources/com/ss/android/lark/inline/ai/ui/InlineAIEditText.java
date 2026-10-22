package com.ss.android.lark.inline.ai.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.ui.richtext.InlineAiRichTextMovementMethod;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u001b\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/InlineAIEditText;", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "editTextFunction", "Lcom/ss/android/lark/inline/ai/ui/view/IEditTextFunction;", "actionOnTouchFinish", "Lkotlin/Function0;", "", "setEditTextFunction", "onSelectionChanged", "start", "end", "getEditTextContent", "", "onFocusChanged", "focused", "", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setupAtEditor", "doOnTouchFinish", "action", "doOnTouchFinish$inline_ai_impl_release", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineAIEditText extends RichTextFunctionEditText {
    public com.ss.android.lark.inline.ai.ui.view.b f;
    public Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public InlineAIEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InlineAIEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object getEditTextContent() {
        com.ss.android.lark.inline.ai.ui.view.b r0 = this.f;
        if (r0 == null) goto L7;
        Object r1 = r0.t(this);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return String.valueOf(getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Log.d("InlineAIEditText", "onTouchEvent: called");
        boolean r4 = super/*android.widget.EditText*/.onTouchEvent(r3);
        this.g.invoke();
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEditTextFunction(com.ss.android.lark.inline.ai.ui.view.b r2) {
        Intrinsics.checkNotNullParameter(r2, "editTextFunction");
        this.f = r2;
        addTextChangedListener(r2);
        setFilters(getFilters());
        setKeyListener(getKeyListener());
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final void onSelectionChanged(int r3, int r4) {
        super.onSelectionChanged(r3, r4);
        Log.i("InlineAIEditText", "onSelectionChanged " + r3 + ", " + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineAIEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (new bmb.a().b.isCurrentEnable("ccm.knowledge.inline_ai_mention_all_enable") == false) goto L5;
        com.ss.android.lark.keyboard.edittext2.edittors.a.C0137a r5 = com.ss.android.lark.keyboard.edittext2.edittors.a.e;
        q(r5);
        setMovementMethod(new InlineAiRichTextMovementMethod(this));
        ArrayList r6 = new ArrayList();
        r6.add(new com.ss.android.lark.inline.ai.ui.richtext.c());
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(r5)).W(r6);
    L5:
        this.g = InlineAIEditText$actionOnTouchFinish$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFocusChanged(boolean r1, int r2, Rect r3) {
        super/*android.widget.EditText*/.onFocusChanged(r1, r2, r3);
        Log.i("InlineAIEditText", "onFocusChanged " + r1);
        com.ss.android.lark.inline.ai.ui.view.b r4 = this.f;
        if (r4 == null) goto L6;
        r4.B(this, r1);
        return;
    }

    public /* synthetic */ InlineAIEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
