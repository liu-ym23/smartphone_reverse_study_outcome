package io.noties.markwon.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.q;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CoreProps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<ListItemType> f16408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q<Integer> f16409b = null;
    public static final q<Integer> c = null;
    public static final q<Integer> d = null;
    public static final q<Boolean> e = null;
    public static final q<Integer> f = null;
    public static final q<String> g = null;
    public static final q<Map<String, String>> h = null;
    public static final q<Boolean> i = null;
    public static final q<HashMap<String, Integer>> j = null;
    public static final q<String> k = null;
    public static final q<String> l = null;

    public static final enum ListItemType extends Enum<ListItemType> {
        private static final /* synthetic */ ListItemType[] $VALUES = null;
        public static final ListItemType BULLET = null;
        public static final ListItemType ORDERED = null;

        static {
            ListItemType r0 = new ListItemType("BULLET", 0);
            BULLET = r0;
            ListItemType r1 = new ListItemType("ORDERED", 1);
            ORDERED = r1;
            $VALUES = new ListItemType[]{r0, r1};
        }

        private ListItemType(String r1, int r2) {
            super(r1, r2);
        }

        public static ListItemType valueOf(String r2) {
            return (ListItemType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ListItemType.class, r2), ListItemType.class, "com.obric.memorydata.plugin");
        }

        public static ListItemType[] values() {
            return (ListItemType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ListItemType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f16408a = q.a("list-item-type");
        f16409b = q.a("bullet-list-item-level");
        c = q.a("list-item-real-level");
        d = q.a("ordered-list-item-number");
        e = q.a("list-item-real-self");
        f = q.a("heading-level");
        g = q.a("link-destination");
        h = q.a("link-extra");
        i = q.a("paragraph-is-in-tight-list");
        j = q.a("render_node_info");
        k = q.a("code-block-info");
        l = q.a("code-block-code");
    }
}
