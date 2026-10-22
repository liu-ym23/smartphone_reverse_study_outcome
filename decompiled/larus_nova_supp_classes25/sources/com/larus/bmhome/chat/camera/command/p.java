package com.larus.bmhome.chat.camera.command;

import com.larus.feishu.office.im.impl.base.q0;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface p {
    void G8(q0 r1);

    void a(SuggestedActionScene r1, String r2, boolean r3, String r4, Function1<? super List<SuggestedAction>, Unit> r5);

    void b(SuggestedActionScene r1, String r2, boolean r3, Function1<? super List<SuggestedAction>, Unit> r4);

    void c(String r1, iq9.e r2);

    void d(SuggestedActionData r1);

    boolean d3();

    void preload(String r1);

    List<SuggestedAction> r4(SuggestedActionScene r1, String r2, boolean r3);
}
