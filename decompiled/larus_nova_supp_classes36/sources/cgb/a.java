package cgb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.flow.bottomsheet.biz.threadwindow.ThreadWindowFrameFragment;
import com.ss.android.lark.flow.threadwindow.FlowThreadWindowActivity;
import com.ss.android.lark.flow.threadwindow.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.bottomsheet.fragment.a.c {
    public a() {
    }

    public final void a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public final String clazz() {
        return FlowThreadWindowActivity.class.getName();
    }

    public final com.ss.android.lark.bottomsheet.fragment.a.b config() {
        return new com.ss.android.lark.bottomsheet.fragment.a.b(false);
    }

    public final BottomSheetFrameFragment f() {
        return new ThreadWindowFrameFragment();
    }

    public final Integer b() {
        return 2131102061;
    }

    public final void c(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "bundle");
        ChatBundle r5 = ChatBundle.f(r4);
        int r1 = i.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        i.b(r3, r5.l());
    }
}
