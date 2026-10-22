package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h extends Handler {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.a.invoke(Boolean.valueOf(r4.getData().getBoolean(WindowEvent.WindowOpenPerfResult.SUCCESS, false)));
    }

    public h(c r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
