package uz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sz7.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends c<ImageView, d> {
    @Override // uz7.c
    public final void b(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public e() {
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void unbind(View r1) {
        b((ImageView) r1);
    }

    @Override // uz7.c
    public final /* bridge */ /* synthetic */ void a(ImageView r1, AvatarModel r2) {
        c(r1, (d) r2);
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void bind(View r1, Object r2) {
        c((ImageView) r1, (d) r2);
    }

    public final void c(ImageView r4, d r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "model");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        Drawable r2 = null;
        if (((b) r4.getTag(2131372195)) != null) goto L24;
        Context r0 = r4.getContext();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Drawable r3 = r5.a;
        if (r3 == null) goto L7;
        r2 = r3;
    L10:
        if (r2 != null) goto L22;
        boolean r6 = v.a;
        if (v.a.a() == false) goto L21;
        String r7 = r5.c;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L21;
    L16:
        if (StringsKt.isBlank(r7) == true) goto L18;
        r8 = true;
    L21:
        rz7.a.a.getDocIconProvider().a();
        r4.setImageResource(0);
        return;
    L22:
        super.a(r4, r5);
        return;
    L7:
        int r9 = r5.b;
        if (r9 <= 0) goto L10;
        r2 = UDIconUtils.getIconDrawable(r0, r9);
        goto L10
    L24:
        throw null;
    }
}
