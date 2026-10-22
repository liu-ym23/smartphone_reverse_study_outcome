package w91;

import android.view.ViewGroup;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
import w91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b<D, VH extends f> {
    void a(VH r1, int r2);

    CommonTabHolder b(ViewGroup r1, int r2);

    void c(j91.b<D> r1);

    u91.a getData(int r1);

    int getDataPosition(D r1);

    int getItemSize();

    int getItemViewType(int r1);

    void notifyDataSetChange();
}
