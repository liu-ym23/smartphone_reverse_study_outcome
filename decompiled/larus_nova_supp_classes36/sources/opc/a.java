package opc;

import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.biz.im.api.l;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.suite.lark.platform.feature.forward.doubao.file.DoubaoFileForwardContent;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ConvertMessageParamsHandler
public final class a implements g<DoubaoFileForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 10;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r10) {
        DoubaoFileForwardContent r11 = (DoubaoFileForwardContent) r10;
        String r0 = null;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank(r11.a) == false) goto L8;
        return null;
    L8:
        if (StringsKt.isBlank(r11.b) == true) goto L24;
        int r1 = r11.c;
        if (r1 <= 0) goto L26;
        k r2 = new k(r11.a, r11.b, r1);
        MessageParams.a[] r3 = new MessageParams.a[1];
        l.a r4 = new l.a();
        String r5 = r11.b;
        if (r5 == null) goto L15;
        r4.B = r5;
    L15:
        r4.C = r2.a();
        r4.D = RangesKt.coerceAtLeast(r11.d, 0);
        String r12 = r11.e;
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L18;
        r0 = r12;
    L18:
        if (r0 != null) goto L20;
        r4.E = "*/*";
    L21:
        r4.F = FileState.UPLOADING;
        r4.J = r2;
        r3[0] = r4;
        return CollectionsKt.arrayListOf(r3);
    L20:
        r4.E = r0;
        goto L21
    L26:
        return null;
    L24:
        return null;
    }
}
