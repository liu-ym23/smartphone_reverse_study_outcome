package com.bytedance.android.ec.common.api.jump.model;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends com.bytedance.android.ec.common.api.jump.model.a {
    public static final /* synthetic */ int c = 0;
    public final ECUIPromotion a;
    public final g b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a {
        public final ECUIPromotion a;
        public final g b;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(e.class)) == false) goto L7;
            return new e(this.a, this.b);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r10).newInstance();
        }

        public b(ECUIPromotion r10, g r11) {
            Intrinsics.checkNotNullParameter(r10, "promotion");
            Intrinsics.checkNotNullParameter(r11, "baseParams");
            this.a = r10;
            this.b = r11;
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L10;
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ECUIPromotion r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        g r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "OldPromotionParams(promotion=" + this.a + ", baseParams=" + this.b + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.a
    public final Map<String, String> chainParams() {
        StandardEventTrack r0 = this.a.getStandardEventTrack();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChainParamsMap();
    }

    public e(ECUIPromotion r10, g r11) {
        Intrinsics.checkNotNullParameter(r10, "promotion");
        Intrinsics.checkNotNullParameter(r11, "baseParams");
        this.a = r10;
        this.b = r11;
    }
}
