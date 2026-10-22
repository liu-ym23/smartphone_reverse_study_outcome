package bg8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.list.cell.sticker.StickerImageCell;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ StickerImageCell a;

    public /* synthetic */ f(StickerImageCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatParam r0 = (ChatParam) lf8.a.c(this.a, ChatParam.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ChatParam(null, null, null, null, null, 255);
    }
}
