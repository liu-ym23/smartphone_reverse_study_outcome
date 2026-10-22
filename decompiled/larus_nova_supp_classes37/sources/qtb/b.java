package qtb;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b extends IOfficeSDKProtocol {
    boolean K(String r1);

    void M(com.ss.android.lark.flow.feed.sidebar.human.c r1);

    Object N1(byte[] r1, Continuation<? super byte[]> r2);

    boolean P0();

    boolean X1(String r1, boolean r2, long r3);

    boolean Y1();

    void a0(com.ss.android.lark.flow.feed.sidebar.human.c r1);

    Object g0(byte[] r1, Continuation<? super byte[]> r2);

    boolean getIsImFeatureOpenedByHostManual();

    Object z1(byte[] r1, Continuation<? super Unit> r2);
}
