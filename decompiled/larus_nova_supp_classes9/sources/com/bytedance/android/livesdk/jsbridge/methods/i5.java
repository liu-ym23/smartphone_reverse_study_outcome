package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i5<T> implements Consumer {
    public final /* synthetic */ h5 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ CallContext c;
    public final /* synthetic */ String d;

    public i5(h5 r1, String r2, CallContext r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        IBaseUser r8 = (IBaseUser) r7;
        String r0 = this.b;
        if (r0 == null) goto L22;
        int r1 = r0.hashCode();
        if (r1 == (-554436100)) goto L17;
        if (r1 != 951530617) goto L22;
        if (r0.equals("content") == false) goto L22;
        if (r8.isVcdAdversaryContentAuthorized() == false) goto L15;
        h5 r9 = this.a;
        JSONObject r2 = new JSONObject();
        r2.put("status_code", -1);
        Unit r3 = Unit.INSTANCE;
        r9.finishWithResult(r2);
        return;
    L15:
        IUserService r10 = jc1.k.n(IUserService.class);
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(this.c.getContext());
        Intrinsics.checkNotNull(r4);
        r10.showVcdContentGrant(r4, this.d, "h5", this.a.c);
        return;
    L17:
        if (r0.equals("relation") == false) goto L22;
        if (r8.isVcdAdversaryRelationAuthorized() == false) goto L21;
        h5 r11 = this.a;
        JSONObject r5 = new JSONObject();
        r5.put("status_code", -1);
        Unit r6 = Unit.INSTANCE;
        r11.finishWithResult(r5);
        return;
    L21:
        IUserService r13 = jc1.k.n(IUserService.class);
        FragmentActivity r14 = ContextUtil.contextToFragmentActivity(this.c.getContext());
        Intrinsics.checkNotNull(r14);
        r13.showVcdRelationshipGrant(r14, this.d, "h5", this.a.c);
        return;
    L22:
        this.a.finishWithFailure();
    }
}
