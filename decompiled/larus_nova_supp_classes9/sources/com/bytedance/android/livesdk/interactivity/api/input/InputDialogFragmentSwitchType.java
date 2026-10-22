package com.bytedance.android.livesdk.interactivity.api.input;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/InputDialogFragmentSwitchType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "NONE", "SLIDE_RIGHT", "FADE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputDialogFragmentSwitchType extends Enum<InputDialogFragmentSwitchType> {
    public static final InputDialogFragmentSwitchType FADE = null;
    public static final InputDialogFragmentSwitchType NONE = null;
    public static final InputDialogFragmentSwitchType SLIDE_RIGHT = null;
    public static final /* synthetic */ InputDialogFragmentSwitchType[] a = null;
    private final String typeName;

    static {
        InputDialogFragmentSwitchType r1 = new InputDialogFragmentSwitchType("NONE", 0, "none");
        NONE = r1;
        InputDialogFragmentSwitchType r2 = new InputDialogFragmentSwitchType("SLIDE_RIGHT", 1, "slide_right");
        SLIDE_RIGHT = r2;
        InputDialogFragmentSwitchType r3 = new InputDialogFragmentSwitchType("FADE", 2, "fade");
        FADE = r3;
        a = new InputDialogFragmentSwitchType[]{r1, r2, r3};
    }

    public static InputDialogFragmentSwitchType valueOf(String r1) {
        return (InputDialogFragmentSwitchType) r27.a.a(InputDialogFragmentSwitchType.class, r1);
    }

    public static InputDialogFragmentSwitchType[] values() {
        return (InputDialogFragmentSwitchType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public InputDialogFragmentSwitchType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
