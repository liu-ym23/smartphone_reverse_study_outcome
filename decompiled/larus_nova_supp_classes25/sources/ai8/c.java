package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import ic8.w;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements w {
    public final List<Long> a;
    public final int b;
    public final String c;
    public final long d;
    public final String e;
    public final Map<String, String> f;
    public final Map<String, String> g;
    public final MessageStatus h;
    public final ChatPageContext i;

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return null;
    }

    @Override // ic8.w
    public final String content() {
        return "";
    }

    @Override // ic8.w
    public final int contentType() {
        return 9999;
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
    public final ChatPageContext N() {
        return this.i;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.f;
    }

    @Override // ic8.w
    public final String b() {
        return this.e;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        return MessageRequestType.SEND_TEXT;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.g;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return this.h;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r14, "bizExt");
        return new c(this.a, this.b, this.c, this.d, this.e, r13, r14, this.h, this.i);
    }

    public c(List<Long> r2, int r3, String r4, long r5, String r7, Map<String, String> r8, Map<String, String> r9, MessageStatus r10, ChatPageContext r11) {
        Intrinsics.checkNotNullParameter(r2, "bizMessageIds");
        Intrinsics.checkNotNullParameter(r4, "brief");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
