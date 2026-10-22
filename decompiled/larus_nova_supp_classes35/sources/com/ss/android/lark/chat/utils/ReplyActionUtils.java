package com.ss.android.lark.chat.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReplyActionUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/utils/ReplyActionUtils$ReplyStyle;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PARTIAL_REPLY", "FULL_REPLY", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReplyStyle extends Enum<ReplyStyle> {
        public static final ReplyStyle FULL_REPLY = null;
        public static final ReplyStyle PARTIAL_REPLY = null;
        public static final /* synthetic */ ReplyStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<ReplyStyle> getEntries() {
            return b;
        }

        static {
            ReplyStyle r0 = new ReplyStyle("PARTIAL_REPLY", 0, 0);
            PARTIAL_REPLY = r0;
            ReplyStyle r1 = new ReplyStyle("FULL_REPLY", 1, 1);
            FULL_REPLY = r1;
            ReplyStyle[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ReplyStyle[] values() {
            return (ReplyStyle[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ReplyStyle valueOf(String r1) {
            return (ReplyStyle) r27.a.a(ReplyStyle.class, r1);
        }

        public ReplyStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Message.Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[PartialReplyInfo.PartialContentRelativePosition.values().length];
            r1[PartialReplyInfo.PartialContentRelativePosition.HEAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[PartialReplyInfo.PartialContentRelativePosition.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[PartialReplyInfo.PartialContentRelativePosition.TAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean c() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.part_reply");
        Log.i("ReplyActionUtils", "fg:im.messenger.part_reply is: " + r0);
        return r0;
    }

    @JvmStatic
    public static final void a(RichText r1) {
        if (r1 == null) goto L4;
        RichTextExtraInfo r0 = r1.getExtraInfo();
    L5:
        if (r0 != null) goto L9;
        if (r1 == null) goto L10;
        r1.setExtraInfo(new RichTextExtraInfo());
        return;
    L10:
        return;
    L9:
        return;
    L4:
        r0 = null;
        goto L5
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo e(PartialReplyInfo r2) {
        com.bytedance.lark.pb.basic.v1.RichText r0 = null;
        if (r2 == null) goto L5;
        RichText r1 = r2.getContent();
    L6:
        if (r1 == null) goto L8;
        RichText r3 = r2.getContent();
        if (r3 == null) goto L18;
        Intrinsics.checkNotNullParameter(r3, "richText");
        r0 = ChatCoreModule.a().getChatDependency().i(r3);
    L18:
        PartialReplyInfo.PartialContentRelativePosition r4 = r2.getPosition();
        if (r4 == null) goto L21;
        int r5 = r4.getNumber();
    L23:
        return new com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo(r0, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo.PartialContentRelativePosition.fromValue(r5));
    L21:
        r5 = com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo.PartialContentRelativePosition.UNKNOWN.getValue();
        goto L23
    L8:
        if (r2 == null) goto L12;
        PartialReplyInfo.PartialContentRelativePosition r6 = r2.getPosition();
        if (r6 == null) goto L12;
        int r7 = r6.getNumber();
    L14:
        return new com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo(null, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo.PartialContentRelativePosition.fromValue(r7));
    L12:
        r7 = com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo.PartialContentRelativePosition.UNKNOWN.getValue();
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final CharSequence b(CharSequence r4, PartialReplyInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "charSequence");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
        if (r5 == null) goto L8;
        PartialReplyInfo.PartialContentRelativePosition r0 = r5.getPosition();
    L9:
        if (r0 == null) goto L11;
        SpannableStringBuilder r1 = new SpannableStringBuilder(r4);
        PartialReplyInfo.PartialContentRelativePosition r6 = r5.getPosition();
        if (r6 != null) goto L15;
        int r7 = -1;
    L17:
        if (r7 != 1) goto L19;
        r1.insert(r1.length(), "...");
        return StringsKt.trim(r1);
    L19:
        if (r7 != 2) goto L21;
        r1.insert(0, "...");
        r1.insert(r1.length(), "...");
        return StringsKt.trim(r1);
    L21:
        if (r7 != 3) goto L23;
        r1.insert(0, "...");
        return StringsKt.trim(r1);
    L23:
        return StringsKt.trim(new SpannableStringBuilder(r4));
    L15:
        r7 = a.b[r6.ordinal()];
        goto L17
    L11:
        return StringsKt.trim(new SpannableStringBuilder(r4));
    L8:
        r0 = null;
        goto L9
    L5:
        return StringsKt.trim(new SpannableStringBuilder(r4));
    }

    @JvmStatic
    public static final PartialReplyInfo d(y6b.a<?> r5, Message.Type r6) {
        Intrinsics.checkNotNullParameter(r6, "messageType");
        int r0 = a.a[r6.ordinal()];
        PartialReplyInfo.PartialContentRelativePosition r1 = null;
        if (r0 != 1) goto L5;
        Object r7 = r5.b();
        if ((r7 instanceof PostContentVO) == false) goto L33;
        PostContentVO r8 = (PostContentVO) r7;
    L34:
        if (r8 == null) goto L43;
        h7b.l.d(r8);
        if (TextUtils.isEmpty(com.ss.android.lark.widget.codeblock.entity.a.c(b7b.b.d(b7b.b.e(r8.u), ((PostContent) r8.a).getDocEntityMap(), r8.C))) == true) goto L38;
        Log.i("ReplyActionUtils", "PostContentVO is not null and partialReplySelectText is not null.");
        RichText r9 = IMRichTextCopyUtils.h(IMRichTextCopyUtils.f(r8.u), r5);
    L44:
        Object r10 = r5.b();
        if ((r10 instanceof PostContentVO) == false) goto L47;
        PostContentVO r11 = (PostContentVO) r10;
    L48:
        if (r11 == null) goto L51;
        r1 = r11.v;
    L51:
        return new PartialReplyInfo(r9, r1);
    L47:
        r11 = null;
        goto L48
    L38:
        Log.i("ReplyActionUtils", "PostContentVO is not null and partialReplySelectText is null.");
        r9 = IMRichTextCopyUtils.h(IMRichTextCopyUtils.f(r8.u), r5);
        if (r9 == null) goto L44;
        RichTextExtraInfo r2 = r9.getExtraInfo();
        if (r2 == null) goto L44;
        r2.setPartialReplySelectTextEmpty(Boolean.TRUE);
        goto L44
    L43:
        Log.i("ReplyActionUtils", "PostContentVO is null.");
        r9 = null;
        goto L44
    L33:
        r8 = null;
        goto L34
    L5:
        if (r0 == 2) goto L8;
        Log.e("ReplyActionUtils", "partial reply only supports message type post or text, current message type is " + r6 + '.');
        return null;
    L8:
        Object r12 = r5.b();
        if ((r12 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L11;
        com.ss.android.lark.chat.base.view.vo.message.e r13 = (com.ss.android.lark.chat.base.view.vo.message.e) r12;
    L12:
        if (r13 == null) goto L21;
        h7b.l.d(r13);
        if (TextUtils.isEmpty(com.ss.android.lark.widget.codeblock.entity.a.c(b7b.b.d(b7b.b.e(r13.u), ((TextContent) r13.a).getDocEntityMap(), r13.C))) == true) goto L16;
        Log.i("ReplyActionUtils", "TextContentVO is not null and partialReplySelectText is not null.");
        RichText r14 = IMRichTextCopyUtils.h(IMRichTextCopyUtils.f(r13.u), r5);
    L22:
        Object r15 = r5.b();
        if ((r15 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L25;
        com.ss.android.lark.chat.base.view.vo.message.e r16 = (com.ss.android.lark.chat.base.view.vo.message.e) r15;
    L26:
        if (r16 == null) goto L29;
        r1 = r16.v;
    L29:
        return new PartialReplyInfo(r14, r1);
    L25:
        r16 = null;
        goto L26
    L16:
        Log.i("ReplyActionUtils", "TextContentVO is not null and partialReplySelectText is null.");
        r14 = IMRichTextCopyUtils.h(IMRichTextCopyUtils.f(r13.u), r5);
        if (r14 == null) goto L22;
        RichTextExtraInfo r3 = r14.getExtraInfo();
        if (r3 == null) goto L22;
        r3.setPartialReplySelectTextEmpty(Boolean.TRUE);
        goto L22
    L21:
        Log.i("ReplyActionUtils", "TextContentVO is null.");
        r14 = null;
        goto L22
    L11:
        r13 = null;
        goto L12
    }
}
