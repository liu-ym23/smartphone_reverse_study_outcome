package nf8;

import android.net.Uri;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import wc9.e;
import z19.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements k {
    public final String a;
    public final /* synthetic */ e b;
    public final /* synthetic */ Pair<Uri, Uri> c;

    public final void b() {
        e r0 = this.b;
        int r1 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.b(this.a, null, r0.a, null, AttachmentAreaType.NO_CLEAR, null, null, null);
    }

    public final void a(boolean r7) {
        if (r7 == true) goto L5;
        int r8 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.e(this.a, String.valueOf(this.c.getFirst()), null, "onboarding_avatar", false, MapsKt.mapOf(TuplesKt.to("onboarding_type", "big")));
        return;
    }

    public final void onFailure(Throwable r9) {
        int r0 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.a(this.a, null, "[image_load_failed]: err:" + r9, String.valueOf(this.c.getFirst()), "onboarding_avatar", false, MapsKt.mapOf(TuplesKt.to("onboarding_type", "big")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(e r1, Pair<? extends Uri, ? extends Uri> r2) {
        this.b = r1;
        this.c = r2;
        this.a = UUID.randomUUID().toString();
    }
}
