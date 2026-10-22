package u2b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements y6b.d<PostContentVO> {
    public boolean a;

    public m() {
        this.a = true;
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.POST;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        PartialReplyInfo r0 = r2.getMessage().getPartialReplyInfo();
        if (r0 == null) goto L5;
        RichText r1 = r0.getContent();
    L6:
        ReplyActionUtils.a(r1);
        CharSequence r3 = com.ss.android.lark.widget.richtext.i.j(r1);
        Intrinsics.checkNotNull(r3);
        return ReplyActionUtils.b(r3, r2.getMessage().getPartialReplyInfo());
    L5:
        r1 = null;
        goto L6
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r6) {
        Intrinsics.checkNotNullParameter(r6, "messageInfo");
        boolean r1 = true;
        boolean r0 = !r6.isShowMessageOriginContent();
        if (r6.getMessage().getTranslateDisplayRule() != 3) goto L5;
        boolean r2 = true;
    L6:
        if (r0 == false) goto L10;
        if (r2 == true) goto L10;
        r1 = false;
    L10:
        Content r3 = r6.getTranslateContent(r1);
        List r4 = null;
        if ((r3 instanceof PostContent) == false) goto L13;
        PostContent r5 = (PostContent) r3;
    L14:
        PostContent r7 = (PostContent) r6.getMessage().getContent();
        Context r8 = ChatCoreModule.a().getContext();
        if (r5 == null) goto L17;
        Intrinsics.checkNotNull(r8);
        String r9 = r5.getTitleWithFilter(r8);
    L19:
        if (TextUtils.isEmpty(r9) == false) goto L24;
        if (r5 == null) goto L22;
        RichText r10 = r5.getRichText();
    L23:
        CharSequence r11 = com.ss.android.lark.widget.richtext.i.j(r10);
    L27:
        SpannableStringBuilder r12 = new SpannableStringBuilder();
        if (r1 == true) goto L30;
        r12.append(UIHelper.getString(2131892287));
    L30:
        if (r5 == null) goto L32;
        r4 = r5.getAttachments();
    L32:
        if (r4 != null) goto L34;
        r4 = CollectionsKt.emptyList();
    L34:
        List r13 = r7.getAttachments();
        if (r13 != null) goto L37;
        r13 = CollectionsKt.emptyList();
    L37:
        r12.append(com.ss.android.lark.chat.utils.e.a(r11, r4, r13));
        return r12;
    L22:
        r10 = null;
        goto L23
    L24:
        if (r5 == null) goto L26;
        Intrinsics.checkNotNull(r8);
        r11 = r5.getTitleWithFilter(r8);
        goto L27
    L26:
        r11 = null;
        goto L27
    L17:
        r9 = null;
        goto L19
    L13:
        r5 = null;
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    @Override // y6b.d
    public final v5b.a c(v r8, f5b.b r9) {
        Intrinsics.checkNotNullParameter(r8, "containerOwner");
        Intrinsics.checkNotNullParameter(r9, "messageInfo");
        Message r10 = r9.getMessage();
        PostContent r0 = (PostContent) r10.getContent();
        PostContentVO r1 = new PostContentVO(r0);
        List<String> r2 = r9.getMessage().getAtBotIds();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.n = r2;
        List<String> r3 = r10.getReadAtChatterIds();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.o = r3;
        DocResult r4 = r0.getDocResult();
        if (r4 == null) goto L5;
        r1.i = r4;
    L5:
        List<MessageUrlPreview> r5 = r0.getUrlPreviewList();
        if (r5 != null) goto L8;
    L14:
        Map<String, PreviewHangPoint> r6 = r0.getPreviewHangPoints();
        if (CollectionUtils.isEmpty(r6) == true) goto L18;
        r1.j = (PreviewHangPoint) ListProtector.get(new ArrayList(r6.values()), 0);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.C = r6;
    L18:
        if (this.a == false) goto L20;
        r1.z = r0.getContentLayout();
        r1.A = r0.getNeedReParseLayout();
    L20:
        r1.b = r9.getMessage().getTranslateLanguage();
        r1.c = r9.isTranslating();
        r1.e = r10.isAutoTranslatedForReceiver();
        r1.f = r9.getMessage().getTranslateDisplayRule();
        TranslateInfo r11 = r9.getTranslateInfo();
        if (r11 == null) goto L30;
        d0 r12 = h7b.l.a;
        if (r0.isGroupAnnouncement() == true) goto L30;
        PostContent r13 = (PostContent) r11.getTranslateContent();
        if (r13 == null) goto L30;
        PostContentVO r7 = new PostContentVO(r13);
        r7.b = r11.getLanguage();
        if (this.a == false) goto L29;
        r7.z = r13.getContentLayout();
        r7.A = r13.getNeedReParseLayout();
    L29:
        r1.g = r7;
    L30:
        return r1;
    L8:
        if (r5.size() != 1) goto L14;
        if (((MessageUrlPreview) ListProtector.get(r5, 0)).isDeleted() == true) goto L14;
        if (TextUtils.isEmpty(((MessageUrlPreview) ListProtector.get(r5, 0)).getTitle()) == true) goto L14;
        r1.h = (MessageUrlPreview) ListProtector.get(r5, 0);
        goto L14
    }
}
