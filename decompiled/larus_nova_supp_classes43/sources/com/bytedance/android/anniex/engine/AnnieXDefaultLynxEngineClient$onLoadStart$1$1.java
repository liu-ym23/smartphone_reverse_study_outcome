package com.bytedance.android.anniex.engine;

import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.ui.e;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXDefaultLynxEngineClient$onLoadStart$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Uri $uri;
    final /* synthetic */ a this$0;

    public AnnieXDefaultLynxEngineClient$onLoadStart$1$1(a r1, Uri r10) {
        this.this$0 = r1;
        this.$uri = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m218invoke() {
        WeakReference<e> r0 = this.this$0.h;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        Uri r10 = this.$uri;
        WeakReference<AnnieXLynxView> r11 = this.this$0.i;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = r11.get();
    L10:
        r1.n(r10, r12);
        return;
    L9:
        r12 = null;
        goto L10
    L13:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m218invoke();
        return Unit.INSTANCE;
    }
}
