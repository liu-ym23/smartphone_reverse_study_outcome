package im.quar.autolayout;

import android.view.View;
import android.view.ViewGroup;
import im.quar.autolayout.attr.AutoAttr;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AutoLayoutInfo {
    public float aspectRatio;
    private List<AutoAttr> autoAttrs;

    public AutoLayoutInfo() {
        this.autoAttrs = new ArrayList();
    }

    private Class getActualTypeClass(Class r8) {
        return (Class) ((ParameterizedType) r8.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void addAttr(AutoAttr r8) {
        this.autoAttrs.add(r8);
    }

    public void applyAspectRatio(View r8) {
        if (this.aspectRatio <= 0.0f) goto L26;
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if (r10 == null) goto L27;
        int r11 = r10.width;
        if (r11 >= 0) goto L9;
        r11 = r8.getMeasuredWidth();
    L9:
        int r12 = r10.height;
        if (r12 >= 0) goto L12;
        r12 = r8.getMeasuredHeight();
    L12:
        boolean r13 = true;
        if (r11 != 0) goto L15;
        boolean r14 = true;
    L16:
        if (r12 == 0) goto L19;
        r13 = false;
    L19:
        if (r14 == false) goto L22;
        if (r12 <= 0) goto L22;
        r10.width = (int) (r12 * this.aspectRatio);
    L22:
        if (r13 == false) goto L28;
        if (r11 <= 0) goto L29;
        r10.height = (int) (r11 * this.aspectRatio);
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r14 = false;
        goto L16
    L27:
        return;
    }

    public void fillAttrs(Object r8) {
        Iterator<AutoAttr> r10 = this.autoAttrs.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        AutoAttr r11 = r10.next();
        if (getActualTypeClass(r11.getClass()).isInstance(r8) == false) goto L4;
        r11.apply(r8);
        goto L4
    }

    public String toString() {
        return "AutoLayoutInfo{autoAttrs=" + this.autoAttrs + '}';
    }
}
