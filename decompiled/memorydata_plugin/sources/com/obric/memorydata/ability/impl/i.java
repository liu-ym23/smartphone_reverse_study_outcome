package com.obric.memorydata.ability.impl;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/ability/impl/IMetaAbility;", "", "onCreate", "", "iAbilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "onVerify", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onDestroy", "onQuery", "key", "", "onSubscribe", "onUnsubscribe", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface i {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static boolean a(i r2, com.obric.memorydata.ability.f r3) {
            i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
            return true;
        }

        public static boolean a(i r2, String r3, com.obric.memorydata.ability.f r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
            return false;
        }

        public static boolean b(i r2, String r3, com.obric.memorydata.ability.f r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
            return false;
        }

        public static boolean c(i r2, String r3, com.obric.memorydata.ability.f r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
            return false;
        }
    }

    void a();

    void a(com.obric.memorydata.ability.j r1);

    boolean a(com.obric.memorydata.ability.f r1);

    boolean a(String r1, com.obric.memorydata.ability.f r2);

    boolean b(String r1, com.obric.memorydata.ability.f r2);

    boolean c(String r1, com.obric.memorydata.ability.f r2);
}
