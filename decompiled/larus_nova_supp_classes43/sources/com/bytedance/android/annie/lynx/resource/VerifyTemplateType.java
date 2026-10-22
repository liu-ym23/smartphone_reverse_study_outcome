package com.bytedance.android.annie.lynx.resource;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/lynx/resource/VerifyTemplateType;", "", "", "TYPE", "Ljava/lang/String;", "getTYPE", "()Ljava/lang/String;", "EMPTY_FILE", "BROKEN_FILE", "VERIFY_SUCCEED", "annie-lynx_release"}, k = 1, mv = {1, 4, 3})
public final enum VerifyTemplateType extends Enum<VerifyTemplateType> {
    public static final VerifyTemplateType BROKEN_FILE = null;
    public static final VerifyTemplateType EMPTY_FILE = null;
    public static final VerifyTemplateType VERIFY_SUCCEED = null;
    public static final /* synthetic */ VerifyTemplateType[] a = null;
    private final String TYPE;

    public static VerifyTemplateType valueOf(String r1) {
        return (VerifyTemplateType) r27.a.a(VerifyTemplateType.class, r1);
    }

    public static VerifyTemplateType[] values() {
        return (VerifyTemplateType[]) a.clone();
    }

    static {
        VerifyTemplateType r0 = new VerifyTemplateType("EMPTY_FILE", 0, "Empty file");
        EMPTY_FILE = r0;
        VerifyTemplateType r1 = new VerifyTemplateType("BROKEN_FILE", 1, "Broken file");
        BROKEN_FILE = r1;
        VerifyTemplateType r10 = new VerifyTemplateType("VERIFY_SUCCEED", 2, "Verify succeed");
        VERIFY_SUCCEED = r10;
        a = new VerifyTemplateType[]{r0, r1, r10};
    }

    public final String getTYPE() {
        return this.TYPE;
    }

    public VerifyTemplateType(String r1, int r10, String r11) {
        super(r1, r10);
        this.TYPE = r11;
    }
}
