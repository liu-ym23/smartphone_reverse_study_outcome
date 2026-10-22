package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.emoji_office.OfficeReactionDetailPopup;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements ReactionFlowLayout.b {
    public final /* synthetic */ y6b.c<?> a;
    public final /* synthetic */ FlowReactionBlock b;
    public final /* synthetic */ Chat c;

    public static final class a implements com.ss.android.lark.emoji_office.a {
        public final /* synthetic */ OfficeReactionDetailPopup a;
        public final /* synthetic */ FlowReactionBlock b;
        public final /* synthetic */ Chat c;

        public a(OfficeReactionDetailPopup r1, FlowReactionBlock r2, Chat r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "userId");
            Map r0 = l7b.a.a;
            l7b.a.a(this.a.getDialog());
            b0 r1 = ChatCoreModule.a().getProfileDependency();
            Context r2 = this.b.getContext();
            ProfileSource.a r3 = new ProfileSource.a();
            r3.e = r4;
            Chat r5 = this.c;
            if (r5 == null) goto L5;
            String r6 = r5.getId();
        L6:
            r3.d = r6;
            r3.b = 4;
            r1.e(r2, new ProfileSource(r3));
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public f(y6b.c<?> r1, FlowReactionBlock r2, Chat r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List r0 = this.a.u;
        ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c.d();
        List r1 = k7b.a.b(r0);
        int r2 = OfficeReactionDetailPopup.j;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "dataList");
        Intrinsics.checkNotNullParameter(r5, "selectedReactionKey");
        OfficeReactionDetailPopup r3 = new OfficeReactionDetailPopup();
        Bundle r4 = new Bundle();
        r4.putSerializable("key_data_list", new ArrayList(r1));
        r4.putString("key_selected_reaction_key", r5);
        r3.setArguments(r4);
        FlowReactionBlock r6 = this.b;
        r3.i = new a(r3, r6, this.c);
        FragmentManager r7 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r6).c.getContext().getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r7, "fragmentManager");
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "OfficeReactionDetailPopup", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r3, r8) == true) goto L13;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r3.show(r7, "OfficeReactionDetailPopup");
        return;
    }
}
