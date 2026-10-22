package com.obric.assistant.chat;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017¨\u0006\f"}, d2 = {"Lcom/obric/assistant/chat/IObricChatContextService;", NameKeys.UnloadStrategy_No_Strategy, "isChatHost", NameKeys.UnloadStrategy_No_Strategy, "activity", "Landroid/app/Activity;", "isChatActivity", "getChatContext", "Lcom/larus/ui/arch/context/external/VContext;", "getCurrentChatContext", "findChatHost", "Landroidx/fragment/app/FragmentActivity;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricChatContextService {

    public static final class a {
        public static /* synthetic */ t1a.b a(ObricChatContextServiceDelegate r1) {
            return r1.b(r1.d());
        }
    }

    t1a.b a();

    t1a.b b(Activity r1);

    boolean c(Activity r1);

    FragmentActivity d();

    boolean e(Activity r1);
}
