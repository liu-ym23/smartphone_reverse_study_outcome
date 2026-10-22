package s62;

import am2.x;
import android.view.View;
import com.bytedance.android.live.base.model.message.k;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ k b;

    public f(a r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        String r7 = this.b.getSchema();
        if (r7 == null) goto L5;
        this.a.b(r7, "live_format_guidance");
    L5:
        int r8 = k22.a.a;
        HashMap r0 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("answer_type", "text")});
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L11;
        String r3 = r2.n();
        if (r3 == null) goto L11;
    L12:
        r0.put("user_id", r3);
        j0.l().sendLog("livesdk_ai_qa_function_guidance_click", r0, new Object[]{IRoom.class, x.class});
        yo2.e r9 = this.a.d;
        if (r9 == null) goto L16;
        r9.d();
        return;
    L16:
        return;
    L11:
        r3 = BuildConfig.FLAVOR;
        goto L12
    }
}
