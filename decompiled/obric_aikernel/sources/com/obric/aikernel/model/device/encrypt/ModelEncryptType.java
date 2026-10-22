package com.obric.aikernel.model.device.encrypt;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelEncryptType extends Enum<ModelEncryptType> {
    private static final /* synthetic */ ModelEncryptType[] $VALUES = null;
    public static final a Companion = null;
    public static final ModelEncryptType Full = null;
    public static final ModelEncryptType No = null;
    public static final ModelEncryptType Part = null;
    private final String type;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final ModelEncryptType b(String r10) {
            int r11 = 0;
            if (r10 != null) goto L5;
        L8:
            boolean r12 = true;
        L9:
            if (r12 == true) goto L17;
            ModelEncryptType[] r13 = ModelEncryptType.values();
            int r14 = r13.length;
        L11:
            if (r11 >= r14) goto L17;
            ModelEncryptType r15 = r13[r11];
            if (StringsKt.equals(r15.getType(), r10, true) == true) goto L14;
            r11 = r11 + 1;
            goto L11
        L14:
            return r15;
        L17:
            return ModelEncryptType.No;
        L5:
            if (r10.length() == 0) goto L8;
            r12 = false;
            goto L9
        }

        public final boolean a(String r10) {
            if (b(r10) == ModelEncryptType.No) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static final /* synthetic */ ModelEncryptType[] $values() {
        return new ModelEncryptType[]{No, Part, Full};
    }

    static {
        No = new ModelEncryptType("No", 0, "none");
        Part = new ModelEncryptType("Part", 1, "partial");
        Full = new ModelEncryptType("Full", 2, "full");
        $VALUES = $values();
        Companion = new a(null);
    }

    private ModelEncryptType(String r10, int r11, String r12) {
        super(r10, r11);
        this.type = r12;
    }

    public static ModelEncryptType valueOf(String r10) {
        return (ModelEncryptType) Enum.valueOf(ModelEncryptType.class, r10);
    }

    public static ModelEncryptType[] values() {
        return (ModelEncryptType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
