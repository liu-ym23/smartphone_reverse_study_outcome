package com.ss.android.lark.im.sdk.statistics;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.q;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.utils.y;
import com.ss.android.lark.utils.z;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final Map<String, String> a = null;
    public static String b;

    public static class a {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final List<String> g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;

        /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.statistics.b$a$a, reason: collision with other inner class name */
        public static class C0087a {
            public int a;
            public String b;
            public String c;
            public String d;
            public int e;
            public String f;
            public List<String> g;
            public int h;
            public int i;
            public int j;
            public int k;
            public boolean l;
            public boolean m;

            public C0087a() {
                this.a = -1;
                this.b = "";
                this.c = "";
                this.d = "";
                this.f = "";
                this.g = new ArrayList();
                this.k = -1;
            }
        }

        public JSONObject a() {
            return new JSONObject().put("chat_type", this.a).put("chat_id", this.b).put("notice", this.d).put("message_length", this.e).put("cid", this.f).put("emoji_type", this.g).put("emoji_count", this.h).put("richtext_image_count", this.i).put("doc_link_count", this.j).put("message_type", this.k).put("is_bot_chat", this.l).put("is_meeting_chat", this.m);
        }

        public a(int r2, String r3, String r4, String r5, int r6, String r7, List<String> r8, int r9, int r10, int r11, int r12, boolean r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r3, "chatId");
            Intrinsics.checkNotNullParameter(r4, "location");
            Intrinsics.checkNotNullParameter(r5, "notice");
            Intrinsics.checkNotNullParameter(r7, "cid");
            Intrinsics.checkNotNullParameter(r8, "emojiType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.statistics.b$b, reason: collision with other inner class name */
    public static final class C0088b extends a {
        public final String n;
        public final long o;
        public final String p;
        public final String q;

        /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.statistics.b$b$a */
        public static final class a extends a.C0087a {
            public String n;
            public long o;
            public String p;
            public String q;

            public final C0088b a() {
                return new C0088b(this.n, this.o, this.p, this.q, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }

            public a() {
                this.n = "";
                this.p = "";
                this.q = "";
            }
        }

        @Override // com.ss.android.lark.im.sdk.statistics.b.a
        public final JSONObject a() {
            return super.a().put("reply_message_id", this.n).put("reply_message_time", this.o).put("reply_order", this.p).put("message_aim_type", this.q);
        }

        public C0088b(String r17, long r18, String r20, String r21, int r22, String r23, String r24, String r25, int r26, String r27, List<String> r28, int r29, int r30, int r31, int r32, boolean r33, boolean r34) {
            Intrinsics.checkNotNullParameter(r17, "replyMessageId");
            Intrinsics.checkNotNullParameter(r20, "replyOrder");
            Intrinsics.checkNotNullParameter(r21, "messageAimType");
            Intrinsics.checkNotNullParameter(r23, "chatId");
            Intrinsics.checkNotNullParameter(r24, "location");
            Intrinsics.checkNotNullParameter(r25, "notice");
            Intrinsics.checkNotNullParameter(r27, "cid");
            Intrinsics.checkNotNullParameter(r28, "emojiType");
            super(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
            this.n = r17;
            this.o = r18;
            this.p = r20;
            this.q = r21;
        }
    }

    public static final class c extends a {
        public final boolean n;
        public final String o;
        public final String p;

        public static final class a extends a.C0087a {
            public boolean n;
            public String o;
            public String p;

            public final c a() {
                return new c(this.n, this.o, this.p, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }

            public a() {
                this.o = "";
                this.p = "";
            }
        }

        @Override // com.ss.android.lark.im.sdk.statistics.b.a
        public final JSONObject a() {
            return super.a().put("is_has_docslink", this.n).put("file_type", this.o).put("file_id", y.b(this.p));
        }

        public c(boolean r17, String r18, String r19, int r20, String r21, String r22, String r23, int r24, String r25, List<String> r26, int r27, int r28, int r29, int r30, boolean r31, boolean r32) {
            Intrinsics.checkNotNullParameter(r18, "fileType");
            Intrinsics.checkNotNullParameter(r19, "fileId");
            Intrinsics.checkNotNullParameter(r21, "chatId");
            Intrinsics.checkNotNullParameter(r22, "location");
            Intrinsics.checkNotNullParameter(r23, "notice");
            Intrinsics.checkNotNullParameter(r25, "cid");
            Intrinsics.checkNotNullParameter(r26, "emojiType");
            super(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
            this.n = r17;
            this.o = r18;
            this.p = r19;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[Message.Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[Message.Type.IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[Message.Type.AUDIO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[Message.Type.TEXT_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[Message.Type.STICKER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[Message.Type.SHARE_USER_CARD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[Message.Type.SYSTEM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    @JvmStatic
    public static final String a(boolean r0, boolean r1, boolean r2) {
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        return "none";
    L6:
        if (r0 == false) goto L9;
        return "me";
    L9:
        if (r1 == false) goto L14;
        if (r0 == true) goto L14;
        if (r2 == true) goto L14;
        return "atother";
    L14:
        if (r2 == false) goto L16;
        return "atall";
    L16:
        return INotificationHitPoint.NoticeType.OTHER;
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        b = "main";
        r0.put("POST", "richtext");
        r0.put("FILE", "file");
        r0.put("TEXT", "text");
        r0.put("IMAGE", LoadParams.ImageFormat.IMAGE);
        r0.put("AUDIO", "voice");
        r0.put("TEXT_IMAGE", "text_image");
        r0.put("SYSTEM", "system");
        r0.put("MEDIA", "video");
        r0.put("EMAIL", IOfflineExtraParser.ParserType.MAIL);
        r0.put("SHARE_GROUP_CHAT", "share_group_chat");
        r0.put("STICKER", TextInputPluginHitPoint.Scene.STICKER);
        r0.put("SHARE_USER_CARD", "share_user_card");
    }

    public static void e(String r3) {
        Gson r1 = z.a;     // Catch: JSONException -> L16
        com.alibaba.fastjson.JSONObject r2 = null;
        if (TextUtils.isEmpty(r3) == false) goto L20;
    L8:
        if (r2 != null) goto L10;
        return;
    L10:
        Integer r4 = r2.getInteger("type");     // Catch: JSONException -> L16
        String r5 = r2.getString("activity");     // Catch: JSONException -> L16
        if (r4 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r5) == true) goto L25;
        Statistics.sendEvent("read_activity_award_message", new JSONObject().put("type", r4.intValue()));     // Catch: JSONException -> L16
        return;
    L25:
        return;
    L20:
        r2 = JSON.parseObject(r3);     // Catch: Throwable -> L19
    L16:
        e = move-exception;
        Log.w("MessageHitPoint", "send extra card analytics data error, " + e.getMessage());
    }

    @JvmStatic
    public static final void d(List<? extends Message> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "messageList");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<? extends Message> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Message r0 = r5.next();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.im.sdk.statistics.c(r0, r4));
        goto L4
    }

    public static a b(Chat r25, Message r26, ChatChatter r27) {
        ArrayList r1 = new ArrayList();
        Message.Type r2 = r26.getType();
        int r3 = -1;
        if (r2 != null) goto L5;
        int r4 = -1;
    L6:
        boolean r5 = true;
        if (r4 == 1) goto L34;
        RichText r6 = null;
        if (r4 == 2) goto L12;
        int r7 = 0;
    L35:
        if (r6 == null) goto L65;
        String r8 = ImSdkProxy.e().getCurrentUserId();
        boolean r9 = com.ss.android.lark.widget.richtext.d.f(r6, false).contains(r8);
        boolean r10 = com.ss.android.lark.widget.richtext.d.k(r6);
        ArrayList r11 = com.ss.android.lark.widget.richtext.d.f(r6, true);
        Pattern r12 = o.a;
        String r13 = a(r9, r10, r11.contains("all"));
        if (i.l(r6) == false) goto L39;
        List<String> r14 = Collections.emptyList();
    L49:
        if (i.l(r6) == false) goto L51;
        List r15 = Collections.emptyList();
    L60:
        int r16 = r15.size();
        int r17 = ((ArrayList) com.ss.android.lark.widget.richtext.d.c(r6, false)).size();
        okb.e r18 = com.ss.android.lark.statistics.message.b.a;
        List r19 = com.ss.android.lark.widget.richtext.d.j(r6);
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L62:
        if (r21.hasNext() == false) goto L64;
        String r110 = (String) r21.next();
        com.ss.android.lark.statistics.message.b.a.b();
        goto L62
    L64:
        int r22 = r20.size();
    L66:
        int r23 = r26.getType().getNumber();
        if (r25.isP2PChat() == false) goto L73;
        if (r27 == null) goto L70;
        boolean r111 = r27.isBot();
    L71:
        if (r111 == false) goto L73;
    L74:
        a.C0087a r24 = new a.C0087a();
        r24.a = r25.getType().getNumber();
        String r112 = r26.getChatId();
        Intrinsics.checkNotNullParameter(r112, "chatId");
        r24.b = r112;
        Intrinsics.checkNotNullParameter(r13, "notice");
        r24.d = r13;
        r24.e = r7;
        String r0 = r26.getcId();
        Intrinsics.checkNotNullParameter(r0, "cid");
        r24.f = r0;
        List<String> r28 = r14;
        Intrinsics.checkNotNullParameter(r28, "emojiType");
        r24.g = r28;
        r24.h = r16;
        r24.i = r17;
        r24.j = r22;
        r24.k = r23;
        r24.l = r5;
        boolean r29 = r25.isMeeting();
        r24.m = r29;
        return new a(r24.a, r24.b, r24.c, r24.d, r24.e, r24.f, r24.g, r24.h, r24.i, r24.j, r24.k, r24.l, r29);
    L70:
        r111 = false;
    L73:
        r5 = false;
        goto L74
    L51:
        ArrayList r30 = new ArrayList();
        Iterator r31 = r6.getElements().getDictionary().entrySet().iterator();
    L53:
        if (r31.hasNext() == false) goto L59;
        RichTextElement r32 = (RichTextElement) ((Map.Entry) r31.next()).getValue();
        if (r32 == null) goto L53;
        if ((r32.getProperty() instanceof RichTextElement.EmotionProperty) == false) goto L53;
        r30.add(r32.getProperty().getKey());
        goto L53
    L59:
        r15 = new ArrayList(r30);
        goto L60
    L39:
        HashSet r33 = new HashSet();
        Iterator r34 = r6.getElements().getDictionary().entrySet().iterator();
    L41:
        if (r34.hasNext() == false) goto L47;
        RichTextElement r35 = (RichTextElement) ((Map.Entry) r34.next()).getValue();
        if (r35 == null) goto L41;
        if ((r35.getProperty() instanceof RichTextElement.EmotionProperty) == false) goto L41;
        r33.add(r35.getProperty().getKey());
        goto L41
    L47:
        r14 = new ArrayList(r33);
        goto L49
    L65:
        r22 = 0;
        r16 = 0;
        r17 = 0;
        r14 = r1;
        r13 = "none";
        goto L66
    L12:
        if (r25.isSecret() == false) goto L14;
        t4b.a r36 = t4b.a.b;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r26, INotificationHitPoint.NoticeType.MESSAGE);
        r7 = r36.a(r26).length();
    L16:
        if (r25.isSecret() == false) goto L25;
        t4b.a.b.getClass();
        Intrinsics.checkNotNullParameter(r26, INotificationHitPoint.NoticeType.MESSAGE);
        Message.Type r37 = r26.getType();
        if (r37 == null) goto L21;
        r3 = t4b.a.a.a[r37.ordinal()];
    L21:
        if (r3 != 1) goto L35;
        int r38 = u4b.a.c;
        TextContent r39 = u4b.a.b.a.b(r26);
        if ((r39 instanceof TextContent) == false) goto L35;
        r6 = r39.getRichText();
        goto L35
    L25:
        com.ss.android.lark.chat.chatwindow.chat.data.content.a.b.getClass();
        Intrinsics.checkNotNullParameter(r26, INotificationHitPoint.NoticeType.MESSAGE);
        Message.Type r40 = r26.getType();
        if (r40 == null) goto L29;
        r3 = com.ss.android.lark.chat.chatwindow.chat.data.content.a.a.a[r40.ordinal()];
    L29:
        if (r3 == 1) goto L33;
        if (r3 != 2) goto L35;
        PostContent r41 = r26.getContent();
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        r6 = r41.getRichText();
        goto L35
    L33:
        TextContent r42 = r26.getContent();
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        r6 = r42.getRichText();
        goto L35
    L14:
        com.ss.android.lark.chat.chatwindow.chat.data.content.a r43 = com.ss.android.lark.chat.chatwindow.chat.data.content.a.b;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r26, INotificationHitPoint.NoticeType.MESSAGE);
        r7 = r43.a(r26).length();
        goto L16
    L34:
        PostContent r44 = r26.getContent();
        int r45 = r44.getText().length();
        r6 = r44.getRichText();
        r7 = r45;
        goto L35
    L5:
        r4 = d.a[r2.ordinal()];
        goto L6
    }

    @JvmStatic
    public static final void c(int r4, String r5, Chat r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "atType");
        Intrinsics.checkNotNullParameter(r6, "chat");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Statistics.sendEvent("message_read", new JSONObject().put("message_type", r4).put("chat_type", r6.getType()).put("notice", r5).put("chat_id", r6.getId()).put("is_mute", q.b).put("is_chatbox", q.c).put("message_id", r7).put("is_bot_chat", r8).put("is_meeting_chat", r6.isMeeting()));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("MessageHitPoint", th.getMessage());
    }
}
