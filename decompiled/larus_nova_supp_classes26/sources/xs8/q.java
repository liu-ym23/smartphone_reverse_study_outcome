package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TextListSelectorWidget;
import com.larus.bmhome.view.actionbar.edit.component.UserMessageSenderWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q extends o {
    @Override // xs8.o, up8.b
    public int getType() {
        return 13;
    }

    public q() {
    }

    @Override // xs8.o, up8.b
    public final /* bridge */ /* synthetic */ AbsInstructionWidget e(Context r1) {
        return s(r1);
    }

    @Override // xs8.o
    public final TextListSelectorWidget s(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UserMessageSenderWidget(r2);
    }
}
