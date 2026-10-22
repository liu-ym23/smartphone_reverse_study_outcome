package ugb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends a {
    public b(CoreNavigationBar r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
    }

    @Override // ugb.e
    public final void a(Context r7, sxa.a r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "titleContext");
        FlowTagBuilder r0 = new FlowTagBuilder(r7);
        r0.c = r8.a.isPublic();
        r0.d = r8.a.is_department();
        r0.i = d.a(r8.a);
        FlowTagView r9 = r0.b();
        if (r9 == null) goto L5;
        r9.setTagStyle(new ahb.a(10.0f, 4.0f, 18.0f, 5.0f, 48));
    L6:
        View r10 = this.c;
        if (r10 == null) goto L11;
        ViewGroup r1 = this.b;
        if (r1 == null) goto L11;
        r1.removeView(r10);
    L11:
        this.c = r9;
        if (r9 != null) goto L16;
        ViewGroup r11 = this.b;
        if (r11 == null) goto L23;
        r11.setVisibility(8);
        return;
    L23:
        return;
    L16:
        ViewGroup r12 = this.b;
        if (r12 == null) goto L19;
        r12.addView(r9);
    L19:
        ViewGroup r13 = this.b;
        if (r13 == null) goto L25;
        r13.setVisibility(0);
        return;
    L25:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
