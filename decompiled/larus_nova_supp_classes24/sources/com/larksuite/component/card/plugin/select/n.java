package com.larksuite.component.card.plugin.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ Function1<UniversalCardShowSelectMenuPluginModel$OptionsItemModel, Unit> a;
    public final /* synthetic */ UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel b;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r3) {
        this.a.invoke(ListProtector.get(this.b.options, r3));
    }

    public n(com.larksuite.component.card.plugin.e r1, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
