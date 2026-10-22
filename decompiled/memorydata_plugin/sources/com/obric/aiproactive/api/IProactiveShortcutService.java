package com.obric.aiproactive.api;

import android.app.Activity;
import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/api/IProactiveShortcutService;", "Lcom/bytedance/news/common/service/manager/IService;", "initializeDefaultOnHome", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryState", "Lcom/obric/aiproactive/api/ProactiveShortcutState;", "context", "Landroid/content/Context;", "requestPin", "Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "disableByUser", "isResidualOnLauncher", "", "registerResultListener", "listener", "Lcom/obric/aiproactive/api/ProactiveShortcutResultListener;", "unregisterResultListener", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IProactiveShortcutService extends IService {
    ProactiveShortcutState disableByUser(Context r1);

    Object initializeDefaultOnHome(Activity r1, Continuation<? super Unit> r2);

    boolean isResidualOnLauncher(Context r1);

    ProactiveShortcutState queryState(Context r1);

    void registerResultListener(af r1);

    ProactiveShortcutRequestResult requestPin(Activity r1);

    void unregisterResultListener(af r1);
}
