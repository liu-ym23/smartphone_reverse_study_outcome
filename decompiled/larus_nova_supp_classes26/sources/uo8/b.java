package uo8;

import android.net.Uri;
import com.larus.bmhome.common_ui.image.CustomPhotoTransitionPagerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements j {
    public final /* synthetic */ CustomPhotoTransitionPagerAdapter a;

    public b(CustomPhotoTransitionPagerAdapter r1) {
        this.a = r1;
    }

    @Override // uo8.j
    public final void a(int r2, Uri r3) {
        Integer r4 = Integer.valueOf(r2);
        this.a.j.put(r4, r3);
    }
}
