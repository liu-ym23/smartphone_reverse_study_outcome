package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.Block;
import ic8.w;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements w {
    public final List<Block> a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final MessageStatus f;
    public final ChatPageContext g;

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
        return this.g;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.d;
    }

    @Override // ic8.w
    public final String b() {
        return this.c;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        return MessageRequestType.SEND_TEXT;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.e;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return this.f;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "bizExt");
        return new g(this.a, this.b, this.c, r10, r11, this.f, this.g);
    }

    public g(List<Block> r2, String r3, String r4, Map<String, String> r5, Map<String, String> r6, MessageStatus r7, ChatPageContext r8) {
        Intrinsics.checkNotNullParameter(r2, "blocks");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
