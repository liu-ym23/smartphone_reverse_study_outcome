package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.databinding.LarusDeepSearchCardBinding;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u extends i {
    public final LarusDeepSearchCardBinding p;
    public final AppCompatImageView q;

    public static final class a {
    }

    static {
    }

    public final AppCompatImageView getErrorIcon() {
        return this.q;
    }

    public u(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        ConstraintLayout r11 = LayoutInflater.from(r10).inflate(2131562020, null, false);
        int r0 = 2131368840;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131368840);
        if (r5 == null) goto L13;
        r0 = 2131371757;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r11, 2131371757);
        if (r1 == null) goto L13;
        r0 = 2131374766;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r11, 2131374766);
        if (r7 == null) goto L13;
        r0 = 2131388915;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, 2131388915);
        if (r8 == null) goto L13;
        ConstraintLayout r12 = r11;
        this.p = new LarusDeepSearchCardBinding(r12, r5, r1, r7, r8);
        this.q = r1;
        addView(r12, new ViewGroup.LayoutParams(-1, -2));
        setBoxType(0);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r1, boolean r2) {
        super.l(r1, r2);
        setMinimumWidth(getMaxWidth());
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void i(int r2, int r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "outSpec");
        r4[0] = View.MeasureSpec.makeMeasureSpec(getMaxWidth(), 1073741824);
        r4[1] = r3;
    }

    public final void m(String r17, String r18, SearchImageInfo r19, boolean r20) {
        boolean r3 = true;
        int r5 = 0;
        this.p.e.setText(getContext().getString(2131909122, new Object[]{r17}));
        this.p.b.setText(r18);
        String r1 = null;
        if (r19 == null) goto L12;
        String r2 = r19.getThumbUrl();
        if (r2 != null) goto L11;
        List r4 = r19.getFullSizeUrl();
        if (r4 == null) goto L9;
        r1 = (String) CollectionsKt.firstOrNull(r4);
    L9:
        if (r1 != null) goto L12;
        r1 = "";
        goto L12
    L11:
        String r7 = r2;
    L13:
        if (r7 == null) goto L19;
        if (r7.length() == 0) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L21;
        this.p.d.setVisibility(8);
    L22:
        AppCompatImageView r6 = this.p.c;
        if (r20 == true) goto L26;
        r5 = 8;
    L26:
        r6.setVisibility(r5);
        return;
    L21:
        this.p.d.setVisibility(0);
        int r8 = oi8.j.a;
        oi8.j.b(this.p.d, r7, "chat.deep_search_card", Integer.valueOf(i5.l0()), Integer.valueOf(i5.l0()), null, null, null, false, 992);
    L12:
        r7 = r1;
        goto L13
    }
}
