package com.bytedance.applog.params.extract;

import android.util.LruCache;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/params/extract/ParamsExtractCache;", "", "maxEntries", "", "(I)V", "cache", "com/bytedance/applog/params/extract/ParamsExtractCache$cache$1", "Lcom/bytedance/applog/params/extract/ParamsExtractCache$cache$1;", "clearAll", "", "get", "Lcom/bytedance/applog/params/extract/ParamsExtractDao$ParamsExtractRecord;", "cpId", "", "put", "record", "putJson", "json", "Lorg/json/JSONObject;", "remove", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1769a;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/bytedance/applog/params/extract/ParamsExtractCache$cache$1", "Landroid/util/LruCache;", "", "Lcom/bytedance/applog/params/extract/ParamsExtractDao$ParamsExtractRecord;", "sizeOf", "", "key", EventBody.KEY_VALUE, "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends LruCache<String, c.a> {
        a(int r1) {
            super(r1);
        }

        public int a(String r1, c.a r2) {
            Intrinsics.checkNotNullParameter(r1, "key");
            Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
            return 1;
        }

        @Override // android.util.LruCache
        public /* synthetic */ int sizeOf(String r3, c.a r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (c.a) ZeusTransformUtils.preCheckCast(r4, c.a.class, "com.obric.memorydata.plugin"));
        }
    }

    public b(int r2) {
        this.f1769a = new a(r2);
    }

    public final c.a a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cpId");
        return (c.a) ZeusTransformUtils.preCheckCast(this.f1769a.get(r2), c.a.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r8, "cpId");
        Intrinsics.checkNotNullParameter(r9, "json");
        c.a r0 = new c.a(r8, "", r9, System.currentTimeMillis());
        this.f1769a.put(r8, r0);
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cpId");
        this.f1769a.remove(r2);
    }
}
