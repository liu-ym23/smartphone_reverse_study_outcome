package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f19775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19776c;

    public n(Context r10, XmlResourceParser r11) {
        this.f19775b = new ArrayList();
        this.f19776c = -1;
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.State);
        int r5 = r12.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L11;
        int r14 = r12.getIndex(r13);
        if (r14 != R$styleable.State_android_id) goto L8;
        this.f19774a = r12.getResourceId(r14, this.f19774a);
    L10:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 != R$styleable.State_constraints) goto L10;
        int r15 = r12.getResourceId(r14, this.f19776c);
        this.f19776c = r15;
        String r16 = r10.getResources().getResourceTypeName(r15);
        r10.getResources().getResourceName(r15);
        "layout".equals(r16);
        goto L10
    L11:
        r12.recycle();
    }
}
