package vy8;

import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.chat.gallery.api.bean.GalleryChatType;
import com.larus.chat.gallery.api.datasource.BaseChatDataSource;
import com.larus.chat.gallery.datasource.ChatGalleryDataHelper;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.k;
import com.larus.gallery.api.m;
import com.larus.gallery.api.q;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ty8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends BaseChatDataSource<b> {
    public final ty8.a i;

    @Override // com.larus.chat.gallery.api.datasource.BaseChatDataSource
    public final int l() {
        return this.i.i;
    }

    @Override // com.larus.chat.gallery.api.datasource.BaseChatDataSource
    public final List<Message> m() {
        Function0<List<Message>> r0 = this.i.j;
        if (r0 == null) goto L6;
        List<Message> r1 = (List) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        q0 r2 = this.i.e;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getCurrentList();
    }

    public a(ty8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "galleryContext");
        super(CollectionsKt.listOf(GalleryChatType.CHAT_SEND), r3.b);
        this.i = r3;
    }

    public final Object i(Object r26, Continuation r27) {
        b r0 = (b) r26;
        GalleryType r2 = r0.e;
        m1 r1 = r0.b;
        if (r1 == null) goto L5;
        String r10 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r11 = r1.b;
    L9:
        if (r1 == null) goto L11;
        Integer r12 = r1.d;
    L12:
        if (r1 == null) goto L14;
        Integer r13 = r1.e;
    L16:
        return new k(r2, new m(r10, r11, r12, r13, null, null, null, 496), new q(UUID.randomUUID().toString(), r0.c, 0, null, null, 60), null, r0.a, 8);
    L14:
        r13 = null;
        goto L16
    L11:
        r12 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.larus.chat.gallery.api.datasource.BaseChatDataSource
    public final Object o(Message r3, Continuation<? super List<? extends b>> r4) {
        return ChatGalleryDataHelper.a.b(this.i, r3, r4);
    }
}
