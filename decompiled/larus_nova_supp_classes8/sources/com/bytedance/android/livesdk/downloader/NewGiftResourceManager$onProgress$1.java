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
final class NewGiftResourceManager$onProgress$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $progress;
    final /* synthetic */ e $request;
    final /* synthetic */ NewGiftResourceManager this$0;

    public NewGiftResourceManager$onProgress$1(NewGiftResourceManager r1, e r2, int r3) {
        this.this$0 = r1;
        this.$request = r2;
        this.$progress = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m534invoke() {
        f r0 = this.this$0.a.get(Long.valueOf(this.$request.i));
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = r0.b().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((c) r1.next()).onProgress(this.$progress);
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m534invoke();
        return Unit.INSTANCE;
    }
}
