package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.TextStyleInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.widget.light.viewstub.h {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.o<eab.a> a;
    public final /* synthetic */ LarkAtThemeData b;
    public final /* synthetic */ eab.a c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ Ref.BooleanRef f;
    public final /* synthetic */ Ref.BooleanRef g;
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.v h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ com.ss.android.lark.coremd.base.parse.v a;

        public a(com.ss.android.lark.coremd.base.parse.v r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.d("AtPlugin", "view: onClicked, raise click.");
            com.ss.android.lark.coremd.base.parse.v r3 = this.a;
            if (r3 == null) goto L6;
            r3.a(0);
            return;
        }
    }

    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        TextView r0 = (TextView) r10;
        Context r1 = this.a.getContext();
        LarkAtThemeData r2 = this.b;
        com.ss.android.lark.coremd.ext.c r3 = r2.g;
        KProperty<Object>[] r4 = LarkAtThemeData.k;
        int r5 = UIUtils.getColor(r1, ((Number) r3.getValue(r2, r4[3])).intValue());
        Context r6 = this.a.getContext();
        LarkAtThemeData r7 = this.b;
        int r8 = UIUtils.getColor(r6, ((Number) r7.h.getValue(r7, r4[4])).intValue());
        SpannableStringBuilder r9 = new SpannableStringBuilder("@" + this.c.j);
        TextStyleInfo r11 = new TextStyleInfo();
        r11.isBold = this.d.element;
        r11.isItalic = this.e.element;
        r11.isUnderlineText = this.f.element;
        r11.isStrikeThruText = this.g.element;
        r9.setSpan(new ncc.h(r11), 0, r9.length(), 33);
        r0.setText(r9);
        int r12 = UIUtils.dp2px(r0.getContext(), 4.0f);
        r10.setPadding(r12, r10.getPaddingTop(), r12, r10.getPaddingBottom());
        TextView r13 = (TextView) r10;
        r13.setTextColor(r5);
        LarkAtThemeData r14 = this.b;
        r13.setTextSize(2, ((Number) r14.i.getValue(r14, r4[5])).floatValue());
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), UIUtils.dp2px(this.a.getContext(), 1.0f));
        GradientDrawable r15 = new GradientDrawable();
        r15.setCornerRadius(UIUtils.getDimens(this.a.getContext(), 2131168115));
        r15.setColor(r8);
        r13.setBackground(r15);
        r10.setOnClickListener(new a(this.h));
    }

    public final View b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new AppCompatTextView(r2);
    }

    public d(com.ss.android.lark.coremd.impl.parse.i r1, LarkAtThemeData r2, eab.a r3, Ref.BooleanRef r4, Ref.BooleanRef r5, Ref.BooleanRef r6, Ref.BooleanRef r7, com.ss.android.lark.coremd.base.parse.v r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
