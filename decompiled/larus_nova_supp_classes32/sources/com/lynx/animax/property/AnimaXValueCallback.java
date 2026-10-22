package com.lynx.animax.property;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface AnimaXValueCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXValueCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getValueInternal(AnimaXValueCallback r9, float r10, float r11, AnimaXValueParam r12, AnimaXValueParam r13, float r14, float r15, float r16) {
            return r9.a(new a(r10, r11, r12, r13, r14, r15, r16));
        }
    }

    AnimaXValueParam a(a r1);

    Object getValueInternal(float r1, float r2, AnimaXValueParam r3, AnimaXValueParam r4, float r5, float r6, float r7);
}
