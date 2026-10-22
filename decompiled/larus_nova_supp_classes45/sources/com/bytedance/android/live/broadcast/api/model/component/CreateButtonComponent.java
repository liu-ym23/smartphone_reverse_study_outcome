package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.CreateButtonComponent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "", "()V", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "startBtnText", "", "", "", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CreateButtonComponent implements h {

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("button_text")
    public Map<Integer, String> startBtnText;

    public CreateButtonComponent() {
    }

    public CreateButtonComponent(g r11) {
        this.startBtnText = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L27;
        if (r2 != 1) goto L8;
        this.base = new BaseComponentModel(r11);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r6 = r11.c();
        Integer r3 = null;
        String r8 = null;
    L11:
        int r9 = r11.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Integer.valueOf(r11.i());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r8 = am3.h.c(r11);
        goto L11
    L15:
        am3.h.e(r11);
        goto L11
    L18:
        r11.d(r6);
        Map<Integer, String> r4 = this.startBtnText;
        if (r3 == null) goto L25;
        if (r8 == null) goto L23;
        r4.put(r3, r8);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r11);
        goto L3
    L27:
        r11.d(r0);
    }
}
