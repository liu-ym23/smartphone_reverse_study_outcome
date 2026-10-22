package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final com.ss.android.lark.auditsdk.v2.receivecheck.a a;
    public final jdb.g b;
    public final w4b.c.o c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[Message.Type.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Message.Type.TEXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[Message.Type.POST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public final void a(Chat r13, List r14) {
        Intrinsics.checkNotNullParameter(r14, "list");
        if (this.b.isEnable("messenger.permission.share") == true) goto L6;
        return;
    L6:
        if (r13 != null) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L13;
        return;
    L13:
        LinkedHashMap r16 = new LinkedHashMap();
        List r17 = r14;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r17.iterator();
    L14:
        IMFileResult r5 = null;
        if (r3.hasNext() == false) goto L73;
        Object r4 = r3.next();
        Message r6 = ((f5b.b) r4).getMessage();
        Message.Type r7 = r6.getType();
        if (r7 != null) goto L19;
        int r8 = -1;
    L20:
        switch(r8) {
            case 1: goto L61;
            case 2: goto L61;
            case 3: goto L61;
            case 4: goto L61;
            case 5: goto L42;
            case 6: goto L22;
            default: goto L62;
        };
    L22:
        PostContent r9 = (PostContent) r6.getMessageContent();
        RichText r10 = r9.getRichText();
        if (r10 == null) goto L29;
        List r11 = r10.getImageIds();
        if (r11 == null) goto L29;
        if ((!r11.isEmpty()) != true) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == true) goto L61;
        if (r10 == null) goto L37;
        List r18 = r10.getMediaIds();
        if (r18 == null) goto L37;
        if ((!r18.isEmpty()) != true) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == true) goto L61;
        if ((!r9.getAttachments().isEmpty()) == false) goto L62;
    L37:
        r19 = false;
    L29:
        r12 = false;
        goto L30
    L42:
        TextContent r20 = (TextContent) r6.getMessageContent();
        RichText r21 = r20.getRichText();
        if (r21 == null) goto L49;
        List r22 = r21.getImageIds();
        if (r22 == null) goto L49;
        if ((!r22.isEmpty()) != true) goto L49;
        boolean r23 = true;
    L50:
        if (r23 == true) goto L61;
        if (r21 == null) goto L57;
        List r24 = r21.getMediaIds();
        if (r24 == null) goto L57;
        if ((!r24.isEmpty()) != true) goto L57;
        boolean r25 = true;
    L58:
        if (r25 == true) goto L61;
        if ((!r20.getAttachments().isEmpty()) == false) goto L62;
    L57:
        r25 = false;
    L49:
        r23 = false;
    L61:
        boolean r26 = true;
    L63:
        List r27 = CollectionsKt.listOf(new IMFileResult[]{null, IMFileResult.UNKNOWN});
        ValidateIMFileResult r28 = r6.getValidateIMFileResult();
        if (r28 == null) goto L66;
        r5 = r28.getResultType();
    L66:
        boolean r29 = r27.contains(r5);
        if (r26 == false) goto L70;
        if (r29 == false) goto L70;
        boolean r30 = true;
    L71:
        if (r30 == false) goto L14;
        r2.add(r4);
    L70:
        r30 = false;
    L62:
        r26 = false;
        goto L63
    L19:
        r8 = a.a[r7.ordinal()];
        goto L20
    L73:
        Iterator r1 = r2.iterator();
    L75:
        if (r1.hasNext() == false) goto L77;
        f5b.b r31 = (f5b.b) r1.next();
        r16.put(r31.getId(), r31);
        goto L75
    L77:
        LinkedHashMap r32 = new LinkedHashMap();
        Iterator r110 = r16.entrySet().iterator();
    L79:
        if (r110.hasNext() == false) goto L105;
        Map.Entry r33 = (Map.Entry) r110.next();
        String r34 = (String) r33.getKey();
        f5b.b r35 = (f5b.b) r33.getValue();
        String r36 = r35.getMessage().getChatId();
        AuthorityParam.a r37 = new AuthorityParam.a();
        r37.a = r34;
        ChatChatter r38 = r35.getMessageSender();
        if (r38 == null) goto L85;
        String r39 = r38.getId();
        if (r39 == null) goto L85;
        int r40 = AuthorityParam.j;
        Long r41 = Long.valueOf(AuthorityParam.Companion.a(r39, AuthorityParam.Companion.AuthScene.IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR));
    L86:
        r37.d = r41;
        ChatChatter r42 = r35.getMessageSender();
        if (r42 == null) goto L91;
        String r43 = r42.getTenantId();
        if (r43 == null) goto L91;
        int r44 = AuthorityParam.j;
        Long r45 = Long.valueOf(AuthorityParam.Companion.a(r43, AuthorityParam.Companion.AuthScene.IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR));
    L92:
        r37.c = r45;
        String r46 = this.c.userId();
        if (r46 == null) goto L95;
        long r47 = CastLongProtector.parseLong(r46);
    L96:
        r37.f = r47;
        int r48 = AuthorityParam.j;
        String r49 = this.c.fe();
        AuthorityParam.Companion.AuthScene r50 = AuthorityParam.Companion.AuthScene.IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR;
        r37.e = AuthorityParam.Companion.a(r49, r50);
        AuthorityParam.AuthorityExtraParam r51 = new AuthorityParam.AuthorityExtraParam(r35.isPreMessage(), r35.getMessage().isFromMe(), r35.getMessage().isMultiResourceAuth());
        Intrinsics.checkNotNullParameter(r51, "authorityExtraParam");
        r37.i = r51;
        r37.b = r36;
        List<String> r52 = r35.getAuthFileKeys();
        Intrinsics.checkNotNullParameter(r52, "fileKeys");
        r37.h = r52;
        r32.put(r34, r37.a());
        if (r35.getMessageSender() == null) goto L98;
        ChatChatter r53 = r35.getMessageSender();
        if (r53 == null) goto L102;
        String r54 = r53.getTenantId();
    L103:
        if (r54 != null) goto L79;
        AuthorityParam.Companion.b(r50, "tenant id is null fo chatter not null");
        goto L79
    L102:
        r54 = null;
        goto L103
    L98:
        AuthorityParam.Companion.b(r50, "tenant id is null for chatter is null");
        goto L79
    L95:
        r47 = 0;
    L91:
        r45 = null;
    L85:
        r41 = null;
        goto L86
    L105:
        Map r111 = this.a.b(r32, true);
        Iterator r112 = r17.iterator();
    L107:
        if (r112.hasNext() == false) goto L111;
        f5b.b r0 = (f5b.b) r112.next();
        ValidateIMFileResult r55 = (ValidateIMFileResult) r111.get(r0.getId());
        if (r55 == null) goto L107;
        r0.getMessage().setValidateIMFileResult(r55);
        goto L107
    L111:
        return;
    L8:
        if (r13.isSecret() != true) goto L10;
        r15 = true;
        goto L11
    }

    public b(com.ss.android.lark.auditsdk.v2.receivecheck.a r2, jdb.g r3, w4b.c.o r4) {
        Intrinsics.checkNotNullParameter(r2, "fileChecker");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        Intrinsics.checkNotNullParameter(r4, "passportDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
