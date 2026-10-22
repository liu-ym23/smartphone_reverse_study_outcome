package com.larus.audio.ttsV2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\t"}, d2 = {"Lcom/larus/audio/ttsV2/DefaultTtsBackgroundPlayControlServiceImpl;", "Lcom/larus/audio/ttsV2/ITtsBackgroundPlayControlService;", "<init>", "()V", "allowPlayWhenAppBackground", "", "shouldStopWhenEnterBackgroundDuringPlayback", "isTtsBackgroundPlayEnabled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DefaultTtsBackgroundPlayControlServiceImpl implements ITtsBackgroundPlayControlService {

    public static final class a {
    }

    static {
    }

    public DefaultTtsBackgroundPlayControlServiceImpl() {
    }

    public static boolean c() {
        String r0 = AccountService.a.getUserId();
        f.a.getClass();
        if (f.a(r0) == true) goto L5;
        int r1 = z2.a.getTtsBackgroundPlayExperimentMode();
        if (r1 != (-1)) goto L9;
        return true;
    L9:
        if (r1 != 1) goto L12;
        return true;
    L12:
        return false;
    L5:
        return f.b(r0, false);
    }

    @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
    public final boolean a() {
        return !c();
    }

    @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
    public final boolean b() {
        return c();
    }
}
