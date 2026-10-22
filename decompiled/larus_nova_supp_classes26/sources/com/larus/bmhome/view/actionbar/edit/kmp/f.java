package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final Map<String, AbsKmpInstructionWidget> a;
    public final Function0<Unit> b;
    public final Function0<Context> c;
    public final Function0<y> d;
    public final Function0<com.larus.bmhome.instruction.g> e;
    public final Function0<ICoreInputAbility> f;
    public final Function0<va8.o> g;
    public final AttachReceiver h;
    public final Function1<com.larus.bmhome.actionbar.model.c, Map<String, String>> i;

    public f(Map r2, Function0 r3, k r4, Function0 r5, Function0 r6, Function0 r7, Function0 r8, AttachReceiver r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r2, "widgetByEntryId");
        Intrinsics.checkNotNullParameter(r3, "closeInstructionPanelAndEditor");
        Intrinsics.checkNotNullParameter(r4, "uiContext");
        Intrinsics.checkNotNullParameter(r5, "chatConversationAbility");
        Intrinsics.checkNotNullParameter(r6, "instructionInputAbility");
        Intrinsics.checkNotNullParameter(r7, "coreInputAbility");
        Intrinsics.checkNotNullParameter(r8, "chatInputUICoreAbility");
        Intrinsics.checkNotNullParameter(r9, "attachReceiver");
        Intrinsics.checkNotNullParameter(r10, "parseQueryExt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
