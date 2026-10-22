package com.bytedance.android.live.base.model.message;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/message/d;", "", "", "Lcom/bytedance/android/live/base/model/message/f;", "displayItems", "Ljava/util/List;", "b", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/message/m6;", "schemaInfo", "Lcom/bytedance/android/live/base/model/message/m6;", "c", "()Lcom/bytedance/android/live/base/model/message/m6;", "e", "(Lcom/bytedance/android/live/base/model/message/m6;)V", "Lcom/bytedance/android/live/base/model/message/e;", "comboInfo", "Lcom/bytedance/android/live/base/model/message/e;", "a", "()Lcom/bytedance/android/live/base/model/message/e;", "setComboInfo", "(Lcom/bytedance/android/live/base/model/message/e;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("combo_info")
    protected e comboInfo;

    @SerializedName("display_items")
    protected List<f> displayItems;

    @SerializedName("schema_info")
    protected m6 schemaInfo;

    public d() {
    }

    public d(am3.g r5) {
        this.displayItems = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.displayItems.add(new f(r5));
        goto L3
    L8:
        if (r2 != 10) goto L10;
        this.schemaInfo = new m6(r5);
        goto L3
    L10:
        if (r2 != 11) goto L11;
        this.comboInfo = new e(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final e a() {
        return this.comboInfo;
    }

    public final List<f> b() {
        return this.displayItems;
    }

    public final m6 c() {
        return this.schemaInfo;
    }

    public final void d(List<f> r1) {
        this.displayItems = r1;
    }

    public final void e(m6 r1) {
        this.schemaInfo = r1;
    }
}
