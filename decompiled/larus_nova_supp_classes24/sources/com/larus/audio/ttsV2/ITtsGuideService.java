package com.larus.audio.ttsV2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J9\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00030\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\tH&¨\u0006\u0018"}, d2 = {"Lcom/larus/audio/ttsV2/ITtsGuideService;", "", "clickGuide", "", "showFrom", "", "initListener", "isTtsOpen", "Lkotlin/Function0;", "", "popupShow", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setGlobalTtsSwitch", "openTts", "removeListener", "getEarphoneFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/audio/ttsV2/EarphoneState;", "isEarphoneOpenGlobal", "toggleTtsCheck", "isEarphoneOnAndTtsCheck", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface ITtsGuideService {
    void a(String r1);

    void b(com.larus.tts.impl.t r1, com.larus.tts.impl.u r2);

    void c();

    void d();

    boolean e();

    i1<a> f();

    boolean g();

    void h(boolean r1);
}
