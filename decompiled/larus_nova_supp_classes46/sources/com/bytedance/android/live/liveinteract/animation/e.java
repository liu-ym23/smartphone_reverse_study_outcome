package com.bytedance.android.live.liveinteract.animation;

import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface e {

    public static final class a {
        public static void a(EPointF r1, EPointF r2, EPointF r3) {
            Intrinsics.checkNotNullParameter(r1, "currentPoint");
            Intrinsics.checkNotNullParameter(r2, "startPoint");
            Intrinsics.checkNotNullParameter(r3, "endPoint");
        }

        public static void b(EPointF r1, EPointF r2, EPointF r3) {
            Intrinsics.checkNotNullParameter(r1, "currentPoint");
            Intrinsics.checkNotNullParameter(r2, "startPoint");
            Intrinsics.checkNotNullParameter(r3, "endPoint");
        }
    }

    void Bn(String r1);

    EPointF C7(int r1, int r2);

    boolean Ed(int r1);

    boolean K5(String r1, String r2);

    ArrayList Ka(int r1, float r2);

    EPointF Kl(int r1, int r2);

    void Mb(String r1, String r2, int r3);

    EPointF Mj(String r1);

    boolean Mk(EPointF r1, EPointF r2, EPointF r3);

    boolean Pf(int r1);

    EPointF Se(int r1, int r2, EPointF r3, EPointF r4);

    boolean W7(EPointF r1, EPointF r2);

    ArrayList dm(int r1);

    boolean ha(EPointF r1, EPointF r2, EPointF r3);

    q50.b jq();

    boolean lo(int r1);

    int ma(int r1, int r2);

    int qq(int r1);

    boolean si();

    FrameLayout vj();

    boolean wc(String r1);

    int zl(String r1);
}
