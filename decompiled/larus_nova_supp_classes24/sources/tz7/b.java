package tz7;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import uz7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends c<ImageView, tz7.a> {

    public static final class a {
    }

    static {
    }

    @Override // uz7.c
    public final void b(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public b() {
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void unbind(View r1) {
        b((ImageView) r1);
    }

    @Override // uz7.c
    public final /* bridge */ /* synthetic */ void a(ImageView r1, AvatarModel r2) {
        c(r1, (tz7.a) r2);
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void bind(View r1, Object r2) {
        c((ImageView) r1, (tz7.a) r2);
    }

    public final void c(ImageView r4, tz7.a r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "model");
        int r1 = uz7.b.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        if (((uz7.b) r4.getTag(2131372195)) != null) goto L17;
        String r0 = r5.m;
        if (r0 != null) goto L7;
    L9:
        String r2 = r5.l;
        if (r2 != null) goto L12;
    L14:
        super.a(r4, r5);
        return;
    L12:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        Log.i("DocsMetaBinder", "DocsMetaBinder bind,not meta");
        mbb.c.e(r4, r5.l, r5.n, r5.o);
        return;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        Log.i("DocsMetaBinder", "DocsMetaBinder bind with meta");
        mbb.c.f(r4, r5.l, r5.m, r5.n, r5.o);
        return;
    L17:
        throw null;
    }
}
