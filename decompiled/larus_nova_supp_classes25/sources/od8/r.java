package od8;

import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function2 {
    public final /* synthetic */ List a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ChatCameraComponent d;

    public /* synthetic */ r(List r1, Ref.IntRef r2, int r3, ChatCameraComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r8, Object r9) {
        List r0 = this.a;
        Ref.IntRef r1 = this.b;
        int r2 = this.c;
        ChatCameraComponent r3 = this.d;
        boolean r10 = ((Boolean) r8).booleanValue();
        String r11 = (String) r9;
        int r4 = ChatCameraComponent.S;
        Intrinsics.checkNotNullParameter(r11, "uri");
        FLogger.a.i("ChatCameraComponent", "saveBitmapWithFilePath isSuccess:" + r10 + ", uri:" + r11);
        if (r10 == true) goto L5;
    L7:
        r1.element++;
        ChatCameraComponent.c4(r1, r2, r3, r0);
        return Unit.INSTANCE;
    L5:
        if (o0.d(r11) == false) goto L7;
        r0.add(r11);
        goto L7
    }
}
