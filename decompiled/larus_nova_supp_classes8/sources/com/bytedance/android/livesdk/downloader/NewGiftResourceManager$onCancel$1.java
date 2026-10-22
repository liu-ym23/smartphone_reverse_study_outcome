package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class NewGiftResourceManager$onCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $resourceRequest;
    final /* synthetic */ NewGiftResourceManager this$0;

    public NewGiftResourceManager$onCancel$1(NewGiftResourceManager r1, e r2) {
        this.this$0 = r1;
        this.$resourceRequest = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m531invoke() {
        f r0 = this.this$0.a.get(Long.valueOf(this.$resourceRequest.i));
        if (r0 == null) goto L8;
        Iterator r1 = r0.b().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((c) r1.next()).a(this.$resourceRequest.i);
    L8:
        this.this$0.a.remove(Long.valueOf(this.$resourceRequest.i));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m531invoke();
        return Unit.INSTANCE;
    }
}
