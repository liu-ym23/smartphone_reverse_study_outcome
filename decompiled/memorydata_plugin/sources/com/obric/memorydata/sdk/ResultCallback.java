package com.obric.memorydata.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/sdk/ResultCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onResult", "", "errorCode", "", DTraitConstant.ERROR, "", "result", "(ILjava/lang/String;Ljava/lang/Object;)V", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ResultCallback<T> {
    void onResult(int r1, String r2, T r3);
}
