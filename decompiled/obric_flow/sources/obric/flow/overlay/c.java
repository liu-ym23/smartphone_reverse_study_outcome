package obric.flow.overlay;

import com.obric.flow.cardlistpage.util.d;
import com.obric.flow.cardlistpage.util.e;
import com.obric.flow.cardlistpage.util.f;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssistantOverlayService f20535a;

    public c(AssistantOverlayService r5) {
        this.f20535a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        f r11 = (f) r5;
        boolean r12 = r11 instanceof com.obric.flow.cardlistpage.util.c;
        AssistantOverlayService r13 = this.f20535a;
        if (r12 == false) goto L6;
        AssistantOverlayService.a(r13, new AssistantOverlayService$onCreate$1$1$1(null));
    L11:
        return Unit.INSTANCE;
    L6:
        if ((r11 instanceof e) == true) goto L11;
        if ((r11 instanceof d) == false) goto L11;
        AssistantOverlayService.a(r13, new AssistantOverlayService$onCreate$1$1$2(null));
        goto L11
    }
}
