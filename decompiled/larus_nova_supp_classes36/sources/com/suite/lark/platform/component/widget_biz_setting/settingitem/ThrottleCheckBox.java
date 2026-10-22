package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ThrottleCheckBox extends LKUICheckBox {
    public long c;
    public long d;
    public CompoundButton.OnCheckedChangeListener e;

    public ThrottleCheckBox(Context r3) {
        super(r3);
        this.c = 200;
        this.d = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setChecked(boolean r8) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.d) >= this.c) goto L6;
        Log.i("OnLimitingListener", "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        this.d = r0;
        super/*android.widget.CheckBox*/.setChecked(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCheckedImmediatelyNoEvent(boolean r3) {
        CompoundButton.OnCheckedChangeListener r0 = this.e;
        setOnCheckedChangeListener(null);
        super/*android.widget.CheckBox*/.setChecked(r3);
        setOnCheckedChangeListener(r0);
    }

    public void setMinClickInterval(long r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        super/*android.widget.CheckBox*/.setOnCheckedChangeListener(r1);
        this.e = r1;
    }

    public ThrottleCheckBox(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = 200;
        this.d = 0;
    }

    public ThrottleCheckBox(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = 200;
        this.d = 0;
    }
}
