package com.bytedance.android.anniex.ability.service;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/AccountAuthType;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Douyin", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AccountAuthType extends Enum<AccountAuthType> {
    public static final AccountAuthType Douyin = null;
    public static final /* synthetic */ AccountAuthType[] a = null;
    private final int value;

    public static AccountAuthType valueOf(String r1) {
        return (AccountAuthType) r27.a.a(AccountAuthType.class, r1);
    }

    public static AccountAuthType[] values() {
        return (AccountAuthType[]) a.clone();
    }

    static {
        AccountAuthType r0 = new AccountAuthType();
        Douyin = r0;
        a = new AccountAuthType[]{r0};
    }

    public AccountAuthType() {
        super("Douyin", 0);
        this.value = 11;
    }

    public final int getValue() {
        return this.value;
    }
}
