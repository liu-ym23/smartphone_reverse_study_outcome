package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0006R#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/effect/sticker/ui/j;", "listener", "", "setOnChangeListener", "", "hint", "setSearchHint", "Landroid/view/View$OnKeyListener;", "setEditTextOnKeyListener", "getContent", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getEditText", "()Landroid/widget/EditText;", "editText", "Landroid/widget/ImageView;", "b", "getBtnClear", "()Landroid/widget/ImageView;", "btnClear", "Landroid/view/View;", "c", "getEditCover", "()Landroid/view/View;", "editCover", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchBox extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public j d;

    public StickerSearchBox(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerSearchBox(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ImageView getBtnClear() {
        return (ImageView) this.b.getValue();
    }

    private final View getEditCover() {
        return (View) this.c.getValue();
    }

    private final EditText getEditText() {
        return (EditText) this.a.getValue();
    }

    public final void Y5() {
        j r0 = this.d;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void V5() {
        getEditCover().setVisibility(0);
    }

    public final void Z5() {
        getEditText().setText(getEditText().getText());
        getEditText().setSelection(getEditText().getText().length());
    }

    public final String getContent() {
        return getEditText().getText().toString();
    }

    public static final /* synthetic */ ImageView R5(StickerSearchBox r0) {
        return r0.getBtnClear();
    }

    public static final /* synthetic */ EditText S5(StickerSearchBox r0) {
        return r0.getEditText();
    }

    public final void T5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        getEditText().setText(r2);
        getEditText().setSelection(getEditText().getText().length());
    }

    public final void U5(boolean r2) {
        getEditText().setCursorVisible(r2);
    }

    public final void setEditTextOnKeyListener(View.OnKeyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getEditText().setOnKeyListener(r2);
    }

    public final void setOnChangeListener(j r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    public final void setSearchHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        getEditText().setHint(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerSearchBox(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new StickerSearchBox$editText$2(this));
        this.b = LazyKt.lazy(new StickerSearchBox$btnClear$2(this));
        this.c = LazyKt.lazy(new StickerSearchBox$editCover$2(this));
        ViewGroup.inflate(r2, 2131565937, this);
        getEditText().addTextChangedListener(new p(this));
        getEditText().setOnClickListener(new q(this));
        getEditCover().setOnClickListener(new r(this));
        getEditText().setOnFocusChangeListener(new s(this));
        getBtnClear().setOnClickListener(new t(this));
    }

    public /* synthetic */ StickerSearchBox(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
