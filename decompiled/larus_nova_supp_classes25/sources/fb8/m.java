package fb8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m extends jc8.a implements jc8.j {
    public final c i;
    public final Boolean j;
    public final boolean k;
    public final jc8.a l;
    public final Integer m;

    @Override // jc8.a
    public final String g() {
        return "TextBlockBizModelV2";
    }

    @Override // jc8.j
    public final String c() {
        BlockContent r0 = this.a.getContent();
        if (r0 == null) goto L7;
        TextBlock r1 = r0.getTextBlock();
        if (r1 == null) goto L7;
        String r2 = r1.summary;
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
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
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        BlockContent r1 = this.a.getContent();
        TextBlock r2 = null;
        if (r1 == null) goto L11;
        TextBlock r3 = r1.getTextBlock();
    L12:
        if (r3 == null) goto L14;
        int r4 = r3.hashCode();
    L15:
        m r6 = (m) r5;
        BlockContent r7 = r6.a.getContent();
        if (r7 == null) goto L18;
        r2 = r7.getTextBlock();
    L18:
        if (r2 == null) goto L20;
        int r8 = r2.hashCode();
    L22:
        if (r4 != r8) goto L41;
        List r9 = this.a.getMetaInfo();
        if (r9 == null) goto L26;
        int r10 = r9.hashCode();
    L27:
        List r11 = r6.a.getMetaInfo();
        if (r11 == null) goto L30;
        int r12 = r11.hashCode();
    L31:
        if (r10 != r12) goto L41;
        if (o(i(), r6.i()) == false) goto L41;
        if (this.a.isFinish() != r6.a.isFinish()) goto L41;
        if (n() != r6.n()) goto L41;
        if (Intrinsics.areEqual(this.m, r6.m) == false) goto L41;
        boolean r13 = true;
    L43:
        if (ObricFeatureServiceDelegate.b.a() == false) goto L50;
        z2 r14 = z2.a;
        if (r13 == true) goto L47;
        return false;
    L47:
        if (m() != r6.m()) goto L52;
        return true;
    L52:
        return false;
    L50:
        return r13;
    L30:
        r12 = 0;
        goto L31
    L26:
        r10 = 0;
    L41:
        r13 = false;
        goto L43
    L20:
        r8 = 0;
        goto L22
    L14:
        r4 = 0;
        goto L15
    L11:
        r3 = null;
        goto L12
    }

    public final boolean p(boolean r8) {
        Boolean r0 = this.j;
        if (r0 != null) goto L5;
        boolean r1 = false;
        if (this.k == false) goto L28;
        Message r9 = j();
        ComplexTaskDelegate r2 = ComplexTaskDelegate.b;
        if (r2.f(r9) == true) goto L11;
    L13:
        boolean r10 = false;
    L14:
        Object r3 = this.l;
        if ((r3 instanceof gb8.g) == false) goto L17;
        gb8.g r4 = (gb8.g) r3;
    L18:
        if (r4 == null) goto L20;
        boolean r5 = r4.b(false);
    L21:
        FLogger.a.d("shirley_test", "deepThinkFinished, isParentDeepThinkTyping = " + r5 + ", isLastBlockModel = " + n() + ", notShowStreamingAnimation = " + r10);
        if (r5 == false) goto L55;
        if (n() == false) goto L55;
        if (r10 == true) goto L55;
        r1 = true;
    L55:
        return !r1;
    L20:
        r5 = false;
        goto L21
    L17:
        r4 = null;
        goto L18
    L11:
        if (r2.i(r9, this.a) == false) goto L13;
        r10 = true;
        goto L14
    L28:
        Message r6 = j();
        int r7 = r6.getMessageStatusLocal();
        if (r8 == false) goto L41;
        if (r7 == 23) goto L52;
        if (r7 == 22) goto L52;
        if (r7 == 21) goto L52;
        if (com.larus.bmhome.chat.bean.d.I0(r6) == true) goto L39;
        if (r6.getMessageStatusLocal() != 20) goto L52;
    L39:
        if (n() == false) goto L52;
    L54:
        return r1;
    L52:
        r1 = true;
        goto L54
    L41:
        if (r7 == 23) goto L52;
        if (r6.getMessageStatusLocal() == 22) goto L52;
        if (com.larus.bmhome.chat.bean.d.I0(r6) == true) goto L51;
        if (r6.getMessageStatusLocal() == 20) goto L51;
        if (com.larus.bmhome.chat.bean.d.Q0(r6) == false) goto L52;
    L51:
        if (n() == true) goto L54;
    L5:
        return r0.booleanValue();
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

    public m(Message r2, Block r3, c r4, Boolean r5, boolean r6, jc8.a r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "blockMessageWrapper");
        super(r2, r3);
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
    }
}
