package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/Code;", "", "", "value", "S", "getValue", "()S", "None", "NotReady", "Downloaded", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Code extends Enum<Code> {
    public static final Code Downloaded = null;
    public static final Code None = null;
    public static final Code NotReady = null;
    public static final /* synthetic */ Code[] a = null;
    private final short value;

    static {
        Code r1 = new Code("None", 0, 0);
        None = r1;
        Code r2 = new Code("NotReady", 1, 1);
        NotReady = r2;
        Code r3 = new Code("Downloaded", 2, 2);
        Downloaded = r3;
        a = new Code[]{r1, r2, r3};
    }

    public static Code valueOf(String r1) {
        return (Code) r27.a.a(Code.class, r1);
    }

    public static Code[] values() {
        return (Code[]) a.clone();
    }

    public final short getValue() {
        return this.value;
    }

    public Code(String r1, int r2, short r3) {
        super(r1, r2);
        this.value = r3;
    }
}
