package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidateResultCode;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ValidateResultCode extends Enum<ValidateResultCode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ValidateResultCode f7232b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ValidateResultCode f7233c = null;
    public static final ValidateResultCode d = null;
    public static final /* synthetic */ ValidateResultCode[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7234a;

    static {
        ValidateResultCode r5 = new ValidateResultCode("Success", 0, 1);
        f7232b = r5;
        ValidateResultCode r10 = new ValidateResultCode("Fail", 1, -1);
        f7233c = r10;
        ValidateResultCode r11 = new ValidateResultCode("Invalid_input", 2, -3);
        d = r11;
        e = new ValidateResultCode[]{r5, r10, r11};
    }

    public ValidateResultCode(String r5, int r10, long r11) {
        super(r5, r10);
        this.f7234a = r11;
    }

    public static ValidateResultCode valueOf(String r5) {
        return (ValidateResultCode) Enum.valueOf(ValidateResultCode.class, r5);
    }

    public static ValidateResultCode[] values() {
        return (ValidateResultCode[]) e.clone();
    }
}
