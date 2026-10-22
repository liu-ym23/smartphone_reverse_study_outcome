package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"sendRenderLog", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveComposerManagerB$showSticker$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $changeList;
    final /* synthetic */ String $reason;
    final /* synthetic */ List $removeList;
    final /* synthetic */ Ref.IntRef $renderResult;
    final /* synthetic */ StringBuilder $showStickerLog;
    final /* synthetic */ String $trace;
    final /* synthetic */ LiveComposerManagerB this$0;

    public LiveComposerManagerB$showSticker$2(LiveComposerManagerB r1, String r2, String r3, Ref.IntRef r4, List r5, List r6, StringBuilder r7) {
        this.this$0 = r1;
        this.$reason = r2;
        this.$trace = r3;
        this.$renderResult = r4;
        this.$changeList = r5;
        this.$removeList = r6;
        this.$showStickerLog = r7;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m742invoke() {
        PthreadHandlerThreadV2 r0 = LiveEffectMonitor.a;
        String r1 = this.$reason;
        String r2 = this.$trace;
        int r3 = this.$renderResult.element;
        LiveComposerManagerB r4 = this.this$0;
        int r5 = LiveComposerManagerB.H;
        r4.getClass();
        SettingKey<Boolean> r6 = LiveEffectSettings.LIVE_EFFECT_ENABLE_ZERO_VALUE_RESOURCE_OPTIMIZE;
        String r7 = "";
        if (r6.getValue().booleanValue() == false) goto L5;
        String r8 = this.$changeList.toString();
    L6:
        this.this$0.getClass();
        if (r6.getValue().booleanValue() == false) goto L9;
        r7 = this.$removeList.toString();
    L9:
        LiveEffectMonitor.n(r1, r2, r3, "", r8, r7, "normal", this.$showStickerLog.toString());
        return;
    L5:
        r8 = "";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m742invoke();
        return Unit.INSTANCE;
    }
}
