package com.obric.memorydata.personalcontext.api;

import android.net.Uri;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bH&J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEntityVideoExtractHelper;", "Lcom/bytedance/news/common/service/manager/IService;", "extractFrame", "Landroid/net/Uri;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "video", "timestampMs", "", "calculateVideoClip", "", "entityJson", "intervalParam", "deleteTempPicPath", "", "uri", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEntityVideoExtractHelper extends IService {
    List<Long> calculateVideoClip(String r1, Uri r2, long r3);

    List<Long> calculateVideoClip(String r1, String r2, long r3);

    void deleteTempPicPath(Uri r1);

    Uri extractFrame(String r1, Uri r2, long r3);
}
