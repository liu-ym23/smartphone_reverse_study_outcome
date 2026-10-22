package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import android.view.ViewGroup;
import com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g1 extends m1a.a {

    public static final class a {
        public static /* synthetic */ int b(g1 r1) {
            return r1.Y40(new f1());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g1 r1, List r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r3 & 2) == 0) goto L8;
            boolean r4 = true;
        L9:
            r1.TU(r2, r4, false);
            return;
        L8:
            r4 = false;
            goto L9
        }
    }

    void Bg();

    void EC(UplinkFileEntity r1);

    void EZ(boolean r1);

    void Es(boolean r1);

    void Mi(boolean r1);

    void Pq(boolean r1);

    boolean RD(UplinkFileEntity r1, String r2);

    kotlinx.coroutines.flow.b1 Ry();

    void TU(List<UplinkFileEntity> r1, boolean r2, boolean r3);

    boolean VS();

    void W0();

    String Wv();

    boolean XT();

    int Y40(Function1<? super UplinkFileEntity, Boolean> r1);

    kotlinx.coroutines.flow.b1 YB();

    ViewGroup YK();

    String ZO();

    void Za();

    String aj();

    void b2(String r1);

    NestedFileContent b6(String r1);

    void bD(UplinkFileEntity r1);

    kotlinx.coroutines.flow.b1 br();

    void dP();

    void dm();

    AttachmentPanelType eC();

    boolean eY(List r1, HashMap r2);

    void f50(UplinkFileEntity r1);

    void hF(boolean r1);

    boolean iJ();

    boolean isVisible();

    i1<List<id8.f>> k1();

    void kS(Uri r1);

    void mO();

    boolean mT();

    void nJ(com.larus.common.venue.impl.venue.component.f r1);

    void o50();

    void p20();

    List<UplinkFileEntity> q1();

    void qe();

    void rv(boolean r1);

    void u50();

    String uM();

    int uW(List<UplinkFileEntity> r1, boolean r2, String r3);

    boolean w50(List<UplinkFileEntity> r1, boolean r2, String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, String r10, String r11, boolean r12, String r13, String r14, Long r15);

    void x2(ns8.b r1);

    Map<String, String> xt();

    void yQ(Function1<? super SuggestedActionScene, Boolean> r1);

    void yj();
}
