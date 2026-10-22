package od8;

import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Function1 {
    public /* synthetic */ w() {
    }

    public final Object invoke(Object r2) {
        Pair r3 = (Pair) r2;
        int r0 = ChatCameraComponent.S;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r3.getFirst(), "CAPTURE_MODE_PHOTO"));
    }
}
