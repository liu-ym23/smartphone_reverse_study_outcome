package i78;

import com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.audio.ttsV2.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rw5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements g {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ a(h r1) {
        this.a = r1;
    }

    public final Object a(rw5.f r5, int r6) {
        Function2 r0 = this.a;
        int r1 = FlowTtsClientKmpManagerDelegate.d;
        Intrinsics.checkNotNullParameter(r5, "config");
        IAudioPlayerConfigFactory r2 = (IAudioPlayerConfigFactory) ServiceManager.get().getService(IAudioPlayerConfigFactory.class);
        if (r2 == null) goto L7;
        g78.a r7 = r2.a(r5.getSampleRate(), r5.getChannel(), r5.getFormat());
        if (r7 == null) goto L7;
        return r0.invoke(r7, Integer.valueOf(r6));
    L7:
        return null;
    }
}
