package com.ss.android.lark.forwardv2.impl.model;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a extends BaseModel implements iib.a {
    public final Map<String, SearchBaseInfo> a;

    @Override // iib.a
    public final void a3() {
        ((LinkedHashMap) this.a).clear();
    }

    @Override // iib.a
    public final List<SearchBaseInfo> z7() {
        return new ArrayList(((LinkedHashMap) this.a).values());
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    @Override // iib.a
    public final CallbackManager m3() {
        return getCallbackManager();
    }

    public final void create() {
        super.create();
    }

    @Override // iib.a
    public final void Y4(SearchBaseInfo r3, boolean r4) {
        String r0 = r3.getId();
        if (r4 == true) goto L5;
    L7:
        if (r4 == false) goto L9;
        return;
    L9:
        if (this.a.containsKey(r0) == false) goto L14;
        this.a.remove(r0);
        return;
    L14:
        return;
    L5:
        if (this.a.containsKey(r0) == true) goto L7;
        this.a.put(r0, r3);
    }
}
