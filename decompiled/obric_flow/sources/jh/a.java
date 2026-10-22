package jh;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0003\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\"\u0004\b\t\u0010\u001a¨\u0006\u001c"}, d2 = {"Ljh/a;", "", "", "a", "Ljava/lang/Number;", "e", "()Ljava/lang/Number;", "maxAge", "", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "version", "Lcom/google/gson/JsonObject;", "c", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "meta", "d", "(Ljava/lang/Number;)V", "expire", "", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "marked", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("maxAge")
    private final Number f18340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("version")
    private final String f18341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("meta")
    private final JsonObject f18342c;

    @SerializedName("expire")
    private Number d;

    @SerializedName("marked")
    private Boolean e;

    public a() {
        this.f18340a = null;
        this.f18341b = null;
        this.f18342c = null;
        this.d = null;
        this.e = null;
    }

    public final Number a() {
        return this.d;
    }

    public final void b(Boolean r5) {
        this.e = r5;
    }

    public final void c(Long r5) {
        this.d = r5;
    }

    public final Boolean d() {
        return this.e;
    }

    public final Number e() {
        return this.f18340a;
    }

    public final JsonObject f() {
        return this.f18342c;
    }

    public final String g() {
        return this.f18341b;
    }

    public final JsonObject h() {
        JsonObject r5 = new JsonObject();
        Number r10 = this.f18340a;
        if (r10 == null) goto L5;
        r5.addProperty("maxAge", r10);
    L5:
        String r11 = this.f18341b;
        if (r11 == null) goto L8;
        r5.addProperty("version", r11);
    L8:
        Number r12 = this.d;
        if (r12 == null) goto L11;
        r5.addProperty("expire", r12);
    L11:
        JsonObject r13 = this.f18342c;
        if (r13 == null) goto L14;
        r5.add("meta", r13);
    L14:
        Boolean r14 = this.e;
        if (r14 == null) goto L17;
        r5.addProperty("marked", r14);
    L17:
        return r5;
    }

    public final String toString() {
        return h().toString();
    }
}
