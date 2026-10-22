package arb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {
    void V(Object r1, String r2);

    void W();

    boolean X();

    void Y(Context r1, String r2);

    void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r1, IItemContainer r2);

    String a0(String r1);

    void b0();

    void c0(Object r1, String r2, ChatAtModel.a r3);

    void d0(boolean r1);

    Drawable e0(Context r1, List r2);
}
