package com.bytedance.android.live.liveinteract.api.chatroom.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.p;
import com.bytedance.android.livesdk.multilink.base.model.p0;
import com.bytedance.android.livesdk.multilink.base.model.q0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LayoutConfigResponseData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/p;", "", "version", "I", "getVersion", "()I", "setVersion", "(I)V", "", "Lcom/bytedance/android/livesdk/multilink/base/model/p0;", "layoutConfigVerMap", "Ljava/util/Map;", "getLayoutConfigVerMap", "()Ljava/util/Map;", "setLayoutConfigVerMap", "(Ljava/util/Map;)V", "<init>", "()V", "StyleLayoutConfig", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LayoutConfigResponseData extends FlexModelBase<p> implements p, h {

    @SerializedName("style_layout_config_map")
    protected Map<Integer, p0> layoutConfigVerMap;

    @SerializedName("version")
    protected int version;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LayoutConfigResponseData$StyleLayoutConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/p0;", "", "", "Lcom/bytedance/android/livesdk/multilink/base/model/q0$a;", "layoutConfigStyleMap", "Ljava/util/Map;", "getLayoutConfigStyleMap", "()Ljava/util/Map;", "setLayoutConfigStyleMap", "(Ljava/util/Map;)V", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class StyleLayoutConfig extends FlexModelBase<p0> implements p0, h {

        @SerializedName("layout_config_map")
        protected Map<Integer, q0.a> layoutConfigStyleMap;

        public StyleLayoutConfig() {
            super(p0.class);
            this.layoutConfigStyleMap = new HashMap();
        }

        public Map<Integer, q0.a> getLayoutConfigStyleMap() {
            return this.layoutConfigStyleMap;
        }

        public StyleLayoutConfig(g r11) {
            super(p0.class);
            this.layoutConfigStyleMap = new HashMap();
            setThreadSafe(false);
            long r0 = r11.c();
        L3:
            int r2 = r11.f();
            if (r2 == (-1)) goto L25;
            g.a r5 = decodeExtensionFields(r2, r11);
            if (r2 != 1) goto L7;
            long r6 = r11.c();
            Integer r3 = null;
            Object r7 = null;
        L9:
            int r8 = r11.f();
            if (r8 == (-1)) goto L17;
            if (r8 != 1) goto L13;
            r3 = Integer.valueOf(r11.i());
            goto L9
        L13:
            if (r8 != 2) goto L14;
            r7 = f.a(r11, q0.a.class);
            goto L9
        L14:
            am3.h.e(r11);
            goto L9
        L17:
            r11.d(r6);
            Map<Integer, q0.a> r4 = this.layoutConfigStyleMap;
            if (r3 == null) goto L24;
            if (r7 == null) goto L22;
            r4.put(r3, (q0.a) r7);
            goto L3
        L22:
            throw new IllegalStateException("Value must not be null");
        L24:
            throw new IllegalStateException("Key must not be null");
        L7:
            am3.h.d(r5, r11);
            goto L3
        L25:
            r11.d(r0);
            setThreadSafe(true);
            if (this.layoutConfigStyleMap != null) goto L46;
            this.layoutConfigStyleMap = new HashMap();
            return;
        }

        public void setLayoutConfigStyleMap(Map<Integer, q0.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.layoutConfigStyleMap = r2;
        }
    }

    public LayoutConfigResponseData() {
        super(p.class);
        this.layoutConfigVerMap = new HashMap();
    }

    public Map<Integer, p0> getLayoutConfigVerMap() {
        return this.layoutConfigVerMap;
    }

    public int getVersion() {
        return this.version;
    }

    public LayoutConfigResponseData(g r11) {
        super(p.class);
        this.layoutConfigVerMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L26;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L7;
        long r7 = r11.c();
        Integer r3 = null;
        Object r6 = null;
    L11:
        int r9 = r11.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Integer.valueOf(r11.i());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r6 = f.a(r11, p0.class);
        goto L11
    L15:
        am3.h.e(r11);
        goto L11
    L18:
        r11.d(r7);
        Map<Integer, p0> r4 = this.layoutConfigVerMap;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r4.put(r3, (p0) r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r2 != 2) goto L8;
        this.version = r11.i();
        goto L3
    L8:
        am3.h.d(r5, r11);
        goto L3
    L26:
        r11.d(r0);
        setThreadSafe(true);
        if (this.layoutConfigVerMap != null) goto L50;
        this.layoutConfigVerMap = new HashMap();
        return;
    }

    public void setLayoutConfigVerMap(Map<Integer, p0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.layoutConfigVerMap = r2;
    }

    public void setVersion(int r1) {
        this.version = r1;
    }
}
