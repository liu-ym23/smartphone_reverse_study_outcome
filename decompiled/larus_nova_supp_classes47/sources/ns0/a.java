package ns0;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    ps0.c getPersonCardData(String r1);

    void noticeAnchorSetButtonClick();

    void noticeGroupPurchaseShowing(View r1);

    void openTransitionDialog();

    void prepareTransitionDialogRequest(Context r1, String r2);

    void setPersonCardData(String r1, ps0.c r2);

    boolean showAnchorSetButtonRedDot();
}
