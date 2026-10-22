package yfa;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.obric.assistant.special_input.ObricSpecialInputServiceDelegate;
import com.obric.assistant.spi.actionbar.ObricSpecialInputType;
import kotlin.jvm.internal.Intrinsics;
import up8.b;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends b {
    public final boolean a() {
        return true;
    }

    public final /* bridge */ /* synthetic */ String g() {
        return null;
    }

    public final void k(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "defaultStateTemplate");
    }

    public int getType() {
        return ObricSpecialInputType.SPECIAL_INPUT.getType();
    }

    public a() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r3 = ObricSpecialInputServiceDelegate.b.b(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.bmhome.instruction.base.AbsInstructionWidget");
        return (AbsInstructionWidget) r3;
    }

    public final a0 n(String r3) {
        return new a0(Boolean.TRUE, "text list selector is empty template");
    }
}
