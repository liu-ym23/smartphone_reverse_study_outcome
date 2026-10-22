package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livesdkapi.util.url.BasicNameValuePair;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class RequestInterceptorConstants {
    public static final Map<String, String> a = null;

    static {
        a = MapsKt.mapOf(new Pair[]{new Pair("anchor_id", "anchor_open_id"), new Pair("to_user_id", "to_user_open_id"), new Pair("from_user_id", "from_user_open_id"), new Pair("user_id", "open_user_id"), new Pair("rival_user_id", "rival_open_id"), new Pair("rival_user_id_str", "rival_open_id_str"), new Pair("invite_user_id", "invite_open_id"), new Pair("source_user_id", "source_user_open_id"), new Pair("invite_uid", "invite_open_id"), new Pair("control_user_id", "control_open_id"), new Pair("mvp_uid", "mvp_open_id"), new Pair("loser_id", "loser_open_id"), new Pair("singer_id", "singer_open_id"), new Pair("mock_user_id", "mock_open_id"), new Pair("lucky_user_id", "lucky_user_open_id"), new Pair("target_uid", "target_open_id")});
    }

    @JvmStatic
    public static final JsonObject a(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "inArgs");
        final JsonObject r0 = r5.deepCopy();
        final Set r1 = r5.keySet();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        final Map.Entry r2 = (Map.Entry) r6.next();
        e(r1, (String) r2.getKey(), new RequestInterceptorConstants$appendFuseParams$$inlined$forEach$lambda$1(r2, r1, r0));
        goto L4
    L6:
        return r0;
    }

    @JvmStatic
    public static final List<NameValuePair> b(List<? extends NameValuePair> r5) {
        Intrinsics.checkNotNullParameter(r5, "inArgs");
        final ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((NameValuePair) r2.next()).getName());
        goto L4
    L6:
        Set r3 = CollectionsKt.toSet(r1);
        Iterator r6 = ((ArrayList) r5).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        final NameValuePair r4 = (NameValuePair) r6.next();
        e(r3, r4.getName(), new RequestInterceptorConstants$appendFuseParams$1(r0, r4));
        goto L8
    L10:
        return r0;
    }

    @JvmStatic
    public static final JSONObject c(final JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "inArgs");
        final JSONObject r0 = new JSONObject();
        final Set r1 = SequencesKt.toSet(SequencesKt.asSequence(r6.keys()));
        Iterator<String> r2 = r6.keys();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        final Object r4 = r6.get(r3);
        r0.put(r3, r4);
        e(r1, r3, new RequestInterceptorConstants$appendFuseParams$$inlined$forEach$lambda$2(r4, r6, r0, r1));
        goto L4
    L6:
        return r0;
    }

    @JvmStatic
    public static final List<BasicNameValuePair> d(List<? extends BasicNameValuePair> r5) {
        Intrinsics.checkNotNullParameter(r5, "inArgs");
        final ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((BasicNameValuePair) r2.next()).getName());
        goto L4
    L6:
        Set r3 = CollectionsKt.toSet(r1);
        Iterator r6 = ((ArrayList) r5).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        final BasicNameValuePair r4 = (BasicNameValuePair) r6.next();
        e(r3, r4.getName(), new RequestInterceptorConstants$appendFuseParamsBasic$1(r0, r4));
        goto L8
    L10:
        return r0;
    }

    public static void e(Set r2, String r3, Function2 r4) {
        Map<String, String> r0 = a;
        if (r0.containsKey(r3) == false) goto L10;
        String r1 = r0.get(r3);
        if (r1 != null) goto L7;
        return;
    L7:
        if (r2.contains(r1) == true) goto L12;
        r4.invoke(r3, r1);
        return;
    L12:
        return;
    }
}
