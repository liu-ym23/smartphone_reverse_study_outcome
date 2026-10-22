package ce;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    String A();

    TraceTimeMetric d();

    String getEcomNotice();

    long getMessageId2();

    int getMsgType();

    List<String> getSecTargetUid();

    List<String> getTargetUid();

    UpdatedCartInfo w();
}
