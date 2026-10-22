package fo1;

import am2.w;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.l;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.ui.framework.base.a {
    public wh1.a A;
    public final PropertyOwner<Boolean> B;
    public boolean C;
    public l s;
    public com.bytedance.android.livesdk.room.b t;
    public boolean u;
    public boolean v;
    public final List<is2.f> w;
    public Runnable x;
    public boolean y;
    public long z;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ILinkServiceExternal r0 = k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L9
            if (r0 == null) goto L5;
            r0.updateLiveMode(this.a.i);     // Catch: Throwable -> L9
        L5:
            ILinkServiceExternal r1 = k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            r1.updatePortrait(this.a.a);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public final void g() {
        DataCenter r0 = b();
        r0.put("data_room", c());
        r0.put("data_room_id", Long.valueOf(c().id));
        r0.put("data_is_portrait", Boolean.valueOf(this.a));
        r0.put("data_live_mode", this.i);
        r0.put("data_user_center", TTLiveSDKContext.getHostService().h());
        o r1 = u.l().c(n0.class);
        if (r1 == null) goto L8;
        Map r2 = r1.getMap();
        if (r2 == null) goto L8;
        String r3 = (String) r2.get("source");
        if (r3 == null) goto L8;
    L9:
        r0.put("data_enter_source", r3);
        Boolean r4 = Boolean.FALSE;
        r0.put("data_is_anchor", r4);
        d().getRoom().setValue(c());
        d().isUsingEnterRoom().setValue(Boolean.valueOf(this.v));
        d().isAnchor().d(r4);
        int r5 = y.a;
        DataCenter r6 = b();
        com.bytedance.android.livesdk.room.b r7 = this.t;
        if (r7 == null) goto L12;
        CompositeDisposable r8 = r7.z;
    L13:
        y.a(r6, r8, "AudienceInteractionContext#prepareGlobalData", new a(this));
        return;
    L12:
        r8 = null;
    L8:
        r3 = "";
        goto L9
    }

    public b(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, true);
        this.v = true;
        this.w = new ArrayList();
        this.B = new PropertyOwner(Boolean.FALSE);
    }

    public static final void f(b r2, LiveMode r3) {
        r2.getClass();
        LiveMode r4 = LiveMode.MEDIA;
        if (r3 != r4) goto L8;
        o r5 = u.l().c(w.class);
        if (r5 == null) goto L9;
        r5.setData(new w(r4, "1"));
        return;
    L9:
        return;
    }
}
