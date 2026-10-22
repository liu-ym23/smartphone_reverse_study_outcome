package com.bytedance.android.livesdk.interactivity.api.utils;

import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MessageStyleFormatter {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/utils/MessageStyleFormatter$StyleType;", BuildConfig.FLAVOR, "CHAT", "GIFT", "INTERACT", "SYSTEM", "DEFAULT", "ENTER", "RED_BOX", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StyleType extends Enum<StyleType> {
        public static final StyleType CHAT = null;
        public static final StyleType DEFAULT = null;
        public static final StyleType ENTER = null;
        public static final StyleType GIFT = null;
        public static final StyleType INTERACT = null;
        public static final StyleType RED_BOX = null;
        public static final StyleType SYSTEM = null;
        public static final /* synthetic */ StyleType[] a = null;

        static {
            StyleType r1 = new StyleType("CHAT", 0);
            CHAT = r1;
            StyleType r2 = new StyleType("GIFT", 1);
            GIFT = r2;
            StyleType r3 = new StyleType("INTERACT", 2);
            INTERACT = r3;
            StyleType r4 = new StyleType("SYSTEM", 3);
            SYSTEM = r4;
            StyleType r5 = new StyleType("DEFAULT", 4);
            DEFAULT = r5;
            StyleType r6 = new StyleType("ENTER", 5);
            ENTER = r6;
            StyleType r7 = new StyleType("RED_BOX", 6);
            RED_BOX = r7;
            a = new StyleType[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static StyleType valueOf(String r1) {
            return (StyleType) r27.a.a(StyleType.class, r1);
        }

        public static StyleType[] values() {
            return (StyleType[]) a.clone();
        }

        public StyleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final HashMap<StyleType, b> a;

        public a() {
            throw null;
        }

        public a(HashMap r2) {
            Intrinsics.checkNotNullParameter(r2, "colorMap");
            this.a = r2;
        }
    }

    public static final class b {
        public final int a;
        public final int b;

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = LazyKt.lazy(MessageStyleFormatter$userWarmColorMap$2.INSTANCE);
        b = LazyKt.lazy(MessageStyleFormatter$anchorWarmColorMap$2.INSTANCE);
        c = LazyKt.lazy(MessageStyleFormatter$userExperiment2$2.INSTANCE);
        d = LazyKt.lazy(MessageStyleFormatter$anchorExperiment3$2.INSTANCE);
    }

    @JvmStatic
    public static final b a(StyleType r0, boolean r1) {
        if (r1 == false) goto L4;
        a r2 = (a) d.getValue();
    L5:
        HashMap<StyleType, b> r3 = r2.a;
        b r4 = r3.get(r0);
        if (r4 != null) goto L9;
        b r5 = r3.get(StyleType.DEFAULT);
        Intrinsics.checkNotNull(r5);
        return r5;
    L9:
        return r4;
    L4:
        r2 = (a) c.getValue();
        goto L5
    }
}
