package vha;

import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: vha.a$a, reason: collision with other inner class name */
    public static final class C0032a extends a {
        public final DoraSwitchState a;
        public final DoraConnectState b;
        public final DoraWearState c;

        public C0032a(DoraSwitchState r2, DoraConnectState r3, DoraWearState r4) {
            Intrinsics.checkNotNullParameter(r2, "switchState");
            Intrinsics.checkNotNullParameter(r3, "connectState");
            Intrinsics.checkNotNullParameter(r4, "wearState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public a() {
    }
}
