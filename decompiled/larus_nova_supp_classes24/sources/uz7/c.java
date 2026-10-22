package uz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class c<V extends ImageView, M extends AvatarModel> implements b08.b<V, M> {
    public c() {
    }

    public void b(V r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void unbind(View r1) {
        b((ImageView) r1);
    }

    public void a(V r4, M r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "model");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        Drawable r2 = null;
        if (((b) r4.getTag(2131372195)) != null) goto L17;
        Context r0 = r4.getContext();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Drawable r3 = r5.a;
        if (r3 == null) goto L7;
        r2 = r3;
    L10:
        if (r2 == null) goto L13;
        r4.setImageDrawable(r2);
        return;
    L13:
        if (r5.h == false) goto L15;
        rz7.a.a.getAvatarLoader().a(r4.getContext(), r4, r5);
        return;
    L15:
        rz7.a.a.getAvatarLoader().b(r4.getContext(), r4, r5);
        return;
    L7:
        int r6 = r5.b;
        if (r6 <= 0) goto L10;
        r2 = UDIconUtils.getIconDrawable(r0, r6);
        goto L10
    L17:
        throw null;
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void bind(View r1, Object r2) {
        a((ImageView) r1, (AvatarModel) r2);
    }
}
