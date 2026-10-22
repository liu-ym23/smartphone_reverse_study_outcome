package ib;

import cj.j;
import com.bytedance.sdk.xbridge.cn.utils.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements sc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f17563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f17564b;

    public a(j r5, b r10) {
        this.f17563a = r5;
        this.f17564b = r10;
    }

    @Override // sc.a
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        LinkedHashMap r10 = f.c(r5);
        this.f17563a.a(r10);
    }

    @Override // sc.a
    public final void onError(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        HashMap r11 = new HashMap();
        r11.put("code", Integer.valueOf(r5));
        r11.put("message", r10);
        r11.put("func", this.f17564b.f17565a.g());
        this.f17563a.a(r11);
    }
}
