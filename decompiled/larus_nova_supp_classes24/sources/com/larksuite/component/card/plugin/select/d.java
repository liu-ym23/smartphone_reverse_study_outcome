package com.larksuite.component.card.plugin.select;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ MultiSelectMenuAdapter a;
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> b;

    public d(MultiSelectMenuAdapter r1, List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r5 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.a.l, r4);
        boolean r0 = !r5.isSelected;
        r5.isSelected = r0;
        if (r0 == false) goto L5;
    L7:
        List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r1 = this.b;
        ListProtector.add(r1, r1.size(), r5);
    L8:
        this.a.notifyItemChanged(r4);
        return;
    L5:
        if (this.b.contains(r5) == false) goto L7;
        this.b.remove(r5);
        goto L8
    }
}
