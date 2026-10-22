package y9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ly9/q;", "", "", "", "pageList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setPageList", "(Ljava/util/List;)V", "", "mode", "I", "a", "()I", "setMode", "(I)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("mode")
    private int mode;

    @SerializedName("page_list")
    private List<String> pageList;

    public q() {
        this.pageList = CollectionsKt.emptyList();
    }

    public final int a() {
        return this.mode;
    }

    public final List<String> b() {
        return this.pageList;
    }
}
