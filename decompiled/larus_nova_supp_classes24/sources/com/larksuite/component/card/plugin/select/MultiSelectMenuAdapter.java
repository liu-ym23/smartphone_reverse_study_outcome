package com.larksuite.component.card.plugin.select;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012%\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/plugin/select/MultiSelectMenuAdapter;", "Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter;", "context", "Landroid/content/Context;", "resource", "", "getImageKey", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "imageID", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "initCheckBox", "", "position", "viewHolder", "Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter$ItemViewHolder;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class MultiSelectMenuAdapter extends SelectMenuAdapter {
    public MultiSelectMenuAdapter(Context r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "getImageKey");
        super(r2, 2131568126, r3);
    }

    @Override // com.larksuite.component.card.plugin.select.SelectMenuAdapter
    public final void B2(int r2, SelectMenuAdapter.ItemViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r4 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.l, r2);
        r3.c.setChecked(r4.isSelected);
    }
}
