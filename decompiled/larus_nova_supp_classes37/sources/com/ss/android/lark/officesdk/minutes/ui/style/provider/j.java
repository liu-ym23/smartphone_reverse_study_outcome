package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import com.ss.android.lark.officesdk.minutes.ui.record.MmDoubaoEndWindowActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmDoubaoRecordingActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j extends a {
    public final String a;
    public final String b;

    public j() {
        this.a = MmDoubaoRecordingActivity.class.getName();
        this.b = MmDoubaoEndWindowActivity.class.getName();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.a, com.ss.android.lark.officesdk.minutes.ui.style.contract.b
    public final String a() {
        return this.b;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.a, com.ss.android.lark.officesdk.minutes.ui.style.contract.b
    public final String b() {
        return this.a;
    }
}
