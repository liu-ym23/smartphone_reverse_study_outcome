package com.bytedance.android.live.broadcastgame.opengame;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudiencePluginManager$askSwitchGameIfNeed$3$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new AudiencePluginManager$askSwitchGameIfNeed$3$1();
    }

    public AudiencePluginManager$askSwitchGameIfNeed$3$1() {
        super(JvmClassMappingKt.class, "javaClass", "getJavaClass(Ljava/lang/Object;)Ljava/lang/Class;", 1);
    }

    public Object get(Object r1) {
        return JvmClassMappingKt.getJavaClass((Room) r1);
    }
}
