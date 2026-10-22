package com.bytedance.android.livesdk.interactivity.common.cleanarch;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdlocation.BuildConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import n72.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u00042\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/IView;", BuildConfig.FLAVOR, "STATE", "ACTION", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IView<STATE, ACTION> extends LifecycleOwner, Observer<STATE> {
    a<STATE, ACTION> aa();
}
