package a2b;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityRequest;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityResponse;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsRequest;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsResponse;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewRequest;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewResponse;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.PreviewService$getUrlPreViewEntityList$2;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface e {
    Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>> a(GetMessagePreviewsRequest.Builder r1, Function1<? super GetMessagePreviewsResponse, ? extends Pair<? extends Map<String, ? extends Map<String, UrlCardPreviewEntity>>, ? extends LinkedHashMap<String, MessageLink>>> r2, Function1<? super ErrorResult, Unit> r3);

    void b(GenerateUrlPreviewEntityRequest.Builder r1, Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r2, IGetDataCallback<UrlInlinePreviewEntity> r3);

    void c(HideMessageUrlPreviewRequest.Builder r1, Function1<? super HideMessageUrlPreviewResponse, ? extends b> r2, IGetDataCallback<b> r3);

    void d(MGetUrlPreviewRequest.Builder r1, com.ss.android.lark.sdk.h r2, PreviewService$getUrlPreViewEntityList$2 r3);
}
