package eub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKCapacity {
    z0 O9(String r1);

    Object c4(f r1, Continuation<? super String> r2);

    Object jb(h r1, Continuation<? super String> r2);

    void setContext(Context r1);
}
