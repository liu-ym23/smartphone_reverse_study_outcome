package com.bytedance.lynx.media;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/lynx/media/e;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class AbsMediaEngineView$onAsyncFetchResourceFailure$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsMediaEngineView f6810a;

    public AbsMediaEngineView$onAsyncFetchResourceFailure$1(AbsMediaEngineView r5) {
        this.f6810a = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f6810a.i("error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("errorMsg", "success convert resource url error"), TuplesKt.to("errorCode", -1)}));
        return Unit.INSTANCE;
    }
}
