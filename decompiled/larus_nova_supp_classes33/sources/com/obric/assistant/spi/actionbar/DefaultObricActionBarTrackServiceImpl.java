package com.obric.assistant.spi.actionbar;

import android.view.View;
import android.widget.TextView;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.im.bean.message.ReferenceInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/actionbar/DefaultObricActionBarTrackServiceImpl;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarTrackService;", "<init>", "()V", "onObricActionBarInstructionShow", "", "tag", "Landroid/widget/TextView;", "status", "", "displayText", "", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "setObricVoiceAuthenParams", "taskId", "json", "Lorg/json/JSONObject;", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "extraMap", "", "getObricMockClickActionBarKey", "getCurrentModelLevel", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricActionBarTrackServiceImpl implements IObricActionBarTrackService {
    public DefaultObricActionBarTrackServiceImpl() {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String h() {
        return "";
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void k(TextView r1, Integer r2, String r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r4, "itemView");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void n(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String p() {
        return "";
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final ReferenceInfo r() {
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void t(AsrLifeState r1, String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "lifeState");
    }
}
