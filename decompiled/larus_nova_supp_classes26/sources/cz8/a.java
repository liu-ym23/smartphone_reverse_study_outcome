package cz8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.ChatConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import va8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements l {
    public final ChatConstraintLayout a;

    public final FrameLayout e() {
        return null;
    }

    public final RecyclerView getMessageList() {
        return null;
    }

    public final GridLayout a() {
        return (GridLayout) this.a.findViewById(2131364488);
    }

    public final View b() {
        return this.a.findViewById(2131387119);
    }

    public final View c() {
        return this.a.findViewById(2131375385);
    }

    public final FrameLayout getInput() {
        return (FrameLayout) this.a.findViewById(2131375324);
    }

    public final FrameLayout getTitleContainer() {
        return (FrameLayout) this.a.findViewById(2131377229);
    }

    public final FrameLayout z8() {
        return (FrameLayout) this.a.findViewById(2131364480);
    }

    public final ViewGroup d() {
        return this.a;
    }

    public final ConstraintLayout getRootView() {
        return this.a;
    }

    public a(ChatConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        this.a = r2;
    }
}
