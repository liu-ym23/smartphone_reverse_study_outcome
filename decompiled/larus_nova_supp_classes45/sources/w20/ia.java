package w20;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.jsbridge.base.LiveAnchorContractAVRecordResultModel;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.facebook.common.internal.ImmutableList;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ia extends i2<ha, LiveAnchorContractAVRecordResultModel> {
    public static final TokenCert b = null;
    public final Fragment a;

    public static final class a {
    }

    static {
        b = TokenCert.Companion.with("bpea-live_upload_jsb_encrypted_upload_method");
    }

    public ia(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void invoke(Object r4, CallContext r5) {
        ha r6 = (ha) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        o30.c r0 = o30.c.b;     // Catch: IOException -> L11
        Context r1 = this.a.getContext();     // Catch: IOException -> L11
        if (r1 == null) goto L8;
        File r2 = r1.getCacheDir();     // Catch: IOException -> L11
        if (r2 == null) goto L8;
        String r3 = r2.getCanonicalPath();     // Catch: IOException -> L11
    L9:
        r0.b(r3);     // Catch: IOException -> L11
    L8:
        r3 = null;
    L13:
        if (Intrinsics.areEqual(r6.d(), "photo") == false) goto L15;
        ImmutableList r7 = ImmutableList.of(new String[]{"android.permission.CAMERA"});
    L16:
        Context r8 = r5.getContext();
        if (r8 == null) goto L21;
        SettingKey<Boolean> r9 = m60.i.a;
        new m60.i.b((Activity) r8).a(new ja(this, r6, r5), b, r7);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L15:
        r7 = ImmutableList.of(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
        goto L16
    }
}
