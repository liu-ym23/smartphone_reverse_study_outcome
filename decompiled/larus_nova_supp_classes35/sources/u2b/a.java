package u2b;

import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a implements y6b.d<AudioContentVO> {
    public a() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.AUDIO;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return UIHelper.getString(2131891532);
    }

    @Override // y6b.d
    public final v5b.a c(v r4, f5b.b r5) {
        Intrinsics.checkNotNullParameter(r4, "containerOwner");
        Intrinsics.checkNotNullParameter(r5, "messageInfo");
        Message r6 = r5.getMessage();
        AudioContent r0 = (AudioContent) r6.getContent();
        AudioContentVO r1 = new AudioContentVO(r0);
        r1.t = r0.getLocalFilePath();
        r1.v = r0.getAudioWaveBytes();
        r1.u = r0.getProgress();
        r1.w = r6.isSourceFileDelete();
        r1.x = r6.getReadAtChatterIds();
        r1.y = r6.getAtBotIds();
        r1.b = r6.getTranslateLanguage();
        r1.e = r6.isAutoTranslatedForReceiver();
        r1.f = r6.getTranslateDisplayRule();
        r1.c = r5.isTranslating();
        TranslateInfo r7 = r5.getTranslateInfo();
        if (r7 == null) goto L7;
        AudioContent r8 = (AudioContent) r7.getTranslateContent();
        if (r8 == null) goto L7;
        AudioContentVO r2 = new AudioContentVO(r8);
        r2.b = r7.getLanguage();
        r1.g = r2;
    L7:
        TextContent r9 = new TextContent();
        r9.setRichText((RichText) r1.o.getValue());
        r1.h = new com.ss.android.lark.chat.base.view.vo.message.e(r9);
        return r1;
    }
}
