package a2b;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface f {
    void Fa(PullUrlPreviewRequest r1);

    void ba(b r1, IGetDataCallback<b> r2);

    void getUrlInlineFromContent(String r1, IGetDataCallback<UrlInlinePreviewEntity> r2);

    void lc(List<String> r1, Map<String, ? extends Map<String, UrlCardPreviewEntity>> r2);

    void r4(List<String> r1, List<String> r2, SyncDataStrategy r3, UrlPreViewEntries.UrlPreViewSourceType r4, List<Long> r5, UIGetDataCallback<UrlPreviewResponse> r6);
}
