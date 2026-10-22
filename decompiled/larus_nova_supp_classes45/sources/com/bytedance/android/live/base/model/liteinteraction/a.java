package com.bytedance.android.live.base.model.liteinteraction;

import am3.g;
import com.bytedance.android.livesdkapi.message.TextPiece;
import com.bytedance.android.livesdkapi.message._TextPiece_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.LightInteractionAction")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/liteinteraction/a;", "", "", "actionType", "J", "a", "()J", "setActionType", "(J)V", "", "toast", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "requestParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setRequestParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/base/model/liteinteraction/c;", "clickMob", "Lcom/bytedance/android/live/base/model/liteinteraction/c;", "c", "()Lcom/bytedance/android/live/base/model/liteinteraction/c;", "setClickMob", "(Lcom/bytedance/android/live/base/model/liteinteraction/c;)V", "Lcom/bytedance/android/livesdkapi/message/TextPiece;", "afterClickPiece", "Lcom/bytedance/android/livesdkapi/message/TextPiece;", "b", "()Lcom/bytedance/android/livesdkapi/message/TextPiece;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("action_type")
    protected long actionType;

    @SerializedName("after_click_piece")
    protected TextPiece afterClickPiece;

    @SerializedName("click_mob")
    protected c clickMob;

    @SerializedName("request_params")
    protected Map<String, String> requestParams;

    @SerializedName("toast")
    protected String toast;

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.liteinteraction.a$a, reason: collision with other inner class name */
    public static final class C0012a {
    }

    static {
    }

    public a() {
    }

    public final long a() {
        return this.actionType;
    }

    public final TextPiece b() {
        return this.afterClickPiece;
    }

    public final c c() {
        return this.clickMob;
    }

    public final Map<String, String> d() {
        return this.requestParams;
    }

    public final String e() {
        return this.toast;
    }

    public a(g r11) {
        this.requestParams = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L36;
        if (r2 != 1) goto L8;
        this.actionType = r11.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.toast = am3.h.c(r11);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        long r6 = r11.c();
        String r3 = null;
        String r8 = null;
    L19:
        int r9 = r11.f();
        if (r9 == (-1)) goto L26;
        if (r9 != 1) goto L22;
        r3 = am3.h.c(r11);
        goto L19
    L22:
        if (r9 != 2) goto L23;
        r8 = am3.h.c(r11);
        goto L19
    L23:
        am3.h.e(r11);
        goto L19
    L26:
        r11.d(r6);
        Map<String, String> r4 = this.requestParams;
        if (r3 == null) goto L33;
        if (r8 == null) goto L31;
        r4.put(r3, r8);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r2 != 4) goto L14;
        this.clickMob = new c(r11);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.afterClickPiece = _TextPiece_ProtoDecoder.decodeStatic(r11);
        goto L3
    L15:
        am3.h.e(r11);
        goto L3
    L36:
        r11.d(r0);
    }
}
