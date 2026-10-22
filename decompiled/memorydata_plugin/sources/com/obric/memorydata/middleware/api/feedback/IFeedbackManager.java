package com.obric.memorydata.middleware.api.feedback;

import android.os.Bundle;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/feedback/IFeedbackManager;", "Lcom/bytedance/news/common/service/manager/IService;", "triggerFeedback", "Landroid/os/Bundle;", "problemDesc", "", "customFilePathList", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IFeedbackManager extends IService {
    Bundle triggerFeedback(String r1, List<String> r2);
}
