package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import ic8.w;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements w {
    public final NestedFileContent a;
    public final String b;
    public final MessageStatus c;
    public final ReferenceInfo d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final boolean g;
    public final MessageStatus h;
    public final ChatPageContext i;
    public final Map<String, String> j;

    @Override // ic8.w
    public final int contentType() {
        return 800;
    }

    @Override // ic8.w
    public final String g() {
        return "flow_nested";
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        Map<String, String> r0 = this.e;
        if (r0 == null) goto L7;
        Map<String, String> r1 = MapsKt.toMutableMap(r0);
        if (r1 == null) goto L7;
        JSONObject r2 = new JSONObject();
        r2.put("picture_num", v0.c(this.a));
        Unit r3 = Unit.INSTANCE;
        r1.put("vlm_da", r2.toString());
        return r1;
    L7:
        return null;
    }

    @Override // ic8.w
    public final String content() {
        return com.larus.bmhome.chat.sendimage.e.a(this.a);
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        if (this.g == false) goto L6;
        return MessageRequestType.RESEND_NESTED_FILE;
    L6:
        return MessageRequestType.SEND_NESTED_FILE;
    }

    @Override // ic8.w
    public final Pair<String, String> h() {
        String r0 = com.larus.bmhome.chat.sendimage.e.d(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new Pair("nested_file_local_path_list", r0);
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.i;
    }

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return this.d;
    }

    @Override // ic8.w
    public final String b() {
        return this.b;
    }

    @Override // ic8.w
    public final Map<String, String> e() {
        return this.j;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.f;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return this.h;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r14, "bizExt");
        return new f(this.a, this.b, this.c, this.d, r13, r14, this.g, this.h, this.i, this.j);
    }

    public f(NestedFileContent r2, String r3, MessageStatus r4, ReferenceInfo r5, Map<String, String> r6, Map<String, String> r7, boolean r8, MessageStatus r9, ChatPageContext r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r2, "nestedFileContent");
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
    }

    public /* synthetic */ f(NestedFileContent r15, String r16, MessageStatus r17, ReferenceInfo r18, Map r19, Map r20, boolean r21, MessageStatus r22, ChatPageContext r23, Map r24, int r25) {
        if ((r25 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r25 & 4) == 0) goto L9;
        MessageStatus r6 = null;
    L11:
        if ((r25 & 8) == 0) goto L13;
        ReferenceInfo r7 = null;
    L15:
        if ((r25 & 16) == 0) goto L17;
        Map r8 = null;
    L19:
        if ((r25 & 32) == 0) goto L21;
        Map r9 = null;
    L23:
        if ((r25 & 64) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r25 & 128) == 0) goto L29;
        MessageStatus r11 = null;
    L31:
        if ((r25 & 256) == 0) goto L33;
        ChatPageContext r12 = null;
    L35:
        if ((r25 & 512) == 0) goto L37;
        Map r13 = null;
    L38:
        this(r15, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        return;
    L37:
        r13 = r24;
        goto L38
    L33:
        r12 = r23;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }
}
