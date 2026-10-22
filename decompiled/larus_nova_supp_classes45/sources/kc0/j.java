package kc0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface j extends k, dy0.c {
    r createRevMultiControlWidget(r.a r1, ViewGroup r2, Boolean r3, boolean r4);

    Class<? extends Widget> getAnchorTicketWidgetClass();

    qc0.f getInteractFeedView(Context r1, pc0.a r2, int r3, d r4);

    Class<? extends Widget> getProfitInteractionWidgetClass();

    void notifyAudienceEngineEvent();
}
