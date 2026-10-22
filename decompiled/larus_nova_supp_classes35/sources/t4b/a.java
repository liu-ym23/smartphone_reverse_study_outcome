package t4b;

import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends MessageContentResolver {
    public static final a b = null;

    /* JADX INFO: renamed from: t4b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0300a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
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
        if (r1 != 1) goto L11;
        int r2 = u4b.a.c;
        Content r4 = u4b.a.b.a.b(r3);
        if ((r4 instanceof TextContent) == false) goto L11;
        return ((TextContent) r4).getText();
    L11:
        return BuildConfig.FLAVOR;
    L5:
        r1 = C0300a.a[r0.ordinal()];
        goto L7
    }
}
