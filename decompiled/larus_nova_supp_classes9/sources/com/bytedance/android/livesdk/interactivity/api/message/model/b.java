package com.bytedance.android.livesdk.interactivity.api.message.model;

import am3.g;
import com.bytedance.android.livesdk.interactivity.api.entity.j;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.PlatformAdviseMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/message/model/b;", "Ly32/a;", "Lcom/bytedance/android/livesdk/interactivity/api/entity/j;", "Lcom/bytedance/android/livesdkapi/message/Text;", "adviseText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getAdviseText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setAdviseText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", BuildConfig.FLAVOR, "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "priority", "getPriority", "setPriority", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventTracking", "Ljava/util/Map;", "n", "()Ljava/util/Map;", "setEventTracking", "(Ljava/util/Map;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends y32.a implements j, h {

    @SerializedName("advise_text")
    protected Text adviseText;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("event_tracking")
    protected Map<String, String> eventTracking;

    @SerializedName("priority")
    protected long priority;

    public b() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.PlatformAdvise;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final long getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final Text l() {
        return this.adviseText;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final Map<String, String> n() {
        return this.eventTracking;
    }

    public b(g r11) {
        this.eventTracking = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L36;
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r11);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.adviseText = _Text_ProtoDecoder.decodeStatic(r11);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.duration = r11.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.priority = r11.j();
        goto L3
    L14:
        if (r2 != 20) goto L15;
        long r6 = r11.c();
        String r3 = null;
        String r8 = null;
    L17:
        int r9 = r11.f();
        if (r9 == (-1)) goto L24;
        if (r9 != 1) goto L20;
        r3 = am3.h.c(r11);
        goto L17
    L20:
        if (r9 != 2) goto L21;
        r8 = am3.h.c(r11);
        goto L17
    L21:
        am3.h.e(r11);
        goto L17
    L24:
        r11.d(r6);
        Map<String, String> r4 = this.eventTracking;
        if (r3 == null) goto L31;
        if (r8 == null) goto L29;
        r4.put(r3, r8);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.e(r11);
        goto L3
    L36:
        r11.d(r0);
    }
}
