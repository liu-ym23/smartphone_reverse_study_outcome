package ry9;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.uaigc.createpage.component.input.t;
import com.larus.uaigc.instruction.a0;
import com.larus.uaigc.instruction.b0;
import com.larus.uaigc.instruction.z;
import ic8.m0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface h extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(h r6, int r7, boolean r8, int r9, int r10) {
            if ((r10 & 2) == 0) goto L5;
            boolean r2 = false;
        L7:
            if ((r10 & 4) == 0) goto L9;
            int r3 = -1;
        L10:
            r6.YL(r7, r2, r3, 0, null);
            return;
        L9:
            r3 = r9;
            goto L10
        L5:
            r2 = r8;
            goto L7
        }

        public static /* synthetic */ void b(h r12, String r13, String r14, String r15, String r16, String r17, boolean r18, boolean r19, String r20, int r21) {
            if ((r21 & 32) == 0) goto L5;
            boolean r9 = false;
        L7:
            if ((r21 & 64) == 0) goto L9;
            boolean r10 = false;
        L11:
            if ((r21 & 128) == 0) goto L13;
            String r11 = null;
        L14:
            r12.q00(r13, r14, r15, r16, r17, r9, r10, r11);
            return;
        L13:
            r11 = r20;
            goto L14
        L9:
            r10 = r19;
            goto L11
        L5:
            r9 = r18;
            goto L7
        }
    }

    Object BM(ResourceItemBean r1, Continuation<? super Unit> r2);

    MutableLiveData BV();

    MutableLiveData Bw();

    void C2(String r1);

    List<MediaAttachment> DX();

    void IR(z r1);

    String J6();

    void JZ(String r1);

    void Ke(String r1, MediaAttachment r2, boolean r3);

    void Lp(int r1);

    void N6();

    void Nn();

    void OI(a0 r1);

    k Q00(String r1);

    void QA(l r1);

    boolean SM();

    NestedFileContent V20(List<ResourceItemBean> r1);

    boolean Wb();

    void YL(int r1, boolean r2, int r3, int r4, d r5);

    void ew(ResourceItemBean r1);

    void f90(boolean r1, t r2);

    LiveData<Map<String, k>> ja();

    boolean jb();

    void lu(String r1);

    void nE(String r1, String r2);

    void q00(String r1, String r2, String r3, String r4, String r5, boolean r6, boolean r7, String r8);

    void tE(b0 r1);

    void uz(String r1, String r2, m0 r3);

    void vB();

    void w60(String r1, String r2, String r3);

    void xz(String r1, int r2, boolean r3);

    String yC();

    d yH(List<ResourceItemBean> r1);
}
