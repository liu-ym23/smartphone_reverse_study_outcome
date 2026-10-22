package x8;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j implements SsHttpCall.IHttpCallThrottleControl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile j f13735f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f13739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f13740e;

    public j() {
        this.f13736a = false;
        this.f13737b = 0;
        this.f13738c = false;
        this.f13739d = new CopyOnWriteArraySet();
        this.f13740e = new ConcurrentHashMap();
        a();
    }

    public final void a() {
        boolean r8 = true;
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_enable", 0) <= 0) goto L5;
        boolean r10 = true;
    L6:
        this.f13736a = r10;
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_use_black_list", 0) > 0) goto L10;
        r8 = false;
    L10:
        this.f13738c = r8;
        this.f13737b = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "app_delay_whitelist_delay_time", 0);
        String r11 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "app_delay_white_list", "");
        CopyOnWriteArraySet r12 = this.f13739d;
        if (r12 == null) goto L17;
        r12.clear();
        if (TextUtils.isEmpty(r11) == true) goto L17;
        r12.addAll(Arrays.asList(r11.split(",")));
    L17:
        String r13 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "app_delay_black_list", "");
        ConcurrentHashMap r14 = this.f13740e;
        if (r14 == null) goto L31;
        r14.clear();
        if (TextUtils.isEmpty(r13) == true) goto L35;
        JSONObject r15 = new JSONObject(r13);     // Catch: JSONException -> L25
    L27:
        Iterator<String> r16 = r15.keys();
    L29:
        if (r16.hasNext() == false) goto L36;
        String r17 = r16.next();
        r14.put(r17, Integer.valueOf(r15.optInt(r17)));
        goto L29
    L36:
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
        goto L27
    L35:
        return;
    L31:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final int getDelayTimeByApp(String r8) {
        boolean r10 = this.f13738c;
        if (r10 == false) goto L17;
        ConcurrentHashMap r11 = this.f13740e;
        if (r11 == null) goto L17;
        Iterator r12 = r11.keySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L21;
        String r13 = (String) r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L8;
        if (r8.startsWith(r13) == false) goto L8;
        Integer r14 = (Integer) r11.get(r13);
        if (r14 == null) goto L21;
        return r14.intValue();
    L21:
        return 0;
    L17:
        if (r10 == true) goto L21;
        if (defpackage.c.Q(r8, this.f13739d) == false) goto L21;
        return this.f13737b;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final int getDispatchDelayTime(String r8, String r10) {
        return g7.j.e().a(r8, r10);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final boolean isAppDelayHandleEnable() {
        return this.f13736a;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final boolean isDispatchDelayEnabled() {
        return !g7.j.e().f7747f.isEmpty();
    }
}
