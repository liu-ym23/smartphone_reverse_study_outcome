package u2b;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements y6b.d<com.ss.android.lark.chat.base.view.vo.message.e> {
    public boolean a;

    public static iec.g e() {
        int r0 = (int) UIHelper.sp2px(13.0f);
        int r1 = (int) UIHelper.sp2px(15.0f);
        iec.g.a r2 = new iec.g.a();
        r2.d.a = false;
        r2.e.a = true;
        r2.b(new iec.f(UIHelper.getContext(), r1, r0));
        return r2.a();
    }

    public r() {
        this.a = true;
    }

    @Override // y6b.d
    public final Message.Type a() {
        return Message.Type.TEXT;
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        PartialReplyInfo r0 = r3.getMessage().getPartialReplyInfo();
        if (r0 == null) goto L5;
        RichText r1 = r0.getContent();
    L6:
        ReplyActionUtils.a(r1);
        CharSequence r2 = com.ss.android.lark.widget.richtext.i.d(r1, e());
        Intrinsics.checkNotNull(r2);
        return ReplyActionUtils.b(r2, r3.getMessage().getPartialReplyInfo());
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
        if ((r3 instanceof TextContent) == false) goto L13;
        TextContent r5 = (TextContent) r3;
    L14:
        TextContent r7 = (TextContent) r6.getMessage().getContent();
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        if (r1 == false) goto L17;
        String r9 = BuildConfig.FLAVOR;
    L18:
        r8.append(r9);
        if (r5 == null) goto L21;
        RichText r10 = r5.getRichText();
    L22:
        CharSequence r11 = com.ss.android.lark.widget.richtext.i.d(r10, e());
        if (r5 == null) goto L25;
        r4 = r5.getAttachments();
    L25:
        if (r4 != null) goto L27;
        r4 = CollectionsKt.emptyList();
    L27:
        List r12 = r7.getAttachments();
        if (r12 != null) goto L30;
        r12 = CollectionsKt.emptyList();
    L30:
        r8.append(com.ss.android.lark.chat.utils.e.a(r11, r4, r12));
        return r8;
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = UIHelper.getString(2131892287);
        goto L18
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
        TextContent r0 = (TextContent) r10.getContent();
        com.ss.android.lark.chat.base.view.vo.message.e r1 = new com.ss.android.lark.chat.base.view.vo.message.e(r0);
        List<String> r2 = r10.getReadAtChatterIds();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.o = r2;
        List<String> r3 = r9.getMessage().getAtBotIds();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.n = r3;
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
        r1.b = r10.getTranslateLanguage();
        r1.e = r10.isAutoTranslatedForReceiver();
        r1.f = r10.getTranslateDisplayRule();
        r1.c = r9.isTranslating();
        TranslateInfo r11 = r9.getTranslateInfo();
        if (r11 == null) goto L28;
        TextContent r12 = (TextContent) r11.getTranslateContent();
        if (r12 == null) goto L28;
        com.ss.android.lark.chat.base.view.vo.message.e r7 = new com.ss.android.lark.chat.base.view.vo.message.e(r12);
        r7.b = r11.getLanguage();
        if (this.a == false) goto L27;
        r7.z = r12.getContentLayout();
        r7.A = r12.getNeedReParseLayout();
    L27:
        r1.g = r7;
    L28:
        return r1;
    L8:
        if (r5.size() != 1) goto L14;
        if (((MessageUrlPreview) ListProtector.get(r5, 0)).isDeleted() == true) goto L14;
        if (TextUtils.isEmpty(((MessageUrlPreview) ListProtector.get(r5, 0)).getTitle()) == true) goto L14;
        r1.h = (MessageUrlPreview) ListProtector.get(r5, 0);
        goto L14
    }
}
