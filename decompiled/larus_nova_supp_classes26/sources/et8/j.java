package et8;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.t2;
import com.larus.bmhome.view.chatinput.InputKeyboardIconPopupMenu;
import com.skydoves.balloon.Balloon;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ InputKeyboardIconPopupMenu b;

    public /* synthetic */ j(t2 r1, InputKeyboardIconPopupMenu r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function0 r3 = this.a;
        InputKeyboardIconPopupMenu r0 = this.b;
        r3.invoke();
        Balloon r4 = r0.b;
        if (r4 == null) goto L6;
        r4.h();
        return;
    }
}
