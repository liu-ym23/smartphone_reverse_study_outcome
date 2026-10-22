package agb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.flow.bottomsheet.biz.chatwindow.ChatWindowBottomFrameFragment;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.FlowChatActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public b() {
    }

    public final void a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public final String clazz() {
        return FlowChatActivity.class.getName();
    }

    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    public final BottomSheetFrameFragment f() {
        return new ChatWindowBottomFrameFragment();
    }

    public final Integer b() {
        return 2131102061;
    }

    public final void c(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "bundle");
        int r0 = FlowChatModule.d;
        FlowChatModule.a.a().e(r3, ChatBundle.f(r4), null);
    }
}
