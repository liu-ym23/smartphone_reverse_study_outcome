package ai8;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextContent;
import ic8.w;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zd9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements w {
    public final String a;
    public final String b;
    public final ReferenceInfo c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final boolean f;
    public final ChatPageContext g;
    public final Long h;

    @Override // ic8.w
    public final int contentType() {
        return 1;
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
        String r0 = i.c(new TextContent(this.a, null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null), TextContent.Companion.serializer());
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        if (this.f == false) goto L6;
        return MessageRequestType.RESEND_AUDIO;
    L6:
        return MessageRequestType.SEND_AUDIO;
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.g;
    }

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return this.c;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.d;
    }

    @Override // ic8.w
    public final String b() {
        return this.b;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.e;
    }

    @Override // ic8.w
    public final w c(Map r11, Map r12) {
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r12, "bizExt");
        return new b(this.a, this.b, this.c, r11, r12, this.f, this.g, this.h);
    }

    public b(String r2, String r3, ReferenceInfo r4, Map<String, String> r5, Map<String, String> r6, boolean r7, ChatPageContext r8, Long r9) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ b(String r13, String r14, ReferenceInfo r15, Map r16, Map r17, boolean r18, ChatPageContext r19, Long r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        ReferenceInfo r6 = null;
    L11:
        if ((r21 & 8) == 0) goto L13;
        Map r7 = null;
    L15:
        if ((r21 & 16) == 0) goto L17;
        Map r8 = null;
    L19:
        if ((r21 & 32) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r21 & 64) == 0) goto L25;
        ChatPageContext r10 = null;
    L27:
        if ((r21 & 128) == 0) goto L29;
        Long r11 = null;
    L30:
        this(r13, r5, r6, r7, r8, r9, r10, r11);
        return;
    L29:
        r11 = r20;
        goto L30
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
