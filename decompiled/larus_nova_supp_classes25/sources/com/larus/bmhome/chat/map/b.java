package com.larus.bmhome.chat.map;

import android.text.TextUtils;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "It is recommended to use the API in the image-loader module")
public final class b {
    public static final b a = null;
    public static final DiskCache b = null;

    public b() {
    }

    static {
        a = new b();
        b = new DiskCache("custom-img-cache");
    }

    public final Object a(String r17, String r18, Continuation r19) {
        if ((r19 instanceof ImageCacheLoader$requestNewUrl$1) == false) goto L7;
        ImageCacheLoader$requestNewUrl$1 r1 = (ImageCacheLoader$requestNewUrl$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ImageCacheLoader$requestNewUrl$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        String r5 = (String) r13.L$0;
        ResultKt.throwOnFailure(r0);
        String r15 = r5;
    L20:
        FileUrlsList r6 = (FileUrlsList) ((a) r0).b;
        if (r6 == null) goto L25;
        List<FileUrlsBean> r7 = r6.getFileUrls();
        if (r7 == null) goto L25;
        FileUrlsBean r8 = (FileUrlsBean) CollectionsKt.firstOrNull(r7);
    L26:
        if (r8 != null) goto L28;
    L33:
        return r15;
    L28:
        if (TextUtils.isEmpty(r8.getMainUrl()) == true) goto L33;
        String r9 = r8.getMainUrl();
        if (r9 != null) goto L34;
        return "";
    L34:
        return r9;
    L25:
        r8 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uris", new JSONArray().put(r17)), TuplesKt.to("type", "image")});
        if (o0.d(null) == false) goto L17;
        r10.put("format", null);
    L17:
        JSONObject r11 = new JSONObject(r10);
        r15 = r18;
        r13.L$0 = r15;
        r13.label = 1;
        r0 = HttpExtKt.k("Social", FileUrlsList.class, "/alice/message/get_file_url", r11, null, null, false, null, null, null, r13, 1008);
        if (r0 != r3) goto L20;
        return r3;
    L7:
        r1 = new ImageCacheLoader$requestNewUrl$1(this, r19);
        goto L8
    }
}
