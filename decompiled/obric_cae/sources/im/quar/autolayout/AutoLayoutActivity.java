package im.quar.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.e;
import im.quar.autolayout.utils.AutoLayoutHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AutoLayoutActivity extends e {
    public AutoLayoutActivity() {
    }

    @Override // androidx.fragment.app.m, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r8, Context r10, AttributeSet r11) {
        View r12 = AutoLayoutHelper.createAutoLayoutView(r8, r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return super.onCreateView(r8, r10, r11);
    }
}
