package pgb;

import com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends aqb.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ kza.b b;

    @Override // aqb.a
    public final void a(g1 r3) {
        Intrinsics.checkNotNullParameter(r3, "pushMessageDTO");
        Message r4 = r3.a.getMessage();
        if (Intrinsics.areEqual(r4.getChatId(), this.a) == true) goto L5;
        return;
    L5:
        if (r4.getStatus() != Message.Status.DELETED) goto L12;
        kza.b r0 = this.b;
        String r5 = r4.getId();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0.a(r5);
        return;
    }

    public b(String r1, SocialGalleryRecallProvider.observer.1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
