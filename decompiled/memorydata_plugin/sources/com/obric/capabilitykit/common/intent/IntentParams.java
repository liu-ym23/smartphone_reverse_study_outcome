package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "getSubActionValue", "", "isParamsCompleted", "", "mergeParams", TrackerImpl.PARAMS, "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IntentParams extends Parcelable {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static String getSubActionValue(IntentParams r2) {
            IntentParams r3 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r2, IntentParams.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static boolean isParamsCompleted(IntentParams r2) {
            IntentParams r3 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r2, IntentParams.class, "com.obric.memorydata.plugin");
            return true;
        }

        public static IntentParams mergeParams(IntentParams r1, Object r2) {
            return (IntentParams) ZeusTransformUtils.wrapperContextForParams(r1, IntentParams.class, "com.obric.memorydata.plugin");
        }
    }

    String getSubActionValue();

    boolean isParamsCompleted();

    IntentParams mergeParams(Object r1);
}
