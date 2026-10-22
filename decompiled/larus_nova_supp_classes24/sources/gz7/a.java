package gz7;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larksuite.component.card.plugin.ShowDatePickerPlugin;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements c {
    public final UniversalCardHostInfoManager a;

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        UniversalCardHostInfoManager r0 = this.a;
        if (r0 == null) goto L15;
        r0.e.clear();
        Activity r1 = UIUtils.getActivityFromContext(r0.a);
        if (r1 == null) goto L19;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L16;
        View r3 = UniversalCardHostInfoManager.a(r2);
        if (r3 == null) goto L17;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L18;
        r4.removeOnGlobalLayoutListener(r0.d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    }

    @Override // gz7.c
    public final void init() {
        UniversalCardHostInfoManager r0 = this.a;
        if (r0 == null) goto L15;
        Activity r1 = UIUtils.getActivityFromContext(r0.a);
        if (r1 == null) goto L19;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L16;
        View r3 = UniversalCardHostInfoManager.a(r2);
        if (r3 == null) goto L17;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L18;
        r4.addOnGlobalLayoutListener(r0.d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    }

    public a(com.larksuite.component.card.service.b r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceContext");
        ILarkLynxContainer r4 = r3.b;
        if (r4 == null) goto L5;
        UniversalCardHostInfoManager r0 = new UniversalCardHostInfoManager(r4.getLynxView().getContext(), r4);
    L6:
        this.a = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // gz7.c
    public final void a(ShowDatePickerPlugin.b r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        UniversalCardHostInfoManager r1 = this.a;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "observer");
        r1.e.remove(r3);
        return;
    }

    @Override // gz7.c
    public final void h(ShowDatePickerPlugin.b r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        UniversalCardHostInfoManager r1 = this.a;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "observer");
        r1.e.add(r3);
        return;
    }
}
