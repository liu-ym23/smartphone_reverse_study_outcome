package mq1;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface z {
    public static final a j2 = null;

    public static final class a {
        public static final List<String> a = null;
        public static final ArrayList<String> b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            a = CollectionsKt.mutableListOf(new String[]{"song_list_board_card", "song_list_board_multi_popup_card"});
            b = CollectionsKt.arrayListOf(new String[]{"pk", "anchor_profile", "audience_linkmic", "anchor_linkmic", "audience_audio"});
        }
    }

    static {
        j2 = a.c;
    }

    void a(vk1.a r1);
}
