package ys8;

import android.content.Intent;
import android.net.Uri;
import com.larus.bmhome.actionbar.model.e2;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.w0;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.edit.o;
import com.larus.bmhome.view.actionbar.edit.p;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.kmp.chat.TemplateInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a extends t1a.a {
    void A1();

    void A8(String r1);

    boolean A80();

    void GX(int r1, long r2);

    void Gk(TemplateInfo.TemplateInfo r1, Uri r2);

    String J6();

    void JI();

    int M4();

    void M70();

    String O3(int r1);

    boolean P0();

    boolean Pz();

    int Q1();

    int S4();

    void S7();

    NestedFileContent T();

    void T1();

    NestedFileContent Wd();

    boolean Wm();

    int X1();

    b Xx(long r1);

    void b00(int r1);

    String c0();

    void c00(int r1);

    void c6();

    boolean dk(int r1);

    List<w> getCurImageList();

    r getCurrentInstructionConf();

    Long getDefaultSelectedImageStyleId();

    List<w> getRatioOptionList();

    d1<o> getSelectDurationFlow();

    i1<p> getSelectVideoModelFlow();

    void h60();

    boolean i3();

    boolean isInVideoTab();

    String k();

    boolean lv();

    void mI(Intent r1);

    ArrayList<Integer> mr();

    AttachmentInfo n4();

    void onDigitalAvatarTemplateChoose(ab8.a r1, int r2, String r3);

    boolean pE();

    void pV();

    void pz(int r1, Intent r2);

    boolean qo();

    void refreshImageListSelectorWithMore(List<w> r1);

    void selectRatio(int r1, long r2);

    void selectRatio(long r1);

    void setEnableResetTemplateCacheAfterDetach(boolean r1);

    void setOriginalRatioEnable(boolean r1);

    void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r1);

    void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r1);

    b1 tP();

    e2 tQ();

    boolean w4();

    void wr(boolean r1);

    boolean x(String r1);

    String xh();

    String y6(String r1);

    String y60(String r1, boolean r2);

    w0 yn();

    boolean z0();

    String zQ();
}
