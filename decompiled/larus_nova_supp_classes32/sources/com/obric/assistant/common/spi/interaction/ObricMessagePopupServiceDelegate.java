package com.obric.assistant.common.spi.interaction;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0001J\u001d\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u001d\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/common/spi/interaction/ObricMessagePopupServiceDelegate;", "Lcom/obric/assistant/common/spi/interaction/IObricMessagePopupService;", "<init>", "()V", "filterMessageMenuItemsIfNeeded", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "menuItems", NameKeys.UnloadStrategy_No_Strategy, "markNextDropdownRewriteIfNeeded", "anchor", "Landroid/view/View;", "popupWindow", "Landroid/widget/PopupWindow;", "prepareFollowClickMenuBeforeShow", NameKeys.UnloadStrategy_No_Strategy, "menuView", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessagePopupServiceDelegate implements IObricMessagePopupService {
    public static final ObricMessagePopupServiceDelegate b = null;
    public final /* synthetic */ IObricMessagePopupService a;

    static {
        b = new ObricMessagePopupServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void filterMessageMenuItemsIfNeeded(Context r2, List<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        this.a.filterMessageMenuItemsIfNeeded(r2, r3);
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void markNextDropdownRewriteIfNeeded(View r2, PopupWindow r3) {
        this.a.markNextDropdownRewriteIfNeeded(r2, r3);
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final boolean prepareFollowClickMenuBeforeShow(View r2, View r3) {
        return this.a.prepareFollowClickMenuBeforeShow(r2, r3);
    }

    private ObricMessagePopupServiceDelegate() {
        IObricMessagePopupService r0 = (IObricMessagePopupService) ServiceManager.get().getService(IObricMessagePopupService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricMessagePopupServiceImpl();
    L5:
        this.a = r0;
    }
}
