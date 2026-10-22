package ai8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.SendFileContent;
import com.larus.utils.p0;
import ic8.w;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "replaced by SendNestedFileStrategy")
public final class d implements w {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final ReferenceInfo f;
    public final Map<String, String> g;
    public final Map<String, String> h;
    public final boolean i;
    public final ChatPageContext j;

    @Override // ic8.w
    public final int contentType() {
        return 7;
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
    public final Pair<String, String> h() {
        return null;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return null;
    }

    @Override // ic8.w
    public final String content() {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = p0.a(r2);
    L6:
        String r5 = this.d;
        if (r5 == null) goto L9;
        r3 = p0.a(r5);
    L9:
        Lazy r6 = com.larus.bmhome.chat.sendimage.e.a;
        Intrinsics.checkNotNullParameter(r0, "localPath");
        SendFileContent r7 = new SendFileContent(CollectionsKt.arrayListOf(new SendFile[]{new SendFile(r0, r1, r4, r3)}));
        Intrinsics.checkNotNullParameter(r7, "content");
        return GsonProtectorUtils.toJson(com.larus.bmhome.chat.sendimage.e.i(), r7);
    L5:
        r4 = null;
        goto L6
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        if (this.i == false) goto L6;
        return MessageRequestType.RESEND_FILE;
    L6:
        return MessageRequestType.SEND_FILE;
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.j;
    }

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return this.f;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.g;
    }

    @Override // ic8.w
    public final String b() {
        return this.e;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.h;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r14, "bizExt");
        return new d(this.a, this.b, this.c, this.d, this.e, this.f, r13, r14, this.i, this.j);
    }

    public /* synthetic */ d(String r15, String r16, String r17, String r18, String r19, ReferenceInfo r20, Map r21, Map r22, ChatPageContext r23, int r24) {
        if ((r24 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r24 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r24 & 32) == 0) goto L17;
        ReferenceInfo r9 = null;
    L19:
        if ((r24 & 64) == 0) goto L21;
        Map r10 = null;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Map r11 = null;
    L27:
        if ((r24 & 512) == 0) goto L29;
        ChatPageContext r13 = null;
    L30:
        this(r15, r16, r6, r7, r8, r9, r10, r11, false, r13);
        return;
    L29:
        r13 = r23;
        goto L30
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }

    public d(String r2, String r3, String r4, String r5, String r6, ReferenceInfo r7, Map<String, String> r8, Map<String, String> r9, boolean r10, ChatPageContext r11) {
        Intrinsics.checkNotNullParameter(r2, "fileLocalPath");
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
}
