package com.larus.business.markdown.fresco;

import android.content.Context;
import android.graphics.Rect;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.business.markdown.api.extplugin.image.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/business/markdown/fresco/DefaultImgWidget;", "Landroid/widget/FrameLayout;", "Lcom/larus/business/markdown/api/extplugin/image/d;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultImgWidget extends FrameLayout implements com.larus.business.markdown.api.extplugin.image.d {
    public static final /* synthetic */ int i = 0;
    public final com.larus.business.markdown.api.extplugin.image.b a;
    public Size b;
    public Size c;
    public Job d;
    public final List<com.larus.business.markdown.api.extplugin.image.c> e;
    public final List<Pair<Integer, View>> f;
    public final List<f> g;
    public final AtomicInteger h;

    public DefaultImgWidget(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 6);
    }

    public DefaultImgWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 4);
    }

    @Override // com.larus.business.markdown.api.extplugin.image.d
    public final DefaultImgWidget asView() {
        return this;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.d
    public final void b(Spanned r2, com.larus.business.markdown.api.extplugin.image.c r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "span");
        c(r2, r3);
    }

    public final void c(Spanned r8, com.larus.business.markdown.api.extplugin.image.c r9) {
        ((ArrayList) this.e).clear();
        List<com.larus.business.markdown.api.extplugin.image.c> r0 = this.e;
        int r3 = 0;
        Object[] r10 = r8.getSpans(0, r8.length(), com.larus.business.markdown.api.extplugin.image.c.class);
        ArrayList r1 = new ArrayList();
        int r2 = r10.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        Object r5 = r10[r4];
        if (((com.larus.business.markdown.api.extplugin.image.c) r5).getWidget() == null) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r1.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L11:
        ArrayList r7 = (ArrayList) r0;
        r7.addAll(CollectionsKt.reversed(r1));
        ((ArrayList) this.f).clear();
        List<Pair<Integer, View>> r11 = this.f;
        List<com.larus.business.markdown.api.extplugin.image.c> r12 = this.e;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = ((ArrayList) r12).iterator();
    L13:
        if (r14.hasNext() == false) goto L18;
        Object r15 = r14.next();
        int r16 = r3 + 1;
        if (r3 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        Integer r17 = Integer.valueOf(r3);
        com.larus.business.markdown.api.extplugin.image.d r18 = ((com.larus.business.markdown.api.extplugin.image.c) r15).getWidget();
        Intrinsics.checkNotNull(r18);
        r13.add(TuplesKt.to(r17, r18.asView()));
        r3 = r16;
        goto L13
    L18:
        ((ArrayList) r11).addAll(r13);
        ((ArrayList) this.g).clear();
        List<f> r19 = this.g;
        List<com.larus.business.markdown.api.extplugin.image.c> r20 = this.e;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = ((ArrayList) r20).iterator();
    L20:
        if (r22.hasNext() == false) goto L22;
        String r23 = ((com.larus.business.markdown.api.extplugin.image.c) r22.next()).getUrl();
        r21.add(new f(r23, r23, r23));
        goto L20
    L22:
        ((ArrayList) r19).addAll(r21);
        this.h.set(((ArrayList) this.e).indexOf(r9));
    }

    public DefaultImgWidget(Context r2, AttributeSet r3, com.larus.business.markdown.api.extplugin.image.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = r4;
        this.b = new Size(0, 0);
        this.c = new Size(0, 0);
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new AtomicInteger(0);
    }

    public /* synthetic */ DefaultImgWidget(Context r2, AttributeSet r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r2, r3, null);
    }

    public final Size a(TextView r12, Spanned r13, com.larus.business.markdown.api.extplugin.image.c r14, Rect r15) {
        Intrinsics.checkNotNullParameter(r12, "textView");
        Intrinsics.checkNotNullParameter(r13, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r14, "span");
        Intrinsics.checkNotNullParameter(r15, "rect");
        this.b = new Size(r15.width(), r15.height());
        this.c = new Size(r15.width(), r15.height());
        Job r16 = this.d;
        if (r16 == null) goto L5;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
    L5:
        this.d = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DefaultImgWidget$bindData$1(this, r14, r13, r12, null), 3, null);
        return this.b;
    }
}
