package com.obric.oui.selection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import da.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.d;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006R(\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "str", "", "setText", "", TypedValues.Custom.S_COLOR, "setTextColor", "Lcom/obric/oui/text/OTextView;", "l", "Lcom/obric/oui/text/OTextView;", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", "getTvTitle$annotations", "()V", "tvTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OActionSheetButton extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OTextView f7348l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public OActionSheetButton(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
        c();
    }

    @SuppressLint({"CustomViewStyleable"})
    private final void c() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(h.o_listitem_button, this);
        ViewParent r10 = (ViewGroup) findViewById(f.ll_root);
        c r11 = c.f8520a;
        if (r10 != null) goto L6;
    L4:
        r10 = null;
    L7:
        o9.a r12 = (o9.a) r10;
        if (r12 == null) goto L10;
        r12.setChangeAlphaWhenPress(false);
    L10:
        View r13 = findViewById(f.tv_content_title);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.tv_content_title)");
        this.f7348l = (OTextView) r13;
        setRadius((int) getResources().getDimension(d.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r10 instanceof o9.a) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public final OTextView getTvTitle() {
        OTextView r10 = this.f7348l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
    L5:
        return r10;
    }

    public final void setText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "str");
        OTextView r11 = this.f7348l;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
    L5:
        r11.setText(r10);
    }

    public final void setTextColor(@ColorInt int r10) {
        OTextView r11 = this.f7348l;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
    L5:
        r11.setTextColor(r10);
    }

    public final void setTvTitle(OTextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7348l = r10;
    }
}
