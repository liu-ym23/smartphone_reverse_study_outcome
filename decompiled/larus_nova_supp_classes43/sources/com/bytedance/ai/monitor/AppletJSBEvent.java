package com.bytedance.ai.monitor;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletJSBEvent extends AppletMonitorableEvent {
    public final String k;
    public final int l;
    public JSBType m;
    public String n;
    public boolean o;
    public JSONObject p;
    public String q;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/AppletJSBEvent$JSBType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AppletJSB", "XBridge", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum JSBType extends Enum<JSBType> {
        public static final JSBType AppletJSB = null;
        public static final JSBType XBridge = null;
        public static final /* synthetic */ JSBType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int type;

        public static EnumEntries<JSBType> getEntries() {
            return b;
        }

        static {
            JSBType r0 = new JSBType("AppletJSB", 0, 0);
            AppletJSB = r0;
            JSBType r1 = new JSBType("XBridge", 1, 1);
            XBridge = r1;
            JSBType[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static JSBType[] values() {
            return (JSBType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static JSBType valueOf(String r1) {
            return (JSBType) r27.a.a(JSBType.class, r1);
        }

        public JSBType(String r1, int r10, int r11) {
            super(r1, r10);
            this.type = r11;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.putOpt("packageId", this.f);     // Catch: Throwable -> L5
        r0.putOpt(BdpAwemeConstant.KEY_APP_ID, this.g);     // Catch: Throwable -> L5
        r0.putOpt("bridgeName", this.k);     // Catch: Throwable -> L5
        r0.putOpt("code", Integer.valueOf(this.l));     // Catch: Throwable -> L5
        r0.putOpt("jsbType", this.m.name());     // Catch: Throwable -> L5
        r0.putOpt(com.bytedance.android.ec.core.event.a.KEY_MSG, this.n);     // Catch: Throwable -> L5
        r0.putOpt("success", Boolean.valueOf(this.o));     // Catch: Throwable -> L5
        r0.putOpt(com.bytedance.android.ec.core.event.a.KEY_URL, this.q);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(r0.putOpt("containerType", null));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L10;
        g.a.w("AppletJSBEvent", "Exception when get category: " + r11);
    L10:
        return r0;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final boolean b() {
        if (super.b() == true) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank(this.k)) == true) goto L7;
        return false;
    L7:
        if (this.k.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r0 = false;
        goto L10
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject n() {
        JSONObject r0 = super.n();
        if (r0.length() != 0) goto L11;
        return r0;
    L11:
    L9:
        g.a.w("AppletJSBEvent", "Exception occurred when parse jsb event to json");
    L10:
        return r0;
    L6:
        if (this.o == true) goto L10;
        r0.putOpt("params", this.p);     // Catch: JSONException -> L9
        goto L10
    }

    public AppletJSBEvent(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeName");
        super("applet_jsb_event");
        this.m = JSBType.AppletJSB;
        this.o = true;
        Intrinsics.checkNotNullParameter("jsb_event", "<set-?>");
        this.b = "jsb_event";
        this.k = r10;
        this.l = r11;
    }
}
