package com.larus.bmhome.instruction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.obric.assistant.component.o6;
import com.obric.assistant.component.p6;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ com.larus.bmhome.actionbar.model.z0 d(g r1, ActiveSwitchType r2) {
            return r1.un(r2, null);
        }

        public static /* synthetic */ com.larus.bmhome.actionbar.model.z0 c(g r1, ActiveSwitchType r2, String r3) {
            return r1.wc(r2, r3, "");
        }

        public static /* synthetic */ void b(g r2, com.larus.bmhome.actionbar.model.z0 r3, ReplyOption r4, boolean r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = true;
        L11:
            r2.QW(r3, r4, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r6, List r7, Function1 r8, o6 r9, p6 r10, int r11) {
            if ((r11 & 4) == 0) goto L5;
            Function1 r3 = null;
        L7:
            if ((r11 & 8) == 0) goto L9;
            o6 r4 = null;
        L11:
            if ((r11 & 16) == 0) goto L13;
            p6 r5 = null;
        L14:
            r6.Td(r7, null, r3, r4, r5);
            return;
        L13:
            r5 = r10;
            goto L14
        L9:
            r4 = r9;
            goto L11
        L5:
            r3 = r8;
            goto L7
        }

        public static /* synthetic */ void e(g r2, String r3, Integer r4, aq8.e r5, int r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = 0;
        L14:
            r2.Iu(r3, r4, r5, r6);
        }
    }

    void A1();

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> A7();

    void A8(String r1);

    boolean Aq();

    void BP();

    boolean Ch();

    void EF(Function1<? super up8.b, Unit> r1);

    Pair<Boolean, Boolean> F7();

    void FC(com.larus.bmhome.chat.model.b0 r1);

    void FP();

    ReplyOption Fe(com.larus.bmhome.actionbar.model.z0 r1);

    void GR();

    boolean HM();

    ReplyOption IT(ModelItemIdentity r1);

    void Iu(String r1, Integer r2, aq8.e r3, int r4);

    @Deprecated(message = "do not use, use your segment by refresh")
    void K90();

    String KU();

    void LB(rs8.f r1);

    void LW();

    void Lg(com.larus.bmhome.chat.model.j1 r1, boolean r2);

    String M10();

    int M4();

    void M80(ReplyOption r1, boolean r2);

    kotlinx.coroutines.flow.d1<Integer> Mp();

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> N8();

    void NZ();

    void Nb(Bundle r1);

    void Ot();

    boolean P0();

    void PL(Map<String, String> r1);

    void Ps(Bundle r1);

    int Q1();

    void QW(com.larus.bmhome.actionbar.model.z0 r1, ReplyOption r2, boolean r3);

    void QX(rs8.f r1);

    String Qh(String r1);

    ReplyOption Ql();

    void S7();

    void SF();

    void SJ(String r1);

    void ST();

    void SU(boolean r1);

    void T1();

    void T40(boolean r1);

    void Td(List<? extends ss8.e> r1, String r2, Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r3, Function0<BotModel> r4, Function0<wc9.e> r5);

    boolean Ty();

    boolean Uc();

    String Un();

    void VQ(String r1);

    void Vm(boolean r1, String r2);

    ReplyOption WK(String r1);

    boolean Wa();

    o Wp();

    int X1();

    boolean Xl();

    MutableLiveData Zb();

    int bd();

    String c0();

    void c6();

    void cO();

    void ck();

    boolean eB();

    void fN(View r1);

    boolean fu();

    void fz(ReplyOption r1);

    String gm();

    boolean i3();

    void ip(boolean r1);

    void j90(com.larus.bmhome.actionbar.model.z0 r1);

    Pair<com.larus.bmhome.actionbar.model.z0, Boolean> jo();

    boolean jt();

    ViewGroup jy();

    boolean k20();

    boolean k5();

    String kb(String r1);

    void ls();

    AttachmentInfo n4();

    void nB(String r1);

    Map<String, String> nK(String r1);

    void oP(View r1);

    boolean of(com.larus.audio.asr.c0 r1);

    void onInputHintChanged(String r1, String r2);

    void p00();

    boolean qf(com.larus.bmhome.actionbar.model.r r1, String r2, String r3, List<com.larus.bmhome.actionbar.model.z0> r4, Image r5);

    boolean rA();

    void requestFocus();

    boolean rm();

    List<com.larus.bmhome.actionbar.model.z0> tq();

    LiveData<List<com.larus.bmhome.actionbar.model.z0>> uE();

    com.larus.bmhome.actionbar.model.z0 un(ActiveSwitchType r1, String r2);

    boolean vO(Integer r1);

    void vW(boolean r1);

    boolean vX();

    CustomActionBar.d vp();

    boolean w4();

    com.larus.bmhome.actionbar.model.z0 wc(ActiveSwitchType r1, String r2, String r3);

    boolean x(String r1);

    void xy();

    void y20(Function0<Unit> r1);

    com.larus.bmhome.actionbar.model.z0 yF();

    boolean yW();

    boolean z0();

    MutableLiveData zU();
}
