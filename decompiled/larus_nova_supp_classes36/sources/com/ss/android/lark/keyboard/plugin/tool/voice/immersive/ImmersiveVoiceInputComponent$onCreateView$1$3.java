package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImmersiveVoiceInputComponent$onCreateView$1$3 extends Lambda implements Function0<Unit> {
    public static final ImmersiveVoiceInputComponent$onCreateView$1$3 INSTANCE = null;

    static {
        INSTANCE = new ImmersiveVoiceInputComponent$onCreateView$1$3();
    }

    public ImmersiveVoiceInputComponent$onCreateView$1$3() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1273invoke() {
        ImmersiveVoiceInputComponent.a r0 = ImmersiveVoiceInputComponent.a;
        Iterator<T> r1 = ImmersiveVoiceInputComponent.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((g0) r1.next()).a();
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1273invoke();
        return Unit.INSTANCE;
    }
}
