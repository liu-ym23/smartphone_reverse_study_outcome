package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.ThreadMergeForwardAuthorityUtil;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMFileAuthorityInterceptor implements com.ss.android.lark.chat.core.model.b.a<y6b.c<?>> {
    public final jdb.g a;
    public final com.ss.android.lark.auditsdk.v2.receivecheck.a b;
    public final Lazy c;

    public static final class a {
    }

    public /* synthetic */ class b {
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

    static {
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c<?>> r1, int r2, int r3) {
    }

    public IMFileAuthorityInterceptor(jdb.g r2, com.ss.android.lark.auditsdk.v2.receivecheck.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fgService");
        Intrinsics.checkNotNullParameter(r3, "fileChecker");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, IMFileAuthorityInterceptor$passportDependency$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r2, int r3) {
        d(r2, r3, 1);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c<?>> r1, int r2, int r3) {
        d(r1, r2, r3);
    }

    public final void d(List<y6b.c<?>> r20, int r21, int r22) {
        LinkedHashMap r2 = new LinkedHashMap();
        if (r20 == null) goto L12;
        int r3 = r22 + r21;
        int r4 = r21;
    L5:
        if (r4 >= r3) goto L12;
        y6b.c r5 = (y6b.c) ListProtector.get(r20, r4);
        r2.put(r5.c, r5);
        y6b.c<T> r6 = r5.v1;
        if (r6 == 0) goto L11;
        if (r2.containsKey(r6.c) == true) goto L11;
        r2.put(r6.c, r6);
    L11:
        r4 = r4 + 1;
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r2.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L65;
        Map.Entry r9 = (Map.Entry) r8.next();
        y6b.c r10 = (y6b.c) r9.getValue();
        switch(b.a[r10.getType().ordinal()]) {
            case 1: goto L61;
            case 2: goto L61;
            case 3: goto L61;
            case 4: goto L61;
            case 5: goto L40;
            case 6: goto L18;
            default: goto L62;
        };
    L18:
        T r11 = r10.o;
        if ((r11 instanceof PostContentVO) == false) goto L62;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO");
        PostContentVO r12 = (PostContentVO) r11;
        RichText r13 = r12.g();
        if (r13 == null) goto L27;
        List r14 = r13.getImageIds();
        if (r14 == null) goto L27;
        if ((!r14.isEmpty()) != true) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == true) goto L61;
        if (r13 == null) goto L35;
        List r16 = r13.getMediaIds();
        if (r16 == null) goto L35;
        if ((!r16.isEmpty()) != true) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == true) goto L61;
        if ((!r12.f().isEmpty()) == false) goto L62;
    L35:
        r17 = false;
    L27:
        r15 = false;
        goto L28
    L40:
        T r18 = r10.o;
        if ((r18 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L62;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.TextContentVO");
        com.ss.android.lark.chat.base.view.vo.message.e r19 = (com.ss.android.lark.chat.base.view.vo.message.e) r18;
        RichText r23 = r19.g();
        if (r23 == null) goto L49;
        List r110 = r23.getImageIds();
        if (r110 == null) goto L49;
        if ((!r110.isEmpty()) != true) goto L49;
        boolean r111 = true;
    L50:
        if (r111 == true) goto L61;
        if (r23 == null) goto L57;
        List r24 = r23.getMediaIds();
        if (r24 == null) goto L57;
        if ((!r24.isEmpty()) != true) goto L57;
        boolean r25 = true;
    L58:
        if (r25 == true) goto L61;
        if ((!r19.f().isEmpty()) == false) goto L62;
    L57:
        r25 = false;
    L49:
        r111 = false;
    L61:
        boolean r26 = true;
    L63:
        if (r26 == false) goto L14;
        r7.put(r9.getKey(), r9.getValue());
    L62:
        r26 = false;
        goto L63
    L65:
        LinkedHashMap r27 = new LinkedHashMap();
        Iterator r28 = r7.entrySet().iterator();
    L67:
        if (r28.hasNext() == false) goto L77;
        Map.Entry r29 = (Map.Entry) r28.next();
        ValidateIMFileResult r30 = ((y6b.c) r29.getValue()).F;
        if (r30 != null) goto L71;
    L74:
        boolean r31 = true;
    L75:
        if (r31 == false) goto L67;
        r27.put(r29.getKey(), r29.getValue());
        goto L67
    L71:
        if (r30.getResultType() == IMFileResult.UNKNOWN) goto L74;
        r31 = false;
        goto L75
    L77:
        LinkedHashMap r32 = new LinkedHashMap();
        Iterator r33 = r27.entrySet().iterator();
    L79:
        if (r33.hasNext() == false) goto L109;
        Map.Entry r34 = (Map.Entry) r33.next();
        String r112 = (String) r34.getKey();
        y6b.c r35 = (y6b.c) r34.getValue();
        String r113 = ((w4b.c.o) this.c.getValue()).userId();
        if (r113 != null) goto L83;
    L91:
        long r36 = 0;
    L92:
        String r114 = r35.e;
        AuthorityParam.a r115 = new AuthorityParam.a();
        r115.a = r112;
        int r116 = AuthorityParam.j;
        String r117 = r35.g;
        AuthorityParam.Companion.AuthScene r37 = AuthorityParam.Companion.AuthScene.IM_FILE_AUTHORITY_INTERCEPTOR;
        r115.d = Long.valueOf(AuthorityParam.Companion.a(r117, r37));
        y6b.b r118 = r35.t;
        if (r118 == null) goto L97;
        String r119 = r118.w;
        if (r119 == null) goto L97;
        Long r120 = Long.valueOf(AuthorityParam.Companion.a(r119, r37));
    L98:
        r115.c = r120;
        r115.f = r36;
        r115.e = AuthorityParam.Companion.a(((w4b.c.o) this.c.getValue()).fe(), r37);
        boolean r121 = r35.isPreMessage();
        boolean r122 = r35.i;
        Iterator r123 = r33;
        if (((ArrayList) r35.p()).size() <= 1) goto L101;
        boolean r38 = true;
    L102:
        AuthorityParam.AuthorityExtraParam r39 = new AuthorityParam.AuthorityExtraParam(r121, r122, r38);
        Intrinsics.checkNotNullParameter(r39, "authorityExtraParam");
        r115.i = r39;
        r115.b = r114;
        List<String> r40 = r35.p();
        Intrinsics.checkNotNullParameter(r40, "fileKeys");
        r115.h = r40;
        r32.put(r112, r115.a());
        y6b.b r41 = r35.t;
        if (r41 != null) goto L106;
        AuthorityParam.Companion.b(r37, "tenant id is null for chatter is null");
    L108:
        r33 = r123;
        goto L79
    L106:
        if (r41.w != null) goto L108;
        AuthorityParam.Companion.b(r37, "tenant id is null fo chatter not null");
        goto L108
    L101:
        r38 = false;
    L97:
        r120 = null;
        goto L98
    L83:
        if (r113.length() <= 0) goto L85;
        boolean r124 = true;
    L86:
        if (r124 == true) goto L89;
        r113 = null;
    L89:
        if (r113 == null) goto L91;
        r36 = CastLongProtector.parseLong(r113);
        goto L92
    L85:
        r124 = false;
        goto L86
    L109:
        Map r42 = this.b.b(r32, false);
        Iterator r43 = r42.entrySet().iterator();
    L111:
        if (r43.hasNext() == false) goto L115;
        Map.Entry r44 = (Map.Entry) r43.next();
        String r45 = (String) r44.getKey();
        ValidateIMFileResult r46 = (ValidateIMFileResult) r44.getValue();
        y6b.c r47 = (y6b.c) r2.get(r45);
        if (r47 == null) goto L111;
        r47.F = r46;
        goto L111
    L115:
        Iterator r48 = r2.entrySet().iterator();
    L117:
        if (r48.hasNext() == false) goto L121;
        y6b.c<T> r49 = ((y6b.c) ((Map.Entry) r48.next()).getValue()).v1;
        if (r49 == 0) goto L117;
        r49.F = (ValidateIMFileResult) r42.get(r49.c);
        goto L117
    L121:
        LinkedHashMap r50 = new LinkedHashMap();
        if (r20 == null) goto L141;
        int r51 = r22 + r21;
        int r52 = r21;
    L124:
        if (r52 >= r51) goto L141;
        y6b.c r53 = (y6b.c) ListProtector.get(r20, r52);
        if (r53.getType() != Message.Type.MERGE_FORWARD) goto L140;
        T r54 = r53.o.a;
        if ((r54 instanceof MergeForwardContent) == false) goto L130;
        MergeForwardContent r55 = (MergeForwardContent) r54;
    L131:
        if (r55 != null) goto L133;
        Log.i("ChatWindowIMFileAuthorityInterceptor", "doMergeForwardAuthority stops for content is null.");
    L133:
        if (r55 != null) goto L135;
    L137:
        boolean r125 = false;
    L138:
        if (r125 == false) goto L140;
        r50.put(r53.c, r55);
        goto L140
    L135:
        if (r55.isFromPrivateTopic() != true) goto L137;
        r125 = true;
        goto L138
    L130:
        r55 = null;
    L140:
        r52 = r52 + 1;
    L141:
        com.ss.android.lark.auditsdk.v2.receivecheck.a r1 = this.b;
        jdb.g r56 = this.a;
        Lazy r57 = ThreadMergeForwardAuthorityUtil.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r56, "fgService");
        Intrinsics.checkNotNullParameter(r50, "mergeForwardContents");
        if (r56.isEnable("messenger.permission.share") == false) goto L239;
        HashMap r58 = new HashMap();
        ArrayList r59 = new ArrayList();
        Iterator r60 = r50.entrySet().iterator();
    L146:
        if (r60.hasNext() == false) goto L156;
        List<Message> r61 = ((MergeForwardContent) ((Map.Entry) r60.next()).getValue()).getMessages();
        if (CollectionUtils.isEmpty(r61) == true) goto L152;
        if (r61 == null) goto L152;
        Message r62 = (Message) ListProtector.get(r61, 0);
    L153:
        if (r62 == null) goto L146;
        r58.put(r62.getId(), r62);
        r59.add(r62);
    L152:
        r62 = null;
        goto L153
    L156:
        if (r58.isEmpty() == true) goto L240;
        ArrayList r63 = new ArrayList(r58.size());
        Iterator r64 = r58.entrySet().iterator();
    L160:
        if (r64.hasNext() == false) goto L162;
        r63.add(((Message) ((Map.Entry) r64.next()).getValue()).getFromId());
        goto L160
    L162:
        Map r65 = ImSdkService.d().l0(r63);
        HashMap r66 = new HashMap();
        Iterator r67 = r58.entrySet().iterator();
    L164:
        if (r67.hasNext() == false) goto L174;
        Message r68 = (Message) ((Map.Entry) r67.next()).getValue();
        Chatter r69 = (Chatter) r65.get(r68.getFromId());
        if (r69 == null) goto L164;
        AuthorityParam.a r126 = new AuthorityParam.a();
        r126.a = r68.getId();
        int r127 = AuthorityParam.j;
        String r128 = r68.getFromId();
        AuthorityParam.Companion.AuthScene r129 = AuthorityParam.Companion.AuthScene.THREAD_MERGE_FORWARD_AUTHORITY_UTIL;
        r126.d = Long.valueOf(AuthorityParam.Companion.a(r128, r129));
        r126.c = Long.valueOf(AuthorityParam.Companion.a(r69.getTenantId(), r129));
        Lazy r70 = ThreadMergeForwardAuthorityUtil.a;
        String r130 = ((w4b.c.o) r70.getValue()).userId();
        if (r130 == null) goto L171;
        long r71 = CastLongProtector.parseLong(r130);
    L172:
        r126.f = r71;
        r126.e = AuthorityParam.Companion.a(((w4b.c.o) r70.getValue()).fe(), r129);
        AuthorityParam.AuthorityExtraParam r72 = new AuthorityParam.AuthorityExtraParam(r68.isPreMessage(), r68.isFromMe(), r68.isMultiResourceAuth());
        Intrinsics.checkNotNullParameter(r72, "authorityExtraParam");
        r126.i = r72;
        r126.b = r68.getChatId();
        List<String> r73 = r68.getAuthFileKeys();
        Intrinsics.checkNotNullParameter(r73, "fileKeys");
        r126.h = r73;
        r66.put(r68.getId(), r126.a());
        AuthorityParam.Companion.b(r129, "chatter is not null");
        goto L164
    L171:
        r71 = 0;
        goto L172
    L174:
        if (CollectionUtils.isNotEmpty(r66) == false) goto L188;
        Iterator r74 = r1.b(r66, false).entrySet().iterator();
    L177:
        if (r74.hasNext() == false) goto L241;
        Map.Entry r75 = (Map.Entry) r74.next();
        String r76 = (String) r75.getKey();
        ArrayList r77 = new ArrayList();
        Iterator r78 = r59.iterator();
    L180:
        if (r78.hasNext() == false) goto L184;
        Object r79 = r78.next();
        if (Intrinsics.areEqual(((Message) r79).getId(), r76) == false) goto L180;
        r77.add(r79);
        goto L180
    L184:
        Iterator r80 = r77.iterator();
    L186:
        if (r80.hasNext() == false) goto L177;
        ((Message) r80.next()).setValidateIMFileResult((ValidateIMFileResult) r75.getValue());
        goto L186
    L241:
        return;
    L188:
        return;
    L240:
        return;
    }
}
