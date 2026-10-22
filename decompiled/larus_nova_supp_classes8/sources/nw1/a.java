package nw1;

import android.view.View;
import com.bytedance.android.livesdk.feed.openui.adapter.FollowLiveSkyLightViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FollowLiveSkyLightViewHolder a;
    public final /* synthetic */ Room b;

    public a(FollowLiveSkyLightViewHolder r1, Room r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Room r3 = this.b;
        if (r3 == null) goto L6;
        this.a.j.invoke(r3);
        return;
    }
}
