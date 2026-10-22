package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j extends Handler {
    public final /* synthetic */ Function1<String, Unit> a;

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.a.invoke(r4.getData().getString(WindowEvent.Params.RESULT, null));
    }

    public j(e r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
