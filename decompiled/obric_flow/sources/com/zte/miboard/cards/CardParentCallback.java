package com.zte.miboard.cards;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface CardParentCallback {
    Bundle onCardContentViewLongClick(View r5, Bundle r10);

    void onContentStateChanged();
}
