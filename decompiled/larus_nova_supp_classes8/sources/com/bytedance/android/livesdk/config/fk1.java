package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/fk1;", "", "", "anchorRegionMixRatio", "F", "a", "()F", "c", "(F)V", "Lcom/bytedance/android/livesdk/config/a0;", "anchorPreviewPremixRect", "Lcom/bytedance/android/livesdk/config/a0;", "getAnchorPreviewPremixRect", "()Lcom/bytedance/android/livesdk/config/a0;", "b", "(Lcom/bytedance/android/livesdk/config/a0;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fk1 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("anchor_preview_premix_rect")
    private a0 anchorPreviewPremixRect;

    @SerializedName("anchor_region_mix_ratio")
    private float anchorRegionMixRatio;

    public static final class a {
        public static HashMap a() {
            HashMap r0 = new HashMap();
            fk1 r2 = new fk1();
            r2.c(0.82f);
            a0 r3 = new a0();
            r3.b();
            r3.c(0.2f);
            r3.a();
            Unit r4 = Unit.INSTANCE;
            r2.b(r3);
            r0.put(7, r2);
            fk1 r5 = new fk1();
            r5.c(0.75f);
            a0 r6 = new a0();
            r6.b();
            r6.c(0.06f);
            r6.a();
            r5.b(r6);
            r0.put(1, r5);
            fk1 r7 = new fk1();
            r7.c(1.0f);
            a0 r8 = new a0();
            r8.b();
            r8.c(0.06f);
            r8.a();
            r7.b(r8);
            r0.put(3, r7);
            return r0;
        }
    }

    static {
    }

    public fk1() {
        this.anchorRegionMixRatio = 1.0f;
        this.anchorPreviewPremixRect = new a0();
    }

    public final float a() {
        return this.anchorRegionMixRatio;
    }

    public final void b(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorPreviewPremixRect = r2;
    }

    public final void c(float r1) {
        this.anchorRegionMixRatio = r1;
    }
}
