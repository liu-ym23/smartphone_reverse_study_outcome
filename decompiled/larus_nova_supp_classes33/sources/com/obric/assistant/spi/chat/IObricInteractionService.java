package com.obric.assistant.spi.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.obric.ObricChatActivity;
import jga.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/spi/chat/IObricInteractionService;", "", "getOChatContainer", "", "adaptSlideBarFragmentArguments", "Landroid/os/Bundle;", "page", "", "arguments", "prepareSideBarMainChatForActivation", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "getOrionChatExtensionUtilsCallback", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricInteractionService {
    String a();

    void b(FragmentActivity r1);

    Bundle c(int r1, Bundle r2);

    a d(ObricChatActivity r1);
}
