package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager;
import com.bytedance.android.livesdk.interactivity.textaudio.TextAudioManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/TextAudioService;", "Lcom/bytedance/android/livesdk/interactivity/api/ITextAudioService;", "()V", "getTextAudioManager", "Lcom/bytedance/android/livesdk/interactivity/api/textaudio/BaseTextAudioManager;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TextAudioService implements ITextAudioService {
    public TextAudioService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ITextAudioService
    public BaseTextAudioManager getTextAudioManager(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        return new TextAudioManager(z.e(r3, false), z.j(r3));
    }
}
