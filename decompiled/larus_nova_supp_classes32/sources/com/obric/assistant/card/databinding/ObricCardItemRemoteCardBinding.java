package com.obric.assistant.card.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemRemoteCardBinding implements ViewBinding {
    public final RemoteCardContainer a;
    public final RemoteCardContainer b;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemRemoteCardBinding(RemoteCardContainer r1, RemoteCardContainer r2) {
        this.a = r1;
        this.b = r2;
    }
}
