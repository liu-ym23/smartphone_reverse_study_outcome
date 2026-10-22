package com.obric.assistant.special_input;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.platform.service.x1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.component.ObricSkillComponent;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.t1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p0 {
    public static final PhoneOperationModeRestoreResult a(com.larus.bmhome.instruction.g r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "source");
        AtomicBoolean r0 = com.obric.assistant.task.skill.m.a;
        boolean r2 = true;
        if (com.obric.assistant.task.skill.m.j(10000) == false) goto L14;
        int r1 = t1.a.getAutoGuiEnabledScene();
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        FLogger.a.w("PhoneOperationModeRestore", "request rejected, phone-operation mode unavailable, source=".concat(r6));
        return PhoneOperationModeRestoreResult.UNAVAILABLE;
    L19:
        if (r7 == false) goto L40;
        kotlinx.coroutines.flow.b1 r8 = j.a;
        String r9 = "mode_restore_".concat(r6);
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        OSkillExtensionSettingRepository.a.getClass();
        OSkillExtensionSettingRepository.b(r9);
        t0 r10 = (t0) j.a.getValue();
        if (r10.c == true) goto L23;
    L37:
        FLogger.a.i("PhoneOperationModeRestore", "request pending, omni skill state not ready, source=".concat(r6));
        return PhoneOperationModeRestoreResult.NOT_READY;
    L23:
        if (r10.f == false) goto L37;
        if (r10.e != 1) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == true) goto L31;
    L33:
        r2 = false;
    L34:
        if (r2 == true) goto L40;
        FLogger.a.w("PhoneOperationModeRestore", "request rejected, omni skill unusable, source=".concat(r6));
        return PhoneOperationModeRestoreResult.UNAVAILABLE;
    L31:
        if (r10.a == false) goto L33;
    L28:
        r11 = false;
    L40:
        if (com.obric.assistant.task.skill.f.d() == true) goto L42;
        if (r5 != null) goto L62;
        FLogger.a.w("PhoneOperationModeRestore", "request rejected, instruction ability unavailable, source=".concat(r6));
        return PhoneOperationModeRestoreResult.UNAVAILABLE;
    L62:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L48
        ObricSkillComponent.A.getClass();     // Catch: Throwable -> L48
        Object r13 = Result.constructor-impl(r5.IT(ObricSkillComponent.B));     // Catch: Throwable -> L48
    L50:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L54;
        FLogger.a.w("PhoneOperationModeRestore", "create reply option failed, source=".concat(r6), r14);
    L54:
        if (Result.isFailure-impl(r13) == false) goto L56;
        r13 = null;
    L56:
        ReplyOption r15 = (ReplyOption) r13;
        if (r15 == null) goto L59;
        r5.M80(r15, false);
        FLogger.a.i("PhoneOperationModeRestore", "phone-operation mode switch requested, source=".concat(r6));
        return PhoneOperationModeRestoreResult.READY;
    L59:
        return PhoneOperationModeRestoreResult.UNAVAILABLE;
    L48:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L42:
        return PhoneOperationModeRestoreResult.READY;
    L9:
        if (x1.a.a() == true) goto L11;
        r3 = true;
    L14:
        r4 = false;
        goto L16
    }
}
