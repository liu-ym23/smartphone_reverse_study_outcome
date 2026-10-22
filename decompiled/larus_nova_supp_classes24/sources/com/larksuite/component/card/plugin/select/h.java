package com.larksuite.component.card.plugin.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel a;
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> b;
    public final /* synthetic */ MultiSelectMenuAdapter c;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r4) {
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r0 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.a.options, r4);
        boolean r1 = !r0.isSelected;
        r0.isSelected = r1;
        if (r1 == false) goto L5;
    L7:
        List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r2 = this.b;
        int r3 = r2.size();
        Intrinsics.checkNotNull(r0);
        ListProtector.add(r2, r3, r0);
    L8:
        this.c.notifyItemChanged(r4);
        return;
    L5:
        if (this.b.contains(r0) == false) goto L7;
        this.b.remove(r0);
        goto L8
    }

    public h(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r1, List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r2, MultiSelectMenuAdapter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
