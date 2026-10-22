package qt0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember.GroupLiveMemberBinderDataViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends me.drakeet.multitype.b<a, GroupLiveMemberBinderDataViewHolder> {
    public c() {
    }

    public final void e(RecyclerView.ViewHolder r3) {
        GroupLiveMemberBinderDataViewHolder r4 = (GroupLiveMemberBinderDataViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        a r5 = r4.a;
        b r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.a;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.e;
    L8:
        if (r1 == null) goto L12;
        if (r0 == null) goto L13;
        r0.c(r1);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        GroupLiveMemberBinderDataViewHolder r5 = (GroupLiveMemberBinderDataViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.a = r6;
        ImageLoader.bindImage(r5.b, r6.b);
        r5.c.setText(r6.c);
        Integer r7 = r6.d;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.intValue() == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
        r5.c.setTextColor(r8);
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new GroupLiveMemberBinderDataViewHolder(r4.inflate(2131567182, r5, false));
    }
}
