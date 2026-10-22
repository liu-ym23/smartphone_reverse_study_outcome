package com.ss.android.lark.keyboard.biz.plus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LarkKeyBoardMorePanel extends LinearLayout {
    public LarkKeyBoardMorePanel(Context r2) {
        this(r2, null);
    }

    public LarkKeyBoardMorePanel(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    public LarkKeyBoardMorePanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        addView(View.inflate(r1, 2131561735, null));
    }
}
