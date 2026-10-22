package com.bytedance.awemeopen.servicesapi.ui.host.ext;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/ui/host/ext/UIComponentExtensionType;", "", "PHOTO_DETAIL_LONG_PRESS", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum UIComponentExtensionType extends Enum<UIComponentExtensionType> {
    public static final UIComponentExtensionType PHOTO_DETAIL_LONG_PRESS = null;
    public static final /* synthetic */ UIComponentExtensionType[] a = null;

    public static UIComponentExtensionType valueOf(String r1) {
        return (UIComponentExtensionType) a.a(UIComponentExtensionType.class, r1);
    }

    public static UIComponentExtensionType[] values() {
        return (UIComponentExtensionType[]) a.clone();
    }

    static {
        UIComponentExtensionType r0 = new UIComponentExtensionType();
        PHOTO_DETAIL_LONG_PRESS = r0;
        a = new UIComponentExtensionType[]{r0};
    }

    public UIComponentExtensionType() {
        super("PHOTO_DETAIL_LONG_PRESS", 0);
    }
}
