package zk8;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ i(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        Function0 r0 = this.a;
        String r6 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "reason");
        FLogger.a.e("FileAudioPlayer", "play failed, media focus denied, reason=" + r6);
        r0.invoke();
        return Unit.INSTANCE;
    }
}
