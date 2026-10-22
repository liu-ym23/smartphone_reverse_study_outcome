package com.bytedance.android.ec.common.api.jump.model;

import com.bytedance.android.ec.model.response.StandardEventTrack;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends com.bytedance.android.ec.common.api.jump.model.a implements d {
    public final ql.a a;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a {
        public final ql.a a;

        public a(ql.a r10) {
            Intrinsics.checkNotNullParameter(r10, "promotion");
            this.a = r10;
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(g.class)) == false) goto L7;
            return new g(this.a);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r10).newInstance();
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((g) r10).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ql.a r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "PromotionParams(promotion=" + this.a + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.a
    public final Map<String, String> chainParams() {
        StandardEventTrack r0 = this.a.getStandardEventTrack();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChainParamsMap();
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r0 = new JSONObject();
        Map r1 = this.a.getExtraEventParams();
        String r10 = null;
        if (r1 == null) goto L5;
        String r11 = (String) r1.get("elastic_title_types");
    L6:
        r0.put("elastic_title_types", r11);
        Map r12 = this.a.getExtraEventParams();
        if (r12 == null) goto L9;
        r10 = (String) r12.get("sellpoint_bp");
    L9:
        r0.put("sellpoint_bp", r10);
        return r0;
    L5:
        r11 = null;
        goto L6
    }

    public g(ql.a r10) {
        Intrinsics.checkNotNullParameter(r10, "promotion");
        this.a = r10;
    }
}
