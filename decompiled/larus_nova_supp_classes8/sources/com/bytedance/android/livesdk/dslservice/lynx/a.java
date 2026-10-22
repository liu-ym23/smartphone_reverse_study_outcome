package com.bytedance.android.livesdk.dslservice.lynx;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.livesdk.dsl.recyclerview.i;
import com.lynx.tasm.TemplateData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends com.bytedance.android.livesdk.dslservice.a {
    public static final /* synthetic */ int e = 0;
    public r c;
    public final AnnieXLynxView d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.lynx.a$a, reason: collision with other inner class name */
    public static final class C0299a {
    }

    static {
    }

    @Override // yt1.k
    public final void a(i r1) {
    }

    @Override // yt1.k
    public final void release() {
        this.d.destroy();
    }

    @Override // yt1.k
    public final View getView() {
        return this.d;
    }

    public a(AnnieXLynxView r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.d = r2;
    }

    @Override // yt1.k
    public final void b(au1.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "lifeType");
        r r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        if (r4 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r3, au1.a.b.b) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r3, au1.a.c.b) == false) goto L14;
        this.d.H();
        return;
    L14:
        if (Intrinsics.areEqual(r3, au1.a.C0001a.b) == false) goto L19;
        this.d.F();
        return;
    L19:
        return;
    L5:
        if (r0.b == true) goto L8;
        goto L6
    }

    @Override // yt1.k
    public final void c(String r1, Map<String, ? extends Object> r2, int r3) {
        this.d.updateData(TemplateData.fromMap(r2));
    }
}
