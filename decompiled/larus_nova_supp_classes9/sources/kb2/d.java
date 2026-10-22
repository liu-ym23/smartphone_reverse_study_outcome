package kb2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import jb2.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends kk6.a<f> {
    public d() {
    }

    public final String e(ek6.d r2) {
        f r3 = (f) r2;
        Intrinsics.checkNotNullParameter(r3, "content");
        String r4 = kk6.a.h(r3);
        if (TextUtils.equals(r4, "$") == false) goto L6;
        return "**";
    L6:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [android.text.style.CharacterStyle, pb2.a] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    public final void a(ik6.b r6, ek6.d r7, ek6.b r8, Drawable r9) {
        f r10 = (f) r7;
        Intrinsics.checkNotNullParameter(r6, "editor");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r8, "resourceInfo");
        Intrinsics.checkNotNullParameter(r9, "drawable");
        if ((r9 instanceof NinePatchDrawable) == false) goto L5;
        NinePatchDrawable r0 = (NinePatchDrawable) r9;
        ?? r11 = new pb2.c(r0, r10.d, r10.e, r0.getMinimumHeight() * r10.f);
    L6:
        ImageStyle r1 = ((fk6.a) r10).b;
        if (r1 != null) goto L9;
        r1 = kk6.a.a;
    L9:
        r11.g(r1, r9.getIntrinsicWidth(), r9.getIntrinsicHeight());
        r11.m = r10.g;
        r6.a(r10, r11);
        return;
    L5:
        r11 = new pb2.a(r9);
        goto L6
    }
}
