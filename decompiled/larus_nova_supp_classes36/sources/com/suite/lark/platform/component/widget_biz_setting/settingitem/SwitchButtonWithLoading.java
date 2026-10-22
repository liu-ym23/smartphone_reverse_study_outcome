package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.button.LKUISwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SwitchButtonWithLoading extends ConstraintLayout {
    public LKUISwitchButton a;

    public interface a {
    }

    public void setOnSwitchListener(a r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        LKUISwitchButton r0 = LayoutInflater.from(getContext()).inflate(2131568206, this).findViewById(2131387951);
        this.a = r0;
        r0.setCheckedNoEvent(true);
        SwitcherLoadingView r1 = (SwitcherLoadingView) findViewById(2131387952);
        this.a.setOnCheckedChangeListener(new com.suite.lark.platform.component.widget_biz_setting.settingitem.a(this));
    }

    public SwitchButtonWithLoading(Context r1) {
        super(r1);
        R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r2) {
        super/*android.view.ViewGroup*/.setEnabled(r2);
        this.a.setEnabled(r2);
    }

    public void update(boolean r2) {
        this.a.setCheckedImmediately(r2);
    }

    public SwitchButtonWithLoading(Context r1, AttributeSet r2) {
        super(r1, r2);
        R5();
    }

    public SwitchButtonWithLoading(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        R5();
    }
}
