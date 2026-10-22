package pub;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKProtocol {
    boolean F(MmRecordingSource r1);

    PolarisFileWrapper r0(String r1, String r2);
}
