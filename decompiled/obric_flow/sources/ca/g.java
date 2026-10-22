package ca;

import com.bytedance.retrofit2.client.Request;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f1163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1165l;

    @Override // ca.c
    public final boolean a(Request r5, LinkedHashMap r10) {
        if (this.f1164k == false) goto L5;
        return false;
    L5:
        if (b(r5) == false) goto L57;
        ArrayList r11 = this.f1162i;
        if (r11.isEmpty() == true) goto L19;
        LinkedHashMap r12 = new LinkedHashMap();
        if (r10.containsKey("x-tt-encrypt-queries") == false) goto L12;
        r12.put("x-tt-encrypt-queries", r10.get("x-tt-encrypt-queries"));
    L12:
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        if (r10.containsKey(r14) == false) goto L14;
        r12.put(r14, r10.get(r14));
        goto L14
    L18:
        r10.clear();
        r10.putAll(r12);
        return true;
    L19:
        ArrayList r15 = this.f1163j;
        if (r15.isEmpty() == true) goto L53;
        Iterator r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L26;
        r10.remove((String) r16.next());
        goto L23
    L26:
        if (r5.getUrl() == null) goto L28;
        String r17 = r5.getUrl();
    L30:
        if (this.f1165l == true) goto L32;
        return true;
    L32:
        if (r17.contains("bgrm") == true) goto L55;
        Iterator r18 = r15.iterator();
    L35:
        if (r18.hasNext() == false) goto L56;
        if (r17.contains((String) r18.next()) == false) goto L35;
        ArrayList r19 = new ArrayList();
        r19.add(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r10.put("bgrm", r19);
        return true;
    L56:
        return true;
    L55:
        return true;
    L28:
        r17 = "";
        goto L30
    L53:
        return true;
    L57:
        return false;
    }

    @Override // ca.c
    public final void c(JSONObject r10) {
        d(r10);
        JSONArray r5 = r10.optJSONArray("keep_list");
        ArrayList r11 = this.f1162i;
        e.d(r5, r11);
        JSONArray r12 = r10.optJSONArray("remove_list");
        ArrayList r13 = this.f1163j;
        e.d(r12, r13);
        boolean r14 = false;
        if (r10.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r15 = true;
    L6:
        this.f1154c = r15;
        if (r10.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r14 = true;
    L9:
        this.f1165l = r14;
        if (r11.isEmpty() == false) goto L12;
        return;
    L12:
        if (r13.isEmpty() == true) goto L16;
        this.f1164k = true;
        return;
    L16:
        return;
    L5:
        r15 = false;
        goto L6
    }
}
