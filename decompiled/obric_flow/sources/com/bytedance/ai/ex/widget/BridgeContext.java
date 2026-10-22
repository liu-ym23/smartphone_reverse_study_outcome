package com.bytedance.ai.ex.widget;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.bridge.context.RefType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&J#\u0010\f\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/ex/widget/BridgeContext;", "", "registerObject", "", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "t", "refType", "Lcom/bytedance/ai/bridge/context/RefType;", "(Ljava/lang/Class;Ljava/lang/Object;Lcom/bytedance/ai/bridge/context/RefType;)V", "unregisterObject", "getObject", "(Ljava/lang/Class;)Ljava/lang/Object;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BridgeContext {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void registerObject$default(BridgeContext r5, Class r10, Object r11, RefType r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = RefType.f1803a;
        L6:
            r5.registerObject(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerObject");
        }
    }

    <T> T getObject(Class<T> r5);

    <T> void registerObject(Class<T> r5, T r10, RefType r11);

    <T> void unregisterObject(Class<T> r5);
}
