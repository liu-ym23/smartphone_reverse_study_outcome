package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", "Common", "Special", "Function", "More", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputFunctionType extends Enum<InputFunctionType> {
    public static final InputFunctionType Common = null;
    public static final InputFunctionType Function = null;
    public static final InputFunctionType More = null;
    public static final InputFunctionType Special = null;
    public static final /* synthetic */ InputFunctionType[] a = null;
    private final int type;

    static {
        InputFunctionType r2 = new InputFunctionType("Common", 0, 1);
        Common = r2;
        InputFunctionType r3 = new InputFunctionType("Special", 1, 2);
        Special = r3;
        InputFunctionType r4 = new InputFunctionType("Function", 2, 3);
        Function = r4;
        InputFunctionType r5 = new InputFunctionType("More", 3, 4);
        More = r5;
        a = new InputFunctionType[]{r2, r3, r4, r5};
    }

    public static InputFunctionType valueOf(String r1) {
        return (InputFunctionType) r27.a.a(InputFunctionType.class, r1);
    }

    public static InputFunctionType[] values() {
        return (InputFunctionType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public InputFunctionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
