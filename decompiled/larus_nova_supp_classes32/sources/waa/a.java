package waa;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import vda.b;
import vda.c;
import vda.d;
import vda.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final StateFlowImpl a = null;
    public static final b1 b = null;
    public static final StateFlowImpl c = null;
    public static final b1 d = null;

    static {
        StateFlowImpl r0 = j1.a(com.obric.assistant.data.a.a);
        a = r0;
        b = e.b(r0);
        StateFlowImpl r1 = j1.a(Boolean.TRUE);
        c = r1;
        d = e.b(r1);
    }

    public static void a(ObricFloatChatPageState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        FLogger.a.i("ObricPageStateManager", "setState: " + r3);
        a.setValue(r3);
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof com.obric.assistant.data.a) == false) goto L5;
        return;
    L5:
        if ((r3 instanceof c) == true) goto L26;
        IInteractionStateApi r0 = IAssistantInteractionServiceKt.getAssistantInteractionServiceProxy().get_interactionStateApi();
        Intrinsics.checkNotNullParameter(r3, "pageStatus");
        if ((r3 instanceof vda.a) == false) goto L11;
        InteractionEvent.InteractionActivityExpandEvent.SmallWindowEvent r4 = InteractionEvent.InteractionActivityExpandEvent.SmallWindowEvent.INSTANCE;
    L23:
        r0.onActivityExpandStateEvent(r4);
        return;
    L11:
        if ((r3 instanceof vda.e) == false) goto L13;
    L22:
        r4 = InteractionEvent.InteractionActivityExpandEvent.NineSplitEvent.INSTANCE;
        goto L23
    L13:
        if ((r3 instanceof f) == true) goto L22;
        if ((r3 instanceof d) == false) goto L19;
        r4 = InteractionEvent.InteractionActivityExpandEvent.FullScreenEvent.INSTANCE;
        goto L23
    L19:
        if ((r3 instanceof b) == false) goto L21;
        r4 = InteractionEvent.InteractionActivityExpandEvent.InvisibleEvent.INSTANCE;
        goto L23
    L21:
        r4 = InteractionEvent.InteractionActivityExpandEvent.InvisibleEvent.INSTANCE;
        goto L23
    }
}
