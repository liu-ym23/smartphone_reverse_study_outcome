package od8;

import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.bmhome.instruction.g;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function0 {
    public final /* synthetic */ ChatCameraComponent a;

    public /* synthetic */ u(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatCameraComponent r0 = this.a;
        if (r0.P == true) goto L5;
        FLogger.a.i("ChatCameraComponent", "[onCameraResultFailure] enableCameraResult false, abort");
        return Unit.INSTANCE;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isAdded() == true) goto L8;
        FLogger.a.e("ChatCameraComponent", "[onCameraResultFailure] fragment is detached");
        return Unit.INSTANCE;
    L8:
        Function0 r1 = r0.m;
        boolean r2 = true;
        if (r1 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L40;
        g r4 = r0.vc();
        if (r4 == null) goto L18;
        Integer r5 = Integer.valueOf(r4.Q1());
    L19:
        g1 r6 = r0.m3();
        if (r6 == null) goto L22;
        int r7 = g1.a.b(r6);
    L23:
        if (r5 != null) goto L26;
    L27:
        if (r5 != null) goto L30;
    L32:
        r2 = false;
    L34:
        if (h0.a(r5) == true) goto L36;
        if (r2 == false) goto L40;
    L36:
        if (r7 != 0) goto L40;
        g r8 = r0.vc();
        if (r8 == null) goto L40;
        r8.A1();
        goto L40
    L30:
        if (r5.intValue() != 23) goto L32;
    L26:
        if (r5.intValue() == 20) goto L34;
    L22:
        r7 = 0;
        goto L23
    L18:
        r5 = null;
    L40:
        r0.Z3();
        return Unit.INSTANCE;
    L11:
        if (((Boolean) r1.invoke()).booleanValue() != true) goto L13;
        r3 = true;
        goto L14
    }
}
