package et8;

import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.view.chatinput.InputKeyboardIconPopupMenu;
import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements View.OnTouchListener {
    public final /* synthetic */ InputKeyboardIconPopupMenu a;

    public k(InputKeyboardIconPopupMenu r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.getActionMasked() != 4) goto L10;
        Balloon r4 = this.a.b;
        if (r4 == null) goto L7;
        r4.h();
    L7:
        Balloon r5 = this.a.c;
        if (r5 == null) goto L10;
        r5.h();
    L10:
        return false;
    }
}
