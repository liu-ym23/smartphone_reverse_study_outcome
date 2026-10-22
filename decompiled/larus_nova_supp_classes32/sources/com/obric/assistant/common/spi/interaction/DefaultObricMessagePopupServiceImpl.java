package com.obric.assistant.common.spi.interaction;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/common/spi/interaction/DefaultObricMessagePopupServiceImpl;", "Lcom/obric/assistant/common/spi/interaction/IObricMessagePopupService;", "<init>", "()V", "filterMessageMenuItemsIfNeeded", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "menuItems", NameKeys.UnloadStrategy_No_Strategy, "prepareFollowClickMenuBeforeShow", NameKeys.UnloadStrategy_No_Strategy, "anchor", "Landroid/view/View;", "menuView", "markNextDropdownRewriteIfNeeded", "popupWindow", "Landroid/widget/PopupWindow;", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricMessagePopupServiceImpl implements IObricMessagePopupService {
    public DefaultObricMessagePopupServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void filterMessageMenuItemsIfNeeded(Context r1, List<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItems");
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void markNextDropdownRewriteIfNeeded(View r1, PopupWindow r2) {
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final boolean prepareFollowClickMenuBeforeShow(View r1, View r2) {
        return true;
    }
}
