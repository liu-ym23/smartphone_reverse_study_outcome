package com.obric.capabilitykit.entity;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/ResultCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onResult", "", "errorCode", "", DTraitConstant.ERROR, "", "result", "(ILjava/lang/String;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ResultCallback<T> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onResult$default(ResultCallback r2, int r3, String r4, Object r5, int r6, Object r7) {
            ResultCallback r8 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r2, ResultCallback.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.onResult(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void onResult(int r1, String r2, T r3);
}
