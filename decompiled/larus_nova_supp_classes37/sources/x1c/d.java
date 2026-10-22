package x1c;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface d extends IOfficeSDKProtocol {
    void A0(Context r1, String r2);

    Object C(String r1, Continuation<? super a> r2);

    Object n1(String r1, Continuation<? super b> r2);

    b y1();
}
