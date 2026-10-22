package w20;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lw20/ua;", "", "", "Lw20/ua$a;", "metaList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setMetaList", "(Ljava/util/List;)V", "", "maxStorage", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setMaxStorage", "(Ljava/lang/Integer;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ua {

    @SerializedName("maxStorage")
    private Integer maxStorage;

    @SerializedName("metaList")
    private List<a> metaList;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lw20/ua$a;", "", "", "idStr", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "", "tsList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setTsList", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("idStr")
        private String idStr;

        @SerializedName("tsList")
        private List<String> tsList;

        public a() {
        }

        public final String a() {
            return this.idStr;
        }

        public final List<String> b() {
            return this.tsList;
        }
    }

    public ua() {
    }

    public final Integer a() {
        return this.maxStorage;
    }

    public final List<a> b() {
        return this.metaList;
    }
}
