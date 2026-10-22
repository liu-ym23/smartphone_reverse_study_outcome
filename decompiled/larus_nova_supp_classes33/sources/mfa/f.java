package mfa;

import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.dialog.p0;
import com.larus.permission.api.IPermissionX;
import com.obric.assistant.permission.IObricPermissionServiceImpl$d;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements p0 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ IPermissionX.c c;

    public final void confirm() {
        this.a.element = true;
        IPermissionX.a.j(this.b, this.c);
    }

    public f(Ref.BooleanRef r1, FragmentActivity r2, IObricPermissionServiceImpl$d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
