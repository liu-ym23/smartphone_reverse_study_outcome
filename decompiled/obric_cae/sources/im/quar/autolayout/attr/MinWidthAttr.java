package im.quar.autolayout.attr;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class MinWidthAttr extends AutoAttr<View> {
    public MinWidthAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 32768;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(View r8, int r10) {
        r8.setMinimumWidth(r10);
        if ((r8 instanceof TextView) == false) goto L6;
        ((TextView) r8).setMinWidth(r10);
        return;
    L6:
        if ((r8 instanceof ProgressBar) == false) goto L13;
        Field r11 = r8.getClass().getDeclaredField("mMinWidth");     // Catch: Exception -> L9
        r11.setAccessible(true);     // Catch: Exception -> L9
        r11.set(r8, Integer.valueOf(r10));     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(View r8, int r10) {
        execute2(r8, r10);
    }
}
