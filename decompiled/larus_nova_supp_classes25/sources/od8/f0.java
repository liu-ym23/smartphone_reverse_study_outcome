package od8;

import android.os.Bundle;
import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 implements Function1<de8.a, Unit> {
    public final /* synthetic */ ChatCameraComponent a;

    public f0(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        t1a.c r4 = (t1a.c) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ChatCameraComponent r0 = this.a;
        Bundle r5 = ((de8.a) r4).a;
        int r1 = ChatCameraComponent.S;
        r0.N2(r5);
        return Unit.INSTANCE;
    }
}
