package h98;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.avlink.env.diary.block.DiaryDiaryImageAdapter;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DoraDiaryImageBlock;
import com.larus.im.bean.message.block.DoraImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kc8.t;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends jc8.b<b> {
    public RecyclerView d;
    public DiaryDiaryImageAdapter e;
    public Boolean f;

    @Override // jc8.b
    public final String c() {
        return "DiaryImageBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        RecyclerView r0 = this.d;
        if (r0 == null) goto L5;
        r0.setAdapter(null);
    L5:
        this.e = null;
        this.f = null;
    }

    public f() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((b) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r19) {
        b r1 = (b) r19;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        BlockContent r2 = r1.a.getContent();
        if (r2 == null) goto L100;
        DoraDiaryImageBlock r3 = r2.getDoraImageBlock();
        if (r3 == null) goto L103;
        List r4 = r3.images;
        if (r4 == null) goto L101;
        List<DoraImage> r5 = CollectionsKt.filterNotNull(r4);
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.isEmpty() == true) goto L105;
        r5.size();
        RecyclerView r6 = this.d;
        if (r6 == null) goto L18;
        r6.getHeight();
    L18:
        RecyclerView r7 = this.d;
        if (r7 == null) goto L21;
        r7.getMeasuredHeight();
    L21:
        kc8.b r8 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r8 == null) goto L24;
        t r9 = r8.n;
    L26:
        if (r9 != null) goto L28;
    L30:
        final boolean r10 = false;
    L32:
        if (Intrinsics.areEqual(this.f, Boolean.valueOf(r10)) == true) goto L45;
        this.f = Boolean.valueOf(r10);
        RecyclerView r11 = this.d;
        if (r11 == null) goto L39;
        if (r10 == false) goto L37;
        RecyclerView.LayoutManager r12 = new n(r11.getContext());
    L38:
        r11.setLayoutManager(r12);
        goto L39
    L37:
        r12 = new LinearLayoutManager(r11.getContext(), 0, false);
    L39:
        RecyclerView r13 = this.d;
        if (r13 == null) goto L42;
        r13.setClipChildren(r10);
    L42:
        DiaryDiaryImageAdapter r14 = new DiaryDiaryImageAdapter(r10);
        this.e = r14;
        RecyclerView r15 = this.d;
        if (r15 == null) goto L45;
        r15.setAdapter(r14);
    L45:
        DiaryDiaryImageAdapter r16 = this.e;
        if (r16 == null) goto L87;
        Intrinsics.checkNotNullParameter(r5, "images");
        r16.b = r5;
        int r17 = r5.size();
        ArrayList r18 = new ArrayList();
        if (r16.a == false) goto L82;
        if (r17 != 1) goto L54;
        DoraImage r20 = (DoraImage) CollectionsKt.getOrNull(r5, 0);
        if (r20 == null) goto L86;
        r18.add(new m(r20.thumbnailUrl, r20.largeUrl, 0.0f, 8, 0));
    L86:
        r16.submitList(r18);
        goto L87
    L54:
        if (r17 < 2) goto L69;
        if (r17 > 4) goto L69;
        DoraImage r21 = (DoraImage) CollectionsKt.getOrNull(r5, 0);
        if (r21 == null) goto L59;
        r18.add(new m(r21.thumbnailUrl, r21.largeUrl, 3.0f, 8, 0));
    L59:
        DoraImage r22 = (DoraImage) CollectionsKt.getOrNull(r5, 1);
        if (r22 == null) goto L62;
        r18.add(new m(r22.thumbnailUrl, r22.largeUrl, -3.0f, 8, 0));
    L62:
        DoraImage r23 = (DoraImage) CollectionsKt.getOrNull(r5, 2);
        if (r23 == null) goto L65;
        r18.add(new m(r23.thumbnailUrl, r23.largeUrl, 3.0f, 8, 0));
    L65:
        DoraImage r24 = (DoraImage) CollectionsKt.getOrNull(r5, 3);
        if (r24 == null) goto L86;
        r18.add(new m(r24.thumbnailUrl, r24.largeUrl, -3.0f, 8, 0));
    L69:
        if (r17 < 5) goto L86;
        DoraImage r110 = (DoraImage) CollectionsKt.getOrNull(r5, 0);
        if (r110 == null) goto L73;
        r18.add(new m(r110.thumbnailUrl, r110.largeUrl, 0.0f, 12, 0));
    L73:
        DoraImage r25 = (DoraImage) CollectionsKt.getOrNull(r5, 1);
        if (r25 == null) goto L76;
        r18.add(new m(r25.thumbnailUrl, r25.largeUrl, -3.0f, 8, 0));
    L76:
        DoraImage r26 = (DoraImage) CollectionsKt.getOrNull(r5, 2);
        if (r26 == null) goto L79;
        r18.add(new m(r26.thumbnailUrl, r26.largeUrl, 3.0f, 8, 0));
    L79:
        DoraImage r27 = (DoraImage) CollectionsKt.getOrNull(r5, 3);
        if (r27 == null) goto L86;
        r18.add(new m(r27.thumbnailUrl, r27.largeUrl, -3.0f, r17 - 4));
        goto L86
    L82:
        Iterator<T> r28 = r5.iterator();
    L84:
        if (r28.hasNext() == false) goto L86;
        DoraImage r29 = (DoraImage) r28.next();
        r18.add(new m(r29.thumbnailUrl, r29.largeUrl, 0.0f, 12, 0));
    L87:
        RecyclerView r30 = this.d;
        if (r30 == null) goto L90;
        int r31 = r30.getMeasuredHeight();
    L91:
        if (r31 != 0) goto L95;
        RecyclerView r32 = this.d;
        if (r32 == null) goto L95;
        r32.post(new c(this));
    L95:
        DiaryDiaryImageAdapter r33 = this.e;
        if (r33 == null) goto L102;
        r33.c = new d(this, r10);
        return;
    L102:
        return;
    L90:
        r31 = 0;
        goto L91
    L28:
        if (r9.a != true) goto L30;
        r10 = true;
        goto L32
    L24:
        r9 = null;
        goto L26
    L105:
        return;
    L101:
        return;
    L103:
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563209, r4, false);
        RecyclerView r0 = r5.findViewById(2131369042);
        this.d = r0;
        if (r0 == null) goto L5;
        r0.setNestedScrollingEnabled(false);
    L5:
        Objects.toString(r5.getLayoutParams());
        RecyclerView r1 = this.d;
        if (r1 == null) goto L8;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L9:
        Objects.toString(r2);
        Intrinsics.checkNotNull(r5);
        return r5;
    L8:
        r2 = null;
        goto L9
    }
}
