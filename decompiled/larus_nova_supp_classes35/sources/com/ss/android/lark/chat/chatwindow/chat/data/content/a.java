package com.ss.android.lark.chat.chatwindow.chat.data.content;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends MessageContentResolver {
    public static final a b = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.content.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0037a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = new a();
    }

    public a() {
    }

    public final String a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Message.Type r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        Content r4 = r3.getContent();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        return ((TextContent) r4).getText();
    L9:
        if (r1 == 2) goto L15;
        return BuildConfig.FLAVOR;
    L15:
        return ((PostContent) r3.getContent()).getText();
    L5:
        r1 = C0037a.a[r0.ordinal()];
        goto L7
    }
}
