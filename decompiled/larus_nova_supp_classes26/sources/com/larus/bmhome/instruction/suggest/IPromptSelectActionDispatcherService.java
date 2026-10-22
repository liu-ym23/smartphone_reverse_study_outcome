package com.larus.bmhome.instruction.suggest;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.bean.PromptContent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/instruction/suggest/IPromptSelectActionDispatcherService;", "", "dispatch", "", "fragment", "Landroidx/fragment/app/Fragment;", "extra", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "enterMethod", "", "scene", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPromptSelectActionDispatcherService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a(Fragment r2, PromptContent.SuggestV2ExtraForMultiAction r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "extra");
            Intrinsics.checkNotNullParameter(r4, "enterMethod");
            Intrinsics.checkNotNullParameter(r5, "scene");
            IPromptSelectActionDispatcherService r0 = (IPromptSelectActionDispatcherService) ServiceManager.get().getService(IPromptSelectActionDispatcherService.class);
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4, r5);
            return;
        }
    }

    static {
        a = a.a;
    }

    void a(Fragment r1, PromptContent.SuggestV2ExtraForMultiAction r2, String r3, String r4);
}
