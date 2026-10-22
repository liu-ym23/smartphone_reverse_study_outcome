package com.ivy.ivykit.api.bridge;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IBridgeService;", "", "Lcom/ivy/ivykit/api/bridge/a;", "bridgeConfig", "", "init", "(Lcom/ivy/ivykit/api/bridge/a;)V", "Ljava/lang/Class;", "Lml/a;", "clazz", "registerIvyMethod", "(Ljava/lang/Class;)V", ExifInterface.GPS_DIRECTION_TRUE, "registerMethod", "depend", "registerHostDepend", "(Ljava/lang/Object;)V", "Companion", "com/ivy/ivykit/api/bridge/c", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBridgeService {
    public static final c Companion = null;

    static {
        Companion = c.f9472a;
    }

    void init(a r5);

    <T> void registerHostDepend(T r5);

    void registerIvyMethod(Class<? extends ml.a> r5);

    <T> void registerMethod(Class<? extends T> r5);
}
