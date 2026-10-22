package u2b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.service.impl.a1;
import com.ss.android.lark.chat.utils.UrlTranslateUtils;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements y6b.d<com.ss.android.lark.chat.base.view.vo.message.c> {
    public l() {
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.MERGE_FORWARD;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Content r3 = r2.getMessage().getContent();
        if ((r3 instanceof MergeForwardContent) == false) goto L5;
        MergeForwardContent r4 = (MergeForwardContent) r3;
    L6:
        String r5 = a1.a(r4).a;
        if (com.ss.android.lark.message.lynxcard.message.r.a(r5) == false) goto L10;
        Intrinsics.checkNotNull(r5);
        return r5;
    L10:
        return UIHelper.getString(2131891921);
    L5:
        r4 = null;
        goto L6
    }

    @Override // y6b.d
    public final v5b.a c(v r14, f5b.b r15) {
        Intrinsics.checkNotNullParameter(r14, "containerOwner");
        Intrinsics.checkNotNullParameter(r15, "messageInfo");
        Message r16 = r15.getMessage();
        Content r0 = r16.getContent();
        MergeForwardContent r2 = null;
        if ((r0 instanceof MergeForwardContent) == false) goto L5;
        MergeForwardContent r1 = (MergeForwardContent) r0;
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.isFromPrivateTopic() == true) goto L61;
        com.ss.android.lark.chat.base.view.vo.message.c r3 = new com.ss.android.lark.chat.base.view.vo.message.c(r1);
        r3.h = r16;
        r3.f = r16.getTranslateDisplayRule();
        r3.c = r15.isTranslating();
        r3.d = r16.isTranslatedManually();
        r3.b = r16.getTranslateLanguage();
        TranslateInfo r17 = r15.getTranslateInfo();
        if (r17 == null) goto L45;
        com.ss.android.lark.chat.base.view.vo.message.c r4 = new com.ss.android.lark.chat.base.view.vo.message.c((MergeForwardContent) r17.getTranslateContent());
        r4.b = r17.getLanguage();
        r3.g = r4;
        ChatAppContainerV1 r18 = ChatAppContainerV1.a;
        ITranslateService r5 = r18.x();
        com.ss.android.lark.translate.service.impl.a r19 = r18.A();
        boolean r6 = false;
        if (r15.getTranslateInfo() != null) goto L16;
    L42:
        if (r6 == false) goto L45;
        new UrlTranslateUtils(r5, r19).a(r15);
        goto L45
    L16:
        if ((r15.getMessage().getContent() instanceof MergeForwardContent) == false) goto L42;
        List<Message> r7 = ((MergeForwardContent) r15.getTranslateInfo().getTranslateContent()).getMessages();
        MergeForwardContent r8 = (MergeForwardContent) r15.getMessage().getContent();
        if (CollectionUtils.isEmpty(r7) == true) goto L42;
        int r9 = 0;
        boolean r10 = false;
    L21:
        if (r9 >= r7.size()) goto L41;
        Message r11 = (Message) ListProtector.get(r7, r9);
        String r12 = r11.getId();
        List<Message> r13 = r8.getMessages();
        if (CollectionUtils.isEmpty(r13) == true) goto L31;
        int r110 = 0;
    L26:
        if (r110 >= r13.size()) goto L31;
        if (((Message) ListProtector.get(r13, r110)).getId().equals(r12) == true) goto L29;
        r110 = r110 + 1;
        goto L26
    L29:
        Message r20 = (Message) ListProtector.get(r13, r110);
    L32:
        Content r21 = r11.getContent();
        if ((r21 instanceof TextContent) == false) goto L35;
    L36:
        if (r20 == null) goto L40;
        if (h0.a(r21, ((BaseTextContent) r20.getContent()).getPreviewHangPoints(), r15.getTranslateInfo().getLanguage()) == false) goto L40;
        r10 = true;
    L40:
        r9 = r9 + 1;
        goto L21
    L35:
        if ((r21 instanceof PostContent) == false) goto L40;
    L31:
        r20 = null;
        goto L32
    L41:
        r6 = r10;
    L45:
        if (r3.e() == false) goto L49;
        v5b.a r111 = r3.g;
        if (r111 == null) goto L51;
        Object r112 = r111.a;
    L50:
        r2 = (MergeForwardContent) r112;
    L51:
        r3.i = a1.a(r2);
        return r3;
    L49:
        r112 = r3.a;
        goto L50
    L61:
        return null;
    L5:
        r1 = null;
        goto L6
    }
}
