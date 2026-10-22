package com.bytedance.android.live.base.model.vip;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.VIPBadge")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u001c\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002R0\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/vip/VipBadge;", "", "", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcons", "icons", "", "setIcons", "_icons", "Ljava/util/Map;", "get_icons", "()Ljava/util/Map;", "set_icons", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VipBadge implements h {
    public static final a Companion = null;
    public static final long TYPE_DEFAULT = 1;
    public static final long TYPE_RANK = 2;
    public static final long TYPE_UNKNOWN = 0;

    @SerializedName("icons")
    protected Map<Long, ? extends ImageModel> _icons;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VipBadge() {
    }

    public final Map<Long, ImageModel> getIcons() {
        return this._icons;
    }

    public final Map<Long, ImageModel> get_icons() {
        return this._icons;
    }

    public VipBadge(g r11) {
        this._icons = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        if (r2 != 1) goto L7;
        long r5 = r11.c();
        Long r3 = null;
        ImageModel r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = x.a(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r5);
        Map<Long, ? extends ImageModel> r4 = this._icons;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r11);
        goto L3
    L25:
        r11.d(r0);
    }

    public final void setIcons(Map<Long, ? extends ImageModel> r1) {
        this._icons = r1;
    }

    public final void set_icons(Map<Long, ? extends ImageModel> r1) {
        this._icons = r1;
    }
}
