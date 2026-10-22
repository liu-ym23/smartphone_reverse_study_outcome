package com.obric.assistant.common.spi.interaction;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/common/spi/interaction/IObricMessagePopupService;", NameKeys.UnloadStrategy_No_Strategy, "filterMessageMenuItemsIfNeeded", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "menuItems", NameKeys.UnloadStrategy_No_Strategy, "prepareFollowClickMenuBeforeShow", NameKeys.UnloadStrategy_No_Strategy, "anchor", "Landroid/view/View;", "menuView", "markNextDropdownRewriteIfNeeded", "popupWindow", "Landroid/widget/PopupWindow;", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricMessagePopupService {
    void filterMessageMenuItemsIfNeeded(Context r1, List<?> r2);

    void markNextDropdownRewriteIfNeeded(View r1, PopupWindow r2);

    boolean prepareFollowClickMenuBeforeShow(View r1, View r2);
}
