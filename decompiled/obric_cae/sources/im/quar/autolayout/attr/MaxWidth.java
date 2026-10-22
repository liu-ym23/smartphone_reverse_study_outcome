package im.quar.autolayout.attr;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class MaxWidth extends AutoAttr<View> {
    public MaxWidth(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 8192;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(View r8, int r10) {
        if ((r8 instanceof TextView) == false) goto L12;
        ((TextView) r8).setMaxWidth(r10);
        return;
    L12:
        if ((r8 instanceof ProgressBar) == false) goto L8;
        Field r11 = r8.getClass().getDeclaredField("mMaxWidth");     // Catch: Exception -> L10
        r11.setAccessible(true);     // Catch: Exception -> L10
        r11.set(r8, Integer.valueOf(r10));     // Catch: Exception -> L10
    L11:
        return;
    L8:
        r8.getClass().getMethod("setMaxWidth", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L10
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(View r8, int r10) {
        execute2(r8, r10);
    }
}
