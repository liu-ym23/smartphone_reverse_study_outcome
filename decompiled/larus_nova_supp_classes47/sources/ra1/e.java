package ra1;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u00062"}, d2 = {"Lra1/e;", "", "", "statusCode", "I", "i", "()I", "setStatusCode", "(I)V", "", "statusMessage", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "setStatusMessage", "(Ljava/lang/String;)V", "", "Lra1/f;", "liveList", "Ljava/util/List;", "f", "()Ljava/util/List;", "n", "(Ljava/util/List;)V", "", "cursor", "J", "c", "()J", "l", "(J)V", "", "hasMore", "Z", "d", "()Z", "m", "(Z)V", "Lcom/google/gson/JsonObject;", "logPb", "Lcom/google/gson/JsonObject;", "g", "()Lcom/google/gson/JsonObject;", "o", "(Lcom/google/gson/JsonObject;)V", "globalDoodleConfig", "getGlobalDoodleConfig", "setGlobalDoodleConfig", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class e {

    @SerializedName("cursor")
    private long cursor;

    @SerializedName("global_doodle_config")
    private JsonObject globalDoodleConfig;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName(Constants.Keys.DATA)
    private List<f> liveList;

    @SerializedName("log_pb")
    private JsonObject logPb;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_message")
    private String statusMessage;

    public final void m() {
        this.hasMore = true;
    }

    public e a() {
        e r0 = new e();
        b(r0);
        return r0;
    }

    public final String e() {
        JsonObject r0 = this.logPb;
        if (r0 == null) goto L8;
        JsonElement r1 = r0.get("impr_id");
        if (r1 == null) goto L8;
        String r2 = r1.getAsString();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final boolean h() {
        JsonObject r0 = this.globalDoodleConfig;
        if (r0 == null) goto L7;
        JsonElement r1 = r0.get("show_recommend");
        if (r1 == null) goto L7;
        return r1.getAsBoolean();
    L7:
        return false;
    }

    public e() {
        this.statusMessage = "";
    }

    public final long c() {
        return this.cursor;
    }

    public final boolean d() {
        return this.hasMore;
    }

    public final List<f> f() {
        return this.liveList;
    }

    public final JsonObject g() {
        return this.logPb;
    }

    public final int i() {
        return this.statusCode;
    }

    public final String j() {
        return this.statusMessage;
    }

    public final void b(e r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        r3.statusCode = this.statusCode;
        r3.statusMessage = this.statusMessage;
        ArrayList r0 = new ArrayList();
        r3.liveList = r0;
        List<f> r1 = this.liveList;
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        r3.cursor = this.cursor;
        r3.hasMore = this.hasMore;
        r3.logPb = this.logPb;
        r3.globalDoodleConfig = this.globalDoodleConfig;
    }

    public final e k(e r4) {
        e r0 = a();
        if (r4 == null) goto L9;
        List<f> r5 = r4.liveList;
        if (r5 == null) goto L9;
        List<f> r1 = r0.liveList;
        if (r1 == null) goto L9;
        r1.addAll(0, r5);
    L9:
        return r0;
    }

    public final void l(long r1) {
        this.cursor = r1;
    }

    public final void n(List<f> r1) {
        this.liveList = r1;
    }

    public final void o(JsonObject r1) {
        this.logPb = r1;
    }
}
