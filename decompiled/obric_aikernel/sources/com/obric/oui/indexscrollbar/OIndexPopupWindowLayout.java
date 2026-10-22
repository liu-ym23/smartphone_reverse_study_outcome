package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowLayout;", "Landroid/widget/LinearLayout;", "Landroid/widget/PopupWindow;", "c", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "popupWindow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OIndexPopupWindowLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PopupWindow f6707c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f6709h;

    public OIndexPopupWindowLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        View r12 = LayoutInflater.from(r10).inflate(h.o_index_scrollbar_popup_circle, null);
        this.f6709h = (ImageView) r12.findViewById(f.popup_img);
        this.f6708g = (TextView) r12.findViewById(f.popup_text);
        this.f6707c = new PopupWindow(r12, -2, -2, false);
    }

    public /* synthetic */ OIndexPopupWindowLayout(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void a() {
        PopupWindow r10 = this.f6707c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isShowing() != true) goto L11;
        PopupWindow r11 = this.f6707c;
        if (r11 == null) goto L12;
        r11.dismiss();
        return;
    L12:
        return;
    }

    public final void b(String r10, Bitmap r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "letter");
        if (r11 != null) goto L13;
        TextView r14 = this.f6708g;
        if (r14 == null) goto L7;
        r14.setText(r10);
    L7:
        ImageView r15 = this.f6709h;
        if (r15 == null) goto L10;
        r15.setVisibility(8);
    L10:
        TextView r16 = this.f6708g;
        if (r16 == null) goto L22;
        r16.setVisibility(0);
    L22:
        PopupWindow r17 = this.f6707c;
        if (r17 != null) goto L25;
    L29:
        PopupWindow r18 = this.f6707c;
        if (r18 == null) goto L35;
        r18.update(r12, r13, -2, -2);
        return;
    L35:
        return;
    L25:
        if (r17.isShowing() == true) goto L29;
        PopupWindow r19 = this.f6707c;
        if (r19 == null) goto L33;
        r19.showAtLocation(this, 0, r12, r13);
        return;
    L33:
        return;
    L13:
        TextView r20 = this.f6708g;
        if (r20 == null) goto L16;
        r20.setVisibility(8);
    L16:
        ImageView r21 = this.f6709h;
        if (r21 == null) goto L19;
        r21.setVisibility(0);
    L19:
        ImageView r22 = this.f6709h;
        if (r22 == null) goto L22;
        r22.setImageBitmap(r11);
        goto L22
    }

    public final PopupWindow getPopupWindow() {
        return this.f6707c;
    }

    public final void setPopupWindow(PopupWindow r10) {
        this.f6707c = r10;
    }
}
