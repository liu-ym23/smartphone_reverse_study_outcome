package cca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockFeedbackBinding;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends com.obric.assistant.block.base.c<d> {
    public static final Set<String> f = null;
    public ObricBlockFeedbackBinding e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AssistantActivityExpandState.values().length];
            r0[AssistantActivityExpandState.FULL_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AssistantActivityExpandState.HALF_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AssistantActivityExpandState.CHAT_WINDOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AssistantActivityExpandState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        f = new LinkedHashSet();
    }

    public final void i() {
        FLogger.a.i("FeedbackBlockHolder", "onViewRecycled");
    }

    public final String k() {
        AssistantActivityExpandState r0 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "full_screen";
    L5:
        if (r1 != 2) goto L7;
        return "global_quad_screen";
    L7:
        if (r1 != 3) goto L9;
    L11:
        return "global_small_window";
    L9:
        if (r1 == 4) goto L11;
        return "unknown";
    }

    public c() {
    }

    @Override // com.obric.assistant.block.base.c
    public final void g(jc8.a r18) {
        final d r3 = (d) r18;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        super.g(r3);
        FLogger r0 = FLogger.a;
        r0.i("FeedbackBlockHolder", "onBindBlockView");
        final ObricBlockFeedbackBinding r7 = this.e;
        if (r7 != null) goto L5;
        r0.w("FeedbackBlockHolder", "binding is null");
        return;
    L5:
        BlockContent r1 = ((jc8.a) r3).a.getContent();
        if (r1 == null) goto L31;
        final OClickActionBlock r2 = r1.getOClickActionBlock();
        if (r2 == null) goto L31;
        e1.x(r7.a);
        TextView r4 = r7.b;
        String r5 = r2.content;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r4.setText(r5);
        we8.a.b(r7.b, i5.m(), false, null, null, 12);
        com.obric.assistant.feedback.d r8 = com.obric.assistant.feedback.d.a;
        String r9 = r2.clickAction;
        r8.getClass();
        final com.obric.assistant.feedback.d.b r10 = com.obric.assistant.feedback.d.d(r9);
        String[] r11 = new String[3];
        String r12 = r3.j().getMessageId();
        if (r12 != null) goto L16;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        r11[0] = r12;
        r11[1] = ((jc8.a) r3).g;
        if (r10 == null) goto L19;
        String r13 = r10.a;
    L20:
        if (r13 == null) goto L23;
        r6 = r13;
    L23:
        r11[2] = r6;
        if (f.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(r11), "#", null, null, 0, null, null, 62, null)) == false) goto L30;
        Message r14 = r3.j();
        String r15 = k();
        Intrinsics.checkNotNullParameter(r14, "message");
        if (com.obric.assistant.feedback.d.f(r10) == false) goto L30;
        o.a.reportEvent("obric_local_search_feedback_entry_show", com.obric.assistant.feedback.d.b(r14, r10, r15));
    L30:
        e1.d(r7.b, new cca.a(this, r2, r3, r10, r7));
        r7.b.setOnLongClickListener(new cca.b(this));
        return;
    L19:
        r13 = null;
    L31:
        e1.o(r7.a);
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("FeedbackBlockHolder", "onCreatedBlockView");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563937, r4, false);
        RelativeLayout r0 = (RelativeLayout) r5;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r5, 2131389991);
        if (r2 == null) goto L7;
        this.e = new ObricBlockFeedbackBinding(r0, r2);
        return r0;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131389991)));
    }
}
