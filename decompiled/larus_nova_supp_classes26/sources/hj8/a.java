package hj8;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.InteractionAskIcon;
import java.util.List;
import jc8.j;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final InteractionAskBlock i;
    public final int j;
    public final List<String> k;
    public final String l;
    public final boolean m;
    public final int n;
    public final List<ResourceItemBean> o;
    public final boolean p;
    public final String q;

    public a() {
        throw null;
    }

    public final String g() {
        return "InteractionAskBlockBizModel";
    }

    public final String c() {
        InteractionAskContent r0 = this.i.getThinkingContent();
        if (r0 == null) goto L5;
        String r1 = r0.getProcessingStatusText();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.q0;
    }

    public final int o() {
        int r0 = this.j;
        List r1 = this.i.getQuestions();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        return RangesKt.coerceIn(r0, 0, RangesKt.coerceAtLeast(r1.size() - 1, 0));
    }

    public final String a(boolean r4) {
        InteractionAskContent r0 = this.i.getThinkingContent();
        String r1 = null;
        if (r0 == null) goto L5;
        InteractionAskIcon r2 = r0.getIcon();
    L7:
        if (r4 == false) goto L12;
        if (r2 == null) goto L10;
        r1 = r2.getUrlDark();
    L10:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L12:
        if (r2 == null) goto L14;
        r1 = r2.getUrlLight();
    L14:
        if (r1 != null) goto L17;
        return "";
    L5:
        r2 = null;
        goto L7
    }

    public final boolean e(jc8.a r4) {
        if ((r4 instanceof a) == true) goto L5;
        return false;
    L5:
        a r5 = (a) r4;
        if (Intrinsics.areEqual(this.i, r5.i) == true) goto L8;
        return false;
    L8:
        if (o() == r5.o()) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.k, r5.k) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.l, r5.l) == true) goto L14;
        return false;
    L14:
        if (this.m == r5.m) goto L16;
        return false;
    L16:
        if (this.n == r5.n) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.o, r5.o) == true) goto L20;
        return false;
    L20:
        if (this.p == r5.p) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.q, r5.q) == false) goto L33;
        return true;
    L33:
        return false;
    }

    public a(Message r5, Block r6, InteractionAskBlock r7, String r8) {
        List<String> r0 = CollectionsKt.emptyList();
        List<ResourceItemBean> r1 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "block");
        Intrinsics.checkNotNullParameter(r7, "interactionAskBlock");
        Intrinsics.checkNotNullParameter(r0, "selectedOptionIds");
        Intrinsics.checkNotNullParameter("", "inputText");
        Intrinsics.checkNotNullParameter(r1, "attachmentItems");
        Intrinsics.checkNotNullParameter(r8, "containerScene");
        super(r5, r6);
        this.i = r7;
        this.j = 0;
        this.k = r0;
        this.l = "";
        this.m = false;
        this.n = 0;
        this.o = r1;
        this.p = true;
        this.q = r8;
    }
}
