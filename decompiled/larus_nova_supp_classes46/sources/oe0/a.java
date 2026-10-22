package oe0;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        b r0 = this.a;
        r0.c((EnlargeGuestInfo) r2);
    }
}
