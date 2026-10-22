package nc8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.standarduikit.search.view.PureVideoView;
import com.larus.bmhome.chat.standarduikit.search.vm.e;
import com.larus.bmhome.chat.standarduikit.search.vm.n;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.im.bean.message.block.SearchVideoItem;
import gn8.c;
import hn8.h;
import hn8.i;
import hn8.j;
import hn8.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc8.d;
import kc8.j0;
import kc8.k0;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.b<oc8.a> {
    public c d;
    public final Lazy e;

    @Override // jc8.b
    public final String c() {
        return "PureVideoBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        c r0 = this.d;
        if (r0 == null) goto L8;
        e r1 = r0.d;
        if (r1 == null) goto L9;
        r1.d = null;
        return;
    L9:
        return;
    }

    public b() {
        this.e = LazyKt.lazy(new a(this));
    }

    public static void j(kc8.b r2) {
        if (r2 == null) goto L8;
        y r0 = r2.a;
        if (r0 == null) goto L8;
        Function1<Boolean, Unit> r1 = r0.B;
        if (r1 == null) goto L8;
        r1.invoke(Boolean.FALSE);
    L8:
        if (r2 == null) goto L15;
        y r3 = r2.a;
        if (r3 == null) goto L16;
        Function0<Unit> r4 = r3.C;
        if (r4 == null) goto L17;
        r4.invoke();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // jc8.b
    public final d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((oc8.a) r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    @Override // jc8.b
    public final void g(jc8.a r20) {
        oc8.a r1 = (oc8.a) r20;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = (kc8.b) jc8.c.a(this, kc8.b.class);
        BlockContent r3 = r1.a.getContent();
        if (r3 == null) goto L77;
        SearchRichMediaBlock r4 = r3.getRichMediaBlock();
        if (r4 == null) goto L78;
        List r5 = r4.creations;
        j0 r6 = null;
        if (r5 == null) goto L15;
        ?? r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        SearchVideoItem r9 = ((RichMediaItem) r8.next()).video;
        if (r9 == null) goto L11;
        r7.add(r9);
    L16:
        if (r7 != 0) goto L18;
        r7 = CollectionsKt.emptyList();
    L18:
        ?? r10 = r7;
        if (r2 == null) goto L24;
        k0 r11 = r2.g;
        if (r11 == null) goto L24;
        ExpandCardViewMode r12 = r11.a;
        if (r12 == null) goto L24;
    L25:
        ExpandCardViewMode r13 = r12;
        if (r2 == null) goto L30;
        k0 r14 = r2.g;
        if (r14 == null) goto L30;
        j0 r15 = r14.d;
    L31:
        boolean r16 = AppHost.a.isOversea();
        Boolean r17 = r4.videoInfinite;
        if (r17 == null) goto L34;
        boolean r18 = r17.booleanValue();
    L35:
        com.larus.bmhome.chat.standarduikit.search.vm.a r19 = new com.larus.bmhome.chat.standarduikit.search.vm.a(r10, r13, r15, r16, r18, r1.j());
        j(r2);
        c r21 = this.d;
        if (r21 == null) goto L67;
        e r22 = (e) this.e.getValue();
        Intrinsics.checkNotNullParameter(r19, "vmData");
        r21.d = r22;
        n r23 = (n) r21.b.getValue();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r19, "vmData");
        r23.a = r19;
        r23.b = r22;
        n r24 = (n) r21.b.getValue();
        com.larus.bmhome.chat.standarduikit.search.vm.a r25 = r24.a;
        if (r25 == null) goto L60;
        List r26 = r25.a;
        if (r26 == null) goto L60;
        List r27 = CollectionsKt.take(r26, 4);
        if (r27 == null) goto L60;
        List r28 = r27;
        ?? r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L45:
        if (r30.hasNext() == false) goto L61;
        SearchVideoItem r31 = (SearchVideoItem) r30.next();
        new j.a();
        j r32 = new j(r31.id, r31.itemId, r31.hostPageUrl, r31.sourceAppIcon, r31.sourceAppIconV2, r31.albumImage, r31.videoCaptions);
        com.larus.bmhome.chat.standarduikit.search.vm.a r33 = r24.a;
        if (r33 == null) goto L50;
        ExpandCardViewMode r110 = r33.b;
        if (r110 == null) goto L50;
    L51:
        if (r33 == null) goto L53;
        boolean r111 = r33.d;
    L54:
        if (r33 == null) goto L58;
        Message r34 = r33.g;
        if (r34 == null) goto L58;
        String r35 = r34.getMessageId();
    L59:
        r29.add(new l(r32, r110, r111, r35));
    L58:
        r35 = null;
        goto L59
    L53:
        r111 = false;
    L50:
        r110 = ExpandCardViewMode.NORMAL;
    L61:
        if (r29 != 0) goto L63;
        r29 = CollectionsKt.emptyList();
    L63:
        com.larus.bmhome.chat.standarduikit.search.vm.a r36 = r24.a;
        if (r36 == null) goto L66;
        r6 = r36.c;
    L66:
        Pair r37 = TuplesKt.to(new h(r29, r6), (i) ((n) r21.b.getValue()).c.getValue());
        ((PureVideoView) r21.c.getValue()).r((h) r37.component1(), (i) r37.component2());
    L60:
        r29 = 0;
    L67:
        j(r2);
        return;
    L34:
        r18 = false;
    L30:
        r15 = null;
    L24:
        r12 = ExpandCardViewMode.NORMAL;
        goto L25
    L15:
        r7 = 0;
        goto L16
    L78:
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        c r0 = this.d;
        if (r0 != null) goto L6;
        r0 = new c(r2.getContext());
        this.d = r0;
    L6:
        return (PureVideoView) r0.c.getValue();
    }
}
