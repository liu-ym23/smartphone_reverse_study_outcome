package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class InvErrorView extends LinearLayout {
    public InvErrorView(Context r2) {
        this(r2, null);
    }

    public InvErrorView(Context r2, AttributeSet r3) {
        super(r2, r3);
        LayoutInflater.from(getContext()).inflate(2131561553, this, true);
        setOrientation(1);
        setGravity(1);
        setBackgroundColor(UIHelper.getColor(2131100545));
        WindowManager r4 = (WindowManager) getContext().getSystemService("window");
        if (r4 != null) goto L5;
        int r5 = -1;
    L6:
        setPadding(0, r5 / 3, 0, 0);
        setVisibility(8);
        setZ(-16.0f);
        ImageView r6 = (ImageView) findViewById(2131375576);
        TextView r7 = (TextView) findViewById(2131375577);
        return;
    L5:
        Point r8 = new Point();
        r4.getDefaultDisplay().getSize(r8);
        r5 = r8.y;
        goto L6
    }
}
