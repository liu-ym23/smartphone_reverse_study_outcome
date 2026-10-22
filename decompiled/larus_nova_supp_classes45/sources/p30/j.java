package p30;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface j {
    void closeLiveRoomRTS(a r1, Function1<? super b, Unit> r2, Context r3);

    void getClientSettingRTS(f r1, Function1<Object, Unit> r2, Context r3);

    void getEnableLiveHistoryRTS(h r1, Function1<? super Boolean, Unit> r2);

    void userActionRTS(q r1, Function1<? super r, Unit> r2, Context r3);
}
