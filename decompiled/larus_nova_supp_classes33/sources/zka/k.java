package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k extends Handler {
    public final /* synthetic */ Function1<List<String>, Unit> a;

    @Override // android.os.Handler
    public final void handleMessage(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Function1<List<String>, Unit> r0 = this.a;
        String[] r4 = r3.getData().getStringArray(WindowEvent.Params.RESULT);
        if (r4 == null) goto L6;
        List r5 = ArraysKt.toList(r4);
        if (r5 == null) goto L6;
    L7:
        r0.invoke(r5);
        return;
    L6:
        r5 = CollectionsKt.emptyList();
        goto L7
    }

    public k(f r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
