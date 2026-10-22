package com.bytedance.awemeopen.infra.plugs.lotties;

import android.text.TextUtils;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BdpAnimationViewImpl$onFailure$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BdpAnimationViewImpl this$0;

    public BdpAnimationViewImpl$onFailure$1(BdpAnimationViewImpl r1) {
        this.this$0 = r1;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.bytedance.awemeopen.infra.plugs.lotties.BdpAnimationViewImpl] */
    public final void invoke(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        ?? r4 = this.this$0;
        int r0 = BdpAnimationViewImpl.f;
        Object r1 = r4.a;
        if (r1 != null) goto L5;
    L12:
        this.this$0.getConfig();
        throw null;
    L5:
        if ((r1 instanceof Integer) == false) goto L7;
        r4.setImageResource(((Number) r1).intValue());
        goto L12
    L7:
        if ((r1 instanceof String) == false) goto L12;
        if (TextUtils.isEmpty((CharSequence) r1) == true) goto L12;
        l64.b r2 = new l64.b();
        r2.a = (String) r1;
        r2.e = new e();
        r2.d = r4;
        int r5 = j64.b.a;
        j64.b.a(AoImageService.class).Q0(r4.getContext(), r2);
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
