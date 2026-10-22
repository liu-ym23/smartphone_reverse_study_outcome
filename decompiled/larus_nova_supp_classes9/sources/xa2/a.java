package xa2;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import ek6.e;
import h52.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements k<c> {
    public final String a;
    public final e52.a b;

    /* JADX INFO: renamed from: xa2.a$a, reason: collision with other inner class name */
    public static final class C0296a extends nk6.a {
        public final /* synthetic */ l a;

        public C0296a(l r1) {
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
            if (r5 == null) goto L12;
            tb2.b r6 = r5.a;
            if (r6 == null) goto L12;
            if (this.a.b(r2, r6, r4) != true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final String getName() {
        return this.a;
    }

    public a(e52.a r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessageConfig");
        this.b = r2;
        this.a = "MessageModelRenderTextProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void a(c r2) {
        c r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "message");
        r3.c(null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final View.OnClickListener c(l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return new C0296a(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void d(c r4) {
        c r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.b() != null) goto L6;
        r5.c(f(r5, new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.b)), true)));
        return;
    }

    public final com.bytedance.android.livesdk.interactivity.service.richcontent.config.b e(f r4) {
        return new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.b)), r4.a);
    }

    public final d f(c r3, com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r4) {
        int r0 = mb2.c.a;
        e r5 = mb2.c.c(r3.getTextInfo().a, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.b), "public_screen");
        return new d(LiveRichContentEngine.a().a().e(r5, r4), new i(0));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final j b(c r5, f r6, k.a<c> r7) {
        c r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r6, "config");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e r1 = r8.b();
        if ((r1 instanceof d) == true) goto L5;
        r1 = null;
    L5:
        d r2 = (d) r1;
        r0.element = r2;
        if (r2 != null) goto L9;
        r0.element = f(r8, e(r6));
    L9:
        if (((d) r0.element).a.b == true) goto L11;
        LiveRichContentEngine.a().a().d(((d) r0.element).a, e(r6), new b(r7, r8, r0));
    L11:
        i r9 = ((d) r0.element).b;
        if (r9 == null) goto L14;
        r9.a = r8.getTextInfo().c;
    L14:
        d r10 = (d) r0.element;
        return new j(r10.a.a, r10.b);
    }
}
