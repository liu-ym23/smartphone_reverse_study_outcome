package com.obric.memorydata.middleware.api.app;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/IUserStateManager;", "Lcom/bytedance/news/common/service/manager/IService;", "requestAgreePrivacyAndLogin", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "", "requestAgreePrivacy", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IUserStateManager extends IService {
    void requestAgreePrivacy(Context r1, Function1<? super Boolean, Unit> r2);

    void requestAgreePrivacyAndLogin(Context r1, Function1<? super Boolean, Unit> r2);
}
