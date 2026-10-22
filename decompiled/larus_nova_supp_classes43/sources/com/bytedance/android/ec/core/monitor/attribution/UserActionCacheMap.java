package com.bytedance.android.ec.core.monitor.attribution;

import androidx.collection.LruCache;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lg.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/attribution/UserActionCacheMap;", "", "T", "Landroidx/collection/LruCache;", "Llg/d;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserActionCacheMap<T> extends LruCache<T, d> {
    public final Set<T> a;
    public final String b;

    public final Set<T> a() {
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll(snapshot().keySet());
        r0.addAll(this.a);
        return r0;
    }

    public UserActionCacheMap(String r10) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        super(10);
        this.b = r10;
        this.a = new LinkedHashSet();
    }

    public final Object create(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        int r1 = t0.a;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl((d) t0.a.a.fromJson(q.a.getString(this.b + '_' + r10, "{}"), d.class));     // Catch: Throwable -> L5
    L7:
        Object r12 = super.create(r10);
        if (Result.isFailure-impl(r11) == false) goto L11;
        r11 = r12;
    L11:
        return (d) r11;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final int sizeOf(Object r10, Object r11) {
        d r12 = (d) r11;
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r12, a.KEY_LUBAN_VALUE);
        return super.sizeOf(r10, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void entryRemoved(boolean r10, Object r11, Object r12, Object r13) {
        d r14 = (d) r12;
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r14, "oldValue");
        super.entryRemoved(r10, r11, r14, (d) r13);
        if (r10 == false) goto L6;
        a().add(r11);
        q r15 = q.a;
        String r16 = this.b + '_' + r11;
        int r17 = t0.a;
        r15.putString(r16, GsonProtectorUtils.toJson(t0.a.a, r14));
        return;
    }
}
