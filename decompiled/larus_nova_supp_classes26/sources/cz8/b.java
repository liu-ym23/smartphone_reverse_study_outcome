package cz8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.ChatConstraintLayout;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements m {
    public final /* synthetic */ ChatConstraintLayout a;
    public final /* synthetic */ Fragment b;

    public final l iX() {
        return new a(this.a);
    }

    public final Fragment getChatFragment() {
        return this.b;
    }

    public b(ChatConstraintLayout r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
