package qpc;

import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface e {
    void addPushPushResourceListener(c r1);

    void addPushResourceDownloadProgressListener(b r1);

    void addPushResourceUploadProgressListener(d r1);

    byte[] decryptResource(String r1);

    void downloadResource(String r1, String r2, String r3);

    a getImageService();

    String getResUrlByResKey(String r1, String r2, int r3, int r4);

    Map<String, Resource> getResources(List<ResourceRequestBaseSet> r1);

    void getResources(List<ResourceRequestBaseSet> r1, int r2, IGetDataCallback<Map<String, Resource>> r3);

    void removePushResourceDownloadProgressListener(b r1);

    void removePushResourceUploadProgressListener(d r1);

    Map<String, Resource> synGetResources(List<ResourceRequestBaseSet> r1);

    void triggerDataClean(Integer r1, Integer r2, TriggerDataCleanRequest.CleanType r3, IGetDataCallback<TriggerDataCleanResponse> r4);
}
