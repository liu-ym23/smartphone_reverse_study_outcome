package fb8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.platform.service.z2;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends jc8.a implements jc8.j {
    @Override // jc8.j
    public final String c() {
        return "";
    }

    @Override // jc8.a
    public final String g() {
        return "TextBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.e;
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        TextBlock r2 = r0.getTextBlock();
    L7:
        if (r4 == false) goto L12;
        if (r2 == null) goto L10;
        r1 = r2.iconUrlDark;
    L10:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L12:
        if (r2 == null) goto L14;
        r1 = r2.iconUrl;
    L14:
        if (r1 != null) goto L17;
        return "";
    L5:
        r2 = null;
        goto L7
    }

    @Override // jc8.a
    public final boolean e(jc8.a r5) {
        if ((r5 instanceof l) == true) goto L5;
        return false;
    L5:
        BlockContent r0 = this.a.getContent();
        TextBlock r2 = null;
        if (r0 == null) goto L8;
        TextBlock r1 = r0.getTextBlock();
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.hashCode();
    L12:
        l r6 = (l) r5;
        BlockContent r4 = r6.a.getContent();
        if (r4 == null) goto L15;
        r2 = r4.getTextBlock();
    L15:
        if (r2 == null) goto L17;
        int r7 = r2.hashCode();
    L19:
        if (r3 != r7) goto L32;
        List r8 = this.a.getMetaInfo();
        if (r8 == null) goto L23;
        int r9 = r8.hashCode();
    L24:
        List r10 = r6.a.getMetaInfo();
        if (r10 == null) goto L27;
        int r11 = r10.hashCode();
    L28:
        if (r9 != r11) goto L32;
        if (o(i(), r6.i()) == false) goto L32;
        boolean r12 = true;
    L34:
        if (ObricFeatureServiceDelegate.b.a() == false) goto L43;
        z2 r13 = z2.a;
        if (r12 == true) goto L38;
        return false;
    L38:
        if (m() == r6.m()) goto L40;
        return false;
    L40:
        if (n() != r6.n()) goto L46;
        return true;
    L46:
        return false;
    L43:
        return r12;
    L27:
        r11 = 0;
        goto L28
    L23:
        r9 = 0;
    L32:
        r12 = false;
        goto L34
    L17:
        r7 = 0;
        goto L19
    L11:
        r3 = 0;
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    public l(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }

    public final boolean o(List<? extends jc8.a> r8, List<? extends jc8.a> r9) {
        if (r8.size() == r9.size()) goto L5;
        return false;
    L5:
        Collection r0 = CollectionsKt.getIndices(r8);
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        IntIterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        int r2 = r1.nextInt();
        jc8.a r4 = (jc8.a) ListProtector.get(r8, r2);
        jc8.a r3 = (jc8.a) ListProtector.get(r9, r2);
        if (r4.a.hashCode() == r3.a.hashCode()) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L12;
        return false;
    L16:
        if (o(r4.i(), r3.i()) == false) goto L18;
        r5 = true;
    L9:
        return true;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L9
    }
}
