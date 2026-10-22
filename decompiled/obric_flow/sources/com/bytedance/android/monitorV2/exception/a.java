package com.bytedance.android.monitorV2.exception;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import k5.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3567a = null;

    static {
        f3567a = new a();
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map getUserData(CrashType r5) {
        HashMap r10 = new HashMap();
        Pattern r11 = k.f18621a;
        r10.put("last_bdhm_url", k.a(b.f3568a));
        r10.put("last_bdhm_bid", b.f3569b);
        return r10;
    }
}
