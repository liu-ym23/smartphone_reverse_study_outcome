package com.bytedance.applog.filter;

import android.content.Context;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.PriorityWrapper;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0018\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012<\u0010\n\u001a8\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u000bj \u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u001c\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0014J$\u0010\u001f\u001a\u00020\u00122\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\"\u001a\u00020\u0012H\u0016R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/applog/filter/NativeFilter;", "Lcom/bytedance/applog/filter/AbstractEventFilter;", "appLogInstance", "Lcom/bytedance/applog/AppLogInstance;", "config", "Lorg/json/JSONObject;", "eventSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", TrackerImpl.PARAMS, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Lcom/bytedance/applog/AppLogInstance;Lorg/json/JSONObject;Ljava/util/HashSet;Ljava/util/HashMap;)V", "appId", "getAppId", "()Ljava/lang/String;", "hasFilter", "", "getHasFilter", "()Z", "setHasFilter", "(Z)V", "lazySoLoader", "com/bytedance/applog/filter/NativeFilter$lazySoLoader$1", "Lcom/bytedance/applog/filter/NativeFilter$lazySoLoader$1;", "clearCache", "", "filter", "eventName", "interceptEventName", "interceptEventParam", "filterParamSet", AutoTestConstant.PARAM, "noFilter", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f extends com.bytedance.applog.filter.a {
    private final String d;
    private boolean e;
    private final a f;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J%\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/bytedance/applog/filter/NativeFilter$lazySoLoader$1", "Lcom/bytedance/applog/log/AbsSingleton;", "", "create", TrackerImpl.PARAMS, "", "", "([Ljava/lang/Object;)Ljava/lang/Boolean;", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends com.bytedance.applog.log.b<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.applog.b f1593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f1594b;
        final /* synthetic */ JSONObject c;

        a(com.bytedance.applog.b r1, f r2, JSONObject r3) {
            this.f1593a = r1;
            this.f1594b = r2;
            this.c = r3;
        }

        public Boolean a(Object... r6) {
            Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
            PriorityWrapper.f1778b.c(new Object[0]);
            if (this.f1593a.aN() == false) goto L6;
            NativeLogWrapper.a(true);
        L6:
            if (PriorityWrapper.f1777a != NativeFilterJNI.nativeInitServerFilter(this.f1594b.b(), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1593a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath())) goto L12;
            JSONObject r7 = this.c;
            if (r7 == null) goto L10;
            NativeFilterJNI.nativeSetServerFilterConfig(this.f1594b.b(), r7.toString());
        L10:
            f r5 = this.f1594b;
            r5.a(!NativeFilterJNI.nativeIsServerFilterEmpty(r5.b()));
        L12:
            return true;
        }

        @Override // com.bytedance.applog.log.b
        public /* synthetic */ Boolean b(Object[] r1) {
            return a(r1);
        }
    }

    public f(com.bytedance.applog.b r2, JSONObject r3, HashSet<String> r4, HashMap<String, HashSet<String>> r5) {
        Intrinsics.checkNotNullParameter(r2, "appLogInstance");
        super(r2, r4, r5);
        String r6 = r2.b();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        this.d = r6;
        a r7 = new a(r2, this, r3);
        this.f = r7;
        r7.c(new Object[0]);
    }

    public final void a(boolean r1) {
        this.e = r1;
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a() {
        return !this.e;
    }

    @Override // com.bytedance.applog.filter.a
    public boolean a(String r1) {
        return false;
    }

    @Override // com.bytedance.applog.filter.a
    public boolean a(String r1, String r2) {
        if (this.e == true) goto L6;
        return true;
    L6:
        String r0 = this.d;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        return NativeFilterJNI.nativeIsEventAllowed(r0, r1);
    }

    @Override // com.bytedance.applog.filter.a
    public boolean a(HashSet<String> r1, String r2) {
        return false;
    }

    public final String b() {
        return this.d;
    }

    public final void c() {
        NativeFilterJNI.nativeClearCache(this.d);
        this.e = false;
    }
}
