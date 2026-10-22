package qh8;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.list.expose.ExposureTrackerExtKt;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final a a = null;

    public static final class a implements com.larus.business.markdown.api.extplugin.image.b {
        public final void b() {
        }

        public a() {
        }

        public final void a(com.larus.business.markdown.api.extplugin.image.g r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
        }

        public final void c(final com.larus.business.markdown.api.extplugin.image.g r12) {
            Intrinsics.checkNotNullParameter(r12, "info");
            SimpleDraweeView r0 = r12.a;
            if ((r0 instanceof SimpleDraweeView) == false) goto L5;
            final ImageView r6 = r0;
        L6:
            if (r6 != null) goto L8;
            return;
        L8:
            final Context r7 = r6.getContext();
            a r1 = k.a;
            if (k.a(r12.c.getUrl()) == false) goto L12;
            r6.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            r6.getHierarchy().setActualImageColorFilter(null);
            r6.setOnClickListener(null);
            r6.setActualImageResource(2131240745);
            return;
        L12:
            final Ref.ObjectRef r2 = new Ref.ObjectRef();
            rt8.a r3 = r12.b;
            if ((r3 instanceof rt8.a) == false) goto L15;
            rt8.a r4 = r3;
        L16:
            if (r4 == null) goto L20;
            Map r5 = r4.getPayload();
            if (r5 == null) goto L20;
            final fh8.f r8 = fh8.h.b(r5);
        L21:
            final fh8.f r9 = r8;
            Function0 r10 = new qh8.a(r9, r12, r6, r7, this, r2);
            r2.element = r10;
            r10.invoke();
            com.larus.business.markdown.api.extplugin.image.f r11 = (com.larus.business.markdown.api.extplugin.image.f) CollectionsKt.firstOrNull(r12.e);
            boolean r13 = false;
            if (r11 == null) goto L28;
            String r14 = r11.a;
            if (r14 == null) goto L28;
            if (StringsKt.contains$default(r14, "card_type", false, 2, null) == true) goto L28;
            r13 = true;
        L28:
            if (r13 == true) goto L32;
            ExposureTrackerExtKt.a(r12.a, new b(r12, r8, this));
            return;
        L32:
            return;
        L20:
            r8 = null;
            goto L21
        L15:
            r4 = null;
            goto L16
        L5:
            r6 = null;
            goto L6
        }
    }

    public k() {
    }

    static {
        a = new a();
    }

    public static final boolean a(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (StringsKt.startsWith(r2, "file://", true) != true) goto L6;
        return true;
    }
}
