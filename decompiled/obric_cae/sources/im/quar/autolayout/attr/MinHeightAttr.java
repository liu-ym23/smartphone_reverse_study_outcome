package im.quar.autolayout.attr;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class MinHeightAttr extends AutoAttr<View> {
    public MinHeightAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 65536;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(View r8, int r10) {
        r8.setMinimumHeight(r10);
        if ((r8 instanceof TextView) == false) goto L6;
        ((TextView) r8).setMinHeight(r10);
        return;
    L6:
        if ((r8 instanceof ProgressBar) == false) goto L13;
        Field r11 = r8.getClass().getDeclaredField("mMinHeight");     // Catch: Exception -> L9
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
