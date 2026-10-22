package com.ss.android.lark.forwardv3.configuration;

import com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig$setForwardNoteListener$1", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardNoteListener$Stub;", "onSuccess", "", "noteMessageId", "", "chatId", "parentId", "onFailed", "errorTitle", "errorMessage", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardAdditionNoteConfig$setForwardNoteListener$1 extends RemoteOnForwardNoteListener.Stub {
    final /* synthetic */ oib.d $listener;

    public ForwardAdditionNoteConfig$setForwardNoteListener$1(oib.d r1) {
        this.$listener = r1;
    }

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener
    public void onFailed(String r2, String r3) {
        this.$listener.onFailed(r2, r3);
    }

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener
    public void onSuccess(String r2, String r3, String r4) {
        this.$listener.onSuccess(r2, r3, r4);
    }
}
