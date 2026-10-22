package q6b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.message.send.CompressMediaStep;
import java.util.ArrayList;
import java.util.List;
import p6b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static d.b a(Message r3, CompressMediaStep.UploadMediaCallback r4, boolean r5) {
        List r0 = com.ss.android.lark.widget.richtext.d.d(((PostContent) r3.getContent()).getRichText());
        d.b r1 = new d.b();
        r1.a = ImSdkProxy.e().getCurrentUserId();
        r1.b = r3;
        r1.c = ((ArrayList) r0).size();
        r1.d = false;
        r1.e = r4;
        r1.f = r5;
        return r1;
    }
}
