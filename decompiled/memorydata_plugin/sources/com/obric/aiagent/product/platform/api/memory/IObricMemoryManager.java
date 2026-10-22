package com.obric.aiagent.product.platform.api.memory;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\rH&J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\rH&J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020#H&J\b\u0010$\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006%"}, d2 = {"Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "", "KEY_TEXT", "", "getKEY_TEXT", "()Ljava/lang/String;", "KEY_IMAGE_URI", "getKEY_IMAGE_URI", "KEY_PACKAGE", "getKEY_PACKAGE", "KEY_TIMESTAMP", "getKEY_TIMESTAMP", "doMemoryActionIfEnabled", "", "from", "", "extras", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "doMemoryAction", "registerMemoryActionCallback", "callback", "Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryActionCallback;", "unregisterMemoryActionCallback", "reportSystemEvent", "event", "state", "registerSystemEventCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "unregisterSystemEventCallback", "doScenePerceptionAction", "type", "reportScenePerceptionEvent", "registerScenePerceptionCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "unregisterScenePerceptionCallback", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricMemoryManager {
    void doMemoryAction(int r1, Bundle r2);

    void doMemoryActionIfEnabled(int r1, Bundle r2, Context r3);

    void doScenePerceptionAction(int r1, Bundle r2);

    String getKEY_IMAGE_URI();

    String getKEY_PACKAGE();

    String getKEY_TEXT();

    String getKEY_TIMESTAMP();

    void registerMemoryActionCallback(ObricMemoryActionCallback r1);

    void registerScenePerceptionCallback(ObricScenePerceptionCallback r1);

    void registerSystemEventCallback(ObricSystemEventCallback r1);

    void reportScenePerceptionEvent(int r1, Bundle r2);

    void reportSystemEvent(int r1, int r2, Bundle r3);

    void unregisterMemoryActionCallback();

    void unregisterScenePerceptionCallback();

    void unregisterSystemEventCallback();
}
