package com.larus.bmhome.chat.trace.container;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J(\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/trace/container/AppreciableRecord;", "", "scene", "", "chatType", "totalDuration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getChatType", "setChatType", "getTotalDuration", "()Ljava/lang/Long;", "setTotalDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "toJSONObject", "Lorg/json/JSONObject;", "report", "", "tag", "params", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a {

    @SerializedName("chat_type")
    private String chatType;

    @SerializedName("scene")
    private String scene;

    @SerializedName("total_duration")
    private Long totalDuration;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.trace.container.a$a, reason: collision with other inner class name */
    public static final class C0012a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public a(int r1) {
        this.scene = null;
        this.chatType = null;
        this.totalDuration = null;
    }

    public final void b(String r1) {
        this.chatType = r1;
    }

    public final void c(String r1) {
        this.scene = r1;
    }

    public final void d(Long r1) {
        this.totalDuration = r1;
    }

    public final void a(String r4, Map<String, String> r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new JSONObject(new Gson().toJson(this)));     // Catch: Throwable -> L4
    L6:
        JSONObject r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        JSONObject r3 = (JSONObject) r1;
        if (r3 == null) goto L17;
        if (r5 == null) goto L16;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<String, String> r7 = r6.next();
        r3.put(r7.getKey(), r7.getValue());
    L16:
        r2 = r3;
    L17:
        FLogger.a.d(r4, "reportEvent, param = " + r2);
        if (r2 == null) goto L24;
        o.a.reportEvent("container_feel_duration_monitor", r2);
        com.larus.bmhome.utils.c.a("container_feel_duration_monitor", r2, true);
        return;
    L24:
        return;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
