package f39;

import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface g extends m1a.a {
    void Qe(boolean r1, @VoiceInputFrom String r2);

    StateFlowImpl getVoiceInputStatus();

    void notifyDocLoadSuccess();
}
