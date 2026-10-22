package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "hostType", "", "setUnSelect", "(Ljava/lang/Integer;)V", "setSelect", "setGray", "Lcom/bytedance/android/ec/common/impl/sku/view/k;", "clickListener", "setItemClickListener", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemView extends AppCompatTextView {
    public Integer a;
    public Boolean b;
    public n.c c;
    public boolean d;
    public final SpecItemGroupLayout.e e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SpecItemView a;
        public final /* synthetic */ k b;

        public a(SpecItemView r1, k r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            n.c r0 = this.a.c;
            if ((r10 instanceof TextView) == true) goto L5;
            r10 = null;
        L5:
            TextView r11 = (TextView) r10;
            if (r0 == null) goto L10;
            if (r11 == null) goto L11;
            this.b.a(r0);
            return;
        L11:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setGray(Integer r10) {
        if (r10 != null) goto L5;
    L7:
        setBackgroundResource(2131247942);
    L8:
        setTextColor(th.a.a(getContext(), 2131106229));
        return;
    L5:
        if (r10.intValue() != 4) goto L7;
        setBackgroundResource(2131247938);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSelect(Integer r10) {
        if (r10 != null) goto L5;
    L7:
        setBackgroundResource(2131247918);
        setTextColor(th.a.a(getContext(), 2131101133));
        return;
    L5:
        if (r10.intValue() != 4) goto L7;
        setBackgroundResource(2131247936);
        setTextColor(th.a.a(getContext(), 2131106181));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setUnSelect(Integer r10) {
        if (r10 != null) goto L5;
    L7:
        setBackgroundResource(2131247942);
        setTextColor(th.a.a(getContext(), 2131101247));
        return;
    L5:
        if (r10.intValue() != 4) goto L7;
        setBackgroundResource(2131247938);
        setTextColor(th.a.a(getContext(), 2131106227));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setItemClickListener(k r10) {
        Intrinsics.checkNotNullParameter(r10, "clickListener");
        setOnClickListener(new a(this, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpecItemView(Context r10, n r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null, 0);
        this.e = r11;
        AccessibilityDelegateCompat r12 = new AnonymousClass1(this);
        int r13 = jg.a.a;
        ViewCompat.setAccessibilityDelegate(this, r12);
    }

    public final void y(n.c r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "viewInfo");
        String r1 = null;
        if (Intrinsics.areEqual(r11, r10.b) == false) goto L14;
        SpecItemGroupLayout.e r12 = this.e;
        if (r12 == null) goto L10;
        n.c r13 = r12.getCheckedItemViewInfo();
        if (r13 == null) goto L10;
        r1 = r13.b;
    L10:
        if ((!Intrinsics.areEqual(r1, r11)) == false) goto L12;
        this.d = true;
        setSelect(this.a);
        return;
    L12:
        this.d = true;
        return;
    L14:
        if (r10.equals(this.c) == true) goto L22;
        n.c r14 = new n.c(r10.b, r10.c, r10.d, r10.e);
        r14.a = r10.a;
        this.c = r14;
        if ((!Intrinsics.areEqual(this.b, Boolean.TRUE)) == false) goto L18;
    L21:
        this.d = false;
        setGray(this.a);
        return;
    L18:
        if (r10.a == false) goto L21;
        this.d = false;
        setUnSelect(this.a);
        return;
    L22:
        SpecItemGroupLayout.e r15 = this.e;
        if (r15 == null) goto L27;
        n.c r16 = r15.getCheckedItemViewInfo();
        if (r16 == null) goto L27;
        String r17 = r16.b;
    L28:
        n.c r18 = this.c;
        if (r18 == null) goto L32;
        r1 = r18.b;
    L32:
        if (Intrinsics.areEqual(r17, r1) == false) goto L40;
        this.d = false;
        if ((!Intrinsics.areEqual(this.b, Boolean.TRUE)) == false) goto L36;
    L39:
        setGray(this.a);
        return;
    L36:
        if (r10.a == false) goto L39;
        setUnSelect(this.a);
        return;
    L40:
        this.d = false;
        return;
    L27:
        r17 = null;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(n.c r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "itemInfo");
        boolean r0 = r10.a;
        n.c r1 = this.c;
        if (r1 != null) goto L5;
    L15:
        this.a = Integer.valueOf(r11);
        this.b = Boolean.valueOf(r12);
        this.d = false;
        boolean r13 = r10.a;
        if (r12 == false) goto L20;
        if (r13 == false) goto L20;
        setUnSelect(Integer.valueOf(r11));
    L22:
        if (r10.equals(this.c) == true) goto L27;
        setText(r10.c);
        ECUrlModel r14 = r10.e;
        if (r14 == null) goto L26;
        com.bytedance.android.ec.core.utils.y.l(r14, 0, 0, new d0(this));
    L26:
        n.c r15 = new n.c(r10.b, r10.c, r10.d, r10.e);
        r15.a = r10.a;
        this.c = r15;
    L27:
        this.d = false;
        return;
    L20:
        setGray(Integer.valueOf(r11));
        goto L22
    L5:
        if (r0 != r1.a) goto L15;
        if (this.d == true) goto L15;
        if ((!Intrinsics.areEqual(Boolean.valueOf(r12), this.b)) == true) goto L15;
        Integer r16 = this.a;
        if (r16 == null) goto L15;
        if (r11 == r16.intValue()) goto L22;
        goto L15
    }
}
