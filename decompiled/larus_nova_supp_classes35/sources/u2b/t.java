package u2b;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements y6b.d<com.ss.android.lark.chat.base.view.vo.message.g> {
    public t() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.UNKNOWN;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        Content r4 = r3.getMessage().getContent();
        String r1 = null;
        if ((r4 instanceof TextContent) == false) goto L5;
        TextContent r5 = (TextContent) r4;
    L6:
        if (r5 == null) goto L17;
        RichText r6 = r5.getRichText();
        if (r6 == null) goto L17;
        String r7 = r6.getInnerText();
        if (r7 == null) goto L17;
        if ((!StringsKt.isBlank(r7)) == false) goto L14;
        r1 = r7;
    L14:
        if (r1 == null) goto L17;
        return r1;
    L17:
        return UIHelper.mustacheFormat(2131892299);
    L5:
        r5 = null;
        goto L6
    }

    public static com.ss.android.lark.chat.base.view.vo.message.g e(v r1, f5b.b r2) {
        Intrinsics.checkNotNullParameter(r1, "containerOwner");
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Content r3 = r2.getMessage().getContent();
        String r0 = null;
        if ((r3 instanceof TextContent) == false) goto L5;
        TextContent r4 = (TextContent) r3;
    L6:
        com.ss.android.lark.chat.base.view.vo.message.g r5 = new com.ss.android.lark.chat.base.view.vo.message.g();
        if (r4 == null) goto L11;
        RichText r6 = r4.getRichText();
        if (r6 == null) goto L11;
        r0 = r6.getInnerText();
    L11:
        r5.b = r0;
        return r5;
    L5:
        r4 = null;
        goto L6
    }

    @Override // y6b.d
    public final /* bridge */ /* synthetic */ v5b.a c(v r1, f5b.b r2) {
        return e(r1, r2);
    }
}
