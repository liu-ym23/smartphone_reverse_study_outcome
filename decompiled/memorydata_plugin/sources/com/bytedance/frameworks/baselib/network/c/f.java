package com.bytedance.frameworks.baselib.network.c;

import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class f extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2306b = "f";
    private List<String> c;
    private List<String> d;
    private boolean e;
    private boolean f;

    static {
    }

    public f(int r1) {
        super(r1);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = false;
        this.f = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.c.c
    public void a(JSONObject r4) {
        b(r4);
        d.a(r4.optJSONArray("keep_list"), this.c);
        d.a(r4.optJSONArray("remove_list"), this.d);
        boolean r1 = false;
        if (r4.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.f2298a = r0;
        if (r4.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r1 = true;
    L9:
        this.f = r1;
        if (this.c.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.d.isEmpty() == true) goto L16;
        this.e = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.frameworks.baselib.network.c.c
    public boolean a(Request r5, Map<String, List<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (this.e == false) goto L5;
    L44:
        return false;
    L5:
        if (a(r5) == false) goto L44;
        if (r7.isEmpty() == false) goto L11;
        return false;
    L11:
        if (this.c.isEmpty() == true) goto L23;
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r8.put("x-tt-encrypt-queries", (List) ZeusTransformUtils.preCheckCast(r7.get("x-tt-encrypt-queries"), List.class, "com.obric.memorydata.plugin"));
    L15:
        Iterator<String> r4 = this.c.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.containsKey(r0) == false) goto L17;
        r8.put(r0, (List) ZeusTransformUtils.preCheckCast(r7.get(r0), List.class, "com.obric.memorydata.plugin"));
        goto L17
    L21:
        r7.clear();
        r7.putAll(r8);
        return true;
    L23:
        if (this.d.isEmpty() == true) goto L55;
        Iterator<String> r1 = this.d.iterator();
    L26:
        if (r1.hasNext() == false) goto L29;
        r7.remove((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));
        goto L26
    L29:
        if (r5.getUrl() == null) goto L31;
        String r9 = r5.getUrl();
    L33:
        if (this.f == true) goto L35;
        return true;
    L35:
        if (r9.contains("bgrm") == true) goto L57;
        Iterator<String> r10 = this.d.iterator();
    L38:
        if (r10.hasNext() == false) goto L58;
        if (r9.contains((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L38;
        ArrayList r11 = new ArrayList();
        r11.add("1");
        r7.put("bgrm", r11);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r9 = "";
        goto L33
    L55:
        return true;
    }
}
