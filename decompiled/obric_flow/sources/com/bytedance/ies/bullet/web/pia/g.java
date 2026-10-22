package com.bytedance.ies.bullet.web.pia;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements fh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f6230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6231b;

    public g(d r5, String r10) {
        this.f6230a = r5;
        this.f6231b = r10;
    }

    @Override // fh.b
    public final Object create() {
        d r5 = this.f6230a;
        if (r5.f6223a.length() != 0) goto L15;
        com.bytedance.android.anniex.base.depend.b r10 = (com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue();
        String r11 = r10.f3115a;
        if (r11 != null) goto L8;
        r11 = "NOT_IMPLEMENT";
        r10.f3115a = "NOT_IMPLEMENT";
    L8:
        if (Intrinsics.areEqual(this.f6231b, "webcast") == true) goto L10;
    L13:
        return r11;
    L10:
        if (StringsKt.g(r11, "WebcastSDK") == true) goto L13;
        return r11.concat(" WebcastSDK/unknown");
    L15:
        return r5.f6223a;
    }
}
