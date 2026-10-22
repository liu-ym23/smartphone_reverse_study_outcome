package com.larksuite.component.universe_design.datepicker.impl.header;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.datepicker.databinding.UdDatepickerDefaultHeadBinding;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/header/MonthPickerDefaultHead;", "Landroid/widget/RelativeLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "mMonthPickerActionListener", "Lcom/larksuite/component/universe_design/datepicker/impl/header/MonthPickerDefaultHead$MonthPickerActionListener;", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdDatepickerDefaultHeadBinding;", "setMonthText", "", "monthText", "", "setMonthPickerActionListener", "listener", "setTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthTextSize", "textSize", "", "MonthPickerActionListener", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MonthPickerDefaultHead extends RelativeLayout {
    public AttributeSet a;
    public a b;
    public final UdDatepickerDefaultHeadBinding c;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MonthPickerDefaultHead a;

        public b(MonthPickerDefaultHead r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MonthPickerDefaultHead a;

        public c(MonthPickerDefaultHead r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public MonthPickerDefaultHead(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MonthPickerDefaultHead(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        this(r3, r4, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.a;
    }

    public final void setAttrs(AttributeSet r1) {
        this.a = r1;
    }

    public final void setMonthPickerActionListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
        this.c.b.setOnClickListener(new b(this));
        this.c.d.setOnClickListener(new c(this));
    }

    public final void setMonthText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "monthText");
        this.c.c.setText(r2);
    }

    public final void setMonthTextSize(float r3) {
        this.c.c.setTextSize(0, r3);
    }

    public final void setTypeFace(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "typeFace");
        this.c.c.setTypeface(r2);
    }

    public MonthPickerDefaultHead(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2, r3, r4);
        this.a = r3;
        LayoutInflater.from(getContext()).inflate(2131568079, this);
        int r5 = 2131377695;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131377695);
        if (r6 == null) goto L11;
        r5 = 2131380273;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131380273);
        if (r7 == null) goto L11;
        r5 = 2131384502;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(this, 2131384502);
        if (r0 == null) goto L11;
        this.c = new UdDatepickerDefaultHeadBinding(this, r6, r7, r0);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ MonthPickerDefaultHead(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
