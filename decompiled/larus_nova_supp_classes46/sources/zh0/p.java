package zh0;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Pair;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ RadioWidget a;

    public /* synthetic */ p(RadioWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RadioWidget r0 = this.a;
        int r1 = RadioWidget.H0;
        r0.getClass();
        Integer r2 = je0.d.h();
        int r3 = je0.d.f();
        if (r2 != null) goto L5;
    L35:
        ViewGroup r4 = ((Widget) r0).containerView;
        if (r4 == null) goto L41;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.width = -1;
        r5.height = -1;
        ((Widget) r0).containerView.setLayoutParams(r5);
        return;
    L41:
        return;
    L5:
        if (r3 == 5) goto L9;
        if (r3 != 16) goto L35;
    L9:
        if (((Widget) r0).containerView == null) goto L39;
        int r6 = ug0.b.a;
        int r7 = r2.intValue();
        ReadOnlyProperty r8 = vm2.h.I5;
        KProperty[] r9 = vm2.h.a;
        if (((Boolean) r8.getValue(null, r9[345(0x159, float:4.83E-43)])).booleanValue() == false) goto L21;
        hs0.a r10 = hs0.a.b;
        if (r10.getCurrentLivePlayerParent() == null) goto L18;
        if (r10.getCurrentLivePlayerParent().getWidth() <= 0) goto L18;
        Integer r11 = Integer.valueOf(r10.getCurrentLivePlayerParent().getWidth());
    L22:
        int r12 = r11.intValue();
        if (((Boolean) r8.getValue(null, r9[345(0x159, float:4.83E-43)])).booleanValue() == false) goto L33;
        hs0.a r13 = hs0.a.b;
        if (r13.getCurrentLivePlayerParent() == null) goto L30;
        if (r13.getCurrentLivePlayerParent().getHeight() <= 0) goto L30;
        Integer r14 = Integer.valueOf(r13.getCurrentLivePlayerParent().getHeight());
    L34:
        Pair r15 = ug0.b.b(3, r7, r12, r14.intValue());
        ViewGroup.LayoutParams r16 = ((Widget) r0).containerView.getLayoutParams();
        r16.width = ((Integer) r15.getFirst()).intValue();
        r16.height = ((Integer) r15.getSecond()).intValue();
        ((Widget) r0).containerView.setLayoutParams(r16);
        return;
    L30:
        if (((Widget) r0).containerView.getHeight() <= 0) goto L32;
        r14 = Integer.valueOf(((Widget) r0).containerView.getHeight());
        goto L34
    L32:
        r14 = Integer.valueOf(s1.y());
        goto L34
    L33:
        r14 = Integer.valueOf(((Widget) r0).containerView.getHeight());
    L18:
        if (((Widget) r0).containerView.getWidth() <= 0) goto L20;
        r11 = Integer.valueOf(((Widget) r0).containerView.getWidth());
        goto L22
    L20:
        r11 = Integer.valueOf(s1.y());
        goto L22
    L21:
        r11 = Integer.valueOf(((Widget) r0).containerView.getWidth());
        goto L22
    }
}
