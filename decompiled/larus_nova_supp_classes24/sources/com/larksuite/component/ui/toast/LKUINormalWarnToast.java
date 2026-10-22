package com.larksuite.component.ui.toast;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import j08.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUINormalWarnToast extends LinearLayout {
    public final View a;
    public final ImageView b;
    public final TextView c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int ERROR = 0;
        public static final int INFO = 2;
        public static final int SUCCESS = 3;
        public static final int WARN = 1;
    }

    public LKUINormalWarnToast(Context r2) {
        this(r2, null);
    }

    public void setImage(int r2) {
        this.b.setImageResource(r2);
    }

    public void setText(String r2) {
        this.c.setText(r2);
    }

    public void setType(int r4) {
        if (r4 != 0) goto L5;
        this.a.setBackgroundColor(b.c(getContext(), 2131103493, 0.15f));
        this.c.setTextColor(getResources().getColor(2131103493));
        return;
    L5:
        if (r4 != 1) goto L7;
        this.a.setBackgroundColor(b.c(getContext(), 2131103533, 0.15f));
        this.c.setTextColor(getResources().getColor(2131103533));
        return;
    L7:
        if (r4 != 2) goto L9;
        this.a.setBackgroundColor(b.c(getContext(), 2131103404, 0.15f));
        this.c.setTextColor(getResources().getColor(2131103404));
        return;
    L9:
        if (r4 == 3) goto L11;
        this.a.setBackgroundColor(b.c(getContext(), 2131103493, 0.15f));
        this.c.setTextColor(getResources().getColor(2131103493));
        return;
    L11:
        this.a.setBackgroundColor(b.c(getContext(), 2131103503, 0.15f));
        this.c.setTextColor(getResources().getColor(2131103503));
    }

    public LKUINormalWarnToast(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LKUINormalWarnToast(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130975161, 2130975162, 2130975163}, r5, 0);
        Drawable r7 = r6.getDrawable(0);
        CharSequence r8 = r6.getText(1);
        int r0 = r6.getInt(2, 0);
        r6.recycle();
        View r9 = LinearLayout.inflate(getContext(), 2131563572, this);
        this.a = r9.findViewById(2131367728);
        ImageView r1 = (ImageView) r9.findViewById(2131374718);
        this.b = r1;
        r1.setImageDrawable(r7);
        this.c = (TextView) r9.findViewById(2131388367);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        setText(r8.toString());
    L5:
        setType(r0);
    }
}
