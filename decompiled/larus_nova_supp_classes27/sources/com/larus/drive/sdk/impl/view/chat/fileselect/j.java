package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.service.FlowDriveSdkService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements ChatFileSelectorView.a {
    public final /* synthetic */ ChatFileSelectDialog a;

    public static final class a implements aq9.c {
        public final /* synthetic */ ChatFileSelectDialog a;

        public final List<com.larus.platform.api.u> b() {
            return this.a.l.snapshot();
        }

        public a(ChatFileSelectDialog r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.u r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.a.l.a(r3.a, IChatFileSelectionStore.Source.SELECTED_LIST);
        }
    }

    @Override // com.larus.common_ui.widget.ChatFileSelectorView.a
    public final void a() {
        FlowDriveSdkService.a.n(this.a.getParentFragmentManager(), null, new a(this.a));
    }

    public j(ChatFileSelectDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.common_ui.widget.ChatFileSelectorView.a
    public final void b(String r3) {
        ChatFileSelectDialog r0 = this.a;
        int r1 = ChatFileSelectDialog.o;
        r0.S90(r3);
    }
}
