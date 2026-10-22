package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", "context", "Landroid/content/Context;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricActivityTaskManager {
    boolean finishAndRemoveAllTask(Context r1);

    boolean registerActivitySwitchListener(ObricActivitySwitchListener r1);

    boolean registerAppSwitchListener(ObricAppSwitchListener r1);

    boolean registerFocusListener(ObricFocusListener r1);

    boolean registerSystemAnimationListener(ObricSystemAnimationListener r1);

    boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1);

    boolean unregisterAppSwitchListener(ObricAppSwitchListener r1);

    boolean unregisterFocusListener(ObricFocusListener r1);

    boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1);
}
