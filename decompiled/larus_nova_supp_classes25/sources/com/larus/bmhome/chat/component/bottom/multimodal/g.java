package com.larus.bmhome.chat.component.bottom.multimodal;

import android.net.Uri;
import com.larus.bmhome.clarification.ClarificationComponent;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.album.AlbumSettingConfig;
import java.util.Set;
import kotlin.coroutines.Continuation;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ boolean a(g r1) {
            return r1.nA(null);
        }
    }

    MultimodalDowngradeData A6();

    boolean Fb();

    void M6();

    boolean Me(String r1, Integer r2, DirectSendData r3);

    void OR(e1 r1);

    void QS();

    void VR(ClarificationComponent.e r1, Set r2);

    void Xc(Boolean r1);

    void bh(boolean r1);

    void cZ();

    AlbumSettingConfig eP();

    void f60(ClarificationComponent.e r1);

    boolean g90();

    void gx(n r1);

    Object kp(Uri r1, String r2, Continuation<? super Boolean> r3);

    void l90();

    boolean ld();

    String mS(boolean r1, Boolean r2);

    void n90(e1 r1);

    boolean nA(BotModel r1);

    void pd(boolean r1);

    void pm();

    void pn();

    void x2(b r1);

    boolean xE();

    boolean yb(BotModel r1);

    boolean yz();

    int zv(boolean r1, Boolean r2);
}
