package i82;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class f<T, VH extends RecyclerView.ViewHolder> extends me.drakeet.multitype.b<T, VH> {
    public final CopyOnWriteArrayList<String> b;

    public abstract void i(View r1, VSMsgBoardDress r2);

    public f() {
        this.b = new CopyOnWriteArrayList();
    }

    public final int h(VSMsgBoardDress r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        int r0 = ((me.drakeet.multitype.b) this).a.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(ListProtector.get(((me.drakeet.multitype.b) this).a.a, r1), r4) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }
}
