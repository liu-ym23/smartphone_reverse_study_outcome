package tp8;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.inputarea.InputAreaBlockComponent;
import hk9.a;
import kotlin.jvm.internal.Intrinsics;
import ss8.g$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements g$a {
    public final /* synthetic */ InputAreaBlockComponent a;
    public final /* synthetic */ a b;

    public /* synthetic */ d(InputAreaBlockComponent r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final a a(ViewGroup r4) {
        InputAreaBlockComponent r0 = this.a;
        a r1 = this.b;
        int r2 = InputAreaBlockComponent.u;
        Intrinsics.checkNotNullParameter(r4, "parent");
        r0.getClass();
        ViewParent r5 = r1.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L5;
        ViewGroup r6 = (ViewGroup) r5;
    L6:
        if (r6 == null) goto L8;
        r6.removeView(r1);
    L8:
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r1;
    L5:
        r6 = null;
        goto L6
    }
}
