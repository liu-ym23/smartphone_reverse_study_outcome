package com.bytedance.android.livesdk.interactivity.medialink.dialog.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.medialink.contract.b;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import t82.c;
import v82.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorLinkUserViewHolder extends RecyclerView.ViewHolder implements f {
    public static final /* synthetic */ int k = 0;
    public final VHeadView a;
    public final VHeadView b;
    public final TextView c;
    public final HSImageView d;
    public final TextView e;
    public final Button f;
    public final c g;
    public int h;
    public final b i;
    public Room j;

    @Override // v82.f
    public final void N(String r1) {
    }

    @Override // v82.f
    public final String G() {
        Room r0 = this.j;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getIdStr();
    }

    public final boolean T3(User r4) {
        b r0 = this.i;
        if (r0 == null) goto L11;
        Iterator r1 = r0.Np().getInviteeList().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if (n0.a(((User) r1.next()).getIdStr(), r4.getIdStr()) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public MediaAnchorLinkUserViewHolder(View r2, c r3) {
        super(r2);
        b.R0.getClass();
        this.i = b.a.a();
        this.a = r2.findViewById(2131376019);
        this.b = r2.findViewById(2131376272);
        this.c = (TextView) r2.findViewById(2131390993);
        this.d = r2.findViewById(2131376380);
        this.e = (TextView) r2.findViewById(2131390517);
        this.f = (Button) r2.findViewById(2131364601);
        this.g = r3;
    }
}
