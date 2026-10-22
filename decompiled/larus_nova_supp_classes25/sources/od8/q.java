package od8;

import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.camera.api.params.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q implements Function2 {
    public final /* synthetic */ List a;
    public final /* synthetic */ VideoParam b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ChatCameraComponent e;

    public /* synthetic */ q(List r1, VideoParam r2, Ref.IntRef r3, int r4, ChatCameraComponent r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r9, Object r10) {
        List r0 = this.a;
        VideoParam r1 = this.b;
        Ref.IntRef r2 = this.c;
        int r3 = this.d;
        ChatCameraComponent r4 = this.e;
        boolean r11 = ((Boolean) r9).booleanValue();
        String r12 = (String) r10;
        int r5 = ChatCameraComponent.S;
        Intrinsics.checkNotNullParameter(r12, "uri");
        FLogger.a.i("ChatCameraComponent", "saveMediaWithFilePath isSuccess:" + r11 + ", uri:" + r12);
        if (r11 == true) goto L5;
    L7:
        r2.element++;
        ChatCameraComponent.c4(r2, r3, r4, r0);
        return Unit.INSTANCE;
    L5:
        if (o0.d(r12) == false) goto L7;
        r0.add(r12);
        d r13 = d.a;
        int r6 = r1.getWidth();
        int r7 = r1.getHeight();
        r13.getClass();
        d.o(r12, r6, r7);
        goto L7
    }
}
