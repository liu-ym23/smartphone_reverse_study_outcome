package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.AudioContent;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import ic8.w;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zd9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "deprecated in social")
public final class a implements w {
    public final AudioContent a;
    public final ChatPageContext b;

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return null;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return null;
    }

    @Override // ic8.w
    public final String b() {
        return null;
    }

    @Override // ic8.w
    public final int contentType() {
        return 11;
    }

    @Override // ic8.w
    public final Map<String, String> e() {
        return null;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
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
        String r0 = i.c(this.a, AudioContent.Companion.serializer());
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.b;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        return MessageRequestType.SEND_AUDIO;
    }

    public a(AudioContent r1, ChatPageContext r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        Intrinsics.checkNotNullParameter(r3, "bizExt");
        return new a(this.a, this.b);
    }
}
