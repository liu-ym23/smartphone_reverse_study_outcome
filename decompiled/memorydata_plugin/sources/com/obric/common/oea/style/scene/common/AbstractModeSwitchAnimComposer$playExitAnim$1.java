package com.obric.common.oea.style.scene.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$playExitAnim$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final AbstractModeSwitchAnimComposer$playExitAnim$1 INSTANCE = null;

    static {
        INSTANCE = new AbstractModeSwitchAnimComposer$playExitAnim$1();
    }

    AbstractModeSwitchAnimComposer$playExitAnim$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean r3) {
        invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r1) {
    }
}
