package com.larus.uaigc.music.applet;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final /* synthetic */ class MusicTemplateAppletInputComponent$configInput$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public MusicTemplateAppletInputComponent$configInput$2(Object r8) {
        super(1, r8, MusicTemplateAppletInputComponent.class, "onCoreFullScreenInputStatusChanged", "onCoreFullScreenInputStatusChanged(Z)V", 0);
    }

    public final void invoke(boolean r6) {
        MusicTemplateAppletInputComponent r0 = (MusicTemplateAppletInputComponent) ((CallableReference) this).receiver;
        r0.u = r6;
        ChatConstraintLayout r1 = r0.n;
        if (r1 == null) goto L5;
        r1.removeCallbacks(r0.y);
    L5:
        if (r6 == false) goto L8;
        r0.v = r0.E3();
        return;
    L8:
        if (r0.v == false) goto L22;
        r0.W3();
        va8.o r7 = r0.B3();
        if (r7 == null) goto L13;
        r7.E40();
    L13:
        ICoreInputAbility r8 = r0.C3();
        if (r8 == null) goto L16;
        ICoreInputAbility.b.e(r8, "core_full_screen_edit_close", null, false, 6);
    L16:
        ChatConstraintLayout r9 = r0.n;
        if (r9 == null) goto L21;
        r9.postDelayed(r0.y, 350);
        return;
    L21:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
