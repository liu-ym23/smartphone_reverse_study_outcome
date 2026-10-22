package com.obric.memorydata.ability;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "", "getKey", "", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface k {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static String a(k r2) {
            k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder().append(r3);
            String r4 = Integer.toString(r3.hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
            return r0.append(r4).toString();
        }
    }

    void a(com.obric.memorydata.ability.data.h r1);

    String g_();
}
