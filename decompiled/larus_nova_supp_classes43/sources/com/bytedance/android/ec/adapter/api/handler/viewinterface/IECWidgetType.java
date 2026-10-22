package com.bytedance.android.ec.adapter.api.handler.viewinterface;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IECWidgetType {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/handler/viewinterface/IECWidgetType$ECExternalWidgetType;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "UNKNOWN", "ECOMMERCE_SIZE_COMPONENTS", "ECOMMERCE_PROPERTY_COMPONENTS", "ECOMMERCE_POP_CARD", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ECExternalWidgetType extends Enum<ECExternalWidgetType> {
        public static final ECExternalWidgetType ECOMMERCE_POP_CARD = null;
        public static final ECExternalWidgetType ECOMMERCE_PROPERTY_COMPONENTS = null;
        public static final ECExternalWidgetType ECOMMERCE_SIZE_COMPONENTS = null;
        public static final ECExternalWidgetType UNKNOWN = null;
        public static final /* synthetic */ ECExternalWidgetType[] a = null;
        private final int value;

        static {
            ECExternalWidgetType r1 = new ECExternalWidgetType("UNKNOWN", 0, 0);
            UNKNOWN = r1;
            ECExternalWidgetType r10 = new ECExternalWidgetType("ECOMMERCE_SIZE_COMPONENTS", 1, 1);
            ECOMMERCE_SIZE_COMPONENTS = r10;
            ECExternalWidgetType r11 = new ECExternalWidgetType("ECOMMERCE_PROPERTY_COMPONENTS", 2, 2);
            ECOMMERCE_PROPERTY_COMPONENTS = r11;
            ECExternalWidgetType r12 = new ECExternalWidgetType("ECOMMERCE_POP_CARD", 3, 101);
            ECOMMERCE_POP_CARD = r12;
            a = new ECExternalWidgetType[]{r1, r10, r11, r12};
        }

        public static ECExternalWidgetType valueOf(String r1) {
            return (ECExternalWidgetType) r27.a.a(ECExternalWidgetType.class, r1);
        }

        public static ECExternalWidgetType[] values() {
            return (ECExternalWidgetType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ECExternalWidgetType(String r1, int r10, int r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    ECExternalWidgetType j();
}
