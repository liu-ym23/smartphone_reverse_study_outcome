package com.larus.platform.api;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a0 {
    void BA(boolean r1);

    void Bs(FragmentManager r1, String r2);

    void Ci(Fragment r1);

    boolean H10();

    void Lb(Function1<? super View, ? extends View> r1);

    void Nu(int r1);

    boolean RU(List<AttachmentSnapshot> r1);

    boolean S0();

    void Ua();

    void Uw();

    View Yz();

    boolean au();

    void cP(String r1);

    boolean gC();

    void k6(int r1, boolean r2);

    void n60();

    Fragment od();

    void tZ(Uri r1);

    void uH();
}
