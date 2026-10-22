package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface n2 extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(n2 r6, InstructionTab r7, OptionItem r8, boolean r9) {
            r6.h70(r7, r8, null, r9, "router_auto_send");
        }
    }

    void Fp(ky8.j r1);

    void IQ(String r1, boolean r2);

    int Jx();

    boolean M20();

    ky8.f O30(String r1);

    int PT();

    void SS(ky8.j r1);

    int Sr();

    Long XF();

    void Xu(int r1);

    void bs(String r1);

    kotlinx.coroutines.flow.i1<ky8.g> bt();

    void cc(String r1, @ImageSaveStatus int r2);

    int dx();

    void gu();

    void h70(InstructionTab r1, OptionItem r2, String r3, boolean r4, String r5);

    Pair<String, String> j50();

    void lH(String r1);

    int re();

    void tM(Uri r1, boolean r2);

    kotlinx.coroutines.flow.b1 tx();

    CanvasProgressState zm();
}
