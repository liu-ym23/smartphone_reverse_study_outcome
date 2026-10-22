package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.lynx.react.bridge.PiperData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PiperData f7377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f7378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f7379c;

    public j(HashMap r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        PiperData r10 = new PiperData(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7377a = r10;
        this.f7378b = r5;
    }

    public j(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        PiperData r10 = new PiperData(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7377a = r10;
        this.f7379c = r5;
    }
}
