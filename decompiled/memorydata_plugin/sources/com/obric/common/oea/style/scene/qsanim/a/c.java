package com.obric.common.oea.style.scene.qsanim.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.animation.c.e;
import com.obric.common.oea.foundation.animation.c.f;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "后续请使用动效曲线中的 api")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u0012\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tJ'\u0010\u0014\u001a\u00020\u000e\"\b\b\u0000\u0010\u0015*\u00020\u0001*\u0002H\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004¢\u0006\u0002\u0010\u0017J]\u0010\u0018\u001a\u0004\u0018\u00010\f\"\b\b\u0000\u0010\u0015*\u00020\u0001*\u0002H\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils;", "", "()V", "PROPERTY_FLOAT", "Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "getPROPERTY_FLOAT", "()Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "TAG", "", "springAnimCache", "", "Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "clearAnimCache", "", "responseToStiffness", "", ChatMessage.TYPE_RESPONSE, "animKey", LocationMonitorConst.TAG, "cancelSpring", "K", "property", "(Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;)V", "springTo", "targetValue", "dampingRatio", "stiffness", "updateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "endListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "(Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;FFFLcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;)Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "CommonFloatProperty", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, e> f7830b = null;
    private static final com.obric.common.oea.foundation.animation.c.c<a> c = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "", EventBody.KEY_VALUE, "", "(F)V", "getValue", "()F", "setValue", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7831a;

        public a(float r1) {
            this.f7831a = r1;
        }

        public final float a() {
            return this.f7831a;
        }

        public final void a(float r1) {
            this.f7831a = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$PROPERTY_FLOAT$1", "Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "getValue", "", "obj", "setValue", "", EventBody.KEY_VALUE, "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends com.obric.common.oea.foundation.animation.c.c<a> {
        b(String r1) {
            super(r1);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(a r1) {
            Intrinsics.checkNotNull(r1);
            return r1.a();
        }

        @Override // com.obric.common.oea.foundation.animation.c.c
        public /* synthetic */ float a(a r3) {
            return a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(a r1, float r2) {
            Intrinsics.checkNotNull(r1);
            r1.a(r2);
        }

        @Override // com.obric.common.oea.foundation.animation.c.c
        public /* synthetic */ void a(a r3, float r4) {
            a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
        f7829a = new c();
        f7830b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = (com.obric.common.oea.foundation.animation.c.c) ZeusTransformUtils.preCheckCast(new b(BaseSwitches.V), com.obric.common.oea.foundation.animation.c.c.class, "com.obric.memorydata.plugin");
    }

    private c() {
    }

    public static /* synthetic */ e a(c r12, Object r13, com.obric.common.oea.foundation.animation.c.c r14, float r15, float r16, float r17, com.obric.common.oea.foundation.animation.c.b.c r18, com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b r19, int r20, Object r21) {
        com.obric.common.oea.foundation.animation.c.b.c r0 = (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b r2 = (com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b.class, "com.obric.memorydata.plugin");
        if ((r20 & 4) == 0) goto L5;
        float r8 = 0.9f;
    L7:
        if ((r20 & 8) == 0) goto L9;
        float r9 = 250.0f;
    L11:
        if ((r20 & 16) == 0) goto L13;
        r0 = (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin");
    L13:
        com.obric.common.oea.foundation.animation.c.b.c r10 = r0;
        if ((r20 & 32) == 0) goto L17;
        r2 = (com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b.class, "com.obric.memorydata.plugin");
    L17:
        return r12.a(r13, r14, r15, r8, r9, r10, r2);
    L9:
        r9 = r17;
        goto L11
    L5:
        r8 = r16;
        goto L7
    }

    public final float a(float r1) {
        return (40.0f / r1) / r1;
    }

    public final com.obric.common.oea.foundation.animation.c.c<a> a() {
        return c;
    }

    public final <K> e a(K r4, com.obric.common.oea.foundation.animation.c.c<K> r5, float r6, float r7, float r8, com.obric.common.oea.foundation.animation.c.b.c r9, com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b r10) {
        com.obric.common.oea.foundation.animation.c.b.c r11 = (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b r12 = (com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.common.oea.foundation.animation.c.b.InterfaceC0374b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$this$springTo");
        Intrinsics.checkNotNullParameter(r5, "property");
        String r3 = a(r4, "SPRING_ANIM_" + r5.hashCode());
        float r0 = r5.a(r4);
        if (r0 != r6) goto L11;
        com.obric.common.oea.foundation.a.b.f7661a.b("SpringAnimUtils", "springTo, no need! currentValue: " + r0 + ", targetValue: " + r6 + ", this: " + r4);
        e r13 = (e) ZeusTransformUtils.preCheckCast(f7830b.get(r3), e.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L8;
        r13.b();
    L8:
        if (r12 == null) goto L10;
        r12.a(null, true, r6, 0.0f);
    L10:
        return null;
    L11:
        Map<String, e> r1 = f7830b;
        e r2 = r1.get(r3);
        if (r2 != null) goto L14;
        e r14 = new e(r4, r5);
        f r15 = new f(r6);
        r15.b(r7);
        r15.a(r8);
        r2 = r14.a(r15);
        Intrinsics.checkNotNullExpressionValue(r2, "springAnim.setSpring(springForce)");
        r1.put(r3, r2);
    L14:
        e r16 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        if (r16.c() == true) goto L20;
        if (r11 == null) goto L18;
        r16.a(r11);
    L18:
        if (r12 == null) goto L20;
        r16.a(r12);
    L20:
        r16.b(r6);
        return r16;
    }

    public final String a(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$animKey");
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        return r2 + '_' + r1.hashCode();
    }

    public final <K> void a(K r3, com.obric.common.oea.foundation.animation.c.c<K> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$cancelSpring");
        Intrinsics.checkNotNullParameter(r4, "property");
        String r2 = a(r3, "SPRING_ANIM_" + r4.hashCode());
        Map<String, e> r5 = f7830b;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5.get(r2), e.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
        r6.b();
        r5.remove(r2);
        return;
    }
}
