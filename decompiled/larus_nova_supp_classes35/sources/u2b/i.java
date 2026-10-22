package u2b;

import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements y6b.d<ImageContentVO> {
    public i() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.IMAGE;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return UIHelper.getString(2131891845);
    }

    @Override // y6b.d
    public final v5b.a c(v r4, f5b.b r5) {
        Intrinsics.checkNotNullParameter(r4, "containerOwner");
        Intrinsics.checkNotNullParameter(r5, "messageInfo");
        Message r6 = r5.getMessage();
        ImageContentVO r1 = new ImageContentVO((ImageContent) r6.getContent());
        r1.b = r6.getTranslateLanguage();
        r1.e = r6.isAutoTranslatedForReceiver();
        r1.f = r6.getTranslateDisplayRule();
        r1.c = r5.isTranslating();
        TranslateInfo r7 = r5.getTranslateInfo();
        if (r7 == null) goto L7;
        ImageContent r0 = (ImageContent) r7.getTranslateContent();
        if (r0 == null) goto L7;
        ImageContentVO r2 = new ImageContentVO(r0);
        r2.b = r7.getLanguage();
        r1.g = r2;
    L7:
        r1.n = r0.c(r5);
        return r1;
    }
}
