package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.graphics.Canvas;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final class CarnivalRenderEngineView$render$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ RenderRequest $request;
    final /* synthetic */ CarnivalRenderEngineView this$0;

    public CarnivalRenderEngineView$render$1(CarnivalRenderEngineView r1, RenderRequest r2, Canvas r3) {
        this.this$0 = r1;
        this.$request = r2;
        this.$canvas = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m546invoke() {
        this.$request.a(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m546invoke();
        return Unit.INSTANCE;
    }
}
