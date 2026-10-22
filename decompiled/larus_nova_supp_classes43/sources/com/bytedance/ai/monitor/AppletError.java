package com.bytedance.ai.monitor;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletError extends AppletMonitorableEvent {
    public final AppletErrorCode k;
    public final ErrorLevel l;
    public final String m;
    public String n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/AppletError$ErrorLevel;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Warn", "Error", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorLevel extends Enum<ErrorLevel> {
        public static final ErrorLevel Error = null;
        public static final ErrorLevel Warn = null;
        public static final /* synthetic */ ErrorLevel[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int type;

        public static EnumEntries<ErrorLevel> getEntries() {
            return b;
        }

        static {
            ErrorLevel r0 = new ErrorLevel("Warn", 0, 1);
            Warn = r0;
            ErrorLevel r1 = new ErrorLevel("Error", 1, 2);
            Error = r1;
            ErrorLevel[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static ErrorLevel[] values() {
            return (ErrorLevel[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static ErrorLevel valueOf(String r1) {
            return (ErrorLevel) r27.a.a(ErrorLevel.class, r1);
        }

        public ErrorLevel(String r1, int r10, int r11) {
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
        r0.putOpt("code", Integer.valueOf(this.k.getType()));     // Catch: Throwable -> L5
        r0.putOpt("error_name", this.k.name());     // Catch: Throwable -> L5
        r0.putOpt(com.bytedance.android.ec.core.event.a.KEY_MSG, this.m);     // Catch: Throwable -> L5
        r0.putOpt("level", this.l);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(r0.putOpt("ai_sdk_version", "1.15.0-rc.7"));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L10;
        g.a.w("AppletError", "Exception when get category: " + r11);
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
        if (this.k == AppletErrorCode.SUCCESS) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject n() {
        if (b() == false) goto L5;
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        AppletMonitorableEvent.l("recovery_suggestion", null, r0);     // Catch: JSONException -> L8
        AppletMonitorableEvent.l("error_stack", this.n, r0);     // Catch: JSONException -> L8
        r0.putOpt("origin", this.c.name());     // Catch: JSONException -> L8
        r0.put("timeStamp", this.e);     // Catch: JSONException -> L8
        AppletMonitorableEvent.c(this.h, r0);     // Catch: JSONException -> L8
        AppletMonitorableEvent.j(r0);     // Catch: JSONException -> L8
        return r0;
    L8:
        e = move-exception;
        g.a.d("AppletError", "failed to convert error to json: " + e.getMessage());
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public AppletError(AppletErrorCode r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        ErrorLevel r12 = ErrorLevel.Error;
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r12, "level");
        super("applet_error");
        this.k = r10;
        this.m = r11;
        this.l = r12;
        Intrinsics.checkNotNullParameter("error_event", "<set-?>");
        this.b = "error_event";
    }
}
