package com.larus.audioplayer.impl.news;

import b88.f;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audioplayer.api.news.IUrlAudioPlayerService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/audioplayer/impl/news/UrlAudioPlayerService;", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerService;", "<init>", "()V", "createPlayer", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayer;", "config", "Lcom/larus/audioplayer/api/news/UrlAudioPlayerConfig;", "playCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "managerCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerManagerCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UrlAudioPlayerService implements IUrlAudioPlayerService {
    public UrlAudioPlayerService() {
    }

    @Override // com.larus.audioplayer.api.news.IUrlAudioPlayerService
    public final b88.b a(f r2, b88.a r3, b88.c r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new c(r2, r3, r4);
    }
}
