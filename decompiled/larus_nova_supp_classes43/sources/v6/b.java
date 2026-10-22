package v6;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lv6/b;", "", "", "", "tagConsistentRitConfig", "Ljava/util/List;", "getTagConsistentRitConfig", "()Ljava/util/List;", "<init>", "()V", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("tag_consistent_rit_config")
    private final List<String> tagConsistentRitConfig;

    public b() {
    }

    public final List<Integer> a() {
        List<String> r0 = this.tagConsistentRitConfig;
        if (r0 == null) goto L10;
        ArrayList r1 = new ArrayList();
        Iterator<T> r10 = r0.iterator();
    L6:
        if (r10.hasNext() == false) goto L17;
        Integer r11 = StringsKt.toIntOrNull((String) r10.next());
        if (r11 == null) goto L6;
        r1.add(r11);
        goto L6
    L17:
        return r1;
    L10:
        return null;
    }
}
