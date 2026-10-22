package di;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Ldi/m;", "", "Ldi/p;", "timing", "Ldi/p;", "f", "()Ldi/p;", "setTiming", "(Ldi/p;)V", "Ldi/n;", "response", "Ldi/n;", "d", "()Ldi/n;", "setResponse", "(Ldi/n;)V", "Ldi/o;", "socket", "Ldi/o;", "e", "()Ldi/o;", "setSocket", "(Ldi/o;)V", "Ldi/k;", "other", "Ldi/k;", "c", "()Ldi/k;", "setOther", "(Ldi/k;)V", "Ldi/a;", "base", "Ldi/a;", "a", "()Ldi/a;", "setBase", "(Ldi/a;)V", "Ldi/g;", "nqe", "Ldi/g;", "b", "()Ldi/g;", "setNqe", "(Ldi/g;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("base")
    private a base;

    @SerializedName("nqe")
    private g nqe;

    @SerializedName("other")
    private k other;

    @SerializedName("response")
    private n response;

    @SerializedName("socket")
    private o socket;

    @SerializedName("timing")
    private p timing;

    public m() {
    }

    public final a a() {
        return this.base;
    }

    public final g b() {
        return this.nqe;
    }

    public final k c() {
        return this.other;
    }

    public final n d() {
        return this.response;
    }

    public final o e() {
        return this.socket;
    }

    public final p f() {
        return this.timing;
    }
}
