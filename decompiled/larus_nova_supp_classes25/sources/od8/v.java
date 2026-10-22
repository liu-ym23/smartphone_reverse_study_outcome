package od8;

import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import dr9.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function0 {
    public final /* synthetic */ ChatCameraComponent a;

    public /* synthetic */ v(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        if (uy8.b.c() == true) goto L5;
    L15:
        r0.Z3();
        return Unit.INSTANCE;
    L5:
        if (r0.q == null) goto L15;
        String r2 = r0.r;
        if (r2 == null) goto L9;
        g.a.a(r2);
    L9:
        ICoreInputAbility r3 = r0.H3();
        if (r3 == null) goto L12;
        r3.p80(false);
    L12:
        g1 r4 = r0.m3();
        if (r4 == null) goto L15;
        g1.a.a(r4, null, 7);
        goto L15
    }
}
