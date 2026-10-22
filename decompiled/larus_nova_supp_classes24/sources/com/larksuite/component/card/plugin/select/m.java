package com.larksuite.component.card.plugin.select;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1<UniversalCardShowSelectMenuPluginModel$OptionsItemModel, Unit> a;
    public final /* synthetic */ SelectMenuAdapter b;

    public m(com.larksuite.component.card.plugin.e r1, SelectMenuAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.invoke(ListProtector.get(this.b.l, r3));
    }
}
