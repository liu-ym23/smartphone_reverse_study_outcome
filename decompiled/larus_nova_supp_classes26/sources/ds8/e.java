package ds8;

import android.view.MotionEvent;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import com.larus.bmhome.top.view.BackTopButton;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ ChatTopFloatingButtonComponent a;

    public /* synthetic */ e(ChatTopFloatingButtonComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        ChatTopFloatingButtonComponent r0 = this.a;
        MotionEvent r10 = (MotionEvent) r9;
        int r1 = ChatTopFloatingButtonComponent.z;
        Intrinsics.checkNotNullParameter(r10, "event");
        boolean r2 = false;
        if (r10.getActionMasked() != 0) goto L25;
        LarusPageChatTopFloatingButtonBinding r3 = r0.Y2();
        if (r3 == null) goto L23;
        BackTopButton r4 = r3.b;
        if (r4 == null) goto L23;
        int[] r5 = new int[2];
        r4.getLocationOnScreen(r5);
        float r6 = r10.getRawX();
        float r11 = r10.getRawY();
        int r7 = r5[0];
        if (r6 >= r7) goto L11;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L23;
        Function0 r13 = r0.u;
        if (r13 == null) goto L22;
        r13.invoke();
    L22:
        r2 = true;
        goto L23
    L11:
        if (r6 > (r7 + r4.getWidth())) goto L17;
        int r8 = r5[1];
        if (r11 < r8) goto L17;
        if (r11 > (r8 + r4.getHeight())) goto L17;
        r12 = true;
    L23:
        r0.hide();
        r0.w.removeCallbacks(r0.y);
    L25:
        return Boolean.valueOf(r2);
    }
}
