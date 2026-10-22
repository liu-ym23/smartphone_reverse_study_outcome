package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BaseDispatchAction {
    private static final String j = "b";
    private int k;
    private int l;
    private int m;
    private final Map<String, Set<String>> n;

    static {
    }

    public b() {
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BaseDispatchAction.DispatchResultEnum b(String r7, String r8, List<Integer> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Uri r11 = Uri.parse(r7);
        if (r11.getHost() == null) goto L59;
        if (a(r11) == false) goto L59;
        if (this.n.isEmpty() == false) goto L15;
        r10.set(0, Integer.valueOf(e()));
        if (Logger.debug() == false) goto L13;
        Logger.d(j, "tnc tag map is empty, result delay time is " + r10.get(0));
    L13:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
    L15:
        if (TTDelayStateManager.c() == true) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d(j, "this action with tag is not enabled");
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if ("".equals(r8) == false) goto L24;
        r8 = "s=0;p=0";
    L24:
        HashMap r12 = new HashMap();
        ArrayList r2 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.a(r8, ";", "=", r2) == false) goto L27;
        Iterator r3 = r2.iterator();
    L30:
        if (r3.hasNext() == false) goto L32;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin");
        r12.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin"));
        goto L30
    L32:
        String r5 = Integer.toString(TTDelayStateManager.AppStartState.NormalStart.getValue());
        if (TTDelayStateManager.b() == TTDelayStateManager.AppStartState.NormalStart) goto L35;
        r5 = Integer.toString(TTDelayStateManager.a().getValue());
    L35:
        r12.put("s", r5);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L38;
        boolean r13 = com.bytedance.frameworks.baselib.network.http.util.g.b(r6);
    L39:
        r12.put("p", Integer.toString(!r13));
        if (Logger.debug() == false) goto L42;
        Logger.d(j, "request tag string is " + r8);
    L42:
        BaseDispatchAction.DispatchResultEnum r14 = BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        Iterator<Map.Entry<String, Set<String>>> r15 = this.n.entrySet().iterator();
    L44:
        if (r15.hasNext() == false) goto L52;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r12.get(r16.getKey()), String.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L47;
        if (((Set) ZeusTransformUtils.preCheckCast(r16.getValue(), Set.class, "com.obric.memorydata.plugin")).contains(r17) == true) goto L44;
    L47:
        r14 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L52:
        if (r14 != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L55;
        r10.set(0, Integer.valueOf(e()));
    L55:
        if (Logger.debug() == false) goto L57;
        String r1 = j;
        Logger.d(r1, "match tag result is " + r14);
        Logger.d(r1, "will delay time is " + r10.get(0));
        Logger.d(r1, "request tag map is " + r12);
        Logger.d(r1, "tnc tag map is " + this.n);
    L57:
        return r14;
    L38:
        r13 = 1;
        goto L39
    L27:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L59:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    private int e() {
        int r0 = this.k;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (this.l < this.m) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.m - this.l) + this.l;
    }

    public BaseDispatchAction.DispatchResultEnum a(String r3, String r4, List<Integer> r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(j, "take delay action");
    L6:
        if (d() == true) goto L8;
    L12:
        r6.set(0, 0);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return b(r3, r4, r6);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean a(JSONObject r8, String r9, long r10) {
        a(r8);
        String r11 = r8.optString(LocationMonitorConst.TAG);
        int r12 = 0;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        String[] r13 = r11.split(";");
        int r14 = r13.length;
        int r0 = 0;
    L5:
        if (r0 >= r14) goto L17;
        String r1 = r13[r0];
        ArrayList r2 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.a(r1, ",", "=", r2) == false) goto L16;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin");
        Set<String> r5 = (Set) ZeusTransformUtils.preCheckCast(this.n.get(r4.first), Set.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L15;
        r5 = new HashSet();
    L15:
        r5.add((String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin"));
        this.n.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin"), r5);
    L16:
        r0 = r0 + 1;
    L17:
        this.k = r8.optInt("delay");
        JSONArray r15 = r8.optJSONArray("random");
        if (this.k > 0) goto L37;
        if (r15 == null) goto L37;
        if (r15.length() == 2) goto L44;
        return false;
    L44:
        int r16 = r15.getInt(0);     // Catch: JSONException -> L28
        int r17 = r15.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r16 <= 0) goto L36;
        if (r17 <= 0) goto L36;
        if (r16 >= r17) goto L36;
        r12 = r16;
    L38:
        this.l = r12;
        this.m = r17;
        if (Logger.debug() == false) goto L41;
        Logger.d(j, "initwithparam tnc tag map is " + this.n);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r17 = 0;
    L28:
        e = e;
        r16 = 0;
    L37:
        r17 = 0;
        goto L38
    }
}
