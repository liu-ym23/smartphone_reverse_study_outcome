package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.w3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<w3> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        Text r0 = this.b.o();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L6;
        r1 = sb2.a.h(this.b.o(), BuildConfig.FLAVOR, false).toString();
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L14;
        if (this.b.s() != 3) goto L14;
        r1 = s1.B(2131916811);
    L14:
        if (SpannableType.GAME != SpannableType.NORMAL) goto L16;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        Intrinsics.checkNotNullParameter(this.i, "type");
        int r3 = i0.a(2131107647);
    L18:
        return i0.b(r1, r3);
    L16:
        int r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        r3 = i0.a(2131107649);
        goto L18
    L6:
        if (this.b.getContent() == null) goto L9;
        r1 = this.b.getContent();
        goto L9
    }

    public a0(w3 r2) {
        super(r2, 0);
    }
}
