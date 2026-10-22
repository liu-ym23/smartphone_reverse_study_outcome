package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/AccessLayerStringField;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AccessLayerStringField extends Enum<AccessLayerStringField> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AccessLayerStringField f7206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AccessLayerStringField f7207b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AccessLayerStringField f7208c = null;
    public static final AccessLayerStringField d = null;
    public static final /* synthetic */ AccessLayerStringField[] e = null;

    static {
        AccessLayerStringField r5 = new AccessLayerStringField("CoreViewType", 0);
        f7206a = r5;
        AccessLayerStringField r10 = new AccessLayerStringField("Biz", 1);
        f7207b = r10;
        AccessLayerStringField r11 = new AccessLayerStringField("ClientComponent", 2);
        f7208c = r11;
        AccessLayerStringField r12 = new AccessLayerStringField("Schema", 3);
        AccessLayerStringField r13 = new AccessLayerStringField("TemplateResType", 4);
        AccessLayerStringField r14 = new AccessLayerStringField("ViewType", 5);
        AccessLayerStringField r15 = new AccessLayerStringField("ContainerType", 6);
        AccessLayerStringField r16 = new AccessLayerStringField("SdkVersion", 7);
        d = r16;
        e = new AccessLayerStringField[]{r5, r10, r11, r12, r13, r14, r15, r16, new AccessLayerStringField("NativePage", 8), new AccessLayerStringField("LynxVersion", 9), new AccessLayerStringField("WebViewType", 10), new AccessLayerStringField("WebEngineVersion", 11), new AccessLayerStringField("Url", 12), new AccessLayerStringField("GeckoId", 13)};
    }

    public AccessLayerStringField(String r5, int r10) {
        super(r5, r10);
    }

    public static AccessLayerStringField valueOf(String r5) {
        return (AccessLayerStringField) Enum.valueOf(AccessLayerStringField.class, r5);
    }

    public static AccessLayerStringField[] values() {
        return (AccessLayerStringField[]) e.clone();
    }
}
