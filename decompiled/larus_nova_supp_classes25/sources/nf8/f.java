package nf8;

import android.animation.ValueAnimator;
import android.view.View;
import com.larus.bmhome.chat.list.cell.avatar.SmallAvatarCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ SmallAvatarCell a;

    public /* synthetic */ f(SmallAvatarCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        final SmallAvatarCell r0 = this.a;
        if (((Boolean) r6).booleanValue() == true) goto L12;
        com.larus.bmhome.chat.component.bottom.voice.a r7 = (com.larus.bmhome.chat.component.bottom.voice.a) r0.h.getValue();
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        boolean r9 = true;
    L14:
        if (r0.i == r9) goto L28;
        r0.i = r9;
        if (r9 == false) goto L19;
        float r10 = 1.0f;
    L20:
        ValueAnimator r3 = r0.f;
        if (r3 == null) goto L23;
        r3.cancel();
    L23:
        float[] r4 = new float[2];
        View r5 = r0.e;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r5 = null;
    L26:
        r4[0] = r5.getAlpha();
        r4[1] = r10;
        ValueAnimator r11 = ValueAnimator.ofFloat(r4);
        r11.setDuration(150);
        r11.addUpdateListener(new i(r0));
        r11.start();
        r0.f = r11;
        goto L28
    L19:
        r10 = 0.0f;
    L28:
        return Unit.INSTANCE;
    L7:
        if (r7.DG() == true) goto L9;
        r8 = true;
    L12:
        r9 = false;
        goto L14
    }
}
