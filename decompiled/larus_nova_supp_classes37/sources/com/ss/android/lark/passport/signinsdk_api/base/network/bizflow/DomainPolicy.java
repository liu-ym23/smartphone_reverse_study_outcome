package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/DomainPolicy;", "Ljava/io/Serializable;", "<init>", "()V", "toString", "", "getDomain", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class DomainPolicy implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "Passport_DomainPolicy";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public abstract String getDomain();

    public final String toString() {
        return getClass().getSimpleName() + ", domain: " + getDomain();
    }

    public DomainPolicy() {
        Log.i(TAG, "create Domain Policy: " + this);
    }
}
