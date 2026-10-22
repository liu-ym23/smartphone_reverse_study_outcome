package com.bytedance.android.live.base.model.message;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface g4 {
    public static final a e0 = null;

    public static final class a {
        public static final List<String> a = null;
        public static final List<String> b = null;
        public static final List<String> c = null;
        public static final List<String> d = null;
        public static final /* synthetic */ a e = null;

        public a() {
        }

        static {
            e = new a();
            a = CollectionsKt.listOf(new String[]{"livehead_enter_prompt_goods_ab1", "livehead_enter_prompt_goods_ab2"});
            b = CollectionsKt.listOf(new String[]{"game_cp_user_multi_download", "game_cp_user_single_download"});
            c = CollectionsKt.listOf(new String[]{"auction_bid_notify", "auction_end_notify"});
            d = CollectionsKt.listOf("instance_role_show_real_grade");
        }
    }

    static {
        e0 = a.e;
    }

    String getScene();
}
