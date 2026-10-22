package ai8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageContent;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.utils.p0;
import ic8.w;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements w {
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final String f;
    public final MessageStatus g;
    public final String h;
    public final ReferenceInfo i;
    public final Map<String, String> j;
    public final Map<String, String> k;
    public final boolean l;
    public final ChatPageContext m;
    public final Boolean n;
    public final String o;

    public static final class a {
    }

    static {
    }

    @Override // ic8.w
    public final int contentType() {
        return 6;
    }

    @Override // ic8.w
    public final Map<String, String> e() {
        return null;
    }

    @Override // ic8.w
    public final String g() {
        return null;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return null;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        Map<String, String> r0 = this.j;
        if (r0 == null) goto L7;
        Map<String, String> r1 = MapsKt.toMutableMap(r0);
        if (r1 == null) goto L7;
        JSONObject r2 = new JSONObject();
        r2.put("picture_num", 1);
        Unit r3 = Unit.INSTANCE;
        r1.put("vlm_da", r2.toString());
        return r1;
    L7:
        return null;
    }

    @Override // ic8.w
    public final String content() {
        String r1 = this.b;
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L18;
        String r5 = this.a;
        Integer r6 = this.c;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        Integer r8 = this.d;
        if (r8 == null) goto L40;
        r3 = r8.intValue();
    L40:
        return com.larus.bmhome.chat.sendimage.e.b(r5, r7, r3, this.n, this.o);
    L13:
        r7 = 0;
        goto L14
    L18:
        String r9 = this.b;
        String r10 = this.a;
        Integer r11 = this.c;
        if (r11 == null) goto L21;
        int r12 = r11.intValue();
    L22:
        Integer r13 = this.d;
        if (r13 == null) goto L25;
        int r14 = r13.intValue();
    L26:
        int r15 = p0.a;
        String r16 = p0.a(this.e);
        String r17 = this.f;
        Boolean r18 = this.n;
        String r19 = this.o;
        Lazy r20 = com.larus.bmhome.chat.sendimage.e.a;
        Intrinsics.checkNotNullParameter(r9, "tosKey");
        Intrinsics.checkNotNullParameter(r10, "localResPath");
        Image[] r21 = new Image[1];
        ImageObj r22 = new ImageObj(r17, r14, r12, null, null, 24, null);
        if (r19 != null) goto L29;
    L37:
        String r23 = null;
        ImageObj r110 = null;
    L38:
        r21[0] = new Image(r9, null, null, r22, r16, r10, null, null, r110, null, r18, null, null, null, 15046, null);
        ImageContent r24 = new ImageContent(CollectionsKt.arrayListOf(r21), r23, 2, r23);
        Intrinsics.checkNotNullParameter(r24, "content");
        return GsonProtectorUtils.toJson(com.larus.bmhome.chat.sendimage.e.i(), r24);
    L29:
        if (r19.length() > 0) goto L32;
        r2 = false;
    L32:
        if (r2 == false) goto L34;
        String r111 = r19;
    L35:
        if (r111 == null) goto L37;
        int r112 = r12;
        r23 = null;
        r110 = new ImageObj(r111, r14, r112, null, null, 24, null);
        goto L38
    L34:
        r111 = null;
        goto L35
    L25:
        r14 = 0;
        goto L26
    L21:
        r12 = 0;
        goto L22
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r4 = false;
        goto L9
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        if (this.l == false) goto L6;
        return MessageRequestType.RESEND_IMAGE;
    L6:
        return MessageRequestType.SEND_IMAGE;
    }

    @Override // ic8.w
    public final Pair<String, String> h() {
        return new Pair("send_image_local_path", this.a);
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.m;
    }

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return this.i;
    }

    @Override // ic8.w
    public final String b() {
        return this.h;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.k;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r20, Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r20, "extra");
        Intrinsics.checkNotNullParameter(r21, "bizExt");
        return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, r20, r21, this.l, this.m, this.n, this.o);
    }

    public /* synthetic */ e(String r20, String r21, Integer r22, Integer r23, String r24, String r25, String r26, ReferenceInfo r27, Map r28, Map r29, boolean r30, ChatPageContext r31, Boolean r32, String r33, int r34) {
        if ((r34 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r34 & 4) == 0) goto L9;
        Integer r6 = 0;
    L11:
        if ((r34 & 8) == 0) goto L13;
        Integer r7 = 0;
    L15:
        if ((r34 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r34 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r34 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r34 & 256) == 0) goto L29;
        ReferenceInfo r12 = null;
    L31:
        if ((r34 & 512) == 0) goto L33;
        Map r13 = null;
    L35:
        if ((r34 & 1024) == 0) goto L37;
        Map r14 = null;
    L39:
        if ((r34 & 2048) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r34 & 4096) == 0) goto L45;
        ChatPageContext r16 = null;
    L47:
        if ((r34 & 8192) == 0) goto L49;
        Boolean r17 = null;
    L51:
        if ((r34 & 16384) == 0) goto L53;
        String r18 = null;
    L54:
        this(r20, r5, r6, r7, r8, r9, null, r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L53:
        r18 = r33;
        goto L54
    L49:
        r17 = r32;
        goto L51
    L45:
        r16 = r31;
        goto L47
    L41:
        r15 = r30;
        goto L43
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r5 = r21;
        goto L7
    }

    public e(String r4, String r5, Integer r6, Integer r7, String r8, String r9, MessageStatus r10, String r11, ReferenceInfo r12, Map<String, String> r13, Map<String, String> r14, boolean r15, ChatPageContext r16, Boolean r17, String r18) {
        Intrinsics.checkNotNullParameter(r4, "imageLocalPath");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
    }
}
