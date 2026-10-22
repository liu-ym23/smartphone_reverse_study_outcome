package com.larus.audioplayer.impl.utils;

import com.bytedance.applet.aibridge.i;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audioplayer.api.utils.IMusicActionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J,\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/audioplayer/impl/utils/MusicActionUtilService;", "Lcom/larus/audioplayer/api/utils/IMusicActionUtil;", "<init>", "()V", "setMusicActionHandler", "", "musicActionHandler", "Lcom/larus/audioplayer/api/music/IMusicActionHandler;", "onDoraBudsEvent", "type", "", "key", "event", "onMusicKeyEvent", "musicId", "", "keyEvent", "source", "doraScene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MusicActionUtilService implements IMusicActionUtil {
    public MusicActionUtilService() {
    }

    @Override // com.larus.audioplayer.api.utils.IMusicActionUtil
    public final void a(i r3) {
        Intrinsics.checkNotNullParameter(r3, "musicActionHandler");
        a88.a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "musicActionHandler");
        a.a = r3;
    }
}
