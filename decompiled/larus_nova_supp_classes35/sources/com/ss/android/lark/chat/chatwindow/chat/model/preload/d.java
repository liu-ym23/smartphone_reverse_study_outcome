package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final ConcurrentHashMap<String, Boolean> a = null;

    public static final class a {
    }

    public static final class b implements Function1<f5b.b, f5b.b> {
        public b() {
        }

        public final Object invoke(Object r3) {
            f5b.b r4 = (f5b.b) r3;
            if (r4 != null) goto L5;
        L7:
            return r4;
        L5:
            if (r4.getMessage().getType() != Message.Type.STICKER) goto L7;
            Content r0 = r4.getMessage().getContent();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.StickerContent");
            ((StickerContent) r0).setAdded(true);
            goto L7
        }
    }

    static {
        a = new ConcurrentHashMap();
    }
}
