package ft9;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final Map<String, String> a = null;
    public static final List<String> b = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("feishu_add_by_link", "https://applink.doubao.com".concat("/client/chat/chatter/add_by_link")), TuplesKt.to("feishu_add_contact", "https://applink.doubao.com".concat("/invitation/page/add_contact/"))});
        b = CollectionsKt.listOf(new String[]{"webcast.amemv.com", "doubao.com", "doupay.com", "douyinpay.com", "ulpay.com"});
    }
}
