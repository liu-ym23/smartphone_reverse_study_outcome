package f31;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lf31/d;", "Lf31/h;", "", "mute", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "", "uid", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "toAll", "c", "g", "skipConfirm", "b", "f", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d extends h {

    @SerializedName("mute")
    private Integer mute;

    @SerializedName("skip_confirm")
    private Integer skipConfirm;

    @SerializedName("to_all")
    private Integer toAll;

    @SerializedName("uid")
    private String uid;

    public d() {
    }

    public final Integer a() {
        return this.mute;
    }

    public final Integer b() {
        return this.skipConfirm;
    }

    public final Integer c() {
        return this.toAll;
    }

    public final String d() {
        return this.uid;
    }

    public final void e(Integer r1) {
        this.mute = r1;
    }

    public final void f(Integer r1) {
        this.skipConfirm = r1;
    }

    public final void g(Integer r1) {
        this.toAll = r1;
    }

    public final void h(String r1) {
        this.uid = r1;
    }
}
