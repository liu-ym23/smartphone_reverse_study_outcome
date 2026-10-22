package od8;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.camera.ChatCameraComponent;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.OutputParam;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ ChatCameraComponent a;

    public /* synthetic */ t(ChatCameraComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        ChatCameraComponent r0 = this.a;
        CameraOutputContext r11 = (CameraOutputContext) r10;
        int r1 = ChatCameraComponent.S;
        Intrinsics.checkNotNullParameter(r11, "outputContext");
        CameraResultRoute r2 = r11.getResultRoute();
        r0.getClass();
        boolean r3 = true;
        OutputParam r5 = null;
        if (r2 != null) goto L6;
        boolean r4 = true;
    L31:
        if (r4 == true) goto L34;
        return Unit.INSTANCE;
    L34:
        if (r0.P == true) goto L36;
        FLogger.a.i("ChatCameraComponent", "[onCameraResultSuccess] enableCameraResult false, abort");
        return Unit.INSTANCE;
    L36:
        List r6 = r11.getOutputParamList();
        if (r6 == null) goto L41;
        OutputParam r7 = (OutputParam) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L41;
        String r8 = r7.getFromScene();
    L42:
        ICoreInputAbility r9 = r0.H3();
        if (r9 == null) goto L45;
        String r12 = r9.EW();
    L46:
        ICoreInputAbility r13 = r0.H3();
        if (r13 != null) goto L49;
    L51:
        boolean r14 = false;
    L52:
        if (r14 == true) goto L54;
    L59:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("camera result, listSize=");
        List r17 = r11.getOutputParamList();
        if (r17 == null) goto L62;
        Integer r18 = Integer.valueOf(r17.size());
    L63:
        r16.append(r18);
        r16.append(", firstParam=");
        List r19 = r11.getOutputParamList();
        if (r19 == null) goto L66;
        r5 = (OutputParam) CollectionsKt.firstOrNull(r19);
    L66:
        r16.append(r5);
        r15.i("ChatCameraComponent", r16.toString());
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isAdded() == true) goto L69;
        r15.e("ChatCameraComponent", "[onCameraResultSuccess] fragment is detached");
        return Unit.INSTANCE;
    L69:
        xa8.b r20 = (xa8.b) r0.O.getValue();
        if (r20 != null) goto L72;
    L74:
        boolean r21 = false;
    L75:
        if (r21 == false) goto L77;
        r15.i("ChatCameraComponent", "[onCameraResultSuccess] isContinuousTalking");
        return Unit.INSTANCE;
    L77:
        ChatControlTrace.b.getClass();
        ChatControlTrace.A = false;
        f r22 = r0.l;
        if (r22 != null) goto L80;
    L82:
        r3 = false;
    L83:
        if (r3 == true) goto L85;
        r0.a4(r11);
    L85:
        r0.Z3();
        return Unit.INSTANCE;
    L80:
        if (r22.a(r11) != true) goto L82;
    L72:
        if (r20.fe() != true) goto L74;
        r21 = true;
        goto L75
    L62:
        r18 = null;
        goto L63
    L54:
        if (Intrinsics.areEqual(r12, "inject_input_photo_picker") == false) goto L59;
        if (r8 == null) goto L59;
        if (Intrinsics.areEqual(r8, "inject_input_photo_picker") == true) goto L59;
        FLogger.a.i("ChatCameraComponent", "[onCameraResultSuccess] ignore non-inject camera result, resultScene=" + r8 + ", injectInputScene=" + r12);
        return Unit.INSTANCE;
    L49:
        if (r13.c1() != true) goto L51;
        r14 = true;
        goto L52
    L45:
        r12 = null;
    L41:
        r8 = null;
        goto L42
    L6:
        if (r2.getDelivery() != CameraResultRoute.Delivery.CONFIRM_TO_OWNER) goto L30;
        ICoreInputAbility r23 = r0.H3();
        if (r23 != null) goto L10;
    L12:
        boolean r24 = false;
    L13:
        if (r24 == false) goto L30;
        ICoreInputAbility r25 = r0.H3();
        if (r25 == null) goto L17;
        String r26 = r25.EW();
    L19:
        if (Intrinsics.areEqual(r26, "inject_input_photo_picker") == false) goto L30;
        Bundle r27 = r0.f1().b;
        if (r27 == null) goto L28;
        String r28 = r27.getString("inject_input_album_node_id");
        if (r28 == null) goto L28;
        if (kq9.b.c(r28) == false) goto L28;
    L29:
        r4 = Intrinsics.areEqual(r28, r2.getOwnerNodeId());
    L28:
        r28 = null;
        goto L29
    L17:
        r26 = null;
        goto L19
    L10:
        if (r23.c1() != true) goto L12;
        r24 = true;
    L30:
        r4 = false;
        goto L31
    }
}
