package com.zte.miboard.cards;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface CardCallback {
    boolean isContentReady();

    void onDestroy();

    Bundle onParentPopupMenuItemClick(View r5, Bundle r10);

    void onPause(boolean r5);

    void onRefresh();

    void onResume(boolean r5);

    void onSlideIn();

    void onSlideOut();

    void setCardParentCallback(CardParentCallback r5);
}
