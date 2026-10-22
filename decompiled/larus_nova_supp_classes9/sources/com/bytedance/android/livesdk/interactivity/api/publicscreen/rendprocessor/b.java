package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements k<s> {
    public final String a;
    public final List<w42.a> b;
    public final e52.a c;

    public static final class a extends nk6.a {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.a(r2);
        }

        public final boolean a(View r2, ek6.c r3, ClickableSpan r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "action");
            Intrinsics.checkNotNullParameter(r4, "span");
            if ((r3 instanceof ib2.a) == true) goto L5;
            r3 = null;
        L5:
            ib2.a r5 = (ib2.a) r3;
            if (r5 == null) goto L10;
            tb2.b r6 = r5.a;
            if (r6 == null) goto L10;
            return this.a.b(r2, r6, r4);
        L10:
            return false;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final String getName() {
        return this.a;
    }

    public b(e52.a r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessageConfig");
        this.c = r2;
        this.a = "PluginMessageRenderTextProcessorV2";
        this.b = CollectionsKt.listOf(new w42.a());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void a(s r2) {
        s r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "message");
        r3.j = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final View.OnClickListener c(l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return new a(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void d(s r4) {
        s r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.j != null) goto L6;
        r5.j = f(r5, new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.c)), true));
        return;
    }

    public final com.bytedance.android.livesdk.interactivity.service.richcontent.config.b e(f r4) {
        return new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.c)), r4.a);
    }

    public final d f(s r6, com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r7) {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        w42.a r1 = (w42.a) r0.next();
        tb2.d r2 = r6.k().a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r6, "model");
        if (r6.getType() != PublicScreenConfig$MessageModelType.AI_AUTO_REPLY) goto L4;
        Iterator<tb2.c> r3 = r2.a.iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        tb2.c r4 = r3.next();
        if (r4.getType() != PieceType.IMAGE.getPieceType()) goto L10;
        if (Intrinsics.areEqual("ai_reply_pic", r4.getSchemaKey()) == false) goto L10;
        ITextPieceImage r5 = r4.getImageValue();
        if (r5 == null) goto L18;
        r5.setHeight((int) UtilityKotlinExtentionsKt.h(14.0f));
    L18:
        ITextPieceImage r8 = r4.getImageValue();
        if (r8 == null) goto L10;
        r8.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        goto L10
    L21:
        int r9 = mb2.c.a;
        ek6.e r10 = mb2.c.c(r6.k().a, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.c), "public_screen");
        return new d(LiveRichContentEngine.a().a().e(r10, r7), new i(0));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final j b(s r5, f r6, k.a<s> r7) {
        s r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r6, "config");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        e r1 = r8.j;
        if ((r1 instanceof d) == true) goto L5;
        r1 = null;
    L5:
        d r2 = (d) r1;
        r0.element = r2;
        if (r2 != null) goto L9;
        r0.element = f(r8, e(r6));
    L9:
        if (((d) r0.element).a.b == true) goto L11;
        LiveRichContentEngine.a().a().d(((d) r0.element).a, e(r6), new c(r7, r8, r0));
    L11:
        i r9 = ((d) r0.element).b;
        if (r9 == null) goto L14;
        r9.a = r8.k().c;
    L14:
        d r10 = (d) r0.element;
        return new j(r10.a.a, r10.b);
    }
}
