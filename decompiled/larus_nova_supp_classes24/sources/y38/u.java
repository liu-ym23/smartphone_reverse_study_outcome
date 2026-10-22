package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u implements x38.g<FlowAccountThirdPartyAuthCore.a> {
    public final /* synthetic */ CompletionBlock<t.b> a;

    public u(CompletionBlock<t.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r19) {
        Intrinsics.checkNotNullParameter(r19, "error");
        if (r19.a != FlowAccountThirdPartyAuthCore.Error.UNSUPPORTED_PLATFORM.getCode()) goto L9;
        CompletionBlock<t.b> r5 = this.a;
        String r1 = r19.b;
        if (r1 != null) goto L7;
        String r7 = "";
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r5, -3, r7, null, 4, null);
        return;
    L7:
        r7 = r1;
        goto L8
    L9:
        CompletionBlock<t.b> r11 = this.a;
        String r2 = r19.b;
        if (r2 != null) goto L12;
        String r13 = "";
    L13:
        CompletionBlock.DefaultImpls.onFailure$default(r11, 0, r13, null, 4, null);
        return;
    L12:
        r13 = r2;
        goto L13
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountThirdPartyAuthCore.a r5) {
        FlowAccountThirdPartyAuthCore.a r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        CompletionBlock<t.b> r0 = this.a;
        t.b r1 = ne7.e.b(t.b.class);
        t.b r2 = r1;
        r2.setCode(r6.c);
        r2.setPlatform(r6.a);
        r2.setPlatformAppId(r6.b);
        r2.setOpenId(r6.d);
        r2.setAccessToken(r6.e);
        r2.setAccessTokenSecret(r6.f);
        r2.setExpiresIn(r6.g);
        r2.setErrorCode(r6.h);
        r2.setRawData(r6.i);
        CompletionBlock.DefaultImpls.onSuccess$default(r0, r1, null, 2, null);
    }
}
