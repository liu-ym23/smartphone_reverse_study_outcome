package com.bytedance.android.livesdk.interactivity.interactive.dialog.framework;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "NONE", "EMPTY", "SHADOW", "CONTENT", "PUBLISH", "CONTROL_PORTRAIT", "KEYBOARD", "EMOJI", "PAID_LIVE_PACKAGE", "BOTTOM_TIP", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VSInputSectionType extends Enum<VSInputSectionType> {
    public static final VSInputSectionType BOTTOM_TIP = null;
    public static final VSInputSectionType CONTENT = null;
    public static final VSInputSectionType CONTROL_PORTRAIT = null;
    public static final VSInputSectionType EMOJI = null;
    public static final VSInputSectionType EMPTY = null;
    public static final VSInputSectionType KEYBOARD = null;
    public static final VSInputSectionType NONE = null;
    public static final VSInputSectionType PAID_LIVE_PACKAGE = null;
    public static final VSInputSectionType PUBLISH = null;
    public static final VSInputSectionType SHADOW = null;
    public static final /* synthetic */ VSInputSectionType[] a = null;
    private final String typeName;

    public static VSInputSectionType valueOf(String r1) {
        return (VSInputSectionType) a.a(VSInputSectionType.class, r1);
    }

    public static VSInputSectionType[] values() {
        return (VSInputSectionType[]) a.clone();
    }

    static {
        VSInputSectionType r1 = new VSInputSectionType("NONE", 0, "none");
        NONE = r1;
        VSInputSectionType r2 = new VSInputSectionType("EMPTY", 1, "empty");
        EMPTY = r2;
        VSInputSectionType r3 = new VSInputSectionType("SHADOW", 2, "shadow");
        SHADOW = r3;
        VSInputSectionType r4 = new VSInputSectionType("CONTENT", 3, "content");
        CONTENT = r4;
        VSInputSectionType r5 = new VSInputSectionType("PUBLISH", 4, "publish");
        PUBLISH = r5;
        VSInputSectionType r6 = new VSInputSectionType("CONTROL_PORTRAIT", 5, "control_portrait");
        CONTROL_PORTRAIT = r6;
        VSInputSectionType r7 = new VSInputSectionType("KEYBOARD", 6, "keyboard");
        KEYBOARD = r7;
        VSInputSectionType r8 = new VSInputSectionType("EMOJI", 7, "emoji");
        EMOJI = r8;
        VSInputSectionType r9 = new VSInputSectionType("PAID_LIVE_PACKAGE", 8, "paid_live_package");
        PAID_LIVE_PACKAGE = r9;
        VSInputSectionType r10 = new VSInputSectionType("BOTTOM_TIP", 9, "bottom_tip");
        BOTTOM_TIP = r10;
        a = new VSInputSectionType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public VSInputSectionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
