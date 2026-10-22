package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenConstant$ContentShowType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h7b.l;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import w4b.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0003H\u0016J\u0013\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020\u0007H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003JU\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/MessageFullScreenLaunchData;", "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, "openApp", "Lcom/ss/android/lark/biz/im/api/OpenApp;", "messageType", BuildConfig.FLAVOR, "pageType", "Lcom/ss/android/lark/biz/im/extension/PageType;", "sequenceId", "contentData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;", "extraData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/OpenApp;ILcom/ss/android/lark/biz/im/extension/PageType;Ljava/lang/String;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;)V", "getMessageId", "()Ljava/lang/String;", "getOpenApp", "()Lcom/ss/android/lark/biz/im/api/OpenApp;", "getMessageType", "()I", "getPageType", "()Lcom/ss/android/lark/biz/im/extension/PageType;", "getSequenceId", "getContentData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;", "getExtraData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "isValid", BuildConfig.FLAVOR, "toString", "equals", "other", BuildConfig.FLAVOR, "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenLaunchData implements Serializable {
    public static final a Companion = null;
    private final ContentData contentData;
    private final ExtraData extraData;
    private Message message;
    private final String messageId;
    private final int messageType;
    private final OpenApp openApp;
    private final PageType pageType;
    private final String sequenceId;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0066a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Message.Type.values().length];
                r0[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[Message.Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[Message.Type.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MessageFullScreenLaunchData copy$default(MessageFullScreenLaunchData r5, String r6, OpenApp r7, int r8, PageType r9, String r10, ContentData r11, ExtraData r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.messageId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.openApp;
    L8:
        OpenApp r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.messageType;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.pageType;
    L14:
        PageType r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.sequenceId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.contentData;
    L20:
        ContentData r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.extraData;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.messageId;
    }

    public final OpenApp component2() {
        return this.openApp;
    }

    public final int component3() {
        return this.messageType;
    }

    public final PageType component4() {
        return this.pageType;
    }

    public final String component5() {
        return this.sequenceId;
    }

    public final ContentData component6() {
        return this.contentData;
    }

    public final ExtraData component7() {
        return this.extraData;
    }

    public final MessageFullScreenLaunchData copy(String r10, OpenApp r11, int r12, PageType r13, String r14, ContentData r15, ExtraData r16) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r13, "pageType");
        Intrinsics.checkNotNullParameter(r14, "sequenceId");
        return new MessageFullScreenLaunchData(r10, r11, r12, r13, r14, r15, r16);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.messageId, Integer.valueOf(this.messageType), this.contentData});
    }

    public final boolean isValid() {
        ContentData r0 = this.contentData;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isValid() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("messageId = ");
        r0.append(this.messageId);
        r0.append(", messageType = ");
        r0.append(this.messageType);
        r0.append(", contentDataType = ");
        ContentData r1 = this.contentData;
        if (r1 == null) goto L14;
        int r2 = r1.getContentType();
        MessageFullScreenConstant$ContentShowType.Companion.getClass();
        if (r2 != 0) goto L7;
        String r3 = "only_origin";
    L15:
        r0.append(r3);
        return r0.toString();
    L7:
        if (r2 != 1) goto L9;
        r3 = "only_translate";
        goto L15
    L9:
        if (r2 == 2) goto L11;
        r3 = "unknown";
        goto L15
    L11:
        r3 = "origin_with_translate";
        goto L15
    L14:
        r3 = "invalid";
        goto L15
    }

    public final ContentData getContentData() {
        return this.contentData;
    }

    public final ExtraData getExtraData() {
        return this.extraData;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final OpenApp getOpenApp() {
        return this.openApp;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final String getSequenceId() {
        return this.sequenceId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(MessageFullScreenLaunchData.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData");
        MessageFullScreenLaunchData r6 = (MessageFullScreenLaunchData) r5;
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L16;
        return false;
    L16:
        if (this.messageType == r6.messageType) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.contentData, r6.contentData) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setMessage(Message r1) {
        this.message = r1;
    }

    /* JADX WARN: Type inference failed for: r11v12, types: [v5b.a] */
    @JvmStatic
    public static final MessageFullScreenLaunchData parseData(y6b.a<?> r18, Chat r19, OpenApp r20, PageType r21, String r22) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r19, "chat");
        Intrinsics.checkNotNullParameter(r21, "pageType");
        Intrinsics.checkNotNullParameter(r22, "sequenceId");
        int r3 = a.C0066a.a[r18.getType().ordinal()];
        int r8 = 1;
        RichTextData r12 = null;
        if (r3 == 1) goto L105;
        if (r3 == 2) goto L63;
        if (r3 == 3) goto L8;
        return null;
    L8:
        if (r18.isPreMessage() == false) goto L10;
        String r4 = r18.getcId();
    L11:
        ContentData.a r11 = ContentData.Companion;
        if ((r18.b() instanceof f) == true) goto L15;
    L60:
        ContentData r6 = null;
    L61:
        ExtraData.Companion.getClass();
        return new MessageFullScreenLaunchData(r4, r20, 2, r21, r22, r6, ExtraData.a.a(r18, r19, r21));
    L15:
        if ((r18.b().a instanceof AudioContent) == false) goto L60;
        Lazy r13 = AudioMessageUtil.a;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r18, "<this>");
        AudioContentVO r2 = (AudioContentVO) r18.b();
        if (r2.k() == true) goto L45;
        String r14 = r2.i();
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L26:
        if (r15 == false) goto L41;
        AudioContentVO r16 = (AudioContentVO) r18.b();
        if (r16.f() <= 0) goto L30;
        long r17 = r16.f();
    L32:
        if (r16.l() == false) goto L34;
    L38:
        boolean r7 = false;
    L39:
        if (r7 == false) goto L45;
    L34:
        if (r18.isPreMessage() == true) goto L38;
        if ((System.currentTimeMillis() - (r17 * ((long) 1000))) >= 30000) goto L38;
        r7 = true;
        goto L39
    L30:
        r17 = r18.getCreateTime();
    L41:
        if (r2.w == true) goto L45;
        if (((k) AudioMessageUtil.a.getValue()).b() == false) goto L45;
        boolean r5 = true;
    L46:
        boolean r9 = !l.d((f) r18.b());
        if (r5 == false) goto L52;
        if (r9 == true) goto L50;
        int r10 = 0;
    L51:
        Integer r23 = Integer.valueOf(r10);
    L53:
        if (r23 == null) goto L60;
        int r24 = r23.intValue();
        Object r25 = r18.b();
        RichTextData.a r26 = RichTextData.Companion;
        AudioContentVO r27 = (AudioContentVO) r25;
        AudioContent r110 = (AudioContent) r27.a;
        r26.getClass();
        RichTextData r28 = RichTextData.a.a(r110);
        v5b.a r29 = r27.g;
        if (r29 == null) goto L59;
        AudioContent r30 = (AudioContent) r29.a;
        if (r30 == null) goto L59;
        r12 = RichTextData.a.a(r30);
    L59:
        r6 = new ContentData(r28, r12, r24);
        goto L61
    L50:
        r10 = 2;
        goto L51
    L52:
        r23 = null;
        goto L53
    L22:
        if (r14.length() == 0) goto L25;
        r15 = false;
    L45:
        r5 = false;
        goto L46
    L10:
        r4 = r18.getId();
        goto L11
    L63:
        if (r18.isPreMessage() == false) goto L65;
        String r31 = r18.getcId();
    L66:
        ContentData.a r32 = ContentData.Companion;
        Object r33 = r18.b();
        if ((r33 instanceof f) == false) goto L102;
        f r34 = (f) r33;
        if ((r34.a instanceof BaseTextContent) == false) goto L102;
        boolean r35 = !l.d(r34);
        if (r34.f != 3) goto L75;
        boolean r111 = true;
    L76:
        if (r35 == true) goto L78;
        r8 = 0;
    L80:
        T r36 = r34.a;
        if ((r36 instanceof TextContent) == false) goto L92;
        RichTextData.a r37 = RichTextData.Companion;
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        r37.getClass();
        RichTextData r38 = RichTextData.a.c((TextContent) r36);
        Object r39 = r34.g;
        if ((r39 instanceof e) == false) goto L85;
        e r40 = (e) r39;
    L86:
        if (r40 == null) goto L90;
        TextContent r41 = (TextContent) r40.a;
        if (r41 == null) goto L90;
        r12 = RichTextData.a.c(r41);
    L90:
        ContentData r42 = new ContentData(r38, r12, r8);
    L103:
        ExtraData.Companion.getClass();
        MessageFullScreenLaunchData r112 = new MessageFullScreenLaunchData(r31, r20, 0, r21, r22, r42, ExtraData.a.a(r18, r19, r21));
    L147:
        return r112;
    L85:
        r40 = null;
        goto L86
    L92:
        if ((r36 instanceof PostContent) == false) goto L102;
        RichTextData.a r113 = RichTextData.Companion;
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        r113.getClass();
        RichTextData r43 = RichTextData.a.b((PostContent) r36);
        Object r44 = r34.g;
        if ((r44 instanceof PostContentVO) == false) goto L96;
        PostContentVO r45 = (PostContentVO) r44;
    L97:
        if (r45 == null) goto L101;
        PostContent r46 = (PostContent) r45.a;
        if (r46 == null) goto L101;
        r12 = RichTextData.a.b(r46);
    L101:
        r42 = new ContentData(r43, r12, r8);
        goto L103
    L96:
        r45 = null;
        goto L97
    L78:
        if (r111 == false) goto L80;
        r8 = 2;
        goto L80
    L75:
        r111 = false;
    L102:
        r42 = null;
        goto L103
    L65:
        r31 = r18.getId();
        goto L66
    L105:
        if (r18.isPreMessage() == false) goto L107;
        String r47 = r18.getcId();
    L108:
        ContentData.a r48 = ContentData.Companion;
        Object r49 = r18.b();
        if ((r49 instanceof f) == false) goto L144;
        f r50 = (f) r49;
        if ((r50.a instanceof BaseTextContent) == false) goto L144;
        boolean r51 = !l.d(r50);
        if (r50.f != 3) goto L117;
        boolean r114 = true;
    L118:
        if (r51 == true) goto L120;
        r8 = 0;
    L122:
        T r52 = r50.a;
        if ((r52 instanceof TextContent) == false) goto L134;
        RichTextData.a r53 = RichTextData.Companion;
        Intrinsics.checkNotNull(r52, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        r53.getClass();
        RichTextData r54 = RichTextData.a.c((TextContent) r52);
        Object r55 = r50.g;
        if ((r55 instanceof e) == false) goto L127;
        e r56 = (e) r55;
    L128:
        if (r56 == null) goto L132;
        TextContent r57 = (TextContent) r56.a;
        if (r57 == null) goto L132;
        r12 = RichTextData.a.c(r57);
    L132:
        ContentData r58 = new ContentData(r54, r12, r8);
    L145:
        ExtraData.Companion.getClass();
        r112 = new MessageFullScreenLaunchData(r47, r20, 1, r21, r22, r58, ExtraData.a.a(r18, r19, r21));
        goto L147
    L127:
        r56 = null;
        goto L128
    L134:
        if ((r52 instanceof PostContent) == false) goto L144;
        RichTextData.a r115 = RichTextData.Companion;
        Intrinsics.checkNotNull(r52, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        r115.getClass();
        RichTextData r59 = RichTextData.a.b((PostContent) r52);
        Object r60 = r50.g;
        if ((r60 instanceof PostContentVO) == false) goto L138;
        PostContentVO r61 = (PostContentVO) r60;
    L139:
        if (r61 == null) goto L143;
        PostContent r62 = (PostContent) r61.a;
        if (r62 == null) goto L143;
        r12 = RichTextData.a.b(r62);
    L143:
        r58 = new ContentData(r59, r12, r8);
        goto L145
    L138:
        r61 = null;
        goto L139
    L120:
        if (r114 == false) goto L122;
        r8 = 2;
        goto L122
    L117:
        r114 = false;
    L144:
        r58 = null;
        goto L145
    L107:
        r47 = r18.getId();
        goto L108
    }

    public MessageFullScreenLaunchData(String r2, OpenApp r3, int r4, PageType r5, String r6, ContentData r7, ExtraData r8) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r5, "pageType");
        Intrinsics.checkNotNullParameter(r6, "sequenceId");
        this.messageId = r2;
        this.openApp = r3;
        this.messageType = r4;
        this.pageType = r5;
        this.sequenceId = r6;
        this.contentData = r7;
        this.extraData = r8;
    }
}
