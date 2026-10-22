package vp8;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m extends g {
    public final Lazy h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    @Override // vp8.g
    public final void i() {
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) this.b.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
    L12:
        com.larus.bmhome.chat.component.bottom.multimodal.g r3 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f.getValue();
        if (r3 != null) goto L15;
    L17:
        r1 = false;
    L18:
        FLogger.a.i("VideoSummaryBizAdapter", "[onCurrentInstructionClose] supportVideoUpload:" + r1);
        if (r1 == true) goto L21;
        return;
    L21:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L33;
        this.i = false;
        ICoreInputAbility r4 = c();
        if (r4 == null) goto L25;
        r4.s20(0);
    L25:
        ICoreInputAbility r5 = c();
        if (r5 == null) goto L28;
        r5.rE();
    L28:
        ICoreInputAbility r6 = c();
        if (r6 == null) goto L34;
        r6.Rk();
        return;
    L34:
        return;
    L33:
        return;
    L15:
        if (r3.nA(null) != true) goto L17;
    L10:
        if (this.i == true) goto L12;
        return;
    L5:
        if (r0.Q1() != 22) goto L7;
        r2 = true;
        goto L8
    }

    @Override // vp8.g
    public final void n() {
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) this.b.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        com.larus.bmhome.chat.component.bottom.multimodal.g r3 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f.getValue();
        if (r3 != null) goto L13;
    L15:
        FLogger.a.i("VideoSummaryBizAdapter", "[onCurrentInstructionOpen] supportVideoUpload:" + r1 + ", albumEntranceEnabled:" + ((Boolean) this.h.getValue()).booleanValue());
        if (r1 == true) goto L18;
        return;
    L18:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L30;
        this.i = true;
        ICoreInputAbility r4 = c();
        if (r4 == null) goto L22;
        r4.s20(6);
    L22:
        ICoreInputAbility r5 = c();
        if (r5 == null) goto L25;
        r5.Dr(true);
    L25:
        com.larus.bmhome.instruction.g r6 = (com.larus.bmhome.instruction.g) this.b.getValue();
        if (r6 == null) goto L31;
        int r7 = j0.a;
        r6.onInputHintChanged(j0.d(2131910952), "VideoSummaryBizAdapter#onCurrentInstructionOpen");
        return;
    L31:
        return;
    L30:
        return;
    L13:
        if (r3.nA(null) != true) goto L15;
        r1 = true;
        goto L15
    L5:
        if (r0.Q1() != 22) goto L7;
        r2 = true;
        goto L8
    }

    public m(BaseContentWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        super(r2);
        this.h = LazyKt.lazy(new l());
    }
}
