package com.ss.android.lark.message.card.parser;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements gya.a<CardContent> {

    /* JADX INFO: renamed from: com.ss.android.lark.message.card.parser.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0180a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardContent.Type.values().length];
            r0[CardContent.Type.VOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CardContent.Type.VCHAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CardContent.Type.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    public final boolean b() {
        return true;
    }

    public final boolean c() {
        return true;
    }

    public final MessageType a() {
        return MessageType.CARD;
    }

    public static String j(Context r3, CardContent r4) {
        int r0 = com.ss.android.lark.message.card.utils.a.a;
        Intrinsics.checkNotNullParameter(r4, "cardContent");
        if (lrb.a.a(r4, 0) == false) goto L7;
        String r1 = r4.getLynxSimpleDigest();
        if (r1 == null) goto L9;
    L10:
        CardContent.Type r5 = r4.getType();
        if (r5 != null) goto L13;
        int r6 = -1;
    L15:
        if (r6 == 1) goto L30;
        if (r6 != 2) goto L19;
        String r7 = UIUtils.getString(r3, 2131892309);
    L28:
        return r7 + ' ' + r1;
    L19:
        if (r6 == 3) goto L22;
        r7 = UIUtils.getString(r3, 2131891919);
        goto L28
    L22:
        if (TextUtils.isEmpty(r1) == true) goto L25;
        return r1;
    L25:
        return UIUtils.getString(r3, 2131891919);
    L30:
        return UIUtils.getString(r3, 2131891920);
    L13:
        r6 = C0180a.a[r5.ordinal()];
    L9:
        r1 = "";
        goto L10
    L7:
        r1 = r4.getDigest();
        if (r1 != null) goto L10;
        goto L9
    }

    public final String d(Context r2, Content r3) {
        CardContent r4 = (CardContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return j(r2, r4);
    }

    public final String f(Context r2, Content r3) {
        CardContent r4 = (CardContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        String r5 = j(r2, r4);
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    public final String h(Context r6, f5b.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "messageInfo");
        boolean r1 = true;
        boolean r0 = !r7.isShowMessageOriginContent();
        if (r7.getMessage().getTranslateDisplayRule() != 3) goto L5;
        boolean r2 = true;
    L6:
        if (r0 == false) goto L10;
        if (r2 == true) goto L10;
        r1 = false;
    L10:
        CardContent r8 = r7.getTranslateContent(r1);
        StringBuilder r3 = new StringBuilder();
        if ((r8 instanceof CardContent) == false) goto L17;
        if (r1 == false) goto L14;
        String r4 = "";
    L15:
        r3.append(r4);
        r3.append(j(r6, r8));
        goto L17
    L14:
        r4 = UIHelper.getString(2131892287);
    L17:
        return r3.toString();
    L5:
        r2 = false;
        goto L6
    }

    public final Content g(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        CardContent r4 = d.a(r3, r3.card_content);     // Catch: Throwable -> L5
    L8:
        if (r4.getType() != CardContent.Type.UNKNOWN) goto L13;
        return null;
    L13:
        return r4;
    L5:
        th = move-exception;
        Log.e("ModelParserCardContent", "parse cardContent with entity failed ", th);
        r4 = new CardContent();
        r4.setType(CardContent.Type.UNKNOWN);
        goto L8
    }

    public final Content e(Entity r5, Message r6, com.bytedance.lark.pb.basic.v1.Content r7, TranslateInfo r8) {
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r7, "pbContent");
        if (r8 != null) goto L12;
        Intrinsics.checkNotNullParameter(r6, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r7, "pbContent");
        CardContent r9 = d.a(r7, r7.card_content);     // Catch: Throwable -> L7
    L10:
        if (r9.getType() != CardContent.Type.UNKNOWN) goto L21;
        return null;
    L21:
        return r9;
    L7:
        th = move-exception;
        Log.e("ModelParserCardContent", "parse cardContent with entity failed ", th);
        r9 = new CardContent();
        r9.setType(CardContent.Type.UNKNOWN);
        goto L10
    L12:
        Log.i("ModelParserCardContent", "parse translate card content messageId:" + r8.message_id);
        com.bytedance.lark.pb.basic.v1.Content r10 = r8.content;
        r9 = d.a(r10, r10.card_content);     // Catch: Throwable -> L15
    L18:
        if (r9.getType() != CardContent.Type.UNKNOWN) goto L21;
        return null;
    L15:
        th = move-exception;
        Log.e("ModelParserCardContent", "parse cardContent with entity failed ", th);
        r9 = new CardContent();
        r9.setType(CardContent.Type.UNKNOWN);
        goto L18
    }

    public final void i(com.bytedance.lark.pb.basic.v1.Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
