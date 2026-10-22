package rj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface e {
    boolean G7();

    t Hk();

    void Jj();

    void Yg();

    boolean isLinkCasting();

    boolean isSupportLinkCastMiniApp();

    void kh(t.b r1);

    void ll(LinkScreenCastType r1, String r2, int r3, int r4, Bitmap r5, String r6, String r7);

    void logMiniAppShareIconClick(String r1, String r2, boolean r3);

    void logMiniAppShareIconShow(String r1, String r2, boolean r3);

    void ne(LinkScreenCastType r1, String r2, String r3, boolean r4);

    void onProgramFrameErr();

    void onProgramHide();

    void onProgramShow();

    void onProgramStop();
}
