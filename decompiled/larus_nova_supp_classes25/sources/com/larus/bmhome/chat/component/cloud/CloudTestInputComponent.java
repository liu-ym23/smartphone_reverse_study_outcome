package com.larus.bmhome.chat.component.cloud;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.d;
import com.larus.network.http.e;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import pd8.a;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/component/cloud/CloudTestInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "Lkotlin/Lazy;", "onParentViewCreated", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CloudTestInputComponent extends ComponentFeature {
    public final Lazy h;

    public final void B2() {
        FLogger r0 = FLogger.a;
        String r1 = d.a;
        StringBuilder r2 = new StringBuilder("disableInputText = ");
        e r3 = d.h;
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.e);
    L6:
        r2.append(r4);
        r0.i("CloudTest", r2.toString());
        e r5 = d.h;
        boolean r6 = false;
        if (r5 != null) goto L9;
    L11:
        if (r6 == false) goto L16;
        o r7 = (o) this.h.getValue();
        if (r7 == null) goto L17;
        r7.setVisibility(8);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        if (r5.e != true) goto L11;
        r6 = true;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public CloudTestInputComponent() {
        this.h = LazyKt.lazy(new a(this));
    }
}
