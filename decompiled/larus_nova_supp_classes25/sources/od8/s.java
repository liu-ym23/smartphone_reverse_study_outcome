package od8;

import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements ex8.b {
    public final /* synthetic */ ChatCameraComponent a;

    public /* synthetic */ s(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final Object a(String r3, int r4, Object r5) {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        Intrinsics.checkNotNullParameter(r3, "innerScene");
        if (s1a.a.c(r0).isAdded() == true) goto L6;
        FLogger.a.e("ChatCameraComponent", "[onCameraCommand] fragment is detached");
        return null;
    L6:
        return ((com.larus.bmhome.chat.camera.command.c) r0.K.getValue()).a(r3, r4, r5);
    }
}
