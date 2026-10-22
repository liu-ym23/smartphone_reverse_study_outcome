package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "Ljava/io/Serializable;", AppbrandHostConstants.Schema_Meta.NAME, "", "domainPolicy", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/DomainPolicy;", "isFgOpen", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/DomainPolicy;Z)V", "getName", "()Ljava/lang/String;", "getDomainPolicy", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/DomainPolicy;", "()Z", "toString", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class BizFlow implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "Passport_BizFlow";
    private final DomainPolicy domainPolicy;
    private final boolean isFgOpen;
    private final String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String toString() {
        return this.name + ", domainPolicy: " + this.domainPolicy;
    }

    public final DomainPolicy getDomainPolicy() {
        return this.domainPolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isFgOpen() {
        return this.isFgOpen;
    }

    public BizFlow(String r2, DomainPolicy r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r3, "domainPolicy");
        this.name = r2;
        this.domainPolicy = r3;
        this.isFgOpen = r4;
        Log.i(TAG, "create bizFlow: " + this);
    }
}
